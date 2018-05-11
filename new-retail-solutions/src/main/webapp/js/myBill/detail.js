var vm = new Vue({
	el:'#billDetail',
	data:{
		baseURL:$('#hPath').val(),
		showLoading:false,
		queryList:[],
		id:null,//账单id
		billCode:null,//账单号
		status:0,//账单状态
		amount:null,//账单总金额
		invoiceAmount:null,//开票总金额
		billDate:null,//账单日期
		invoiceIscomplete:false,//是否开票完成
		expectedDays:null,//是否逾期
	},
	methods:{
		init:function(){
			vm.initUrl();
			vm.query();
		},
		//获取URL地址
		GetUrl:function(name){
		    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		    var r = window.location.search.substr(1).match(reg);
		    if(r!=null)return  unescape(r[2]); return null;
		},
		//初始化并获取URL参数
		initUrl:function(){
			vm.id = vm.GetUrl('i');
			vm.billCode = vm.GetUrl('c');
			vm.status = vm.GetUrl('s');
			vm.amount = vm.GetUrl('a');
			vm.invoiceAmount = vm.GetUrl('ia');
			vm.billDate = JSON.parse(vm.GetUrl('d'));
			vm.invoiceIscomplete = vm.GetUrl('ic');
			vm.expectedDays = JSON.parse(vm.GetUrl('e'));
		},
		//查询账单详情数据
		query:function(){
			vm.showLoading = true;
			$.get(vm.baseURL + '/myBill/queryBillDetail',{customerBillId:vm.id},function(res){
				vm.showLoading = false;
				if(res.success){
					vm.queryList = res.data.data;
				}
			});
		},
		//确认账单
		confrim:function(){
			vm.showLoading = true;
			$.post(vm.baseURL + '/myBill/confirmBill',{customerBillId:vm.id},function(res){
				vm.showLoading = false;
				if(res.success){
					mui.toast(res.msg);
					vm.status = 2;
					setTimeout(function(){
						location.href = vm.baseURL + '/myBill/';
					},1500)
				}else{
					mui.toast(res.msg);
				}
			});
		},
		
	},
	filters:{
		renderStatus:function(value){
			if(value == 1){
				return '待确认';
			}else if(value == 2){
				return '待付款';
			}else{
				return '已付款';
			}
		},
		renderDate:function(value){
			return !value ? '' : new Date(value).format('yy-MM-dd');
		},
	},
});
vm.init();
