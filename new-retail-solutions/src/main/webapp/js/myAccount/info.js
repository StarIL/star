mui.init({swipeBack:true });
var vm = new Vue({
	el:'#wapper',
	data:{
    	baseURL: $('#hPath').val(),
    	showLoading:false,
    	
    	info:{}
	},
	methods:{
		queryUserInfo:function(callback){
			mui.get(this.baseURL + '/myAccount/queryInfo',function(res){
				res = JSON.parse(res);
				if(res.success){
					vm.info = res.data;
				}
				if(typeof callback == 'function')
					callback();
			})
		},
		setting:function(){
			if(mui.os.plus){
				plus.nativeUI.actionSheet({
					title: "修改头像",
					cancel: "取消",
					buttons: [{ title: "拍照"}, {title: "从手机相册选择"}]
				}, function(b) {
					switch (b.index) {
						
					}
				})
			}
		},
		setError:function($event){
    		$event.srcElement.src = 'http://img.aiswl.com/images/a_userpic.jpg';
    	},
    	
//  	企业选择弹框
    	enterprise:function(){
    		mui('#bottombox').popover('toggle');
    	},
//  	性别选择弹框
    	genderPopover:function(){
			mui('#gender').popover('toggle');
		},
	},
	filters:{
		renderPic:function(value){
    		if(!value || value == undefined){
    			return 'http://img.aiswl.com/images/a_userpic.jpg';
    		}
    		return value;
    	}
	},
	created:function(){
		
		var viewApi = mui('#views').view({
			defaultPage: '#account'
		});
		this.queryUserInfo(function(){
			mui('body').on('tap', '#wapper a', function () {
			    document.location.href = this.href;
			});
		});
	}
});
