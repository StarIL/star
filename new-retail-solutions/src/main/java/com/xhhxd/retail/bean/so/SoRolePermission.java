package com.xhhxd.retail.bean.so;

public class SoRolePermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column so_role_permission.id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column so_role_permission.role_id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column so_role_permission.permission_id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    private Long permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column so_role_permission.id
     *
     * @return the value of so_role_permission.id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column so_role_permission.id
     *
     * @param id the value for so_role_permission.id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column so_role_permission.role_id
     *
     * @return the value of so_role_permission.role_id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column so_role_permission.role_id
     *
     * @param roleId the value for so_role_permission.role_id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column so_role_permission.permission_id
     *
     * @return the value of so_role_permission.permission_id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column so_role_permission.permission_id
     *
     * @param permissionId the value for so_role_permission.permission_id
     *
     * @mbg.generated Mon Jun 04 10:15:41 CST 2018
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}