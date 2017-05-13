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

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
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
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<%@ include file="/common/jquery.noty.jsp"%>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#tbl_newslist").dataTable(
	{
		"aaSorting" : [ [ 2, "desc" ] ],
		"sDom" : "flrt<ip>",
		"sPaginationType" : "full_numbers",
		"oLanguage" : {
			"sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sZeroRecords": "对不起，查询不到任何相关数据",
                    "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                    "sInfoEmpty": "找不到相关数据",
                    "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
                    "sProcessing": "正在加载中...",
                    "sSearch": "搜索",
                    "oPaginate": {
                        "sFirst": "第一页",
                        "sPrevious": " 上一页 ",
                        "sNext": " 下一页 ",
                        "sLast": " 最后一页 "
                        }
		}
	});
});
		function delfile(id){
			noty({
				  text: '是否删除本条新闻？',
				  type: 'confirm',
			        dismissQueue: false,
			        closeWith: ['click','button'],
			        timeout: 3000,
			  		layout: 'center',
			  		theme: 'defaultTheme',
				  buttons: [
				    {addClass: 'btn btn-primary', text: '确定', onClick: function($noty) {
				    	$noty.close();
				    	var url = '${ctx}/newsdel';
						var datas = 'id='+id;
						$.ajax({
					  		type: 'post',
					  		dataType:'text',
					  		url: url,
					  		data:datas,
					  		success: function(result, textStatus){
					  			var rst=eval('('+result+')');
					  			if (rst.result == 1) {
									noty({
												text : '删除成功！',
												type : 'success',
												dismissQueue : false,
												closeWith : ['click', 'button'],
												timeout : 1500,
												layout : 'center',
												callback : {
													afterClose : function() {
														location.reload();
													}
												},
												theme : 'defaultTheme'
											});
								}
								
					  		},
					  		error: function(XMLHttpRequest, textStatus, errorThrown){
					  			generatenoty('center','删除失败，请重试！','error');
					  		}
					  		});
				      }
				    },
				    {addClass: 'btn btn-danger', text: '取消', onClick: function($noty) {
				        $noty.close();
				      }
				    }
				  ]
				});
		}
</script>
</head>
<body><%@ include file="/common/bodyheader.jsp"%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="row-fluid">
				<div class="page-header">
					<h2>新闻公告</h2>
				</div>
				<div class="span11">

					<security:authorize ifAnyGranted="ROLE_PROFESSOR">
						<div style="text-align: left;">
							<a class="btn btn-small btn-info" href="${ctx}/addnews">
								<i class="icon-plus-sign"></i>增加
							</a>
						</div>
						<br />
					</security:authorize>
					<div class="row-fluid">
						<table id="tbl_newslist" class="table table-hover table-bordered table-striped">
							<thead>
								<tr>
									<th width="30%" style="text-align: center;">新闻标题</th>
									<th width="10%" style="text-align: center;">发布者</th>
									<th width="15%" style="text-align: center;">发布日期</th>
									<th width="15%" style="text-align: center;">是否首页显示</th>
									<th width="10%" style="text-align: center;">是否置顶</th>
									<th width="20%" style="text-align: center;">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="news" items="${newslist}">
									<tr>
										<td>${news.title}</td>
										<td style="text-align: center;">${news.author}</td>
										<td style="text-align: center;">${news.pub_date}</td>
										<td style="text-align: center;">
											<c:if test="${news.top=='top'}">
												<a id="unpaid" href="javascript:void(0)" class="btn btn-small">
													<i class="icon-ok"></i>
												</a>
											</c:if>
											<c:if test="${news.top=='none'}">
												<a id="unpaid" href="javascript:void(0)" class="btn btn-small">
													<i class="icon-remove"></i>
												</a>
											</c:if>
										</td>
										<td style="text-align: center;">
											<c:if test="${news.first==-1}">
												<a id="unpaid" href="javascript:void(0)" class="btn btn-small">
													<i class="icon-ok"></i>
												</a>
											</c:if>
											<c:if test="${news.first>-1}">
												<a id="unpaid" href="javascript:void(0)" class="btn btn-small">
													<i class="icon-remove"></i>
												</a>
											</c:if>
										</td>
										<td style="text-align: center;">
											<button class="btn btn-small btn-info" onClick="location.href='${ctx}/newsdetail?id=${news.id}'">
												<i class="icon-search"></i>详情
											</button>
											<security:authorize ifAnyGranted="ROLE_PROFESSOR">
												<button class="btn btn-small btn-info" onClick="location.href='${ctx}/newsedit?id=${news.id}'">
													<i class="icon-edit"></i>编辑
												</button>

												<a href="javascript:void(0)" onClick="delfile('${news.id}')" id="btndel" class="btn btn-small btn-info">
													<i class="icon-remove"></i>删除
												</a>
											</security:authorize>
										</td>
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
		<!--/row-->
		<hr>


	</div>
	<!--/.fluid-container-->

	<%@ include file="/common/footer.jsp"%>
</body>
</html>
