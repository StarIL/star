package com.shiwulian.wechat.mapper.fn;

import java.util.List;

import com.shiwulian.wechat.bean.fn.ExpenseType;

public interface ExpenseTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fn_expense_type
     *
     * @mbg.generated Fri Jan 12 18:39:13 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fn_expense_type
     *
     * @mbg.generated Fri Jan 12 18:39:13 CST 2018
     */
    int insert(ExpenseType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fn_expense_type
     *
     * @mbg.generated Fri Jan 12 18:39:13 CST 2018
     */
    int insertSelective(ExpenseType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fn_expense_type
     *
     * @mbg.generated Fri Jan 12 18:39:13 CST 2018
     */
    ExpenseType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fn_expense_type
     *
     * @mbg.generated Fri Jan 12 18:39:13 CST 2018
     */
    int updateByPrimaryKeySelective(ExpenseType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fn_expense_type
     *
     * @mbg.generated Fri Jan 12 18:39:13 CST 2018
     */
    int updateByPrimaryKey(ExpenseType record);
    
    List<ExpenseType> selectByIds(List<String> ids);
}