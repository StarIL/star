package com.xhhxd.retail.bean.bs;

import java.util.Date;

public class BsTeam {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.cn_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String cnName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.portrait
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String portrait;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.province_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Integer provinceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.province_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String provinceName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.city_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Integer cityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.city_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String cityName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.county_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Integer countyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.county_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String countyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.cn_address
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String cnAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.phone
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.mobile
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.approve_status
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Boolean approveStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.approve_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Date approveTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.license_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String licenseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.license_url
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String licenseUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.user_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.is_sys
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Boolean isSys;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.reg_date
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Date regDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.valid_month
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Integer validMonth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.valid_month_surplus
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Integer validMonthSurplus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.valid
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Integer valid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.create_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.last_login_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Date lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_team.is_del
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    private Boolean isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.id
     *
     * @return the value of bs_team.id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.id
     *
     * @param id the value for bs_team.id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.cn_name
     *
     * @return the value of bs_team.cn_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.cn_name
     *
     * @param cnName the value for bs_team.cn_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.portrait
     *
     * @return the value of bs_team.portrait
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.portrait
     *
     * @param portrait the value for bs_team.portrait
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.province_id
     *
     * @return the value of bs_team.province_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.province_id
     *
     * @param provinceId the value for bs_team.province_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.province_name
     *
     * @return the value of bs_team.province_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.province_name
     *
     * @param provinceName the value for bs_team.province_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.city_id
     *
     * @return the value of bs_team.city_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.city_id
     *
     * @param cityId the value for bs_team.city_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.city_name
     *
     * @return the value of bs_team.city_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.city_name
     *
     * @param cityName the value for bs_team.city_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.county_id
     *
     * @return the value of bs_team.county_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Integer getCountyId() {
        return countyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.county_id
     *
     * @param countyId the value for bs_team.county_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.county_name
     *
     * @return the value of bs_team.county_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.county_name
     *
     * @param countyName the value for bs_team.county_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.cn_address
     *
     * @return the value of bs_team.cn_address
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getCnAddress() {
        return cnAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.cn_address
     *
     * @param cnAddress the value for bs_team.cn_address
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setCnAddress(String cnAddress) {
        this.cnAddress = cnAddress == null ? null : cnAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.phone
     *
     * @return the value of bs_team.phone
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.phone
     *
     * @param phone the value for bs_team.phone
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.mobile
     *
     * @return the value of bs_team.mobile
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.mobile
     *
     * @param mobile the value for bs_team.mobile
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.approve_status
     *
     * @return the value of bs_team.approve_status
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Boolean getApproveStatus() {
        return approveStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.approve_status
     *
     * @param approveStatus the value for bs_team.approve_status
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setApproveStatus(Boolean approveStatus) {
        this.approveStatus = approveStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.approve_time
     *
     * @return the value of bs_team.approve_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Date getApproveTime() {
        return approveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.approve_time
     *
     * @param approveTime the value for bs_team.approve_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.license_name
     *
     * @return the value of bs_team.license_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getLicenseName() {
        return licenseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.license_name
     *
     * @param licenseName the value for bs_team.license_name
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName == null ? null : licenseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.license_url
     *
     * @return the value of bs_team.license_url
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getLicenseUrl() {
        return licenseUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.license_url
     *
     * @param licenseUrl the value for bs_team.license_url
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl == null ? null : licenseUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.user_id
     *
     * @return the value of bs_team.user_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.user_id
     *
     * @param userId the value for bs_team.user_id
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.is_sys
     *
     * @return the value of bs_team.is_sys
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Boolean getIsSys() {
        return isSys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.is_sys
     *
     * @param isSys the value for bs_team.is_sys
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setIsSys(Boolean isSys) {
        this.isSys = isSys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.reg_date
     *
     * @return the value of bs_team.reg_date
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.reg_date
     *
     * @param regDate the value for bs_team.reg_date
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.valid_month
     *
     * @return the value of bs_team.valid_month
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Integer getValidMonth() {
        return validMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.valid_month
     *
     * @param validMonth the value for bs_team.valid_month
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setValidMonth(Integer validMonth) {
        this.validMonth = validMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.valid_month_surplus
     *
     * @return the value of bs_team.valid_month_surplus
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Integer getValidMonthSurplus() {
        return validMonthSurplus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.valid_month_surplus
     *
     * @param validMonthSurplus the value for bs_team.valid_month_surplus
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setValidMonthSurplus(Integer validMonthSurplus) {
        this.validMonthSurplus = validMonthSurplus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.valid
     *
     * @return the value of bs_team.valid
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.valid
     *
     * @param valid the value for bs_team.valid
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.create_time
     *
     * @return the value of bs_team.create_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.create_time
     *
     * @param createTime the value for bs_team.create_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.last_login_time
     *
     * @return the value of bs_team.last_login_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.last_login_time
     *
     * @param lastLoginTime the value for bs_team.last_login_time
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_team.is_del
     *
     * @return the value of bs_team.is_del
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_team.is_del
     *
     * @param isDel the value for bs_team.is_del
     *
     * @mbg.generated Mon Jun 04 10:11:48 CST 2018
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}