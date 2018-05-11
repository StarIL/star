var vm=new Vue({
	el:"#wapper",
	data:{
		baseURL: $('#hPath').val(),
		t:$('#t').val(),
		
		radio:0,
	    compName:'',//企业名称
	},
	methods:{
		registerSumbmit:function(){
			if(vm.radio == 0){
				if(vm.isCorpPass()){
					mui.post(vm.baseURL + '/registerComp', {token:vm.t,compName:vm.compName}, function (res) {
						if(res.success){
							location.href = vm.baseURL + '/login/';
						}else{
		            		mui.toast(res.msg);
		            	}
		            },'json');
				}
			}else{
				location.href = vm.baseURL + '/login/';
			}
		},
		isCorpPass:function(){
			if(!vm.compName && vm.compName.length == 0){
				mui.toast('企业名称不能为空');
				return false;
			}
			return true;
		},
		toast:function(msg){
			setTimeout(function(){
				mui.toast(msg);
			},10);
		}
	},
	created:function(){
		mui.init();
		mui('body').on('tap', '#wapper a', function () {
			document.location.href = this.href;
		});
	}
});