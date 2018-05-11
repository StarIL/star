<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>账单详情</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myBill/detail.css" />
</head>
<body>
	<input type="hidden" id="hPath" value="${pageContext.request.contextPath}"/>
	<input type="hidden" id="hId" value="${id}" />
	<div class="mui-content mui-row" id="billDetail" v-cloak>
		<!--顶部账户信息-->
		<div class="top topContent">
			<div class="title">
				<p class="mui-pull-left">{{billCode}}</p>
				<p class="mui-pull-right">{{status | renderStatus}}</p>
			</div>
			<div class="table-view">
				<p class="mui-pull-left">账单金额</p>
				<p class="mui-pull-right">{{amount | currency ''}}</p>
			</div>
			<div class="table-view">
				<p class="mui-pull-left">开票金额<span class="billAlert" v-if="invoiceIscomplete == 'true'">开票完成</span></p>
				<p class="mui-pull-right">{{invoiceAmount | currency ''}}</p>
			</div>
			<div class="table-view">
				<p class="mui-pull-left">账单日期<span class="billAlert" v-if="expectedDays > 0">[逾期60天]</span></p>
				<p class="mui-pull-right">{{billDate | renderDate}}</p>
			</div>
		</div>
		<!--中间账户具体信息-->
		<div class="content" v-for="item in queryList">
			<div class="title">
				<p class="mui-pull-left">订单号<a href="javascript:;" class="order">{{item.orderCode}}</a></p>
				<p class="mui-pull-right">{{item.totalAmount | currency ''}}</p>
			</div>
			<div class="table-view" v-for="d in item.expenseList">
				<p class="mui-pull-left">{{d.expenseTypeName}}<span class="nameAlert" v-if="d.isCollect">[代付]</span></p>
				<p class="mui-pull-right">{{d.incomeAmountCny | currency ''}}</p>
			</div>
		</div>
		<button type="button" class="mui-btn mui-btn-primary mui-col-xs-12 mui-col-sm-12 confirmBtn" v-on:tap="confrim()" v-if="status == 1">确认账单</button>
		<div class=mui-loading v-if="showLoading"><div class="mui-img"><img src="http://img.aiswl.com/images/loading.gif"></div></div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/pageCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/myBill/detail.js"></script>
</html>