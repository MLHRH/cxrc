function expertGroupSave() {
	arrData = new Array();
	if ($("#expertId").val() != "") {
		arrData.push({
			"name" : "expertId",
			"value" : $("#expertId").val()
				});
		arrData.push({
			"name" : "groupId",
			"value" : $("#group").val()
		});
		arrData.push({
			"name" : "teamLeaderType",
			"value" : $("#team_leader_type").val()
		});
		
		$.ajax({
			"dataType" : 'json',
			"type" : "post",
			"url" : "updateExpertGroup",
			"data" : arrData,
			"success" : function(data) {
				if (data.status == 0) {
					noty({
						text : data.msg,
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
				} else if (data.status == 1) {
					noty({
						text : data.msg,
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
				} 
			}
		});
	}
	else{
		generatenoty('center', '更新失败！', 'error');
	}
}