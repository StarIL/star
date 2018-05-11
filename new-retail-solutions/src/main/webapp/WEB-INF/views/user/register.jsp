<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
    <style>
        .binding { margin-top: 30px; }
        input[type='tel']{font-size: 15px;}
        input[type='text']{font-size: 15px;}
        input[type='password']{font-size: 15px;   }
    </style>
</head>
<body style="background-color: #fff !important;">
    <div class="mui-content-padded" id="register" v-cloak>
        <input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
        <div class="content">
            <div class="mui-input-row">
                <input type="text" ex="账号" v-model="reg.userName" placeholder="请输入账号" class="mui-input-account mui-input-clear" maxlength="16" />
            </div>
            <div class="mui-input-row">
                <input type="tel" ex="手机号" v-model="reg.mobile" placeholder="请输入手机号" class="mui-input-mobile mui-input-clear" maxlength="11" />
            </div>

            <div class="mui-input-row">
                <input type="password" ex="密码" style=" padding-left: 14px;" v-model="reg.password" placeholder="请输入密码（6-18位字母与数字组合）" class="mui-input-pwd mui-input-password" maxlength="18" />
            </div>
            <div class="mui-input-row">
                <input type="password" ex="确认密码" v-model="reg.confirmPassword" placeholder="请确认密码" class="mui-input-pwd mui-input-password" maxlength="18" />
            </div>

            <div class="mui-input-row">
                <input type="text" ex="验证码" v-model="reg.verifyCode" placeholder="请输入验证码" class="mui-input-code"  maxlength="6" />
                <button type="button" style="padding: 3px;" data-loading-text="发送中" class="mui-btn mui-btn-primary mui-btn-code" v-on:tap="smsSend" v-bind:disabled="smsVerify.disabled">{{smsVerify.name}}</button>
            </div>
            <div class="binding">
                <button type="button" style="font-size: 15px;" class="mui-btn mui-btn-block mui-btn-primary" v-on:tap="sumbmit" v-bind:disabled="button.disabled">{{button.name}}</button>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/underscore-min.js"></script>
	<script src="${pageContext.request.contextPath}/js/user/register.js"></script>
</body>
</html>