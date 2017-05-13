<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>doc02</title>
</head>
<body bgcolor=white lang=ZH-CN style='text-justify-trim: punctuation'>

	<div class=WordSection1 style='layout-grid: 15.6pt; padding: 10px 50px 10px 60px;'>


		 <p class=MsoNormal align=left style='text-align: left'>
			<span style='font-size: 16.0pt; font-family: 仿宋'>
				附件
				<span lang=EN-US>2(此表需到“我的档案”中完善)</span>
			</span>
		</p>
      <div class="modal hide" id="myModal" style="width: 600px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3 id="myModalTitle">附件窗口</h3>
			</div>
			<div class="modal-body" style="min-height: 300px; max-height: 600px; padding-left: 0; padding-right: 0;"></div>
			<div class="modal-footer">
				<a id="myModalSave" class="btn btn-primary" style="margin-right: 5px" href='javascript:void(0)' onclick="" class='btn'>保存</a>
				<a href='javascript:void(0)' data-dismiss='modal' class='btn'>取消</a>
			</div>
		</div>

		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>


		<%-- <p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 16.0pt'>&nbsp;</span>
		</p>

		<p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 16.0pt'>&nbsp;</span>
		</p>

		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>学&nbsp;习&nbsp;培&nbsp;训&nbsp;经&nbsp;历</span>
			</b>
		</p>

		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 15.0pt; font-family: 宋体'>（包括参加专业学习、培训、国内外进修等）</span>
			</b>
		</p>

		<div class="modal hide" id="myModal" style="width: 600px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3 id="myModalTitle">附件窗口</h3>
			</div>
			<div class="modal-body" style="min-height: 300px; max-height: 600px; padding-left: 0; padding-right: 0;"></div>
			<div class="modal-footer">
				<a id="myModalSave" class="btn btn-primary" style="margin-right: 5px" href='javascript:void(0)' onclick="" class='btn'>保存</a>
				<a href='javascript:void(0)' data-dismiss='modal' class='btn'>取消</a>
			</div>
		</div>
		<jsp:include  page="" /view/userBaseInfor/userPeixun.jspflush="true"/>
		 
      <%@ include file="/view/userBaseInfor/userPeixun.jsp"%>
  --%>

		<%-- <p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>

		<!-- 		工&nbsp;作&nbsp;经&nbsp;历 -->
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>工&nbsp;作&nbsp;经&nbsp;历</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userWork.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p> --%>

      <p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>承担主要科研任务情况</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userProject.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>获得主要科研学术奖励情况</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userAward.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>代&nbsp;表&nbsp;性&nbsp;论&nbsp;文</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userChengguo.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>获得授权专利情况</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userZhuanli.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>在重要国际学术会议报告情况</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userBaogao.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>重要专著情况（不超过5项）</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userReport.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		
		
		
		<%-- <!-- 任现职前主要专业技术工作业绩登记 -->
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>任现职前主要专业技术工作业绩登记</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userSkill.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		

		
		<!-- 		考&nbsp;试&nbsp;经&nbsp;历 -->
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>考&nbsp;试&nbsp;经&nbsp;历</span>
			</b>
		</p>
		<%@ include file="/view/userBaseInfor/userExam.jsp"%>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>
		
		
		
		<!-- 		著作、论文及重要技术报告登记 -->
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 7.5pt'>&nbsp;</span>
			</b>
		</p>

		<p class=MsoNormal style='text-align: center'>
			<b> <span lang=EN-US style='font-size: 18.0pt'>&nbsp;</span>
			</b>
		</p>

		

		 --%>
		

	




<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>
		



		<p class=MsoNormal>
			<span lang=EN-US>&nbsp;</span>
		</p>

	</div>

</body>

</html>