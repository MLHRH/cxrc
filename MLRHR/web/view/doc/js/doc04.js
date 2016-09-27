var obj = new Object();

function initDoc04() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc04Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					$('#userName').val(data.userName);
					$('#bodyName').val(data.bodyName);
					$('#autobiography').val(data.autobiography);

				}
			});
}
function updateDoc04() {
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
	arrData.push({
				"name" : "autobiography",
				"value" : $('#autobiography').val()
			});
	$.ajax({
				"dataType" : 'json',
				"type" : "post",
				"url" : "zhichengDoc04Update",
				"data" : arrData,
				"success" : function(rst) {
					if (rst.result == 1) {
						noty({
									text : '附件2  保存完成！请继续完善其他信息！',
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
