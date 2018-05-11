package com.shiwulian.wechat.bean.bs;

import java.util.Date;

public class Warehouse {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.province_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private Integer provinceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.province_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String provinceName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.city_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private Integer cityId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.city_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String cityName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.county_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private Integer countyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.county_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String countyName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.address
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String address;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.valid
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private Boolean valid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.create_operator
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String createOperator;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.create_time
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.upt_operator
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private String uptOperator;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.upt_time
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private Date uptTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_warehouse.is_del
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	private Boolean isDel;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.id
	 * @return  the value of bs_warehouse.id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.id
	 * @param id  the value for bs_warehouse.id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.name
	 * @return  the value of bs_warehouse.name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.name
	 * @param name  the value for bs_warehouse.name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.province_id
	 * @return  the value of bs_warehouse.province_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.province_id
	 * @param provinceId  the value for bs_warehouse.province_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.province_name
	 * @return  the value of bs_warehouse.province_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.province_name
	 * @param provinceName  the value for bs_warehouse.province_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName == null ? null : provinceName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.city_id
	 * @return  the value of bs_warehouse.city_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.city_id
	 * @param cityId  the value for bs_warehouse.city_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.city_name
	 * @return  the value of bs_warehouse.city_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.city_name
	 * @param cityName  the value for bs_warehouse.city_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.county_id
	 * @return  the value of bs_warehouse.county_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public Integer getCountyId() {
		return countyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.county_id
	 * @param countyId  the value for bs_warehouse.county_id
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.county_name
	 * @return  the value of bs_warehouse.county_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getCountyName() {
		return countyName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.county_name
	 * @param countyName  the value for bs_warehouse.county_name
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setCountyName(String countyName) {
		this.countyName = countyName == null ? null : countyName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.address
	 * @return  the value of bs_warehouse.address
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.address
	 * @param address  the value for bs_warehouse.address
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.valid
	 * @return  the value of bs_warehouse.valid
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.valid
	 * @param valid  the value for bs_warehouse.valid
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.create_operator
	 * @return  the value of bs_warehouse.create_operator
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getCreateOperator() {
		return createOperator;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.create_operator
	 * @param createOperator  the value for bs_warehouse.create_operator
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator == null ? null : createOperator.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.create_time
	 * @return  the value of bs_warehouse.create_time
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.create_time
	 * @param createTime  the value for bs_warehouse.create_time
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.upt_operator
	 * @return  the value of bs_warehouse.upt_operator
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public String getUptOperator() {
		return uptOperator;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.upt_operator
	 * @param uptOperator  the value for bs_warehouse.upt_operator
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setUptOperator(String uptOperator) {
		this.uptOperator = uptOperator == null ? null : uptOperator.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.upt_time
	 * @return  the value of bs_warehouse.upt_time
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public Date getUptTime() {
		return uptTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.upt_time
	 * @param uptTime  the value for bs_warehouse.upt_time
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setUptTime(Date uptTime) {
		this.uptTime = uptTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_warehouse.is_del
	 * @return  the value of bs_warehouse.is_del
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public Boolean getIsDel() {
		return isDel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_warehouse.is_del
	 * @param isDel  the value for bs_warehouse.is_del
	 * @mbg.generated  Mon Oct 30 18:00:48 CST 2017
	 */
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
}