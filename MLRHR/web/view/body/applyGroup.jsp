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
				<input type="hidden" id="applyId" name="applyId" value="${applyInfo.apply_id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">姓名：</td>
						<td class="td_Right">
							${applyInfo.name}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">组织结构：</td>
						<td class="td_Right">
						${applyInfo.body}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">申请类别：</td>
						<td class="td_Right">
							${applyInfo.type}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">申请时间：</td>
						<td class="td_Right">
							${applyInfo.date}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">所在分组：</td>
						<td class="td_Right">
							<select name="group" id="group">
							<c:forEach var="group" items="${applyInfo.groups}" varStatus="status">     
      						    <option value="${ group.id}" ${group.name eq applyInfo.group?'selected':'' }>${group.name}</option>
							</c:forEach> 
							</select>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
