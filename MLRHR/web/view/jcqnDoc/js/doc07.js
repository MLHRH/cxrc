var objUser = new Object();
 
var userBaseInfor_id ;
//专家ID
var  user_id;
// 被审核人ID
var userid = $.query.get("userId");

var apply_id =  $.query.get("apply_id") ;
function initjcqnDoc07() {
//	user_id = user_id;
	var arrData = new Array();
	arrData.push({
		"name" : "expert_id",
		"value" : user_id
	});
	arrData.push({
		"name" : "apply_id",
		"value" : apply_id
	});
	$.ajax({
				type : 'post',
				dataType : 'json',
//				url : "jcqnDoc07Init?expert_id=" + user_id +"& userid= "+userid,// 请求的路径
				url : 'jcqnDoc07Init',// 请求的路径
				data :arrData,
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					$('#expert_score').val(data.expert_score);	
					$('#expert_pingyu').val(data.expert_pingyu);				

				} 
			});
}

function updatejcqnDoc07() {
	var arrData = new Array();
	arrData.push({
		"name" : "user_id",
		"value" : userid
	});
	arrData.push({
		"name" : "expert_id",
		"value" : user_id
	});
	arrData.push({
		"name":"expert_pingyu",
		"value":$('#expert_pingyu').val()
	});
	arrData.push({
		"name":"expert_score",
		"value":$('#expert_score').val()
	});
	arrData.push({
		"name":"apply_id",
		"value":apply_id
	});
	$.ajax({
		dataType : "json",
		type : "post",
		url : "jcqnDoc07Update",
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