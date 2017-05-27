var Reg = (function($) {
	return {
		/* 判断字符串是否为null */
		isBlank: function(str) {
			if(str != null || str != undefined || str.trim() != '' || str.length != 0) {
				return false;
			} else {
				return true;
			}
		},
		/*校验是否是整型*/
		isInteger: function(numStr,This) {
			var reg = new RegExp("^[0-9]*$");
			if(reg.test(numStr)){
				This.css('border','');
			}else{
				This.val('请输入数字');
				This.css('border','1px solid red');
			}
			/*return reg.test(numStr) ? true : This.val('请输入数字');
			This.css('border','1px solid red');;*/
			
		},
		/*校验一个字符中的内容是浮点数的数字*/
		isFloat: function(numStr,This) {
			var reg = new RegExp("^(-?\d+)(\.\d+)?");
			return reg.test(numStr) ? true : false;
		},
		/*判断是否是电话号码*/
		isTelePhone: function(telStr,This) {
			var reg = new RegExp("^(\(\\d{3,4}\)|\\d{3,4}-)?\\d{7,8}$");
//			return reg.test(telStr) ? true : console.log('电话号码错误');
			if(reg.test(telStr)){
				This.css('border','');
			}else{
				This.val('电话号码错误');
				This.css('border','1px solid red');
			}
		},
		/*校验一个字符串中的内容是否是手机号*/
		isPhoneNumber: function(phoneNumStr,This) {
			var reg = new RegExp("^(13|15|18)[0-9]{9}$");
//			return reg.test(phoneNumStr) ? true : console.log('手机号码错误');
			if(reg.test(phoneNumStr)){
				This.css('border','');
			}else{
				This.val('手机号码错误');
				This.css('border','1px solid red');
			}
			
		},
		/*校验邮箱*/
		isEmail: function(emailStr,This) {
			var reg = new RegExp("^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$");
//			return reg.test(emailStr) ? true : console.log('邮箱错误');
			if(reg.test(emailStr)){
				This.css('border','');
			}else{
				This.val('邮箱错误');
				This.css('border','1px solid red');
			}
		},
		/*判断是否是身份证*/
		isIDCard: function(IDCardStr,This) {
			var reg = new RegExp("^\\d{15}|\\d{}18$");
//			return reg.test(IDCardStr) ? true : console.log('身份证错误');
			if(reg.test(IDCardStr)){
				This.css('border','');
			}else{
				This.val('身份证错误');
				This.css('border','1px solid red');
			}
		}
	};
})(jQuery);
/**
 * 
 验证数字：^[0-9]*$ 
 验证n位的数字：^\d{n}$ 
 验证至少n位数字：^\d{n,}$ 
 验证m-n位的数字：^\d{m,n}$ 
 验证零和非零开头的数字：^(0|[1-9][0-9]*)$ 
 验证有两位小数的正实数：^[0-9]+(.[0-9]{2})?$ 
 验证有1-3位小数的正实数：^[0-9]+(.[0-9]{1,3})?$ 
 验证非零的正整数：^\+?[1-9][0-9]*$ 
 验证非零的负整数：^\-[1-9][0-9]*$ 
 验证非负整数（正整数 + 0） ^\d+$ 
 验证非正整数（负整数 + 0） ^((-\d+)|(0+))$ 
 验证长度为3的字符：^.{3}$ 
 验证由26个英文字母组成的字符串：^[A-Za-z]+$ 
 验证由26个大写英文字母组成的字符串：^[A-Z]+$ 
 验证由26个小写英文字母组成的字符串：^[a-z]+$ 
 验证由数字和26个英文字母组成的字符串：^[A-Za-z0-9]+$ 
 验证由数字、26个英文字母或者下划线组成的字符串：^\w+$ 
 验证用户密码:^[a-zA-Z]\w{5,17}$ 正确格式为：以字母开头，长度在6-18之间，只能包含字符、数字和下划线。 
 验证是否含有 ^%&',;=?$\" 等字符：[^%&',;=?$\x22]+ 
 验证汉字：^[\u4e00-\u9fa5],{0,}$ 
 验证Email地址：^\w+[-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$ 
 验证InternetURL：^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$ ；^[a-zA-z]+://(w+(-w+)*)(.(w+(-w+)*))*(?S*)?$ 
 验证电话号码：^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$：--正确格式为：XXXX-XXXXXXX，XXXX-XXXXXXXX，XXX-XXXXXXX，XXX-XXXXXXXX，XXXXXXX，XXXXXXXX。 
 验证身份证号（15位或18位数字）：^\d{15}|\d{}18$ 
 验证一年的12个月：^(0?[1-9]|1[0-2])$ 正确格式为：“01”-“09”和“1”“12” 
 验证一个月的31天：^((0?[1-9])|((1|2)[0-9])|30|31)$ 正确格式为：01、09和1、31。 
 整数：^-?\d+$ 
 非负浮点数（正浮点数 + 0）：^\d+(\.\d+)?$ 
 正浮点数 ^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$ 
 非正浮点数（负浮点数 + 0） ^((-\d+(\.\d+)?)|(0+(\.0+)?))$ 
 负浮点数 ^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$ 
 浮点数 ^(-?\d+)(\.\d+)?$
*/