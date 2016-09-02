var id = $.query.get("id");
var contentName = "";
var zhichengApply;
var currentRole;
var user_id = 0;
$(document).ready(function() {
			$.fn.autoHeight = function() {
				function autoHeight(elem) {
					elem.style.height = 'auto';
					elem.scrollTop = 0; // 防抖动
					elem.style.height = elem.scrollHeight + 'px';
				}
				this.each(function() {
							autoHeight(this);
							$(this).on('keyup', function() {
										autoHeight(this);
									});
						});
			}
			$('textarea[autoHeight]').autoHeight();

			user_id = $("#userId").val();
			if (id == null) {
				$(".isHR").hide();
				$(".isUSER").hide();
			} else {
				initApplication();
			}
			$("#content").load("docMain");
			$("#editSave").hide();

			// 左侧导航添加选中效果
			$("#orderedlist li").click(function() {
						$("#editSave").show();
						$("li").each(function() {
									$(this).removeClass("active");
								});
						$(this).addClass("active");
						contentName = $(this).attr("id");

						$("#content").load(contentName, function() {
									init(contentName);
								});
					});
		});

function init(contentName) {
	switch (contentName) {
		case "jcqnDoc01" :
			initjcqnDoc01();
			break;
		case "jcqnDoc02" :
			initjcqnDoc02();
			break;
		case "jcqnDoc03" :
			initjcqnDoc03();
			break;
		case "jcqnDoc04" :
			initjcqnDoc04();
			break;
		case "jcqnDoc05" :
			initjcqnDoc05();
			break;
		case "jcqnDoc06" :
			initjcqnDoc06();
			break;
		case "jcqnDoc07" :
			initjcqnDoc07();
			break;
		case "kjljDoc01" :
			initkjljDoc01();
			break;
		case "kjljDoc02" :
			initkjljDoc02();
			break;
		case "kjljDoc03" :
			initkjljDoc03();
			break;
		case "kjljDoc04" :
			initkjljDoc04();
			break;
		case "kjljDoc05" :
			initkjljDoc05();
			break;
		case "kjljDoc06" :
			initkjljDoc06();
			break;
		case "kjljDoc07" :
			initkjljDoc07();
			break;
		case "cxtdDoc01" :
			initcxtdDoc01();
			break;
		case "cxtdDoc02" :
			initcxtdDoc02();
			break;
		case "cxtdDoc03" :
			initcxtdDoc03();
			break;
		case "cxtdDoc04" :
			initcxtdDoc04();
			break;
		case "cxtdDoc05" :
			initcxtdDoc05();
			break;
		case "cxtdDoc06" :
			initcxtdDoc06();
			break;
		default :
			break;
	}
}

