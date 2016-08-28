<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<style type="text/css">
.table td{
    vertical-align: middle;
}
.table thead th {
    vertical-align: middle;
}
</style>
<body>
	<form id="userStudyForm" class="form-horizontal"
		style="margin: 0 0 0 0"></form>
	<div style="text-align: left;" class="add">
		<a class="btn btn-small btn-info" href="javascript:void(0)"
			onClick="userStudyEdit()">
			<i class="icon-plus-sign"></i>添加
		</a>
		<span>（注：此处仅填写"</span>
		<span style="color: #FF8000;">教育经历</span>
		<span>",其他专业学习、培训、国内外进修等经历无需填写） </span>
	</div>
	<div class="xline" style="height: 5px"></div>
	<table id="userStudyList"
		class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead valign="middle">
			<tr>
				<th width="10%"  style="text-align:center;">开始时间</th>
				<th width="10%"  style="text-align:center;">结束时间</th>
				<th width="16%"  style="text-align:center;">学校</th>
				<th width="16%"  style="text-align:center;">专业</th>
				<th width="8%"  style="text-align:center;">学制</th>
				<th width="8%"  style="text-align:center;">学位</th>
				<th width="10%"  style="text-align:center;">学历</th>
<!-- 				<th width="8%"  style="text-align:center;">证明人</th> -->
				<th width="15%"  style="text-align:center;">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>
