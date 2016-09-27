function userPeixunEditSave() {
	if (validateuserPeixunEdit()) {
		arrData = new Array();
		if ($("#user_peixun_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_peixun_id").val()
					});
		arrData.push({
					"name" : "user_id",
					"value" : user_id
				});
		arrData.push({
					"name" : "start_date",
					"value" : $("#user_peixun_start_date").val()
				});
		arrData.push({
					"name" : "end_date",
					"value" : $("#user_peixun_end_date").val()
				});
		arrData.push({
					"name" : "content",
					"value" : $("#user_peixun_content").val()
				});
		arrData.push({
					"name" : "place",
					"value" : $("#user_peixun_place").val()
				});
		arrData.push({
					"name" : "zhengmingren",
					"value" : $("#user_peixun_zhengmingren").val()
				});
		if ($("#user_peixun_xuezhi").val() != "-1")
			arrData.push({
						"name" : "xuezhi",
						"value" : $("#user_peixun_xuezhi").val()
					});
		if ($("#user_peixun_xuewei").val() != "-1")
			arrData.push({
						"name" : "xuewei",
						"value" : $("#user_peixun_xuewei").val()
					});
		if ($("#user_peixun_xueli").val() != "-1")
			arrData.push({
						"name" : "xueli",
						"value" : $("#user_peixun_xueli").val()
					});
		if ($("#user_peixun_isTop").val() != "-1")
			arrData.push({
						"name" : "isTop",
						"value" : $("#user_peixun_isTop").val()
					});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userPeixunUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '学习培训经历 更新完成.请继续完善其他信息.',
										type : 'success',
										dismissQueue : false,
										closeWith : ['click', 'button'],
										timeout : 1500,
										layout : 'top',
										callback : {
											afterClose : function() {
												$('#myModal').modal('hide');
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
function validateuserPeixunEdit() {
	// 校验方法
	if ($("#user_peixun_start_date").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	if ($("#user_peixun_end_date").val() == "") {
		generatenoty('center', "请选择结束时间！", 'error');
		return false;
	}
	if ($("#user_peixun_start_date").val() > $("#user_peixun_end_date").val()) {
		generatenoty('center', "开始时间不能晚于结束时间！", 'error');
		return false;
	}
	if ($("#user_peixun_xuezhi").val() == "-1") {
		generatenoty('center', "请选择学制类型", 'error');
		return false;
	}
	if ($("#user_peixun_xuewei").val() == "-1") {
		generatenoty('center', "请选择学位类型", 'error');
		return false;
	}
	if ($("#user_peixun_xueli").val() == "-1") {
		generatenoty('center', "请选择学历类型", 'error');
		return false;
	}
	if ($("#user_peixun_isTop").val() == "-1") {
		generatenoty('center', "请选择是否最高学历", 'error');
		return false;
	}
	return true;
}