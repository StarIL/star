package com.shiwulian.wechat.bean.sys;

public class SequenceNumbers {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_sequencenumbers.id
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_sequencenumbers.biz_scope_name
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private String bizScopeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_sequencenumbers.sequence_number
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Long sequenceNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_sequencenumbers.id
     *
     * @return the value of sys_sequencenumbers.id
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_sequencenumbers.id
     *
     * @param id the value for sys_sequencenumbers.id
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_sequencenumbers.biz_scope_name
     *
     * @return the value of sys_sequencenumbers.biz_scope_name
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public String getBizScopeName() {
        return bizScopeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_sequencenumbers.biz_scope_name
     *
     * @param bizScopeName the value for sys_sequencenumbers.biz_scope_name
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setBizScopeName(String bizScopeName) {
        this.bizScopeName = bizScopeName == null ? null : bizScopeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_sequencenumbers.sequence_number
     *
     * @return the value of sys_sequencenumbers.sequence_number
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_sequencenumbers.sequence_number
     *
     * @param sequenceNumber the value for sys_sequencenumbers.sequence_number
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}