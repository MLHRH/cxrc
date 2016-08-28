var obj = new Object();

function initDoc09() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc09Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					$('#userName').val(data.userName);
					$('#bodyName').val(data.bodyName);
					initFengpi(data.fengpi);
				}
			});
}
function initFengpi(str) {
	if (str != "" && str != null) {
		var arr = str.split("|");
		for (var i = 0; i < arr.length; i++) {
			var t = i + 1;
			$('#fengpi0' + t).val(arr[i]);
		}
	}
}
function updateDoc09() {
	var arrData = new Array();
	arrData.push({
				"name" : "userId",
				"value" : user_id
			});
	arrData.push({
				"name" : "userName",
				"value" : $('#userName').val()
			});
	arrData.push({
				"name" : "bodyName",
				"value" : $('#bodyName').val()
			});
	var myList = new Array($('#fengpi01').val(), $('#fengpi02').val(), $('#fengpi03').val(), $('#fengpi04').val(), $('#fengpi05').val(), $('#fengpi06').val(), $('#fengpi07').val(), $('#fengpi08')
					.val(), $('#fengpi09').val());
	var fengpi = myList.join("|");
	arrData.push({
				"name" : "fengpi",
				"value" : fengpi
			});
	$.ajax({
				"dataType" : 'json',
				"type" : "post",
				"url" : "zhichengDoc09Update",
				"data" : arrData,
				"success" : function(rst) {
					if (rst.result == 1) {
						noty({
									text : '附件7  保存完成！请继续完善其他信息！',
									type : 'success',
									dismissQueue : false,
									closeWith : ['click', 'button'],
									timeout : 1500,
									layout : 'top',
									callback : {
										afterClose : function() {
											// location.href='${ctx}/userBaseInfor?bt=base';
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
