function userAwardEditSave() {
	if (validateuserAwardEdit()) {
		arrData = new Array();
		if ($("#user_award_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_award_id").val()
					});
		arrData.push({
					"name" : "userId",
					"value" : user_id
				});
//		arrData.push({
//					"name" : "xuhao_id",
//					"value" : $("#user_award_xuhao_id").val()
//				});
		arrData.push({
					"name" : "awardItemName",
					"value" : $("#user_award_name").val()
				});
		arrData.push({
					"name" : "prizeName",
					"value" : $("#user_prize_name").val()
				});
		if ($("#user_award_grade").val() != "-1")
			arrData.push({
						"name" : "grade",
						"value" : $("#user_award_grade").val()
					});
		if ($("#user_award_sort").val() != "-1")
			arrData.push({
						"name" : "sort",
						"value" : $("#user_award_sort").val()
					});
			arrData.push({
		"name" : "rewardTime",
		"value" : $("#user_reward_time").val()
	});
		
			arrData.push({
				"name" : "grantInstitution",
				"value" : $("#user_grant_institution").val()
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
	if ($("#user_reward_time").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	return true;
}