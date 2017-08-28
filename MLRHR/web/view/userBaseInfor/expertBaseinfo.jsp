<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
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

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
	
}
</style>

<script type="text/javascript" src="${ctx}/view/userBaseInfor/js/expertUserBase.js"></script>

<%@ include file="/common/jquery.noty.jsp"%>
</head>
<body>
<%@ include file="/common/bodyheader.jsp"%>
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
	<div class="container-fluid">
		<div class="page-header">
			<h2>我的档案</h2>
		</div>
		
		
		
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

		<form id="detail_base" class="form-horizontal" style="margin: 0 0 0 0">
		<div class="control-group" align="left">
			<input type="hidden" id="user_id" name="id" value="${user.id}" />
			<table id="people" border="0" cellpadding="2" cellspacing="1" align="center" style="margin-top: 8px; margin-left: 0px;">
				<tr align="left" style="margin-left: 20px">
					<td style="width: 130px">姓名：</td>
					<td>
						<input type="text" id="user_name" style="width: 200px" value="${user.name}" readOnly />
					</td>
					<td style="width: 150px; padding-left: 50px">性别：</td>
					<td>
                        <input type="text" id="user_sex" style="width: 200px"  />
                   </td>
				</tr>
				<tr align="left">
					<td style="width: 150px">民族：</td>
					<td>
						<input type="text" id="user_minzu" style="width: 200px"/>
					</td>
					<td style="width: 130px; padding-left: 50px">身份证：</td>
					<td>
						<input type="text" id="user_id_num" style="width: 200px" value="${user.id_num}" readOnly />
					</td>
				</tr>
				<tr align="left">
					
					<td style="width: 150px">出生日期：</td>
					<td>
						<input type="text" id="user_birthday" style="width: 200px" />
					</td>
					<td style="width: 150px; padding-left: 50px">电子邮箱：</td>
					<td>
						<input type="text" id="user_email" style="width: 200px" value="${user.email}"/>
					</td>
				</tr>
				
				
				
				<tr class="xline">
					<td colspan=4 style="width: 100%; border-bottom: 1px dashed #b3b3b3; height: 10px;"></td>
				</tr>
				<tr style="height: 10px"></tr>
				<tr align="left">
					<td style="width: 130px;">通讯地址：</td>
					<td>
						<input type="text" id="user_address" />
					</td>
					<td style="width: 150px; padding-left: 50px">所在单位：</td>
					<td>
						<select name="user_body_id_select" id="user_body_id_select" class="input-block-level" >
							<c:forEach var="body" items="${bodyList}">
								<option value=${body.id } id="user_body_id" <c:if test="${body.id==user.body_id}">selected="true"</c:if>>${body.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">现任专业技术职务：</td>
					<td>
						<input type="text" id="user_current_zhicheng" style="width: 200px" />
					</td>
				<td style="width: 130px">现（兼）行政职务：</td>
					<td>
						<input type="text" id="user_xingzhengzhiwu" style="width: 200px"  />
					</td>
				</tr>
				<tr align="left">
					<td style="width: 130px">现从事专业：</td>
					<td>
						<input type="text" id="user_congshizhuanye" style="width: 200px"  />
					</td>
					<td style="width: 150px; padding-left: 50px">是否是京内：</td>
					<td>
						<input type="text" id="within_beijing" style="width: 200px" />
					</td>
				</tr>
				
				<tr class="xline">
					<td colspan=4 style="width: 100%; border-bottom: 1px dashed #b3b3b3; height: 10px;"></td>
				</tr>
				<tr style="height: 10px"></tr>
			</table>

			<div class="control-group">
				<div class="controls" style="margin-left: 295px">
					<button type="button" class="btn btn-primary" id="save_btn">保存</button>
					<button type="button" class="btn btn-default " onClick="javascript:history.back(-1);" >返回</button>
				</div>
			</div>
		</div>

		<!-- <div class="span9" style="margin-left: 20px; padding: 3px;">
		<div class="row-fluid" id="content"></div>
				
		</div>
		</div> -->
		<input type="hidden" id="userId" value="${sessionScope.loginuser.id}" />
		<%@ include file="/common/footer.jsp"%>
	</div>
	<!--/.fluid-container-->
</body>
<script>
$('#save_btn').bind("click",function(){
	arrData = {};
	arrData.birthday = $('#user_birthday').val();
	arrData.gender = $('#user_sex').val();
	arrData.minzu = $('#user_minzu').val();
	arrData.congshizhuanye = $('#user_congshizhuanye').val();
	arrData.zhicheng = $('#user_current_zhicheng').val();
	arrData.xingzhengzhiwu = $('#user_xingzhengzhiwu').val();
	arrData.within_beijing = $('#within_beijing').val();
	arrData.address = $('#user_address').val();
	arrData.group_id = group_id;
	var baseInfo = JSON.stringify(arrData);user_body_id_select
	var body = $('#user_body_id_select').val();
	$.ajax({
		dataType : 'json',
		type : "POST",
		url : "baseEdit",
		async:true,
		data : {"data":baseInfo,
			   "email":$('#user_email').val(),
			   "body":body
		   },
		success : function(rst) {
			alert("保存成功");
			console.log(rst)
			initExpertBase();
		},
		error:function(rst){
			alert('保存失败');
			console.log(rst)
			initExpertBase();
		}
	});
})
</script>
</html>
