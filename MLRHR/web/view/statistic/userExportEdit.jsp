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
	padding-right: 20px;
}

.td_Right {
	width: 60%;
	text-align: left;
	padding-left: 10px;
}

h3 {
	text-align: left;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form id="userChengguoForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center">
						<td class="td_Left">专业级别：</td>
						<td class="td_Right">
							<input style="" type="text" id="apply_userRank"  />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">单&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp位：</td>
						<td class="td_Right">
							<input style="" type="text" id="apply_body" value="${bodyName}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">填&nbsp&nbsp报&nbsp&nbsp人：</td>
						<td class="td_Right">
							<input style="" type="text" id="apply_userName" value="${userName}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">联系电话：</td>
						<td class="td_Right">
							<input style="" type="text" id="apply_userMobile"  />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">填报时间：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="apply_date" value="${user_chengguo.cg_date}" />
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div style="text-align:left； padding: 20px;">
			<span>提示：上面填写数据将作为"</span>
			<span style="color: #FF8000;">附件5 任职资格人员情况一览表 </span>
			<span>"中表头信息。</span>
		</div>

	</form>
</body>
</html>
