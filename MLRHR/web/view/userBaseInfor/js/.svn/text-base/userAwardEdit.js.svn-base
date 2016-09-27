function userAwardEditSave() {
	if (validateuserAwardEdit()) {
		arrData = new Array();
		if ($("#user_award_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_award_id").val()
					});
		arrData.push({
					"name" : "user_id",
					"value" : user_id
				});
		arrData.push({
					"name" : "date",
					"value" : $("#user_award_date").val()
				});
		arrData.push({
					"name" : "name",
					"value" : $("#user_award_name").val()
				});
		arrData.push({
					"name" : "other",
					"value" : $("#user_award_other").val()
				});
		if ($("#user_award_type").val() != "-1")
			arrData.push({
						"name" : "type",
						"value" : $("#user_award_type").val()
					});
		if ($("#user_award_jiaose").val() != "-1")
			arrData.push({
						"name" : "jiaose",
						"value" : $("#user_award_jiaose").val()
					});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userAwardUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '获奖 情况 更新完成.请继续完善其他信息.',
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
function validateuserAwardEdit() {
	// 校验方法
	if ($("#user_award_date").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	return true;
}