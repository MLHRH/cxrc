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

#inputcontent {
	max-height: 400px;
	height: 400px;
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
<%@ include file="/common/jquery.noty.jsp"%>
<script>
	$(document).ready(function() {
		$('#inputcontent').wysiwyg();
		$("#submit").click(function() {
			$("#newsedit").validate({
				highlight : function(label) {
					$(label).closest('.control-group').addClass('error');
				},
				unhighlight : function(label) {
					$(label).closest('.control-group').removeClass('error');
				},
				errorElement : 'span',
				submitHandler : function() {
					arrData = new Array();
					arrData.push({
						"name" : "id",
						"value" : $("#id").val()
					});
					arrData.push({
						"name" : "title",
						"value" : $("#inputtitle").val()
					});
					arrData.push({
						"name" : "top",
						"value" : $('input[name="top"]:checked ').val()
					});
					arrData.push({
						"name" : "type",
						"value" : $('input[name="type"]:checked ').val()
					});
					arrData.push({
						"name" : "first",
						"value" : $('input:checkbox:checked').val()
					});
					arrData.push({
						"name" : "content",
						"value" : $("#inputcontent").html()
					});
					$.ajax({
						"dataType" : 'json',
						"type" : "post",
						"url" : "${ctx}/newsupdate",
						"data" : arrData,
						"success" : function(rst) {
							if (rst.result == 1) {
								noty({
									text : '新闻更新成功！',
									type : 'success',
									dismissQueue : false,
									closeWith : [ 'click', 'button' ],
									timeout : 3000,
									layout : 'top',
									callback : {
										afterClose : function() {
											location.href = '${ctx}/newslist';
										}
									},
									theme : 'defaultTheme'
								});
							} else {
								generatenoty('center', rst.msg, 'error');
							}
						}
					});
				}
			});
		});
	});
	function uploadNewsFile() {
		$("#newsFileDocTitle").text("管理附件");
		$("#newsFileDocBodyId").load("uploadfile?ft=1&num=1");
		$('#newsFileDoc').modal();
	}
</script>
<body>
	<%@ include file="/common/bodyheader.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="row-fluid">

				<div class="page-header">
					<h2>新闻编辑页面</h2>
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
				<div class="span9">
					<form id="newsedit" class="form-horizontal" method="post" action="${ctx}/newsupdate">
						<input type="hidden" id="id" name="id" value="${news.id}" />
						<div class="control-group">
							<label class="control-label" for="inputtitle">新闻标题</label>
							<div class="controls">
								<textarea rows="4" id="inputtitle" class="input-xxlarge form-control" name="title" class="required">${news.title}</textarea>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="inputtop">是否首页显示</label>
							<div class="controls">
								<c:if test="${news.top=='top'}">
									<label class="radio">
										<input type="radio" name="top" id="inputtop1" value="top" checked />
										Yes
									</label>
									<label class="radio">
										<input type="radio" name="top" id="inputtop2" value="none" />
										No
									</label>

								</c:if>
								<c:if test="${news.top=='none'}">
									<label class="radio">
										<input type="radio" name="top" id="inputtop1" value="top" />
										Yes
									</label>
									<label class="radio">
										<input type="radio" name="top" id="inputtop2" value="none" checked />
										No
									</label>

								</c:if>

							</div>

						</div>

						<div class="control-group">
							<label class="control-label" for="inputfirst">是否置顶</label>
							<div class="controls">
								<c:if test="${news.first==-1}">
									<label class="checkbox">
										<input type="checkbox" name="first" id="inputfirst" value="-1" checked />
										Yes
									</label>
								</c:if>
								<c:if test="${news.first>-1}">
									<label class="checkbox">
										<input type="checkbox" name="first" id="inputfirst" value="-1" />
										Yes
									</label>
								</c:if>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="inputcontent">新闻正文</label>
							<div class="controls">
								<div id="inputcontent">${news.content}</div>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="doc">附件管理</label>
							<div class="controls">
								<div id="doc">
									<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadNewsFile()">
										<i class="icon-upload"></i>管理
									</a>
								</div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="doc">发布形式</label>
							<div class="controls">
								<div id="doc">
									<c:if test="${news.type==1}">
										<label class="radio">
											<input type="radio" name="type" id="news_type" value="0" />
											新闻
										</label>
										<label class="radio">
											<input type="radio" name="type" id="news_type" value="1" checked />
											附件
										</label>
									</c:if>
									<c:if test="${news.type!=1}">
										<label class="radio">
											<input type="radio" name="type" id="news_type" value="0" checked />
											新闻
										</label>
										<label class="radio">
											<input type="radio" name="type" id="news_type" value="1" />
											附件
										</label>
									</c:if>

								</div>
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<input id="submit" type="submit" class="btn btn-primary" value="提交">
								<button type="button" class="btn " onClick="javascript:history.back(-1);">返回</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<hr>
		<%@ include file="/common/footer.jsp"%>

	</div>
	<!--/.fluid-container-->
</body>
</html>
