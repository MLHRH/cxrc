<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<style type="text/css">
.table td {
	vertical-align: middle;
}

.table thead th {
	vertical-align: middle;
}
</style>
<body>
	<form id="userZhuanliForm" class="form-horizontal" style="margin: 0 0 0 0"></form>
	<div style="text-align: left;" class="add">
		<a id="userZhuanliAddBtn" class="btn btn-small btn-info" href="javascript:void(0)" onClick="userZhuanliEdit()">
			<i class="icon-plus-sign"></i>添加
		</a>
		<!-- <span>（注：此处只填写您为"</span>
		<span style="color: #FF8000;">第一作者</span>
		<span>"专利情况）</span> -->
	</div>
	<div class="xline" style="height: 5px"></div>
	<table id="userZhuanliList" class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead>
			<tr>
				<th width="15%" style="text-align: center;">专利名称</th>
				<th width="10%" style="text-align: center;">授权号</th>
				<th width="12%" style="text-align: center;">类别</th>
				<th width="15%" style="text-align: center;">发明人或设计人排序</th>
				<th width="10%" style="text-align: center;">授权时间</th>
				<th width="15%" style="text-align: center;">授权国别或组织</th>
				<th width="27%" style="text-align: center;">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>
