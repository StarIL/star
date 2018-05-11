var viewApi = mui('#views').view({
    defaultPage: '#enterpriseFirst'
});
var vm=new Vue({
	el:"#myenterprise",
	data:{
		
	},
	methods:{
		init:function(){
		  },
		 record:function(){
			mui('#modifyrecord').popover('toggle');
		},
		 role:function(){
			mui('#modifyenterprise').popover('toggle');
		},
	},
});
vm.init();
