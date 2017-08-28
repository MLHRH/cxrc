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
			<b> <span style='font-size: 22.0pt; font-family: 幼圆; letter-spacing: 1.0pt'>附件管理</span>
			</b>
		</p>
 
	<p class=MsoNormal style='text-align: center'>
			
			<div>
			<b> <span style='font-size: 10.0pt; font-family: 幼圆; letter-spacing: 1.0pt'><font color=red >(只支持压缩文件上传,如*.zip;*.rar文件)(附件说明：1，相关方向最具代表性论文（不超过10篇）、学术奖励（不超过5项）、承担科研项目（不超过5项）的证明材料；2，国际学术组织及重要学术期刊任职证明材料；3，材料以PDF格式；4，所有文件打包为压缩格式上传)</font></span>
			</b></div>
		</p>
		<div style="margin-top:10px">
			<button type="button" class="layui-btn" id="test1">
  						<i class="layui-icon">&#xe67c;</i>上传附件
			</button>
		</div>
	 <input id="applyid" name="applyid" type="hidden" value="" />
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
<script type="text/javascript">
initUpFile()
layui.use('upload', function(){
	  var upload = layui.upload;
	  //执行实例
	  var uploadInst = upload.render({
	    elem: '#test1' //绑定元素
	    ,url: '${ctx}/uploadFile' //上传接口
	    ,accept: 'file' //允许上传的文件类型,accept: 'file' //允许上传的文件类型
	  	,exts:'zip|rar'
	  	,data:{"applyId":$('#applyid').val(),"applyType":$('#apply_type').val()}
	    ,done: function(res){
	    	layer.msg(res.msg)
	    	initUpFile()
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
