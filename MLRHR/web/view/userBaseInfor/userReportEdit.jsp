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
	padding: 0 20px;
}

.td_Right {
	width: 65%;
	text-align: left;
	padding-left: 10px;
}
</style>
<body>
	<form id="userReportForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_report_id" name="id" value="${user_report.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center">
						<td class="td_Left">日期：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_report_date" value="${user_report.date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">名称：</td>
						<td class="td_Right">
							<textarea style="width: 300px; height: 100px" id="user_report_name">${user_report.name}</textarea>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">内容提要：</td>
						<td class="td_Right">
							<textarea style="width: 300px; height: 100px" id="user_report_content_summary">${user_report.content_summary}</textarea>
						</td>
					</tr>

					<tr align="center">
						<td class="td_Left">出版、登载获奖或在学术会议上交流情况：</td>
						<td class="td_Right">
							<textarea style="width: 300px; height: 100px" id="user_report_situation">${user_report.situation}</textarea>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">合（独）著、译：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" id="user_report_isAlone" value="${user_report.isAlone}" />
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
