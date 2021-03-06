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
	<form id="userSkillForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_skill_id" name="id" value="${user_skill.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center">
						<td class="td_Left">开始时间：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_skill_start_date" value="${user_skill.start_date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">结束时间：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_skill_end_date" value="${user_skill.end_date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">专业技术工作名称（项目、课题、成果等）：</td>
						<td class="td_Right">
							<textarea style="width: 300px; height: 50px" id="user_skill_project_name">${user_skill.project_name}</textarea>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">工作内容、本人起何作用（主持、参加、独立）：</td>
						<td class="td_Right">
							<textarea style="width: 300px; height: 50px" id="user_skill_jiaose">${user_skill.jiaose}</textarea>
						</td>
					</tr>
					<!-- 					<tr align="center"> -->
					<!-- 						<td class="td_Left">角&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp色：</td> -->
					<!-- 						<td class="td_Right"><input type="text" id="user_skill_jiaose" -->
					<%-- 							value="${user_skill.jiaose}" /></td> --%>
					<!-- 					</tr> -->
					<!-- 					<tr align="center"> -->
					<!-- 						<td class="td_Left">金&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp额：</td> -->
					<!-- 						<td class="td_Right"><input type="text" id="user_skill_jine" -->
					<%-- 							value="${user_skill.jine}" /></td> --%>
					<!-- 					</tr> -->
					<!-- 					<tr align="center"> -->
					<!-- 						<td class="td_Left">来&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp源：</td> -->
					<!-- 						<td class="td_Right"><input type="text" id="user_skill_laiyuan" -->
					<%-- 							value="${user_skill.laiyuan}" /></td> --%>
					<!-- 					</tr> -->
					<tr align="center">
						<td class="td_Left">完成情况及效果（获何奖励效益或专利）：</td>
						<td class="td_Right">
							<textarea style="width: 300px; height: 50px" id="user_skill_project_result">${user_skill.project_result}</textarea>
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
