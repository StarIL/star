package com.shiwulian.wechat.bean.bs;

import java.util.Date;

public class UserRole {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_user_role.id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_user_role.user_id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_user_role.role_id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	private Integer roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_user_role.create_operator
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	private String createOperator;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_user_role.create_time
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column bs_user_role.is_del
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	private Boolean isDel;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_user_role.id
	 * @return  the value of bs_user_role.id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_user_role.id
	 * @param id  the value for bs_user_role.id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_user_role.user_id
	 * @return  the value of bs_user_role.user_id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_user_role.user_id
	 * @param userId  the value for bs_user_role.user_id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_user_role.role_id
	 * @return  the value of bs_user_role.role_id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_user_role.role_id
	 * @param roleId  the value for bs_user_role.role_id
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_user_role.create_operator
	 * @return  the value of bs_user_role.create_operator
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public String getCreateOperator() {
		return createOperator;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_user_role.create_operator
	 * @param createOperator  the value for bs_user_role.create_operator
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator == null ? null : createOperator.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_user_role.create_time
	 * @return  the value of bs_user_role.create_time
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_user_role.create_time
	 * @param createTime  the value for bs_user_role.create_time
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column bs_user_role.is_del
	 * @return  the value of bs_user_role.is_del
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public Boolean getIsDel() {
		return isDel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column bs_user_role.is_del
	 * @param isDel  the value for bs_user_role.is_del
	 * @mbg.generated  Thu Oct 19 13:12:07 CST 2017
	 */
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
}