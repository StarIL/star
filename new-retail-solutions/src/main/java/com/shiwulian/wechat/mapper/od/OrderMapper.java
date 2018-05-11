package com.shiwulian.wechat.mapper.od;

import java.util.List;

import com.shiwulian.wechat.bean.od.Order;
import com.shiwulian.wechat.bean.request.PagedListRequest;
import com.shiwulian.wechat.bean.response.PagedListResponse;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order
     *
     * @mbg.generated Wed Jan 03 12:27:55 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order
     *
     * @mbg.generated Wed Jan 03 12:27:55 CST 2018
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order
     *
     * @mbg.generated Wed Jan 03 12:27:55 CST 2018
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order
     *
     * @mbg.generated Wed Jan 03 12:27:55 CST 2018
     */
    Order selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order
     *
     * @mbg.generated Wed Jan 03 12:27:55 CST 2018
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table od_order
     *
     * @mbg.generated Wed Jan 03 12:27:55 CST 2018
     */
    int updateByPrimaryKey(Order record);
    
    List<PagedListResponse> pagedList(PagedListRequest request);
    
    List<Integer> selectServiceStatus(String customerId);
    
    List<String> selectByCid(String customerId);
}