//修改手机
var viewApi = mui('#views').view({
    defaultPage: '#modifyiphoneFirst'
});
var vm = new Vue({
	el:'#wapper',
	data:{
		
	},
	methods:{
		init:function(){
		},
		next:function(){
			viewApi.go('#modifyiphone');
		}
	}
});
vm.init();
