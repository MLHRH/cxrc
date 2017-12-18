var checkSubmitFlg;
function userZhuanliEditSave() {
	if (validateuserZhuanliEdit()) {
		checkSubmitFlg = true;
		arrData = new Array();
		if ($("#user_zhuanli_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_zhuanli_id").val()
					});
		arrData.push({
					"name" : "userId",
					"value" : user_id
				});
//		arrData.push({
//					"name" : "xuhao_id",
//					"value" : $("#user_zhuanli_xuhao").val()
//				});
		arrData.push({
					"name" : "patentName",
					"value" : $("#user_zhuanli_name").val()
				});
		arrData.push({
					"name" : "grantNumber",
					"value" : $("#user_zhuanli_number").val()
				});
		
			arrData.push({
						"name" : "type",
						"value" : $("#user_zhuanli_type").val()
					});
	
			arrData.push({
						"name" : "inventorSort",
						"value" : $("#user_zhuanli_sort").val()
					});
			arrData.push({
				"name" : "authorizedTime",
				"value" : $("#user_zhuanli_date").val()
			});
			arrData.push({
				"name" : "authorizedNational",
				"value" : $("#user_zhuanli_authorized_national").val()
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
function validateuserZhuanliEdit() {
	// 校验方法
//	if ($("#user_zhuanli_date").val() == "") {
//		generatenoty('center', "请选择日期！", 'error');
//		return false;
//	}
//	if ($("#user_zhuanli_jiaose").val() == "-1") {
//		generatenoty('center', "请选择排名！", 'error');
//		return false;
//	}
//	if ($("#user_zhuanli_type").val() == "-1") {
//		generatenoty('center', "请选择级别！", 'error');
//		return false;
//	}
	if(checkSubmitFlg == true){
		return false; 
	}
	return true;
}