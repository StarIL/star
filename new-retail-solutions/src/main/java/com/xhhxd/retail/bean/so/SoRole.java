package com.xhhxd.retail.bean.so;

public class SoRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column so_role.id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column so_role.role_name
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column so_role.role_sign
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    private String roleSign;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column so_role.description
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column so_role.id
     *
     * @return the value of so_role.id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column so_role.id
     *
     * @param id the value for so_role.id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column so_role.role_name
     *
     * @return the value of so_role.role_name
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column so_role.role_name
     *
     * @param roleName the value for so_role.role_name
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column so_role.role_sign
     *
     * @return the value of so_role.role_sign
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public String getRoleSign() {
        return roleSign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column so_role.role_sign
     *
     * @param roleSign the value for so_role.role_sign
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign == null ? null : roleSign.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column so_role.description
     *
     * @return the value of so_role.description
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column so_role.description
     *
     * @param description the value for so_role.description
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}