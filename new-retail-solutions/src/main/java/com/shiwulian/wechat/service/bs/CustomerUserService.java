package com.shiwulian.wechat.service.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.bs.CustomerUser;
import com.shiwulian.wechat.mapper.bs.CustomerUserMapper;

@Service
public class CustomerUserService {
	@Autowired
	private CustomerUserMapper customerUserMapper;

	public CustomerUser selectByUid(String userId){
		return customerUserMapper.selectByUid(userId);
	}
}
