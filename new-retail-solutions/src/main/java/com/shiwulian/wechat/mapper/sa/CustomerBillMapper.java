package com.shiwulian.wechat.mapper.sa;

import java.util.List;
import java.util.Map;
import com.shiwulian.wechat.bean.sa.CustomerBill;

/**
 * 应收账单Mapper
 * @author ZhangSuYun
 * @date 2018-01-11
 */
public interface CustomerBillMapper {
	
    /***
     * 按主键查询应收账单
     * @param id 主键id
     * @return 应收账单信息
     */
    CustomerBill selectByPrimaryKey(String id);
    
    /***
     * 关联结算明细查询
     * @param map 查询map
     * @return 应收账单列表
     */
	List<CustomerBill> selectByMapParam(Map<String, Object> map);
	
	/***
	 * 单表条件查询
	 * @param map 查询map
	 * @return 应收账单列表
	 */
	List<CustomerBill> selectCustomerBillList(Map<String, Object> map);
	
    /***
     * 全量插入
     * @param record 应收账单实体类
     * @return 返回插入成功的记录数
     */
    int insert(CustomerBill record);

    /***
     * 条件插入
     * @param record 应收账单实体类
     * @return 返回插入成功的记录数
     */
    int insertSelective(CustomerBill record);
    
    /***
     * 全量更新
     * @param record 应收账单实体类
     * @return 返回更新成功的记录数
     */
    int updateByPrimaryKey(CustomerBill record);

    /***
     * 条件更新
     * @param record 应收账单实体类
     * @return 返回更新成功的记录数
     */
    int updateByPrimaryKeySelective(CustomerBill record);

    /***
     * 根据主键id删除应收账单
     * @param id 主键id
     * @return 返回更新成功的记录数
     */
    int deleteByPrimaryKey(String id);
	
}