function save() {
	switch (contentName) {
	case "jcqnDoc01" :
		updatejcqnDoc01();
		break;
	case "jcqnDoc02" :
		updatejcqnDoc02();
		break;
	case "jcqnDoc03" :
		updatejcqnDoc03();
		break;
	case "jcqnDoc04" :
		updatejcqnDoc04();
		break;
	case "jcqnDoc05" :
		updatejcqnDoc05();
		break;
	case "jcqnDoc06" :
		updatejcqnDoc06();
		break;
	case "jcqnDoc07" :
		updatejcqnDoc07();
		break;
	case "kjljDoc01" :
		updatekjljDoc01();
		break;
	case "kjljDoc02" :
		updatekjljDoc02();
		break;
	case "kjljDoc03" :
		updatekjljDoc03();
		break;
	case "kjljDoc04" :
		updatekjljDoc04();
		break;
	case "kjljDoc05" :
		updatekjljDoc05();
		break;
	case "kjljDoc06" :
		updatekjljDoc06();
		break;
	case "kjljDoc07" :
		updatekjljDoc07();
		break;
	case "cxtdDoc01" :
		updatecxtdDoc01();
		break;
	case "cxtdDoc02" :
		updatecxtdDoc02();
		break;
	case "cxtdDoc03" :
		updatecxtdDoc03();
		break;
	case "cxtdDoc04" :
		updatecxtdDoc04();
		break;
	case "cxtdDoc05" :
		updatecxtdDoc05();
		break;
	case "cxtdDoc06" :
		updatecxtdDoc06();
		break;
	default :
		break;
	}
}
function initApplication() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengApplyGetById?id=' + id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					zhichengApply = data[0];
					$("#zhichengapply_status").html(zhichengApply.status);
					$("#zhichengapply_pre_approve_sug").val(zhichengApply.pre_approve_sug);
					$("#zhichengapply_finial_approve_sug").val(zhichengApply.finial_approve_sug);

					autoHeight_2($("#zhichengapply_pre_approve_sug")[0]);
					autoHeight_2($("#zhichengapply_finial_approve_sug")[0]);

					user_id = zhichengApply.user_id;

					var authority = data[1].authority;
					var arr = authority.split("|");

					if (currentRole == null)
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_PROFESSOR") {
								$(".isHR").show();
								$(".isPro").show();
								$("#zhichengapply_pre_approve_sug").attr("disabled", true);
								currentRole = arr[i];
							}
						}
					if (currentRole == null)
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_HR") {
								$(".isHR").show();
								$(".isPro").hide();
								$("#zhichengapply_finial_approve_sug").attr("disabled", true);
								currentRole = arr[i];
							}
						}
					if (currentRole == null)
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_USER") {
								$(".isHR").hide();
								$("#zhichengapply_pre_approve_sug").attr("disabled", true);
								$("#zhichengapply_finial_approve_sug").attr("disabled", true);
								currentRole = arr[i];
							}
						}

				}
			});
}
function zhichengApplyUpdate() {
	if (validateZhichengApplyUpdate()) {
		arrData = new Array();
		var status;
		var pre_approve_date = null;
		var pre_approve_id = 0;
		var pre_approve_sug;
		var finial_approve_date = null;
		var finial_approve_id = 0;
		var finial_approve_sug;

		if (zhichengApply == null) {
			user_id = $("#userId").val();
			status = "待审核";

			var myDate = new Date();
			var year = myDate.getFullYear(); // 获取完整的年份(4位,1970-????)
			var month = myDate.getMonth() + 1; // 获取当前月份(0-11,0代表1月)
			var date = myDate.getDate(); // 获取当前日(1-31)
			var mytime = myDate.toLocaleTimeString(); // 获取当前时间

		} else {
			arrData.push({
						"name" : "id",
						"value" : zhichengApply.id
					});
			arrData.push({
						"name" : "apply_date",
						"value" : zhichengApply.apply_date
					});
			arrData.push({
						"name" : "file_name",
						"value" : zhichengApply.file_name
					});
			user_id = zhichengApply.user_id;

			if (currentRole == "ROLE_USER") {
				pre_approve_date = zhichengApply.pre_approve_date;
				pre_approve_id = zhichengApply.pre_approve_id;
				pre_approve_sug = zhichengApply.pre_approve_sug;

				finial_approve_date = zhichengApply.finial_approve_date;
				finial_approve_id = zhichengApply.finial_approve_id;
				finial_approve_sug = zhichengApply.finial_approve_sug;

				status = "待审核";
			}
			if (currentRole == "ROLE_HR") {
				var myDate = new Date();
				var year = myDate.getFullYear(); // 获取完整的年份(4位,1970-????)
				var month = myDate.getMonth() + 1; // 获取当前月份(0-11,0代表1月)
				var date = myDate.getDate(); // 获取当前日(1-31)
				pre_approve_date = year + "-" + month + "-" + date;
				pre_approve_id = $("#userId").val();
				pre_approve_sug = $("#zhichengapply_pre_approve_sug").val();

				finial_approve_date = zhichengApply.finial_approve_date;
				finial_approve_id = zhichengApply.finial_approve_id;
				finial_approve_sug = zhichengApply.finial_approve_sug;

				status = $("#zhichengapply_status_new").val();
			}
			if (currentRole == "ROLE_PROFESSOR") {
				pre_approve_date = zhichengApply.pre_approve_date;
				pre_approve_id = zhichengApply.pre_approve_id;
				pre_approve_sug = zhichengApply.pre_approve_sug;

				var myDate = new Date();
				var year = myDate.getFullYear(); // 获取完整的年份(4位,1970-????)
				var month = myDate.getMonth() + 1; // 获取当前月份(0-11,0代表1月)
				var date = myDate.getDate(); // 获取当前日(1-31)
				finial_approve_date = year + "-" + month + "-" + date;
				finial_approve_id = $("#userId").val();
				finial_approve_sug = $("#zhichengapply_finial_approve_sug").val();

				status = $("#zhichengapply_status_new").val();
			}
		}

		arrData.push({
					"name" : "user_id",
					"value" : user_id
				});
		arrData.push({
					"name" : "apply_type",
					"value" : $("#apply_type").val()
				});
//		arrData.push({
//					"name" : "apply_isbreak",
//					"value" : $("#zhichengIsbreak").val()
//				});
		arrData.push({
					"name" : "status",
					"value" : status
				});
		arrData.push({
					"name" : "pre_approve_date",
					"value" : pre_approve_date
				});
		arrData.push({
					"name" : "pre_approve_id",
					"value" : pre_approve_id
				});
		arrData.push({
					"name" : "pre_approve_sug",
					"value" : pre_approve_sug
				});
		arrData.push({
					"name" : "finial_approve_date",
					"value" : finial_approve_date
				});
		arrData.push({
					"name" : "finial_approve_id",
					"value" : finial_approve_id
				});
		arrData.push({
					"name" : "finial_approve_sug",
					"value" : finial_approve_sug
				});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "zhichengApplyUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '职称申请 更新完成！',
										type : 'success',
										dismissQueue : false,
										closeWith : ['click', 'button'],
										timeout : 1500,
										layout : 'top',
										callback : {
											afterClose : function() {
												if (zhichengApply == null)
													location.href = 'zhichengApplylist';
												else
													location.href = 'zhichengApplylist?id=' + zhichengApply.user_id;
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

}
function validateZhichengApplyUpdate() {
	// var truthBeTold =
	// window.confirm("提示1：提交后将不再允许修改，如需修改请联系管理员。\n提示2：若仅仅想保存当前操作，请点击右侧上方“保存修改”按钮。\n请确认是否继续“提交操作”？");
	// if (truthBeTold) {
	// 校验方法
	if ($("#zhichengnow").val() == "-1") {
		generatenoty('center', "请选择申报级别", 'error');
		return false;
	}
	if ($("#zhichengType").val() == "-1") {
		generatenoty('center', "请选择专业分组", 'error');
		return false;
	}
	/*
	 * if ($("#zhichengRank").val() == "-1") { generatenoty('center', "请选择专业级别",
	 * 'error'); return false; }
	 */
	if ($("#zhichengIsbreak").val() == "-1") {
		generatenoty('center', "请选择是否破格", 'error');
		return false;
	}
	if ((currentRole == "ROLE_HR") || (currentRole == "ROLE_PROFESSOR")) {
		if ($("#zhichengapply_status_new").val() == "-1") {
			generatenoty('center', "请选择审核变更类型", 'error');
			return false;
		}
	}
	return true;
	// }

}

// 生成PDF
function PDFTemp() {
	if (pdfShowAlert()) {
		$.ajax({
					type : 'get',
					dataType : 'json',
					url : 'MyPDFTemp?user_id=' + user_id,// 请求的路径
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
						}
					}
				});
	}
}
function pdfShowAlert() {
	var truthBeTold = window.confirm("提示1：由于该申请记录尚未提交或尚未保存，故导出PDF中部分数据为空，此处仅方便用户预览使用。\n提示2：若需导出完整PDF数据，请提交后在申报记录列表中操作。\n请确认是否继续“导出PDF操作”？");
	return truthBeTold;

}
function autoHeight_2(elem) {
	elem.style.height = 'auto';
	elem.scrollTop = 0; // 防抖动
	elem.style.height = elem.scrollHeight + 'px';
}

function getDocList(){
	var type = $('#apply_type').val();
	var jcqn_list = '<ul class="nav nav-list" id="orderedlist">'+
		'<li id="jcqnDoc01"><a href="javascript:void(0)">1. 基本信息 </a></li>'+
		'<li id="jcqnDoc02"><a href="javascript:void(0)">2. 近5年主要科研情况</a></li>'+
		'<li id="jcqnDoc03"><a href="javascript:void(0)">3. 推荐人选自我评价</a></li>'+
		'<li id="jcqnDoc04"><a href="javascript:void(0)">4. 未来研究计划及当前研究基础</a></li>'+
		'<li id="jcqnDoc05"><a href="javascript:void(0)">5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施</a></li>'+
		'<li id="jcqnDoc06"><a href="javascript:void(0)">6. 承诺与推荐意见</a><br></li>'+
		'<li id="jcqnDoc06"><a href="javascript:void(0)">7. 报送材料明细</a></li></ul>'
	var kjlj_list = '<ul class="nav nav-list" id="orderedlist">'+
		'<li id="kjljDoc01"><a href="javascript:void(0)">1. 基本信息 </a></li>'+
		'<li id="kjljDoc02"><a href="javascript:void(0)">2. 近5年主要科研情况</a></li>'+
		'<li id="kjljDoc03"><a href="javascript:void(0)">3. 推荐人选自我评价</a></li>'+
		'<li id="kjljDoc04"><a href="javascript:void(0)">4. 未来研究计划及当前研究基础</a></li>'+
		'<li id="kjljDoc05"><a href="javascript:void(0)">5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施</a></li>'+
		'<li id="kjljDoc06"><a href="javascript:void(0)">6. 承诺与推荐意见</a><br></li>'+
		'<li id="kjljDoc06"><a href="javascript:void(0)">7. 报送材料明细</a></li></ul>'
	var cxtd_list = '<ul class="nav nav-list" id="orderedlist">'+
		'<li id="cxtdDoc01"><a href="javascript:void(0)">1. 基本信息 </a></li>'+
		'<li id="cxtdDoc02"><a href="javascript:void(0)">2. 近5年主要科研情况</a></li>'+
		'<li id="cxtdDoc03"><a href="javascript:void(0)">3. 团队及负责人自我评价</a></li>'+
		'<li id="cxtdDoc04"><a href="javascript:void(0)">4. 团队发展规划及基础情况</a></li>'+
		'<li id="cxtdDoc05"><a href="javascript:void(0)">5. 工作单位发展需求与推荐团队的相关性及工作单位提供的支持保障措施</a></li>'+
		'<li id="cxtdDoc06"><a href="javascript:void(0)">6. 承诺与推荐意见</a><br></li>'+
		'<li id="cxtdDoc06"><a href="javascript:void(0)">7. 报送材料明细</a></li></ul>'
	$('#orderedlist').remove();
	if( type == "杰出青年"){
		$('#nav').append(jcqn_list);
		$('#apply_type').val("杰出青年");
	}
	if( type == "科技领军"){
		$('#nav').append(kjlj_list);
		$('#apply_type').val("科技领军");
	}
	if( type == "创新团队"){
		$('#nav').append(cxtd_list);
		$('#apply_type').val("创新团队");
	}
}
function applyMenu() {
	var type = $('#apply_type').val();
	location.href = 'applyMenu?applytype=' + type;
}