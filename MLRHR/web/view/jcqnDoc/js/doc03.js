var objUser = new Object();
 
var userBaseInfor_id;

var id;
function initjcqnDoc03() {
	//被审核人的ID存在时。此时是审核模式。采用被审核人的ID初始化。
	if(userId != null && userId !=""){
		id = userId;
	}
	else{
		id = user_id;
	}
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'jcqnDoc03Init?userId=' + id,// 请求的路径
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

function updatejcqnDoc03() {
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
		url : "jcqnDoc03Update",
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