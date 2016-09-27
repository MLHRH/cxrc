function clearForm(form) {
	$(':input', form).each(function() {
				var type = this.type;
				var tag = this.tagName.toLowerCase();
				if (type == 'text' || type == 'password' || tag == 'textarea')
					this.value = "";
				else if (type == 'checkbox' || type == 'radio')
					this.checked = false;
				else if (tag == 'select')
					this.selectedIndex = -1;
			});
};
$(document).ready(function() {
			$("#changepassword").validate({
						rules : {
							oldPassword : {
								required : true
							},
							newPassword : {
								required : true,
								minlength : 6
							},
							newPassword2 : {
								required : true,
								equalTo : "#newPassword"
							}
						},
						messages : {
							oldPassword : {
								required : "没有填写密码"
							},
							newPassword : {
								required : "请填写新密码",
								minlength : jQuery.format("密码不能小于{0}个字符")
							},
							newPassword2 : {
								required : "请确认新密码",
								equalTo : "两次输入密码不一致！"
							}
						},
						highlight : function(label) {
							$(label).closest('.control-group').addClass('error');
							$('#submit').attr('disabled', true);
						},
						unhighlight : function(label) {
							$(label).closest('.control-group').removeClass('error');
							$('#submit').attr('disabled', false);
						},
						errorElement : 'span'
					});
			$("#submit").click(function() {
						if (validatechangepassword()) {
							arrData = new Array();
							arrData.push({
										"name" : "oldPassword",
										"value" : $("#oldPassword").val()
									});
							arrData.push({
										"name" : "newPassword",
										"value" : $("#newPassword").val()
									});
							$.ajax({
										"dataType" : 'json',
										"type" : "post",
										"url" : "changepwd",
										"data" : arrData,
										"success" : function(rst) {
											if (rst.result == 1) {
												// generatenoty('top',rst.msg,'success');
												var ny = noty({
															text : rst.msg,
															type : 'success',
															dismissQueue : false,
															closeWith : ['click', 'button'],
															timeout : 1500,
															layout : 'top',
															callback : {
																afterClose : function() {
																	self.location = "logout";
																}
															},
															theme : 'defaultTheme'
														});
											} else {
												generatenoty('top', rst.msg, 'error');
												clearForm($('#changepassword'));
											}
										}
									});
						}
					});
		});
function validatechangepassword() {
	if ($("#oldPassword").val() == "") {
		generatenoty('center', "请输入当前密码！", 'error');
		return false;
	}
	if ($("#newPassword").val() == "") {
		generatenoty('center', "请输入新密码！", 'error');
		return false;
	}
	if ($("#newPassword2").val() == "") {
		generatenoty('center', "请确认新密码！", 'error');
		return false;
	}
	return true;
}