<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>专属客服</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<style type="text/css">
		body{background: #fff;}
		#exclusive{background: #fff;}
		.rightimg{background-position: left center; background-size: 100%;text-indent: 20px;height: 65px;	width: 65px; margin-right:15px;}
		.portrait{line-height: 65px;}
		.wechartimg{width: 140px;  height: 140px; margin: 0 auto;background-size: 100%; margin-top: 20px;}
		.mui-table-view-chevron .content{padding-right: 18px;}
	</style>
</head>
<body>
	<div id="exclusive" v-cloak>
		<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
		<ul class="mui-table-view mui-table-view-chevron">
            <li class="mui-table-view-cell content">
                <p><span class="portrait">头像</span> <span class="mui-pull-right rightimg" ><img v-bind:src="userInfo.user.portrait | portrait"/></span></p>
            </li>        
            <li class="mui-table-view-cell content">
                <p>姓名<span class="mui-pull-right">{{userInfo.operator.realName}}</span></p>
            </li>
            <li class="mui-table-view-cell content">
             	<p>公司<span class="mui-pull-right">{{userInfo.partner.partnerName}}</span></p>
            </li>
            <li class="mui-table-view-cell content">
              	<p>手机<span class="mui-pull-right">{{userInfo.operator.mobile}}</span></p>	
            </li>
            <li class="mui-table-view-cell content">
               <p>邮箱<span class="mui-pull-right">{{userInfo.operator.email}}</span></p>
            </li>
            <li class="mui-table-view-cell content">
               <p>客服<span class="mui-pull-right">400-888-7898</span></p>
            </li>
   	    </ul> 
   	    <div class="wechartimg">
   	    	<img v-bind:src="userInfo.operator.weixinCode| portrait140"/>
   	    </div>
   	    <div class="texlisit" style="text-align: center; color: #666; margin-top:10px; font-size: 16px;">
   	    	<p id='textliest'>长按二维码添加我微信</p>
   	    </div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/myAccount/exclusive.js"></script>
</html>