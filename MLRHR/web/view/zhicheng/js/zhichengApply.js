//applyid
var id = $.query.get("id");
var type = $.query.get("applyType");
var contentName = "";
var zhichengApply;
var currentRole;
var group_id ;
var expert =$.query.get("expert"); 
//登录者Id
var user_id =$.query.get("user_id") ;
//被审核人的ID
var userId=$.query.get("userId") ;;
var apply_type="";
var expert_id =$.query.get("expert_id");
var applyid =$.query.get("applyid");

$(document).ready(function() {
	if(type != null && type !=""){
		apply_type = type.substring(1,type.length-1);
	}
	console.log(apply_type)
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
	if (applyid == null) {
		$(".isHR").hide();
		$(".isUSER").hide();
		$(".isEXP").hide();
		$(".isEXP2").hide();
		document.getElementById("voteBtn").style.display = "none";
	} else {
		initApplication();
		zhichengApplyInteVote();
	}
	$("#content").load("docMain");
	$("#editSave").hide();
	//设置申请类型为不可选择
	if(apply_type != ""){
		$("#apply_type").val(apply_type);
		$("#apply_type").prop("disabled",true);
	}
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
//	case "jcqnDoc00":
//		initjcqnDoc00();
//		break;
	case "jcqnDoc01":
		initjcqnDoc01();
		break;
	case "jcqnDoc02":
//		initjcqnDoc02();		
		initUserPeixun();
		initUserWork();
		initUserSkill();
		initUserExam();
		initUserReport();
		initUserChengguo();
		initUserZhuanli();
		initUserAward();
		initUserProject();
		initUserBaogao();
		break;
	case "jcqnDoc03":
		initjcqnDoc03();
		break;
	case "jcqnDoc04":
		initjcqnDoc04();
		break;
	case "jcqnDoc05":
		initjcqnDoc05();
		break;
//	case "jcqnDoc06":
//		initjcqnDoc06();
//		break;
	case "jcqnDoc07":
		initjcqnDoc07();
		break;
	case "jcqnDoc08":
		initExpertScore();
		break;
	case "jcqnDoc09":	
		initExpertVote();
		break;
	case "kjljDoc01":
		initkjljDoc01();
		break;
	case "kjljDoc02":
		initUserPeixun();
		initUserWork();
		initUserSkill();
		initUserExam();
		initUserReport();
		initUserChengguo();
		initUserZhuanli();
		initUserAward();
		initUserProject();
		initUserBaogao();
		break;
	case "kjljDoc03":
		initkjljDoc03();
		break;
	case "kjljDoc04":
		initkjljDoc04();
		break;
	case "kjljDoc05":
		initkjljDoc05();
		break;
//	case "kjljDoc06":
//		initkjljDoc06();
//		break;
	case "kjljDoc07":
		initjcqnDoc07();
		break;
	case "cxtdDoc01":
		initcxtdDoc01();
		break;
	case "cxtdDoc02":
//		initcxtdDoc02();
		initUserPeixun();
		initUserWork();
		initUserSkill();
		initUserExam();
		initUserReport();
		initUserChengguo();
		initUserZhuanli();
		initUserAward();
		initUserProject();
		initUserBaogao();
		break;
	case "cxtdDoc03":
		initcxtdDoc03();
		break;
	case "cxtdDoc04":
		initcxtdDoc04();
		break;
	case "cxtdDoc05":
		initcxtdDoc05();
		break;
//	case "cxtdDoc06":
//		initcxtdDoc06();
//		break;
	case "cxtdDoc07":
		initjcqnDoc07();
		break;
	case "uploadfile":
		initUpFile();
		break;
	default:
		break;
	}
}

