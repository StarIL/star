var vm = new Vue({
	el:'#wapper',
	data:{
		baseURL:$('#hPath').val(),
		id:$('#hId').val(),
		
		docs:[],
	},
	methods:{
		queryDocs:function(callback){
			setTimeout(function(){
				mui.get(vm.baseURL + '/myDoc/docs',{orderId:vm.id},function(res){
					if(res.success && res.data){						
						vm.queryBillTypes(res.data);
					}
					if(typeof callback == 'function')
						callback();
				},'json');
				mui('#refreshContainer').pullRefresh().endPulldownToRefresh();
			},200);
		},
		queryBillTypes:function(origins){
			mui.get(vm.baseURL + '/billType/queryList',function(res){
				if(res.success){
					_.each(origins,function(origin){
						if(_.some(res.data,function(q){ return q.id == origin.billId;})){
							var billType = _.find(res.data,function(q){return q.id == origin.billId});
	                    	origin.billName = billType.billName;
						}
                    })
					vm.docs = origins;
				}
			},'json');
		},
		del:function(item){
			mui.confirm('是否确定删除？','提示',['否', '是'],function(e){
				if(e.index == 1){
					mui.get(vm.baseURL + '/myDoc/up/' + item.id,function(res){
						if(res.success){
							vm.queryDocs(function(){
								//mui.toast('删除成功');
							});
						}else{
							mui.toast(res.msg);
						}
					},'json');
				}
			});			
		},
		//打开按钮
		showPhoto:function(item){
			if(item.billFileUrl == ''){
				mui.toast('您还没有上传文件');
			}else{
				mui.openWindow(item.billFileUrl);
			}
		}
	},
	filters:{
		renderDate:function(value,formatString){
			return !value ? '-' : new Date(value).format(formatString);
		},
		renderStatus:function(value){
			return value == 10 ? '审核' : '';
		},
		renderOper:function(value){
			return !value ? '-' : value;
		}
	},
	created:function(){
		mui.init({
			pullRefresh:{
				container:'#refreshContainer',
				down: { auto:true, contentrefresh:'数据加载中...', callback: this.queryDocs }
			},
			swipeBack:true
		});
		
//		mui('.mui-scroll-wrapper').scroll();
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