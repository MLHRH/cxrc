<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 <script type="text/javascript" src="${ctx}/static/ckeditor/ckeditor.js"></script>
<title>doc04</title>
</head>
<body>
<tr>	
<td width=487 colspan=7 valign=topstyle='width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 3pt' >
<div class=MsoNormal '>
<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 22.0pt; font-family: 幼圆; letter-spacing: 1.0pt'>未来研究计划及当前研究基础</span>
			</b>
		</p>
 </div></td></tr>
                  <div>
                      <td colspan="3">
						<textarea name ="futurePlans" class="ckeditor" id="futurePlans"></textarea>
						 <script type="text/javascript">
					            editor=CKEDITOR.replace('futurePlans');
                      </script> 
					</td>
              </div>
</body>
</html>