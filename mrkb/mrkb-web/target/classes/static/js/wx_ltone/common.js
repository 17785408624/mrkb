// 获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if (r != null) return unescape(r[2]);
	return null; //返回参数值
}

// 时间戳转化为时间字符串
function formatDateTimeStr(DataTime, cod) {// 将13位数时间戳转换为字符串，cod为1显示时分秒
	var date = new Date(DataTime);// 创建时间对象，DataTime为13位时间戳
	var y = date.getFullYear();// 获取年份
	var m = date.getMonth() + 1;// 获取月份
	m = m < 10 ? ('0' + m) : m;// 月份不足10在前面加0
	var d = date.getDate();// 获取天数日期
	d = d < 10 ? ('0' + d) : d;// 天数不足10在前面加0
	switch (parseInt(cod)) {
    case 1:// 显示时分秒
		var h = date.getHours();
		h = h < 10 ? ('0' + h) : h;
		var minute = date.getMinutes();
		var second = date.getSeconds();
		minute = minute < 10 ? ('0' + minute) : minute;
		second = second < 10 ? ('0' + second) : second;
		return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;

		break;
	case 2:
		return y + '-' + m + '-' + d;
	default:
		return y + '-' + m + '-' + d;
		break;
	}

};

//手机号码验证
function isMobilePhone(mobilePhoneNumber){
	if(mobilePhoneNumber == null || mobilePhoneNumber == ''){
		$.alert("请填写手机号码..."); 
		return false;
	}else if(!(/^1[3456789]\d{9}$/.test(mobilePhoneNumber))){ 
        $.alert("手机号码有误，请重填...");  
        return false; 
    }else{
    	return true;
    };
};

//屏蔽表情
function isEmojiCharacter(substring) { 
 for ( var i = 0; i < substring.length; i++) {  
     var hs = substring.charCodeAt(i);  
     if (0xd800 <= hs && hs <= 0xdbff) {  
         if (substring.length > 1) {  
             var ls = substring.charCodeAt(i + 1);  
             var uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;  
             if (0x1d000 <= uc && uc <= 0x1f77f) {  
                 return true;  
             }  
         }  
     } else if (substring.length > 1) {  
         var ls = substring.charCodeAt(i + 1);  
         if (ls == 0x20e3) {  
             return true;  
         }  
     } else {  
         if (0x2100 <= hs && hs <= 0x27ff) {  
             return true;  
         } else if (0x2B05 <= hs && hs <= 0x2b07) {  
             return true;  
         } else if (0x2934 <= hs && hs <= 0x2935) {  
             return true;  
         } else if (0x3297 <= hs && hs <= 0x3299) {  
             return true;  
         } else if (hs == 0xa9 || hs == 0xae || hs == 0x303d || hs == 0x3030  
                 || hs == 0x2b55 || hs == 0x2b1c || hs == 0x2b1b  
                 || hs == 0x2b50) {  
             return true;  
         }  
     }  
 }  
}