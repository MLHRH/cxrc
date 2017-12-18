<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/common.jsp"%>
 <script type="text/javascript" src="${ctx}/static/ckeditor/ckeditor.js"></script>
<title>doc03</title>
</head>
<body>
<tr>	
<td width=487 colspan=7 valign=topstyle='width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 3pt' >
<div class=MsoNormal '>
<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 22.0pt; font-family: 幼圆; letter-spacing: 1.0pt'>推荐人选自我评价</span>
			</b>		
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 10.0pt; font-family: 仿宋; letter-spacing: 1.0pt'>主要包括研究能力和学术技术水平、对所属科学技术领域和相关产业影响等方面的情况。（1000字以内）</span>
			</b>		
		</p>
 </div></td></tr>
          <div>
                <td> 
				 <textarea name ="selfAssessment" class="ckeditor" id="selfAssessment"></textarea>
					 <script type="text/javascript">
					 editor=CKEDITOR.replace('selfAssessment');
                      </script> 
				</td>
          </div>
</body>
 
</html>
