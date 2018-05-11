var trans = $('#transList').ui_choose();
var agent = $('#agentList').ui_choose();
var storage = $('#storageList').ui_choose();
var finance = $('#financeList').ui_choose();
var vm = new Vue({
	el:'#placeOrder',
	data:{
    	baseURL: $('#hPath').val(),
		storageOld:'',
		financeOld:'',
        showWAgent:true,//显示仓储/显示送货+仓储
        showfAgent: true,//货押融资
        service:{
        	cate : 1,//运输方式/商品种类
        	iAgent: 1,//贸易代理( 含进口清关 )
        	dAgent : false,//是否送货
        	wAgent : false,//是否仓储
            wdAgent : false,//是否仓储物流               
            tAgent : false,//垫付税费
            fAgent : false//货押融资
        },
	},
	methods:{
		init:function(){
			//运输方式选择
			trans.change = function(index,item){
				vm.service.cate = index + 1;
				if(vm.service.cate != 1){
					//隐藏仓储物流 ,并取消选中
					vm.showWAgent = false;//隐藏
					vm.service.dAgent = false;//值
					vm.service.wAgent = false;//值
					vm.service.wdAgent = false;//值
					storage.val(undefined);//jsp渲染
					//隐藏货压,并取消货压选中;
					vm.showfAgent = false;//隐藏
					vm.service.fAgent = false;//值
					finance.val(undefined);//jsp渲染
				}else{
					vm.showWAgent = true;//显示
					vm.showfAgent = true;//显示
				}
			};
			//进口代理选择
			agent.change = function(index, item) {
				vm.service.iAgent = index + 1;
				if(vm.service.iAgent == 2){
					//隐藏货压,并取消货压选中
					vm.showfAgent = false;//隐藏
					vm.service.fAgent = false;//值
					finance.val(undefined);//jsp渲染
				}else if(vm.service.cate == 1){
					vm.showfAgent = true;//显示
				}
			};
			//仓储物流选择
			storage.change = function(index,item){
				var storageOld = undefined;
				if(index != undefined && index.length > 1){
					for (var i = 0 ; i<index.length;i++) {
						if(index[i] != vm.storageOld){
							storage.val([index[i]]);
							break;
						}
					}
				}
				var storageOld = storage.val();
				vm.storageOld = storageOld ? storageOld[0] : undefined;
				if(vm.storageOld == 0){
					vm.service.dAgent = true;
					vm.service.wAgent = false;
					vm.service.wdAgent = false;
				}else if(vm.storageOld == 1){
					vm.service.dAgent = false;
					vm.service.wAgent = true;
					vm.service.wdAgent = false;
				}else if(vm.storageOld == 2){
					vm.service.dAgent = false;
					vm.service.wAgent = false;
					vm.service.wdAgent = true;
				}else if(vm.storageOld == undefined){
					vm.service.dAgent = false;
					vm.service.wAgent = false;
					vm.service.wdAgent = false;
				}
			};
			//金融服务选择
			finance.change = function(index, item) {
				var financeOld = undefined;
				if(index != undefined && index.length > 1){
					for (var i = 0 ; i<index.length;i++) {
						if(index[i] != vm.financeOld){
							finance.val([index[i]]);
							break;
						}
					}
				}
				var financeOld = finance.val();
				vm.financeOld = financeOld ? financeOld[0] : undefined;
				if(vm.financeOld == 0){
					vm.service.tAgent = true;
					vm.service.fAgent = false;
				}else if(vm.financeOld == 1){
					vm.service.tAgent = false;
					vm.service.fAgent = true;
					storage.val(2);//货押融资自动选中送货仓储
					vm.service.dAgent = false;
					vm.service.wAgent = false;
					vm.service.wdAgent = true;
				}
			};
		},
        submitJson:function(){
        	window.location.href = vm.baseURL + "/myOrder/confirm?cate="+vm.service.cate+'&i='+vm.service.iAgent + 
        	'&d=' +vm.service.dAgent+'&w=' +vm.service.wAgent + '&wd='+vm.service.wdAgent+'&t='+vm.service.tAgent +'&f=' + vm.service.fAgent;
        }
	},
	created:function(){
		mui.init();
	}
});
vm.init();
