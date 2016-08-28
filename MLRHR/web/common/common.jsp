<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link href="${ctx}/static/bootstrap/2.1.1/css/bootstrap.min.css" rel="stylesheet" media="screen" />
<link rel="stylesheet" href="${ctx}/static/bootstrap/2.1.1/css/bootstrap-responsive.min.css">
<script src="${ctx}/static/jquery/1.8.3/jquery.min.js"></script>
<script src="${ctx}/static/bootstrap/2.1.1/js/bootstrap.min.js"></script>
<link href="${ctx}/css/jfn.css" rel="stylesheet">
<script type="text/javascript">
	if (!!window.ActiveXObject || "ActiveXObject" in window) {
		$.ajaxSetup({
			cache : false
		});
	}
</script>
<link rel="shortcut icon" href="images/logo.ico" type="image/x-icon" />
<link rel="icon" href="images/logo.ico" type="image/x-icon" />




