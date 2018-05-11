<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>服务下单</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="SHORTCUT ICON" href="//www.aiswl.com/favicon.ico" type="image/x-icon" />
	<link rel="ICON" href="//www.aiswl.com/favicon.ico" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ui-choose.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myOrder/create.css" /> 
	<style>
	.mui-bar-tab{
    background: #007aff;
   	height: auto !important;
    width: 93%;
    bottom: 15px;
    margin: auto;}
	</style>
</head>
	<body style="background:#fff;border-top:15px solid #efeff4">
		<input type="hidden" id="hPath" value="${pageContext.request.contextPath}"/>
		<div class="mui-content-padded" id="placeOrder">
			<div class="content">
				<div class="top">
                    <ul class="ui-choose mui-col-sm-12 mui-col-xs-12" id="transList">
                        <li class="selected">冻品<p>海运</p></li>
                        <li>冻品<p>空运</p></li>
                        <li>海鲜<p>空运</p></li>
                    </ul>
				</div>
				<div class="table-view">
					<p class="title">进口代理</p>
					<ul class="ui-choose mui-col-sm-12 mui-col-xs-12" id="agentList">
                        <li class="selected">贸易代理<p>含进口清关</p></li>
                        <li class="noData">进口清关</li>
                    </ul>
				</div>
				<div class="table-view">
					<p class="title">仓储物流</p>
					<ul class="ui-choose mui-col-sm-12 mui-col-xs-12" multiple="multiple" id="storageList">
                        <li class="noData">送货</li>
                        <li class="noData" v-show="showWAgent">仓储</li>
                        <li class="noData" v-show="showWAgent">送货+仓储</li>
                    </ul>
				</div>
				<div class="table-view">
					<p class="title">金融服务</p>
					<ul class="ui-choose mui-col-sm-12 mui-col-xs-12" multiple="multiple" id="financeList">
                        <li class="noData">应付关税融资</li> 
                        <li class="noData" v-show="showfAgent">货押融资</li>
                    </ul>
				</div>
			</div>
			<nav class="mui-bar mui-bar-tab mui-btn-block  mui-btn mui-btn-primary" v-on:tap="submitJson()">
				服务下单
			</nav>
			</div>
			
		</div>	
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/ui-choose.js"></script>
	<script src="${pageContext.request.contextPath}/js/myOrder/create.js"></script>
</html>
