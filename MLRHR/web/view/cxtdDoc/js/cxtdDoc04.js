var objUser = new Object();
 
var userBaseInfor_id;
var userid;

function initcxtdDoc04() {
	if(userId != null && userId !=""){
		userid = userId;
	}
	else{
		userid = user_id;
	}
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'cxtdDoc04Init?userId=' + userid,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					
					$('#futurePlans').val(data[0].futurePlans);				
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
							$("#futurePlans").attr("disabled",
									true);
						}
				} 
			});
	
}

function updatecxtdDoc04() {
	var arrData = new Array();
	var content = editor.getData();
	arrData.push({
		"name" : "userId",
		"value" : user_id
	});
	arrData.push({
		"name":"futurePlans",
		"value":content
	});

	$.ajax({
		dataType : "json",
		type : "post",
		url : "cxtdDoc04Update",
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