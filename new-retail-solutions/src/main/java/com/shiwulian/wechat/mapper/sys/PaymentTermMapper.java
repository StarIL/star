package com.shiwulian.wechat.mapper.sys;

import java.util.List;

import com.shiwulian.wechat.bean.sys.PaymentTerm;

public interface PaymentTermMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_payment_term
     *
     * @mbg.generated Mon Jan 08 15:08:38 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_payment_term
     *
     * @mbg.generated Mon Jan 08 15:08:38 CST 2018
     */
    int insert(PaymentTerm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_payment_term
     *
     * @mbg.generated Mon Jan 08 15:08:38 CST 2018
     */
    int insertSelective(PaymentTerm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_payment_term
     *
     * @mbg.generated Mon Jan 08 15:08:38 CST 2018
     */
    PaymentTerm selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_payment_term
     *
     * @mbg.generated Mon Jan 08 15:08:38 CST 2018
     */
    int updateByPrimaryKeySelective(PaymentTerm record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_payment_term
     *
     * @mbg.generated Mon Jan 08 15:08:38 CST 2018
     */
    int updateByPrimaryKey(PaymentTerm record);
    
    List<PaymentTerm> selectList();
}