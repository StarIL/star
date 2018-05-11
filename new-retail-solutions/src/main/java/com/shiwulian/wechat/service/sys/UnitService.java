package com.shiwulian.wechat.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.sys.Unit;
import com.shiwulian.wechat.mapper.sys.UnitMapper;

@Service
public class UnitService {
	@Autowired
	private UnitMapper unitMapper;
	
	public List<Unit> selectList(){
		return unitMapper.selectList();
	}
}
