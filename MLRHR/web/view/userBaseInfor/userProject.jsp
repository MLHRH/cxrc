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
	<form id="userProjectForm" class="form-horizontal" style="margin: 0 0 0 0"></form>
	<div style="text-align: left;" class="add">
		<a id="userProjectAddButton" class="btn btn-small btn-info" href="javascript:void(0)" onClick="userProjectEdit()">
			<i class="icon-plus-sign"></i>添加
		</a>
		<!-- <span>（注：此处只填写您为"</span>
		<span style="color: #FF8000;">第一负责人</span>
		<span>"项目，最多填写</span>
		<span style="color: #FF8000;">3</span>
		<span>条记录）</span> -->
	</div>
	<div class="xline" style="height: 5px"></div>
	<table id="userProjectList" class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead>
			<tr>
			    <th width="8%" style="text-align: center;">序号</th>
				<th width="15%" style="text-align: center;">项目名称</th>
				<th width="10%" style="text-align: center;">立项编号</th>
				<th width="10%" style="text-align: center;">经费(万元)</th>
				<th width="10%" style="text-align: center;">起止年月</th>
				<th width="20%" style="text-align: center;">项目性质及来源</th>
				<th width="15%" style="text-align: center;">担任角色</th>
				<th width="25%" style="text-align: center;">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>
