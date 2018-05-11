var vm = new Vue({
	el:'#wapper',
	data:{
		baseURL:$('#hPath').val(),
		orders:[],
		statusArr:[
			{name:'全部',hash:'#all',status:'',count:0,active:0},
	        {name:'受理中',hash:'#accept',status:'0',count:0,active:1},
	        {name:'发货中',hash:'#shipment',status:'20',count:0,active:2},
	        {name:'清关中',hash:'#declar',status:'30',count:0,active:3},
	        {name:'配送中',hash:'#logistics',status:'40',count:0,active:4}
	    ],
	    active:0,
	    statusList:[{text:'受理中',value:0},{text:'发货中',value:20},{text:'清关中',value:30},{text:'配送中',value:40},{text:'结算中',value:50},{text:'已结算',value:60},{text:'已完成',value:70},{text:'已关闭',value:-10}],
	    productList:[],
	    
	    //search
	    status:'',
	    orderNo:'',
	    customsNo:'',
	    billNo:'',
	    productName:'',
	    startArrivalTime:'',
	    endArrivalTime:'',	
	    serviceStatus:[],
	    
	    pageList:[],
	    totalPage:0,
	    currentPage:1,
	    pageSize:5
	},
	methods:{
		initQueryHash:function(callback){
			var hash = window.location.hash;
			if(!_.isUndefined(hash) && !_.isEqual(hash,'')){
         		var ele = _.find(this.statusArr,function(q){ return q.hash == hash;});
         		this.status = ele.status;
         		this.active = ele.active; 
         	}
         	setTimeout(function(){
         		if (typeof (callback) == "function")
    				callback();
        	},50);
		},
		pulldownRefresh:function(){
			vm.currentPage = 1;
			vm.totalPage = 0;
			setTimeout(function(){
				vm.pageList = [];
				
				vm.pagedList(function(){
					mui('#refreshContainer').pullRefresh().endPulldownToRefresh();
					mui('#refreshContainer').pullRefresh().refresh(true);
				});				
			},500);
		},
		pullupRefresh:function(){
			setTimeout(function(){
				vm.currentPage ++;
				mui('#refreshContainer').pullRefresh().endPullupToRefresh(vm.currentPage > vm.totalPage);
				if(vm.currentPage <= vm.totalPage){
					vm.pagedList();
				}
			},500);
		},
		pagedList:function(callback){
			mui.ajax(vm.baseURL + '/myOrder/pagedList',{
				data:JSON.stringify({
					status:vm.status,
				    orderNo:vm.orderNo,
				    customsNo:vm.customsNo,
				    billNo:vm.billNo,
				    productName:vm.productName,
				    startArrivalTime:vm.startArrivalTime,
				    endArrivalTime:vm.endArrivalTime,
				    currentPage:vm.currentPage,
				    pageSize:vm.pageSize,
				    serviceStatus:vm.serviceStatus.length == 0 ? null : vm.serviceStatus
				}),
				dataType:'json',
				type:'POST',
				headers:{'Content-Type':'application/json'},     
				success:function(res){
					if(res.success && res.data){
						var data = res.data;
						vm.totalPage = data.totalPage;
						_.each(data.pagedList,function(item){
							vm.pageList.push(item);
						});
					}
					if(typeof(callback) == 'function')
						callback();
				}
			});
		},
		chooseTab:function($index,item){
			$('.ui-choose li').removeClass('selected');
			vm.serviceStatus = [];
			vm.active = $index;
			vm.status = item.status;
			vm.orderNo = '';
		    vm.customsNo = '';
		    vm.billNo = '';
		    vm.productName = '';
		    vm.startArrivalTime = '';
		    vm.endArrivalTime = '';
		    vm.serviceStatus = [];
		    vm.pulldownRefresh();
		},
		//显示菜单
		showPopover:function(){
			mui('.mui-popover').popover('toggle');
			mui('.mui-scroll-wrapper').scroll();
			vm.uiChoose();
			vm.productList = [];
			mui.post(vm.baseURL + '/myOrder/queryProducts',{},function(res){
				if(res.success){
					_.each(res.data,function(q,n){
						vm.productList.push({text:q,value:n++ });
					});
				};
			},'json');
		},
		//选择产品
		choosePro:function(){
			var picker = new mui.PopPicker();
			picker.setData(vm.productList); 
			picker.show(function (selectItems) {
				vm.productName = selectItems[0].text;
		  })
		},
		//选择预到港起日
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
		//选择预到港止日
		chooseEndDate:function(){
			var picker = new mui.DtPicker({type:'date'});
			picker.show(function(rs) {
				if(rs.text != ''){
					vm.endArrivalTime = rs.text;
				}
				picker.dispose();
				picker = null;
			});
		},
		//订单状态选择
		uiChoose:function(){
			var uc = $('#selectStatus').ui_choose();
			uc.change = function(value, item) {
			    vm.serviceStatus = value;
			};
		},
		//订单查询
		queryOrder:function(){
			vm.status = '';
			vm.active = 0;
			vm.pulldownRefresh();			
			mui('#popover').popover('hide');
		},
	},
	filters:{
		renderStatus:function(value){
			return value == -10 ? '已关闭':value == 20 ? '发货中':value == 30 ? '清关中':value == 40 ?'配送中':value == 50 ?'结算中':value == 60 ?'已结算':value == 70 ? '已完成':'受理中';
		},
		renderDate:function(value,formatString){
			return !value ? '-' : new Date(value).format(formatString);
		},
		renderRemark:function(value){
			if(!_.isUndefined(value)){
				var arr = value.split('|');
				return _.first(arr);
			}
			return '-';
		}
	},
	watch:{
		'serviceStatus':function(value){
			console.log(value);
		}
	},
	created:function(){
		this.initQueryHash(function(){
			mui.init({
				pullRefresh:{
					container:'#refreshContainer',
					down: { auto:true, contentrefresh:'数据加载中...',callback: vm.pulldownRefresh },
					up :{ auto:true, contentrefresh:'数据加载中...', callback:vm.pullupRefresh }
				},
				swipeBack:false
			});
		});
		
		mui('body').on('tap', '#wapper a', function () {
		    document.location.href = this.href;
		});		
		/*xback.listen(function() {
			//ToDo
		});*/
	}
});
Date.prototype.format = function (formatStr) {
    var format = formatStr;
    var Week = ['日', '一', '二', '三', '四', '五', '六'];
    format = format.replace(/yyyy|YYYY/, this.getFullYear());
    format = format.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));
    var month = this.getMonth() + 1;
    format = format.replace(/MM/, month > 9 ? month.toString() : '0' + month);
    format = format.replace(/M/g, month);
    format = format.replace(/w|W/g, Week[this.getDay()]);
    format = format.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
    format = format.replace(/d|D/g, this.getDate());
    format = format.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
    format = format.replace(/h|H/g, this.getHours());
    format = format.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
    format = format.replace(/m/g, this.getMinutes());
    format = format.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
    format = format.replace(/s|S/g, this.getSeconds());
    return format;
}
