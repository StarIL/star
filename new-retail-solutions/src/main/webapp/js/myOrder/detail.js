var vm = new Vue({
	el:'#wapper',
	data:{
		baseURL:$('#hPath').val(),
		id:$('#hId').val(),
		showPage:false,
		
		units:[],
		currencys:[],
		paymentTerms:[],
		tradeTrems:[],
		billTypes:[],
		cny:{cnySum:0,list:[]},
		serverTypes:[],
		
		detail:{},
		plans:[],
		items:[],
		docs:[],
		
	},
	methods:{
		pulldownRefresh:function(){
			Thenjs(function (cont) {vm.queryDetail(cont); }) 
			.then(function(cont,arg){
				vm.queryPlan(cont);
				vm.queryCnys(cont)
				vm.queryBillTypes(cont);
			}).then(function(cont,arg){
				vm.queryItems(cont);
				vm.queryDocs(cont);
			});
		},
		queryDetail:function(callback){
			setTimeout(function(){
				mui.get(vm.baseURL + '/myOrder/queryDetail/'+ vm.id,function(res){
					vm.showPage = true;
					if(res.success){
						vm.detail = res.data;
					}
					if(typeof(callback) == 'function')
						callback();
				},'json');
				mui('.refreshContainer').pullRefresh().endPulldownToRefresh();
			},500);
		},
		queryItems:function(callback){
			vm.items = [];
			mui.get(vm.baseURL + '/myOrder/items/' + vm.id,function(res){
				if(res.success){
					vm.items = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryPlan:function(callback){
			vm.plans = [];
			mui.get(vm.baseURL + '/myOrder/plans/' + vm.id,{limit:1},function(res){
				if(res.success){
					vm.plans =  res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryDocs:function(callback){
			vm.docs = [];
			mui.get(vm.baseURL + '/myDoc/docs',{orderId:vm.id},function(res){
				if(res.success){
					vm.docs = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryCnys:function(callback){
			mui.get(vm.baseURL + '/mySettlement/queryCny',{orderId:vm.id},function(res){
				if(res.success){
					var data = res.data;
					vm.cny.cnySum = data.value0;
					vm.cny.list = [];
					_.each(data.value1,function(item){
						if(_.some(vm.cny.list,function(cny){ return cny.serverTypeId == item.serverTypeId;})){
							var server =_.find(vm.cny.list,function(cny){ return cny.serverTypeId == item.serverTypeId;});							
							server.cny += item.incomeAmountCny;
						}else{
							vm.cny.list.push({serverTypeId:item.serverTypeId,cny:item.incomeAmountCny});
						}
					});
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryUnits:function(callback){
			mui.get(vm.baseURL + '/unit/queryList',function(res){
				if(res.success){
					vm.units = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryCurrencys:function(callback){
			mui.get(vm.baseURL + '/currency/queryList',function(res){
				if(res.success){
					vm.currencys = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryPaymentTerms:function(callback){
			mui.get(vm.baseURL + '/paymentTerm/queryList',function(res){
				if(res.success){
					vm.paymentTerms = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryTradeTrems:function(callback){
			mui.get(vm.baseURL + '/tradeTerm/queryList',function(res){
				if(res.success){
					vm.tradeTrems = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryBillTypes:function(callback){
			mui.get(vm.baseURL + '/billType/queryList',function(res){
				if(res.success){
					vm.billTypes = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
		queryServerTypes:function(callback){
			mui.get(vm.baseURL + '/serverType/queryList',function(res){
				if(res.success){
					vm.serverTypes = res.data;
				}
				if(typeof(callback) == 'function')
					callback();
			},'json');
		},
	},
	filters:{
		renderService:function(order){
			var arr = [];
			if(order != undefined){
				if(order.importAgent == 1){
					arr.push('贸易代理');
				}else if(order.importAgent == 2){
					arr.push('进口清关');
				}
				if(order.deliveryAgent && !order.warehouseAgent){
					arr.push('送货');
				}else if(!order.deliveryAgent && order.warehouseAgent){
					arr.push('仓储');
				}else{
					arr.push('送货 + 仓储');
				}
				if(order.payImportTaxAgent){
					arr.push('应付关税融资');
				}
				if(order.cargoMortgageFinancingAgent){
					arr.push('货押融资');
				}
			}
			return arr.join('&nbsp;|&nbsp;');
		},
		renderStatus:function(value){
			return value == -10 ? '已关闭':value == 10 ? '受理中' :value == 20 ? '发货中':value == 30 ? '清关中':value == 40 ?'配送中':value == 50 ?'结算中':value == 60 ?'已结算':value == 70 ? '已完成':'待受理';
		},
		renderDate:function(value,formatString){
			return !value ? value : new Date(value).format(formatString);
		},
		renderUnit:function(value){
			if(_.some(this.units,function(unit){ return unit.id == value;})){
				var unit = _.find(this.units,function(unit){ return unit.id == value;});
				return unit.unitName;
			}
			return '';
		},
		renderCurrency:function(value){
			if(_.some(this.currencys,function(currency){ return currency.id == value;})){
				var currency = _.find(this.currencys,function(currency){ return currency.id == value;});
				return currency.currencyShortName;
			}
			return value;
		},
		renderTransactionMethod:function(value){
			if(_.some(this.tradeTrems,function(term){ return term.id == value;})){
				var term = _.find(this.tradeTrems,function(term){ return term.id == value;});
				return term.termName;
			}
			return '';
		},
		renderPaymentMethod:function(value){
			if(_.some(this.paymentTerms,function(term){ return term.id == value;})){
				var term = _.find(this.paymentTerms,function(term){ return term.id == value;});
				return term.termName;
			}
			return '';
		},
		renderBillType:function(value){
			if(_.some(this.billTypes,function(bill){ return bill.id == value;})){
				var bill = _.find(this.billTypes,function(bill){ return bill.id == value;});
				return bill.billName;
			}
			return '';
		},
		renderServerType:function(value){
			if(_.some(this.serverTypes,function(serverType){ return serverType.id == value;})){
				var serverType = _.find(this.serverTypes,function(serverType){ return serverType.id == value;});
				return serverType.serverName;
			}
			return '';
		}
	},
	created:function(){
		Thenjs.parallel([
			function (cont) { vm.queryUnits(cont); },
			function (cont) { vm.queryCurrencys(cont); },
			function (cont) { vm.queryPaymentTerms(cont); },
			function (cont) { vm.queryTradeTrems(cont); },
			function (cont) { vm.queryServerTypes(cont); }
		]).then(function(cont, arg){
			mui.init({
				pullRefresh:{
					container:'.refreshContainer',
					down: { auto:true, contentrefresh:'数据加载中...', callback: vm.pulldownRefresh }
				},
				swipeBack:true
			});
		});
		mui('.mui-scroll-wrapper').scroll();
		mui('body').on('tap', '#wapper a', function () {
		    document.location.href = this.href;
		});
	}
});
Date.prototype.format = function (formatStr) {
    var str = formatStr;
    var Week = ['日', '一', '二', '三', '四', '五', '六'];

    str = str.replace(/yyyy|YYYY/, this.getFullYear());
    str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));

    var month = this.getMonth() + 1;
    str = str.replace(/MM/, month > 9 ? month.toString() : '0' + month);
    str = str.replace(/M/g, month);

    str = str.replace(/w|W/g, Week[this.getDay()]);

    str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
    str = str.replace(/d|D/g, this.getDate());

    str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
    str = str.replace(/h|H/g, this.getHours());
    str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
    str = str.replace(/m/g, this.getMinutes());

    str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
    str = str.replace(/s|S/g, this.getSeconds());

    return str;
}
