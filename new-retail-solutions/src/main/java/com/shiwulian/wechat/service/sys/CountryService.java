package com.shiwulian.wechat.service.sys;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiwulian.wechat.bean.sys.Country;
import com.shiwulian.wechat.mapper.sys.CountryMapper;


@Service
public class CountryService {
	@Autowired
	private CountryMapper countryMapper;

	/**
	 * 查询国家
	 * @param isChina 是否中国
	 */
	public List<Country> queryByKeyWord(Boolean isChina){
		return queryByKeyWord(isChina,null);
	}
	/**
	 * 查询国家
	 * @param isChina 是否中国 可空
	 * @param countryName 模糊查询 可空
	 */
	public List<Country> queryByKeyWord(Boolean isChina,String countryName){
		HashMap<String, Object> map = new HashMap<>();
		if(isChina != null){
			map.put("isChina", isChina);
		}
		if(countryName != null){
			map.put("countryName", countryName);
		}
		return countryMapper.selectByMap(map);
	}
	
	/***
	 * 条件查询所有国家 
	 * @param valid 0:无效；1：有效
	 * @return
	 */
	public List<Country> listParams(@Param("valid") Integer valid) {
		return countryMapper.listParams(valid);
	}
}
