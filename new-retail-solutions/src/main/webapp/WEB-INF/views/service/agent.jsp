<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>进口代理</title>
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
		<div class="mui-content mui-row" id="agent">
			<!--贸易代理-->
			<div class="trade">
				<p class="title">贸易代理</p>
				<dl class="table-view">
					<dt><img src="${pageContext.request.contextPath}/images/wechat_service1.jpg"/></dt>
					<dd>食务链专注于食材领域多年，业务涉及肉类、水产品、活鲜、冻品等食材。为客户提供专业优质的代采、代理、报关、仓储、物流、金融等一站式供应链服务，服务范围覆盖全国各大城市。经过多年市场的深耕，食务链已获得超过3000+客户的信赖。</dd>
				</dl>
				<div class="imgContent"><img src="${pageContext.request.contextPath}/images/wechat_process1.png"/></div>
			</div>
			<!--进口清关-->
			<div class="clearance">
				<p class="title">进口清关</p>
				<dl class="table-view">
					<dt><img src="${pageContext.request.contextPath}/images/wechat_service2.jpg"/></dt>
					<dd>通关专业、高效、安全、便利。活鲜4小时通关，冻品48小时内通关。上海、天津、深圳、广州等港口机场全天候驻扎专业人员，服务范围覆盖全国各大城市。</dd>
				</dl>
				<div class="imgContent"><img src="${pageContext.request.contextPath}/images/wechat_process2.png"/></div>
			</div>
			
			<a href="${pageContext.request.contextPath}/myOrder/create" class="mui-btn mui-btn-primary mui-col-sm-12 mui-col-xs-12 noRadius">服务下单</a>
		</div>	
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
</html>
