package com.xhhxd.retail.bean.sys;

public class SysCity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_city.id
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_city.province_id
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    private Integer provinceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_city.city_name
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    private String cityName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_city.sort
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_city.valid
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    private Boolean valid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_city.id
     *
     * @return the value of sys_city.id
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_city.id
     *
     * @param id the value for sys_city.id
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_city.province_id
     *
     * @return the value of sys_city.province_id
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_city.province_id
     *
     * @param provinceId the value for sys_city.province_id
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_city.city_name
     *
     * @return the value of sys_city.city_name
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_city.city_name
     *
     * @param cityName the value for sys_city.city_name
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_city.sort
     *
     * @return the value of sys_city.sort
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_city.sort
     *
     * @param sort the value for sys_city.sort
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_city.valid
     *
     * @return the value of sys_city.valid
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_city.valid
     *
     * @param valid the value for sys_city.valid
     *
     * @mbg.generated Mon Jun 04 10:16:56 CST 2018
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}