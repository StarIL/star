<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>订单详情</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<style>
	.mui-table-view:first-child{margin-top:0 !important;}
	.mui-table-order{background:#4481e6;color:#fff !important;}
	.mui-table-order li span{color:#fff !important}
	.mui-table-order .mui-table-view-cell:first-child{font-size:18px;}
	.mui-table-order .mui-table-view-cell:after{left:0px;}
	.mui-table-order .mui-table-view-cell:first-child:after{border-bottom:1px dashed #ddd;background-color:transparent !important;}
	.mui-arrowright{padding-right: 20px;color: #4481e6 !important;}
	.mui-media-img{vertical-align:top;padding:0 0 0 2px;}
	.mui-table-view span.mui-pull-right {color: #666;}
	</style>
</head>
<body>
<div id="wapper" class="mui-fullscreen" v-cloak>
 	<input type="hidden" id="hPath" value="${pageContext.request.contextPath}" />
	<input type="hidden" id="hId" value="${id}" />
    <div class="refreshContainer mui-scroll-wrapper">	   
        <div class="mui-scroll">
        	<div id="page-View" v-if="showPage">
	            <ul class="mui-table-view mui-table-order" >
	                <li class="mui-table-view-cell">{{detail.order.orderCode}}
	                    <span class="mui-media-body">
	                        <img src="http://img.aiswl.com/images/a_biao1.png" class="mui-media-img" v-if="detail.order.haveAgent"/>
	                        <img src="http://img.aiswl.com/images/a_biao2.png" class="mui-media-img" v-if="detail.order.haveLogistical"/>
	                        <img src="http://img.aiswl.com/images/a_biao3.png" class="mui-media-img" v-if="detail.order.haveFinance"/>
	                    </span>
	                    <span class="mui-pull-right">{{detail.order.serviceStatus |　renderStatus}}</span>
	                </li>
	                <li class="mui-table-view-cell">
	                    <div class="mui-table">
	                        <div class="mui-table-cell">
	                            <div class="mui-media-body">
	                                <span class="mui-ellipsis mui-pull-left mui-col-xs-9 mui-col-sm-9 mui-left">{{detail.order.startCountryName}} - {{detail.order.dischargePortName}}</span>
	                                <span class="mui-pull-right">{{detail.order.createTime | renderDate 'yy-MM-dd'}}</span>
	                            </div>
	                            <div class="mui-media-body">
	                                <span class="mui-h5 mui-pull-left">服务内容</span>
	                                <span class="mui-h5 mui-pull-right mui-col-xs-9 mui-col-sm-9 mui-ellipsis">{{{detail.order | renderService}}}</span>
	                            </div>
	                        </div>
	                    </div>
	                </li>
	            </ul>
	            <ul class="mui-table-view mui-table-view-striped" v-if="detail.todos.length > 0">
	                <li class="mui-table-view-cell mui-table-view-chevron">待办事宜</li>
	                <li class="mui-table-view-cell">
	                    <div class="mui-table">
	                        <div class="mui-table-cell mui-collapse-content">
	                            <div class="mui-media-body" v-for="todo in detail.todos">
	                                <span class="mui-h5 mui-ellipsis mui-pull-left mui-col-xs-8 mui-left">{{todo.listremark}}</span>
	                                <span class="mui-h5 mui-pull-right">{{todo.createTime | renderDate 'yy-MM-dd'}}</span>
	                            </div>
	                        </div>
	                    </div>
	                </li>
	            </ul>
	           <!-- <ul class="mui-table-view" v-if="plans.length > 0">
	                <li class="mui-table-view-cell"><a href="${pageContext.request.contextPath}/myOrder/executive?id={{detail.order.id}}" class="mui-navigate-right">执行进度<span class="mui-h5 mui-pull-right mui-arrowright" v-for="plan in plans">{{plan.completeTime | renderDate 'MM-dd'}} {{plan.workName}}</span></a></li>
	                <li class="mui-table-view-cell">
	                    <div class="mui-table">
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">国外发货</span>
	                            <span class="mui-h5 mui-pull-right">预计需要21天</span>
	                        </div>
	                    </div>
	                </li>
	            </ul> -->
	            <ul class="mui-table-view" v-if="cny.cnySum > 0">
	                <li class="mui-table-view-cell"><a href="${pageContext.request.contextPath}/myOrder/cost?id={{detail.order.id}}" class="mui-navigate-right">订单费用<span class="mui-pull-right mui-arrowright">{{cny.cnySum | currency ''}}</span></a></li>
	                <li class="mui-table-view-cell">
	                    <div class="mui-table">
	                        <div class="mui-media-body" v-for="item in cny.list">
	                            <span class="mui-h5 mui-pull-left">{{item.serverTypeId | renderServerType}}</span>
	                            <span class="mui-h5 mui-pull-right">{{item.cny | currency ''}}</span>
	                        </div>
	                    </div>
	                </li>
	            </ul>
	            <ul class="mui-table-view">
	                <li class="mui-table-view-cell">贸易信息</li>
	                <li class="mui-table-view-cell">
	                    <div class="mui-table">
	                        <div class="mui-media-body mui-col-sm-12 mui-col-xs-12">
	                            <span class="mui-h5 mui-pull-left">合同编号</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.contractNo}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">签约日期</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.contractDate | renderDate 'yyyy-MM-dd'}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">卖方</span>
	                            <span class="mui-h5 mui-ellipsis mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.sellerCompanyName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">生产厂号</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.factoryNo}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">买方</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.buyerCompanyName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">起运港</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.order.startCountryName}}&nbsp;{{detail.order.loadingPortName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">目的港</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.transportType == '2'?'空运':'海运'}}&nbsp;{{detail.order.dischargePortName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">贸易条款</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.transactionMethods | renderTransactionMethod}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">支付方式</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.trade.paymentMethod | renderPaymentMethod}}&nbsp;预付{{detail.trade.prepaidPercent}}%</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">发货时间</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.trade.deliveryItemTerms}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">合同金额</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.trade.orderAmount | currency ''}} {{detail.trade.currencyId | renderCurrency}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">运保杂费</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.insuranceChange | currency ''}} CNY</span>
	                        </div>
	                    </div>
	                </li>
	            </ul>
	            <ul class="mui-table-view" v-if="items.length > 0">
	                <li class="mui-table-view-cell">产品信息</li>
	                <li class="mui-table-view-cell" v-for="item in items">
	                    <div class="mui-table">
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">产品</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{item.productName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">HS编码</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{item.hsCode}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">原产地</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{item.countryName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">生产厂号</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.trade.factoryNo}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">数量</span>
	                            <span class="mui-h5 mui-pull-right">{{item.productAmount}} {{item.productUnitId | renderUnit}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">单价</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{item.productSalePrice}} {{detail.trade.currencyId | renderCurrency}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">总价</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{item.productTotalPrice}} {{detail.trade.currencyId | renderCurrency}}</span>
	                        </div>
	                    </div>
	                </li>                
	            </ul>
	            <ul class="mui-table-view" v-if="detail.order.warehouseAgent || detail.order.deliveryAgent">
	                <li class="mui-table-view-cell">仓储物流</li>
	                <li class="mui-table-view-cell">
	                    <div class="mui-table" v-if="detail.order.servicesCate == 1 && detail.order.warehouseAgent && !detail.order.deliveryAgent"> <!-- 海运仓储 -->
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">净重</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.info.totalnetweight}}公斤</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">储存天数</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.storage.storageDays}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">仓库</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.warehouse.name}}</span>
	                        </div>
	                    </div>
	                    <div class="mui-table" v-if="detail.order.servicesCate == 1 && !detail.order.warehouseAgent && detail.order.deliveryAgent"> <!-- 海运送货 -->
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">箱数</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.info.containerNum}} * {{detail.info.containerUnitid | renderUnit}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">送货门点</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.destination.destinationName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">详细地址</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.delivery.recAddress}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">联系人/电话</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-8 mui-col-xs-8 mui-ellipsis">{{detail.delivery.recContactName}}/{{detail.delivery.recContactPhone}}</span>
	                        </div>
	                    </div>
	                    <div class="mui-table" v-if="detail.order.servicesCate == 1 && detail.order.warehouseAgent && detail.order.deliveryAgent"> <!-- 海运送货  + 仓储-->
	                    	<div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">箱数</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.info.containerNum}} * {{detail.info.containerUnitid | renderUnit}}</span>
	                        </div>
	                    	<div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">净重</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.info.totalnetweight}}公斤</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">储存天数</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.storage.storageDays}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">仓库</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.warehouse.name}}</span>
	                        </div>
	                    </div>
	                    <div class="mui-table" v-if="detail.order.servicesCate > 1 && !detail.order.warehouseAgent && detail.order.deliveryAgent"> <!-- 空运送货-->
	                    	<div class="mui-media-body" v-if="detail.order.servicesCate  == 2">
	                            <span class="mui-h5 mui-pull-left">箱数</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.info.containerNum}} * {{detail.info.containerUnitid | renderUnit}}</span>
	                        </div>
	                    	<div class="mui-media-body" v-if="detail.order.servicesCate  == 3">
	                            <span class="mui-h5 mui-pull-left">毛重</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.info.totalgrossweight}}公斤</span>
	                        </div>
	                    	<div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">送货门点</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.destination.destinationName}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">详细地址</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{detail.delivery.recAddress}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">联系人/电话</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-8 mui-col-xs-8 mui-ellipsis">{{detail.delivery.recContactName}}/{{detail.delivery.recContactPhone}}</span>
	                        </div>
	                    </div>
	                </li>
	            </ul>
	            <ul class="mui-table-view" v-if="detail.order.payImportTaxAgent || detail.order.cargoMortgageFinancingAgent">
	                <li class="mui-table-view-cell">{{detail.order.payImportTaxAgent ? '应付关税融资':'货押融资'}}</li>
	                <li class="mui-table-view-cell">
	                    <div class="mui-table">
	                    	<div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">融资天数</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.financial.financingDays}}</span>
	                        </div>
	                        <div class="mui-media-body">
	                            <span class="mui-h5 mui-pull-left">融资金额</span>
	                            <span class="mui-h5 mui-pull-right">{{detail.financial.financingAmount | currency ''}}</span>
	                        </div>                        
	                    </div>
	                </li>
	            </ul>            
	            <ul class="mui-table-view">
	                <li class="mui-table-view-cell">
	                    <a href="${pageContext.request.contextPath}/myDoc/?id={{detail.order.id}}" class="mui-navigate-right">单据文件</a>
	                </li>
	                <li class="mui-table-view-cell" v-if="docs.length > 0">
	                    <div class="mui-table">
	                        <div class="mui-media-body" v-for="doc in docs">
	                            <span class="mui-h5 mui-pull-left mui-col-sm-3 mui-col-xs-3 mui-ellipsis mui-left">{{doc.billId | renderBillType}}</span>
	                            <span class="mui-h5 mui-pull-right mui-col-sm-9 mui-col-xs-9 mui-ellipsis">{{doc.billNo}}</span>
	                        </div>
	                    </div>
	                </li>
            	</ul>
        	</div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/underscore-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/then.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/myOrder/detail.js" type="text/javascript"></script>
</html>