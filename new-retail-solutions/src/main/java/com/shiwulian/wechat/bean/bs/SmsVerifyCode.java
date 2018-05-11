package com.shiwulian.wechat.bean.bs;

import java.util.Date;

public class SmsVerifyCode {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sms_verify_code.id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sms_verify_code.business_scope
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String businessScope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sms_verify_code.receiver
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sms_verify_code.code
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sms_verify_code.verified
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private Boolean verified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sms_verify_code.send_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private Date sendTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sms_verify_code.verify_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    private Date verifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sms_verify_code.id
     *
     * @return the value of bs_sms_verify_code.id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sms_verify_code.id
     *
     * @param id the value for bs_sms_verify_code.id
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sms_verify_code.business_scope
     *
     * @return the value of bs_sms_verify_code.business_scope
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sms_verify_code.business_scope
     *
     * @param businessScope the value for bs_sms_verify_code.business_scope
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sms_verify_code.receiver
     *
     * @return the value of bs_sms_verify_code.receiver
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sms_verify_code.receiver
     *
     * @param receiver the value for bs_sms_verify_code.receiver
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sms_verify_code.code
     *
     * @return the value of bs_sms_verify_code.code
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sms_verify_code.code
     *
     * @param code the value for bs_sms_verify_code.code
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sms_verify_code.verified
     *
     * @return the value of bs_sms_verify_code.verified
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sms_verify_code.verified
     *
     * @param verified the value for bs_sms_verify_code.verified
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sms_verify_code.send_time
     *
     * @return the value of bs_sms_verify_code.send_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sms_verify_code.send_time
     *
     * @param sendTime the value for bs_sms_verify_code.send_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sms_verify_code.verify_time
     *
     * @return the value of bs_sms_verify_code.verify_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public Date getVerifyTime() {
        return verifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sms_verify_code.verify_time
     *
     * @param verifyTime the value for bs_sms_verify_code.verify_time
     *
     * @mbg.generated Tue Oct 10 10:49:00 CST 2017
     */
    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }
}