var checkSubmitFlg = false; 
function userChengguoEditSave() {
	if (validateuserChengguoEdit()) {
		checkSubmitFlg = true;
		arrData = new Array();
		if ($("#user_chengguo_id").val() != "")
			arrData.push({
						"name" : "id",
						"value" : $("#user_chengguo_id").val()
					});
		arrData.push({
					"name" : "userId",
					"value" : user_id
				});
//		 arrData.push({
//					"name" : "xuhao_id",
//					"value" : $("#user_chengguo_xuhao").val()
//				});
				
		var nameTemp = $("#user_chengguo_thesis_topic").val();
		while (nameTemp.length < 350) {
			nameTemp += " ";
		}
		arrData.push({
					"name" : "thesisTopic",
					"value" : nameTemp
				});
		arrData.push({
					"name" : "authorSort",
					"value" : $("#user_chengguo_author_sort").val()
				});
		arrData.push({
					"name" : "journalTitle",
					"value" : $("#user_chengguo_journal_title").val()
				});
//		if ($("#user_chengguo_type").val() != "-1")
			arrData.push({
						"name" : "yearVolumePagenumber",
						"value" : $("#user_chengguo_year_volume_pagenumber").val()
					});

			arrData.push({
						"name" : "influenceFactor",
						"value" : $("#user_chengguo_yingxiangyinzi").val()
					});
			arrData.push({
				"name" : "sciTimes",
				"value" : $("#user_chengguo_sci_times").val()
			});
			arrData.push({
				"name" : "numberTotal",
				"value" : $("#user_chengguo_number_total").val()
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
function validateuserChengguoEdit() {
	// 校验方法
//	if ($("#user_chengguo_cg_date").val() == "") {
//		generatenoty('center', "请选择日期！", 'error');
//		return false;
//	}
	if ($("#user_chengguo_author_sort").val() == "-1") {
		generatenoty('center', "请选择排名！", 'error');
		return false;
	}
	if(checkSubmitFlg == true){
		return false; 
	}
//	if ($("#user_chengguo_type").val() == "-1") {
//		generatenoty('center', "请选择级别！", 'error');
//		return false;
//	}
	return true;
}