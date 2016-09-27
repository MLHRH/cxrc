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
				<table role="presentation" class="table table-hover table-bordered table-striped">
					<thead>
						<tr>
							<th width="60%">附件名称</th>
							<th width="80px">附件大小</th>
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

	<script id="template-upload" type="text/x-tmpl">
            {% for (var i=0, file; file=o.files[i]; i++) { 

 %}
        <tr class="template-upload fade">
            <td class="name"><span>{%=file.name%}</span>
 				<div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
			</td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            {% if (file.error) { %}
            <td class="error"><span class="label label-important">Error</span> {%=file.error%}</td>
            {% } else if (o.files.valid && !i) { %}
            <td class="start">{% if (!o.options.autoUpload) { %}
              <button class="btn btn-primary">
                    <i class="icon-upload icon-white"></i>
                    <span>开始</span>
                </button>
                {% } %}</td>
            {% } else { %}
            {% } %}
            <td class="cancel">{% if (!i) { %}
                <button class="btn btn-warning">
                    <i class="icon-ban-circle icon-white"></i>
                    <span>取消</span>
                </button>
                {% } %}</td>
        </tr>
        {% } %}
    </script>
	<!-- The template to display files available for download -->
	<script id="template-download" type="text/x-tmpl">
        {%
 for (var i=0, file; file=o.files[i]; i++) { %}
        <tr class="template-download fade">
            {% if (file.error) { %}
            <td class="name"><span>{%=file.name%}</span></td>
            <td class="error" ><span class="label label-important">Error</span> {%=file.error%}</td>
            {% } else { %}
            <td class="name">
                <a target="_blank" href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}">{%=file.name%}</a>
            </td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            {% } %}
            <td class="delete"  colspan="2">
               <button class="btn btn-danger" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}"{% if (file.delete_with_credentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                        <i class="icon-trash icon-white"></i>
                    <span>删除</span>
                </button>
    			<input type="checkbox" name="delete" value="1">
            </td>
        </tr>
        {% } %}
    </script>

	<script src="js/vendor/jquery.ui.widget.js"></script>
	<script src="js/tmpl.min.js"></script>
	<script src="js/load-image.min.js"></script>
	<script src="js/canvas-to-blob.min.js"></script>
	<script src="js/bootstrap-image-gallery.min.js"></script>
	<script src="js/jquery.iframe-transport.js"></script>
	<script src="js/jquery.fileupload.js"></script>
	<script src="js/jquery.fileupload-fp.js"></script>
	<script src="js/jquery.fileupload-ui.js"></script>
	<script src="js/locale.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
