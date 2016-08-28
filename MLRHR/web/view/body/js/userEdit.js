function userEditSave() {
	if (validateUserEdit()) {
		arrData = new Array();
		if ($("#user_id").val() != "") {
			arrData.push({
						"name" : "id",
						"value" : $("#user_id").val()
					});
		}
		arrData.push({
					"name" : "name",
					"value" : $("#user_name").val()
				});
		arrData.push({
					"name" : "id_num",
					"value" : $.trim($("#user_id_num").val())
				});
		arrData.push({
					"name" : "email",
					"value" : $.trim($("#user_email").val())
				});
		arrData.push({
					"name" : "password",
					"value" : $.trim($("#user_password").val())
				});
		arrData.push({
					"name" : "body_id",
					"value" : body_id
				});
		arrData.push({
					"name" : "role_type",
					"value" : role_type
				});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "userupdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '更新成功！',
										type : 'success',
										dismissQueue : false,
										closeWith : ['click', 'button'],
										timeout : 3000,
										layout : 'top',
										callback : {
											afterClose : function() {
												$('#myModal').modal('hide');
											}
										},
										theme : 'defaultTheme'
									});
						} else if (rst.result == 2) {
							noty({
										text : '该名称已经注册，请选择其他登陆名称注册！',
										type : 'error',
										dismissQueue : false,
										closeWith : ['click', 'button'],
										timeout : 3000,
										layout : 'center',
										callback : {
											afterClose : function() {
											}
										},
										theme : 'defaultTheme'
									});
						} else {
							generatenoty('center', '更新失败！', 'error');
						}
					}
				});
	}
}
function validateUserEdit() {
	if ($("#user_name").val() == "") {
		generatenoty('center', "请输入姓名！", 'error');
		return false;
	}
	if ($("#user_id_num").val() == "") {
		generatenoty('center', "请输入身份证号码！", 'error');
		return false;
	}
	if ($("#user_email").val() == "") {
		generatenoty('center', "请输入邮箱！", 'error');
		return false;
	}
	if ($("#user_password").val() == "") {
		generatenoty('center', "请输入登陆密码！", 'error');
		return false;
	}
	return true;
}