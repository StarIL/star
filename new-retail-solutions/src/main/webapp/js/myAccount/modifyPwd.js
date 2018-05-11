//修改密码页面
var viewApi = mui('#views').view({
    defaultPage: '#passworldFirst'
});
var vm = new Vue({
	el:'#wapper',
	data:{
		
	},
	methods:{
		init:function(){
		},
		next:function(){
			viewApi.go('#passworld');
		}
	}
});
vm.init();
