function initUserBase() {
	checkEdit();
	// 基础信息提交
	$("#submit_base").live("click", function() {
				$("#detail_base").validate({
							highlight : function(label) {
								$(label).closest('.control-group').addClass('error');
							},
							unhighlight : function(label) {
								$(label).closest('.control-group').removeClass('error');
							},
							errorElement : 'span',
							submitHandler : function() {
								arrData = new Array();
								arrData.push({
											"name" : "id",
											"value" : $("#user_id").val()
										});
								arrData.push({
											"name" : "name",
											"value" : $("#user_name").val()
										});
								arrData.push({
											"name" : "id_num",
											"value" : $("#user_id_num").val()
										});
								arrData.push({
											"name" : "body_id",
											"value" : $("#user_body_id_select").val()
										});
								arrData.push({
											"name" : "telephone",
											"value" : $("#user_telephone").val()
										});
								arrData.push({
											"name" : "telefax",
											"value" : $("#user_telefax").val()
										});
								arrData.push({
											"name" : "mobile",
											"value" : $("#user_mobile").val()
										});
								arrData.push({
											"name" : "email",
											"value" : $("#user_email").val()
										});
								$.ajax({
											dataType : "json",
											type : "post",
											url : "updateUser",
											data : arrData,
											error : function() {// 请求失败处理函数
												alert('请求失败');
											},
											success : function(rst) {
												// if(rst.result==1){
												// noty({
												// text: '基础信息 更新完成.请继续完善其他信息.',
												// type: 'success',
												// dismissQueue: false,
												// closeWith:
												// ['click','button'],
												// timeout: 1500,
												// layout: 'top',
												// callback:{afterClose:function(){
												// //
												// location.href='${ctx}/userBaseInfor?bt=base';
												// }},
												// theme: 'defaultTheme'
												// });
												// }
												// else{
												// generatenoty('center',rst.msg,'error');
												// }
											}
										});
								arrData = new Array();
								arrData.push({
											"name" : "id",
											"value" : $("#userbaseinfor_id").val()
										});
								arrData.push({
											"name" : "user_id",
											"value" : $("#user_id").val()
										});
								arrData.push({
											"name" : "former_name",
											"value" : $("#user_former_name").val()
										});
								arrData.push({
											"name" : "gender",
											"value" : $("input[name='user_gender']:checked").val()
										});
								if ($("#user_birthday").val() != "")
									arrData.push({
												"name" : "birthday",
												"value" : $("#user_birthday").val()
											});
								arrData.push({
											"name" : "health",
											"value" : $("#user_health").val()
										});
								arrData.push({
											"name" : "chushengdi",
											"value" : $("#user_chushengdi").val()
										});
								arrData.push({
											"name" : "minzu",
											"value" : $("#user_minzu").val()
										});
								if ($("#user_canjiashijian").val() != "")
									arrData.push({
												"name" : "canjiashijian",
												"value" : $("#user_canjiashijian").val()
											});
								arrData.push({
											"name" : "zhengzhi",
											"value" : $("#user_zhengzhi").val()
										});
								arrData.push({
											"name" : "minzhudangpai",
											"value" : $("#user_minzhudangpai").val()
										});
								arrData.push({
											"name" : "shehuijianzhi",
											"value" : $("#user_shehuijianzhi").val()
										});
								arrData.push({
											"name" : "yuyan",
											"value" : $("#user_yuyan").val()
										});
								arrData.push({
											"name" : "yingyu",
											"value" : $("#user_yingyu").val()
										});
								arrData.push({
											"name" : "gongzi",
											"value" : $("#user_gongzi").val()
										});
								arrData.push({
											"name" : "jisuanji",
											"value" : $("#user_jisuanji").val()
										});
								arrData.push({
											"name" : "congshizhuanye",
											"value" : $("#user_congshizhuanye").val()
										});
								arrData.push({
											"name" : "renzhizige",
											"value" : $("#user_renzhizige").val()
										});
								arrData.push({
											"name" : "shenpidanwei",
											"value" : $("#user_shenpidanwei").val()
										});
								if ($("#user_shenpishijian").val() != "")
									arrData.push({
												"name" : "shenpishijian",
												"value" : $("#user_shenpishijian").val()
											});
								arrData.push({
											"name" : "xingzhengzhiwu",
											"value" : $("#user_xingzhengzhiwu").val()
										});
								if ($("#user_xingzhengshijian").val() != "")
									arrData.push({
												"name" : "xingzhengshijian",
												"value" : $("#user_xingzhengshijian").val()
											});
								arrData.push({
											"name" : "current_zhicheng",
											"value" : $("#user_current_zhicheng").val()
										});
								if ($("#user_current_zhicheng_date").val() != "")
									arrData.push({
												"name" : "current_zhicheng_date",
												"value" : $("#user_current_zhicheng_date").val()
											});
								arrData.push({
											"name" : "kaohe",
											"value" : $("#user_kaohe").val()
										});
								arrData.push({
											"name" : "tiaojian",
											"value" : $("#user_tiaojian").val()
										});
								$.ajax({
											dataType : "json",
											type : "post",
											url : "updateUserBaseDetail",
											data : arrData,
											error : function() {// 请求失败处理函数
												alert('请求失败');
											},
											success : function(rst) {
												if (rst.result == 1) {
													noty({
																text : '基础信息 更新完成.请继续完善其他信息.',
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
						});
			});
}
function checkEdit() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'checkEdit',// 请求的路径
				error : function() {// 请求失败处理函数
				},
				success : function(rst) { // 请求成功后处理函数。
					if (rst.result == 0) {
						alert('您的申请记录正在审批流程中，当前状态信息不可编辑！');
						location.href = 'zhichengApplylist';
					}
				}
			});
}