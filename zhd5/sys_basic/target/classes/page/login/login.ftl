<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<link rel="stylesheet" type="text/css" href="${base}/css/font/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${base}/css/basic.css" />
<link rel="stylesheet" type="text/css" href="${base}/css/login.css" />

</head>
<body>

<div id="" class="login">
			<form name="f1" id="f1" method="post" >
				<div class="login_box">
					<h3>系统登录</h3>
					<ul>
						<li class="loginList">
							<span><i class="icon iconfont icon-qunzu"></i>用户名：</span>
							<input type="text" name="userId" id="" value="" />
						</li>
						<li class="loginList">
							<span><i class="icon iconfont icon-suo"></i>密码：</span>
							<input type="password" name="password" id="" value="" />
						</li>
						<li class="crandomCode">
							<input name="captcha" type="text"  placeholder="验证码"> 
							<img id="randomCode" src="../validateCodeServlet" border="0" onclick="reloadCode();"/>
							<span><a href="javascript:reloadCode();">看不清换一张</a></span>
						</li>
						<li class="btnlogin">
							<a href="javascript:void(0);" id="btnlogin"  class="btnbg">登录</a>
							<!--  <input name="btnlogin" type="submit" val="登陆" class="btnbg"/>  -->
							<input type="reset" name="" id="" class="reset" value="重置" />
						</li>
					</ul>
				</div>
			</form>
			<div class="bdp_bottom">CopyRight&copy;1997-2015 江苏智恒达钢盟科技有限公司</div>
		</div>


</body>
</html>
<script src="${base}/js/plugin/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${base}/js/plugin/md5.js" type="text/javascript" charset="utf-8"></script>
<script src="${base}/js/login/login.js" type="text/javascript" charset="utf-8"></script>