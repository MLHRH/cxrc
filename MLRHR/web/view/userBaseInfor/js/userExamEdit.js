function userExamEditSave() {
	if (validateuserExamEdit()) {
		arrData = new Array();
		if ($("#user_exam_id").val() != "")
			arrData.push({
				"name" : "id",
				"value" : $("#user_exam_id").val()
			});
		arrData.push({
			"name" : "user_id",
			"value" : user_id
		});
		arrData.push({
			"name" : "exam_date",
			"value" : $("#user_exam_exam_date").val()
		});
		arrData.push({
			"name" : "type",
			"value" : $("#user_exam_type").val()
		});
		arrData.push({
			"name" : "kemu",
			"value" : $("#user_exam_kemu").val()
		});
		arrData.push({
			"name" : "chengji",
			"value" : $("#user_exam_chengji").val()
		});
		arrData.push({
			"name" : "zuzhizhe",
			"value" : $("#user_exam_zuzhizhe").val()
		});
		$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "userExamUpdate",
			"data" : arrData,
			"success" : function(rst) {
				if (rst.result == 1) {
					noty({
						text : '考试经历 更新完成.请继续完善其他信息.',
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
function validateuserExamEdit() {
	// 校验方法
	if ($("#user_exam_exam_date").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	return true;
}