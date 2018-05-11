var vm = new Vue({
	el:'#wapper',
	data:{
		baseURL:$('#hPath').val(),	
		id:$('#hId').val(),
		showLoading:false,
		button:{name:"保存", disabled:false},
		billTypes:[],
		billName:'',
		doc:{
			orderId:$('#hId').val(),
			billId:null, 
			billFileUrl:'', 
			billFileName:'', 
			billNo:''
		}
	},
	methods:{
		//上传图片
		uploadInit:function(){
			new AjaxUpload($("#files"),{
    			action:vm.baseURL + '/aliyun/upload',
    			responseType: 'json',
    			name: 'files',
    			data:{},
    			onSubmit:function(file, ext){
    				vm.showLoading = true;
    			},
       			onComplete:function(file, res){
       				vm.showLoading = false;
       				if (res.success) {
       					var file = res.data[0];
       					vm.doc.billFileName = file.fileName;
       					vm.doc.billFileUrl = file.filePath;
    	            }else {
    	                mui.toast(res.msg);
    	            }
       			}
    		});
		},
		queryBillTypes:function(){
			setTimeout("vm.uploadInit()",100);
			mui.get(this.baseURL + '/billType/queryList',function(res){
				if(res.success){
					vm.billTypes = _.each(res.data,function(q){q.text = q.billName;});
                }
			},'json');
		},
		billPicker:function(){
			var picker = new mui.PopPicker();
			picker.setData(vm.billTypes); 
			picker.show(function (selectItems) {
				var billType = _.first(selectItems);
			    vm.billName = billType.text;
			    vm.doc.billId = billType.id;
		  	});
		},
		isAllPass:function(){
			if(!vm.doc.billId){
				vm.toast('请选择文件类型');
				return false;
			}
			if(!vm.doc.billNo){
				vm.toast('请输入单据编号');
				return false;
			}
			if(!vm.doc.billFileName || !vm.doc.billFileUrl){
				vm.toast('请上传图片');
				return false;
			}
			return true;
		},
		toast:function(msg,callback){
			setTimeout(function(){
				mui.toast(msg);
			},10);
			
			if(typeof callback == 'function')
				callback();
		},
		save:function(){
			if(vm.isAllPass()){
				vm.button = {name:'保存中...',disabled:true};
				mui.ajax(vm.baseURL + '/myDoc/save',{
					dataType:'json',				
					type:'POST',
		    		data:JSON.stringify(vm.doc),
		    		headers:{'Content-Type':'application/json'},
		    		success:function(res){
		    			vm.button = {name:'保存',disabled:false};
		    			if(res.success){
		    				vm.toast('保存成功',function(){
		    					location.href = vm.baseURL + '/myDoc/?id=' + vm.id;
		    				});
		    			}else{
		    				vm.toast(res.msg);
		    			}
		    		},
		    		error:function(xhr,type,errorThrown){
		    			vm.button = {name:'保存',disabled:false};
		    			vm.toast("程序开小差了，请重试~~");
		    		}
				});
			}
		},
	},
	filters:{
		renderImgSrc:function(value){
			if(!value || value == undefined){
    			return '../images/wechat_upload.jpg';
    		}
    		return value;
		},
	},
	created:function(){
		this.queryBillTypes();
	}
});
