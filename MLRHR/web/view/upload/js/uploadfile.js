//申请ID
var applyid;
var oTable = null;
var currentRole;

function initUpFile() {
	$("#applyid").val(applyid);
	console.log("申请ID："+applyid);
	console.log("角色："+currentRole);
	if(currentRole != "ROLE_USER"){
		$("#importBtn").hide();
	}
	var arrData = new Array();
	arrData.push({
				"name" : "applyid",
				"value" : applyid,
			});
	$.ajax({
				type : 'get',
				dataType : 'json',
				data : arrData,
				url : "showUpLoadFile",// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					initFileMangerDataTables(data);
				}
			});
}
function initFileMangerDataTables(data) {
	if (oTable) {
		oTable.fnClearTable(false);
		$('#fileManager').dataTable().fnDestroy();
	}
	oTable = $('#fileManager').dataTable({
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
					"data" : "oldfilename",
					"class" : "center"
				}, {
					"data" : "upload_time",
					"class" : "center"
				},{
					"data" : null,
					"class" : "center",
					"render" : function(data) {
						if(currentRole != "ROLE_USER"){
							return "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='downLoadFile(" + data.id
							+ ")'><i class='icon-edit'></i>下载</a>";
						}
						else{
							return "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='downLoadFile(" + data.id
							+ ")'><i class='icon-edit'></i>下载</a>"
							+"<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='delFile(" + data.id
							+ ")'><i class='icon-edit'></i>删除</a>";
						}
					}
				}]
	});
}

function delFile(id){
	arrData = new Array();
	if ($("#applyId").val() != "") {
		arrData.push({
					"name" : "fileId",
					"value" : id
				});
		$.ajax({
			"dataType" : 'json',
			"type" : "get",
			"url" : "delFile",
			"data" : arrData,
			"success" : function(data) {
				if (data.status == 0) {
					noty({
						text : data.msg,
						type : 'success',
						dismissQueue : false,
						maxVisible:false,
						closeWith : ['click', 'button'],
						timeout : 3000,
						layout : 'top',
						callback : {
							afterClose : function() {
								initUpFile();
							}
						},
						theme : 'defaultTheme'
					});
				} else if (data.status == 1) {
					noty({
						text : data.msg,
						type : 'error',
						dismissQueue : false,
						maxVisible:false,
						closeWith : ['click', 'button'],
						timeout : 3000,
						layout : 'center',
						callback : {
							afterClose : function() {
								initUpFile();
							}
						},
						theme : 'defaultTheme'
					});
				} 
			}
		});
	}
	else{
		generatenoty('center', '更新失败！', 'error');
	}
}
function downLoadFile(id){
	location.href = 'downloadfile?fileid=' + id;
}