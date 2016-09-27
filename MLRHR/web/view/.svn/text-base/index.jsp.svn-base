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

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
body {
	padding-top: 80px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
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
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.columnFilter.js"></script>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
<!-- Fav and touch icons -->
<script type="text/javascript">
	var oTable = null;
// 	$(document).ready(function() {
// 		$("#bodyHeaderMenuId").hide();
// 		$.ajax({
// 			type : 'get',
// 			dataType : 'json',
// 			url : 'calendarSelect',// 请求的路径
// 			error : function() {// 请求失败处理函数
// 				alert('请求失败');
// 			},
// 			success : function(data) { // 请求成功后处理函数。
// 				if (data.result == 0) {
// 					noty({
// 						text : '当前不在申请时间范围内！',
// 						type : 'error',
// 						dismissQueue : false,
// 						closeWith : [ 'click', 'button' ],
// 						timeout : 1500,
// 						layout : 'center',
// 						callback : {
// 							afterClose : function() {
// 								location.href = 'j_spring_security_logout';
// 							}
// 						},
// 						theme : 'defaultTheme'
// 					});
// 				} else {
// 					$("#bodyHeaderMenuId").show();
// 				}
// 			}
// 		});
// 	});
</script>
</head>
<body>
	<%@ include file="/common/bodyheader.jsp"%>
	<div class="container-fluid">

		<div class="page-header">
			<h2>首页</h2>
		</div>
		<div class="row-fluid">
			<div class="span6" style="width: 100%">
				<div class="row-fluid">
					<table id="tbl_newslist" class="table table-hover table-bordered table-striped">
						<thead>
							<tr>
								<th width="85%">新闻公告</th>
								<th><a style="cursor: pointer;" onClick="location.href='${ctx}/newslist'">更多...</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="news" items="${topnews}">
								<tr>

									<td>
										<a style="cursor: pointer;" onClick="location.href='${ctx}/newsdetail?id=${news.id}'">${news.title}</a>
									</td>
									<td>${news.pub_date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--/row-->
			</div>
			<!--/span-->
		</div>
	</div>
	<!--/.fluid-container-->

	<%@ include file="/common/footer.jsp"%>
	<%@ include file="/common/jquery.noty.jsp"%>
	<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
</body>
</html>
