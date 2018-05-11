package com.shiwulian.wechat.mapper.sys;

import java.util.List;

import com.shiwulian.wechat.bean.response.WorkTypeResponse;
import com.shiwulian.wechat.bean.sys.WorkType;


public interface WorkTypeMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_worktype
	 * @mbg.generated  Tue Nov 21 11:08:24 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_worktype
	 * @mbg.generated  Tue Nov 21 11:08:24 CST 2017
	 */
	int insert(WorkType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_worktype
	 * @mbg.generated  Tue Nov 21 11:08:24 CST 2017
	 */
	int insertSelective(WorkType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_worktype
	 * @mbg.generated  Tue Nov 21 11:08:24 CST 2017
	 */
	WorkType selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_worktype
	 * @mbg.generated  Tue Nov 21 11:08:24 CST 2017
	 */
	int updateByPrimaryKeySelective(WorkType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_worktype
	 * @mbg.generated  Tue Nov 21 11:08:24 CST 2017
	 */
	int updateByPrimaryKey(WorkType record);

	/**
     * serverId查询
     * 返回serverId + serverName + WorkType
     * @author liXin
     */
    List<WorkTypeResponse> selectByServerIds(List<Integer> ids);
    
    List<WorkType> selectByIds(List<Integer> ids);
}