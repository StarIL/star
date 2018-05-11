package com.shiwulian.wechat.bean.sys;

/***
 * 商检pojo对象
 * @author 张苏云
 * @date 2017-11-27 13:00下午
 */
public class Ciq {
    private Integer id;//主键id
    private String ciqCode;//代码
    private String ciqName;//名称
    private Integer cityId;//市ID
    private Integer sort;//顺序
    private Boolean valid;//生效 1:生效；0：失效
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCiqCode() {
		return ciqCode;
	}
	public void setCiqCode(String ciqCode) {
		this.ciqCode = ciqCode;
	}
	public String getCiqName() {
		return ciqName;
	}
	public void setCiqName(String ciqName) {
		this.ciqName = ciqName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}