package com.shiwulian.wechat.service.lg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.lg.Destination;
import com.shiwulian.wechat.mapper.lg.DestinationMapper;


@Service
public class DestinationService {
	@Autowired
	private DestinationMapper destinationMapper;
	/**
	 * 所有门点
	 */
	public List<Destination> list(){
		return destinationMapper.list();
	}
	
	public Destination selectByPrimaryKey(String id){
		return destinationMapper.selectByPrimaryKey(id);
	}
}
