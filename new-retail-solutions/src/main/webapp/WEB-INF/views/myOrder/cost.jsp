<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>订单费用</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
    <style>
    .mui-arrowright {color: #4481e6; }
    .mui-df {color: #fe7f32; }
    </style>
</head>
<body>
    <div id="wapper" class="refreshContainer mui-scroll-wrapper" v-cloak>
        <div class="mui-scroll">
			<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
			<input type="hidden" id="hId" value="${id}" />
            <ul class="mui-table-view" v-for="item in list">
                <li class="mui-table-view-cell">
                    <span class="mui-pull-left">{{item.serverId | renderServerType}}</span>
                    <span class="mui-pull-right mui-arrowright">{{item.receivableCnyTotal | currency ''}}</span>
                </li>
                <li class="mui-table-view-cell">
                    <div class="mui-table" v-for="sett in item.setts">
                        <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">{{sett.expenseTypeName}}<span class="mui-df" v-if="sett.isCollect">&nbsp;&nbsp;[代付]</span></span>
                            <span class="mui-pull-right">{{sett.incomeAmountCny | currency '' | renderPrice}}</span>
                        </div>
                    </div>
                </li>
           </ul>
        </div>
        <div class=mui-loading v-if="showLoading"><div class="mui-img"><img src="http://img.aiswl.com/images/loading.gif"></div></div>
    </div>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/underscore-min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/then.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/myOrder/cost.js" type="text/javascript"></script>
</body>
</html>
