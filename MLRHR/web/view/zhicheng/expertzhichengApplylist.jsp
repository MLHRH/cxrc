<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<%@ include file="/common/common.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<style type="text/css">
body {
	padding-top: 80px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

.table td {
	vertical-align: middle;
}

.table thead th {
	vertical-align: middle;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link href="${ctx}/static/styles/jquery.dataTables.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/static/jquery/DataTables-1.10.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/getURLparam.js"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<%@ include file="/common/jquery.noty.jsp"%>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/view/zhicheng/js/expertzhichengApplylist.js"></script>
</head>
<body><%@ include file="/common/bodyheader.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="row-fluid">
				<div class="page-header">
					<h2>人才申报</h2>
				</div>
				<div class="span8" style="width: 90%">

					<security:authorize ifAnyGranted="ROLE_USER">
						<div style="text-align: left;">
							<a class="btn btn-small btn-info" href="zhichengApply" id="zhichengAddButton">
								<i class="icon-plus-sign"></i>添加申请
							</a>
						</div>
						<div class="xline" style="border-bottom: 1px dashed #b3b3b3; height: 10px;margin-bottom: 10px"></div>
					</security:authorize>
					<div class="row-fluid">
						<table id="zhichengApplyList" class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
							<thead>
								<tr>
									<th width="20%" style="text-align: center;">姓名</th>
									<th width="20%" style="text-align: center;">所在机构</th>
									<th width="10%" style="text-align: center;">申请类别</th>
									<th width="20%" style="text-align: center;">申请时间</th>
									<th width="20%" style="text-align: center;">所在分组</th>
									<th width="20%" style="text-align: center;">操作</th>
								</tr>
							</thead>
						</table>
					</div>
					<!--/row-->
					<div class="control-group" align="left" style="margin: 10px 0; display: none;" id="roleBack">
						<div class="controls">
							<a class="btn btn-info" href="bodylist"> 返回 </a>
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
		</div>
		<!--/row-->

	</div>
	<!--/.fluid-container-->
	<br />
	<input type="hidden" id="userId" value="${sessionScope.loginuser.id}" />
	<%@ include file="/common/footer.jsp"%>
</body>
</html>
