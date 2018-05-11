var vm=new Vue({
	el:'#register',
	data:{
    	baseURL: $('#hPath').val(),
		bizScope : 'WeChatRegister',
		smsVerify:{ name: '发送验证码', disabled: true },
		button:{ name: '提交', disabled: false },
		
		reg:{ userName: '',mobile: '',password: '',confirmPassword: '',verifyCode: ''},
	},
	methods:{
		smsSend:function(){
			if(vm.isMobilePass(true)){
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
			    		vm.toast(res.msg);
			    	}
	            },'json');
			}
		},
		toast:function(msg){
			setTimeout(function(){
				mui.toast(msg);
			},10);
		},
		isMobilePass:function(isTips){
			if(!vm.reg.mobile || vm.reg.mobile.length > 0 && !/^(13[0-9]|14[457]|15[0-35-9]|17[0345678]|18[0-9])[0-9]{8}$/.test(vm.reg.mobile)){
				if(isTips) vm.toast("请输入正确的手机号");
				return false;
			}
			return true;
		},
        isAllPass:function(){
			if(!vm.reg.userName || vm.reg.userName.length > 0 && !/^[0-9a-zA-Z_]{6,16}$/.test(vm.reg.userName)){
				vm.toast('账号为6-16位字母数字');
				return false;
			}
			if(!vm.reg.mobile || vm.reg.mobile.length > 0 && !/^(13[0-9]|14[457]|15[0-35-9]|17[0345678]|18[0-9])[0-9]{8}$/.test(vm.reg.mobile)){
				vm.toast("请输入正确的手机号");
				return false;
			}
			if(!vm.reg.password || vm.reg.password.length > 0 && !/^[a-zA-Z0-9]{6,18}$/.test(vm.reg.password)){
				vm.toast('密码为6-18位字母数字');
				return false;
			}else if(vm.reg.confirmPassword != vm.reg.password){
				vm.toast('两次输入密码不一致');
				return false;
			}
			if(!vm.reg.verifyCode || vm.reg.verifyCode.length > 0 && !/^\d{0,6}$/.test(vm.reg.verifyCode)){
				vm.toast('验证码为6位数字');
				return false;
			}
			return true;
        },
        sumbmit:function(){
			if(vm.isAllPass()){
				vm.button = { name: '提交中...', disabled: true };
				mui.ajax(vm.baseURL + '/registerSubmit',{
					data: JSON.stringify(vm.reg),
	                dataType:'json',
	                type: 'POST',	               
	                headers:{'Content-Type':'application/json'},
	                success: function (res) {
	                	vm.button = { name: '提交', disabled: false };
	                	if(res.success){
				    		location.href = vm.baseURL + "/regCorp?t=" + res.data;
	                	}else{
	                		mui.toast(res.msg);	                 		
	                	}
	                },
	                error:function(xhr,type,errorThrown){
						vm.button = { name: '提交', disabled: false };
						vm.toast("程序开小差了，请重试~~");
					}
	            });
			}
		}
	},
	watch:{
      	'reg.mobile':function(curVal,oldVal){
      		vm.smsVerify.disabled = true;
			if(vm.isMobilePass(false)){
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
