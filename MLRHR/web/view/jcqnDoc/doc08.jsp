<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@ include file="/common/common.jsp"%>
<link href="${ctx}/static/styles/jquery.dataTables.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/static/jquery/DataTables-1.10.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.columnFilter.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.ztree.exedit-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/Chart.js"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<%@ include file="/common/jquery.noty.jsp"%>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<style type="text/css">
.table td{
    vertical-align: middle;
}
.table thead th {
    vertical-align: middle;
}
</style>
<body>
	<div class="xline" style="height: 5px"></div>
	<input type="hidden" value="${applyid}" id="applyid">
	<table id="expertScoress"
		class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead valign="middle">
			<tr>
				<th width="8%"  style="text-align:center;">专家姓名</th>
				<th width="36%"  style="text-align:center;">专家意见</th>
			</tr>
		</thead>
	</table>
</body>
</html>
