function userStudyEditSave() {
	if (validateUserStudyEdit()) {
		arrData = new Array();
		if ($("#user_study_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_study_id").val()
					});
		arrData.push({
					"name" : "user_id",
					"value" : user_id
				});
		arrData.push({
					"name" : "start_date",
					"value" : $("#user_study_start_date").val()
				});
		arrData.push({
					"name" : "end_date",
					"value" : $("#user_study_end_date").val()
				});
		arrData.push({
					"name" : "xuexiao",
					"value" : $("#user_study_xuexiao").val()
				});
		arrData.push({
					"name" : "zhuanye",
					"value" : $("#user_study_zhuanye").val()
				});
		if ($("#user_study_xuewei").val() != "-1")
			arrData.push({
						"name" : "xuezhi",
						"value" : $("#user_study_xuezhi").val()
					});
		if ($("#user_study_xuewei").val() != "-1")
			arrData.push({
						"name" : "xuewei",
						"value" : $("#user_study_xuewei").val()
					});
		if ($("#user_study_xueli").val() != "-1")
			arrData.push({
						"name" : "xueli",
						"value" : $("#user_study_xueli").val()
					});
		arrData.push({
					"name" : "zhengmingren",
					"value" : $("#user_study_zhengmingren").val()
				});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userStudyUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '教育经历 更新完成.请继续完善其他信息.',
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
function validateUserStudyEdit() {
	if ($("#user_study_start_date").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	if ($("#user_study_end_date").val() == "") {
		generatenoty('center', "请选择结束时间！", 'error');
		return false;
	}
	if ($("#user_study_start_date").val()>$("#user_study_end_date").val()) {
		generatenoty('center', "开始时间不能晚于结束时间！", 'error');
		return false;
	}
	if ($("#user_study_xuexiao").val() == "") {
		generatenoty('center', "请输入学校信息！", 'error');
		return false;
	}
	if ($("#user_study_zhuanye").val() == "") {
		generatenoty('center', "请选择专业信息！", 'error');
		return false;
	}
	if ($("#user_study_xuezhi").val() == "-1") {
		generatenoty('center', "请选择学制类型", 'error');
		return false;
	}
	if ($("#user_study_xueli").val() == "-1") {
		generatenoty('center', "请选择学历类型", 'error');
		return false;
	}
	if ($("#user_study_xuewei").val() == "-1") {
		generatenoty('center', "请选择学位类型", 'error');
		return false;
	}
	return true;
}