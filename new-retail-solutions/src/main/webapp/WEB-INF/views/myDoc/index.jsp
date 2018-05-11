<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>单据文件</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
<style>
.mui-input-btn{padding:6px 26px;}
.upload{position:fixed;bottom:0;z-index:999;border-radius: 0px; margin-bottom: 0px;}	
.mui-arrowright {color: #4481e6 !important;}
.mui-upload-btn{height:44px;-webkit-box-shadow: 0 0 0;box-shadow: 0 0 0;}
 .mui-upload-btn a{border-radius:0;top: 0 !important;}
</style>
</head>
<body>
<div id="wapper" class="mui-fullscreen" v-cloak>
    <nav class="mui-bar mui-bar-tab mui-upload-btn">
    	<a href="${pageContext.request.contextPath}/myDoc/info?id=${id}" class="mui-btn mui-btn-block mui-btn-primary">上传文件</a>
    </nav>
    <div id="refreshContainer" class="mui-content mui-scroll-wrapper">
        <div class="mui-scroll">
            <input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
            <input type="hidden" id="hId" value="${id}" />
            <ul class="mui-table-view" v-for="item in docs">
                <li class="mui-table-view-cell">
                    <span class="mui-pull-left">{{item.billName}}</span>
                    <span class="mui-pull-right mui-arrowright">{{item.status | renderStatus}}</span>
                </li>
                <li class="mui-table-view-cell">
                    <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
                        <span class="mui-h5 mui-pull-left">单据编号</span>
                        <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{item.billNo}}</span>
                    </div>
                    <div class="mui-media-body">
                        <span class="mui-h5 mui-pull-left">上传人/时间</span>
                        <span class="mui-h5 mui-pull-right">{{item.uploadOperator | renderOper}}/{{item.uploadTime | renderDate 'MM-dd'}}</span>
                    </div>
                    <div class="mui-pull-right" style="padding-top:10px">
                        <button type="button" class="mui-btn mui-btn-outlined mui-input-btn delBtn" v-if="item.status == 0" v-on:tap="del(item)">删除</button>
                        <button type="button" class="mui-btn mui-btn-primary mui-btn-outlined mui-input-btn openBtn" v-on:tap="showPhoto(item)">打开</button>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/myDoc/index.js" type="text/javascript"></script>
</body>
</html>