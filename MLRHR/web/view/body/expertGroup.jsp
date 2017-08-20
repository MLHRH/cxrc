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
				<input type="hidden" id="expertId" name="expertId" value="${expertInfo.expertId}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">姓名：</td>
						<td class="td_Right">
							${expertInfo.name}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">所在机构：</td>
						<td class="td_Right">
							${expertInfo.body}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">技术职称：</td>
						<td class="td_Right">
							${expertInfo.zhiCheng}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">研究方向：</td>
						<td class="td_Right">
							${expertInfo.congShiFangXiang}
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">是否为复审专家：</td>
						<td class="td_Right">
							<select name="fushenexpert" id="fushen_expert">
								<option value = "1" ${roleId == 1?'selected':'' }>是</option>
								<option value = "2" ${roleId == 2?'selected':'' }>否</option>
							</select>
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">组内级别：</td>
						<td class="td_Right">
							<select name="level" id="team_leader_type">
								<option value = "3" ${expertInfo.level == 3?'selected':'' }>成员</option>
								<option value = "2" ${expertInfo.level == 2?'selected':'' }>副组长</option>
								<option value = "1" ${expertInfo.level == 1?'selected':'' }>组长</option>
							</select>
						</td>
					</tr>
					<tr align="center" style="line-height: 50px">
						<td class="td_Left">所在分组：</td>
						<td class="td_Right">
							<select name="group" id="group">
								<c:forEach items="${expertInfo.groups }" var="group">
									<option value="${group.id }" ${group.name eq expertInfo.group?'selected':'' }>${group.name}</option>
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
