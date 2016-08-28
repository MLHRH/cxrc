function userSkill_2EditSave() {
	if (validateuserSkill_2Edit()) {
		arrData = new Array();
		if ($("#user_skill_2_id").val() != "")
			arrData.push({
				"name" : "id",
				"value" : $("#user_skill_2_id").val()
			});
		arrData.push({
			"name" : "user_id",
			"value" : user_id
		});
		arrData.push({
			"name" : "start_date",
			"value" : $("#user_skill_2_start_date").val()
		});
		arrData.push({
			"name" : "end_date",
			"value" : $("#user_skill_2_end_date").val()
		});
		arrData.push({
			"name" : "project_name",
			"value" : $("#user_skill_2_project_name").val()
		});
//		arrData.push({
//			"name" : "work_content",
//			"value" : $("#user_skill_2_work_content").val()
//		});
		arrData.push({
			"name" : "jiaose",
			"value" : $("#user_skill_2_jiaose").val()
		});
//		arrData.push({
//			"name" : "jine",
//			"value" : $("#user_skill_2_jine").val()
//		});
//		arrData.push({
//			"name" : "laiyuan",
//			"value" : $("#user_skill_2_laiyuan").val()
//		});
		arrData.push({
			"name" : "project_result",
			"value" : $("#user_skill_2_project_result").val()
		});
		$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "userSkill_2Update",
			"data" : arrData,
			"success" : function(rst) {
				if (rst.result == 1) {
					noty({
						text : '专业技术工作业绩 更新完成.请继续完善其他信息.',
						type : 'success',
						dismissQueue : false,
						closeWith : [ 'click', 'button' ],
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
function validateuserSkill_2Edit() {
	// 校验方法
	if ($("#user_skill_2_start_date").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	if ($("#user_skill_2_end_date").val() == "") {
		generatenoty('center', "请选择结束时间！", 'error');
		return false;
	}
	if ($("#user_skill_2_start_date").val()>$("#user_skill_2_end_date").val()) {
		generatenoty('center', "开始时间不能晚于结束时间！", 'error');
		return false;
	}
	return true;
}