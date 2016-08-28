<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<%@ page import="org.springside.modules.security.springsecurity.SpringSecurityUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>国土资源科技创新人才工程管理信息系统</title>
<%@ include file="/common/common.jsp"%>
<link href="${ctx}/static/styles/jquery.dataTables.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.columnFilter.js"></script>
<script type="text/javascript" src="${ctx}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
<%@ include file="/common/jquery.noty.jsp"%>
<link href="${ctx}/static/bootstrap/2.1.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
<style type="text/css">
body {
	padding-top: 43px;
	padding-bottom: 0px;
	background-color: #fff;
	text-align: left;
}

.banner {
	background-color: #4292DB;
}

.form-signin {
	max-width: 240px;
	padding: 25px 39px 10px;
	margin: 0 auto 10px;
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
	padding: 55px 0px 30px 400px;
	margin: 0 auto 0px;
	background-image: url(images/login_02.jpg);
	background-repeat: no-repeat;
	background-position: center;
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
</head>
<script>
	$(document).ready(function() {
		$("#j_body option:first").remove();
		$("#j_body").prepend("<option value='0'>请选择</option>");
		$("#submit").click(function() {
			if ($("#j_body").val() == "0") {
				$("#j_body_2").val("");
			} else {
				$("#j_body_2").val($("#j_body").val());
			}

			$("#register").validate({
				rules : {
					j_username : {
						required : true
					},
					j_idnum : {
						required : true,
						rangelength : [ 18, 18 ]
					},
					j_email : {
						required : true,
						email : true
					},
					j_body_2 : {
						required : true
					},
					j_password : {
						required : true,
						minlength : 6
					}
				},
				messages : {
					j_username : {
						required : "姓名不能为空！"
					},
					j_idnum : {
						required : "身份证号不能为空！",
						rangelength : jQuery.format("请输入{0}位身份证号码！")
					},
					j_email : {
						required : "邮箱不能为空！",
						email : "请输入正确邮箱格式！",
					},
					j_body_2 : {
						required : "请选择工作单位！",
					},
					j_password : {
						required : "密码不能为空！",
						minlength : jQuery.format("密码不能小于{0}个字符")
					}
				},
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
						"name" : "j_username",
						"value" : $.trim($("#j_username").val())
					});
					arrData.push({
						"name" : "j_idnum",
						"value" : $.trim($("#j_idnum").val())
					});
					arrData.push({
						"name" : "j_email",
						"value" : $.trim($("#j_email").val())
					});
					arrData.push({
						"name" : "j_body",
						"value" : $("#j_body").val()
					});
					arrData.push({
						"name" : "j_password",
						"value" : $.trim($("#j_password").val())
					});
					$.ajax({
						"dataType" : 'json',
						"type" : "post",
						"url" : "${ctx}/registersave",
						"data" : arrData,
						"success" : function(rst) {
							if (rst.result == 1) {
								noty({
									text : '注册成功，继续登录！',
									type : 'success',
									dismissQueue : false,
									closeWith : [ 'click', 'button' ],
									timeout : 3000,
									layout : 'top',
									callback : {
										afterClose : function() {
											location.href = '${ctx}/login';
										}
									},
									theme : 'defaultTheme'
								});
							} else if (rst.result == 2) {
								noty({
									text : '该身份证号码已经注册，请直接登录！',
									type : 'error',
									dismissQueue : false,
									closeWith : [ 'click', 'button' ],
									timeout : 4000,
									layout : 'top',
									callback : {
										afterClose : function() {
											location.href = '${ctx}/register';
										}
									},
									theme : 'defaultTheme'
								});
							} else {
								generatenoty('center', '注册失败，请联系管理员！', 'error');
							}
						}
					});
				}
			});
		});
	});
</script>
<body>
	<div class="banner">
		<div class="navbar navbar-fixed-top ">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="#"> 国土资源科技创新人才工程管理信息系统</a>
					<ul class="nav">
						<li>
							<a href="mailto:zhangqc@cags.ac.cn">
								<i class="icon-envelope"></i> 联系我们
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
				<form id="register" action="${ctx}/registersave" method="post">
					<h3 class="form-signin-heading">欢迎注册</h3>
					<label class="control-label" for="j_idnum">身份证号码（登陆用户名）</label>
					<input type="text" name="j_idnum" id="j_idnum" class="input-block-level">
					<label class="control-label" for="j_password">创建密码（登陆密码）</label>
					<input type="password" name="j_password" id="j_password" class="input-block-level">
					<label class="control-label" for="j_username">姓名</label>
					<input type="text" name="j_username" id="j_username" class="input-block-level">
					<label class="control-label" for="j_email">电子邮箱(找回密码使用)</label>
					<input type="email" name="j_email" id="j_email" class="input-block-level">
					<label class="control-label" for="j_body">工作单位</label>
					<select name="j_body" id="j_body" class="input-block-level">
						<c:forEach var="body" items="${bodyList}">
							<option value=${body.id}>${body.name}</option>
						</c:forEach>
					</select>
					<input name="j_body_2" id="j_body_2" class="input-block-level" style="border:0px solid ;height: 0px;min-height: 0px">

					<br>
					<button class="btn btn-success btn-large btn-block" type="submit" id="submit" type="submit">注 册</button>
				</form>
			</div>
		</div>
	</div>

	<footer class="footer">
	<div class="container">
		<p>&copy; 2015 中国地质科学院版权所有</p>

	</div>
	</footer>
</body>
</html>