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
	<form id="userAwardForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_award_id" name="id" value="${user_award.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
					<tr align="center">
						<td class="td_Left">序号：</td>
						<td class="td_Right">
							<input type="text" id="user_award_xuhao_id" value="${user_award.xuhao_id}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">获奖项目名称：</td>
						<td class="td_Right">
							<input type="text" id="user_award_name" value="${user_award.awardItemName}" />
						</td>
					</tr>
<!-- 					<tr align="center"> -->
<!-- 						<td class="td_Left">专利数量：</td> -->
<!-- 						<td class="td_Right"> -->
<%-- 							<input type="text" id="user_award_other" value="${user_award.other}" /> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
	                  <tr align="center">
						<td class="td_Left">奖励名称：</td>
						<td class="td_Right">
							<input type="text" id="user_prize_name" value="${user_award.prizeName}" />
						</td>
					</tr>
		
					<tr align="center">
						<td class="td_Left">等&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp级：</td>
						<td class="td_Right">
							<select id="user_award_grade" name="user_award_grade" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="一等奖" <c:if test="${user_award.grade == '一等奖'}">selected</c:if>>一等奖</option>
								<option value="二等奖" <c:if test="${user_award.grade == '二等奖'}">selected</c:if>>二等奖</option>
								<option value="三等奖" <c:if test="${user_award.grade == '三等奖'}">selected</c:if>>三等奖</option>
								<option value="四等奖" <c:if test="${user_award.grade == '四等奖'}">selected</c:if>>四等奖</option>
								<option value="其它" <c:if test="${user_award.grade == '其它'}">selected</c:if>>其它</option>
							</select>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">排&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp序：</td>
						<td class="td_Right">
							<select id="user_award_sort" name="user_award_sort" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="第一" <c:if test="${user_award.sort == '第一'}">selected</c:if>>第一</option>
								<option value="第二" <c:if test="${user_award.sort == '第二'}">selected</c:if>>第二</option>
								<option value="第三" <c:if test="${user_award.sort == '第三'}">selected</c:if>>第三</option>
								<option value="第四" <c:if test="${user_award.sort == '第四'}">selected</c:if>>第四</option>
								<option value="第五" <c:if test="${user_award.sort == '第五'}">selected</c:if>>第五</option>
								<option value="第六" <c:if test="${user_award.sort == '第六'}">selected</c:if>>第六</option>
								<option value="第七" <c:if test="${user_award.sort == '第七'}">selected</c:if>>第七</option>
								<option value="第八" <c:if test="${user_award.sort == '第八'}">selected</c:if>>第八</option>
								<option value="第九" <c:if test="${user_award.sort == '第九'}">selected</c:if>>第九</option>
								<option value="第十" <c:if test="${user_award.sort == '第十'}">selected</c:if>>第十</option>
								<option value="其它" <c:if test="${user_award.sort == '其它'}">selected</c:if>>其它</option>
							</select>
						</td>
					</tr>
						<tr align="center">
						<td class="td_Left">获奖日期：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_reward_time" value="${user_award.rewardTime}" />
						</td>
					</tr>
					
					   <tr align="center">
						<td class="td_Left">授予机构：</td>
						<td class="td_Right">
							<input type="text" id="user_grant_institution" value="${user_award.grantInstitution}" />
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
