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
	<form id="userZhuanliForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_zhuanli_id" name="id" value="${user_zhuanli.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
			
					<%-- <tr align="center">
						<td class="td_Left">序号：</td>
						<td class="td_Right">
							<input type="text" id="user_zhuanli_xuhao" value="${user_zhuanli.xuhao_id}" />
						</td>
					</tr> --%>
					<tr align="center">
						<td class="td_Left">专利名称：</td>
						<td class="td_Right">
							<input type="text" id="user_zhuanli_name" value="${user_zhuanli.patentName}" />
						</td>
					</tr>

					<tr align="center">
						<td class="td_Left">授权号：</td>
						<td class="td_Right">
							<input type="text" id="user_zhuanli_number" value="${user_zhuanli.grantNumber}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">类&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别：</td>
						<td class="td_Right">
							<input type="text" id="user_zhuanli_type" value="${user_zhuanli.type}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">发明人或设计人排序：</td>
						<td class="td_Right">
							<input type="text" id="user_zhuanli_sort" value="${user_zhuanli.inventorSort}" />
						</td>
					</tr>
							<tr align="center">
						<td class="td_Left">授权时间：</td>
						<td class="td_Right">
							<input type="text"  id="user_zhuanli_date" value="${user_zhuanli.authorizedTime}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">授权国别或组织	：</td>
						<td class="td_Right">
							<input type="text" id="user_zhuanli_authorized_national" value="${user_zhuanli.authorizedNational}" />
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
