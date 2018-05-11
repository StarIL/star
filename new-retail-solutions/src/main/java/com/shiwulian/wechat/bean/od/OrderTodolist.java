package com.shiwulian.wechat.bean.od;

import java.util.Date;

public class OrderTodolist {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column od_order_todolist.id
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column od_order_todolist.order_id
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    private String orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column od_order_todolist.listremark
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    private String listremark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column od_order_todolist.is_complete
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    private Boolean isComplete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column od_order_todolist.create_operator
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    private String createOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column od_order_todolist.create_time
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column od_order_todolist.is_del
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    private Boolean isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column od_order_todolist.id
     *
     * @return the value of od_order_todolist.id
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column od_order_todolist.id
     *
     * @param id the value for od_order_todolist.id
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column od_order_todolist.order_id
     *
     * @return the value of od_order_todolist.order_id
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column od_order_todolist.order_id
     *
     * @param orderId the value for od_order_todolist.order_id
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column od_order_todolist.listremark
     *
     * @return the value of od_order_todolist.listremark
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public String getListremark() {
        return listremark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column od_order_todolist.listremark
     *
     * @param listremark the value for od_order_todolist.listremark
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public void setListremark(String listremark) {
        this.listremark = listremark == null ? null : listremark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column od_order_todolist.is_complete
     *
     * @return the value of od_order_todolist.is_complete
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public Boolean getIsComplete() {
        return isComplete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column od_order_todolist.is_complete
     *
     * @param isComplete the value for od_order_todolist.is_complete
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column od_order_todolist.create_operator
     *
     * @return the value of od_order_todolist.create_operator
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public String getCreateOperator() {
        return createOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column od_order_todolist.create_operator
     *
     * @param createOperator the value for od_order_todolist.create_operator
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator == null ? null : createOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column od_order_todolist.create_time
     *
     * @return the value of od_order_todolist.create_time
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column od_order_todolist.create_time
     *
     * @param createTime the value for od_order_todolist.create_time
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column od_order_todolist.is_del
     *
     * @return the value of od_order_todolist.is_del
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column od_order_todolist.is_del
     *
     * @param isDel the value for od_order_todolist.is_del
     *
     * @mbg.generated Wed Jan 03 12:51:36 CST 2018
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}