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
	<form id="userPeixunForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_peixun_id" name="id" value="${user_peixun.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center">
						<td class="td_Left">开始时间：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_peixun_start_date" value="${user_peixun.start_date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">结束时间：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_peixun_end_date" value="${user_peixun.end_date}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">专业或主要内容：</td>
						<td class="td_Right">
							<textarea style="width: 300px; height: 150px" id="user_peixun_content">${user_peixun.content}</textarea>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">学习地点：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" id="user_peixun_place" value="${user_peixun.place}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">证&nbsp明&nbsp人：</td>
						<td class="td_Right">
							<input style="width: 300px;" type="text" id="user_peixun_zhengmingren" value="${user_peixun.zhengmingren}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">学&nbsp&nbsp&nbsp&nbsp制：</td>
						<td class="td_Right">
							<select id="user_peixun_xuezhi" name="user_peixun_xuezhi" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="1年" <c:if test="${user_peixun.xuezhi == '1年'}">selected</c:if>>1年</option>
								<option value="2年" <c:if test="${user_peixun.xuezhi == '2年'}">selected</c:if>>2年</option>
								<option value="3年" <c:if test="${user_peixun.xuezhi == '3年'}">selected</c:if>>3年</option>
								<option value="4年" <c:if test="${user_peixun.xuezhi == '4年'}">selected</c:if>>4年</option>
								<option value="5年" <c:if test="${user_peixun.xuezhi == '5年'}">selected</c:if>>5年</option>
								<option value="6年" <c:if test="${user_peixun.xuezhi == '6年'}">selected</c:if>>6年</option>
								<option value="其它" <c:if test="${user_peixun.xuewei == '其它'}">selected</c:if>>其它</option>
							</select>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">学&nbsp&nbsp&nbsp&nbsp位：</td>
						<td class="td_Right">
							<select id="user_peixun_xuewei" name="user_peixun_xuewei" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="学士" <c:if test="${user_peixun.xuewei == '学士'}">selected</c:if>>学士</option>
								<option value="硕士" <c:if test="${user_peixun.xuewei == '硕士'}">selected</c:if>>硕士</option>
								<option value="博士" <c:if test="${user_peixun.xuewei == '博士'}">selected</c:if>>博士</option>
								<option value="其它" <c:if test="${user_peixun.xuewei == '其它'}">selected</c:if>>其它</option>
							</select>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">学&nbsp&nbsp&nbsp&nbsp历：</td>
						<td class="td_Right">
							<select id="user_peixun_xueli" name="user_peixun_xueli" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="中专/高中" <c:if test="${user_peixun.xueli == '中专/高中'}">selected</c:if>>中专/高中</option>
								<option value="专科" <c:if test="${user_peixun.xueli == '专科'}">selected</c:if>>专科</option>
								<option value="本科" <c:if test="${user_peixun.xueli == '本科'}">selected</c:if>>本科</option>
								<option value="硕士研究生" <c:if test="${user_peixun.xueli == '硕士研究生'}">selected</c:if>>硕士研究生</option>
								<option value="博士研究生" <c:if test="${user_peixun.xueli == '博士研究生'}">selected</c:if>>博士研究生</option>
								<option value="其它" <c:if test="${user_peixun.xuewei == '其它'}">selected</c:if>>其它</option>
							</select>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">是否最高学历：</td>
						<td class="td_Right">
							<select id="user_peixun_isTop" name="user_peixun_isTop" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="0" <c:if test="${user_peixun.isTop == 0}">selected</c:if>>否</option>
								<option value="1" <c:if test="${user_peixun.isTop == 1}">selected</c:if>>是</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
