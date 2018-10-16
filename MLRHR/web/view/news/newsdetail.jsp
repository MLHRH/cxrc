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

#news_content {
	max-height: 600px;
	height: 600px;
	background-color: white;
	border-collapse: separate;
	border: 1px solid rgb(204, 204, 204);
	padding: 4px;
	box-sizing: content-box;
	-webkit-box-shadow: rgba(0, 0, 0, 0.0745098) 0px 1px 1px 0px inset;
	box-shadow: rgba(0, 0, 0, 0.0745098) 0px 1px 1px 0px inset;
	border-top-right-radius: 3px;
	border-bottom-right-radius: 3px;
	border-bottom-left-radius: 3px;
	border-top-left-radius: 3px;
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

.sidebar-nav {
	padding: 9px 0;
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
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.columnFilter.js"></script>
<script type="text/javascript" src="${ctx}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/google-code-prettify/prettify.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/jquery.hotkeys.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/bootstrap-wysiwyg.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/google-code-prettify/prettify.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/jquery.hotkeys.js"></script>
<script type="text/javascript" src="${ctx}/view/upload/js/newuploadfile.js"></script>
<%@ include file="/common/jquery.noty.jsp"%>
<script>

	$(document).ready(function() {
		$('#news_content').wysiwyg();
	});
	
	function uploadNewsFileinfo() {
		var id = $("#id").val();
		/* $("#newsFileDocTitle").text("查看"); */
		$("#newsFileDocBodyId").load("newuploadfile?ft=1&num=1&id="+id);
		$('#newsFileDoc').modal();
	}
</script>
<body>
	<%@ include file="/common/bodyheader.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="row-fluid">

				<div class="page-header">
					<h2>${news.title}</h2>
				</div>
               <div class="modal hide" id="newsFileDoc" style="width: 794px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h3 id="newsFileDocTitle">附件窗口</h3>
					</div>
					<div id="newsFileDocBodyId" class="modal-body" style="min-height: 300px; max-height: 500px;"></div>
					<div class="modal-footer">
						<a href="javascript:void(0)" data-dismiss="modal" class="btn">关闭</a>
					</div>
				</div>
				<div class="span11">
					<div class="well">
					<input type="hidden" id="id" name="id" value="${news.id}" />
						<h2></h2>
						<p>${news.author}|${news.pub_date}</p>
						<%-- <c:if test="${news.type==0}"> --%>
							<div id="news_content">${news.content}</div>
						<%-- </c:if>
						<c:if test="${news.type==1}">
							<a href="${news.content}" style="cursor：pointer">附件下载</a>
						</c:if> --%>
					<div class="control-group">
					<div class="control-group">
							<label class="control-label" for="doc">附件</label>
							<div class="controls">
								<div id="doc">
									<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadNewsFileinfo()">
										<i class="icon-upload"></i>查看
									</a>
								</div>
							</div>
						</div> 
					</div>
						<div class="controls">
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
