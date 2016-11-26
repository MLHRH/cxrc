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

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
	
}
</style>
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/jquery.dataTables.css" type="text/css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="${ctx}/static/jquery/lightSlider/css/lightSlider.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/static/jquery/magiczoomplus/magiczoomplus.css" media="screen" />

<script type="text/javascript" src="${ctx}/static/jquery/DataTables-1.10.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/lightSlider/js/jquery.lightSlider.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/magiczoomplus/magiczoomplus.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/pdfobject.js"></script>

<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/expertUserBase.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/expertBaseinfo.js"></script>


<script type="text/javascript" src="${ctx}/view/doc/js/doc02.js"></script>
<script type="text/javascript" src="${ctx}/view/doc/js/doc02_middle.js"></script>
<script type="text/javascript" src="${ctx}/view/doc/js/doc03.js"></script>
<script type="text/javascript" src="${ctx}/view/doc/js/doc03_middle.js"></script>
<script type="text/javascript" src="${ctx}/view/fileManager/js/checkFile.js"></script>
<script type="text/javascript" src="${ctx}/view/fileManager/js/checkFilePDF.js"></script>


<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<%@ include file="/common/jquery.noty.jsp"%>
</head>
<body><%@ include file="/common/bodyheader.jsp"%>
	<div class="modal hide" id="myModal" style="width: 600px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3 id="myModalTitle">附件窗口</h3>
		</div>
		<div class="modal-body" style="min-height: 300px; max-height: 600px; padding-left: 0; padding-right: 0;"></div>
		<div class="modal-footer">
			<a id="myModalSave" class="btn btn-primary" style="margin-right: 5px" href='javascript:void(0)' onclick="" class='btn'>保存</a>
			<a href='javascript:void(0)' data-dismiss='modal' class='btn'>取消</a>
		</div>
	</div>
	<div class="container-fluid">
		<div class="page-header">
			<h2>我的档案</h2>
		</div>
		<div class="row-fluid">
			<div class="span3" style="float: left; text-align: left;">
				<div class="well sidebar-nav" style="padding: 9px 0;">
					<ul class="nav nav-list" id="orderedlist">
						<li id="expertUserBase"><a href="javascript:void(0)"> 基本信息</a></li>
<!-- 						<li id="userExam"><a href="javascript:void(0)">11. 考试成绩及答辩情况</a></li> -->
<!-- 						<li id="doc02_middle"><a href="javascript:void(0)">12. 证书、证明材料管理</a></li> -->
<!-- 						<li id="doc03_middle"><a href="javascript:void(0)">13. 业绩、成果材料管理</a></li> -->
					</ul>
				</div>
			</div>

			<div class="span9" style="margin-left: 20px; padding: 3px;">
				<div class="row-fluid" id="content"></div>
				<!--/row-->
			</div>
			<!--/span-->
		</div>
		<input type="hidden" id="userId" value="${sessionScope.loginuser.id}" />
		<%@ include file="/common/footer.jsp"%>
	</div>
	<!--/.fluid-container-->
</body>
</html>
