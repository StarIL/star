<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/mui.picker.min.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/ui-choose.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/css/myOrder/index.css" rel="stylesheet"/>
</head>
<body>
<div id="wapper" class="mui-fullscreen" v-cloak>
	<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
    <header class="mui-bar mui-bar-nav mui-slider-nav">
        <span class="mui-slider-nav-item" v-for="item in statusArr" v-on:tap="chooseTab($index,item)" v-bind:class="{'mui-active':$index == active }">{{item.name}}</span>
        <span v-on:tap="showPopover"><i class="mui-icon mui-icon-search"></i></span>
    </header>
    <!--右上角弹出菜-->
	<div id="popover" class="mui-popover">
		<div class="mui-popover-arrow"></div>
		<div class="mui-scroll-wrapper">
			<div class="mui-scroll">
				<ul class="mui-table-view">
					<li class="mui-input-row">
						<input type="text" placeholder="请输入单号" v-model="orderNo"/>
					</li>
					<li class="mui-input-row">
						<input type="text" placeholder="请输入报关单号" v-model="customsNo"/>
					</li>
					<li class="mui-input-row">
						<input type="text" placeholder="请输入运单号" v-model="billNo"/>
					</li>
					<li class="mui-input-row">
						<input type="text" class="lSelect" placeholder="请选择产品" v-on:tap="choosePro" readonly v-model="productName"/>
					</li>
					<li class="mui-input-row">
						<input type="text" class="lSelect" style="width:49%" placeholder="预到港起日" v-on:tap="chooseStartDate" readonly v-model="startArrivalTime"/><!--
						--><input type="text" class="lSelect" style="width:49%;margin-left:2%" placeholder="预到港止日" v-on:tap="chooseEndDate" readonly v-model="endArrivalTime"/>
					</li>
					<select class="ui-choose" multiple="multiple" id="selectStatus" v-model="serviceStatus">
		                 <option v-for="item in statusList" v-bind:value="item.value">{{item.text}}</option>
		            </select>
					<button type="button" class="mui-btn mui-btn-block mui-btn-primary" v-on:tap="queryOrder">查询</button>
				</ul>
			</div>
		</div>
	</div>
	<div id="refreshContainer" class="mui-content mui-scroll-wrapper">
	    <div class="mui-scroll">
	        <ul class="mui-table-view" v-for="item in pageList">
	            <li class="mui-table-view-cell">
	                <a href="${pageContext.request.contextPath}/myOrder/detail?id={{item.id}}" class="mui-navigate-right">
	                    {{item.orderCode}}
	                    <span class="mui-media-body">
	                        <img src="http://img.aiswl.com/images/a_biao1.png" class="mui-media-img" v-if="item.haveAgent" />
	                        <img src="http://img.aiswl.com/images/a_biao2.png" class="mui-media-img" v-if="item.haveLogistical" />
	                        <img src="http://img.aiswl.com/images/a_biao3.png" class="mui-media-img" v-if="item.haveFinance" />
	                    </span>
	                    <span class="mui-pull-right mui-arrowright">{{item.serviceStatus | renderStatus}}</span>
	                </a>
	            </li>
	            <li class="mui-table-view-cell mui-li-view-cell">
	                <a href="${pageContext.request.contextPath}/myOrder/detail?id={{item.id}}">
	                    <div class="mui-table">
	                        <div class="mui-media-body mui-col-xs-12">
	                            <span class="mui-pull-left mui-col-xs-8">{{item.startCountryName}}-{{item.dischargePortName}}</span>
	                            <span class="mui-pull-right">{{item.createTime | renderDate 'yy-MM-dd'}}</span>
	                        </div>
	                        <div class="mui-media-body mui-col-xs-12">
	                            <span class="mui-pull-left mui-col-xs-12 mui-ellipsis mui-left">{{item.tradeGoodsRemark | renderRemark}}</span>
	                        </div>
	                        <div class="mui-media-body mui-col-xs-12">
	                            <span class="mui-h5 mui-pull-left">预\实到港日</span>
	                            <span class="mui-pull-right">{{item.expectedArrivalTime | renderDate 'yy-MM-dd'}}\{{item.actualArrivalTime | renderDate 'yy-MM-dd'}}</span>
	                        </div>
	                    </div>
	                </a>
	            </li>
	           <%--  <li class="mui-table-view-cell" v-if="item.plans.length > 0 || item.todos.length > 0">
	                <a href="${pageContext.request.contextPath}/myOrder/detail?id={{item.id}}">
	                    <div class="mui-table">
	                        <div class="mui-media-body mui-col-xs-12" v-if="item.plans.length > 0">
	                            <p class="mui-h5 mui-pull-left">最新进度</p>
	                            <div class="mui-pull-right" v-for="plan in item.plans">
	                                <span class="mui-ellipsis mui-pull-left">{{plan.workName}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
	                                <span class="mui-pull-right">{{plan.completeTime | renderDate 'MM-dd'}}</span>
	                            </div>
	                        </div>
	                        <div class="mui-media-body mui-col-xs-12" v-if="item.todos.length > 0">
	                            <span class="mui-h5 mui-pull-left">待办事宜</span>
	                            <ul class="mui-pull-right mui-col-xs-9">
	                                <li class="mui-media-body" v-for="todo in item.todos">
	                                    <span class="mui-ellipsis mui-pull-right">{{todo.listremark}}&nbsp;&nbsp;{{todo.createTime | renderDate 'MM-dd'}}</span>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                </a>
	            </li> --%>
	        </ul>
	    </div>
	</div>
</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/then.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.picker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ui-choose.js"></script>
<script src="${pageContext.request.contextPath}/js/myOrder/index.js" type="text/javascript"></script>
</html>