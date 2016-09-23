var oTableUserProject = null;
function initUserProject() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'userProjectList?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					initUserProjectDataTables(data);
				}
			});

}

function initUserProjectDataTables(data) {
	if(data.length>=6)
	{
		$('#userProjectAddButton').attr("disabled",true);
		$('#userProjectAddButton').removeAttr("onclick");
		$('#userProjectAddButton').attr("class", "btn btn-small btn-inverse"); 
	}
	else
	{
		$('#userProjectAddButton').removeAttr("disabled");
		$('#userProjectAddButton').attr("onclick","userProjectEdit();");
		$('#userProjectAddButton').attr("class", "btn btn-small btn-info"); 
	}
	if (oTableUserProject) {
		oTableUserProject.fnClearTable(false);
		$('#userProjectList').dataTable().fnDestroy();
	}
	oTableUserProject = $('#userProjectList').dataTable({
		"aaSorting" : [[0, "desc"]],
		"sDom" : "flrt<ip>",
		"sPaginationType" : "full_numbers",
		"bDestory" : true,
		"bRetrieve" : true,
		"bStateSave" : false,
		"oLanguage" : {
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "对不起，查询不到任何相关数据",
			"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
			"sInfoEmpty" : "找不到相关数据",
			"sInfoFiltered" : "数据表中共为 _MAX_ 条记录",
			"sProcessing" : "正在加载中...",
			"sSearch" : "搜索",
			"oPaginate" : {
				"sFirst" : "第一页",
				"sPrevious" : " 上一页 ",
				"sNext" : " 下一页 ",
				"sLast" : " 最后一页 "
			}
		},
		"processing" : true,
		"data" : data,
		"columns" : [{
					"data" : "xuhao_id",
					"class" : "center"
				}, {
					"data" : "entryName",
					"class" : "center"
				}, {
					"data" : "projectNumber"
				},{
					"data" : "funds"
				}, {
					"data" : "startStopTime"
				}, {
					"data" : "projectNature"
				}, {
					"data" : "role"
				}, {
					"data" : null,
					"class" : "center",
					"render" : function(data) {
						return "<a class='btn btn-small btn-info'   style='margin: 2.5px;' href='javascript:void(0)' onClick='userProjectEdit(" + data.id
								+ ")'><i class='icon-edit'></i>编辑</a><a class='btn btn-small btn-info'  style='margin: 2.5px;'  href='javascript:void(0)' onClick='userProjectDelete(" + data.id
								+ ")' id='btndel'><i class='icon-remove'></i>删除</a>";
					}
				}]
	});
}

function userProjectEdit(id) {
	$("#myModalSave").unbind("click");
	$("#myModalSave").click(function() {
				userProjectEditSave();
			});
	if (id == null) {
		$("#myModalTitle").text("添加承担项目");
		$(".modal-body").load("userProjectEdit");
		$('#myModal').modal();
	} else {
		$("#myModalTitle").text("修改承担项目");
		$(".modal-body").load("userProjectEdit?id=" + id);
		$('#myModal').modal('show');
	}
}

function userProjectDelete(id) {
	if (id != null) {
		noty({
					text : '是否继续删除该条数据?',
					type : 'confirm',
					dismissQueue : false,
					closeWith : ['click', 'button'],
					timeout : 2000,
					layout : 'center',
					theme : 'defaultTheme',
					buttons : [{
								addClass : 'btn btn-primary',
								text : '确定',
								onClick : function($noty) {
									$noty.close();
									var url = 'userProjectDelete';
									var datas = 'id=' + id;
									$.ajax({
												type : 'post',
												dataType : 'text',
												url : url,
												data : datas,
												success : function(result, textStatus) {
													var rst = eval('(' + result + ')');
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
																			initUserProject();
																		}
																	},
																	theme : 'defaultTheme'
																});
													}
												},
												error : function(XMLHttpRequest, textStatus, errorThrown) {
													generatenoty('center', 'FAILED to delete this news! \n\nPlease contact Administrator or try again later.', 'error');
												}
											});
								}
							}, {
								addClass : 'btn btn-danger',
								text : '取消',
								onClick : function($noty) {
									$noty.close();
								}
							}]
				});
	}
}
