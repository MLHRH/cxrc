<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中国地质科学院自然科学系列职称申报系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<style type="text/css">

.csAction > .csPrev {
    background-position: 0 0;
    left: 10px;
}

.csAction > .csNext {
    background-position: -32px 0;
    right: 10px;
}
.csAction > a {
	background-image: url("static/jquery/lightSlider/img/controls.png");
	cursor: pointer;
	display: block;
	height: 32px;
	margin-top: -16px;
	opacity: 0.5;
	position: absolute;
	top: 50%;
	transition: opacity 0.35s linear 0s;
	width: 32px;
	z-index: 99;
}
</style>
</head>
<body>
	<p id="pdfShow" style="width: 100%; width: 100%">加载失败请重新尝试！或更换其它浏览器以获得更好的浏览效果！</p>
	<div class="csAction">
		<a id="PDF_prev" class="csPrev"></a>
		<a id="PDF_next" class="csNext"></a>
	</div>
</body>
</html>
