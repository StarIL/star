package com.shiwulian.wechat.bean.sys;

public class BillType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.id
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.bill_name
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private String billName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.is_sea_agent
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Boolean isSeaAgent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.is_sea_eclare
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Boolean isSeaEclare;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.is_air_agent
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Boolean isAirAgent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.is_air_eclare
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Boolean isAirEclare;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.is_show
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Boolean isShow;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.sort
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_billtype.valid
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    private Boolean valid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.id
     *
     * @return the value of sys_billtype.id
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.id
     *
     * @param id the value for sys_billtype.id
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.bill_name
     *
     * @return the value of sys_billtype.bill_name
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public String getBillName() {
        return billName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.bill_name
     *
     * @param billName the value for sys_billtype.bill_name
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.is_sea_agent
     *
     * @return the value of sys_billtype.is_sea_agent
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Boolean getIsSeaAgent() {
        return isSeaAgent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.is_sea_agent
     *
     * @param isSeaAgent the value for sys_billtype.is_sea_agent
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setIsSeaAgent(Boolean isSeaAgent) {
        this.isSeaAgent = isSeaAgent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.is_sea_eclare
     *
     * @return the value of sys_billtype.is_sea_eclare
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Boolean getIsSeaEclare() {
        return isSeaEclare;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.is_sea_eclare
     *
     * @param isSeaEclare the value for sys_billtype.is_sea_eclare
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setIsSeaEclare(Boolean isSeaEclare) {
        this.isSeaEclare = isSeaEclare;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.is_air_agent
     *
     * @return the value of sys_billtype.is_air_agent
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Boolean getIsAirAgent() {
        return isAirAgent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.is_air_agent
     *
     * @param isAirAgent the value for sys_billtype.is_air_agent
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setIsAirAgent(Boolean isAirAgent) {
        this.isAirAgent = isAirAgent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.is_air_eclare
     *
     * @return the value of sys_billtype.is_air_eclare
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Boolean getIsAirEclare() {
        return isAirEclare;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.is_air_eclare
     *
     * @param isAirEclare the value for sys_billtype.is_air_eclare
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setIsAirEclare(Boolean isAirEclare) {
        this.isAirEclare = isAirEclare;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.is_show
     *
     * @return the value of sys_billtype.is_show
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.is_show
     *
     * @param isShow the value for sys_billtype.is_show
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.sort
     *
     * @return the value of sys_billtype.sort
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.sort
     *
     * @param sort the value for sys_billtype.sort
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_billtype.valid
     *
     * @return the value of sys_billtype.valid
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_billtype.valid
     *
     * @param valid the value for sys_billtype.valid
     *
     * @mbg.generated Tue Oct 10 10:44:33 CST 2017
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}