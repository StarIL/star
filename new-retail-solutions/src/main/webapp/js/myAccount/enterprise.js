//注册企业1页面
var viewApi = mui('#views').view({
    defaultPage: '#enterpriseFirst'
});
var vm = new Vue({
	el:'#wapper',
	data:{
		baseUrl:$('#hPath').val(),
		retieveToken : null,
		bizScope : 'WeChatRetrievePwd',
		smsVerify:{name: '发送验证码', disabled: true },
		button:{ name: '下一步', disabled: false },
    	confirm:{ name: '确认', disabled: false },
    	reg:{ userName: '',mobile: '',password: '',confirmPassword: '',verifyCode: ''},
	},
	methods:{
		init:function(){
		},
		smsNextSubmit:function(){
			viewApi.go('#enterprise');
		},
		
		smsSend:function(){
			if(vm.isMobilePass(true)){
				vm.cSecond = 30;//30秒倒计时
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
//		手机号码验证
			isMobilePass:function(isTips){
			if(!vm.reg.mobile || vm.reg.mobile.length > 0 && !/^(13[0-9]|14[457]|15[0-35-9]|17[0345678]|18[0-9])[0-9]{8}$/.test(vm.reg.mobile)){
				if(isTips) vm.toast("请输入正确的手机号");
				return false;
			}if(!vm.reg.password||vm.reg.password.length>0&&!/^[a-zA-Z0-9]{6,18}$/.test(vm.reg.password)){
				vm.toast('密码为6-18位字母数字');
				return false;
			}
			return true;
		},
		
	}
});
vm.init();
