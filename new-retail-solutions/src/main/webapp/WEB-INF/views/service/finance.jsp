<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>金融服务</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<link rel="SHORTCUT ICON" href="//www.aiswl.com/favicon.ico" type="image/x-icon" />
	<link rel="ICON" href="//www.aiswl.com/favicon.ico" />
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/service/agent.css" />
</head>
	<body style="background:#efeff4">
		<input type="hidden" id="hPath" value="${pageContext.request.contextPath}"/>
		<div class="mui-content mui-row" id="finance">
			<!--应付关税融资-->
			<div class="trade">
				<p class="title">应付关税融资</p>
				<dl class="table-view">
					<dt><img src="${pageContext.request.contextPath}/images/wechat_service3.jpg"/></dt>
					<dd>委托食务链报关，食务链先行垫付进口关税，解决客户因未及时支付关税导致报关不畅及征收滞纳金等问题，缓解客户资金压力，提高企业资金周转率。放款迅速、手续简单、服务费低。</dd>
				</dl>
				<div class="imgContent"><img src="${pageContext.request.contextPath}/images/wechat_process3.png"/></div>
			</div>
			<!--货押融资-->
			<div class="clearance">
				<p class="title">货押融资</p>
				<dl class="table-view">
					<dt><img src="${pageContext.request.contextPath}/images/wechat_service4.jpg"/></dt>
					<dd>客户委托食务链代理进口，申请以货物抵押方式垫资，以保证进口顺利履行并缓解客户资金压力，保证资金周转灵活。放款迅速、手续简单、服务费低、支持分期提货。</dd>
				</dl>
				<div class="imgContent"><img src="${pageContext.request.contextPath}/images/wechat_process4.png"/></div>
			</div>
			
			<a href="${pageContext.request.contextPath}/myOrder/create" class="mui-btn mui-btn-primary mui-col-sm-12 mui-col-xs-12 noRadius">服务下单</a>
		</div>	
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
</html>
