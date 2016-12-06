var id = $.query.get("id");
var oTable = null;
var currentRole;
var jcqn_zhichengApply;
var hasOne;
var createNewPDF = true;
//登陆者Id
var zhichengId = $("#userId").val();
var role_type = 2 ;
var user_id ;

//initUser() ;
$(document).ready(function() {
			if (id == null) {
				zhichengId = $("#userId").val();
				initZhichengApply();
			} else {
				zhichengId = id;
			}
		});

var groupId ;
function initZhichengApply() {
	console.log(groupId);
//	if (zhichengId != null)
	var arrData = new Array();

arrData.push({
		"name" : "role_type",
		"value" : role_type
	});

		$.ajax({
			         type : 'get',
			        dataType : 'json',
			        data : arrData,
					url : 'expertzhichengApplylistInit',// 请求的路径
					error : function() {// 请求失败处理函数
						alert('请求失败');
					},
					success : function(data) { // 请求成功后处理函数。
						
						initZhichengApplyDataTables(data);
					}
				});

}

function initZhichengApplyDataTables(data) {
	if (oTable) {
		oTable.fnClearTable(false);
		$('#zhichengApplyList').dataTable().fnDestroy();
	}
	oTable = $('#zhichengApplyList').dataTable({
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
		}, {
					"data" : null,
					"class" : "center",
					"render" : function(data) {
					
							return "<a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='zhichengApplyEdit("
									+ data.apply_id +","+"\/"+data.type+"\/"+","+data.user_id+","+zhichengId+","+"true"+")'><i class='icon-search'></i>审核</a>";
					}
				}]
	});
}

function zhichengApplyEdit(id,type,userId,expert_id,expert) {
	console.log("申请类型："+type);
	location.href = 'zhichengApply?apply_id=' + id+"&applyType="+type+"&userId="+userId+"&user_id="+expert_id+"&expert="+expert;
}


// 生成PDF
function PDFCreater(object) {
	zhichengApply = object;
	if (zhichengApply.status == "已结束" && zhichengApply.file_name != ""&&!createNewPDF) {
		var curWwwPath = window.document.location.href;
		// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		// 获取主机地址，如： http://localhost:8083
		var localhostPaht = curWwwPath.substring(0, pos);
		var url = localhostPaht + "/exportFile/" + zhichengApply.file_name;
		window.open(url, "_blank");
	} else {
		$.ajax({
					type : 'get',
					dataType : 'json',
					url : 'MyPDFCreate?zhichengApply_id=' + zhichengApply.id,// 请求的路径
					error : function() {// 请求失败处理函数
						alert('请求失败');
					},
					success : function(rst) { // 请求成功后处理函数。
						if (rst.filename != "") {
							// alert('请求成功');
							var curWwwPath = window.document.location.href;
							// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
							var pathName = window.document.location.pathname;
							var pos = curWwwPath.indexOf(pathName);
							// 获取主机地址，如： http://localhost:8083
							var localhostPaht = curWwwPath.substring(0, pos);
							// 获取带"/"的项目名，如：/uimcardprj
							// var
							// projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
							var url = localhostPaht + "/exportFile/" + rst.filename;
							window.open(url, "_blank");
							initZhichengApply(zhichengId);
						}
					}
				});
	}
}




