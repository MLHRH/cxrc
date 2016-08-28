var objUser = new Object();
var objbody = new Object();
var userBaseInfor_id;
var id_num;
var body_id;
var telephone;
var telefax;
var mobile;
var email;
var kaohe;
var tiaojian;
var minzu;
var former_name;
var chushengdi;
var health;
var minzhudangpai;
var xingzhengshijian;
var zhengzhi;
var shehuijianzhi;
var yuyan;
var gongzi;
var user_current_zhicheng;
var user_current_zhicheng_date;
var myDateYear;
function initDoc06() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'calendarGet',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					myDateYear = data[0].start_date.substring(0, 4);
					$.ajax({
								type : 'get',
								dataType : 'json',
								url : 'zhichengDoc06Init?userId=' + user_id,// 请求的路径
								error : function() {// 请求失败处理函数
									alert('请求失败');
								},
								success : function(data) { // 请求成功后处理函数。
									objUser = data[0];
									objUserBaseInfor = data[1];
									objUserStudy = data[2];
									var userbusiness = data[3];

									user_id = objUser.id;
									id_num = objUser.id_num;
									body_id = objUser.body_id;
									telephone = objUser.telephone;
									telefax = objUser.telefax;
									mobile = objUser.mobile;
									email = objUser.email;
									$('#userName').val(objUser.name);

									userBaseInfor_id = objUserBaseInfor.id;
									minzu = objUserBaseInfor.minzu;
									former_name = objUserBaseInfor.former_name;
									chushengdi = objUserBaseInfor.chushengdi;
									health = objUserBaseInfor.health;
									minzhudangpai = objUserBaseInfor.minzhudangpai;
									xingzhengshijian = objUserBaseInfor.xingzhengshijian;
									user_current_zhicheng = objUserBaseInfor.current_zhicheng;
									user_current_zhicheng_date = objUserBaseInfor.current_zhicheng_date;
									zhengzhi = objUserBaseInfor.zhengzhi;
									shehuijianzhi = objUserBaseInfor.shehuijianzhi;
									yuyan = objUserBaseInfor.yuyan;
									gongzi = objUserBaseInfor.gongzi;
									initKaohe(objUserBaseInfor.kaohe);
									initTiaojian(objUserBaseInfor.tiaojian);
									if (objUserBaseInfor.gender == "男")
										$("input[name=user_gender]:eq(0)").attr("checked", 'checked');
									else
										$("input[name=user_gender]:eq(1)").attr("checked", 'checked');
									$('#user_birthday').val(objUserBaseInfor.birthday);
									$('#user_canjiashijian').val(objUserBaseInfor.canjiashijian);
									$('#user_yingyu').val(objUserBaseInfor.yingyu);
									$('#user_jisuanji').val(objUserBaseInfor.jisuanji);
									$('#user_congshizhuanye').val(objUserBaseInfor.congshizhuanye);
									$('#user_renzhizige').val(objUserBaseInfor.renzhizige);
									$('#user_shenpidanwei').val(objUserBaseInfor.shenpidanwei);
									$('#user_shenpishijian').val(objUserBaseInfor.shenpishijian);
									$('#user_xingzhengzhiwu').val(objUserBaseInfor.xingzhengzhiwu);

									$('#userStudy_end_date').val(objUserStudy.end_date);
									$('#userStudy_xuexiao').val(objUserStudy.place);
									$('#userStudy_zhuanye').val(objUserStudy.content);
									$('#userStudy_xuezhi').val(objUserStudy.xuezhi);
									$('#userStudy_xueli').val(objUserStudy.xueli);
									if (objUserStudy.xuewei == "博士" || objUserStudy.xueli == "博士研究生") {
										$('#user_yingyu').val("免试");
										$('#user_yingyu').attr("disabled", true);
										$('#user_jisuanji').val("免试");
										$('#user_jisuanji').attr("disabled", true);
									}
									$('#chuangxin').val(userbusiness.chuangxin);

									if ($("#zhichengnow").val() == "副研究员") {
										$('.apply_jibie').html("副高");
									} else if ($("#zhichengnow").val() == "研究员") {
										$('.apply_jibie').html("正高");
									} else {
										$('.apply_jibie').html("__");
									}
								}
							});
				}
			});

}
function initKaohe(str) {

	var year05 = myDateYear - 1;
	var year04 = myDateYear - 2;
	var year03 = myDateYear - 3;
	var year02 = myDateYear - 4;
	var year01 = myDateYear - 5;

	str = objUserBaseInfor.kaohe;
	var arr = str.split("|");

	$('#kaoheYear05').html(year05 + "年:");
	$('#kaoheYear04').html(year04 + "年:");
	$('#kaoheYear03').html(year03 + "年:");
	$('#kaoheYear02').html(year02 + "年:");
	$('#kaoheYear01').html(year01 + "年:");

	for (var i = arr.length - 1; i >= 0; i--) {
		var tempYear = arr[i].substring(0, 4);
		switch (parseInt(tempYear)) {
			case year05 :
				$('#kaohe05').val(arr[i].substring(6));
				break;
			case year04 :
				$('#kaohe04').val(arr[i].substring(6));
				break;
			case year03 :
				$('#kaohe03').val(arr[i].substring(6));
				break;
			case year02 :
				$('#kaohe02').val(arr[i].substring(6));
				break;
			case year01 :
				$('#kaohe01').val(arr[i].substring(6));
				break;
		}
	}

}
function initTiaojian(str) {
	str = objUserBaseInfor.tiaojian;
	if (str != "") {
		var arr = str.split("|");
		for (var i = 0; i < 3; i++) {
			if (arr[i].substring(2) == "1") {
				$("#user_tiaojian_" + i).attr("checked", 'true');
			} else {
				$("#user_tiaojian_" + i).removeAttr("checked");
			}
		}
		var test = $("input[type='radio'][value='" + arr[3].substring(2) + "']");
		test.attr("checked", 'true');
	}
}
function updateDoc06() {
	// 创新内容
	arrData = new Array();
	arrData.push({
				"name" : "userId",
				"value" : user_id
			});
	arrData.push({
				"name" : "chuangxin",
				"value" : $("#chuangxin").val()
			});

	$.ajax({
				dataType : "json",
				type : "post",
				url : "zhichengDoc06Update",
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
				"value" : $("#userName").val()
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
				"value" : former_name
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
				"value" : health
			});
	arrData.push({
				"name" : "chushengdi",
				"value" : chushengdi
			});
	arrData.push({
				"name" : "minzu",
				"value" : minzu
			});
	if ($("#user_canjiashijian").val() != "")
		arrData.push({
					"name" : "canjiashijian",
					"value" : $("#user_canjiashijian").val()
				});
	arrData.push({
				"name" : "zhengzhi",
				"value" : zhengzhi
			});
	arrData.push({
				"name" : "minzhudangpai",
				"value" : minzhudangpai
			});
	arrData.push({
				"name" : "shehuijianzhi",
				"value" : shehuijianzhi
			});
	arrData.push({
				"name" : "yingyu",
				"value" : $("#user_yingyu").val()
			});
	arrData.push({
				"name" : "yuyan",
				"value" : yuyan
			});
	arrData.push({
				"name" : "gongzi",
				"value" : gongzi
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
	if (xingzhengshijian != "")
		arrData.push({
					"name" : "xingzhengshijian",
					"value" : xingzhengshijian
				});
	arrData.push({
				"name" : "current_zhicheng_date",
				"value" : user_current_zhicheng_date
			});
	arrData.push({
				"name" : "current_zhicheng",
				"value" : user_current_zhicheng
			});

	var myList = new Array($('#kaoheYear01').html() + $('#kaohe01').val(), $('#kaoheYear02').html() + $('#kaohe02').val(), $('#kaoheYear03').html() + $('#kaohe03').val(), $('#kaoheYear04').html()
					+ $('#kaohe04').val(), $('#kaoheYear05').html() + $('#kaohe05').val());
	kaohe = myList.join("|");
	arrData.push({
				"name" : "kaohe",
				"value" : kaohe
			});

	var user_tiaojian_1_isCheck = 0;
	var user_tiaojian_2_isCheck = 0;
	var user_tiaojian_3_isCheck = 0;
	var user_tiaojian_4_checked = 0;
	if ($("#user_tiaojian_0").attr("checked") == "checked") {
		user_tiaojian_1_isCheck = 1
	}
	if ($("#user_tiaojian_1").attr("checked") == "checked") {
		user_tiaojian_2_isCheck = 1
	}
	if ($("#user_tiaojian_2").attr("checked") == "checked") {
		user_tiaojian_3_isCheck = 1
	}
	user_tiaojian_4_checked = $('input[name="user_tiaojian4"]:checked ').val();

	tiaojian = "1:" + user_tiaojian_1_isCheck + "|2:" + user_tiaojian_2_isCheck + "|3:" + user_tiaojian_3_isCheck + "|4:" + user_tiaojian_4_checked;
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
									text : '附件4  保存完成！请继续完善其他信息!',
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
