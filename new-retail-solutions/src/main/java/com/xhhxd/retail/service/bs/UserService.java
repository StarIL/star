package com.xhhxd.retail.service.bs;

import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhhxd.retail.bean.bs.BsUser;
import com.xhhxd.retail.bean.request.LoginRequest;
import com.xhhxd.retail.mapper.bs.BsUserMapper;
import com.xhhxd.retail.util.RegexPatternUtil;

@Service
public class UserService {
	@Autowired
	private BsUserMapper bsUserMapper;
	

	public Triplet<Boolean, String, BsUser> login(LoginRequest request) {		
		BsUser user = null;
		if(RegexPatternUtil.isMobile(request.getUserName())){
			user = bsUserMapper.queryByMobile(request.getUserName());
		}else{
			user = bsUserMapper.queryByUsername(request.getUserName());
		}
		if (user == null) {
			return Triplet.with(Boolean.FALSE, "用户不存在", null);
		}
		if (user.getPassword().equals(request.getPassword()) == false) {
			return Triplet.with(Boolean.FALSE, "密码错误", null);
		}
		if(!user.getStatus().equals(Integer.valueOf(0))){
			return Triplet.with(Boolean.FALSE, "账号已禁用", null);
		}
		if (request.getUserTypes().contains(user.getUserType())) {
			return Triplet.with(Boolean.TRUE, null, user);
		}
		return Triplet.with(Boolean.FALSE, "用户名/密码错误", null);
	}
}
