package com.shiwulian.wechat.bean.sys;

public class UserRoleSystem {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_user_role_system.id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_user_role_system.user_id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_user_role_system.system_id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    private Integer systemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_user_role_system.valid
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    private Boolean valid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_user_role_system.id
     *
     * @return the value of bs_user_role_system.id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_user_role_system.id
     *
     * @param id the value for bs_user_role_system.id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_user_role_system.user_id
     *
     * @return the value of bs_user_role_system.user_id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_user_role_system.user_id
     *
     * @param userId the value for bs_user_role_system.user_id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_user_role_system.system_id
     *
     * @return the value of bs_user_role_system.system_id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_user_role_system.system_id
     *
     * @param systemId the value for bs_user_role_system.system_id
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_user_role_system.valid
     *
     * @return the value of bs_user_role_system.valid
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_user_role_system.valid
     *
     * @param valid the value for bs_user_role_system.valid
     *
     * @mbg.generated Fri Dec 08 14:29:41 CST 2017
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}