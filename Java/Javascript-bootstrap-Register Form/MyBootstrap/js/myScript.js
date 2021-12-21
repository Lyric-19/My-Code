function isUserName() {
	var name = $("#userName").val;
	var msg = $("#nameMsg"); 
	if (name == null || name == '') { 
		msg.html = "用户名不能为空！"; 
		msg.css('color', "red"); 
		return false; 
	} 
	else if (/\w{5,}/.test(name)==false) { 
			msg.html = '用户名长度必须大于6！'; 
			msg.css('color', "red"); 
			return false; 
		} 
		msg.html = '用户名可用';
		msg.css('color','green'); 
		return true; 
	} 
function isPasswd() { 
	var password = $('#password').val; 
	var msg = $("#pwdMsg1"); 
	if (password == null || password == '') { 
		msg.html = "密码不能为空！"; 
		msg.css('color','red'); 
		return false;
	} 
	else if (password.length < 8) { 
		msg.innerHTML = '密码长度必须大于8！'; 
		msg.css('color','red'); 
		return false; 
	} 
	msg.html = '密码合法'; 
	msg.css('color','green'); 
	return true;
} 
function confirmPwd(){ 
	var pwd1 = $("#password").val ; 
	var pwd2 = $("#password2").val; 
	var msg = $("#pwdMsg2"); 
	if (pwd2 == null || pwd2 == '') { 
		msg.html = "请再次输入密码！";
		msg.css('color','red');
		return false; 
	} 
	else if (pwd1 != pwd2) {
		msg.html = '两次密码不一致，请重新输入密码'; 
		msg.css('color','red'); 167 return false; 
	} 
	msg.html = '两次密码一致'; 
	msg.css('color','green'); 
	return true; 
}
function register(){ 
	if(isUserName() && isPasswd() && confirmPwd()) { 
		return true; 
	}else {  
		window.alert("请检查用户名和密码是否规范"); 
		return false; 
	} 
}