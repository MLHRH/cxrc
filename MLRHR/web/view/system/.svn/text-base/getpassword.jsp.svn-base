<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<%@ include file="/common/common.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
body {
	padding-top: 43px;
	padding-bottom: 0px;
	background-color: #fff;
	text-align: left;
}

.form-signin {
	max-width: 240px;
	padding: 25px 39px 10px;
	margin: 0 auto;
	margin-right:70%;
	background-color: #fff;
	border: 2px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 2px 3px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 2px 3px rgba(0, 0, 0, .05);
	box-shadow: 0 2px 3px rgba(0, 0, 0, .05);
}

.login {
	 padding: 5% 20%;
	margin: 0 auto 0px;
	background-repeat: no-repeat;
	background-position: center;
	background-color: #56a4f6;
	background-image: url(images/login_02.jpg);
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 5px;
	margin-top: 1px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	font-size: 14px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>


<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
</head>
<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
<body>
	<div class="banner">
		<div class="navbar navbar-fixed-top ">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="#"> 国土资源科技创新人才工程管理信息系统</a>
					<ul class="nav">
						<li>
							<a href="mailto:zhangqc@cags.ac.cn">
								<i class="icon-envelope"></i>联系我们
							</a>
						</li>
						<li>
							<a href="${ctx}/login">
								<i class="icon-user"></i> 登 录
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="login">
			<div class="form-signin">
				<form action="" id="getpassword" method="post">
					<h3 class="form-signin-heading">找回密码</h3>
					<div class="control-group">
						<label class="control-label" for="identification">用户名（身份证号码）</label>
						<div class="controls">
							<input type="input" id="username" name="username" class="input-block-level required" minlength="6">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="username">电子邮箱</label>
						<div class="controls">
							<input type="input" id="email" name="email" class="input-block-level required" minlength="6">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button id="submit" type="button" class="btn btn-primary">提交</button>
							<button id="reset" type="reset" class="btn">重置</button>
						</div>
					</div>
				</form>
			</div>
			<!--/row-->
		</div>
	</div>


	<%@ include file="/common/footer.jsp"%>
	<%@ include file="/common/jquery.noty.jsp"%>
	<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
	<!--/.fluid-container-->
	<script>
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
			$("#getpassword").validate({
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
				arrData = new Array();
				arrData.push({
					"name" : "email",
					"value" : $("#email").val()
				});
				arrData.push({
					"name" : "username",
					"value" : $("#username").val()
				});
				$.ajax({
					"dataType" : 'json',
					"type" : "post",
					"url" : "${ctx}/sendGetPasswordMail",
					"data" : arrData,
					"success" : function(rst) {
						if (rst.result == 1) {
							//generatenoty('top',rst.msg,'success');
							var ny = noty({
								text : rst.msg,
								type : 'success',
								dismissQueue : false,
								closeWith : [ 'click', 'button' ],
								timeout : 1500,
								layout : 'top',
								callback : {
									afterClose : function() {
										self.location = "${ctx}/getpassword";
									}
								},
								theme : 'defaultTheme'
							});
						} else if (rst.result == 2) {
							generatenoty('top', rst.msg, 'error');
							clearForm($('#getpassword'));
						} else {
							generatenoty('top', rst.msg, 'error');
							clearForm($('#getpassword'));
						}
					}
				});
			});
		});
	</script>
</body>
</html>