var vm = new Vue({
		el:'#userIndex',
		data:{
	    	baseURL: $('#hPath').val(),
	    	userInfo:{},
	    	orderInfo:[],
	    	billInfo:{pendingConfirmCount:0,pendingExpectedCount:0,pendingPaymentCount:0}
		},
		methods:{
			pulldownRefresh:function(){
				vm.userInfo = {};
				vm.billInfo = {pendingConfirmCount:0,pendingExpectedCount:0,pendingPaymentCount:0 };
				vm.orderInfo = [];
				setTimeout(function(){
					vm.queryUserInfo(function(info){
						vm.queryBillInfo();//TODO 账单
						vm.queryOrderInfo(info);
					});
					mui('#refreshContainer').pullRefresh().endPulldownToRefresh();
				},500);
			},
	        //用户数据
	        queryUserInfo: function (callback) {
	            mui.get(vm.baseURL + '/myAccount/queryInfo', function (res) {
	                if (res.success) {
	                    vm.userInfo = res.data;
	    				if(typeof callback == 'function')
	    					callback(res.data);
	                }
	            },'json');
	        },
	        //账单数据
	        queryBillInfo:function(){
	        	mui.post(vm.baseURL + '/myBill/myBillStatistics',{},function(res){
	        		if(res.success){
	        			vm.billInfo = res.data;
	        		}
	        	},'json');
	        },
	        //订单数据(依赖用户)
	        queryOrderInfo: function (info) {
	        	if(info.customer.id){//如果有公司,才查询订单
		            mui.get(vm.baseURL + '/myOrder/queryInfo', function (res) {
		                if (res.success) {
		                    vm.orderInfo = res.data;
		                }
		            },'json');
	        	}
	        },
	        //跳转至我的账单
	        jumpMyBill:function(){
	        	location.href = vm.baseURL + '/myBill/';
	        },
	        //跳转至我的订单
	        jumpMyOrder:function(){
	        	location.href = vm.baseURL + '/myOrder/';
	        },
	        //跳转到我的客服
	        jumpOperator:function(){
	        	if(vm.userInfo.operator){
	        		location.href = vm.baseURL + '/myAccount/exclusive';
	        	}
	        },
	        /**
	         * 跳转确认 -> 有无公司
	         */
	        hrefConfim:function(url,$event){
	        	if(vm.userInfo.customer){
	        		var href= $event != undefined ? $event.currentTarget.getAttribute('data-url')  : url;
	        		window.location.href = href
	        	} else{
	        		mui.toast("您还没有加入公司! ");
	        	}
	        }
		},
	    filters:{
	    	renderDate:function(value){
	    		return value != undefined ? new Date(value).format("MM-dd"):value;
	    	},
	    	portrait:function(value){
	    		return (value ?  value : "http://img.aiswl.com/images/wechat_head.png")+"?x-oss-process=image/resize,m_lfit,h_120,w_120" ;
	    	},
	    	renderPrice:function(value){
	    		return value != undefined ? value :'0.00';
	    	}
	    },
	    created:function(){
	    	mui.init({
				pullRefresh:{
					container:'#refreshContainer',
					down: { auto:true, contentrefresh:'数据加载中...', callback: this.pulldownRefresh },
				},
				swipeBack:true
			});
			mui('.mui-scroll-wrapper').scroll();
	    }		
});
