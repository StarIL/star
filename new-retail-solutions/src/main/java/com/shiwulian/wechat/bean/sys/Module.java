package com.shiwulian.wechat.bean.sys;

public class Module {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.system_id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private Integer systemId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.module_name
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private String moduleName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.parent_id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private Integer parentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.icon
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private String icon;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.url
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private String url;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.perms
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private String perms;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.sort
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private Integer sort;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.remark
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_module.valid
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	private Boolean valid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.id
	 * @return  the value of sys_module.id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.id
	 * @param id  the value for sys_module.id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.system_id
	 * @return  the value of sys_module.system_id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public Integer getSystemId() {
		return systemId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.system_id
	 * @param systemId  the value for sys_module.system_id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.module_name
	 * @return  the value of sys_module.module_name
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.module_name
	 * @param moduleName  the value for sys_module.module_name
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName == null ? null : moduleName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.parent_id
	 * @return  the value of sys_module.parent_id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.parent_id
	 * @param parentId  the value for sys_module.parent_id
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.icon
	 * @return  the value of sys_module.icon
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.icon
	 * @param icon  the value for sys_module.icon
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.url
	 * @return  the value of sys_module.url
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.url
	 * @param url  the value for sys_module.url
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.perms
	 * @return  the value of sys_module.perms
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public String getPerms() {
		return perms;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.perms
	 * @param perms  the value for sys_module.perms
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setPerms(String perms) {
		this.perms = perms == null ? null : perms.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.sort
	 * @return  the value of sys_module.sort
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.sort
	 * @param sort  the value for sys_module.sort
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.remark
	 * @return  the value of sys_module.remark
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.remark
	 * @param remark  the value for sys_module.remark
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_module.valid
	 * @return  the value of sys_module.valid
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_module.valid
	 * @param valid  the value for sys_module.valid
	 * @mbg.generated  Wed Dec 20 21:34:40 CST 2017
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}