var checkboxValue;
function userWorkEditSave() {
	if (validateuserWorkEdit()) {
		arrData = new Array();
		if ($("#user_work_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_work_id").val()
					});
		arrData.push({
					"name" : "user_id",
					"value" : user_id
				});
		arrData.push({
					"name" : "start_date",
					"value" : $("#user_work_start_date").val()
				});
		arrData.push({
					"name" : "end_date",
					"value" : $("#user_work_end_date").val()
				});
		arrData.push({
					"name" : "work_content",
					"value" : $("#user_work_work_content").val()
				});
		arrData.push({
					"name" : "country",
					"value" : $("#user_work_country").val()
				});
		arrData.push({
					"name" : "zhiwu",
					"value" : $("#user_work_zhiwu").val()
				});
//		arrData.push({
//					"name" : "zhengmingren",
//					"value" : $("#user_work_zhengmingren").val()
//				});
		arrData.push({
					"name" : "toNow",
					"value" : checkboxValue
				});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userWorkUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '工作经历 更新完成.请继续完善其他信息.',
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
function validateuserWorkEdit() {
	// 校验方法
	if ($("#user_work_start_date").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	if ($('#user_work_toNow').is(':checked') == false) {
		if ($("#user_work_end_date").val() == "") {
			generatenoty('center', "请选择结束时间！", 'error');
			return false;
		}
		if ($("#user_work_start_date").val() > $("#user_work_end_date").val()) {
			generatenoty('center', "开始时间不能晚于结束时间！", 'error');
			return false;
		}
		checkboxValue = 0;
	} else {
		checkboxValue = 1;
	}

	return true;
}