<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>我的</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myAccount/index.css" />
</head>
<body >
<div id="userIndex" class="mui-fullscreen" v-cloak>
	<input type="hidden" id="hPath" value="${pageContext.request.contextPath}"/>
    <div id="refreshContainer" class="mui-content mui-row mui-scroll-wrapper" >
   		<div class="mui-scroll">
	        <ul class="mui-table-view mui-col-sm-12 mui-col-xs-12" id="userInfo">
	            <li style="padding:20px 24px">
	               <%--<a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myAccount/info')"> --%>
	               	<a href="javascript:;">
	                   <div class="imgContent"><img id="userImg" v-bind:src="userInfo.user.portrait | portrait"></div>
	                </a>
	                <div class="mui-media-body" style="margin-top:10px">
	                    <p class="mui-ellipsis mui-left" style="font-size:18px">{{userInfo.user.realName }}</p>
	                    <div class="companyContent">
	                        <p class='mui-ellipsis mui-left' v-if="userInfo.customer">{{userInfo.customer.cnName }}</p>
	                        <p v-if="!userInfo.customer">（未加入公司）</p>
	                        <img src="http://img.aiswl.com/images/a_prove2.png" class="proveImg" v-show="userInfo.customer.approveStatus"/>
	                        <img src="http://img.aiswl.com/images/a_prove1.png" class="proveImg" v-show="!userInfo.customer.approveStatus"/>
	                    </div>
	                    <p v-if="userInfo.customer" class="mui-ellipsis mui-left" v-on:tap="jumpOperator()">专属客服：{{userInfo.operator.realName}}</p>
	                    <p v-if="!userInfo.customer">无专属客服</p>
	                </div>
	            </li>
	        </ul>
	        <!--账户信息-->
	        <ul class="account mui-col-sm-12 mui-col-xs-12">
	            <li class="mui-col-sm-6 mui-col-xs-6">
	                <p>{{userInfo.capital | renderPrice | currency ''}}</p>
	                <p class="bottom">账户余额（元）</p>
	            </li>
	            <li class="mui-col-sm-6 mui-col-xs-6">
	                <p>{{orderInfo.incomeAmountCny | renderPrice | currency ''}}</p>
	                <p class="bottom">应付余额（元）</p>
	            </li>
	            <!-- <li class="mui-col-sm-4 mui-col-xs-4">
	                <p>0.00</p>TODO
	                <p class="bottom">借款余额（元）</p>
	            </li> -->
	        </ul>
	        <!--我的账单-->
	        <div class="bill mui-col-sm-12 mui-col-xs-12">
	            <ul class="title" v-on:tap="jumpMyBill()">
	                <li class="mui-pull-left">我的账单</li>
	                <li class="mui-pull-right"><a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myBill/')">更多<span class="mui-icon mui-icon-arrowright" style="font-size:16px"></span></a></li>
	            </ul>
	            <ul class="status mui-col-sm-12 mui-col-xs-12">
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myBill/#confirm')">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon1.png" />
	                            <span class="mui-badge mui-badge-warning statusNum" v-if="billInfo.pendingConfirmCount > 0">{{billInfo.pendingConfirmCount}}</span>
	                        </div>
	                        <p class="statusW">待确认</p>
	                    </li>
	                </a>
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myBill/#payment')">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon2.png" />
	                            <span class="mui-badge mui-badge-warning statusNum" v-if="billInfo.pendingPaymentCount > 0">{{billInfo.pendingPaymentCount}}</span>
	                        </div>
	                        <p class="statusW">待付款</p>
	                    </li>
	                </a>
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myBill/#overdue')">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon3.png" />
	                            <span class="mui-badge mui-badge-warning statusNum" v-if="billInfo.pendingExpectedCount > 0">{{billInfo.pendingExpectedCount}}</span>
	                        </div>
	                        <p class="statusW">逾期</p>
	                    </li>
	                </a>
	            </ul>
	        </div>
	        <!--我的订单-->
	        <div class="order">
	            <ul class="title">
	                <li class="mui-pull-left">我的订单</li>
	                <li class="mui-pull-right"><a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myOrder/#all')">更多<span class="mui-icon mui-icon-arrowright" style="font-size:16px"></span></a></li>
	            </ul>
	            <ul class="status mui-col-sm-12 mui-col-xs-12" style="border-bottom:1px solid #ddd">
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myOrder/#accept')">
	                    <li class="mui-col-sm-3 mui-col-xs-3">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon4.png" />
	                            <span class="mui-badge mui-badge-warning statusNum" v-show="orderInfo.orderStatus.placeorder != 0">{{orderInfo.orderStatus.placeorder}}</span>
	                        </div>
	                        <p class="statusW">受理中</p>
	                    </li>
	                </a>
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myOrder/#shipment')">
	                    <li class="mui-col-sm-3 mui-col-xs-3">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon5.png" />
	                            <span class="mui-badge mui-badge-warning statusNum" v-show="orderInfo.orderStatus.accepance != 0">{{orderInfo.orderStatus.accepance}}</span>
	                        </div>
	                        <p class="statusW">发货中</p>
	                    </li>
	                </a>
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myOrder/#declar')">
	                    <li class="mui-col-sm-3 mui-col-xs-3">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon6.png" />
	                            <span class="mui-badge mui-badge-warning statusNum" v-show="orderInfo.orderStatus.transport_f != 0">{{orderInfo.orderStatus.transport_f}}</span>
	                        </div>
	                        <p class="statusW">清关中</p>
	                    </li>
	                </a>
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myOrder/#logistics')">
	                    <li class="mui-col-sm-3 mui-col-xs-3">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon7.png" />
	                            <span class="mui-badge mui-badge-warning statusNum" v-show="orderInfo.orderStatus.clearance != 0">{{orderInfo.orderStatus.clearance}}</span>
	                        </div>
	                        <p class="statusW">配送中</p>
	                    </li>
	                </a>
	            </ul>
	            <%-- <ul class="orderStatus">
	                <li class="mui-pull-left">
	                    <p class="statusP">最新进展</p>
	                    <p>{{orderInfo.work.completeTime | renderDate}}</p>
	                </li>
	                <li class="mui-pull-left mui-col-sm-8 mui-col-xs-7" v-show="orderInfo.work">
	                    <a href="javascript:;" v-on:tap="hrefConfim('',$event)" data-url="${pageContext.request.contextPath}/myOrder/detail?id={{orderInfo.work.orderId}}">
	                        <img class="mui-media-object mui-pull-left" src="${pageContext.request.contextPath}/images/wechat_pro.png">
	                        <div class="mui-media-body mui-pull-left orderInfo mui-col-sm-12 mui-col-xs-12 mui-ellipsis mui-left">{{orderInfo.work.workName}}</div>
	                    </a>
	                </li>
	                <li class="mui-pull-left" v-show="!orderInfo.work">暂无</li>
	            </ul>
	            <ul class="orderStatus">
	                <li class="mui-pull-left">
	                    <p class="statusP">待办事宜</p>
	                    <p>{{orderInfo.todo.createTime | renderDate}}</p>
	                </li>
	                <li class="mui-pull-left mui-col-sm-8 mui-col-xs-7" v-show="orderInfo.todo">
	                    <a href="javascript:;" v-on:tap="hrefConfim('',$event)" data-url="${pageContext.request.contextPath}/myOrder/detail?id={{orderInfo.work.orderId}}">
	                        <img class="mui-media-object mui-pull-left" src="${pageContext.request.contextPath}/images/wechat_pro.png">
	                        <div class="mui-media-body mui-pull-left orderInfo mui-col-sm-12 mui-col-xs-12 mui-ellipsis mui-left">{{orderInfo.todo.listremark}}</div>
	                    </a>
	                </li>
	                <li class="mui-pull-left" v-show="!orderInfo.todo">
						暂无
	                </li>
	            </ul> --%>
	            <div class="btncontent" style="margin-top:20px;">
	                <a href="javascript:;" v-on:tap="hrefConfim('${pageContext.request.contextPath}/myOrder/create')" class="mui-btn mui-btn-outlined mui-col-sm-11 mui-col-xs-11">立即下单</a>
	            </div>
	        </div>
	        <!--我的借款
	        <div class="loan mui-col-sm-12 mui-col-xs-12">
	            <ul class="title">
	                <li class="mui-pull-left">我的借款</li>
	                <li class="mui-pull-right"><a v-on:tap="hrefConfim()">更多<span class="mui-icon mui-icon-arrowright" style="font-size:16px"></span></a></li>
	            </ul>
	            <ul class="status mui-col-sm-12 mui-col-xs-12">
	                <a v-on:tap="hrefConfim()">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon8.png" />
	                            <span class="mui-badge mui-badge-warning statusNum">5</span>
	                        </div>
	                        <p class="statusW">放款中</p>
	                    </li>
	                </a>
	                <a v-on:tap="hrefConfim()">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon9.png" />
	                            <span class="mui-badge mui-badge-warning statusNum">5</span>
	                        </div>
	                        <p class="statusW">代还款</p>
	                    </li>
	                </a>
	                <a v-on:tap="hrefConfim()">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon3.png" />
	                            <span class="mui-badge mui-badge-warning statusNum">5</span>
	                        </div>
	                        <p class="statusW">逾期</p>
	                    </li>
	                </a>
	            </ul>
	        </div> -->
	        <!--我的管理
	        <div class="loan mui-col-sm-12 mui-col-xs-12" style="margin-bottom:0">
	            <ul class="title">
	                <li class="mui-pull-left" style="font-size:18px">我的管理</li>
	            </ul>
	            <ul class="status mui-col-sm-12 mui-col-xs-12">
	                <a v-on:tap="hrefConfim()">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon10.png" />
	                        </div>
	                        <p class="statusW">我的同事</p>
	                    </li>
	                </a>
	                <a v-on:tap="hrefConfim()">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon11.png" />
	                        </div>
	                        <p class="statusW">我的企业</p>
	                    </li>
	                </a>
	                <a v-on:tap="hrefConfim()">
	                    <li class="mui-col-sm-4 mui-col-xs-4">
	                        <div class="statusContent">
	                            <img src="${pageContext.request.contextPath}/images/wechat_icon12.png" />
	                        </div>
	                        <p class="statusW">资金流水</p>
	                    </li>
	                </a>
	            </ul>
	        </div> -->
    	</div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/vue.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/mui.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/pageCommon.js"></script>
<script src="${pageContext.request.contextPath}/js/myAccount/index.js"></script>
</html>