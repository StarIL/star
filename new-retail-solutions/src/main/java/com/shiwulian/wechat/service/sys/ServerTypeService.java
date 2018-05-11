package com.shiwulian.wechat.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.sys.ServerType;
import com.shiwulian.wechat.mapper.sys.ServerTypeMapper;

@Service
public class ServerTypeService {

	@Autowired
	private ServerTypeMapper serverTypeMapper;
	
	public List<ServerType> selectList(List<Integer> ids){
		return serverTypeMapper.selectList(ids);
	}
}
