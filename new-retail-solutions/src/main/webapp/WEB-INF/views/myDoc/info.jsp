<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>上传文件</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/mui.picker.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" />
    <style>
    .mui-row-views {background: #fff; margin: 15px 0 0;}
    .mui-upload-bar {height: 44px;-webkit-box-shadow: 0 0 0; box-shadow: 0 0 0;}
    .mui-upload-bar .mui-upload-btn {border-radius: 0;top: 0 !important;}
    .mui-upload { padding: 14px 0 10px;position:relative}
    .mui-upload input[type=file]{opacity:0;width:120px;height:120px;position:absolute;left:35%;} 
    .mui-input-row {border-bottom: 1px solid #ddd;} 
    </style>
</head>
<body>
    <div id="wapper" class="mui-content" v-cloak>
        <input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
        <input type="hidden" id="hId" value="${id}" />
        <nav class="mui-bar mui-bar-tab  mui-upload-bar">
            <button type="button" class="mui-btn mui-btn-block mui-btn-primary mui-upload-btn" v-on:tap="save" v-bind:disabled="button.disabled">{{button.name}}</button>
        </nav>
        <div class="mui-row-views">
            <div class="mui-input-row mui-navigate-right">
                <label>类型</label>
                <input type="text" placeholder="请选择文件类型" readonly v-on:tap="billPicker" v-model="billName">
            </div>
            <div class="mui-input-row">
                <label>单据编号</label>
                <input type="text" class="mui-input-clear" placeholder="请输入单据编号" v-model="doc.billNo" maxlength="20">
            </div>
            <div class="mui-input-row">
                <label>文件</label>
                <input type="text" readonly v-model="doc.billFileName" class="mui-ellipsis mui-left">
            </div>
            <div class="mui-input-row mui-upload">
                <label class="mui-input-label">上传图片</label>
                <img src="${pageContext.request.contextPath}/images/wechat_upload.jpg" v-bind:src="doc.billFileUrl | renderImgSrc" style="width:120px;height:120px"/>
                <input type="file" accept="image/*" id="files" class="hover">
            </div>
        </div>
        <div class="loading"  v-if="showLoading" style="background:rgba(0,0,0,.075)"><div><img src="${pageContext.request.contextPath}/images/loading.gif"></div></div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.picker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/ajaxupload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/myDoc/info.js"></script>
</html>
