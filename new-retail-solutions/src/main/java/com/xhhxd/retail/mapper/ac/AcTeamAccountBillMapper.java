package com.xhhxd.retail.mapper.ac;

import com.xhhxd.retail.bean.ac.AcTeamAccountBill;

public interface AcTeamAccountBillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ac_team_account_bill
     *
     * @mbg.generated Mon Jun 04 10:09:43 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ac_team_account_bill
     *
     * @mbg.generated Mon Jun 04 10:09:43 CST 2018
     */
    int insert(AcTeamAccountBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ac_team_account_bill
     *
     * @mbg.generated Mon Jun 04 10:09:43 CST 2018
     */
    int insertSelective(AcTeamAccountBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ac_team_account_bill
     *
     * @mbg.generated Mon Jun 04 10:09:43 CST 2018
     */
    AcTeamAccountBill selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ac_team_account_bill
     *
     * @mbg.generated Mon Jun 04 10:09:43 CST 2018
     */
    int updateByPrimaryKeySelective(AcTeamAccountBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ac_team_account_bill
     *
     * @mbg.generated Mon Jun 04 10:09:43 CST 2018
     */
    int updateByPrimaryKey(AcTeamAccountBill record);
}