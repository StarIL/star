package com.shiwulian.wechat.service.sys;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.sys.SequenceNumbers;
import com.shiwulian.wechat.mapper.sys.SequenceNumbersMapper;
import com.shiwulian.wechat.util.SysConfig;
import com.shiwulian.wechat.util.SysConfig.OddNumbersName;

@Service
public class SequenceNumbersService {
	@Autowired
	private SequenceNumbersMapper sequenceNumbersMapper;
	/**
	 * 生成单号
	 * @param startStr 单号起始字符串
	 * @param oddName 单号类型
	 * @return oddName的startValue + yyMMdd + 5位数
	 */
	public String createNo(SysConfig.OddNumbersName oddName){
		return createNo(null,oddName);
	}
	/**
	 * 生成单号
	 * @param centerStr 单号中间字符串
	 * @param oddName 单号类型
	 * @return oddName的startValue + centerStr + 5位数
	 */
	public String createNo(String centerStr,OddNumbersName oddName){
		LocalDateTime time = LocalDateTime.now();
		if(centerStr == null) centerStr = DateTimeFormatter.ofPattern("yyMM").format(time);//中间
		String endStr = "000001",//末尾
		yearMonth = DateTimeFormatter.ofPattern("yyMM").format(time),
		nameAndyyMM = oddName.getValue()+yearMonth;
		int count = sequenceNumbersMapper.countByBizScopeName(nameAndyyMM);//查询是否存在
		if (count == 0) {
			SequenceNumbers scmSequenceNumbers = new SequenceNumbers();
			scmSequenceNumbers.setSequenceNumber(1L);//第一次新增单号
			scmSequenceNumbers.setBizScopeName(nameAndyyMM);//成功录入
			sequenceNumbersMapper.insertSelective(scmSequenceNumbers);
		}else{
			String sequenceNumber = sequenceNumbersMapper.updateSequenceNumberByBiz(nameAndyyMM);//查询目前单号并加1
			DecimalFormat df = new DecimalFormat("000000");
			endStr = df.format(Integer.parseInt(sequenceNumber));//重置单号尾部
		}
		return oddName.getStartValue()+centerStr + endStr;
	}
}
