package com.xhhxd.retail.mapper.bs;

import com.xhhxd.retail.bean.bs.BsGoodSpec;

public interface BsGoodSpecMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_good_spec
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_good_spec
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    int insert(BsGoodSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_good_spec
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    int insertSelective(BsGoodSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_good_spec
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    BsGoodSpec selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_good_spec
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    int updateByPrimaryKeySelective(BsGoodSpec record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_good_spec
     *
     * @mbg.generated Mon Jun 04 10:10:32 CST 2018
     */
    int updateByPrimaryKey(BsGoodSpec record);
}