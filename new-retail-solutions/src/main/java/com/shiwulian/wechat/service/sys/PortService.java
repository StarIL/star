package com.shiwulian.wechat.service.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.response.SelectResponse;
import com.shiwulian.wechat.bean.sys.Port;
import com.shiwulian.wechat.mapper.sys.PortMapper;


@Service
public class PortService {
	@Autowired
	private PortMapper portMapper;
	public List<SelectResponse> selectList(){
		return portMapper.selectList(null);
	}
	/**
	 * @return 所有港口
	 */
	public List<Port> selectByMap(){
		return selectByMap(null, null, null, null, null);
	}
	/**
	 * 查询港口(条件可空)
	 * @param cityId 城市 
	 * @param customsId 默认海关ID 
	 * @param ciqId 默认商检ID
	 * @param portType 港口
	 * @param portName 名称
	 * @return
	 */
	public List<Port> selectByMap(String cityId,String customsId,String ciqId,Integer portType,String portName){
		HashMap<String,Object> map =new HashMap<>();
		return portMapper.selectByMap(map);
	}
	
	/***
	 * 条件查询所有口岸 
	 * @param valid 0:无效；1：有效
	 * @return
	 */
	public List<Port> listParams(Integer valid) {
		return portMapper.listParams(valid);
	}
	
	/***
	 * 条件查询所有口岸
	 * @param valid 0:无效；1：有效
	 * @return
	 */
	public List<Port> selectPortsByParams(Map<String, Object> params) {
		return portMapper.selectPortsByParams(params);
	}
	
}
