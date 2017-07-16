function userReportEditSave() {
//	if (validateuserReportEdit()) {
		arrData = new Array();
		if ($("#user_report_id").val() != "")
			arrData.push({
				"name" : "id",
				"value" : $("#user_report_id").val()
			});
		arrData.push({
			"name" : "userId",
			"value" : user_id
		});
//		arrData.push({
//			"name" : "xuhao_id",
//			"value" : $("#user_xuhao").val()
//		});
		var nameTemp = $("#user_report_name").val();
//		while (nameTemp.length < 350) {
//			nameTemp += " ";
//		}
		
		arrData.push({
			"name" : "treatiseName",
			"value" :nameTemp 
		});
		arrData.push({
			"name" : "press",
			"value" : $("#user_report_press").val()
		});
		arrData.push({
			"name" : "issuingCountry",
			"value" : $("#user_report_issuingCountry").val()
		});
		arrData.push({
			"name" : "year",
			"value" : $("#user_report_date").val()
		});
		$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "userReportUpdate",
			"data" : arrData,
			"success" : function(rst) {
				if (rst.result == 1) {
					noty({
						text : '著作、论文及重要技术报告 更新完成.请继续完善其他信息.',
						type : 'success',
						dismissQueue : false,
						closeWith : [ 'click', 'button' ],
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
//}	
//function validateuserReportEdit() {
//	// 校验方法
//	if ($("#user_report_date").val() == "") {
//		generatenoty('center', "请选择日期！", 'error');
//		return false;
//	}
//	var temp =$("#user_report_content_summary").val();
//	/*if(Statistics(temp)>250)
//	{
//		generatenoty('center', "内容提要不得超过250字！", 'error');
//		return false;
//	}*/
//	return true;
//}
//function Statistics(target){
//	var str =  target.replace(/\r\n/g, "\n");
//	var t_str = str.replace(/\n/g, '');
//	var w_c_str = str.match(/[\u4e00-\u9fa5]/g)||[];
//	var w_e_str = str.match(/\b\w+\b/g)||[];
//	var w_n_str = str.match(/\b\d+\b/g)||[];
//	var e_p = t_str.match(/[|\~|\`|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\-|\_|\+|\=|\||\\|\[|\]|\{|\}|\;|\:|\"|\'|\,|\<|\.|\>|\/|\?]/g)||[];
//	
//	var sTotal = 0;
//	for(var i = 0; i < t_str.length; i++){
//		var c = t_str.charAt(i);
//		if (c.match(/[^\x00-\xff]/))sTotal ++;
//	}
//	
//	var e = t_str.match(/[A-Za-z]/g)||[];
//	var eTotal = e.length;
//
//	var n = t_str.match(/[0-9]/g)||[];
//	var nTotal = n.length;
//
//	var part = 0;
//	var s_ma = str.split("\n");
//	for(var i = 0; i < s_ma.length; i++){
//		if(s_ma[i].length > 0) part++;
//	}
//	
////	console.log("中文："+w_c_str.length);
//	var temp=w_e_str.length - w_n_str.length;
////	console.log("单词："+temp);
//
//	// console.log('字符总数： ', t_str.length);
//	// console.log('中文字符总数： ', w_c_str.length);
//	// console.log('中文标点总数： ', sTotal - w_c_str.length);
//	// console.log('英文字符总数： ', eTotal);
//	// console.log('英文标点总数： ', e_p.length);
//	// console.log('英文单词总数： ', w_e_str.length - w_n_str.length);
//	// console.log('数据单词总数： ', w_n_str.length);
//	// console.log('数字字符总数： ', nTotal);
//	// console.log('行（段）总数： ', part);
//	
//	return w_c_str.length+temp;
//	

