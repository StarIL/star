var viewApi = mui('#views').view({
    defaultPage: '#retrieveFirst'
});
var vm=new Vue({
	el:'#wapper',
	data:{
    	baseURL: $('#hPath').val(),
    	retieveToken : null,
	  	bizScope : 'WeChatRetrievePwd',
    	smsVerify:{ name: '发送验证码', disabled: true },
    	button:{ name: '下一步', disabled: false },
    	confirm:{ name: '确认', disabled: false },
    	cSecond : 30,
    	
    	ret:{mobile: '',verifyCode: '' },
    	sec:{ password: '', confirmPassword: ''}
	},	
	methods:{
		smsSend:function(){
			if(vm.isMobilePass(true)){
				vm.cSecond = 30;
				vm.smsVerify = { name: "重新发送(" + vm.cSecond + "s)", disabled: true };		
				mui.post(vm.baseURL + "/smsSend", {mobile:vm.ret.mobile,bizScope:vm.bizScope}, function (res) {
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
		smsNextSubmit:function(){
			if(vm.isAllPass()){
				vm.button = { name: '提交中...', disabled: true };
				mui.post(vm.baseURL + "/uptPwdVerify", {mobile:vm.ret.mobile,bizScope:vm.bizScope,verifyCode:vm.ret.verifyCode}, function (res) {
					vm.button = { name: '下一步', disabled: false };
			    	if(res.success){
			    		vm.retieveToken = res.data;//第二步token存储
						viewApi.go('#retrieveSec');
			    	}else{
			    		vm.toast(res.msg);
			    	}
	            },'json');
			}
		},
		isMobilePass:function(isTips){
			if(!vm.ret.mobile || vm.ret.mobile.length > 0 && !/^(13[0-9]|14[457]|15[0-35-9]|17[0345678]|18[0-9])[0-9]{8}$/.test(vm.ret.mobile)){
				if(isTips) vm.toast("请输入正确的手机号");
				return false;
			}
			return true;
		},
		isAllPass:function(){
			if(!vm.ret.mobile || vm.ret.mobile.length > 0 && !/^(13[0-9]|14[457]|15[0-35-9]|17[0345678]|18[0-9])[0-9]{8}$/.test(vm.ret.mobile)){
				vm.toast("请输入正确的手机号");
				return false;
			}
			if(!vm.ret.verifyCode){
				vm.toast("请输入验证码");
				return false;
			}
			return true;
		},		
		isPwdPass:function(){
			if(!vm.sec.password || vm.sec.password.length > 0 && !/^[a-zA-Z0-9]{6,18}$/.test(vm.sec.password)){
				vm.toast('密码为6-18位字母数字');
				return false;
			}else if(vm.sec.password != vm.sec.confirmPassword){
				vm.toast('两次输入密码不一致');
				return false;
			}
			return true;
		},
		confirmSubmit:function(){
			if(vm.isPwdPass()){
				vm.confirm = { name: '提交中...', disabled: true };
				mui.post(vm.baseURL + "/uptPwd", { password:vm.sec.password,token:vm.retieveToken }, function (res) {
					vm.confirm = { name: '确认', disabled: false };
					if(res.success){
			    		location.href = vm.baseURL + "/login/";
			    	}else{
			    		mui.toast(res.msg);
			    	}
	            },'json');
			}
		},
		toast:function(msg){
			setTimeout(function(){
				mui.toast(msg);
			},10);
		},
	},
	watch:{
      	'ret.mobile':function(curVal,oldVal){
      		vm.smsVerify.disabled = true;
			if(vm.isMobilePass(false)){
				vm.smsVerify.disabled = false;
			}
      	},
	},
	created:function(){
		mui.init();
	}
});