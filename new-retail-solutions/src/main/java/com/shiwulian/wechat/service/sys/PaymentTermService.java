package com.shiwulian.wechat.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.sys.PaymentTerm;
import com.shiwulian.wechat.mapper.sys.PaymentTermMapper;

@Service
public class PaymentTermService {
	@Autowired
	private PaymentTermMapper paymentTermMapper;
	
	public List<PaymentTerm> selectList(){
		return paymentTermMapper.selectList();
	}
}
