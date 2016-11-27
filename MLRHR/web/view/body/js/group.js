var oTable = null;
var zNodes = "";
var currentRole;
var currentNode;
var group_id;
var role_type = 2;
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
		beforeDrag : beforeDrag,
		beforeRemove : beforeRemove,
		beforeEditName : beforeEditName,
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
			$("#expert_div").hide();
		});
function init() {

	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'groupTree',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					$.fn.zTree.init($("#treeDemo"), setting, data[0]);
					var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
					treeObj.expandAll(true);
					var selectedTreeId = data[0][0].id;
					currentNode = treeObj.getNodeByParam("id", selectedTreeId);
					treeObj.selectNode(currentNode, false);
					setDetail(currentNode);
				}
			});
}
function beforeDrag(treeId, treeNodes) {
	return false;
}
function showRemoveBtn(treeId, treeNode) {
	return !treeNode.isParent;
}
function showRenameBtn(treeId, treeNode) {
	return true;
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
				"type" : "get",
				"url" : "delGroup?id=" + treeNode.id,
				"success" : function(data) {
					if (data.status == 0) {
						noty({
									text : data.msg,
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
						generatenoty('center', data.msg, 'error');
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
				"url" : "updateGroup",
				"data" : arrData,
				"success" : function(data) {
					if (data.status == 0) {
					} else {
						generatenoty('center', data.msg, 'error');
					}
				}
			});
}

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
		return;
	
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='新增' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	
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
								"url" : "updateGroup",
								"data" : arrData,
								"success" : function(data) {
									if (data.status == 0) {
										noty({
													text : data.msg,
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
										generatenoty('center', data.msg, 'error');
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
	group_id = treeNode.id;
	initUser();
}
//待审核申请
function initApplyMangerDataTables(data) {
	if (oTable) {
		oTable.fnClearTable(false);
		$('#groupManager').dataTable().fnDestroy();
	}
	oTable = $('#groupManager').dataTable({
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
					"data" : "body",
					"class" : "center",
					"render" : function(data) {
							if(data == null){
								return "";
							}
							return data;
						}
				}, {
					"data" : "type",
					"class" : "center",
				}, {
					"data" : "date",
					"class" : "center"
				}, {
					"data" : "group",
					"class" : "center"
				},{
					"data" : null,
					"class" : "center",
					"render" : function(data) {
						return "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='applyEdit(" + data.apply_id
								+ ")'><i class='icon-edit'></i>编辑</a>";
					}
				}]
	});
}
//专家
function initExpertMangerDataTables(data) {
	if (oTable) {
		oTable.fnClearTable(false);
		$('#expertManager').dataTable().fnDestroy();
		$('#grouptManager').dataTable().fnDestroy();
	}
	oTable = $('#expertManager').dataTable({
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
					"data" : "body",
					"class" : "center"
				}, {
					"data" : "zhiCheng",
					"class" : "center",
				}, {
					"data" : "level",
					"class" : "center",
					"render" : function(data) {
						var team_leader_type = "";
						if(data == 1 ){
							team_leader_type = "组长";
						}
						else if(data == 2){
							team_leader_type = "副组长";
						}
						else{
							team_leader_type = "成员";
						}
						return team_leader_type
					}
				}, {
					"data" : "congShiFangXiang",
					"class" : "center"
				},{
					"data" : null,
					"class" : "center",
					"render" : function(data) {
						return "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='expertEdit(" + data.expertId
								+ ")'><i class='icon-edit'></i>编辑</a>";
					}
				}]
	});
}
function applyEdit(id) {
	$("#myModalSave").unbind("click");
	$("#myModalSave").click(function() {
		applyGroupSave();
			});
	if (id == null) {
		$("#myModalTitle").text("暂无分组信息");
		$(".modal-body").load("ApplyGroupInfo");
		$('#myModal').modal();
	} else {
		$("#myModalTitle").text("修改分组信息");
		$(".modal-body").load("ApplyGroupInfo?applyId=" + id);
		$('#myModal').modal();
	}
}
function expertEdit(id) {
	$("#myModalSave").unbind("click");
	$("#myModalSave").click(function() {
		expertGroupSave();
			});
	if (id == null) {
		$("#myModalTitle").text("暂无分组信息");
		$(".modal-body").load("expertGroupInfo");
		$('#myModal').modal();
	} else {
		$("#myModalTitle").text("修改分组信息");
		$(".modal-body").load("expertGroupInfo?expertId=" + id);
		$('#myModal').modal();
	}
}

function setStatus(sta) {
	if (sta == 2) {
		$("#nav1").addClass("active");
		$("#nav2").removeClass("active");
		$("#nav3").removeClass("active");
		$("#apply_div").show();
		$("#expert_div").hide();
	} else if (sta == 4) {
		$("#nav2").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav3").removeClass("active")
		$("#apply_div").hide();
		$("#expert_div").show();
	} else {
		$("#nav3").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav2").removeClass("active")
		$("#apply_div").hide();
		$("#expert_div").show();
	}
	role_type = sta;
	initUser();
}
function initUser() {
	var arrData = new Array();
	arrData.push({
				"name" : "group_id",
				"value" : group_id
			});
	arrData.push({
				"name" : "role_type",
				"value" : role_type
			});
	//根据角色确定
	var url_request = null;
	if(role_type == 2){
		url_request = "initApplyByGroupId";
	}
	else{
		url_request = "initExpertByGroupId"
	}
	$.ajax({
				type : 'get',
				dataType : 'json',
				data : arrData,
				url : url_request,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					if(role_type == 2){
						initApplyMangerDataTables(data);
					}
					else{
						initExpertMangerDataTables(data);
					}
				}
			});
}
