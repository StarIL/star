var numberPass = {
	    /**
		* @name 构造函数
		* @param obj 输入框标识
		* @param regExp 输入框允许输入类型的正则表达式（格式：/[正则表达式]/g）
		*/
	 "numberPassEvent": function (obj,regExp) {
	    $("body").on("propertychange input", obj, function () {
	        numberPassFn($(this),regExp);
	  })
	  var numberPassFn = function (obj,regExp) {
	       $(obj).val($(obj).val().replace(regExp, ''));
	      var value = $(obj).val();
	      if ((value) == 0) value = '';
	      $(obj).val(value);
	   }
	},
	"numberPassUnbindEvent": function (obj) {
	    $("body").off("keyup contextmenu propertychange input", obj);
	}
}
/**
* 调用Demo var pageUtils=new PageUtils("V1.1");
* pageUtils.newGuid();
*/
var PageUtils = (function () {
    /**
    * @name 构造函数
    * @param {Object} v 未知参数1
    */
    function PageUtils(v) {
        this._v0 = v;
    }
    /**
     * 调试日志
     * @param  {String} str 打印的字符串
     * @return {Void}
     */
    PageUtils.prototype.debuglog = function (str) {
        var that = this;
        var err;
        try {
            if (typeof str === 'object' && str.hasOwnProperty('stack') && str.hasOwnProperty('message')) {
                str = "" + str.message + "\n\n" + str.stack;
            }
            if ($.isFunction(str)) {
                str = str.toString();
            }
            that.safeFunc(function () {
                console.log(str);
            });
        } catch (_error) {
            err = _error;
            that.safeFunc(function () {
                console.log(err);
            });
        }
    }
    /**
     * 安全执行方法
     * @param  {Func} func 匿名函数
     * @return {void}
     */
    PageUtils.prototype.safeFunc = function (func) {
        try { func(); } catch (err0) { }
    }
    /**
     * 生成guid
     * @return {String}
     */
    PageUtils.prototype.newGuid = function () {
        var guid = "";
        for (var i = 1; i <= 32; i++) {
            var n = Math.floor(Math.random() * 16.0).toString(16);
            guid += n;
            if ((i == 8) || (i == 12) || (i == 16) || (i == 20))
                guid += "-";
        }
        return guid;
    }
    /**
     * 延迟加载js
     * @param  {String} Url
     * @param  {Func} 回调函数
     * @return {void}
     */
    PageUtils.prototype.loadjs = function (file, func) {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = file;
        document.getElementsByTagName("head")[0].appendChild(script);
        if (script.readyState) { //IE
            script.onreadystatechange = function () {
                if (script.readyState == "loaded" || script.readyState == "complete") {
                    script.onreadystatechange = null;
                    func();
                }
            };
        } else { //Others
            script.onload = function () {
                func();
            };
        }
        return false;
    }
    /**
     * 倒计时
     * @param  {DOM} obj 操作对象的id
     * @param  {Integer} second 间隔时间
     * @param  {String} uniqueClass 唯一的class
     * @param  {String} tip 文字提示
     * @param  {String} funcName 业务名称
     * @param  {Object} options Cookie设置项
     * @return {void}
     */
    PageUtils.prototype.remainTime = function (obj, second, uniqueClass, tip, funcName, options) {
        var that = this;
        var $obj = null;
        if (second == undefined) second = 90;
        if (uniqueClass == undefined) {
            uniqueClass = that.newGuid();
            $obj = $(obj);
            $obj.addClass(uniqueClass).attr("disabled", true).attr("sourceval", $obj.attr("value"));
            $(window).keydown(function (e) {
                if (e.which == 116) {
                    return false;
                }
            });
        } else {
            $obj = $("." + uniqueClass);
        }
        if (second > 0) {
            $obj.val(second + (tip || "秒后重新获取"));
            second = second - 1;
            //var code = "remainTime(null," + second + ",'" + uniqueClass + "')";
            setTimeout(function () {
                options = options || {};
                if (funcName === null) {
                    funcName = 'reg_mobile_remainTime';
                }
                var expires = '';
                if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
                    var date;
                    if (typeof options.expires == 'number') {
                        date = new Date();
                        date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
                    } else {
                        date = options.expires;
                    }
                    expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
                }
                var path = options.path ? '; path=' + options.path : '';
                var domain = options.domain ? '; domain=' + options.domain : '';
                var secure = options.secure ? '; secure' : '';
                document.cookie = [funcName, '=', encodeURIComponent('' + second), expires, path, domain, secure].join('');
                that.remainTime(null, second, uniqueClass, tip, funcName, options);
            }, 1000);
        } else {
            $(window).unbind("keydown");
            $obj.removeClass(uniqueClass);
            $obj.attr("value", $obj.attr("sourceval"));
            $obj.removeAttr("disabled");
        }
    }

    PageUtils.prototype.isNumber = function (obj) {
        return !isNaN(parseFloat(obj)) && isFinite(obj);
    }

    PageUtils.prototype.isInteger = function (obj) {
        return obj % 1 === 0;
    }
    PageUtils.prototype.mainPageResize = function () {
        var docHeight = $(window).height();
        $('.scrollbar').height(docHeight - 46);
    }
    PageUtils.prototype.formatMoney = function(money, digit){
    	var tpMoney = '0.00';
    	if(money != undefined) tpMoney = money;  
    	
    	tpMoney = new Number(tpMoney);
    	if(isNaN(tpMoney)) return '0.00';
    		
    	tpMoney = tpMoney.toFixed(digit);
    	var regexp = /^(-?\d+)(\d{3})(\.?\d*)/;
    	while(regexp.test(tpMoney)){  
    		tpMoney = tpMoney.replace(regexp,"$1,$2$3"); 
    	}
    	return tpMoney;  
    }
    PageUtils.prototype.queryString = function(key) {
        var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }
    return PageUtils;
})();

