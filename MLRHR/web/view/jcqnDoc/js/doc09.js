
var apply_id =  $.query.get("applyid") ;
function initExpertVote() {
	$.ajax({
		type : 'get',
		dataType : 'json',
		url : 'expertVoteLists?applyid=' + apply_id,// 请求的路径
		error : function() {// 请求失败处理函数
			alert('请求失败');
		},
		success : function(data) { // 请求成功后处理函数。
			initExpertMangerDataTables(data);
			

		}
	});

}
function initExpertMangerDataTables(data) {
	if (oTable) {
		oTable.fnClearTable(false);
		$('#expertVote').dataTable().fnDestroy();
	}
	oTable = $('#expertVote').dataTable({
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
					"data" : "expert_sug",
					"class" : "center",
				}]
	});
}




