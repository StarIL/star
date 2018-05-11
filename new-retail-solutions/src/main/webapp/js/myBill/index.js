var vm = new Vue({
	el:'#myBill',
	data:{
		baseURL:$('#hPath').val(),
		id:$('#hId').val(),
		navList:[
			{name:'全部',hash:'#all',status:0,activeIndex:0,isExpected:false},
			{name:'待确认',hash:'#confirm',status:1,activeIndex:1,isExpected:false},
			{name:'待付款',hash:'#payment',status:2,activeIndex:2,isExpected:false},
			{name:'逾期',hash:'#overdue',status:0,activeIndex:3,isExpected:true}
		],
		activeIndex:0,
		showLoading:false,
		queryList:[],
		//search
		status:0,
		isExpected:false,
		totalPage:0,
	    currentPage:1,
	    pageSize:5		
	},
	methods:{
		//初始化URL
		initQueryHash:function(callback){
			var hash = window.location.hash;
			if(!_.isUndefined(hash) && !_.isEqual(hash,'')){
         		var ele = _.find(this.navList,function(q){ return q.hash == hash;});
         		this.status = ele.status;
         		this.activeIndex = ele.activeIndex;
         		this.isExpected = ele.isExpected;
         	}
		},
		//查询数据
		queryAll:function(){
			$.ajax({
				url:vm.baseURL + '/myBill/queryList',
				async:true,
	            type: 'POST',
	    		contentType:"application/json",
	    		data:JSON.stringify({
	    			currentPage: vm.currentPage,
					isExpected: vm.isExpected,
					pageSize:vm.pageSize,
					status:vm.status
	    		}),
	    		success:function(res){
	    			if(res.success){
	    				vm.totalPage = res.data.totalPage;
						for(var i = 0; i < res.data.pagedList.length;i++){
							vm.queryList.push(res.data.pagedList[i]);
						}
	    			}
	    		}
			});
		},
		//初始化上拉刷新，下拉加载
		muiInit:function(){
			mui.init({
				pullRefresh:{
					container:'#refreshContainer',
					down: { auto:true, contentrefresh:'数据加载中...', callback: this.pulldownRefresh },
					up :{ contentrefresh:'数据加载中...', callback:this.pullupRefresh }
				},
				swipeBack:true
			});
			mui('body').on('tap', '#myBill a', function () {
			    document.location.href = this.href;
			});
		},
		//上拉刷新
		pulldownRefresh:function(){
			setTimeout(function(){
				vm.currentPage = 1;
				vm.queryList = [];
				vm.queryAll();
				mui('#refreshContainer').pullRefresh().endPulldownToRefresh();
				mui('#refreshContainer').pullRefresh().refresh(true);
			},1000);
		},
		//下拉加载
		pullupRefresh:function(){
			setTimeout(function(){
				vm.currentPage ++;
				mui('#refreshContainer').pullRefresh().endPullupToRefresh(vm.currentPage > vm.totalPage);
				if(vm.currentPage <= vm.totalPage){
					vm.queryAll();
				}
			},1000);
		},
		//头部导航栏点击切换事件
		chooseNav:function($index,item){
			vm.activeIndex = $index;
			vm.status = item.status;
			vm.isExpected = item.isExpected;
			vm.queryList = [];
			vm.pulldownRefresh();
		},
		//跳转至详情
		jumpDeail:function(item){
			location.href = vm.baseURL + '/myBill/detail?i=' + item.id + '&c=' + item.billCode + '&s=' + item.status + '&a=' + item.amount + '&ia=' + item.invoiceAmount + '&d=' + item.billDate + '&ic=' + item.invoiceIscomplete + '&e=' + item.expectedDays;
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
	created:function(){
		this.initQueryHash();
		this.muiInit();	
	}
});