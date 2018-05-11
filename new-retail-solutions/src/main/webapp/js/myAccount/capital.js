//资金流水
var viewApi = mui('#views').view({
    defaultPage: '#capitalFirst'
});
var vm=new Vue({
	el:'#capital',
	data:{
		
	},
	methods:{
		init:function(){
		},
		//收支期日
		chooseStartDate:function(){
			var picker = new mui.DtPicker({type:'date'});
			picker.show(function(rs) {
				if(rs.text != ''){
					vm.startArrivalTime = rs.text;
				}
				picker.dispose();
				picker = null;
			});
		},
		//收支止日
		chooseEndDate:function(){
			var picker = new mui.DtPicker();
			picker.show(function(rs) {
				if(rs.text != ''){
					vm.endArrivalTime = rs.text.substring(0,10);
				}
				picker.dispose();
				picker = null;
			});
		},
	},
});
vm.init();