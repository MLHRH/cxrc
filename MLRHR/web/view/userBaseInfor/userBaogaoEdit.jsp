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
	padding-right: 20px;
}

.td_Right {
	width: 65%;
	text-align: left;
	padding-left: 10px;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form id="userBaogaoForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_Baogao_id" name="id" value="${user_study.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					
					
					<tr align="center">
						<td class="td_Left">报告名称：</td>
						<td class="td_Right">
							<input type="text" id="user_Baogao_report_name" value="${user_study.reportName}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">会议名称：</td>
						<td class="td_Right">
							<input type="text" id="user_Baogao_meeting_name" value="${user_study.meetingName}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">主&nbsp&nbsp办&nbsp&nbsp方：</td>
						<td class="td_Right">
							<input type="text" id="user_Baogao_organizers" value="${user_study.organizers}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">会议时间：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_Baogao_meeting_time" value="${user_study.meetingTime}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">地&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp点：</td>
						<td class="td_Right">
							<input type="text" id="user_Baogao_meeting_place" value="${user_study.meetingPlace}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">报告类别：</td>
						<td class="td_Right">
							<input type="text" id="user_Baogao_report_type" value="${user_study.reportType}" />
						</td>
					</tr>
					<!-- 					<tr align="center"> -->
					<!-- 						<td class="td_Left">证&nbsp明&nbsp人：</td> -->
					<!-- 						<td class="td_Right"><input type="text" -->
					<%-- 							id="user_Baogao_zhengmingren" value="${user_Baogao.zhengmingren}" /></td> --%>
					<!-- 					</tr> -->
				</table>
			</div>
		</div>
	</form>
</body>
</html>
