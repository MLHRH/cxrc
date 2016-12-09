//被审核ID
var id = $.query.get("id");
var oTable = null;
var currentRole;
var jcqn_zhichengApply;
var hasOne;
var user_id ;
var createNewPDF = true;

$(document).ready(function() {
	      user_id =$("#userId").val();
			if (id == null) {
				zhichengId = $("#userId").val();
//				user_id=$("#userId").val;
			} else {
//				user_id=$("#userId").val;
				zhichengId = id;
			}
			initZhichengApply(zhichengId);
			initCheckCalendar();
		});
function initZhichengApply(zhichengId) {
	console.log(zhichengId);
	if (zhichengId != null)
		$.ajax({
					type : 'get',
					dataType : 'json',
					url : 'zhichengApplylistInit?userId=' + zhichengId,// 请求的路径
					error : function() {// 请求失败处理函数
						alert('请求失败');
					},
					success : function(data) { // 请求成功后处理函数。
						var authority = data[1].authority;
						var arr = authority.split("|");
						
						if (currentRole == null)
							for (var i = 0; i < arr.length - 1; i++) {
								if (arr[i] == "ROLE_PROFESSOR") {
									currentRole = arr[i];
									$("#roleBack").show();
								}
							}
						if (currentRole == null)
							for (var i = 0; i < arr.length - 1; i++) {
								if (arr[i] == "ROLE_HR") {
									currentRole = arr[i];
									$("#roleBack").show();
								}
							}
						if (currentRole == null)
							for (var i = 0; i < arr.length - 1; i++) {
								if (arr[i] == "ROLE_EXPERT2") {
									currentRole = arr[i];
									$("#roleBack").show();
								}
							}
						if (currentRole == null)
							for (var i = 0; i < arr.length - 1; i++) {
								if (arr[i] == "ROLE_EXPERT1") {
									currentRole = arr[i];
									$("#roleBack").show();
								}
							}
					
						
						if (currentRole == null)
							for (var i = 0; i < arr.length - 1; i++) {
								if (arr[i] == "ROLE_USER") {
									currentRole = arr[i];
									$("#roleBack").hide();
								}
							}
 
						
						initZhichengApplyDataTables(data[0]);
						var hasOne = data[1].hasOne;
//						var userId = data[2].id;
						if (hasOne == 1) {
							$('#zhichengAddButton').attr("disabled", true);
							$('#zhichengAddButton').removeAttr("href");
							$('#zhichengAddButton').attr("class", "btn btn-small btn-inverse");
						} else {
							$('#zhichengAddButton').removeAttr("disabled");
							$('#zhichengAddButton').attr("href", "zhichengApply");
							$('#zhichengAddButton').attr("class", "btn btn-small btn-info");
						}
						if(currentRole !="ROLE_USER"){
							$('#zhichengAddButton').hide();
						}
						checkApply();
					}
				});

}
function initCheckCalendar() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'calendarGet',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var nowBack = new Date();
					var sYear = nowBack.getFullYear();
					var sMonth = nowBack.getMonth() + 1;
					var sDate = nowBack.getDate();
					var nowTime = sYear + "-" + sMonth + "-" + sDate;

					if (duibi(data[0].start_date, nowTime) && duibi(nowTime, data[0].end_date)) {
						createNewPDF = true;
					}else{
						createNewPDF = false;
					}
				}
			})
}
// js日期比较(yyyy-mm-dd)
function duibi(a, b) {
	var arr = a.split("-");
	var starttime = new Date(arr[0], arr[1], arr[2]);
	var starttimes = starttime.getTime();

	var arrs = b.split("-");
	var lktime = new Date(arrs[0], arrs[1], arrs[2]);
	var lktimes = lktime.getTime();

	if (starttimes >= lktimes) {
		return false;
	} else
		return true;

}
function checkApply() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'calendarSelect',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					if (data.result == 0) {
						$('#zhichengAddButton').attr("disabled", true);
						$('#zhichengAddButton').removeAttr("href");
						$('#zhichengAddButton').attr("class", "btn btn-small btn-inverse");
					}
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
					"data" : "apply_date",
					"class" : "center"
				}, {
					"data" : "apply_type",
					"class" : "center"
				}, {
					"data" : "group_id",
					"class" : "center"
				},{
					"data" : null,
					"class" : "center",
					"render" : function(data) {
						if (data.status == "已提交")
							return "<a id='unpaid' href='javascript:void(0)' class='btn btn-small '><i class='icon-refresh'></i>已提交</a>";
						if (data.status == "打分阶段")
							return "<a id='unpaid' href='javascript:void(0)' class='btn btn-small btn-warning'><i class='icon-play-circle'></i>打分阶段</a>";
						if (data.status == "打分完成")
							return "<a id='unpaid' href='javascript:void(0)' class='btn btn-small btn-success'><i class='icon-ok'></i>打分完成</a>";
						if (data.status == "已结束")
							return "<a id='unpaid' href='javascript:void(0)' class='btn btn-small btn-danger'><i class='icon-remove'></i>已结束</a>";
						else
							return "0";
					}
				}, {
					"data" : null,
					"class" : "center",
					"render" : function(data) {
								if (currentRole == "ROLE_USER") {
									if (data.status != "打分阶段" && data.status != "打分完成")
										return "<a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='PDFCreater("
												+ JSON.stringify(data)
												+ ")'><i class='icon-download'></i>导出PDF</a><a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='zhichengApplyDelete("
												+ data.id
												+ ")'><i class='icon-remove'></i>删除</a><a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='zhichengApplyEdit("
												+ data.id + ","+"\/"+data.apply_type+"\/"+","+zhichengId+")'><i class='icon-edit'></i>编辑</a>";
									else
										return "<a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='PDFCreater("
												+ JSON.stringify(data)
												+ ")'><i class='icon-download'></i>导出PDF</a><a class='btn btn-small btn-inverse' style='margin-right: 5px' disabled='disabled'  href='javascript:void(0)'><i class='icon-remove'></i>删除</a><a class='btn btn-small btn-inverse' style='margin-right: 5px'  disabled='disabled' href='javascript:void(0)' ><i class='icon-edit'></i>编辑</a>";

								}
						if ((currentRole == "ROLE_EXPERT1") || (currentRole == "ROLE_EXPERT2")||(currentRole == "ROLE_HR") || (currentRole == "ROLE_PROFESSOR")) {
							return "<a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='ExpertScore(" + data.id
									+ ")'><i class='icon-download'></i>打分情况</a><a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='zhichengApplyEdit("
									+ data.id +","+"\/"+data.apply_type+"\/"+","+id+","+user_id+")'><i class='icon-search'></i>审核</a>";}
						if (currentRole == "ROLE_USER") {
							return "<a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='zhichengApplyDelete("
										+ data.id
										+ ")'><i class='icon-remove'></i>删除</a>";
							

						}
					}
				}]
	});
}

function zhichengApplyEdit(id,type,userId,user_id) {
	console.log("申请类型："+type);
	location.href = 'zhichengApply?id=' + id+"&applyType="+type+"&userId="+userId+"&user_id="+user_id;
}

function zhichengApplyDelete(id) {
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
									var url = 'zhichengApplyDelete';
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
																			initZhichengApply(zhichengId);
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
//获取专家打分
function ExpertScore(id) {
	$("#myModalSave").unbind("click");
	$("#myModalSave").click(function() {
		initExpertScore();
	});
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
