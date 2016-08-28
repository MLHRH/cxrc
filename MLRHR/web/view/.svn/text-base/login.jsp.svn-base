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
<style type="text/css">
html, body {
	height: 100%;
}

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
</head>
<body>
		<div class="banner">
		<div class="navbar navbar-fixed-top ">
			<div class="navbar-inner">
				<div class="container">
					<a class="brand" href="#">国土资源科技创新人才工程管理信息系统</a>
					<ul class="nav">
						<li>
							<a href="#">
								<i class="icon-envelope"></i>联系我们
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	
	<div class="login">
		<div class="form-signin">
			<form action="${ctx}/j_spring_security_check" method="post">
				<h3 class="form-signin-heading">请登录</h3>
				<input type="hidden" name="lastPage" value="${lastPage}" />
				<label class="control-label" for="j_username">用户名（身份证号码）</label>
				<input type="text" name="j_username" id="j_username" class="input-block-level" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}">
				<label class="control-label" for="j_password">密 码（注册密码）</label>
				<input type="password" name="j_password" id="j_password" class="input-block-level">
				<br>
				<button class="btn btn-large btn-primary" type="submit">登 录</button>
				<a class="btn btn-large" href="${ctx}/register">注 册</a>
				<a class="control-label" href="${ctx}/getpassword" for="j_getpassword">忘记密码？</a>
				<%
					if (session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) != null) {
				%><br> <br>
				<div class="alert alert-error">
					<a class="close" data-dismiss="alert">×</a>
					账号或密码错误
				</div>
				<%
					}
				%>
			</form>
		</div>
	</div>
	</div>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>