var vm = new Vue({
	el:'#wapper',
	data:{
		baseURL:$('#hPath').val(),
		id:$('#hId').val(),
		showLoading:false,
		
		serverTypes:[],
		list:[],
		
	},
	methods:{
		queryCosts:function(callback){
			setTimeout(function(){
				vm.list = [];
				mui.get(vm.baseURL + '/mySettlement/queryList',{orderId:vm.id},function(res){
					if(res.success){
						var data = res.data;
						_.each(data,function(sett,n){
							if(_.some(vm.list,function(item){ return item.serverId == sett.serverId;})){
								var server =_.find(vm.list,function(item){ return item.serverId == sett.serverId;});
								server.receivableTotal += sett.receivableTotal;
								server.receivableCnyTotal += sett.receivableCnyTotal;
								_.each(sett.settlmentDetails,function(detail){
									server.setts.push(detail);
								});
							}else{
								vm.list.push({serverId:sett.serverId,receivableTotal:sett.receivableTotal,receivableCnyTotal:sett.receivableCnyTotal,setts:sett.settlmentDetails});
							}
						});
					}
					if(typeof callback == 'function')
						callback();
				},'json');
				mui('.refreshContainer').pullRefresh().endPulldownToRefresh();
			},500);
		},
		querySererTypes:function(callback){
			mui.get(vm.baseURL + '/serverType/queryList',function(res){
				if(res.success){
					vm.serverTypes = res.data;
				}
				if(typeof callback == 'function')
					callback();
			},'json');
		}
	},
	filters:{
		renderServerType:function(value){
			if(_.some(vm.serverTypes,function(item){ return item.id == value;})){
				var server = _.find(vm.serverTypes,function(item){ return item.id == value;});
				return server.serverName;
			}
		},
		renderPrice:function(value){
			return _.isEqual(value,'') ? '0.00':value;
		}
	},
	created:function(){
		Thenjs(function(cont){vm.querySererTypes(cont);})
		.then(function(cont,args){
			mui.init({
				pullRefresh:{
					container:'.refreshContainer',
					down: { auto:true, contentrefresh:'数据加载中...', callback: vm.queryCosts }
				},
				swipeBack:true
			});
		});
	}
});
