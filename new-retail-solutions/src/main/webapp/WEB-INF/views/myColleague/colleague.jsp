<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>加入同事</title>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
		<!--<link href="${pageContext.request.contextPath}/css/mycolleague/colleague.css" rel="stylesheet" />-->
		<style type="text/css">
		 .mui-icon-mobile {background: url(../images/wechat_login3.png) no-repeat left; background-position: left 10px center; background-size: 20px 20px; text-indent: 20px; }
		 #enterpriseFirst{margin-top: 10px;    padding: 10px;}
		 .info{padding: 10px;}
		 .Symbol{font-size: 50px; margin-right: 20px;}
		 .topinfo{border-bottom: 1px solid #ccc;    padding: 6px;}
		 .footer{padding: 10px ; margin-top: 20px;}
		 #content{padding: 3px;}
		 #contentlist{display: inline-block;padding: 10px;border: 1px solid #ccc;width: 100%;}
		#contentlist .lastspan { margin-left: 10px;color: #8f8f94;}	
		 #contentlist .leftspan {color: #333; margin-right: 16px;}
		</style>
	</head>
	<body class="mui-fullscreen mui-row contenet">	
		<div id="myenterprise" class="mui-page-content">
			<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
       		 <div id="views" class="mui-views">
	            <div class="mui-view">
	                <div class="mui-pages"></div>
	            </div>
        	</div>    
        	<div id="enterpriseFirst" class="mui-page">     	
           		 <div class="mui-input-row top">
           		 	<input type="text" class="mui-icon-mobile  mui-input-clear" placeholder="1801****234" />
           		 </div>
           		 <button  class="mui-btn mui-btn-block mui-btn-primary btn" v-on:tap="next()">下一步</button>
           		 <div class="info">
           		 	<p><span class="Symbol ">.</span><span class="infolist ">如果该同事没有食物链账号，请让该同事先注册账号</span></p>	
           		 	<p><span class="Symbol">.</span><span class="infolist">如果该同事已经加入其它企业，请让该同事先退出其它企业</span></p>
           		 </div>
        	</div> 
        	
	      	 <div id="passworld" class="mui-page">
	            <div class="mui-content-padded">
	               	<div class=" top">
           				<p class="topinfo"><span class="leftspan">李四</span><span class="mui-pull-right rightspan" >lisi001</span></p>
           				<p class="topinfo"><span class="leftspan">手机</span><span class="mui-pull-right rightspan" >18322221111</span></p>
           				<p class="topinfo"><span class="leftspan">角色分配</span></p>
           			</div>
				  <div id="content">
						<p id="contentlist"><span class="leftspan">管理员</span><span class="lastspan">拥有所有操作权限</span></p>
						<p id="contentlist"><span  class="leftspan">业务</span><span class="lastspan">订单处理、账单处理等业务操作</span></p>
						<button data-loading-text="提交中" class="mui-btn mui-btn-block mui-btn-primary">加入新同事</button>
				  </div> 
                
	            </div>
        	</div>
       </div>
       
       
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/mycolleague/colleague.js"></script>
</html>
