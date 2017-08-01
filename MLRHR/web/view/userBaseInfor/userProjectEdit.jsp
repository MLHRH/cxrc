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
				
					<%-- <tr align="center">
						<td class="td_Left">序号：</td>
						<td class="td_Right">
						<input type="text" id="user_project_xuhao_id" value="${user_project.xuhao_id}" />
						</td>
					</tr> --%>
					<tr align="center">
						<td class="td_Left">项目名称：</td>
						<td class="td_Right">
							<input type="text" id="user_project_project_name" value="${user_project.entryName}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">立项编号：</td>
						<td class="td_Right">
							<input type="text" id="user_project_project_number" value="${user_project.projectNumber}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">经费（万元）：</td>
						<td class="td_Right">
							<input type="text" id="user_project_funds" value="${user_project.funds}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">起止年月：</td>
						<td class="td_Right">
							<input type="text" id="user_project_startStopTime" value="${user_project.startStopTime}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目性质及来源：</td>
						<td class="td_Right">
							<input type="text" id="user_project_projectNature" value="${user_project.projectNature}" />
						</td>
					</tr>
						<tr align="center">
						<td class="td_Left">参与的其他团队成员：</td>
						<td class="td_Right">
							<input type="text" id="user_project_role" value="${user_project.role}" />
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
