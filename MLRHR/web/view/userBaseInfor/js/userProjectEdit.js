var checkSubmitFlg = false; 
function userProjectEditSave() {
	if (validateuserProjectEdit()) {
		checkSubmitFlg = true;
		arrData = new Array();
		if ($("#user_project_id").val() != "")
			arrData.push({
				"name" : "id",
				"value" : $("#user_project_id").val()
			});
		arrData.push({
			"name" : "userId",
			"value" : user_id
		});
//		arrData.push({
//			"name" : "xuhao_id",
//			"value" : $("#user_project_xuhao_id").val()
//		});
		arrData.push({
			"name" : "entryName",
			"value" : $("#user_project_project_name").val()
		});
		arrData.push({
			"name" : "projectNumber",
			"value" : $("#user_project_project_number").val()
		});
		arrData.push({
			"name" : "funds",
			"value" : $("#user_project_funds").val()
		});
		arrData.push({
			"name" : "startStopTime",
			"value" : $("#user_project_startStopTime").val()
		});
		arrData.push({
			"name" : "projectNature",
			"value" : $("#user_project_projectNature").val()
		});
		arrData.push({
			"name" : "role",
			"value" : $("#user_project_role").val()
		});
//		arrData.push({
//			"name" : "project_result",
//			"value" : $("#user_project_project_result").val()
//		});
		$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "userProjectUpdate",
			"data" : arrData,
			"success" : function(rst) {
				if (rst.result == 1) {
					noty({
						text : '承担项目 更新完成.请继续完善其他信息.',
						type : 'success',
						dismissQueue : false,
						closeWith : [ 'click', 'button' ],
						timeout : 1500,
						layout : 'top',
						callback : {
							afterClose : function() {
								$('#myModal').modal('hide');
								checkSubmitFlg = false;
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
function validateuserProjectEdit() {
	// 校验方法
//	if ($("#user_project_xuhao_id").val() == "") {
//		generatenoty('center', "请填写序号！", 'error');
//		return false;
//	}
//	if ($("#user_project_end_date").val() == "") {
//		generatenoty('center', "请选择结束时间！", 'error');
//		return false;
//	}
//	if ($("#user_project_start_date").val()>$("#user_project_end_date").val()) {
//		generatenoty('center', "开始时间不能晚于结束时间！", 'error');
//		return false;
//	}
	if(checkSubmitFlg == true){
		return false; 
	}
	return true;
}