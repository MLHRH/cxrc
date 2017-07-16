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
	<form id="userChengguoForm" class="form-horizontal" style="margin: 0 0 0 0"></form>
	<div style="text-align: left;" class="add">
		<a id="userChengguoAddButton" class="btn btn-small btn-info" href="javascript:void(0)" onClick="userChengguoEdit()">
			<i class="icon-plus-sign"></i>添加
		</a>
		<span>（注：此处只填写您为"</span>
		<span style="color: #FF8000;">第一作者/通讯作者的论文（不超过10篇）</span>
		<!-- <span>"论文专著，研究员限</span>
		<span style="color: #FF8000;">10</span>
		<span>篇、副研限</span>
		<span style="color: #FF8000;">6</span>
		<span>篇、破格申报正研限</span>
		<span style="color: #FF8000;">12</span>
		<span>篇、破格申报副研限</span>
		<span style="color: #FF8000;">8</span>
		<span>篇）</span> -->
	</div>
	<div class="xline" style="height: 5px"></div>
	<table id="userChengguoList" class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead>
			<tr>
			 	<th width="10%" style="text-align: center;">论文题目</th>
				<th width="15%" style="text-align: center;">作者排序（通讯作者请标注*）</th>
			 	<th width="15%" style="text-align: center;">期刊名称</th>
				<th width="15%" style="text-align: center;">年份、卷期及页码</th>
				<th width="10%" style="text-align: center;">影响因子</th>
				<th width="7%" style="text-align: center;">SCI他引次数</th>
				<th width="7%" style="text-align: center;">他引总次数</th>
				<th width="15%" style="text-align: center;">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>
