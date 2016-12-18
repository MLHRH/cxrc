<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附件上传</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="iugs">
<meta name="author" content="iugs">
<%@ include file="/common/common.jsp"%>
<%@ include file="/common/jquery.noty.jsp"%>
<link href="${ctx}/static/styles/jquery.dataTables.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/static/jquery/DataTables-1.10.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/jquery.dataTables.columnFilter.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/openWindow.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/notify.function.js"></script>
<script type="text/javascript" src="${ctx}/view/upload/js/uploadfile.js"></script>
<link rel="stylesheet" href="${ctx }/static/uploadify/3.1/css/uploadify.css">
<script src="${ctx}/static/layer/layer.js"></script>
<script src="${ctx}/static/uploadify/3.1/js/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${ctx}/js/Chart.js"></script>
<style>
		.icon-cancel{
			background:url('img/cancel.png') no-repeat center center;
		}
	</style>
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
</head>

<body>
	<div class="container-fluid" style="margin-top: 10px;margin-left:5px; margin-bottom: 10px;">
	<p class=MsoNormal style='text-align: center'>
			
			<div>
			<b> <span style='font-size: 10.0pt; font-family: 幼圆; letter-spacing: 1.0pt'><font color=red >(只支持压缩文件上传,如*.zip;*.rar文件)</font></span>
			</b></div>
		</p>
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
				<table id="fileManager"
				class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
					<thead valign="middle">
						<tr>
							<th style="text-align:center;">附件名称</th>
							<th style="text-align:center;">上传日期</th>
							<th style="text-align:center;">操作</th>
						</tr>
					</thead>
				</table>
			</div>
	</div>
	<div class="container">
    	<div class="row">
    		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header" style="height:50px;">
		                    <h4 style="width:150px;float:left;" class="modal-title" id="exampleModalLabel">附件上传</h4>
		                </div>
		                <div class="modal-body">
		               	 
		                	<form>
								<div id="queueID"></div>
								<input id="file_upload" name="file_upload" type="file" multiple="true">
								
							</form>
							<form id="importform">
								<input id="filename" name="filename" type="hidden" value="" />
								<input id="oldfilename" name="oldfilename" type="hidden" value="" />
								<input id="path" name="path" type="hidden" value="" />
								<input id="applyid" name="applyid" type="hidden" value="" />
								<div id="result">
								</div>
							</form>
	                    	
        					<div style="text-align: center;">
        						<label class="control-label" id="impsuccess"></label>
        					</div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                    <button type="button" class="btn btn-primary" id="import">上传</button>
		                </div>
		            </div>
		        </div>
		    </div>
    	</div>
    </div>
	<hr>
</body>
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
$('#exampleModal').on('hidden.bs.modal', function () {
	initUpFile();
	});
$('#import').click(function(){
	if($("#filename").val()==''){
		alert("没有选择文件，请选择后再导入");
		return false;
	}
 	var index = layer.load(1, {
		shade: [0.5,'#0099FF'] //0.5透明度的黑色背景
	}); 
	$.ajax({
		cache: false,
        type: "POST",
        url: "${ctx}/importFile",
        data:$('#importform').serialize(),// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
            layer.close(index);
        },
        success: function(data) {
            $('#impsuccess').html(data.msg);
            $("#filename").val("");
            $("#oldfilename").val("");
            $("#path").val("");
            $("#result").empty();
            layer.close(index);
            initUpFile();
        }
    })   
});
$("#file_upload").uploadify({
    'swf'      : '${ctx}/static/uploadify/3.1/js/uploadify.swf',
    'uploader' : '${ctx}/uploadFile',
    'queueID ' : 'queueID',
    'cancelImg': '${ctx}/static/uploadify/3.1/img/uploadify-cancel.png',
    'auto'     : true,
    'multi'    : true,
    'fileTypeDesc' : '.zip|.rar',
    'fileTypeExts'  : '*.zip;*.rar',
    'buttonText': '请选择上传文件',
    'onUploadError': errorCallback,
    'onUploadSuccess': function(file, data, response) {
        $('#' + file.id).find('.data').html('导入完毕!');
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
    $("#path").val(res.PATH);
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
      $("#path").val("");
}
function errorCallback(event, queueId, fileObj, errorObj) {

}
</script>
</html>
