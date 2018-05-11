<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>注册企业</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
		<style type="text/css">
			.contenet{background: #fff;}
			.mui-btn-primary {background-color: #4481e6;border: 1px solid #4481e6;}
	        .mui-icon-mobile {background: url(../images/wechat_login3.png) no-repeat left; background-position: left 10px center; background-size: 20px 20px; text-indent: 20px; }
	        .mui-icon-code { background: url(../images/wechat_login4.png) no-repeat left; background-position: left 10px center;background-size: 20px 20px;text-indent: 20px;width: 66% !important;}
	        .mui-icon-enterprise {background: url(../images/wechat_icon11.png) no-repeat left; background-position: left 10px center; background-size: 16px 16px; text-indent: 20px; }       
	        .mui-btn-code { width: 32% !important; height: 40px; }
	        #enterpriseFirst{background: #ffff;}
	        #enterprise{background: #ffff;}
		</style>
	</head>
	<!--注册企业1页面-->
	<body class="mui-fullscreen contenet">
		<div id="wapper" class="mui-page-content">
			<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
       		 <div id="views" class="mui-views">
	            <div class="mui-view">
	                <div class="mui-pages"></div>
	            </div>
        	</div>
        	
        	<div id="enterpriseFirst" class="mui-page">
	            <div class="mui-content-padded">
	                <div class="mui-input-row"><input type="text" class="mui-icon-mobile  mui-input-clear" v-model="reg.mobile" placeholder="1801****234"  maxlength="11" /></div>
	                <div class="mui-input-row">
	                    <input type="text" class="mui-icon-code" v-model="reg.verifyCode" placeholder="请输入验证码" maxlength="6" />
	                    <button class="mui-btn mui-btn-primary mui-btn-code" v-on:tap="smsSend" v-bind:disabled="smsVerify.disabled" >{{smsVerify.name}}</button>
	                </div>
	                <button data-loading-text="提交中" class="mui-btn mui-btn-block mui-btn-primary" v-on:tap="smsNextSubmit()"v-bind:disabled="button.disabled">{{button.name}}</button>
	            </div>
        	</div>
        	<div id="enterprise" class="mui-page">
	            <div class="mui-content-padded">
	                <div class="mui-input-row"><input type="text" v-model="reg.password" class="mui-icon-enterprise  mui-input-clear" placeholder="请输入新密码(6-18位字母与数字组合)" /></div>
	                <button data-loading-text="提交中" class="mui-btn mui-btn-block mui-btn-primary">保存</button>
	            </div>
        	</div>
		</div>
		
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/underscore-min.js"></script>
	<script src="${pageContext.request.contextPath}/js/myAccount/enterprise.js"></script>
</html>
