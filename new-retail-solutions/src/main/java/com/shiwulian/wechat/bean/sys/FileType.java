package com.shiwulian.wechat.bean.sys;

public class FileType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_type.id
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_type.file_type
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    private String fileType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_type.sort
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_file_type.valid
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    private Boolean valid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_type.id
     *
     * @return the value of sys_file_type.id
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_type.id
     *
     * @param id the value for sys_file_type.id
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_type.file_type
     *
     * @return the value of sys_file_type.file_type
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_type.file_type
     *
     * @param fileType the value for sys_file_type.file_type
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_type.sort
     *
     * @return the value of sys_file_type.sort
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_type.sort
     *
     * @param sort the value for sys_file_type.sort
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_file_type.valid
     *
     * @return the value of sys_file_type.valid
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_file_type.valid
     *
     * @param valid the value for sys_file_type.valid
     *
     * @mbg.generated Wed Jan 03 13:35:44 CST 2018
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}