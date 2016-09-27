var objUser = new Object();
var objbody = new Object();
var userBaseInfor_id;
var id_num;
var body_id;
var telephone;
var telefax;
var mobile;
var email;
var jisuanji;
var kaohe;
var tiaojian;
var yingyu;

function initDoc05() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc05Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					objUser = data[0];
					objUserBaseInfor = data[1];
					objBody = data[2];
					objUserStudy = data[3];
					var userbusiness = data[4];

					user_id = objUser.id;
					id_num = objUser.id_num;
					body_id = objUser.body_id;
					telephone = objUser.telephone;
					telefax = objUser.telefax;
					mobile = objUser.mobile;
					email = objUser.email;
					$('#userName').val(objUser.name);
					$('#userName2').val(objUser.name);

					userBaseInfor_id = objUserBaseInfor.id;
					jisuanji = objUserBaseInfor.jisuanji;
					kaohe = objUserBaseInfor.kaohe;
					tiaojian = objUserBaseInfor.tiaojian;
					yingyu = objUserBaseInfor.yingyu;
					if (objUserBaseInfor.gender == "男")
						$("input[name=user_gender]:eq(0)").attr("checked", 'checked');
					else
						$("input[name=user_gender]:eq(1)").attr("checked", 'checked');

					$('#user_minzu').val(objUserBaseInfor.minzu);
					$('#user_former_name').val(objUserBaseInfor.former_name);
					$('#user_birthday').val(objUserBaseInfor.birthday);
					$('#user_chushengdi').val(objUserBaseInfor.chushengdi);
					$('#user_canjiashijian').val(objUserBaseInfor.canjiashijian);
					$('#user_health').val(objUserBaseInfor.health);
					$('#user_zhengzhi').val(objUserBaseInfor.zhengzhi);
					$('#user_minzhudangpai').val(objUserBaseInfor.minzhudangpai);
					$('#user_shehuijianzhi').val(objUserBaseInfor.shehuijianzhi);
					$('#user_yuyan').val(objUserBaseInfor.yuyan);
					$('#user_gongzi').val(objUserBaseInfor.gongzi);
					$('#user_congshizhuanye').val(objUserBaseInfor.congshizhuanye);
					$('#user_renzhizige').val(objUserBaseInfor.renzhizige);
					$('#user_shenpidanwei').val(objUserBaseInfor.shenpidanwei);
					$('#user_shenpishijian').val(objUserBaseInfor.shenpishijian);
					$('#user_xingzhengzhiwu').val(objUserBaseInfor.xingzhengzhiwu);
					$('#user_xingzhengshijian').val(objUserBaseInfor.xingzhengshijian);
					$('#user_current_zhicheng').val(objUserBaseInfor.current_zhicheng);
					$('#user_current_zhicheng_date').val(objUserBaseInfor.current_zhicheng_date);

					$('#bodyName').val(objBody.name);
					$('#userStudy_end_date').val(objUserStudy.end_date);
					$('#userStudy_xuexiao').val(objUserStudy.place);
					$('#userStudy_zhuanye').val(objUserStudy.content);
					$('#userStudy_xuezhi').val(objUserStudy.xuezhi);
					$('#userStudy_xuewei').val(objUserStudy.xuewei);

					$('#yijian_1').val(userbusiness.yijian_1);
					$('#yijian_2').val(userbusiness.yijian_2);
					$('#yijian_3').val(userbusiness.yijian_3);
					$('#fuzeren_1').val(userbusiness.fuzeren_1);
					$('#fuzeren_2').val(userbusiness.fuzeren_2);
					$('#fuzeren_3').val(userbusiness.fuzeren_3);
					if (currentRole == "ROLE_HR"||currentRole == "ROLE_PROFESSOR"){
						$('#yijian_1').attr("disabled",false)//
						$('#yijian_2').attr("disabled",false)//
						$('#yijian_3').attr("disabled",false)//
						$('#fuzeren_1').attr("disabled",false)//
						$('#fuzeren_2').attr("disabled",false)//
						$('#fuzeren_3').attr("disabled",false)//
					}
					else {
						$('#yijian_1').attr("disabled",true)//
						$('#yijian_2').attr("disabled",true)//
						$('#yijian_3').attr("disabled",true)//
						$('#fuzeren_1').attr("disabled",true)//
						$('#fuzeren_2').attr("disabled",true)//
						$('#fuzeren_3').attr("disabled",true)//
					}

				}
			});
}
function updateDoc05() {
	arrData = new Array();
	arrData.push({
				"name" : "userId",
				"value" : user_id
			});
	arrData.push({
				"name" : "yijian_1",
				"value" : $("#yijian_1").val()
			});
	arrData.push({
				"name" : "yijian_2",
				"value" : $("#yijian_2").val()
			});
	arrData.push({
				"name" : "yijian_3",
				"value" : $("#yijian_3").val()
			});
	arrData.push({
				"name" : "fuzeren_1",
				"value" : $("#fuzeren_1").val()
			});
	arrData.push({
				"name" : "fuzeren_2",
				"value" : $("#fuzeren_2").val()
			});
	arrData.push({
				"name" : "fuzeren_3",
				"value" : $("#fuzeren_3").val()
			});

	$.ajax({
				dataType : "json",
				type : "post",
				url : "zhichengDoc05Update",
				data : arrData,
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) {
					if (rst.result == 1) {

					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
	// user
	arrData = new Array();
	arrData.push({
				"name" : "id",
				"value" : user_id
			});
	arrData.push({
				"name" : "name",
				"value" : $("#userName2").val()
			});
	arrData.push({
				"name" : "id_num",
				"value" : id_num
			});
	arrData.push({
				"name" : "body_id",
				"value" : body_id
			});
	arrData.push({
				"name" : "telephone",
				"value" : telephone
			});
	arrData.push({
				"name" : "telefax",
				"value" : telefax
			});
	arrData.push({
				"name" : "mobile",
				"value" : mobile
			});
	arrData.push({
				"name" : "email",
				"value" : email
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
					if (rst.result == 1) {

					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
	arrData = new Array();
	arrData.push({
				"name" : "id",
				"value" : userBaseInfor_id
			});
	arrData.push({
				"name" : "user_id",
				"value" : user_id
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
				"name" : "gongzi",
				"value" : $("#user_gongzi").val()
			});
	arrData.push({
				"name" : "yingyu",
				"value" : yingyu
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
				"name" : "jisuanji",
				"value" : jisuanji
			});
	arrData.push({
				"name" : "kaohe",
				"value" : kaohe
			});
	arrData.push({
				"name" : "tiaojian",
				"value" : tiaojian
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
									text : '附件3  保存完成！请继续完善其他信息!',
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
