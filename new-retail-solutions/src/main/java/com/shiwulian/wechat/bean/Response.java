package com.shiwulian.wechat.bean;

import java.util.Map;
import org.javatuples.Triplet;

import com.baidu.unbiz.fluentvalidator.ValidationError;

public class Response<T> {

    private Boolean success;
    private int code;

    private T data;

    private Object msg;

    public Response() {
        this.success = false;
        this.code = 0;
    }
    public Response(Boolean success,T data,String msg) {
    	this.success = success;
    	this.data = data;
    	this.msg = msg;
    }
    public Response(Triplet<Boolean, T, String> resp){
    	this.success = resp.getValue0();
    	this.data = resp.getValue1();
    	this.msg = resp.getValue2();
    }
    
    public Response(boolean success) {
        this.success = success;
        this.code = success ? 1 : 0;
    }

    public Response(boolean success, T data) {
        this.success = success;
        this.code = success ? 1 : 0;
        this.data = data;
    }

    public Response(boolean success, String msg) {
        this.success = success;
        this.code = success ? 1 : 0;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
        this.code = success ? 1 : 0;
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
		this.code = code;
	}

	public Response<Map<String, Object>> putAll(Map<String, Object> map) {
        Response<Map<String, Object>> res = new Response<Map<String, Object>>(true);
        res.setData(map);
        return res;
    }
	/**
	 * 用于前端 对应 testRemind  (通用vueJs方法validationError自行拷贝)
	 */
	@SuppressWarnings("unchecked")
	public void putError(ValidationError error) {
        this.data = (T)error.getField();
        this.msg = error.getErrorMsg();
    }
	
}