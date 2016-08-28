function userChengguoEditSave() {
	if (validateuserChengguoEdit()) {
		arrData = new Array();
		if ($("#user_chengguo_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_chengguo_id").val()
					});
		arrData.push({
					"name" : "user_id",
					"value" : user_id
				});
		 arrData.push({
					"name" : "cg_date",
					"value" : $("#user_chengguo_cg_date").val()
				});
				
		var nameTemp = $("#user_chengguo_cg_name").val();
		while (nameTemp.length < 350) {
			nameTemp += " ";
		}
		arrData.push({
					"name" : "cg_name",
					"value" : nameTemp
				});
		arrData.push({
					"name" : "cg_jieshao",
					"value" : $("#user_chengguo_cg_jieshao").val()
				});
		arrData.push({
					"name" : "yingxiangyinzi",
					"value" : $("#user_chengguo_yingxiangyinzi").val()
				});
		if ($("#user_chengguo_type").val() != "-1")
			arrData.push({
						"name" : "type",
						"value" : $("#user_chengguo_type").val()
					});
		if ($("#user_chengguo_jiaose").val() != "-1")
			arrData.push({
						"name" : "jiaose",
						"value" : $("#user_chengguo_jiaose").val()
					});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userChengguoUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '论文专著 更新完成.请继续完善其他信息.',
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
function validateuserChengguoEdit() {
	// 校验方法
	if ($("#user_chengguo_cg_date").val() == "") {
		generatenoty('center', "请选择日期！", 'error');
		return false;
	}
	if ($("#user_chengguo_jiaose").val() == "-1") {
		generatenoty('center', "请选择排名！", 'error');
		return false;
	}
	if ($("#user_chengguo_type").val() == "-1") {
		generatenoty('center', "请选择级别！", 'error');
		return false;
	}
	return true;
}