<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>个人资料</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
</head>
<body style="background-color: #efeff4;">
<div id="wapper" class="mui-page-content">
   	<input type="hidden" id="hPath" value="${pageContext.request.contextPath}"/>
	<!-- webView start-->
	<div id="views" class="mui-views">
		<div class="mui-view">
			<div class="mui-pages"></div>
		</div>
	</div>
	<!-- webView end-->
    <div id="account" class="mui-page">
       <ul class="mui-table-view mui-table-view-chevron">
                <li class="mui-table-view-cell">
                    <a href="javascript:;" id="head" class="mui-navigate-right mui-navigate-head" v-on:tap="setting">头像
                    	<span class="mui-pull-right"><img class="mui-action-preview" v-bind:src="info.user.portrait | renderPic" v-on:error="setError($event)"/></span>
                    </a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="javascript:;">帐号<span class="mui-pull-right">{{info.user.userName}}</span></a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="#real" class="mui-navigate-right">姓名<span class="mui-pull-right">{{info.user.realName}}</span></a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="#en" class="mui-navigate-right">英文名<span class="mui-pull-right">{{info.user.englishName}}</span></a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="javascript:;" class="mui-navigate-right" v-on:tap="genderPopover">性别<span class="mui-pull-right">{{info.user.gender ? '男':'女'}}</span></a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="#birthday" class="mui-navigate-right">生日<span class="mui-pull-right">{{info.user.birthday | renderDate 'yyyy-MM-dd'}}</span></a>
                </li>
            </ul>
       <ul class="mui-table-view mui-table-view-chevron">
                <li class="mui-table-view-cell">
                    <a href="#mobile" class="mui-navigate-right">手机<span class="mui-pull-right">{{info.user.mobile}}</span></a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="#email" class="mui-navigate-right">邮箱<span class="mui-pull-right">{{info.user.email}}</span></a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="#pwd" class="mui-navigate-right">密码修改</a>
                </li>
                <li class="mui-table-view-cell">
                    <a href="#" class="mui-navigate-right" v-on:tap='enterprise'>所在企业<span class="mui-pull-right"></span></a>
                </li>
          </ul>   
         	 <!--选择企业弹框-->
           <div id="bottombox" class="mui-popover mui-popover-bottom mui-popover-action ">
			    <!-- 可选择菜单 -->
			    <ul class="mui-table-view">
			      <li class="mui-table-view-cell">
			        <a href="#">注册企业</a>
			      </li>
			      <li class="mui-table-view-cell">
			        <a href="#">退出企业</a>
			      </li>
			    </ul>
			    <!-- 取消菜单 -->
			    <ul class="mui-table-view">
			      <li class="mui-table-view-cell">
			        <a href="#bottombox"><b>取消</b></a>
			      </li>
			    </ul>
			</div>     
			<!--选择性别弹框-->
		   <div id="gender" class="mui-popover mui-popover-bottom mui-popover-action ">
			    <!-- 可选择菜单 -->
			    <ul class="mui-table-view">
			      <li class="mui-table-view-cell mui-table-view-radio">
			        <a href="#">男</a>
			      </li>
			      <li class="mui-table-view-cell">
			        <a href="#">女</a>
			      </li>
			    </ul>
			    <!-- 取消菜单 -->
			    <ul class="mui-table-view">
			      <li class="mui-table-view-cell">
			        <a href="#gender"><b>确定</b></a>
			      </li>
			    </ul>
			</div>    
    </div> 
    <div id="real" class="mui-page">
    	
    </div>
    <div id="en" class="mui-page">
    	
    </div>
    <div id="gender" class="mui-page">
    	
    </div>
    <div id="birthday" class="mui-page">
    	
    </div>
    <div id="mobile" class="mui-page">
    	
    </div>
    <div id="email" class="mui-page">
    	
    </div>
    <div id="pwd" class="mui-page">
    	
    </div>
    <div id="cus" class="mui-page">
    	
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.view.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/myAccount/info.js"></script>
</html>