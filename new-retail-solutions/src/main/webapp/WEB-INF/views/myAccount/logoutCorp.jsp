<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>退出企业</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myAccount/confirmsignout.css" />
	</head>
	<!---退出注册页面-->
	<body>
		<div class="mui-content mui-row" id="confirmsignout" >
			<div class="content">
				<div class="mui-input-row" style="margin-top: 20px;">
					<input type="text"  placeholder="1801****234" class="mobileInpt mui-input-clear"/>
				</div>
				<div class="mui-input-row">
					<input type="text"  placeholder="请输入验证码" class="VerificationInpt mui-input-clear " style="width: 66%;"/>
					<button type="button"  class="mui-btn  mui-btn-primary "  style="width: 32%;height: 40px; ">发送验证码</button>
				</div>
				<div class="binding">
					<button type="button" class="mui-btn bindingbtn mui-btn-primary mui-btn-outlined mui-col-sm-12 mui-col-xs-12 btn">确认退出</button>
				</div>
			</div>			
		</div>
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/myAccount/logoutCorp.js"></script>
</html>
