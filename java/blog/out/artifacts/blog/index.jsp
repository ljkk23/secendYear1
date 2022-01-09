<%@ page pageEncoding="UTF-8" %>
<%@ page import="lj.*" %>
<!doctype html>
<html  lang="en">

    <head>
        <!-- meta data -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!--font-family-->
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext" rel="stylesheet">

        <!-- title of site -->
        <title>Sign in</title>

        <!-- For favicon png -->
		<link rel="shortcut icon" type="image/icon" href="assets/logo/favicon.png"/>

        <!--font-awesome.min.css-->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

		<!--animate.css-->
        <link rel="stylesheet" href="assets/css/animate.css">

        <!--bootstrap.min.css-->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

		<!-- bootsnav -->
		<link rel="stylesheet" href="assets/css/bootsnav.css" >

        <!--style.css-->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--responsive.css-->
        <link rel="stylesheet" href="assets/css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

        <!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
	</head>

	<body οnlοad="getCookie();"><!--为什么在这里设置不可以-->


		<!-- signin end -->
		<section class="signin">
			<div class="container">

				<div class="sign-content">
					<h2>登录</h2>

					<div class="row">
						<div class="col-sm-12">
							<div class="signin-form">
								<form action="./login">
									<div class="form-group">
									    <label>用户名</label>
									    <input type="text" class="form-control" id="zhanghao" placeholder="请输入正确的用户名" name="username">
									</div><!--/.form-group -->
									<div class="form-group">
										<label >密码</label>
									    <input type="password" class="form-control"  id="mima" placeholder="请输入密码" name="pass">
										<span id="pass"></span>
									</div><!--/.form-group -->
									<div>
										<label for="signin_form">验证码</label>
										<input type='text' name='code'  value=''>
										<br>
										<img src="./yanzheng" />
										<span id="code"></span>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<div class="signin-footer">
												<button  class="btn signin_btn" id="denglu">
													登录
												</button>
											</div><!--/.signin-footer -->
										</div><!--/.col-->
									</div><!--/.row -->

									<div class="row">
										<div class="col-sm-12">
											<div class="signin-password">
												<div class="awesome-checkbox-list">
													<ul class="unstyled centered">

														<li>
															<input class="styled-checkbox" id="styled-checkbox-2" type="checkbox" value="value2" name="jizhu">
															<label for="styled-checkbox-2">记住密码</label>
														</li>

													</ul>
												</div><!--/.awesome-checkbox-list -->
											</div><!--/.signin-password -->
										</div><!--/.col -->
									</div><!--/.row -->

								</form><!--/form -->
							</div><!--/.signin-form -->
						</div><!--/.col -->
					</div><!--/.row -->
					


					<div class="row">
						<div class="col-sm-12">
							<div class="signin-footer">
								<button type="button" class="btn signin_btn" data-toggle="modal" data-target=".signin_modal">
								注册
								</button>
							</div><!--/.signin-footer -->
						</div><!--/.col-->
					</div><!--/.row -->

				</div><!--/.sign-content -->

				<!-- modal part start -->
				<div class="modal fade signin_modal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="sign-content">

							<div class="modal-header">
								<h2>注册</h2>
							</div><!--/.modal-header -->

							<div class="modal-body">
								<div class="signin-form">
									<div class=" ">
										<div class=" ">
											<form action="./register" onsubmit="return check()">
												<div class="form-col" style="width: 620px;">
													<div class="form-group">
														<label >用户名</label>
														<input type="text" class="form-control" id="registerName" placeholder="用户名" name="username">
													</div><!--/.form-group -->
												</div><!--/.form-col -->
												<div class="form-group">
													<label>密码</label>
													<input type="password" class="form-control" id="registerPass" placeholder="密码" name="pass">
												</div><!--/.form-group -->
												<div class="form-group">
													<label>确认密码</label>
													<input type="password" class="form-control" id="registerPass2" placeholder="确认密码">
												</div><!--/.form-group -->
												<div class="signin-footer">
													<button type="submit" class="btn signin_btn">
														注册									</button>
													<p>
														已经是会员 ?
														<a href="index.jsp">登录</a>										</p>
												</div>
											</form><!--/form -->
										</div><!--/.col -->
									</div><!--/.row -->
								</div><!--/.signin-form -->

								<div class="signin-password">
									<div class="awesome-checkbox-list">
										<ul class="unstyled centered">

											<li></li>
										</ul>
									</div><!--/.awesome-checkbox-list -->
								</div><!--/.signin-password -->

								<!--/.signin-footer -->
							</div><!--/.modal-body -->
						</div><!--/.sign-content -->
					</div><!--/.modal-content -->
				</div><!--/.modal-dialog -->
			</div><!--/.modal -->
			</div><!--/.container -->

		</section><!--/.signin -->
		
		<!-- signin end -->

		<!--footer copyright start -->
		<footer class="footer-copyright">
			<div id="scroll-Top">
				<i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
			</div><!--/.scroll-Top-->

		</footer><!--/.hm-footer-copyright-->
		<!--footer copyright  end -->

		<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
		<script src="https://cdn.bootcdn.net/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>




