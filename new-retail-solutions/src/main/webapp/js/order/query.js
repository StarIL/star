var vm = new Vue({
	el:'#orderQuery',
	data:{
		statusList:[{name:'受理中',selected:false},{name:'发货中',selected:false},{name:'清关中',selected:false},{name:'配送中',selected:false},{name:'结算中',selected:false},{name:'已结算',selected:false},{name:'已完成',selected:false},{name:'已关闭',selected:false}],
		activeIndex:0,
	},
	methods:{
		init:function(){
			//订单状态选择
			var uc_04 = $('#selectStatus').ui_choose();
			uc_04.change = function(value, item) {
			    mui.toast(value);
			};
		},
		//选择产品
		choosePro:function(){
			var picker = new mui.PopPicker();
			picker.setData([{value:'1111',text:'冻猪肉'},{value:'2222',text:'冻猪肉2'}]); 
			picker.show(function (selectItems) {
			    mui.toast(selectItems[0].text);
		  })
		},
		//选择预到港起日
		chooseStartDate:function(){
			var picker = new mui.DtPicker();
			picker.show(function(rs) {
				mui.toast(rs.text);
				picker.dispose();
				picker = null;
			});
		},
		//选择预到港止日
		chooseEndDate:function(){
			var picker = new mui.DtPicker();
			picker.show(function(rs) {
				mui.toast(rs.text);
				picker.dispose();
				picker = null;
			});
		},
	}
});
vm.init();
