var objUser = new Object();
 
var userBaseInfor_id;


function initjcqnDoc03() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'cxtdDoc03Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					
					$('#selfAssessment').val(data.selfAssessment);				
					
				} 
			});
	
}

function updatecxtdDoc03() {
	var arrData = new Array();
	arrData.push({
		"name" : "userId",
		"value" : user_id
	});
	arrData.push({
		"name":"selfAssessment",
		"value":$('#selfAssessment').val()
	});

	$.ajax({
		dataType : "json",
		type : "post",
		url : "cxtdDoc03Update",
		data :arrData,
		error : function() {// 请求失败处理函数
			alert('请求失败');
		},
		success : function(rst) {
			if (rst.result == 1) {
				alert("保存成功，请继续操作!");

			} else {
				generatenoty('center', rst.msg, 'error');
			}
		}
	});
	
	
	
}