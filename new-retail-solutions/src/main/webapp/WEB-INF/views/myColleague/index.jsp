<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>我的同事</title>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">		
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath}/css/mycolleague/index.css" rel="stylesheet" />
		
	</head>
	<body class="mui-fullscreen contenet">
		<div id="myenterprise" class="mui-page-content">
			<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
       		 <div id="views" class="mui-views">
	            <div class="mui-view">
	                <div class="mui-pages"></div>
	            </div>
        	</div>    
        	<div id="enterpriseFirst" class="mui-page">     	
           		<div class="mui-table-view  top">
           			<p class="topinfo"><span class="leftspan">李四</span><span class="mui-pull-right rightspan" >lisi001</span></p>
           		</div>
           		<p class="infolist"><spsan  class="leftinfo">手机</spsan><span class="mui-pull-right rightinfo">18011112222</span></p>
           		<p class="infolist"><spsan  class="leftinfo">邮箱</spsan><span class="mui-pull-right rightinfo">lisi@swl.com</span></p>
           		<p class="infolist"><spsan  class="leftinfo">传真</spsan><span class="mui-pull-right rightinfo">0021-2222-3333</span></p>
           		<p class="infolist"><spsan  class="leftinfo">角色</spsan><span class="mui-pull-right rightinfo">管理员、业务</span></p>
           		<div class="btn">
           			<div class="btns mui-pull-right">
           				<span class="btnlist" v-on:tap="role()"> 退出企业</span>
           				<span class="btnlist"v-on:tap="record()">分配角色</span>
           			</div>
           		</div>
        	</div>
		</div>
		<div id="modifyrecord" class="mui-popover mui-popover-bottom mui-popover-action ">
		  <div id="content">
		    <p class="toptitle">修改CIQ备案号</p>
				<p id="contentlist"><span class="leftspan">管理员</span><span class="rightspan">拥有所有操作权限</span></p>
				<p id="contentlist"><span  class="leftspan">业务</span><span class="lastspan">订单处理、账单处理等业务操作</span></p>
		     <p class="bottomplist">
			   	<span class="lastbtn"><a href="#modifyrecord">保存</a></span>
			  </p>
		    </div> 
		</div>  
		
		<div id="modifyenterprise" class="mui-popover mui-popover-bottom mui-popover-action ">
		  <div id="enterprise">
		    <p class="toptitle">退出企业</p>
				<p class="toptitle">该用户将不能访问本公司，是否继续？</p>
		   
			   	<span class="bottompbtn"><a href="#modifyenterprise">是</a></span>
			   	<span class="bottompbtn"><a href="#modifyenterprise">否</a></span>

		    </div> 
		</div>  
		
		
		<div class="binding">
			<button type="button" class="mui-btn bindingbtn mui-btn-primary mui-btn-outlined mui-col-sm-12 mui-col-xs-12 btn">加入同事</button>
		</div>
	</body>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/mycolleague/index.js"></script>
</html>
