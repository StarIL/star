//修改邮箱

var viewApi = mui('#views').view({
    defaultPage: '#mailFirst'
});
var vm = new Vue({
	el:'#wapper',
	data:{
		
	},
	methods:{
		init:function(){
		},
		next:function(){
			viewApi.go('#mail');
		},
	}
});
vm.init();
