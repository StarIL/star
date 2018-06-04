package com.xhhxd.retail.bean.bs;

import java.util.Date;

public class BsGood {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.goodname
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private String goodname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.category_id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.pic_url
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private String picUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.valid
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private Boolean valid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.team_id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private String teamId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.remark
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.create_user
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.create_time
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.upt_user
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private String uptUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.upt_time
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private Date uptTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.status
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_good.is_del
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    private Boolean isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.id
     *
     * @return the value of bs_good.id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.id
     *
     * @param id the value for bs_good.id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.goodname
     *
     * @return the value of bs_good.goodname
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public String getGoodname() {
        return goodname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.goodname
     *
     * @param goodname the value for bs_good.goodname
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.category_id
     *
     * @return the value of bs_good.category_id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.category_id
     *
     * @param categoryId the value for bs_good.category_id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.pic_url
     *
     * @return the value of bs_good.pic_url
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.pic_url
     *
     * @param picUrl the value for bs_good.pic_url
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.valid
     *
     * @return the value of bs_good.valid
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.valid
     *
     * @param valid the value for bs_good.valid
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.team_id
     *
     * @return the value of bs_good.team_id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.team_id
     *
     * @param teamId the value for bs_good.team_id
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.remark
     *
     * @return the value of bs_good.remark
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.remark
     *
     * @param remark the value for bs_good.remark
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.create_user
     *
     * @return the value of bs_good.create_user
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.create_user
     *
     * @param createUser the value for bs_good.create_user
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.create_time
     *
     * @return the value of bs_good.create_time
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.create_time
     *
     * @param createTime the value for bs_good.create_time
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.upt_user
     *
     * @return the value of bs_good.upt_user
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public String getUptUser() {
        return uptUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.upt_user
     *
     * @param uptUser the value for bs_good.upt_user
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setUptUser(String uptUser) {
        this.uptUser = uptUser == null ? null : uptUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.upt_time
     *
     * @return the value of bs_good.upt_time
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public Date getUptTime() {
        return uptTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.upt_time
     *
     * @param uptTime the value for bs_good.upt_time
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setUptTime(Date uptTime) {
        this.uptTime = uptTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.status
     *
     * @return the value of bs_good.status
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.status
     *
     * @param status the value for bs_good.status
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_good.is_del
     *
     * @return the value of bs_good.is_del
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_good.is_del
     *
     * @param isDel the value for bs_good.is_del
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}