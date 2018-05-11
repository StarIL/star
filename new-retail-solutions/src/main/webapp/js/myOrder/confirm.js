var pageUtils = new PageUtils('v1.0.0');
var vm = new Vue({
	el:'#placeInfo',
	data:{
    	baseURL: $('#hPath').val(),
    	orderData:{
    		servicesCate: 1,//服务大类：1、冻品海运；2、冻品空运；3、活鲜空运
    		importAgent: 1,//进口代理：1:贸易代理； 2、进口清关
    		warehouseAgent: false,//是否仓储
    	  	deliveryAgent: false,//是否送货
    	  	payImportTaxAgent: false,//是否垫付进口税费
    	 	cargoMortgageFinancingAgent: false,//是否货押融资
    	  	destinationId: "",
    	  	dischargePortId: 0,
    	  	dischargePortName: "",
    	  	financingPercent: 0,
    	  	startCountryId: 0,
    	  	startCountryName: "",
    	  	warehouseDeliveryAgent: false,
    	  	warehouseId: ""
    	},
    	wCityName:'',
    	warehouseName:'',
    	destinations:[],
    	dProvinceName:'',
    	dCtiyName:'',
    	dCountyName:'',
    	destinationName:'',
    	financingPercentName:'',
		selectDataObj:{
			ports:[],
			countrys:[],
			warehouses:[],
			names:[],
			provinces:[],
			citys:[],
			countys:[],
			destinations:[],
		},
		submitBtn:{//防止重复提交
			name:"立即下单",
			disabled:false,
		}
	},
	methods:{
		init:function(){
			vm.loadByUrl();
            vm.queryCountrys();
			vm.queryPorts();
			vm.queryWarehouses();
			vm.queryDestinations();
		},
		loadByUrl:function(){
            var servicesCate = pageUtils.queryString('cate');
            if (servicesCate) vm.orderData.servicesCate = Number(servicesCate);//ajaxData
            
            var importAgent = Number(pageUtils.queryString('i'));
            if (importAgent) vm.orderData.importAgent = Number(importAgent);//ajaxData
            
            var deliveryAgent = pageUtils.queryString('d');
            if (deliveryAgent) vm.orderData.deliveryAgent = deliveryAgent.bool();//ajaxData
            
            var warehouseAgent = pageUtils.queryString('w');
            if (warehouseAgent) vm.orderData.warehouseAgent = warehouseAgent.bool();//ajaxData
            
            var warehouseDeliveryAgent = pageUtils.queryString('wd');
            if (warehouseDeliveryAgent && warehouseDeliveryAgent.bool()){
                vm.orderData.warehouseDeliveryAgent = vm.orderData.deliveryAgent = vm.orderData.warehouseAgent = true;//ajaxData
            }
            var payImportTaxAgent = pageUtils.queryString('t');
            if (payImportTaxAgent) 
            	vm.orderData.payImportTaxAgent = payImportTaxAgent.bool();//ajaxData
            
            var cargoMortgageFinancingAgent = pageUtils.queryString('f');
            if (cargoMortgageFinancingAgent)
            	vm.orderData.cargoMortgageFinancingAgent = cargoMortgageFinancingAgent.bool();//ajaxData
            
		},
		//选择起运国
		chooseCountry:function(){
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.countrys); 
			picker.show(function (selectItems) {
				vm.orderData.startCountryId = selectItems[0].id;//ajaxData
				vm.orderData.startCountryName = selectItems[0].countryName;//ajaxData//showData
		  })
		},
		//选择目的港
		choosePort:function(){
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.ports); 
			picker.show(function (selectItems) {
				vm.orderData.dischargePortId = selectItems[0].id;//ajaxData
				vm.orderData.dischargePortName = selectItems[0].portName;//ajaxData//showData
			})
		},
		//选择仓库市
		chooselcCity:function(){
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.warehouses); 
			picker.show(function (selectItems) {
				vm.wCityName = selectItems[0].text;//showData
            	var warehouse =  _.find(vm.selectDataObj.warehouses, function (item) { return item.cityId == selectItems[0].cityId; });
            	if(warehouse){
            		_.each(warehouse.names,function(q){q.text = q.name;})
            		vm.selectDataObj.names = warehouse.names;//showData
            	};
			})
		},
		//选择仓库地址
		chooselc:function(){
			if(!vm.selectDataObj.names || vm.selectDataObj.names.length == 0){
				mui.toast("请选择仓库市");
				return;
			}
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.names); 
			picker.show(function (selectItems) {
				vm.orderData.warehouseId = selectItems[0].id;//ajaxData
				vm.warehouseName = selectItems[0].text;//showData
		  })
		},
		//选择省
		chooseProvince:function(){
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.provinces); 
			picker.show(function (selectItems) {
				vm.dProvinceName = selectItems[0].text;//showData
                vm.selectDataObj.citys = [];
                vm.selectDataObj.countys = [];
                vm.selectDataObj.destinations = [];
                var result = _.filter(vm.destinations, function (q) { return q.provinceId == selectItems[0].provinceId; });
                _.each(result, function (q) {
                    if (!_.some(vm.selectDataObj.citys, function (p) { return p.cityId == q.cityId; })) {
                        vm.selectDataObj.citys.push({ cityId: q.cityId, text: q.cityName  });//showData
                    }
                });
		  })
		},
		//选择市
		chooseCity:function(){
			if(!vm.selectDataObj.citys || vm.selectDataObj.citys.length == 0){
				mui.toast("请选择省");
				return;
			}
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.citys); 
			picker.show(function (selectItems) {
				vm.dCtiyName = selectItems[0].text;//showData
                vm.selectDataObj.countys = [];//showData
                vm.selectDataObj.destinations = [];//showData
                var result = _.filter(vm.destinations, function (q) { return q.cityId == selectItems[0].cityId; });
                _.each(result, function (q) {
                    if (!_.some(vm.selectDataObj.countys, function (p) { return p.countyId == q.countyId; })) {
                        vm.selectDataObj.countys.push({ countyId: q.countyId, text: q.countyName });//showData
                    }
                });
		  })
		},
		//选择区县
		chooseArea:function(){
			if(!vm.selectDataObj.countys || vm.selectDataObj.countys.length == 0){
				mui.toast("请选择市");
				return;
			}
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.countys); 
			picker.show(function (selectItems) {
				vm.dCountyName = selectItems[0].text;//showData
                vm.selectDataObj.destinations = [];//showData
                var result = _.filter(vm.destinations, function (q) { return q.countyId == selectItems[0].countyId; });
                _.each(result, function (q) {
                    if (!_.some(vm.selectDataObj.destinations, function (p) { return p.id == q.id; })) {
                        vm.selectDataObj.destinations.push({ id: q.id, text: q.destinationName });//showData
                    }
                });
		  })
		},
		//选择送货门点
		chooseDelivery:function(){
			if(!vm.selectDataObj.countys || vm.selectDataObj.countys.length == 0){
				mui.toast("请选择区县");
				return;
			}
			var picker = new mui.PopPicker();
			picker.setData(vm.selectDataObj.destinations); 
			picker.show(function (selectItems) {
				vm.orderData.destinationId = selectItems[0].id;//ajaxData
				vm.destinationName = selectItems[0].text;//showData
		  })
		},
		//选择融资比例
		chooseFinancing:function(){
			var picker = new mui.PopPicker();
			picker.setData([{value:'70',text:'70%'},{value:'60',text:'60%'},{value:'50',text:'50%'},{value:'40',text:'40%'}]); 
			picker.show(function (selectItems) {
				vm.orderData.financingPercent = selectItems[0].value;//ajaxData
				vm.financingPercentName = selectItems[0].text;//showData
		  })
		},
		//选择起运国
        queryCountrys: function () {
            mui.get(vm.baseURL + "/country/queryList", { isChina: false }, function (res) {
                if (res.success) {
                    vm.selectDataObj.countrys = res.data;
                }
            },'json');
        },
        //查询并组装港口和启运国
        queryPorts: function () {
        	mui.get(vm.baseURL + '/port/queryList', function (res) {
                if (res.success) {
                    if (vm.orderData.servicesCate == 1) { //海运
                        vm.selectDataObj.ports = _.filter(res.data, function (q) {
                        	q.text = q.portName;
                        	return q.portType == 1 || q.portType == 5; 
                        });
                    } else if (vm.orderData.servicesCate == 2 || vm.orderData.servicesCate == 3) { //空运
                        vm.selectDataObj.ports = _.filter(res.data, function (q) {
                        	q.text = q.portName;
                        	return q.portType == 2 || q.portType == 5; 
                        });
                    }
                }
            },'json');
        },
        //仓储初始数据
        queryWarehouses: function (callback) {
        	mui.get(vm.baseURL + '/warehouse/queryList', function (res) {
                if (res.success) {
                    vm.selectDataObj.warehouses = res.data;
                }
            },'json');
        },
        //门点
        queryDestinations: function (callback) {
        	mui.get(vm.baseURL + '/destination/queryList', function (res) {
                if (res.success && res.data) {
                    _.each(_.sortBy(res.data, 'provinceId'), function (q) {
                        if (!_.some(vm.selectDataObj.provinces, function (p) { return p.provinceId == q.provinceId; })) {
                            vm.selectDataObj.provinces.push({ provinceId: q.provinceId, text:q.provinceName});
                        }
                    });
                    vm.destinations = res.data;
                }
                if (typeof (callback) == "function")
                    callback();
            },'json');
        },
        validate:function(className){
        	var retVar = {success:true,msg:""}
        	mui("."+className).each(function() {
        		//若当前input为空，则alert提醒 
        		if(!this.value || this.value.trim() == "") {
        			retVar.msg = this.attributes.ex.value ? this.attributes.ex.value + "不允许为空" : "必填字段不能为空";
        			return retVar.success = false;
        		}
        	});
        	return retVar;
        },
        submit: function () { //建单(简易)
        	var validate = vm.validate("lSelect");
        	if(validate.success){
	            $.ajax({
	                url: vm.baseURL+'/myOrder/create',
	                type: 'POST',
	                contentType: "application/json",
	                data: JSON.stringify(vm.orderData),
	                beforeSend: function () {
	                    vm.submitBtn = { name: '建单中...', disabled: true };
	                },
	                success: function (res) {
	                	if(res.success){
	                		location.href = vm.baseURL + '/myOrder/success?tp=' + res.data;
	                	}else{
	                		mui.toast(res.msg);       		                 		
	                	}
	                    vm.submitBtn = { name: '立即询价', disabled: false };
	                }
	            })
        	}else{
				setTimeout(function(){
	        		mui.toast(validate.msg);  
				},100)
			}
        },
	}
});
vm.init();