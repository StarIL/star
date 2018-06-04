package com.xhhxd.retail.bean.gd;

import java.math.BigDecimal;
import java.util.Date;

public class GdGoodStorage {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gd_good_storage.id
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gd_good_storage.good_id
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    private String goodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gd_good_storage.amount
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    private BigDecimal amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gd_good_storage.valid
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    private Boolean valid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gd_good_storage.is_del
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    private Boolean isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gd_good_storage.upt_user
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    private String uptUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gd_good_storage.upt_time
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    private Date uptTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gd_good_storage.id
     *
     * @return the value of gd_good_storage.id
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gd_good_storage.id
     *
     * @param id the value for gd_good_storage.id
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gd_good_storage.good_id
     *
     * @return the value of gd_good_storage.good_id
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gd_good_storage.good_id
     *
     * @param goodId the value for gd_good_storage.good_id
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gd_good_storage.amount
     *
     * @return the value of gd_good_storage.amount
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gd_good_storage.amount
     *
     * @param amount the value for gd_good_storage.amount
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gd_good_storage.valid
     *
     * @return the value of gd_good_storage.valid
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gd_good_storage.valid
     *
     * @param valid the value for gd_good_storage.valid
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gd_good_storage.is_del
     *
     * @return the value of gd_good_storage.is_del
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gd_good_storage.is_del
     *
     * @param isDel the value for gd_good_storage.is_del
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gd_good_storage.upt_user
     *
     * @return the value of gd_good_storage.upt_user
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public String getUptUser() {
        return uptUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gd_good_storage.upt_user
     *
     * @param uptUser the value for gd_good_storage.upt_user
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public void setUptUser(String uptUser) {
        this.uptUser = uptUser == null ? null : uptUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gd_good_storage.upt_time
     *
     * @return the value of gd_good_storage.upt_time
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public Date getUptTime() {
        return uptTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gd_good_storage.upt_time
     *
     * @param uptTime the value for gd_good_storage.upt_time
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    public void setUptTime(Date uptTime) {
        this.uptTime = uptTime;
    }
}