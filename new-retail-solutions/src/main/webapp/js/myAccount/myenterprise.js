var viewApi = mui('#views').view({
    defaultPage: '#enterpriseFirst'
});
var vm=new Vue({
	el:'#myenterprise',
	data:{
		
	},
	methods:{
		init:function(){
		},
//		修改备案号
		record:function(){
			mui('#modifyrecord').popover('toggle');
		},
//		修改三证合一
		Certificates:function(){
			mui('#modifyCertificates').popover('toggle');
		},
//		修改传真
		fax:function(){
			mui('#modifyfax').popover('toggle');
		},
//		修改法人
		law:function(){
			mui('#modifylaw').popover('toggle');
		},
//		修改企业
		enterprise:function(){
			mui('#modifyenterprise').popover('toggle');
		},
//		修改邮编
		code:function(){
			mui('#modifycode').popover('toggle');
		},
//		修改税务登记证
		tax:function(){
			mui('#modifyBureau').popover('toggle');
		},
//		修改营业执照
		license:function(){
			mui('#modifyicense').popover('toggle');
		},
//		修改组织机构
		mechanism:function(){
			mui('#modifyorganization').popover('toggle');
		},
	},
});
vm.init();