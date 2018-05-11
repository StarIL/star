<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>资料完善</title>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" /> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mui.picker.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
    <style>
        .mui-btn-nav { position: absolute;bottom: 0px; left: 10px; right: 10px;margin: auto;}
    </style>
</head>
<body>
    <div class="mui-content-padded" id="placeInfo" v-cloak>
        <input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
        <div class="mui-input-row">
            <input type="text" ex="起运国" class="lSelect" placeholder="请选择起运国" readonly v-on:tap="chooseCountry()" v-model="orderData.startCountryName" />
        </div>
        <div class="mui-input-row">
            <input type="text" ex="目的港" class="lSelect" placeholder="请选择目的港" readonly v-on:tap="choosePort" v-model="orderData.dischargePortName" />
        </div>
        <div class="mui-input-row">
            <input type="text" ex="仓库市" class="lSelect" placeholder="仓库市" style="width:49%;" readonly v-on:tap="chooselcCity" v-model="wCityName" v-if="orderData.warehouseAgent" />
            <input type="text" ex="仓库" class="lSelect" placeholder="请选择仓库" style="width:49%; " readonly v-on:tap="chooselc" v-model="warehouseName" v-if="orderData.warehouseAgent" />
        </div>
        <div class="mui-input-row">
            <input type="text" ex="送货省" class="lSelect" placeholder="送货省" style="width:31%" readonly v-on:tap="chooseProvince" v-model="dProvinceName" v-if="orderData.deliveryAgent" />
            <input type="text" ex="送货市" class="lSelect" placeholder="送货市" style="width:32%;" readonly v-on:tap="chooseCity" v-model="dCtiyName" v-if="orderData.deliveryAgent" />

            <input type="text" ex="送货区县" class="lSelect" placeholder="送货区县" style="width:33%; " readonly v-on:tap="chooseArea" v-model="dCountyName" v-if="orderData.deliveryAgent" />
        </div>
        <div class="mui-input-row">
            <input type="text" ex="送货门点" class="lSelect" placeholder="送货门点" readonly v-on:tap="chooseDelivery" v-model="destinationName" v-if="orderData.deliveryAgent" />
        </div>
        <div class="mui-input-row">
            <input type="text" ex="融资比例" class="lSelect" placeholder="融资比例" readonly v-on:tap="chooseFinancing" v-model="financingPercentName" v-if="orderData.cargoMortgageFinancingAgent" />
        </div>
        <div class="mui-btn-nav">
            <button type="button" class="mui-btn mui-btn-block mui-btn-primary" v-on:tap="submit" v-bind:disabled="submitBtn.disabled">{{submitBtn.name}}</button>
            <a href="${pageContext.request.contextPath}/myOrder/create" class="mui-btn mui-btn-primary mui-btn-block mui-btn-outlined">重新选择</a>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/mui.picker.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/underscore-min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plugins/pageCommon.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/myOrder/confirm.js" type="text/javascript"></script>
</body>
</html>
