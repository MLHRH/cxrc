function initDoc07() {
	// checkEditDoc07();
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc07Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					user = data[0];
					userbaseinfor = data[1];
					objBody = data[2];
					var userpeixun = data[3];

					var myDate = new Date();
					var year = myDate.getFullYear();

					$('#name').html(user.name);
					$('#gender').html(userbaseinfor.gender);
					$('#birthday').html(userbaseinfor.birthday);
					$('#canjiashijian').html(userbaseinfor.canjiashijian);
					$('#congshizhuanye').html(userbaseinfor.congshizhuanye);
					var temp = year - userbaseinfor.canjiashijian.substring(0, 4);
					$('#zhuanyeYearInt').html(temp + "年");
					$('#renzhizige').html(userbaseinfor.renzhizige);
					$('#shenpishijian').html(userbaseinfor.shenpishijian);
					var temp2 = year - userbaseinfor.shenpishijian.substring(0, 4);
					$('#renzhiYearInt').html(temp2 + "年");
					$('#shenpidanwei').html(userbaseinfor.shenpidanwei);
					$('#yingyu').html(userbaseinfor.yingyu);
					$('#jisuanji').html(userbaseinfor.jisuanji);
					//					
					$('#xuewei').html(userpeixun.xuewei);
					$('#xueli').html(userpeixun.xueli);
					$('#place').html(userpeixun.place);
					$('#user_content').html(userpeixun.content);
					$('#end_date').html(userpeixun.end_date);

					if ($("#zhichengnow").val() == "副研究员") {
						$('.apply_jibie').html("副高");
					} else if ($("#zhichengnow").val() == "研究员") {
						$('.apply_jibie').html("正高");
					} else {
						$('.apply_jibie').html("__");
					}

					if ($("#zhichengType").val() != -1) {
						$('#apply_type').html($("#zhichengType").val());
					}

				}
			});
}
function checkEditDoc07() {
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
