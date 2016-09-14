<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<%@ include file="/common/common.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Le styles -->
<style type="text/css">
body {
	padding-top: 80px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link type="text/css" rel="stylesheet" href="${ctx}/static/styles/jquery.dataTables.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/static/jquery/lightSlider/css/lightSlider.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/static/jquery/magiczoomplus/magiczoomplus.css" media="screen" />
<script type="text/javascript" src="${ctx}/static/jquery/DataTables-1.10.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.columnFilter.js"></script>
<script type="text/javascript" src="${ctx}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/lightSlider/js/jquery.lightSlider.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/magiczoomplus/magiczoomplus.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/pdfobject.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/getURLparam.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/google-code-prettify/prettify.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap/wysiwyg/external/jquery.hotkeys.js"></script>

<script type="text/javascript" src="${ctx}/view/zhicheng/js/zhichengApply.js"></script>
<script type="text/javascript" src="${ctx}/view/fileManager/js/checkFile.js"></script>
<script type="text/javascript" src="${ctx}/view/fileManager/js/checkFilePDF.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userStudy.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userStudyEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userWork.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userWorkEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userProject.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userProjectEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userPeixun.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userPeixunEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userReport.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userReportEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userChengguo.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userChengguoEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userExam.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userExamEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userZhuanli.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userZhuanliEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userAward.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userAwardEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userSkill.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userSkillEdit.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userSkill_2.js"></script>
<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/userSkill_2Edit.js"></script>

<script type="text/javascript" src="${ctx}/view/cxtdDoc/js/cxtdDoc01.js"></script>
<script type="text/javascript" src="${ctx}/view/cxtdDoc/js/cxtdDoc02.js"></script>
<script type="text/javascript" src="${ctx}/view/cxtdDoc/js/cxtdDoc03.js"></script>
<script type="text/javascript" src="${ctx}/view/cxtdDoc/js/cxtdDoc04.js"></script>
<script type="text/javascript" src="${ctx}/view/cxtdDoc/js/cxtdDoc05.js"></script>
<%-- <script type="text/javascript" src="${ctx}/view/cxtdDoc/js/cxtdDoc06.js"></script>
<script type="text/javascript" src="${ctx}/view/cxtdDoc/js/cxtdDoc07.js"></script> --%>

<script type="text/javascript" src="${ctx}/view/jcqnDoc/js/doc01.js"></script>
<script type="text/javascript" src="${ctx}/view/jcqnDoc/js/doc02.js"></script>
<script type="text/javascript" src="${ctx}/view/jcqnDoc/js/doc03.js"></script>
<script type="text/javascript" src="${ctx}/view/jcqnDoc/js/doc04.js"></script>
<script type="text/javascript" src="${ctx}/view/jcqnDoc/js/doc05.js"></script>
<%-- <script type="text/javascript" src="${ctx}/view/jcqnDoc/js/doc06.js"></script>
<script type="text/javascript" src="${ctx}/view/jcqnDoc/js/doc07.js"></script> --%>

<script type="text/javascript" src="${ctx}/view/kjljDoc/js/doc01.js"></script>
<script type="text/javascript" src="${ctx}/view/kjljDoc/js/doc02.js"></script>
<script type="text/javascript" src="${ctx}/view/kjljDoc/js/doc03.js"></script>
<script type="text/javascript" src="${ctx}/view/kjljDoc/js/doc04.js"></script>
<script type="text/javascript" src="${ctx}/view/kjljDoc/js/doc05.js"></script>
<%-- <script type="text/javascript" src="${ctx}/view/kjljDoc/js/doc06.js"></script>
<script type="text/javascript" src="${ctx}/view/kjljDoc/js/doc07.js"></script> --%>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<%@ include file="/common/jquery.noty.jsp"%>

</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<%@ include file="/common/bodyheader.jsp"%>
	<div class="navbar container-fluid">
		<div class="navbar-inner row-fluid">
			<div class="nav-collapse page-header" align="left">
				<span class="text-error" style="font-size: 20px; margin-left: 18px">
					<strong>申请类别：</strong>
				</span>
				<select id="apply_type" name="apply_type" style="width: 150px;" onchange="applyMenu()">
					<option value="杰出青年" ${type =='杰出青年' ?'selected':''}>杰出青年</option>
					<option value="科技领军" ${type =='科技领军' ?'selected':''}>科技领军</option>
					<option value="创新团队" ${type =='创新团队' ?'selected':''}>创新团队</option>
				</select>
				<input type="hidden" id="zhichengType"> 
				<span class="text-error isUSER" style="font-size: 20px; margin-left: 18px;">
					<strong>当前状态：</strong>
				</span>
				<span class="isUSER" style="font-size: 20px;" id="zhichengapply_status"> </span>
			</div>
			<div class="row-fluid" align="center">

				<div class="span2" style="float: left; text-align: left;">
					<div id="nav">
					<ul class="nav nav-list" id="orderedlist">
					<c:forEach items="${menus}" varStatus="i" var="applymenu" >  
                		<li id="${applymenu.menuid}"><a href="javascript:void(0)">${applymenu.menudetails}</a></li> 
            		</c:forEach>  
            		</ul>
					</div>
					<div class="control-group isUSER" align="left">
						<label class="text-error">初审意见：</label>
						<textarea  autoHeight="true" style="width: 95%; min-height: 50px; overflow:hidden;" id="zhichengapply_pre_approve_sug"></textarea>
					</div>
					<div class="control-group isUSER" align="left">
						<label class="text-error">终审意见：</label>
						<textarea autoHeight="true" style="width: 95%; min-height: 50px; overflow:hidden;" id="zhichengapply_finial_approve_sug"></textarea>
					</div>
					
					<div class="control-group isUSER" align="left">
						<label class="text-error">初审专家评分：</label>
						<!--  <textarea  autoHeight="true" style="width: 95%; min-height: 10px; overflow:hidden;" id="zhichengapply_expert1_score"></textarea>-->
						<input type="text" id="zhichengapply_expert1_score" style="text-align: center; font-size: 16.0pt; font-family: 仿宋; display: inline-block; height: 0%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
					</div>
					
					<div class="control-group isUSER" align="left">
						<label class="text-error">初审专家意见：</label>
						<textarea  autoHeight="true" style="width: 95%; min-height: 50px; overflow:hidden;" id="zhichengapply_expert1_sug"></textarea>
					</div>
					
						<div class="control-group isUSER" align="left">
						<label class="text-error">终审专家评分：</label>
						<!-- <textarea  autoHeight="true" style="width: 95%; min-height: 5px; overflow:hidden;" id="zhichengapply_expert2_score"></textarea> -->
						<input type="text" id="zhichengapply_expert2_score" style="text-align: center; font-size: 16.0pt; font-family: 仿宋; display: inline-block; height: 0%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
						
					</div>
					
					<div class="control-group isUSER" align="left">
						<label class="text-error">终审专家意见：</label>
						<textarea  autoHeight="true" style="width: 95%; min-height: 50px; overflow:hidden;" id="zhichengapply_expert2_sug"></textarea>
					</div>
					
					<div class="control-group isEXPERT1" align="left">
						<span class="text-error">审核变更：</span>
						<select id="zhichengapply_status_new" style="font-size: 14px">
							<option value="-1">请选择</option>
							<option value="终审中">初审通过</option>
							<option value="已通过" class="isEXPERT2">终审通过</option>
							<option value="未通过">审核不通过</option>
						</select>
					</div>

					<div class="control-group" align="center">
						<div class="controls">
							<!-- 							<a class='btn btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='PDFTemp()'><i class='icon-download'></i>导出PDF</a> -->
							<a class="btn btn-success" href="javascript:void(0)" onClick="zhichengApplyUpdate()"> 提交 </a>
							<button type="button" class="btn " onClick="javascript:history.back(-1);" style="margin-left: 10px">返回</button>
						</div>
					</div>
				</div>

				<div align="center" class="span9" style="margin-left: 20px; border: 1px solid #999; border-radius: 4px; padding: 3px;">
					<div style="height: 30px;; border-radius: 4px;" id="editSave">
						<a style="margin: 0 auto; float: right;" class="btn btn-small btn-info" href="javascript:void(0)" onClick="save()">
							<i class="icon-edit"></i>保存修改
						</a>
					</div>
					<div align="center" style="overflow-y: auto; border-radius: 4px; padding: 10px; max-height: 620px;">
						<div align="left" id="content" style="margin: 0 auto; height: 600px; padding: 3px;">
							<!--/row-->
						</div>
					</div>
				</div>
				<!--/span-->
			</div>
		</div>
		<!--/row-->
		<hr>

	</div>

	<!--/.fluid-container-->
	<input type="hidden" id="userId" value="${sessionScope.loginuser.id}" />
	<%@ include file="/common/footer.jsp"%>
</body>
</html>


