
$('#btnlogin').on('click',function(){
	var _button=$(this);
	checkForm(_button);
	return false
});
function checkForm(_button) {
	_button.disabled = "disabled";
	var form = document.getElementById("f1");
	var userId = form.userId.value;
	var password = form.password.value;
	var captcha = form.captcha.value;
	 if(userId.trim() == "") {
		alert("请输入用户名!");
		_button.disabled = false;
		form.name.focus();
		return;
	}
	if(password == "") {
		alert("请输入密码!");
		_button.disabled = false;
		form.password.focus();
		return;
	}
	if(captcha.trim() == "") {
		alert("请输入验证码!");
		_button.disabled = false;
		form.checkInput.focus();
		return;
	}
	 
	
	var bean = {};
	bean['userId'] = userId;
	bean['password'] = hex_md5(password);
	bean['captcha'] = captcha;
	 $.ajax({
         type: "POST",
         url: "checkLogin",
         data:bean,
         success: function(msg,status){
//        	 var res=eval("("+ msg +")");
        	 var res=JSON.parse(msg);
        	 var errmsg=res.errmsg;
        	 if(errmsg == null){
        		 window.location.href ="/index";
        	 }else {
					reloadCode();
					alert(errmsg);
				}
	 
         }
      }); 
	 //_button.disabled = false;
};
function reloadCode(){
	var form=document.getElementById("f1");
	form.captcha.focus();
    form.captcha.value="";
	var verify = document.getElementById('randomCode');
    verify.setAttribute('src', '../validateCodeServlet?dt=' + Math.random());
};

document.onkeydown = function() {
	if(event.keyCode == 13) {
		checkForm(document.getElementById("btnlogin"))
	}
};
String.prototype.trim = function() {
	return this.replace(/(^\s*)(\s*$)/g, "");
}