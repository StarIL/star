package com.shiwulian.wechat.mapper.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.sys.Currency;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyMapper currencyMapper;
	
	public List<Currency> selectList(){
		return currencyMapper.selectList();
	}
	
}
