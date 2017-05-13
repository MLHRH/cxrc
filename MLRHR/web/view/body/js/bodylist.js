var oTable = null;
var zNodes = "";
var currentRole;
var currentNode;
var body_id;
var userId = $("#userId").val();
var setting = {
	data : {
		key : {
			title : "name"
		},
		simpleData : {
			enable : true
		}
	},
	callback : {
		beforeClick : zTreeBeforeClick,
		onClick : onClick
	}
};
var log, className = "dark";
$(document).ready(function() {
			$.ajax({
						type : 'get',
						dataType : 'json',
						url : 'bodytree',// 请求的路径
						error : function() {// 请求失败处理函数
							alert('请求失败');
						},
						success : function(data) { // 请求成功后处理函数。
							$.fn.zTree.init($("#treeDemo"), setting, data[0]);
							var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
							treeObj.expandAll(true);
							var selectedTreeId = $("#bodyId").val();
							currentNode = treeObj.getNodeByParam("id", selectedTreeId);
							treeObj.selectNode(currentNode, false);
							setDetail(currentNode);
							// searchUser(currentNode.id);

							var authority = data[1].authority;
							var arr = authority.split("|");

							if (currentRole == null)
								for (var i = 0; i < arr.length - 1; i++) {
									if (arr[i] == "ROLE_PROFESSOR") {
										currentRole = arr[i];
									}
								}
							if (currentRole == null)
								for (var i = 0; i < arr.length - 1; i++) {
									if (arr[i] == "ROLE_HR") {
										currentRole = arr[i];
									}
								}
							if (currentRole == null)
								for (var i = 0; i < arr.length - 1; i++) {
									if (arr[i] == "ROLE_USER") {
										currentRole = arr[i];
									}
								}
						}
					});
		});

function zTreeBeforeClick(treeId, treeNode, clickFlag) {
	if (currentRole == "ROLE_USER") {
		return false;
	}
//	if (currentRole == "ROLE_HR") {
//		return false;
//	}
//	if (currentRole == "ROLE_PROFESSOR") {
//		return true;
//	}
}
function onClick(event, treeId, treeNode, clickFlag) {
	setDetail(treeNode);
	// searchUser(treeNode.id);
}
function setDetail(treeNode) {
	body_id = treeNode.id;
	$("#currAccount").html();
//	if (treeNode.level == 1 || treeNode.level == 0) {
//		$("#currAccount").load("hrstatisticOfBody", function() {
//					 initHrstatisticOfBody();
//				});
//	} else {
//		$("#currAccount").load("hrstatistic", function() {
//					initHrstatistic();
//				});
//	}
	$("#currAccount").load("hrstatistic", function() {
					initHrstatistic();
				});
}
function searchUser(body_id) {
	// $.ajax({
	// type : 'get',
	// dataType : 'json',
	// url : 'bodyTreeClick?body_id=' + body_id,// 请求的路径
	// error : function() {// 请求失败处理函数
	// alert('请求失败');
	// },
	// success : function(data) { // 请求成功后处理函数。
	// initBodyListDataTables(data);
	// }
	// });
	// initHrstatistic();
}
function initBodyListDataTables(data) {
	if (oTable) {
		oTable.fnClearTable(false);
		$('#bodyList').dataTable().fnDestroy();
	}
	oTable = $('#bodyList').dataTable({
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
							"data" : "name",
							"class" : "center"
						}, {
							"data" : "email"
						},  {
							"data" : "loginName"
						},{
							"data" : "id_num"
						}, {
							"data" : null,
							"class" : "center",
							"render" : function(data) {
								return "<a class='btn btn-small btn-info' href='javascript:void(0)' onClick='bodyListCheck(" + data.id + ")'><i class='icon-search'></i> 人才审核</a>";
							}
						}]
			});
}
function bodyListCheck(id) {
	location.href = 'zhichengApplylist?id=' + id;
}
function delfile(id) {
	noty({
				text : 'Confirm to delete the seleted body?',
				type : 'confirm',
				dismissQueue : false,
				closeWith : ['click', 'button'],
				timeout : 3000,
				layout : 'center',
				theme : 'defaultTheme',
				buttons : [{
							addClass : 'btn btn-primary',
							text : 'Yes',
							onClick : function($noty) {
								$noty.close();
								var url = 'bodydel';
								var datas = 'id=' + id;
								$.ajax({
											type : 'post',
											dataType : 'text',
											url : url,
											data : datas,
											success : function(result, textStatus) {
												var rst = eval('(' + result + ')');
												if (rst.result != 1) {
													generatenoty('center', rst.msg, 'error');
													location.reload();
													return;
												}
												generatenoty('center', rst.msg, 'success');
												location.reload();
											},
											error : function(XMLHttpRequest, textStatus, errorThrown) {
												generatenoty('center', 'FAILED to delete this body! \n\nPlease contact Administrator or try again later.', 'error');
											}
										});
							}
						}, {
							addClass : 'btn btn-danger',
							text : 'Cancel',
							onClick : function($noty) {
								$noty.close();
							}
						}]
			});
}