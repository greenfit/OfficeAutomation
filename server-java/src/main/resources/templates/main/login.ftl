<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>SpringBoot</title>
		<link rel="icon" href="favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="/lib/layui/css/layui.css">
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/lib/font-awesome/css/font-awesome.css">
		<script src="/lib/jquery-3.1.1.js"></script>
		<script src="/lib/layui/layui.js"></script>
		<script src="/lib/layui/lay/dest/layui.all.js"></script>			
	</head>
	<body class="login-body">
		<center>
			<div class="login">
				<img src="/images/login-logo.png">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-block">
						<input id="username" type="text" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密&nbsp;&nbsp;&nbsp;码</label>
					<div class="layui-input-block">
						<input id="password" type="password" class="layui-input" onkeydown='if(event.keyCode==13)login()'>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block" style="float: right;">
						<button class="layui-btn layui-btn-normal" onclick="login()">登录</button>
					</div>
				</div>
			</div>
		</center>
		<script type="text/javascript">
			layui.use([ 'form', ], function() {
				var form = layui.form();
			});
			function login(){
				var username = $("#username").val();
				var password = $("#password").val();
				$.post("login.json", { "username" : username, "password" : password }, function(res){
					if(res.code == 0){
						//登录成功
						location.href = "index.html";
					}else{
						layer.msg(res.message, {icon : 2});
					}
				});
			}
		</script>
	</body>
</html>