<%--		登录有关的script--%>
		<script>
			//var loginurl="http://localhost:8088/register";
			$("#denglu").click(function(){
				login();
				console.log("进入");
			});
			//设置cookie
			function setCookie(){
				var loginCode = $("#zhanghao").val(); //获取用户名信息
				var pwd = $("#mima").val(); //获取登陆密码信息
				var checked = $("input[type='checkbox']").is(':checked');//获取“是否记住密码”复选框
				//console.log("setCookie方法是否记住密码："+checked);
				if(checked){ //判断是否选中了“记住密码”复选框
					//设置cookie过期时间
					var date = new Date();
					date.setTime(date.getTime()+60*60000*48);//只能这么写，表示48小时
					window.alert("记住密码时间为：两天");
					$.cookie("login_code",loginCode,{ expires: date, path: '/' });//调用jquery.cookie.js中的方法设置cookie中的用户名
					$.cookie("pwd",pwd,{ expires: date, path: '/' });//调用jquery.cookie.js中的方法设置cookie中的登陆密码，并使用base64（jquery.base64.js）进行加密
				}else{
					$.cookie("login_code", null);
					$.cookie("pwd", null);
				}
			}

			//清除所有cookie函数
			function clearAllCookie() {
				var date=new Date();
				date.setTime(date.getTime()-60000);
				var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
				if (keys) {
					for (var i =  keys.length; i--;)
						document.cookie=keys[i]+"=0; expire="+date.toGMTString()+"; path=/";
				}
			}

			//获取cookie
			function getCookie(){
				var loginCode = $.cookie("login_code"); //获取cookie中的用户名
				var pwd =  $.cookie("pwd"); //获取cookie中的登陆密码
				console.log("获取cookie:账户："+loginCode);
				console.log("获取cookie:密码："+pwd);
				if (!loginCode||loginCode==0) {
					console.log("账户："+!loginCode);
					//alert("请输出内容！");
				}else{
					$("#zhanghao").val(loginCode);
				}
				if(!pwd||pwd==0){
					console.log("密码："+!pwd);
				}else{
					//密码存在的话把密码填充到密码文本框
					//console.log("密码解密后："+$.base64.decode(pwd));
					$("#mima").val(pwd);
					//密码存在的话把“记住用户名和密码”复选框勾选住
					$("[name='jizhu']").attr("checked","true");
				}

			}
			function login(){
				var userName = $('#zhanghao').val();
				console.log("用户名："+userName);
				if(userName == ''){
					alert("请输入用户名。");
					return;
				}
				var userPass =$('#mima').val();
				console.log("密码："+userPass);
				if(userPass == ''){
					alert("请输入密码。");
					return;
				}
				//判断是否选中复选框，如果选中，添加cookie
				var jizhupwd=$("input[type='checkbox']").is(':checked');
				console.log("是否记住密码："+jizhupwd);
				if(jizhupwd){
					//添加cookie
					setCookie();
				}else{
					clearAllCookie();
				}
			}

			// 密码或者验证码错误的情况
			function getUrlParam(name) {
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
				var r = window.location.search.substr(1).match(reg);  //匹配目标参数
				if (r != null) return unescape(r[2]);
				return null; //返回参数值
			}
			function wrongInfo(itemId){
				if (itemId=="pass") {
					console.log("pass error");
					$("#pass").text("密码错误！");
				}
				if (itemId=="code") {
					$("#code").text("验证码错误！");
				}
			}

			function check(){
				var pass=getUrlParam("pass");
				var code=getUrlParam("code");
				var regist=getUrlParam("noRegist");
				if (pass!=null){
					wrongInfo(pass);
				}
				if (code!=null){
					wrongInfo(code)
				}
				if (regist!=null){
					alert("用户名错误或者没有该用户")
				}

			}
		</script>
		<script>
			window.onload=getCookie();
			window.onload=check();
		</script>
<%--	注册有关的script--%>
	<script>
		function checkusrn() {
			var check = false;
			var username = document.getElementById("registerName").value;
			if (username.length > 10) {
				//document.getElementById("checktext1").innerHTML = "  × 不要多于10位";
				window.alert("用户名长度不能大于10！");
				check = false;
			} else if (username.length==0){
				//document.getElementById("checktext1").innerHTML = "  × 不能为空！";
				window.alert("用户名不能为空！");
				check = false;

			} else{
				check = true;
			}
			return check;
		}
		function checkpwd() {
			var check = false;
			var password = document.getElementById("registerPass").value;
			if (password.length < 6) {
				window.alert("密码不能小于6！");
				check = false;
			}else if (password.length ==0){
				//document.getElementById("checktext2").innerHTML = "  × 不能为空！";
				window.alert("密码不能为空！");
			}
			else {
				check = true;
			}
			return check;
		}

		function checksame() {
			var check = false;
			var password = document.getElementById("registerPass").value;
			var password2 = document.getElementById("registerPass2").value;
			if (password!=password2) {
				window.alert("两次输入密码不一致");
				check = false;
			} else {
				check = true;
			}
			return check;
		}

		function check() {
			var check = checkusrn() && checkpwd() && checksame();
			if (check){
				alert("注册成功！");
			}
			return check;
		}
	</script>

		 <!-- Include all js compiled plugins (below), or include individual files as needed -->

		<!--<script src="assets/js/jquery.js"></script>-->
        
        <!--modernizr.min.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		
		<!--bootstrap.min.js-->
        <script src="assets/js/bootstrap.min.js"></script>
		
		<!-- bootsnav js -->
		<script src="assets/js/bootsnav.js"></script>
		
		<!-- jquery.sticky.js -->
		<script src="assets/js/jquery.sticky.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
		
        
        <!--Custom JS-->
        <script src="assets/js/custom.js"></script>

    </body>
	
</html>