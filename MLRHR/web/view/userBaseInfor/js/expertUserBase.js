var group_id ;
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
					} 
				});
	}