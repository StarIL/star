package com.xhhxd.retail.mapper.gd;

import com.xhhxd.retail.bean.gd.GdSaleGood;

public interface GdSaleGoodMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gd_sale_good
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gd_sale_good
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    int insert(GdSaleGood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gd_sale_good
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    int insertSelective(GdSaleGood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gd_sale_good
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    GdSaleGood selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gd_sale_good
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    int updateByPrimaryKeySelective(GdSaleGood record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gd_sale_good
     *
     * @mbg.generated Mon Jun 04 10:14:20 CST 2018
     */
    int updateByPrimaryKey(GdSaleGood record);
}