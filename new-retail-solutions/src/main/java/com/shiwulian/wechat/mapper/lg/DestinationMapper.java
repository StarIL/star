package com.shiwulian.wechat.mapper.lg;

import java.util.List;

import com.shiwulian.wechat.bean.lg.Destination;


public interface DestinationMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lg_destination
	 * @mbg.generated  Tue Oct 31 12:12:37 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lg_destination
	 * @mbg.generated  Tue Oct 31 12:12:37 CST 2017
	 */
	int insert(Destination record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lg_destination
	 * @mbg.generated  Tue Oct 31 12:12:37 CST 2017
	 */
	int insertSelective(Destination record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lg_destination
	 * @mbg.generated  Tue Oct 31 12:12:37 CST 2017
	 */
	Destination selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lg_destination
	 * @mbg.generated  Tue Oct 31 12:12:37 CST 2017
	 */
	int updateByPrimaryKeySelective(Destination record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lg_destination
	 * @mbg.generated  Tue Oct 31 12:12:37 CST 2017
	 */
	int updateByPrimaryKey(Destination record);

	/**
	 * 查询有效的门�?
	 */
	List<Destination> list();
}