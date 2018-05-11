package com.shiwulian.wechat.bean.bs;

import java.util.Date;

public class PartnerUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_partner_user.id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_partner_user.partner_id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String partnerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_partner_user.user_id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_partner_user.create_operator
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String createOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_partner_user.create_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_partner_user.is_del
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private Boolean isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_partner_user.id
     *
     * @return the value of bs_partner_user.id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_partner_user.id
     *
     * @param id the value for bs_partner_user.id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_partner_user.partner_id
     *
     * @return the value of bs_partner_user.partner_id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_partner_user.partner_id
     *
     * @param partnerId the value for bs_partner_user.partner_id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_partner_user.user_id
     *
     * @return the value of bs_partner_user.user_id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_partner_user.user_id
     *
     * @param userId the value for bs_partner_user.user_id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_partner_user.create_operator
     *
     * @return the value of bs_partner_user.create_operator
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getCreateOperator() {
        return createOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_partner_user.create_operator
     *
     * @param createOperator the value for bs_partner_user.create_operator
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator == null ? null : createOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_partner_user.create_time
     *
     * @return the value of bs_partner_user.create_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_partner_user.create_time
     *
     * @param createTime the value for bs_partner_user.create_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_partner_user.is_del
     *
     * @return the value of bs_partner_user.is_del
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_partner_user.is_del
     *
     * @param isDel the value for bs_partner_user.is_del
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}