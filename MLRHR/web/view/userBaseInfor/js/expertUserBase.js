var group_id ;
function update() {
	arrData = {};
	arrData.birthday = $('#user_birthday').val();
	arrData.gender = $('#user_sex').val();
	arrData.minzu = $('#user_minzu').val();
	arrData.congshizhuanye = $('#user_congshizhuanye').val();
	arrData.zhicheng = $('#user_current_zhicheng').val();
	arrData.xingzhengzhiwu = $('#user_xingzhengzhiwu').val();
	arrData.within_beijing = $('#within_beijing').val();
	arrData.address = $('#user_address').val();
	arrData.group_id = group_id;
	var baseInfo = JSON.stringify(arrData);
	$.ajax({
		dataType : "json",
		type : "post",
		url : "baseEdit",
		data :{"data": baseInfo},
		error : function() {// 请求失败处理函数
			alert('请求rrrrrr失败');
		},
		success : function(rst) {
			if (rst.result == 1) {
				alert("success!");

			} else {
				generatenoty('center', rst.msg, 'error');
			}
		}
	});
	
	}
var objUser = new Object();
var contentName = "expertBase";
$(document).ready(function() {
	initExpertBase();
});

	function initExpertBase() {
		$.ajax({
					type : 'get',
					dataType : 'json',
					url : 'expertBase',// 请求的路径
					error : function() {// 请求失败处理函数
						alert('请求失败');
					},
					success : function(data) { // 请求成功后处理函数。
						var myDate = new Date();
						var year = myDate.getFullYear();
						var month = myDate.getMonth() + 1;
						var day = myDate.getDate();
						$('#currentDate').html(year + "年" + month + "月" + day + "日");
					
						$('#user_birthday').val(data[1].birthday);
						$('#user_sex').val(data[1].gender);
						$('#user_minzu').val(data[1].minzu);
					    $('#user_congshizhuanye').val(data[1].congshizhuanye);
						$('#user_xingzhengzhiwu').val(data[1].xingzhengzhiwu);
						$('#user_current_zhicheng').val(data[1].zhicheng);
						$('#within_beijing').val(data[1].within_beijing);
						$('#xingzhengzhiwu').val(data[1].xingzhengzhiwu);
						$('#user_address').val(data[1].address);
						group_id =data[1].group_id;
//						var isUser = false;
//							for (var i = 0; i < arr.length - 1; i++) {
//								if (arr[i] == "ROLE_USER") {
//										isUser = true;
//								}
//							}
//							if(isUser == false){
//								$("#selfAssessment").attr("disabled",
//										true);
//								$("input").each(function(){
//									$(this).attr("disabled",
//											true);
//								});
//							}
					} 
				});
	}