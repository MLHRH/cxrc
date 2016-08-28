<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form id="detail_base" class="form-horizontal" style="margin: 0 0 0 0">
		<div class="control-group" align="left">
			<input type="hidden" id="user_id" name="id" value="${user.id}" />
			<input type="hidden" id="userbaseinfor_id" name="id" value="${userbaseinfor.id}" />
			<input type="hidden" id="user_kaohe" name="id" value="${userbaseinfor.kaohe}" />
			<input type="hidden" id="user_tiaojian" name="id" value="${userbaseinfor.tiaojian}" />
			<table id="people" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px; margin-left: 0px;">
				<tr align="left" style="margin-left: 20px">
					<td style="width: 130px">姓名：</td>
					<td>
						<input type="text" id="user_name" style="width: 200px" value="${user.name}" />
					</td>
					<td style="width: 150px; padding-left: 50px">性别：</td>
					<td>
						<div style="float: left;">
							<c:if test="${userbaseinfor.gender=='女'}">
								<label class="radio" style="width: 50px; float: left;">
									<input type="radio" name="user_gender" value="男" />
									男
								</label>
								<label class="radio" style="width: 50px; float: left;">
									<input type="radio" name="user_gender" value="女" checked />
									女
								</label>
							</c:if>
							<c:if test="${userbaseinfor.gender=='男'}">
								<label class="radio" style="width: 50px; float: left;">
									<input type="radio" name="user_gender" value="男" checked />
									男
								</label>
								<label class="radio" style="width: 50px; float: left;">
									<input type="radio" name="user_gender" value="女" />
									女
								</label>
							</c:if>
						</div>
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">曾用名：</td>
					<td>
						<input type="text" id="user_former_name" style="width: 200px" value="${userbaseinfor.former_name}" />
					</td>
					<td style="width: 150px; padding-left: 50px">民族：</td>
					<td>
						<input type="text" id="user_minzu" style="width: 200px" value="${userbaseinfor.minzu}" />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">身份证：</td>
					<td>
						<input type="text" id="user_id_num" style="width: 200px" value="${user.id_num}" />
					</td>
					<td style="width: 150px; padding-left: 50px">出生日期：</td>
					<td>
						<input type="text" id="user_birthday" style="width: 200px" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" value="${userbaseinfor.birthday}" />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">出生地：</td>
					<td>
						<input type="text" id="user_chushengdi" style="width: 200px" value="${userbaseinfor.chushengdi}" />
					</td>
					<td style="width: 150px; padding-left: 50px">身体状况：</td>
					<td>
						<input type="text" id="user_health" style="width: 200px" value="${userbaseinfor.health}" />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">计算机成绩：</td>
					<td>
						<input type="text" id="user_jisuanji" style="width: 200px" value="${userbaseinfor.jisuanji}" />
					</td>
					<td style="width: 150px; padding-left: 50px">外语成绩：</td>
					<td>
						<input type="text" id="user_yingyu" style="width: 200px" value="${userbaseinfor.yingyu}" />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">标准工资：</td>
					<td>
						<input type="text" id="user_gongzi" style="width: 200px" value="${userbaseinfor.gongzi}" />
					</td>
					<td style="width: 150px; padding-left: 50px">电子邮箱：</td>
					<td>
						<input type="text" id="user_email" style="width: 200px" value="${user.email}" />
					</td>
				</tr>
				<tr class="xline">
					<td colspan=4 style="width: 100%; border-bottom: 1px dashed #b3b3b3; height: 10px;"></td>
				</tr>
				<tr style="height: 10px"></tr>
				<tr align="left">
					<td style="width: 130px;">参加工作时间：</td>
					<td>
						<input type="text" id="user_canjiashijian" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" style="width: 200px" value="${userbaseinfor.canjiashijian}" />
					</td>
					<td style="width: 150px; padding-left: 50px">所在单位：</td>
					<td>
						<select name="user_body_id_select" id="user_body_id_select" class="input-block-level">
							<c:forEach var="body" items="${bodyList}">
								<option value=${body.id } id="user_body_id" <c:if test="${body.id==user.body_id}">selected="true"</c:if>>${body.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr align="left">
					<td style="width: 130px">现从事专业：</td>
					<td>
						<input type="text" id="user_congshizhuanye" style="width: 200px" value="${userbaseinfor.congshizhuanye}" />
					</td>
					<td style="width: 150px; padding-left: 50px">现任职资格：</td>
					<td>
						<input type="text" id="user_renzhizige" style="width: 200px" value="${userbaseinfor.renzhizige}" />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">任职资格审批单位：</td>
					<td>
						<input type="text" id="user_shenpidanwei" style="width: 200px" value="${userbaseinfor.shenpidanwei}" />
					</td>
					<td style="width: 150px; padding-left: 50px">任职资格审批时间：</td>
					<td>
						<input type="text" id="user_shenpishijian" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" style="width: 200px" value="${userbaseinfor.shenpishijian}" />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">现任专业技术职务：</td>
					<td>
						<input type="text" id="user_current_zhicheng" style="width: 200px" value="${userbaseinfor.current_zhicheng}" />
					</td>
					<td style="width: 150px; padding-left: 50px">现任专业技术任职时间：</td>
					<td>
						<input type="text" id="user_current_zhicheng_date" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" style="width: 200px" value="${userbaseinfor.current_zhicheng_date}" />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">现（兼）任行政职务：</td>
					<td>
						<input type="text" id="user_xingzhengzhiwu" style="width: 200px" value="${userbaseinfor.xingzhengzhiwu}" />
					</td>
					<td style="width: 150px; padding-left: 50px">现（兼）任行政职务任职时间：</td>
					<td>
						<input type="text" id="user_xingzhengshijian" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" style="width: 200px" value="${userbaseinfor.xingzhengshijian}" />
					</td>
				</tr>

				<tr class="xline">
					<td colspan=4 style="width: 100%; border-bottom: 1px dashed #b3b3b3; height: 10px;"></td>
				</tr>
				<tr style="height: 10px"></tr>
				<tr align="left">
				<tr align="left">
					<td style="width: 130px;">何时加入中国共产党（共青团）任何职务：</td>
					<td colspan="3">
						<textarea style="width: 620px; height: 80px" id="user_zhengzhi">${userbaseinfor.zhengzhi}</textarea>
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px;">何时何地参加何种民主党派，任何职务：</td>
					<td colspan="3">
						<textarea style="width: 620px; height: 80px" id="user_minzhudangpai">${userbaseinfor.minzhudangpai}</textarea>
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px;">参加何种学术团体，任何种职务有何社会兼职：</td>
					<td colspan="3">
						<textarea style="width: 620px; height: 80px" id="user_shehuijianzhi">${userbaseinfor.shehuijianzhi}</textarea>
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px;">懂何种外语，达到何种程度:</td>
					<td colspan="3">
						<textarea style="width: 620px; height: 80px" id="user_yuyan">${userbaseinfor.yuyan}</textarea>
					</td>
				</tr>
				<tr class="xline">
					<td colspan=4 style="width: 100%; border-bottom: 1px dashed #b3b3b3; height: 10px;"></td>
				</tr>
				<tr style="height: 10px"></tr>
			</table>

			<div class="control-group">
				<div class="controls" style="margin-left: 295px">
					<input id="submit_base" type="submit" class="btn btn-primary" value="保存">
					<button type="button" class="btn " onClick="javascript:history.back(-1);">返回</button>
				</div>
			</div>
		</div>
	</form>

</body>
</html>
