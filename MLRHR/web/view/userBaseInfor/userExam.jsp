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
	<form id="userExamForm" class="form-horizontal" style="margin: 0 0 0 0"></form>
	<div style="text-align: left;" class="add">
		<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="userExamEdit()">
			<i class="icon-plus-sign"></i>添加
		</a>
<!-- 		<span>（注：该数据将在"</span> -->
<!-- 		<span style="color: #FF8000;">附件5：专业技术职务任职资格评审表</span> -->
<!-- 		<span>"中呈现）</span> -->
	</div>
	<div class="xline" style="height: 5px"></div>
	<table id="userExamList" class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead>
			<tr>
				<th width="10%" style="text-align: center;">考试时间</th>
				<th width="10%" style="text-align: center;">考试种类</th>
				<th width="25%" style="text-align: center;">考试科目</th>
				<th width="10%" style="text-align: center;">考试成绩</th>
				<th width="25%" style="text-align: center;">组织考试单位</th>
				<th width="15%" style="text-align: center;">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>