String.prototype.bool = function() { 
    return (/^true$/i).test(this);
}; 

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

/** 
*js中更改日期  
* y年， m月， d日， h小时， n分钟，s秒  
*/  
Date.prototype.add = function (part, value) {  
    value *= 1;  
    if (isNaN(value)) {  
        value = 0;  
    }  
    switch (part) {  
        case "y":  
            this.setFullYear(this.getFullYear() + value);  
            break;  
        case "m":  
            this.setMonth(this.getMonth() + value);  
            break;  
        case "d":  
            this.setDate(this.getDate() + value);  
            break;  
        case "h":  
            this.setHours(this.getHours() + value);  
            break;  
        case "n":  
            this.setMinutes(this.getMinutes() + value);  
            break;  
        case "s":  
            this.setSeconds(this.getSeconds() + value);  
            break;  
        default:  
   
    }  
}

function UrlSearch() {
    var qs = (location.search.length > 0 ? location.search.substring(1) : ""); //去除？
    args = {},
    items = qs.length ? qs.split("&") : [];
    item = null,
    name = null,
    value = null,
    i = 0,
    len = items.length;
    for (i = 0; i < len; i++) {
        item = items[i].split('=');
        name = decodeURIComponent(item[0]);
        value = decodeURIComponent(item[1]);
        if (name.length) {
            args[name] = value;
        };
    }
    return args;
}
var validateCommon = {
	showObjectTestRemind:function(msg){
		var msgObj = JSON.parse(msg);
		if(msgObj.name!=undefined && msgObj.errMsg!=undefined){
			$(msgObj.name).testRemind(msgObj.errMsg);
		}
	},
	showArrayTestRemind:function(msg){
		var msgObj = JSON.parse(msg);
		for (var i = 0; i < msgObj.length; i++) {
			if(msgObj[i].name!=undefined && msgObj[i].errMsg!=undefined){
				$(msgObj[i].name).testRemind(msgObj[i].errMsg);
			}
		}
	}
}