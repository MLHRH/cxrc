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
</head>
<script>
	$(document).ready(function() {
		if ($('#user_work_toNow_old').val() == 1) {
			$('#user_work_toNow').attr("checked", true);
		} else {
			$('#user_work_toNow').attr("checked", false);
		}
		checkboxClick();
		$("#user_work_toNow").click(checkboxClick);
	});
	function checkboxClick() {
		if ($('#user_work_toNow').is(':checked') == true) {
			$('#user_work_end_date').attr("disabled", true);
			$('#user_work_end_date').val('');
		} else {
			$('#user_work_end_date').attr("disabled", false);
		}
	}
</script>
<body>
	<form id="userWorkForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_work_id" name="id" value="${user_work.id}" />
				<input type="hidden" id="user_work_toNow_old" name="id" value="${user_work.toNow}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center">
						<td class="td_Left">开始时间：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_work_start_date" value="${user_work.start_date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">结束时间：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_work_end_date" value="${user_work.end_date}" />
							<label class="radio" style="display: inline-block; margin: 0 0 0 5px; padding-left: 10px" for="user_work_toNow">至今</label>
							<input type="checkbox" name="user_work_toNow" value="1" id="user_work_toNow" style="margin: 0" />

						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">单&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp位：</td>
						<td class="td_Right">
							<input type="text" id="user_work_work_content" value="${user_work.work_content}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">国&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp家：</td>
						<td class="td_Right">
							<input type="text" id="user_work_country" value="${user_work.country}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">职&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp务：</td>
						<td class="td_Right">
							<input type="text" id="user_work_zhiwu" value="${user_work.zhiwu}" />
						</td>
					</tr>
					<!-- 					<tr align="center"> -->
					<!-- 						<td class="td_Left">证&nbsp明&nbsp人：</td> -->
					<!-- 						<td class="td_Right"><input type="text" -->
					<%-- 							id="user_work_zhengmingren" value="${user_work.zhengmingren}" /></td> --%>
					<!-- 					</tr> -->
				</table>
			</div>
		</div>



	</form>
</body>
</html>
