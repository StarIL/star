package com.shiwulian.wechat.bean.response;

import java.util.List;

import com.shiwulian.wechat.bean.bs.Warehouse;


public class WarehouseResponse {
	private String cityName;
	private String text;
    private Integer cityId;

	/**
	 * 仓库名
	 */
	private List<Warehouse> names;


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public List<Warehouse> getNames() {
		return names;
	}

	public void setNames(List<Warehouse> names) {
		this.names = names;
	}
    
	
}
