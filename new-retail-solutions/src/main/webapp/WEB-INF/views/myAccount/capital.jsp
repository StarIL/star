<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>资金流水</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<link href="${pageContext.request.contextPath}/css/mui.picker.min.css" rel="stylesheet"/>
	<!--<link href="${pageContext.request.contextPath}/css/myAccount/capital.css" rel="stylesheet"/>-->
	<style  type="text/css">
		#capitalFirst{padding: 10px;}
		.header{overflow: hidden; text-align: center;}
		.datalist{display: inline-block;padding: 4px;width: 38%;border: 1px solid #ccc; color: #999999;}
		.serch{display: inline-block;padding: 5px;width: 20%;background: #4481E6;color: #ffffff;  text-align: center; }
		.mui-data-img{vertical-align: middle;padding:0 0 0 2px;}
		#flowing{margin-top: 10px;text-align: center; }
		.leftflowing{display: inline-block;width: 32%;padding: 4px; border: 1px solid #cccccc; color: #666666;   font-size: 16px;text-align: center;}
		.current{border: 1px solid #4481E6; color: #4481E6;}
		.collect{color: #FE7F32;margin-left: 6px;font-size: 16px;}
		.content{padding: 4px;    margin-top: 10px;}
		.content .firstp{border-bottom: 1px solid #999999;}
		.leftdata{font-size: 16px;}
		.rightdata{font-size: 16px;color: #333333;}
		.payment{color: #999999;font-size: 16px;}
		.rightinfo{color: #FE7F32;font-size: 16px;}
	</style>
</head>
<body class="mui-fullscreen contenet">
 	<div id="capital" class="mui-page-content">
 		<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
       		 <div id="views" class="mui-views">
	            <div class="mui-view">
	                <div class="mui-pages"></div>
	            </div>
        	</div>    	
        	<div id="capitalFirst" class="mui-page">
        		<div class="header">
        			<span class="datalist" v-on:tap="chooseStartDate()">收支期日 <img src="http://img.aiswl.com/images/wechat_date.png" class="mui-data-img" /></span>		
        			<span class="datalist" v-on:tap="chooseEndDate()">收支止日 <img src="http://img.aiswl.com/images/wechat_date.png" class="mui-data-img" /></span>
        			<span class="serch">查询</span>
        		</div>
        		<div id="flowing">
        			<span class="leftflowing current">一个月流水</span>
        			<span class="leftflowing">三个月流水</span>
        			<span class="leftflowing">一年流水</span>
        		</div>
        		<div class="content" >
        			<p class="firstp">
        				<span class="leftdata">17-07-17</span> 
        				<span class="collect">收</span>
        				<span class="mui-pull-right rightdata">30.000.00</span>
        			</p>
        			<p>
        				<span class="payment">收/付款方</span><span class="mui-pull-right rightdata">xxxx公司</span>
        			</p>
        			<p>
        				<span class="payment">账单号</span>
        				<span class="mui-pull-right rightinfo">20170716000001</span>
        			</p>
        		</div>		
        	</div>	
 	</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.picker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/myAccount/capital.js" type="text/javascript"></script>
</html>