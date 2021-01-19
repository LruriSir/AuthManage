//正则表达式截取url路径中的参数
function getQueryString(name){
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var url=decodeURI(decodeURI(window.location.search));	//获取返回路径
	var r=url.substr(1).match(reg);
	if(r!=null){
		return unescape(r[2]);
	}
	return null;
}

//点击登录按钮触发事件
function login(){
	var userName=$("#username").val();
	var password=$("#password").val();
	var yzm=$("#yzm").val();
	if(userName==null||userName==""){
		$("#massagers").html("用户名不能为空！");
	}else if(password==null||password==""){
		$("#massagers").html("密码不能为空！");
	}else if(yzm==null||yzm==""){
		$("#massagers").html("验证码不能为空！");
	}else{
		$("#form1").submit();
	}
}

//光标移开用户名文本框触发事件
$("#username").blur(function(){
	var userName=$("#username").val();
	if(userName!=null||userName!=""){
		$("#massagers").html("请输入账户信息");
	}
});

//光标移开密码框触发事件
$("#password").blur(function(){
	var password=$("#password").val();
	if(password!=null||password!=""){
		$("#massagers").html("请输入账户信息");
	}
});

//光标移开验证码框触发事件
$("#yzm").blur(function(){
	var yzm=$("#yzm").val();
	if(yzm!=null||yzm!=""){
		$("#massagers").html("请输入账户信息");
	}
});

//点击验证码图片触发事件
function loadImage(){
	$("#randImage").attr("src","images/image.jsp?"+Math.random());
}

//页面加载完毕后触发事件
$(function(){
	var userName=getQueryString("user_name");
	var error=getQueryString("error");
	var password=getQueryString("user_pwd");
	var yzm=getQueryString("yzm");
	if(error==1){
		$("#massagers").html("用户名或密码错误");
		$("#username").val(userName);
		$("#password").val(password);
		$("#yzm").val(yzm);
	}else if(error==2){
		$("#massagers").html("验证码错误");
		$("#username").val(userName);
		$("#password").val(password);
		$("#yzm").val(yzm);
	}
//页面回退刷新
$.post("userInfo/clearSession.action",{},function(result){});

});