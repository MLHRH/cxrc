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
.td_Left {
	width: 35%;
	text-align: right;
	padding:0 20px;
}

.td_Right {
	width: 65%;
	text-align: left;
	padding-left: 10px;
}
</style>
<body>
	<form id="userProjectForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_project_id" name="id" value="${user_project.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center">
						<td class="td_Left">开始时间：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_project_start_date" value="${user_project.start_date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">结束时间：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_project_end_date" value="${user_project.end_date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目编号：</td>
						<td class="td_Right">
							<input type="text" id="user_project_project_result" value="${user_project.project_result}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目名称：</td>
						<td class="td_Right">
							<input type="text" id="user_project_project_name" value="${user_project.project_name}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目来源：</td>
						<td class="td_Right">
							<input type="text" id="user_project_laiyuan" value="${user_project.laiyuan}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目经费：</td>
						<td class="td_Right">
							<input type="text" id="user_project_jine" value="${user_project.jine}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">承担任务：</td>
						<td class="td_Right">
							<input type="text" id="user_project_jiaose" value="${user_project.jiaose}" />
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
