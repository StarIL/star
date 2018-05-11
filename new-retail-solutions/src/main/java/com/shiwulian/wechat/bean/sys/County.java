package com.shiwulian.wechat.bean.sys;

public class County {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_county.id
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_county.province_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	private Integer provinceCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_county.city_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	private Integer cityCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_county.county_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	private Integer countyCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_county.county_name
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	private String countyName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_county.sort
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	private Integer sort;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_county.valid
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	private Boolean valid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_county.id
	 * @return  the value of sys_county.id
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_county.id
	 * @param id  the value for sys_county.id
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_county.province_code
	 * @return  the value of sys_county.province_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public Integer getProvinceCode() {
		return provinceCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_county.province_code
	 * @param provinceCode  the value for sys_county.province_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_county.city_code
	 * @return  the value of sys_county.city_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public Integer getCityCode() {
		return cityCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_county.city_code
	 * @param cityCode  the value for sys_county.city_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_county.county_code
	 * @return  the value of sys_county.county_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public Integer getCountyCode() {
		return countyCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_county.county_code
	 * @param countyCode  the value for sys_county.county_code
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public void setCountyCode(Integer countyCode) {
		this.countyCode = countyCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_county.county_name
	 * @return  the value of sys_county.county_name
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public String getCountyName() {
		return countyName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_county.county_name
	 * @param countyName  the value for sys_county.county_name
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public void setCountyName(String countyName) {
		this.countyName = countyName == null ? null : countyName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_county.sort
	 * @return  the value of sys_county.sort
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_county.sort
	 * @param sort  the value for sys_county.sort
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_county.valid
	 * @return  the value of sys_county.valid
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_county.valid
	 * @param valid  the value for sys_county.valid
	 * @mbg.generated  Wed Oct 25 11:50:48 CST 2017
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}