function save() {
	switch (contentName) {
	case "jcqnDoc01":
		updatejcqnDoc01();
		break;
//	case "jcqnDoc02":
//		updatejcqnDoc02();
//		break;
	case "jcqnDoc03":
		updatejcqnDoc03();
		break;
	case "jcqnDoc04":
		updatejcqnDoc04();
		break;
	case "jcqnDoc05":
		updatejcqnDoc05();
		break;
	case "jcqnDoc06":
		updatejcqnDoc06();
		break;
	case "jcqnDoc07":
		updatejcqnDoc07();
		break;
	case "kjljDoc01":
		updatekjljDoc01();
		break;
//	case "kjljDoc02":
//		updatekjljDoc02();
//		break;
	case "kjljDoc03":
		updatekjljDoc03();
		break;
	case "kjljDoc04":
		updatekjljDoc04();
		break;
	case "kjljDoc05":
		updatekjljDoc05();
		break;
	case "kjljDoc06":
		updatekjljDoc06();
		break;
	case "kjljDoc07":
		updatejcqnDoc07();
		break;
	case "cxtdDoc01":
		updatecxtdDoc01();
		break;
	case "cxtdDoc02":
		initUserPeixun();
		initUserWork();
		initUserSkill();
		initUserExam();
		initUserReport();
		initUserChengguo();
		initUserZhuanli();
		initUserAward();
		initUserProject();
		initUserBaogao();
		break;
	case "cxtdDoc03":
		updatecxtdDoc03();
		break;
	case "cxtdDoc04":
		updatecxtdDoc04();
		break;
	case "cxtdDoc05":
		updatecxtdDoc05();
		break;
	case "cxtdDoc06":
		updatecxtdDoc06();
		break;
	case "cxtdDoc07":
		updatejcqnDoc07();
		break;
	default:
		break;
	}
}
function initApplication() {
	$.ajax({
		type : 'get',
		dataType : 'json',
		url : 'zhichengApplyGetById?id=' + applyid,// 请求的路径
		error : function() {// 请求失败处理函数
			alert('请求失败');
		},
		success : function(data) { // 请求成功后处理函数。
			
			zhichengApply = data[0];
			group_id = zhichengApply.group_id;
			status = zhichengApply.status;
			$('#zhichengapply_status').val(zhichengApply.status);
			$("#zhichengapply_status_new").val(zhichengApply.status);
			if(status == 0){
				status = "已提交";
			}else if(status == 1){
				status ="初审中";
			}else if(status == 2){
				status = "初审未通过";
			}else if(status == 3){
				status = "初审通过";
			}else if(status == 4){
				status = "复审中";
			}else if(status == 5){
				status = "复审通过";
			}else if(status == 6){
				status = "复审未通过";
			}else {
				status = "已结束";
			}
//			userId = zhichengApply.user_id;
			$("#zhichengapply_status").html(status);
			
			var authority = data[1].authority;
			var arr = authority.split("|");

			if (currentRole == null)
				for (var i = 0; i < arr.length - 1; i++) {
					if (arr[i] == "ROLE_PROFESSOR") {
						$(".icon-edit").hide();
						$(".isHR").show();
						$(".isEXP").hide();
						$(".isEXP2").hide();
						$(".isSTA").show();
						$(".span2").show();
						$("#editSave").hide();
//						$("#tijiaoBtn").hide();
						document.getElementById("voteBtn").style.display = "none";
						currentRole = arr[i];
						
					}
				}
			if (currentRole == null)
				for (var i = 0; i < arr.length - 1; i++) {
					if (arr[i] == "ROLE_HR") {
						$(".icon-edit").hide()
						$(".isHR").show();
						$(".isEXP2").hide();
						$(".span2").show();
						$(".isSTA").show();
						$("#editSave").hide();
						document.getElementById("voteBtn").style.display = "none";
						currentRole = arr[i];
					}
				}
			if (currentRole == null)
				for (var i = 0; i < arr.length - 1; i++) {
					if (arr[i] == "ROLE_EXPERT1") {
						$(".btn btn-small btn-info").hide()
//						$(".isEXP").show();
						$(".isHR").hide();
						$(".isEXP2").hide();
						$(".isSTA").show();
						$(".isUSER").hide();
						$(".span2").show();
						$("#editSave").hide();
//						$(".btn-success").hide();
						document.getElementById("tijiaoBtn").style.display = "none";
						document.getElementById("voteBtn").style.display = "none";
						currentRole = arr[i];
					}
				}

			if (currentRole == null)
				for (var i = 0; i < arr.length - 1; i++) {
					if (arr[i] == "ROLE_EXPERT2") {
						$("#tijiaoBtn").hide();
						$("#editSave").hide();
						$(".isEXP2").show();
						$(".isHR").hide();
						$(".isSTA").show();
						$(".isUSER").hide();
						$("#orderedlist").show();
						$("#editSave").hide();
						currentRole = arr[i];
						document.getElementById("tijiaoBtn").style.display = "none";
					}
				}
			if (currentRole == null)
				for (var i = 0; i < arr.length - 1; i++) {
					if (arr[i] == "ROLE_USER") {
						$(".isEXP2").hide();
						$(".icon-edit").show()
						$(".isEXP").hide();
						$(".isEXP2").hide();
						$(".isUSER").hide();
						$("#editSave").show();
						$(".isHR").hide();
						document.getElementById("voteBtn").style.display = "none";
						currentRole = arr[i];
					}
				}
		}
	});
}

