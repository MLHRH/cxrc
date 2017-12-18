var objUser = new Object();
 
var userBaseInfor_id;
var currentRole;
var userid;
function initjcqnDoc03() {
	//被审核人的ID存在时。此时是审核模式。采用被审核人的ID初始化。
	if(userId != null && userId !=""){
		userid = userId;
	}
	else{
		userid = user_id;
	}
	console.log(currentRole);
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'jcqnDoc03Init?userId=' + userid,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					$('#selfAssessment').val(data[0].selfAssessment);	
					var authority = data[1].authority;
					var arr = authority.split("|");
//					if (currentRole == null)
					var isUser = false;
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_USER") {
									isUser = true;
							}
						}
						if(isUser == false){
							$("#selfAssessment").attr("disabled",
									true);
						}
				} 
			});
	
}

function updatejcqnDoc03() {
	var arrData = new Array();
	var content = editor.getData();
	arrData.push({
		"name" : "userId",
		"value" : user_id
	});
	arrData.push({
		"name":"selfAssessment",
		"value":content
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