package com.shiwulian.wechat.mapper.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiwulian.wechat.bean.sys.TradeTerm;

@Service
public class TradeTermService {
	@Autowired
	private TradeTermMapper tradeTermMapper;
	
	public List<TradeTerm> selectList(){
		return tradeTermMapper.selectList();
	}
}
