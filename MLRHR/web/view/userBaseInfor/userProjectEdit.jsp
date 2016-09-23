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
				<input type="hidden" id="user_project_id" name="id" value="${jcqn_doc02_01.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
				
					<tr align="center">
						<td class="td_Left">序号：</td>
						<td class="td_Right">
						<input type="text" id="user_project_xuhao_id" value="${jcqn_doc02_01.xuhao_id}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目名称：</td>
						<td class="td_Right">
							<input type="text" id="user_project_project_name" value="${jcqn_doc02_01.entryName}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目编号：</td>
						<td class="td_Right">
							<input type="text" id="user_project_project_number" value="${jcqn_doc02_01.projectNumber}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目经费：</td>
						<td class="td_Right">
							<input type="text" id="user_project_funds" value="${jcqn_doc02_01.funds}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">起止年月：</td>
						<td class="td_Right">
							<input type="text" id="user_project_startStopTime" value="${jcqn_doc02_01.startStopTime}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">项目来源：</td>
						<td class="td_Right">
							<input type="text" id="user_project_projectNature" value="${jcqn_doc02_01.projectNature}" />
						</td>
					</tr>
						<tr align="center">
						<td class="td_Left">承担角色：</td>
						<td class="td_Right">
							<input type="text" id="user_project_role" value="${jcqn_doc02_01.role}" />
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
