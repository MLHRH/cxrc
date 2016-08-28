var obj = new Object();
var objId = "";
function initDoc08() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc08Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					user = data[0];
					userbaseinfor = data[1];
					objBody = data[2];
					objUser = data[3];

					$('#userName').val(user.name);
					$('#bodyName').val(objBody.name);
					$('#user_current_zhicheng').val(userbaseinfor.current_zhicheng);
					

					objId = objUser.id;
					$('#objUser_xueli').val(objUser.xueli);
					$('#objUser_xuewei').val(objUser.xuewei);
					$('#objUser_tuijian_name').val(objUser.tuijian_name);
					$('#objUser_tuijian_zhiwu').val(objUser.tuijian_zhiwu);
					$('#objUser_tuijian_danwei').val(objUser.tuijian_danwei);
					$('#objUser_tuijian_liyou').val(objUser.tuijian_liyou);
					$('#objUser_tuijian_zhuanjia').val(objUser.tuijian_zhuanjia);
					
					$('#objUser_tuijian_name_2').val(objUser.tuijian_name_2);
					$('#objUser_tuijian_zhiwu_2').val(objUser.tuijian_zhiwu_2);
					$('#objUser_tuijian_danwei_2').val(objUser.tuijian_danwei_2);
					$('#objUser_tuijian_liyou_2').val(objUser.tuijian_liyou_2);
					$('#objUser_tuijian_zhuanjia_2').val(objUser.tuijian_zhuanjia_2);

				}
			});
}
function updateDoc08() {
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
				"name" : "user_current_zhicheng",
				"value" : $('#user_current_zhicheng').val()
			});
	if (objId != "")
		arrData.push({
					"name" : "id",
					"value" : objId
				});
	arrData.push({
				"name" : "user_id",
				"value" : user_id
			});
	arrData.push({
				"name" : "xueli",
				"value" : $('#objUser_xueli').val()
			});
	arrData.push({
				"name" : "xuewei",
				"value" : $('#objUser_xuewei').val()
			});
	arrData.push({
				"name" : "tuijian_name",
				"value" : $('#objUser_tuijian_name').val()
			});
	arrData.push({
				"name" : "tuijian_zhiwu",
				"value" : $('#objUser_tuijian_zhiwu').val()
			});
	arrData.push({
				"name" : "tuijian_danwei",
				"value" : $('#objUser_tuijian_danwei').val()
			});
	arrData.push({
				"name" : "tuijian_liyou",
				"value" : $('#objUser_tuijian_liyou').val()
			});
	arrData.push({
				"name" : "tuijian_zhuanjia",
				"value" : $('#objUser_tuijian_zhuanjia').val()
			});
			
	arrData.push({
				"name" : "tuijian_name_2",
				"value" : $('#objUser_tuijian_name_2').val()
			});
	arrData.push({
				"name" : "tuijian_zhiwu_2",
				"value" : $('#objUser_tuijian_zhiwu_2').val()
			});
	arrData.push({
				"name" : "tuijian_danwei_2",
				"value" : $('#objUser_tuijian_danwei_2').val()
			});
	arrData.push({
				"name" : "tuijian_liyou_2",
				"value" : $('#objUser_tuijian_liyou_2').val()
			});
	arrData.push({
				"name" : "tuijian_zhuanjia_2",
				"value" : $('#objUser_tuijian_zhuanjia_2').val()
			});
	$.ajax({
				"dataType" : 'json',
				"type" : "post",
				"url" : "zhichengDoc08Update",
				"data" : arrData,
				"success" : function(rst) {
					if (rst.result == 1) {
						noty({
									text : '附件6  保存完成！请继续完善其他信息！',
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
