package com.shiwulian.wechat.bean.sys;

public class ServerType {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_server_type.id
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_server_type.server_name
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	private String serverName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_server_type.is_virtual
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	private Boolean isVirtual;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_server_type.sort
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	private Integer sort;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_server_type.valid
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	private Boolean valid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_server_type.id
	 * @return  the value of sys_server_type.id
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_server_type.id
	 * @param id  the value for sys_server_type.id
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_server_type.server_name
	 * @return  the value of sys_server_type.server_name
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_server_type.server_name
	 * @param serverName  the value for sys_server_type.server_name
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName == null ? null : serverName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_server_type.is_virtual
	 * @return  the value of sys_server_type.is_virtual
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public Boolean getIsVirtual() {
		return isVirtual;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_server_type.is_virtual
	 * @param isVirtual  the value for sys_server_type.is_virtual
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public void setIsVirtual(Boolean isVirtual) {
		this.isVirtual = isVirtual;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_server_type.sort
	 * @return  the value of sys_server_type.sort
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_server_type.sort
	 * @param sort  the value for sys_server_type.sort
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_server_type.valid
	 * @return  the value of sys_server_type.valid
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_server_type.valid
	 * @param valid  the value for sys_server_type.valid
	 * @mbg.generated  Mon Jan 08 16:22:52 CST 2018
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}