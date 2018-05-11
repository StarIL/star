<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>下单成功</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" /> 
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<style>
	body{background:#fff;}
	.mui-content-padded dl{margin-top:30%;text-align:center}
	.mui-content-padded dl dt{height:100px;width:100px;margin:0 auto;margin-bottom:15px}
	.mui-content-padded dl dt img{height:100%;width:100%}
	.mui-content-padded dl dd{margin-bottom:40px}
	.mui-content-padded dl dd p:first-child{color:#333;font-size:18px}
	.mui-content-padded dl dd p:last-child{font-size:16px}
	.mui-content-padded dl dd p:last-child span{margin-left:10px;color:#666}
	</style>
</head>
<body>
    <div class="mui-content-padded" id="placeSuccess">
        <dl>
            <dt><img src="${pageContext.request.contextPath}/images/wechat_success.png" /></dt>
            <dd>
                <p>您的订单下单成功</p>
                <p>订单号<span>${tp }</span></p>
            </dd>
            <a href="${pageContext.request.contextPath}/myOrder/" class="mui-btn mui-btn-block mui-btn-primary">确认</a>
        </dl>
    </div>
    <script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
</body>
</html>
