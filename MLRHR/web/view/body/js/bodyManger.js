var oTable = null;
var zNodes = "";
var currentRole;
var currentNode;
var body_id;
var role_type = 0;
var setting = {
	view : {
		addHoverDom : addHoverDom,
		removeHoverDom : removeHoverDom,
		selectedMulti : false
	},
	edit : {
		enable : true,
		editNameSelectAll : true,
		showRemoveBtn : showRemoveBtn,
		showRenameBtn : showRenameBtn,
		renameTitle : "编辑",
		removeTitle : "删除"
	},
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
		beforeDrag : beforeDrag,
		beforeEditName : beforeEditName,
		beforeRemove : beforeRemove,
		beforeRename : beforeRename,
		onRemove : onRemove,
		onRename : onRename,
		onClick : onClick
	}
};
$(document).ready(function() {
			init();
			$('#myModal').on('hidden', function() {
						initUser();
					});
		});
function init() {
	var activeLiId = $("#myTab .active").attr('id');
	if (activeLiId == "nav1") {
		role_type = 0;
	}
	if (activeLiId == "nav2") {
		role_type = 1;
	}
	if (activeLiId == "nav3") {
		role_type = 2;
	}
	if (activeLiId == "nav4") {
		role_type = 3;
	}
	if (activeLiId == "nav5") {
		role_type = 4;
	}
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
								$('#nav3').hide();
							}
						}
					if (currentRole == null)
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_USER") {
								currentRole = arr[i];
								$('#nav2').hide();
								$('#nav3').hide();
							}
						}
				}
			});
}
function zTreeBeforeClick(treeId, treeNode, clickFlag) {
	if (currentRole == "ROLE_USER") {
		return false;
	}
	if (currentRole == "ROLE_HR") {
		return false;
	}if (currentRole == "ROLE_EXPERT1") {
		return false;
	}if (currentRole == "ROLE_EXPERT2") {
		return false;
	}
	if (currentRole == "ROLE_PROFESSOR") {
		return true;
	}
}
function beforeDrag(treeId, treeNodes) {
	return false;
}
function beforeEditName(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.selectNode(treeNode);
	return true;
}
function beforeRemove(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.selectNode(treeNode);
	return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}
function onRemove(e, treeId, treeNode) {
	$.ajax({
				"dataType" : 'json',
				"type" : "post",
				"url" : "bodydel?id=" + treeNode.id,
				"success" : function(rst) {
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
											init();
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
function beforeRename(treeId, treeNode, newName, isCancel) {
	if (newName.length == 0) {
		alert("节点名称不能为空!");
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.cancelEditName();
		setTimeout(function() {
					zTree.editName(treeNode)
				}, 10);
		return false;
	}
	return true;
}
function onRename(e, treeId, treeNode, isCancel) {
	arrData = new Array();
	arrData.push({
				"name" : "id",
				"value" : treeNode.id
			});
	arrData.push({
				"name" : "pId",
				"value" : treeNode.pId
			});
	arrData.push({
				"name" : "name",
				"value" : treeNode.name
			});
	$.ajax({
				"dataType" : 'json',
				"type" : "post",
				"url" : "bodyupdate",
				"data" : arrData,
				"success" : function(rst) {
					if (rst.result == 1) {
					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
}
function showRemoveBtn(treeId, treeNode) {
	if (currentRole != "ROLE_PROFESSOR") {
		return false;
	} else {
		return !treeNode.isParent;
	}
}
function showRenameBtn(treeId, treeNode) {
	if (currentRole != "ROLE_PROFESSOR") {
		return false;
	} else {
		return true;
	}
}
var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
		return;
	if (currentRole != "ROLE_PROFESSOR") {
		return false;
	} else {
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='新增' onfocus='this.blur();'></span>";
		sObj.after(addStr);
	}
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.bind("click", function() {
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					zTree.addNodes(treeNode, {
								id : (100 + newCount),
								pId : treeNode.id,
								name : "new node" + (newCount++)
							});
					arrData = new Array();
					arrData.push({
								"name" : "pId",
								"value" : treeNode.id
							});
					arrData.push({
								"name" : "name",
								"value" : "new node" + (newCount++)
							});
					$.ajax({
								"dataType" : 'json',
								"type" : "post",
								"url" : "bodyupdate",
								"data" : arrData,
								"success" : function(rst) {
									if (rst.result == 1) {
										noty({
													text : '添加成功！',
													type : 'success',
													dismissQueue : false,
													closeWith : ['click', 'button'],
													timeout : 1500,
													layout : 'center',
													callback : {
														afterClose : function() {
															init();
														}
													},
													theme : 'defaultTheme'
												});
									} else {
										generatenoty('center', rst.msg, 'error');
									}
								}
							});
					return false;
				});
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
};
function onClick(event, treeId, treeNode, clickFlag) {
	setDetail(treeNode);
}
function setDetail(treeNode) {
	body_id = treeNode.id;
	initUser();
}
function initBodyMangerDataTables(data) {
	if (oTable) {
		oTable.fnClearTable(false);
		$('#bodyManger').dataTable().fnDestroy();
	}
	oTable = $('#bodyManger').dataTable({
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
					"data" : "id_num",
					"class" : "center"
				}, {
					"data" : "loginName",
					"class" : "center"
				}, {
					"data" : null,
					"class" : "center",
					"render" : function(data) {
						return "*********";
					}
				}, {
					"data" : null,
					"class" : "center",
					"render" : function(data) {
						return "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='userEdit(" + data.id
								+ ")'><i class='icon-edit'></i>编辑</a><a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='userDelete(" + data.id
								+ ")' id='btndel'><i class='icon-remove'></i>删除</a>";
					}
				}]
	});
}
function userEdit(id) {
	$("#myModalSave").unbind("click");
	$("#myModalSave").click(function() {
				userEditSave();
			});
	if (id == null) {
		$("#myModalTitle").text("添加人员信息");
		$(".modal-body").load("userEdit");
		$('#myModal').modal();
	} else {
		$("#myModalTitle").text("修改人员信息");
		$(".modal-body").load("userEdit?id=" + id);
		$('#myModal').modal();
	}
}

function userDelete(id) {
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
									var url = 'userdel';
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
																			init();
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
function setStatus(sta) {
	if (sta == 0) {
		$("#nav1").addClass("active")
		$("#nav2").removeClass("active")
		$("#nav3").removeClass("active")
		$("#nav4").removeClass("active")
		$("#nav5").removeClass("active")
	} else if (sta == 1) {
		$("#nav2").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav3").removeClass("active")
	    $("#nav4").removeClass("active")
		$("#nav5").removeClass("active")
	} else if(sta == 2){
		$("#nav3").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav2").removeClass("active")
		$("#nav4").removeClass("active")
		$("#nav5").removeClass("active")
	}
	 else if(sta == 3){
	    $("#nav4").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav2").removeClass("active")
		$("#nav3").removeClass("active")
		$("#nav5").removeClass("active")
		}
	 else if(sta == 4){
		$("#nav5").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav2").removeClass("active")
		$("#nav3").removeClass("active")
		$("#nav4").removeClass("active")
		}
	role_type = sta;
	initUser();
}
function initUser() {
	var arrData = new Array();
	arrData.push({
				"name" : "body_id",
				"value" : body_id
			});
	arrData.push({
				"name" : "role_type",
				"value" : role_type
			});
	$.ajax({
				type : 'get',
				dataType : 'json',
				data : arrData,
				url : 'userbybodyid',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					initBodyMangerDataTables(data[0]);
				}
			});
}
