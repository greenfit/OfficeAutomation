<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>SEO优化管理端</title>
		<link rel="icon" href="favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${request.contextPath}/static/lib/layui/css/layui.css">
		<link rel="stylesheet" href="${request.contextPath}/static/css/style.css">
		<link rel="stylesheet" href="${request.contextPath}/static/lib/font-awesome/css/font-awesome.css">
		<script src="${request.contextPath}/static/lib/jquery-3.1.1.js"></script>
		<script src="${request.contextPath}/static/lib/layui/layui.js"></script>
		<script src="${request.contextPath}/static/lib/layui/lay/dest/layui.all.js"></script>
	</head>
	<body>
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<img class="header-logo" src="${request.contextPath}/static/images/logo.png">
			</div>
			<div class="nav-user">
				<a target="BODY_FRAME" class="avatar" href="${request.contextPath}/profile.html">
					<#if admin.image?length &lt; 2>
						<img src="static/images/100.gif">
					<#else>
						<#if admin.image?starts_with('http')>
							<img src="${admin.image}">
						<#else>
							<img src="${imageHost}${admin.image}">
						</#if>
					</#if>
					<cite>${admin.realname}</cite>
				</a>
				<div class="nav" style="cursor: pointer;top: 0px;">
					<#if debug>
						<a><i class="fa fa-wrench"></i>调试</a>
					</#if>
					<a onclick="exit()"><i class="fa fa-power-off"></i>退出</a>
				</div>
			</div>
			<div id="leftFrame" class="layui-side layui-bg-black">
				<div class="layui-side-scroll">
					<ul class="layui-nav layui-nav-tree">
						<li class="layui-nav-item layui-nav-title"><a>公共设置</a></li>
						<!-- <li class="layui-nav-item layui-nav-link">
							<a onclick="change('manager.html')"> 
								<i class="fa fa-list"></i> <cite>管理员</cite>
							</a>
						</li> -->
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('setting.html')"> 
								<i class="fa fa-sliders"></i> <cite>链接设置</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('soft/index.html')"> 
								<i class="fa fa-comments-o"></i> <cite>新手指导</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-title"><a>站点设置</a></li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/position.html')"> 
								<i class="fa fa-flag-o"></i> <cite>麟龙招聘</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/news.html')"> 
								<i class="fa fa-newspaper-o"></i> <cite>媒体报道</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/culture.html')"> 
								<i class="fa fa-rocket"></i> <cite>企业文化</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/stone.html')"> 
								<i class="fa fa-video-camera"></i> <cite>石头网</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/teacher.html')"> 
								<i class="fa fa-tencent-weibo" style="width:14px;"></i> <cite>讲师团</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/ipo.html')"> 
								<i class="fa fa-volume-control-phone"></i> <cite>新三板</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/show.html')"> 
								<i class="fa fa-bookmark-o" style="width:18px;"></i><cite>新三板路演Show</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/ibd.html')"> 
								<i class="fa fa-diamond"></i> <cite>麟龙投行</cite>
							</a>
						</li>
						<li class="layui-nav-item layui-nav-link">
							<a onclick="change('stock/message.html')"> 
								<i class="fa fa-bullhorn" style="width:18px;"></i><cite>信息公告</cite>
							</a>
						</li>
					</ul>
					<script>
				      layui.use('element', function(){});
				      $(".layui-nav-link").on('click', function(){
					      $(".layui-nav-tree li[class$='layui-this']").removeClass("layui-this");
					      $(this).addClass('layui-this');
				      });
				      function change(src){
				    	  var start = (new Date()).valueOf();
				    	  $.post("${request.contextPath}/islogin.json", function(res){
				    		 var end = (new Date()).valueOf();
						 	 if(res.code == 0) {
						 		$("#BODY_FRAME").attr("src", "${request.contextPath}/" + src);
						 		<#if debug>
							 		console.log("UP  :" + (+res.message - start) + "ms");
							 		console.log("DOWN:" + (end - +res.message)   + "ms");
						 		</#if>
						 	 } else{
						 		location.reload(true);
						 	 }
						  });
				      }
				    </script>
				</div>
			</div>
			<div id="bodyFrame" class="layui-body" style="padding: 10px;">
				<iframe id="BODY_FRAME" name="BODY_FRAME" src="logs.html" frameborder="0" width="100%" height="99%"></iframe>
			</div>
			<div class="layui-footer" style="padding-top: 15px;height:30px;">
			  <center><p>2016 © <a href="http://www.win-stock.com.cn/" target="_black">沈阳麟龙科技股份有限公司</a></p></center>
			</div>
		</div>
		<script type="text/javascript">
			$(".layui-body").css("height", $(".layui-side").css("height"));
			$(".layui-body").css("top", "65px");
			function exit() {
				layer.confirm('确定要退出？', {
					title : '退出?',
					btn : [ '确定', '取消' ]
				}, function() { 
					$.post("${request.contextPath}/logout.json", function(res){
						layer.msg('退出成功', {icon : 1});
						setTimeout(function(){location.reload(true);}, 500);
					});
				});
			}
			function resizeWin() {
				$("#bodyFrame").height($("#leftFrame").height() - 50);
			}
			resizeWin();
			$(window).resize(function() {
				resizeWin();
			});
		</script>
	</body>
</html>
