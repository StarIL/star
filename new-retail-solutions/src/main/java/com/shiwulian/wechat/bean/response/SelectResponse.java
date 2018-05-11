package com.shiwulian.wechat.bean.response;
/**
 * 方便vue 下拉框 绑定数据的实体
 */
public class SelectResponse {
	/**
	 * 下拉框value
	 */
	private Object text;
	/**
	 * 下拉框id
	 */
	private String value;
	
	public Object getText() {
		return text;
	}
	public void setText(Object text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
