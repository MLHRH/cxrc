function userBaogaoEditSave() {
	if (validateUserBaogaoEdit()) {
		arrData = new Array();
		if ($("#user_Baogao_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_Baogao_id").val()
					});
		arrData.push({
					"name" : "userId",
					"value" : user_id
				});
		arrData.push({
					"name" : "xuhao_id",
					"value" : $("#user_Baogao_xuhao_id").val()
				});
		arrData.push({
					"name" : "reportName",
					"value" : $("#user_Baogao_report_name").val()
				});
		arrData.push({
					"name" : "meetingName",
					"value" : $("#user_Baogao_meeting_name").val()
				});
		arrData.push({
					"name" : "organizers",
					"value" : $("#user_Baogao_organizers").val()
				});
		
			arrData.push({
						"name" : "meetingTime",
						"value" : $("#user_Baogao_meeting_time").val()
					});
		
			arrData.push({
						"name" : "meetingPlace",
						"value" : $("#user_Baogao_meeting_place").val()
					});

			arrData.push({
						"name" : "reportType",
						"value" : $("#user_Baogao_report_type").val()
					});

		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userBaogaoUpdate",
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
function validateUserBaogaoEdit() {
	if ($("#user_Baogao_meeting_time").val() == "") {
		generatenoty('center', "请选择时间！", 'error');
		return false;
	}
//	if ($("#user_Baogao_end_date").val() == "") {
//		generatenoty('center', "请选择结束时间！", 'error');
//		return false;
//	}
//	if ($("#user_Baogao_start_date").val()>$("#user_Baogao_end_date").val()) {
//		generatenoty('center', "开始时间不能晚于结束时间！", 'error');
//		return false;
//	}
//	if ($("#user_Baogao_xuexiao").val() == "") {
//		generatenoty('center', "请输入学校信息！", 'error');
//		return false;
//	}
//	if ($("#user_Baogao_zhuanye").val() == "") {
//		generatenoty('center', "请选择专业信息！", 'error');
//		return false;
//	}
//	if ($("#user_Baogao_xuezhi").val() == "-1") {
//		generatenoty('center', "请选择学制类型", 'error');
//		return false;
//	}
//	if ($("#user_Baogao_xueli").val() == "-1") {
//		generatenoty('center', "请选择学历类型", 'error');
//		return false;
//	}
//	if ($("#user_Baogao_xuewei").val() == "-1") {
//		generatenoty('center', "请选择学位类型", 'error');
//		return false;
//	}
	return true;
}