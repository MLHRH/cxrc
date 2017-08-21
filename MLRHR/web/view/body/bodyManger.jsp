<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
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

#currRight span {
	color: #064c06;
	float: left;
	font-size: 14px;
	height: 30px;
	margin-left: 12px;
	margin-top: 10px;
	/* 	width: 260px; */
	display: block;
	text-align: left;
	font-size: 14px;
}

.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
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
<script type="text/javascript" src="${ctx}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/view/body/js/bodyManger.js"></script>
<script type="text/javascript" src="${ctx}/view/body/js/userEdit.js"></script>
</head>
<body>
	<%@ include file="/common/bodyheader.jsp"%>
	<div class="modal hide" id="myModal" style="width: 400px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3 id="myModalTitle">附件窗口</h3>
		</div>
		<div class="modal-body" style="min-height: 200px; max-height: 400px; padding-left: 0; padding-right: 0;"></div>
		<div class="modal-footer">
			<a id="myModalSave" class="btn btn-primary" style="margin-right: 5px" href='javascript:void(0)' onclick="" class='btn'>保存</a>
			<a href='javascript:void(0)' data-dismiss='modal' class='btn'>取消</a>
		</div>
	</div>
	<div class="container-fluid" style="margin-bottom: 20px">
		<div class="row-fluid">
			<div class="page-header" align="left">
				<h2>机构管理</h2>
			</div>
			<div class="row-fluid" align="center">

				<div id="nav" class="well sidebar-nav" style="float: left; width: 280px;">
					<ul id="treeDemo" class="ztree nav nav-list"></ul>
				</div>
				<div class="span9" style="margin-left: 20px; border-radius: 4px; padding: 3px;">
					<ul class="nav nav-tabs" id="myTab">
						<li id="nav1" class="active" onclick="setStatus(0)">
							<a href="javascript:void(0)">普通职工</a>
						</li>
						<li id="nav2" onclick="setStatus(1)">
							<a href="javascript:void(0)">初级管理员</a>
						</li>
						<li id="nav3" onclick="setStatus(2)">
							<a href="javascript:void(0)">高级管理员</a>
						</li>
						<li id="nav4" onclick="setStatus(3)">
							<a href="javascript:void(0)">初审专家</a>
						</li>
						<li id="nav5" onclick="setStatus(4)">
							<a href="javascript:void(0)">复审专家</a>
						</li>
					</ul>
					<div style="text-align: left;">
						<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="userEdit()">
							<i class="icon-plus-sign"></i>添加
						</a>
					</div>
					<div style="text-align: left;">
						<b> <span style='font-size: 10.0pt; font-family: 黑体; letter-spacing: 1.0pt'><font color=red >(添加专家后，需要专家先登录完善个人档案后再进行审核)</font></span>
			</b>
					</div>
					<div class="xline" style="border-bottom: 1px dashed #b3b3b3; height: 10px"></div>
					<div id="userDetail" class="row-fluid" style="padding-top: 10px;">
						<table id="bodyManger" class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
							<thead valign="middle">
								<tr>
									<th width="20%" style="text-align: center;">姓名</th>
									<th width="20%" style="text-align: center;">身份证号码</th>
									<th width="20%" style="text-align: center;">登陆用户名</th>
									<th width="20%" style="text-align: center;">登陆密码</th>
									<th width="20%" style="text-align: center;">操作</th>
								</tr>
							</thead>
						</table>
					</div>
					<!--/row-->
				</div>
				<!--/span-->
			</div>
		</div>
	</div>
	<!--/.fluid-container-->
	<input type="hidden" id="bodyId" value="${sessionScope.loginuser.body_id}" />
	<%@ include file="/common/footer.jsp"%>
</body>
</html>
