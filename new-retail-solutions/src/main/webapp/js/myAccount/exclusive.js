//专属客服
var vm= new Vue({
	el:'#exclusive',
	data:{
    	baseURL: $('#hPath').val(),
		userInfo:{},
	},
	methods:{
        //用户数据
        queryUserInfo: function (callback) {
            $.get(vm.baseURL + '/myAccount/queryOperator', function (res) {
                if (res.success) {
                    vm.userInfo = res.data;
    				if(typeof callback == 'function')
    					callback(res.data);
                }
            });
        },
	},
    filters:{
    	portrait:function(value){
    		return (value ?  value : "http://img.aiswl.com/images/wechat_head.png")+"?x-oss-process=image/resize,m_lfit,h_65,w_65" ;
    	},
    	portrait140:function(value){
    		return (value ?  value : "")+"?x-oss-process=image/resize,m_lfit,h_140,w_140" ;
    	},
    },
});
vm.queryUserInfo();