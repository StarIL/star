package com.shiwulian.wechat.bean.sys;

import java.util.Date;

/***
 * 物流商pojo对象
 * @author 张苏云
 * @date 2017-11-27 13:00下午
 */
public class Logistics {
	private Integer id;// 主键id
	private String name;// 名称
	private Integer provinceId;// 省ID
	private Integer cityId;// 市ID
	private Integer countyId;// 区ID
	private String address;// 地址
	private Boolean valid;// 生效 1:生效；0：失效
	private String createOperator;
	private Date createTime;
	private String uptOperator;
	private Date uptTime;
	private Boolean isDel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCountyId() {
		return countyId;
	}
	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getCreateOperator() {
		return createOperator;
	}
	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUptOperator() {
		return uptOperator;
	}
	public void setUptOperator(String uptOperator) {
		this.uptOperator = uptOperator;
	}
	public Date getUptTime() {
		return uptTime;
	}
	public void setUptTime(Date uptTime) {
		this.uptTime = uptTime;
	}
	public Boolean getIsDel() {
		return isDel;
	}
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
}