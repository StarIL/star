<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>我的账单</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myBill/index.css" />
	<style>
		.mui-scroll-wrapper{top: 57px;}
	</style>
</head>
<body>
	<input type="hidden" id="hPath" value="${pageContext.request.contextPath}"/>
	<div class="mui-content mui-row" id="myBill" v-cloak>
		<!--顶部导航-->
		<ul class="nav">
			<li v-for="(index,item) in navList" v-on:tap="chooseNav($index,item)" v-bind:class="{'active':$index == activeIndex }">{{item.name}}</li>
		</ul>
		<!--中间账单信息-->
		<div id="refreshContainer" class="content mui-content mui-scroll-wrapper">
			<div class="mui-scroll">
				<div class="billContent" v-for="item in queryList" v-on:tap="jumpDeail(item)">
					<ul class="title">
						<li class="mui-pull-left">{{item.billCode}}</li>
						<li class="mui-pull-right" style="color:#4481e6">{{item.status | renderStatus}}<span class="mui-icon mui-icon-arrowright"></span></li>
					</ul>
					<div class="billBox">
						<p class="mui-pull-left">账单金额</span></p>
						<p class="mui-pull-right">{{item.amount}}</p>
					</div>
					<div class="billBox">
						<p class="mui-pull-left">开票金额<span class="nameAlert" v-if="item.invoiceIscomplete">开票完成</span></p>
						<p class="mui-pull-right">{{item.invoiceAmount | currency ''}}</p>
					</div>
					<div class="billBox">
						<p class="mui-pull-left">账单日期<span class="billAlert" v-if="item.expectedDays > 0 && item.status != 3">[逾期{{item.expectedDays}}天]</span></p>
						<p class="mui-pull-right">{{item.billDate | renderDate}}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/pageCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/myBill/index.js"></script>
</html>