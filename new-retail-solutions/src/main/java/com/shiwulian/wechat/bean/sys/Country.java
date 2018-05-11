package com.shiwulian.wechat.bean.sys;

public class Country {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_country.id
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_country.country_code
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	private String countryCode;
	
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_country.country_name
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	private String countryName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_country.is_china
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	private Boolean isChina;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_country.sort
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	private Integer sort;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_country.valid
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	private Boolean valid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_country.id
	 * @return  the value of sys_country.id
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_country.id
	 * @param id  the value for sys_country.id
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return countryName;
	}


	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_country.country_code
	 * @return  the value of sys_country.country_code
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_country.country_code
	 * @param countryCode  the value for sys_country.country_code
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode == null ? null : countryCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_country.country_name
	 * @return  the value of sys_country.country_name
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_country.country_name
	 * @param countryName  the value for sys_country.country_name
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName == null ? null : countryName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_country.is_china
	 * @return  the value of sys_country.is_china
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public Boolean getIsChina() {
		return isChina;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_country.is_china
	 * @param isChina  the value for sys_country.is_china
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public void setIsChina(Boolean isChina) {
		this.isChina = isChina;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_country.sort
	 * @return  the value of sys_country.sort
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_country.sort
	 * @param sort  the value for sys_country.sort
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_country.valid
	 * @return  the value of sys_country.valid
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_country.valid
	 * @param valid  the value for sys_country.valid
	 * @mbg.generated  Tue Oct 17 11:48:53 CST 2017
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}