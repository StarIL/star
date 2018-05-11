package com.shiwulian.wechat.service.bs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.bs.UserOauth;
import com.shiwulian.wechat.mapper.bs.UserOauthMapper;


@Deprecated
@Service
public class UserOauthService {

	@Autowired
	private UserOauthMapper userOauthMapper;
	
	public UserOauth selectByPrimaryKey(String id){
		return userOauthMapper.selectByPrimaryKey(id);
	}
	public UserOauth selectByOpenId(String thirdParty,String openId){
		Map<String,Object> map = new HashMap<>();
		map.put("thirdParty", thirdParty);
		map.put("openId", openId);
		return userOauthMapper.selectByOpenId(map);
	}
	
	public int insertSelective(UserOauth record){
		return userOauthMapper.insertSelective(record);
	}
}
