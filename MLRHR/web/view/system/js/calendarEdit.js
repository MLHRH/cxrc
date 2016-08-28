$(document).ready(function() {
			$('#calendar_jieshao').wysiwyg();
		});
function calendarEditSave() {
	if (validatecalendarEdit()) {
		arrData = new Array();
		arrData.push({
					"name" : "id",
					"value" : $("#calendar_id").val()
				});
		arrData.push({
					"name" : "start_date",
					"value" : $("#calendar_start_date").val()
				});
		arrData.push({
					"name" : "end_date",
					"value" : $("#calendar_end_date").val()
				});
		arrData.push({
					"name" : "jieshao",
					"value" : $("#calendar_jieshao").html()
				});
		$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "calendarUpdate",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							noty({
										text : '更新完成!',
										type : 'success',
										dismissQueue : false,
										closeWith : ['click', 'button'],
										timeout : 1500,
										layout : 'top',
										callback : {
											afterClose : function() {
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
function validatecalendarEdit() {
	// 校验方法
	if ($("#calendar_start_date").val() == "") {
		generatenoty('center', "请选择开始时间！", 'error');
		return false;
	}
	if ($("#calendar_end_date").val() == "") {
		generatenoty('center', "请选择结束时间！", 'error');
		return false;
	}
	if ($("#calendar_start_date").val() > $("#calendar_end_date").val()) {
		generatenoty('center', "开始时间不能晚于结束时间！", 'error');
		return false;
	}
	return true;
}