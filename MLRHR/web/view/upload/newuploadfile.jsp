<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
</head>

<body>
<div style="min-height:600px">
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 22.0pt; font-family: 幼圆; letter-spacing: 1.0pt'>附件</span>
			</b>
		</p>
 
	<!-- <p class=MsoNormal style='text-align: center'>
			
			<div>
			<b> <span style='font-size: 10.0pt; font-family: 幼圆; letter-spacing: 1.0pt'><font color=red >(只支持压缩文件上传,如*.zip;*.rar文件)(附件说明（杰出青年与科技领军：1，相关方向最具代表性论文（不超过10篇）、学术奖励（不超过5项）、承担科研项目（不超过5项）的证明材料；2，国际学术组织及重要学术期刊任职证明材料；创新团队：1. 团队成员（单位）之间的相关合作协议；2. 相关方向最具代表性论文（不超过10篇）、学术奖励（不超过5项）及其他成果材料；3. 依托项目的证明材料（关键页））3，材料为PDF或者Word格式并且打包为zip或者rar压缩格式上传；)</font></span>
			</b></div>
		</p> -->
		<div style="margin-top:10px">
			<button type="button" class="layui-btn" id="test2">
  						<i class="layui-icon">&#xe67c;</i>上传附件
			</button>
		</div>
	 <input id="newId" name="newId" type="hidden" value="${newId}" />
		 <!-- <div class="row-fluid" style="padding: 10px 0 5px 0px;" align="left"> 
			<div class="span8" style="width: 100%; margin-left: 10px;"> -->
				<table id="fileManager"
				class="table table-hover table-bordered table-striped MsoNormalTable">
					<thead valign="middle">
						<tr>
							<th style="text-align:center;">附件名称</th>
							<th style="text-align:center;">上传日期</th>
							<th style="text-align:center;">操作</th>
						</tr>
					</thead>
					<tbody id="fileList">
					</tbody>
				</table>
		<!-- 	</div>
		</div> -->
	</div>
	<hr>
</body>
<script type="text/javascript" src="${ctx}/view/upload/js/newuploadfile.js"></script>
<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css">
<script src="${ctx }/static/layui/layui.js"></script>
<script type="text/javascript">
var newId = $('#newId').val();
initnewUpFile()
layui.use('upload', function(){
	  var upload = layui.upload;
	  //执行实例
	  var uploadInst = upload.render({
	    elem: '#test2' //绑定元素
	    ,url: '${ctx}/newuploadFile' //上传接口
	    ,accept: 'file' //允许上传的文件类型,accept: 'file' //允许上传的文件类型
	    /* ,auto: false */
	    /* ,bindAction: '#test3' */
	  	/* ,exts:'zip|rar' */
	  	,data:{"newId":newId}
	    ,done: function(res){
	    	layer.msg(res.msg)
	    	initnewUpFile()
	      //上传完毕回调
	    }
	    ,error: function(){
	      //请求异常回调
	      layer.msg("请求异常")
	    }
	  });
	});
</script>
</html>
