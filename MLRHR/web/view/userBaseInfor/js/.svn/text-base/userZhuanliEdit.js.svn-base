function userZhuanliEditSave() {
	if (validateuserZhuanliEdit()) {
		arrData = new Array();
		if ($("#user_zhuanli_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_zhuanli_id").val()
					});
		arrData.push({
					"name" : "user_id",
					"value" : user_id
				});
		arrData.push({
					"name" : "date",
					"value" : $("#user_zhuanli_date").val()
				});
		arrData.push({
					"name" : "name",
					"value" : $("#user_zhuanli_name").val()
				});
		arrData.push({
					"name" : "other",
					"value" : $("#user_zhuanli_other").val()
				});
		if ($("#user_zhuanli_type").val() != "-1")
			arrData.push({
						"name" : "type",
						"value" : $("#user_zhuanli_type").val()
					});
		if ($("#user_zhuanli_jiaose").val() != "-1")
			arrData.push({
						"name" : "jiaose",
						"value" : $("#user_zhuanli_jiaose").val()
					});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userZhuanliUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '专利 更新完成.请继续完善其他信息.',
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
function validateuserZhuanliEdit() {
	// 校验方法
	if ($("#user_zhuanli_date").val() == "") {
		generatenoty('center', "请选择日期！", 'error');
		return false;
	}
	if ($("#user_zhuanli_jiaose").val() == "-1") {
		generatenoty('center', "请选择排名！", 'error');
		return false;
	}
	if ($("#user_zhuanli_type").val() == "-1") {
		generatenoty('center', "请选择级别！", 'error');
		return false;
	}
	return true;
}