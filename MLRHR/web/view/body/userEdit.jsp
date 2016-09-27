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
	width: 40%;
	text-align: right;
	padding-right: 10px;
}

.td_Right {
	width: 60%;
	text-align: left;
	padding-left: 10px;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form id="userStudyForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_id" name="id" value="${user.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">姓名：</td>
						<td class="td_Right">
							<input type="text" id="user_name" value="${user.name}" />
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">登陆名(身份证号码)：</td>
						<td class="td_Right">
							<input type="text" id="user_id_num" value="${user.id_num}" />
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">邮箱：</td>
						<td class="td_Right">
							<input type="text" id="user_email" value="${user.email}" />
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">登陆密码：</td>
						<td class="td_Right">
							<input type="text" id="user_password" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
