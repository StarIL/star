<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>找回密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
    <style>
     .binding { margin-top: 30px; }
      input[type='text']{font-size: 15px;}
      input[type='password']{font-size: 15px;}
    </style>
</head>
<body class="mui-fullscreen" style="background-color: #fff !important;">
    <div id="wapper" class="mui-page-content">
        <input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
        <div id="views" class="mui-views">
            <div class="mui-view">
                <div class="mui-pages"></div>
            </div>
        </div>

        <div id="retrieveFirst" class="mui-page">
            <div class="mui-content-padded">
                <div class="mui-input-row"><input type="text" class="mui-input-mobile mui-input-clear" placeholder="请输入手机号" v-model="ret.mobile" /></div>
                <div class="mui-input-row">
                    <input type="text" class="mui-input-code" placeholder="请输入验证码" maxlength="6" v-model="ret.verifyCode" />
                    <button class="mui-btn mui-btn-primary mui-btn-code"  style="padding: 3px;" v-on:tap="smsSend" v-bind:disabled="smsVerify.disabled">{{smsVerify.name}}</button>
                </div>
                <div class="binding">
                	<button class="mui-btn mui-btn-block mui-btn-primary" style="font-size: 15px;" v-on:tap="smsNextSubmit" v-bind:disabled="button.disabled">{{button.name}}</button>
                </div>
            </div>
        </div>

        <div id="retrieveSec" class="mui-page">
            <div class="mui-content-padded">
                <div class="mui-input-row mui-password">
                    <input type="password" class="mui-icon-pwd mui-input-password" placeholder="请输入密码(6-18位字母与数字组合)" v-model="sec.password" />
                </div>
                <div class="mui-input-row mui-password">
                    <input type="password" class="mui-icon-pwd mui-input-password" placeholder="请输入密码" v-model="sec.confirmPassword" />
                </div>
                <button class="mui-btn mui-btn-block mui-btn-primary" v-on:tap="confirmSubmit" v-bind:disabled="confirm.disabled">{{confirm.name}}</button>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/user/retrievePwd.js" type="text/javascript"></script>
</body>
</html>