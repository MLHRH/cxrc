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
	<form id="userSkillForm" class="form-horizontal" style="margin: 0 0 0 0"></form>
	<div style="text-align: left;" class="add">
		<a id="userSkillAddBtn" class="btn btn-small btn-info" href="javascript:void(0)" onClick="userSkillEdit()">
			<i class="icon-plus-sign"></i>添加
		</a>
<!-- 		<span>（注：该数据将在"</span> -->
<!-- 		<span style="color: #FF8000;">附件5：专业技术职务任职资格评审表 </span> -->
<!-- 		<span>"中呈现）</span> -->
	</div>
	<div class="xline" style="height: 5px"></div>
	<table id="userSkillList" class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead>
			<tr>
				<th width="10%" style="text-align: center;">开始时间</th>
				<th width="10%" style="text-align: center;">结束时间</th>
				<th width="15%" style="text-align: center;">专业技术工作名称（项目、课题、成果等）</th>
				<th width="15%" style="text-align: center;">工作内容、本人起何作用（主持、参加、独立）</th>
				<!-- 				<th width="5%" style="text-align: center;">角色</th> -->
				<!-- 				<th width="5%" style="text-align: center;">金额</th> -->
				<!-- 				<th width="8%" style="text-align: center;">来源</th> -->
				<th width="15%" style="text-align: center;">完成情况及效果（获何奖励效益或专利）</th>
				<th width="15%" style="text-align: center;">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>
