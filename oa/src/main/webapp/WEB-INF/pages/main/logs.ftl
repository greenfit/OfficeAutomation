<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>SEO优化管理端</title>
		<link rel="icon" href="favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${request.contextPath}/static/lib/layui/css/layui.css">
		<link rel="stylesheet" href="${request.contextPath}/static/css/style.css">
	    <script src="${request.contextPath}/static/lib/jquery-3.1.1.js"></script>
	    <script src="${request.contextPath}/static/lib/layui/layui.js"></script>
	    <script src="${request.contextPath}/static/lib/layui/lay/dest/layui.all.js"></script>
	</head>
	<body>
	<div class="layui-code">
		Version 0.1.9 (2016-12-8)
		1.[修复]新闻的摘要中的图片
		2.[修复]管理端Session过期的处理方式
		3.[新增]展示端客服图片
		4.[新增]展示端meta内容
		<br/>
		Version 0.1.8 (2016-12-7)
		1.[新增]讲师团视频的分页
		2.[优化]所有代码的注释和逻辑
		3.[新增]所有页面的百度统计
		4.[新增]所有编辑页面的提示信息
		<br/>
		Version 0.1.7 (2016-12-6)
		1.[修复]展示端的部分样式
		2.[新增]媒体公告和投行的管理端
		<br/>
		Version 0.1.6 (2016-12-5)
		1.[修复]管理端滚动条的BUG
		2.[优化]展示端的部分链接和分页
		3.[新增]媒体公告和投行的展示端
		<br/>
		Version 0.1.5 (2016-12-2)
		1.[修复]新三板路演Show的部分链接
		<br/>
		Version 0.1.4 (2016-12-1)
		1.[优化]管理端的数据展示方式
		2.[修复]新三板路演Show的部分图片样式
		<br/>
		Version 0.1.3 (2016-11-30)
		1.[优化]富文本编辑器的相关内容
		2.[修复]保金所和路演Show的部分链接
		3.[优化]管理端的部分样式,文字和设置方式
		<br/>
		Version 0.1.2 (2016-11-29)
		1.[优化]新三板路演Show的财富指标
		2.[优化]新三板路演Show的首页内容
		3.[新增]管理端的管理员相关的内容
		4.[新增]管理端的登录
		<br/>
		Version 0.1.1 (2016-11-28)
		1.[优化]富文本编辑器
		2.[修复]展示端的细节和BUG
		3.[新增]新三板路演Show
		4.[重构]新三板和新三板路演Show
		5.[新增]保金所模块
		<br/>
		Version 0.0.12 (2016-11-25)
		1.[新增]讲师团的管理端
		2.[新增]新三板的展示端和管理端
		3.[修复]讲师团相关的BUG
		<br/>
		Version 0.0.11 (2016-11-24)
		1.[优化]所有管理端的图片上传功能
		2.[优化]石头网首页修改切换方式
		3.[新增]讲师团的内容
		<br/>
		Version 0.0.10 (2016-11-23)
		1.[新增]企业文化模块展示端
		2.[新增]石头网首页讲师内容重做
		3.[新增]企业文化模块的活动内容
		<br/>
	    Version 0.0.9 (2016-11-22)
	    1.[新增]CKEditor编辑器
	    2.[优化]新闻模块的富文本编辑器改为CKEditor
	    3.[修复]新闻展示模块的细节
	    <br/>
		Version 0.0.8 (2016-11-21)
		1.[新增]石头网模块的展示端和管理端
		2.[优化]招聘模块的地图坐标获取方式
		3.[新增]富文本编辑器上传图片功能(临时解决方案)
		4.[新增]图片模块
		<br/>
		Version 0.0.7 (2016-11-18)
		1.[优化]新手问答列表的展示方式
		2.[新增]新手问答分页,新增
		3.[修复]所有的编辑都显示到父窗口的BUG
		4.[新增]所有页面的新手指导
		<br/>
		Version 0.0.6 (2016-11-17)
		1.[优化]所有页面的标题,底部,下载链接
		2.[新增]新手问答列表
		3.[新增]期天大胜的机构版静态页面
		<br/>
		Version 0.0.5 (2016-11-16)
		1.[新增]麟龙新闻的分页和查询功能
		2.[新增]期天大胜的专业版静态页面
		3.[新增]麟龙新闻的META字段
		4.[优化]所有页面的链接等细节
		<br/>
		Version 0.0.4 (2016-11-15)
		1.[新增]新闻展示端的列表和详细内容
		2.[新增]友情链接的管理和展示
		3.[优化]麟龙招聘的细节,友情链接
		4.[新增]普及版,至尊版,至尊套餐的静态页面
		</br>
		Version 0.0.3 (2016-11-14)
		1.[修改]展示模块为RESTful风格,更像静态页面
		2.[修改]展示模块的路径统一规划
		3.[新增]新闻模块
		4.[新增]新闻列表展示,分页,新增,编辑,查询功能
		5.[新增]媒体列表展示,分页,新增,编辑功能
		</br>
		Version 0.0.2 (2016-11-11)
		1.[新增]麟龙官网模块
		2.[新增]麟龙招聘列表展示,分页功能
		3.[新增]麟龙招聘的新增,编辑功能
		4.[新增]麟龙招聘的查询功能
		</br>		
		Version 0.0.1 (2016-11-9)
		1.[新增]基本的框架
	</div>
	<script type="text/javascript">
      layui.use('code', function(){ layui.code({ title : "开发日志", about : false }); });
    </script>
	</body>
</html>
