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
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form id="userChengguoForm" class="form-horizontal" style="margin: 0 0 0 0">
		<div style="text-align: center;">
			<div class="control-group">
				<input type="hidden" id="user_chengguo_id" name="id" value="${user_chengguo.id}" />
				<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
				<tr align="center">
						<td class="td_Left">序号：</td>
						<td class="td_Right">
							<input type="text"  id="user_chengguo_xuhao" value="${user_chengguo.xuhao_id}" />
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">论文题目：</td>
						<td class="td_Right">
						<textarea style="width: 205px; height: 60px" id="user_chengguo_thesis_topic">${user_chengguo.thesisTopic}</textarea>
						
						</td>
					</tr>
					
					<tr align="center">
						<td class="td_Left">作者排序（通讯作者标记*）：</td>
						<td class="td_Right">
						<textarea style="width: 205px; height: 60px" id="user_chengguo_author_sort">${user_chengguo.authorSort}</textarea>
						
						</td>
					</tr>
						<%-- <tr align="center">
						<td class="td_Left">作者排序：</td>
						<td class="td_Right">
							<select id="user_chengguo_author_sort" name="user_chengguo_author_sort" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="第一作者" <c:if test="${user_chengguo.authorSort == '第一作者'}">selected</c:if>>第一作者</option>
								<option value="第二作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第二作者(通讯作者)'}">selected</c:if>>第二作者(通讯作者)</option>
								<option value="第三作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第三作者(通讯作者)'}">selected</c:if>>第三作者(通讯作者)</option>
								<option value="第四作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第四作者(通讯作者)'}">selected</c:if>>第四作者(通讯作者)</option>
								<option value="第五作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第五作者(通讯作者)'}">selected</c:if>>第五作者(通讯作者)</option>
								<option value="第六作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第六作者(通讯作者)'}">selected</c:if>>第六作者(通讯作者)</option>
								<option value="第七作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第七作者(通讯作者)'}">selected</c:if>>第七作者(通讯作者)</option>
								<option value="第八作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第八作者(通讯作者)'}">selected</c:if>>第八作者(通讯作者)</option>
								<option value="第九作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第九作者(通讯作者)'}">selected</c:if>>第九作者(通讯作者)</option>
								<option value="第十作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第十作者(通讯作者)'}">selected</c:if>>第十作者(通讯作者)</option>
								<option value="第十一作者(通讯作者)" <c:if test="${user_chengguo.authorSort == '第十一作者(通讯作者)'}">selected</c:if>>第十一作者(通讯作者)</option>
								<option value="其它" <c:if test="${user_chengguo.authorSort == '其它'}">selected</c:if>>其它</option>
							</select>
						</td>
					</tr> --%>
						
						<tr align="center">
						<td class="td_Left">期刊名称：</td>
						<td class="td_Right">
							<textarea style="width: 205px; height: 60px" id="user_chengguo_journal_title">${user_chengguo.journalTitle}</textarea>
						</td>
					</tr>
					<tr align="center">
						<td class="td_Left">年份、卷期及页码：</td>
						<td class="td_Right">
<%-- 						<textarea style="width: 220px; height: 100px" id="user_chengguo_year_volume_pagenumber">${user_chengguo.yearVolumePagenumber}</textarea>
 --%>								<input type="text"  id="user_chengguo_year_volume_pagenumber" value="${user_chengguo.yearVolumePagenumber}" />
	
						</td>
					</tr>
                 <tr align="center">
						<td class="td_Left">影响因子：</td>
						<td class="td_Right">
						
							<input type="text"  id="user_chengguo_yingxiangyinzi" value="${user_chengguo.influenceFactor}" />
						</td>
					</tr>
				
					
				<%-- 	<tr align="center">
						<td class="td_Left">日期：</td>
						<td class="td_Right">
							<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="user_chengguo_cg_date" value="${user_chengguo.cg_date}" />
						</td>
					</tr> --%>
				
					<%-- <tr align="center">
						<td class="td_Left">级&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别：</td>
						<td class="td_Right">
							<select id="user_chengguo_type" name="user_chengguo_type" class="input-block-level" style="width: 220px">
								<option value="-1">请选择</option>
								<option value="国际核心SCI（EI）收录" <c:if test="${user_chengguo.type == '国际核心SCI（EI）收录'}">selected</c:if>>国际核心SCI（EI）收录</option>
								<option value="SCI（EI）收录" <c:if test="${user_chengguo.type == 'SCI（EI）收录'}">selected</c:if>>SCI（EI）收录</option>
								<option value="中文核心期刊" <c:if test="${user_chengguo.type == '中文核心期刊'}">selected</c:if>>中文核心期刊</option>
								<option value="其它" <c:if test="${user_chengguo.type == '其它'}">selected</c:if>>其它</option>
							</select>
						</td>
					</tr> --%>
					<tr align="center">
						<td class="td_Left">SCI他引次数：</td>
						<td class="td_Right">
							<input type="text"  id="user_chengguo_sci_times" value="${user_chengguo.sciTimes}" />
						</td>
					</tr>
					 <tr align="center">
						<td class="td_Left">他引总次数：</td>
						<td class="td_Right">
						
							<input type="text"  id="user_chengguo_number_total" value="${user_chengguo.numberTotal}" />
						</td>
					</tr>
				</table>
			</div>
		</div>



	</form>
</body>
</html>
