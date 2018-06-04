package com.xhhxd.retail.bean.request;

import java.util.Arrays;
import java.util.List;

public class LoginRequest {
	private String userName;

	private String password;

	private Boolean isRecordPwd = false;

	private String jump = "/";

	private List<Integer> userTypes;

	public LoginRequest() {
	}

	public LoginRequest(String userName, String password, Boolean isRecordPwd, Integer... userTypes) {
		this.userName = userName;
		this.password = password;
		this.isRecordPwd = isRecordPwd;
		this.userTypes = Arrays.asList(userTypes);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsRecordPwd() {
		return isRecordPwd;
	}

	public void setIsRecordPwd(Boolean isRecordPwd) {
		this.isRecordPwd = isRecordPwd;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public List<Integer> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<Integer> userTypes) {
		this.userTypes = userTypes;
	}

	public void putUserTypes(Integer... userTypes) {
		this.userTypes = Arrays.asList(userTypes);
	}
}