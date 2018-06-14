<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>账号绑定</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
    <style>
    .mui-head{padding: 20px;width: 80%; margin: 0 auto;  margin-bottom: 24px;}
	.mui-head-img{ width: 100%;height:100%;}
    .binding{ margin-top:60px; margin-bottom: 30px;}
    input[type='text']{font-size: 15px;}
    input[type='password']{font-size: 15px;}
    </style>
</head>
<body style="background-color: #fff !important;">
    <div id="wapper" class="mui-content-padded" v-cloak>
	    <input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
	    <div class="mui-head">
	        <img src="${pageContext.request.contextPath}/images/wechat_logo.png" class="mui-head-img" />
	    </div>
	    <div class="mui-input-row">
	        <input type="text" target="手机号" placeholder="请输入手机号" class="mui-input-clear mui-input-mobile valid" v-model="reg.mobile" maxlength="11" />
	    </div>
	    <div class="mui-input-row">
	        <input type="password" target="密码" placeholder="请输入密码" class="mui-input-password mui-input-pwd valid" v-model="reg.password" maxlength="30" />
	    </div>
	    <div class="mui-input-row">
	        <input type="text" target="密验证码" placeholder="请输入验证码" class="mui-input-code valid" v-model="reg.verifyCode" maxlength="6" />
	        <button type="button" style=" padding: 3px;" class="mui-btn mui-btn-primary mui-btn-code" v-on:tap="smsSend" v-bind:disabled="smsVerify.disabled">{{smsVerify.name}}</button>
	    </div>
	    <div class="binding">
	        <button type="button" style="font-size: 15px;" class="mui-btn mui-btn-block mui-btn-primary" v-on:tap="submit" v-bind:disabled="button.disabled">{{button.name}}</button>
	    </div>
	    <div class="mui-input-row">
	        <p class="mui-pull-left"><span class="account ">没有账号？</span> <span class="register"><a href="${pageContext.request.contextPath}/register">立即注册</a></span></p>
	        <p class="mui-pull-right"><span class="register"><a href="${pageContext.request.contextPath}/retrievePwd">忘记密码？</a></span></p>
	    </div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/login.js" type="text/javascript"></script>
</html>