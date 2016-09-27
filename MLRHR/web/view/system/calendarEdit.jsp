<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Le styles -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
body {
	padding-top: 70px;
	padding-bottom: 10px;
}

.sidebar-nav {
	padding: 9px 0;
}

.td_Left {
	width: 250px;
	text-align: right;
	padding: 0 20px;
}

.td_Right {
	text-align: left;
	padding-left: 10px;
}
#calendar_jieshao {
	max-height: 400px;
	height: 400px;
	background-color: white;
	border-collapse: separate; 
	border: 1px solid rgb(204, 204, 204); 
	padding: 4px; 
	box-sizing: content-box; 
	-webkit-box-shadow: rgba(0, 0, 0, 0.0745098) 0px 1px 1px 0px inset; 
	box-shadow: rgba(0, 0, 0, 0.0745098) 0px 1px 1px 0px inset;
	border-top-right-radius: 3px; border-bottom-right-radius: 3px;
	border-bottom-left-radius: 3px; border-top-left-radius: 3px;
	overflow: scroll;
	outline: none;
}
#voiceBtn {
  width: 20px;
  color: transparent;
  background-color: transparent;
  transform: scale(2.0, 2.0);
  -webkit-transform: scale(2.0, 2.0);
  -moz-transform: scale(2.0, 2.0);
  border: transparent;
  cursor: pointer;
  box-shadow: none;
  -webkit-box-shadow: none;
}

div[data-role="editor-toolbar"] {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.dropdown-menu a {
  cursor: pointer;
}
@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

</head>
<%@ include file="/common/common.jsp"%>
<link href="${ctx}/static/styles/jquery.dataTables.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
  <link href="${ctx}/static/bootstrap/wysiwyg/external/google-code-prettify/prettify.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.columnFilter.js"></script>
<script type="text/javascript" src="${ctx}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/bootstrap-wysiwyg.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/google-code-prettify/prettify.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/jquery.hotkeys.js"></script>
<script type="text/javascript" src="${ctx}/view/system/js/calendarEdit.js"></script>
<%@ include file="/common/jquery.noty.jsp"%>
<body>
	<%@ include file="/common/bodyheader.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="row-fluid">
				<div class="page-header">
					<h2>申请设置</h2>
				</div>
				<div class="span11">
					<form id="calendarForm" class="form-horizontal" style="margin: 0 0 0 0">
						<div style="text-align: center;">
							<div class="control-group">
								<input type="hidden" id="calendar_id" name="id" value="${calendar.id}" />
								<table width="98%" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px">
									<tr align="center">
										<td class="td_Left">开始时间：</td>
										<td class="td_Right">
											<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="calendar_start_date" value="${calendar.start_date}" />
										</td>
									</tr>
									<tr align="center">
										<td class="td_Left">结束时间：</td>
										<td class="td_Right">
											<input type="text" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" id="calendar_end_date" value="${calendar.end_date}" />
										</td>
									</tr>
									<tr align="center">
										<td class="td_Left">申请介绍：</td>
										<td class="td_Right">
											<div id="calendar_jieshao">${calendar.jieshao}</div>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</form>
					<div class="control-group">
						<div class="controls" style="padding-left: 250px">
							<input id="submit" type="submit" class="btn btn-primary" onclick="calendarEditSave()" value="提交">
							<button type="button" class="btn " onClick="javascript:history.back(-1);">返回</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<%@ include file="/common/footer.jsp"%>

	</div>
	<!--/.fluid-container-->
</body>
</html>