function zhichengApplyExport() {
		/*arrData = new Array();
		if(userId == null){
			arrData.push({
				"name" : "user_id",
				"value" : user_id
			});	
		}else{ssss
		arrData.push({
			"name" : "user_id",
			"value" : userId
		});
		}
		arrData.push({
			"name" : "apply_type",
			"value" : $("#apply_type").val()
		});*/
	if(userId == null){
		location.href="zhichengApplyExport?user_id="+user_id+'&apply_type='+$('#apply_type').val()		
	}else{
		location.href="zhichengApplyExport?user_id="+userId+'&apply_type='+$('#apply_type').val()
	}

		/*$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "zhichengApplyExport",
			"data" : arrData,
			"success" : function(rst) {
				if (rst.result == 1) {
					noty({
						text : '人才申请导出成功！',
						type : 'success',
						dismissQueue : false,
						closeWith : [ 'click', 'button' ],
						timeout : 1500,
						layout : 'top',						
						theme : 'defaultTheme'
					});
				} else {
					generatenoty('center', rst.msg, 'error');
				}
			}
		});*/

}


function zhichengApplyUpdate() {
	if (validateZhichengApplyUpdate()) {
		arrData = new Array();
		if (zhichengApply == null) {
			userId = $("#userId").val();
			var status = "0";

			var myDate = new Date();
			var year = myDate.getFullYear(); // 获取完整的年份(4位,1970-????)
			var month = ("0" + (myDate.getMonth() + 1)).slice(-2); // 获取当前月份(0-11,0代表1月)
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

//				if (currentRole == "ROLE_HR" || currentRole == "ROLE_PROFESSOR") {
//				 status = $("#zhichengapply_status_new").val();
//			}

		}

		arrData.push({
			"name" : "user_id",
			"value" : userId
		});

		arrData.push({
			"name" : "group_id",
			"value" :group_id
		});
		arrData.push({
			"name" : "apply_type",
			"value" : $("#apply_type").val()
		});
		if (currentRole == "ROLE_HR" || currentRole == "ROLE_PROFESSOR") 
		{
		    arrData.push({
			"name" : "status",
			"value" : $("#zhichengapply_status_new").val()
		});
		}else{
			if (zhichengApply == null){
		arrData.push({
		"name" : "status",
		"value" : "0"
     	});
		}else{
			arrData.push({
				"name" : "status",
				"value" : zhichengApply.status
			});
			}
			}

		$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "zhichengApplyUpdate",
			"data" : arrData,
			"success" : function(rst) {
				if (rst.result == 1) {
					noty({
						text : '人才申请 更新完成！',
						type : 'success',
						dismissQueue : false,
						closeWith : [ 'click', 'button' ],
						timeout : 1500,
						layout : 'top',
						callback : {
							afterClose : function() {
								if (expert != "true") {
								if (zhichengApply == null)
									location.href = 'zhichengApplylist';
								else
									location.href = 'zhichengApplylist?id='
											+ zhichengApply.user_id;
								}else{
									location.href = 'expertzhichengApplylist';
								}
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


function zhichengApplyInteVote() {
//	user_id = user_id;
	var arrData = new Array();
	arrData.push({
		"name" : "expert_id",
		"value" : user_id
	});
	arrData.push({
		"name" : "apply_id",
		"value" : applyid
	});
	$.ajax({
				type : 'post',
				dataType : 'json',
//				url : "jcqnDoc07Init?expert_id=" + user_id +"& userid= "+userid,// 请求的路径
				url : 'zhichengApplyInteVote',// 请求的路径
				data :arrData,
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					$('#zhichengapply_vote').val(data.expert_vote);	
					$('#zhichengapply_expert2_sug').val(data.expert_sug);
									

				} 
			});
}

function zhichengApplyUpdateVote() {
	if (validateZhichengApplyUpdate()) {
		arrData = new Array();	
			
		arrData.push({
			"name" : "expert_id",
			"value" : user_id
		});
		arrData.push({
			"name" : "apply_id",
			"value" : applyid
		});	
		arrData.push({
			"name" : "expert_vote",
			"value" : $("#zhichengapply_vote").val()
			
		});
		arrData.push({
			"name" : "expert_sug",
			"value" : $("#zhichengapply_expert2_sug").val()
			
		});
		$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "zhichengApplyUpdateVote",
			"data" : arrData,
			"success" : function(rst) {
				if (rst.result == 1) {
					noty({
						text : '人才申请 更新完成！',
						type : 'success',
						dismissQueue : false,
						closeWith : [ 'click', 'button' ],
						timeout : 1500,
						layout : 'top',
						callback : {
							afterClose : function() {								
									location.href = 'expertzhichengApplylist';							
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
	if ($("#zhichengType").val() == "-1") {
		generatenoty('center', "请选择申报级别", 'error');
		return false;
	}
	// if ($("#zhichengType").val() == "-1") {
	// generatenoty('center', "请选择专业分组", 'error');
	// return false;
	// }
	/*
	 * if ($("#zhichengRank").val() == "-1") { generatenoty('center', "请选择专业级别",
	 * 'error'); return false; }
	 */
	if ($("#zhichengIsbreak").val() == "-1") {
		generatenoty('center', "请选择是否破格", 'error');
		return false;
	}
//	if ((currentRole == "ROLE_EXPERT1") || (currentRole == "ROLE_EXPERT2")) {
//		if ($("#zhichengapply_status_new").val() == "-1") {
//			generatenoty('center', "请选择审核变更类型", 'error');
//			return false;
//		}
//	}
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
	var truthBeTold = window
			.confirm("提示1：由于该申请记录尚未提交或尚未保存，故导出PDF中部分数据为空，此处仅方便用户预览使用。\n提示2：若需导出完整PDF数据，请提交后在申报记录列表中操作。\n请确认是否继续“导出PDF操作”？");
	return truthBeTold;

}
function autoHeight_2(elem) {
	elem.style.height = 'auto';
	elem.scrollTop = 0; // 防抖动
	elem.style.height = elem.scrollHeight + 'px';

}

function getDocList() {

	var type = $('#apply_type').val();
	var jcqn_list = '<ul class="nav nav-list" id="orderedlist">'
			+ '<li id="jcqnDoc01"><a href="javascript:void(0)">1. 基本信息 </a></li>'
			+ '<li id="jcqnDoc02"><a href="javascript:void(0)">2. 近5年主要科研情况</a></li>'
			+ '<li id="jcqnDoc03"><a href="javascript:void(0)">3. 推荐人选自我评价</a></li>'
			+ '<li id="jcqnDoc04"><a href="javascript:void(0)">4. 未来研究计划及当前研究基础</a></li>'
			+ '<li id="jcqnDoc05"><a href="javascript:void(0)">5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施</a></li>'
			+ '<li id="jcqnDoc06"><a href="javascript:void(0)">6. 承诺与推荐意见</a><br></li>'
			+ '<li id="jcqnDoc07"><a href="javascript:void(0)">7. 专家评分</a></li></ul>'
	var kjlj_list = '<ul class="nav nav-list" id="orderedlist">'
			+ '<li id="kjljDoc01"><a href="javascript:void(0)">1. 基本信息 </a></li>'
			+ '<li id="kjljDoc02"><a href="javascript:void(0)">2. 近5年主要科研情况</a></li>'
			+ '<li id="kjljDoc03"><a href="javascript:void(0)">3. 推荐人选自我评价</a></li>'
			+ '<li id="kjljDoc04"><a href="javascript:void(0)">4. 未来研究计划及当前研究基础</a></li>'
			+ '<li id="kjljDoc05"><a href="javascript:void(0)">5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施</a></li>'
			+ '<li id="kjljDoc06"><a href="javascript:void(0)">6. 承诺与推荐意见</a><br></li>'
			+ '<li id="kjljDoc06"><a href="javascript:void(0)">7. 专家评分</a></li></ul>'
	var cxtd_list = '<ul class="nav nav-list" id="orderedlist">'
			+ '<li id="cxtdDoc01"><a href="javascript:void(0)">1. 基本信息 </a></li>'
			+ '<li id="cxtdDoc02"><a href="javascript:void(0)">2. 近5年主要科研情况</a></li>'
			+ '<li id="cxtdDoc03"><a href="javascript:void(0)">3. 团队及负责人自我评价</a></li>'
			+ '<li id="cxtdDoc04"><a href="javascript:void(0)">4. 团队发展规划及基础情况</a></li>'
			+ '<li id="cxtdDoc05"><a href="javascript:void(0)">5. 工作单位发展需求与推荐团队的相关性及工作单位提供的支持保障措施</a></li>'
			+ '<li id="cxtdDoc06"><a href="javascript:void(0)">6. 承诺与推荐意见</a><br></li>'
			+ '<li id="cxtdDoc06"><a href="javascript:void(0)">7. 专家评分</a></li></ul>'
	$('#orderedlist').remove();
	if (type == "杰出青年") {
		$('#nav').append(jcqn_list);
		$('#apply_type').val("杰出青年");
	}
	if (type == "科技领军") {
		$('#nav').append(kjlj_list);
		$('#apply_type').val("科技领军");
	}
	if (type == "创新团队") {
		$('#nav').append(cxtd_list);
		$('#apply_type').val("创新团队");
	}
}
function applyMenu() {
	var type = $('#apply_type').val();
//	if(type !="杰出青年"){
		location.href = 'applyMenu?applytype=' + type;
//	}
}