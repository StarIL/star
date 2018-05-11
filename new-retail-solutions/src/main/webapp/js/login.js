var timerID;
var vm = new Vue({
	el:'#wapper',
	data:{
    	baseURL: $('#hPath').val(),
    	cSecond:30,
    	bizScope : 'WeChatLogin',
    	smsVerify:{ name: "发送验证码", disabled: true },
    	button:{ name: '绑定账号', disabled: false },
    	
    	reg:{ mobile: '', password: '', verifyCode: '' },
	},
	methods:{
		smsSend:function(){
			if(vm.isMobilePass()){
				vm.cSecond = 30;
				vm.smsVerify = { name: "重新发送(" + vm.cSecond + "s)", disabled: true };		
				mui.post(vm.baseURL + "/smsSend", {mobile:vm.reg.mobile,bizScope:vm.bizScope}, function (res) {
			    	if(res.success){
			    		timerID = setInterval(function () {
	                        if (--vm.cSecond > 0) {
	                            vm.smsVerify = { name: "重新发送(" + vm.cSecond + "s)", disabled: true };
	                        } else {		                        	
	                            clearInterval(timerID);
	                            vm.cSecond = 30;
	                            vm.smsVerify = { name: "发送验证码", disabled: false };
	                        }
	                    }, 1000);
			    	}else{
			    		vm.smsVerify = { name: "发送验证码", disabled: false };
			    		mui.toast(res.msg);
			    	}			    	
	            },'json');
			}
		},
		isMobilePass:function(){
			if(!vm.reg.mobile || vm.reg.mobile.length > 0 && !/^(13[0-9]|14[457]|15[0-35-9]|17[0345678]|18[0-9])[0-9]{8}$/.test(vm.reg.mobile)){
				mui.toast("请输入正确的手机号");
				return false;
			}
			return true;
		},
		submit:function(){			
			if(vm.isAllpass()){
				vm.button = { name: '登录中...', disabled: true };
				mui.ajax(vm.baseURL + '/bind',{
					data: JSON.stringify(vm.reg),
					dataType:'json',
					type:'POST',
					headers:{'Content-Type':'application/json'},	              
					success:function(res){
						vm.button = { name: '绑定账号', disabled: false };
	                	if(res.success){
	                		location.href = vm.baseURL + '/myAccount/';
	                	}else{
	                		mui.toast(res.msg); 
	                	}
					},
					error:function(xhr,type,errorThrown){
						vm.button = { name: '绑定账号', disabled: false };
						mui.toast("程序开小差了，请重试~~");
					}
				});
			}
		},
		toast:function(msg){
			setTimeout(function(){
				mui.toast(msg);
			},10);
		},
		isAllpass:function(){
			var reg = vm.reg;
			if(!reg.mobile || reg.mobile.length > 0 && !/^(13[0-9]|14[457]|15[0-35-9]|17[0345678]|18[0-9])[0-9]{8}$/.test(reg.mobile)){
				vm.toast('请输入正确的手机号');  
				return false;
			}
			if(!reg.password){
				vm.toast('请输入正确的密码'); 
				return false;
			}
			if(!reg.verifyCode){
				vm.toast('请输入正确的验证码');
				return false;
			}
			return true;
		}
	},
	watch:{
		'reg.mobile':  function (curVal, oldVal) {
			vm.smsVerify = { name: "发送验证码", disabled: true };
			if (curVal.length == 11) {
				vm.smsVerify.disabled = false;
			}
		}
	},
	created:function(){
		mui.init();
		mui('body').on('tap', '#wapper a', function () {
			document.location.href = this.href;
		});
	}
});
