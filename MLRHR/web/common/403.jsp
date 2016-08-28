<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>HTTP Error 403 - Forbidden</title>
<link href="${ctx}/static/bootstrap/2.1.1/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
</head>
<body>
	<div class="hero-unit center">
		<h1>
			HTTP Error 403 - Forbidden. <small><font face="Tahoma"
				color="red">Error 403</font></small>
		</h1>
		<br />
		<p>
			The Web server is configured to not list the contents of this
			directory. Use your browsers <b>Back</b> button to navigate to the
			page you have prevously come from.
		</p>
		<p>
			<b>Or you could just go to homepage: </b><a href="${ctx}/filelist"
				class="btn btn-large btn-info"><i class="icon-home"></i>
				Take Me Home</a>&nbsp;&nbsp;<a href="${ctx}/j_spring_security_logout">Log
				out</a>
		</p>
	</div>
</body>
</html>