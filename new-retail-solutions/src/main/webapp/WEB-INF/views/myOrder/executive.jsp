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
    <link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
</head>
<body>
    <div id="wapper" class="refreshContainer mui-scroll-wrapper" v-cloak>
	    <input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
	    <input type="hidden" id="hId" value="${id}" />
        <div class="mui-scroll">
            <ul class="mui-table-view">
                <li class="mui-table-view-cell">
                    <div class="mui-table">
                        <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">订单受理</span>
                            <span class="mui-pull-right">{{entity.order.acceptDate | renderDate 'yyyy-MM-dd hh:mm'}}</span>
                        </div>
                        <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">单证接收</span>
                            <span class="mui-pull-right">{{entity.info.declarationDate | renderDate 'yyyy-MM-dd hh:mm'}}</span>
                        </div>
                        <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">商品到港</span>
                            <span class="mui-pull-right">{{entity.info.ata | renderDate 'yyyy-MM-dd hh:mm'}}</span>
                        </div>
                        <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">海关放行</span>
                            <span class="mui-pull-right">{{entity.info.customsDate | renderDate 'yyyy-MM-dd hh:mm'}}</span>
                       </div>
                       <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">商品送达</span>
                            <span class="mui-pull-right">{{entity.info.deliveryEndTime | renderDate 'yyyy-MM-dd hh:mm'}}</span>
                       </div>
                       <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">订单完成</span>
                            <span class="mui-pull-right">{{entity.order.orderCompleteDate | renderDate 'yyyy-MM-dd hh:mm'}}</span>
                       </div>
                    </div>
                </li>
           </ul>
           <ul class="mui-table-view">
                <li class="mui-table-view-cell">
                    <div class="mui-table">
                        <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
                            <span class="mui-h5 mui-pull-left">{{entity.order.servicesCate == 1 ?'船':'航空'}}公司</span>
                            <span class="mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{entity.info.shippingCompanyName}}</span>
                        </div>
                        <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
                            <span class="mui-h5 mui-pull-left" v-if="entity.order.servicesCate == 1">船名/航次</span>
                            <span class="mui-h5 mui-pull-left" v-else>航班号</span>
                            <span class="mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis" v-if="entity.order.servicesCate == 1">{{entity.info.shipname}}&nbsp;/&nbsp;{{entity.info.voyageNo}}</span>
                            <span class="mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis" v-else>{{entity.info.voyageNo}}</span>
                        </div>
                        <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">预计到港时间</span>
                            <span class="mui-pull-right">{{entity.info.eta | renderDate 'yyyy-MM-dd hh:mm'}}</span>
                        </div>
                        <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
                            <span class="mui-h5 mui-pull-left">提单号</span>
                            <span class="mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{entity.info.billNo}}</span>
                       </div>
                       <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
                            <span class="mui-h5 mui-pull-left">报关单号</span>
                            <span class="mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{entity.info.customsNo}}</span>
                       </div>
                       <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
                            <span class="mui-h5 mui-pull-left">报检号</span>
                            <span class="mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{entity.info.inspectionNo}}</span>
                       </div>
                       <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
                            <span class="mui-h5 mui-pull-left">集装箱号</span>
                            <span class="mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{entity.info.containerNo}}</span>
                       </div>
                       <div class="mui-media-body">
                            <span class="mui-h5 mui-pull-left">还箱日期</span>
                            <span class="mui-pull-right">{{entity.info.storageDate | renderDate 'yyyy-MM-dd'}}</span>
                       </div>
                    </div>
                </li>
           </ul>
        </div>
    </div>
	<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/myOrder/executive.js" type="text/javascript"></script>
</body>
</html>
