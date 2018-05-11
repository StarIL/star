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
    .mui-btn {background: #007aff;margin-top: 20px;}
    .mui-content > .mui-card {padding-top: 10px;}
    .mui-input-label:first-child {margin-top:0px;}
    .mui-input-corp{padding: 0 20px 0 55px}
    .mui-input-clear{ height: 34px !important; font-size: 16px;} 
    #labels{line-height: 20px;}
     input[type='text']{font-size: 15px;}
    </style>
</head>
<body>
    <div id="wapper" class="mui-content">
    	<input type="hidden" id="t" value="${t}"/>
    	<input type="hidden" id="hPath" value="${pageContext.request.contextPath}"/>
        <div class="mui-card">
        	<div class="mui-input-row mui-radio mui-left">
				<label class="mui-input-label" style="line-height: 20px;">如果贵公司未注册，请直接注册新企业</label>
				<input name="radio1" type="radio" v-bind:value="0" v-model="radio">
			</div>
            <div class="mui-input-corp">
                <input id="registerCompName" type="text" class="mui-input-clear" placeholder="请输入企业名称" v-model="compName"/>
            </div>
        </div>
        <div class="mui-card">
        	<div class="mui-input-row mui-radio mui-left">
				<label id="labels">如果贵公司已注册，你可以让同事(管理员)帮你加入公司，这样你们同属一家公司,方便后续合作</label>
				<input name="radio1" type="radio" v-bind:value="1" v-model="radio">
			</div>
        </div>
        <div class="mui-content-padded"><button type="button" style="font-size: 15px;" class="mui-btn bindingbtn mui-btn-block mui-btn-primary" v-on:click="registerSumbmit()">确认</button></div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/underscore-min.js"></script>
<script src="${pageContext.request.contextPath}/js/user/regCorp.js"></script>
</html>