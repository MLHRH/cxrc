<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附件上传</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="iugs">
<meta name="author" content="iugs">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/jquery.fileupload-ui.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
</head>

<body>
	<div class="row-fluid" style="padding: 10px 0 5px 0px;" align="left">
		<form id="fileupload" action="UploadServlet" method="POST" enctype="multipart/form-data">
			<!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
			<div class="row fileupload-buttonbar" style="margin-left: 10px;">
				<div class="span7" style="width: 70%;">
					<!-- The fileinput-button span is used to style the file input field as button -->
					<span class="btn btn-success fileinput-button"> <i class="icon-plus icon-white"></i> <span>选择文件</span> <input type="file" name="files[]" multiple>
					</span>
					<button type="submit" class="btn btn-primary start">
						<i class="icon-upload icon-white"></i> <span>开始上传</span>
					</button>
					<button type="reset" class="btn btn-warning cancel">
						<i class="icon-ban-circle icon-white"></i> <span>取消全部</span>
					</button>
					<button type="button" class="btn btn-danger delete">
						<i class="icon-trash icon-white"></i> <span>删除选中文件</span>
					</button>
					<input type="checkbox" class="toggle">
				</div>
				<!-- The global progress information -->
				<div class="span5 fileupload-progress fade" style="width: 25%;">
					<!-- The global progress bar -->
					<div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
						<div class="bar" style="width: 0%;"></div>
					</div>
					<!-- The extended global progress information -->
					<div class="progress-extended">&nbsp;</div>
				</div>
			</div>
			<!-- The loading indicator is shown during file processing -->
			<div class="fileupload-loading"></div>
			<!-- The table listing the files available for upload/download -->
			<div class="span8" style="width: 100%; margin-left: 10px;">
				<table id="fileManager" class="table table-hover table-bordered table-striped">
					<thead>
						<tr>
							<th>附件名称</th>
							<th>附件大小</th>
							<th>上传日期</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="files" data-toggle="modal-gallery" data-target="#modal-gallery">
					</tbody>
				</table>
			</div>
		</form>
	</div>
	<hr>
	<div class="well">提示：你可以拖拽文件至上方区域.</div>
</body>
<script type="text/javascript">
function doUpload() {  
    var formData = new FormData($( "#uploadForm" )[0]);  
    $.ajax({  
         url: 'UploadFile' ,  
         type: 'POST',  
         data: formData,  
         async: false,  
         cache: false,  
         contentType: false,  
         processData: false,  
         success: function (data) {  
             alert(data.msg);  
         },  
         error: function (returndata) {  
             alert("连接服务器失败");  
         }  
    });  
}  
</script>
</html>
