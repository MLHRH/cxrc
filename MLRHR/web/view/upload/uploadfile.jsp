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
<link rel="stylesheet" href="static/uploadify/3.1/css/uploadify.css">
<style>
		.icon-cancel{
			background:url('img/cancel.png') no-repeat center center;
		}
	</style>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
</head>

<body>
	<div class="container-fluid" style="margin-top: 10px;margin-left:5px; margin-bottom: 10px;">
		<table>
			<tr>
				<td style="padding: 2px 10px 2px 10px;" >
					<a class="btn btn-primary btn-sm" id="importBtn" href="javascript:void(0)" >
						<span class="glyphicon glyphicon-import" aria-hidden="true"></span>上传文件
					</a>
				</td>
			</tr>
		</table>
	 </div>
	<div class="row-fluid" style="padding: 10px 0 5px 0px;" align="left">
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
	</div>
	<div class="container">
    	<div class="row">
    		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		        <div class="modal-dialog" role="document">
		            <div class="modal-content">
		                <div class="modal-header" style="height:50px;">
		                    <h4 style="width:150px;float:left;" class="modal-title" id="exampleModalLabel">产品导入</h4>
							<div style="float: right;margin-left: 10px;"><a href="${ctx }/static/model/excel-model.xlsx">下载模版样例</a></div>
		                </div>
		                <div class="modal-body">
		               	 
		                	<form>
								<div id="queueID"></div>
								<input id="file_upload" name="file_upload" type="file" multiple="true">
								
							</form>
							<form id="importform">
								<input id="filename" name="filename" type="hidden" value="" />
								<input id="oldfilename" name="oldfilename" type="hidden" value="" />
								<div id="result">
								</div>
							</form>
	                    	
        					<div style="text-align: center;">
        						<label class="control-label" id="impsuccess"></label>
        					</div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                    <button type="button" class="btn btn-primary" id="import">导入</button>
		                </div>
		            </div>
		        </div>
		    </div>
    	</div>
    </div>
	<hr>
</body>
<script src="static/jquery/1.8.3/jquery.min.js"></script>
<script src="static/layer/layer.js"></script>
<script src="static/uploadify/3.1/js/jquery.uploadify.min.js"></script>
<script src="static/uploadify/3.1/js/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${ctx}/view/upload/js/uploadfile.js"></script>
<script type="text/javascript">
//导入按钮
$("#importBtn").on("click",function(){
	$("#filename").val("");
    $("#oldfilename").val("");
    $("#result").empty();
    $('#exampleModal').modal({
        show: true
    });
 });
$("#file_upload").uploadify({
    'swf'      : '${ctx}/static/uploadify/3.1/js/uploadify.swf',
    'uploader' : '${ctx}/uploadFile',
    'queueID ' : 'queueID',
    'cancelImg': '${ctx}/static/uploadify/3.1/img/uploadify-cancel.png',
    'auto'     : true,
    'multi'    : false,
    'fileTypeDesc' : '.zip|.rar',
    'fileTypeExts'  : '*.zip;*.rar',
    'buttonText': '请选择上传文件',
    'onUploadError': errorCallback,
    'onUploadSuccess': function(file, data, response) {
        $('#' + file.id).find('.data').html('上传完毕!');
        if(response == true) {
        	showInfo(file, data);
	    }
    }
});
//显示提示信息，textstyle2为绿色，即正确信息；textstyl1为红色，即错误信息
function showInfo(file, data) {
    var res = JSON.parse(data);
    $('#impsuccess').html("");
    $("#filename").val(res.NEW);
    $("#oldfilename").val(res.OLD);
    $("#result").empty();
    var msg = '<div id="div_' + file.id + '" style="height:30px;">' +
        '<span style="font-size:16px; height:26px;">' +
            '<a target="_blank" href="javascript:void(0);" style="text-decoration:underline;color:black;">' + res.OLD + '</a>&nbsp;&nbsp;' +
            '<a href="javascript:void(0);" onclick="delAttach(this)" id="del_' + file.id +
                '" class="icon-cancel" style="width:30px;">&nbsp;&nbsp;&nbsp;&nbsp;</a>' +
        '</span>' +
    '</div>';
    $("#result").append(msg);
}

function delAttach(obj) {
    $('#' + $(obj).attr("id").replace("del", "div")).remove();
      $("#filename").val("");
      $("#oldfilename").val("");
}
</script>
</html>
