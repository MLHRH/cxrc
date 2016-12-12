<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<style type="text/css">
.table td{
    vertical-align: middle;
}
.table thead th {
    vertical-align: middle;
}
</style>
<body>
	<form id="userBaogaoForm" class="form-horizontal"
		style="margin: 0 0 0 0"></form>
<!-- 	<div style="text-align: left;" class="add">
		<a id="userBaogaoAddButton" class="btn btn-small btn-info" href="javascript:void(0)"
			onClick="userBaogaoEdit()">
			<i class="icon-plus-sign"></i>添加
		</a>
		<span>（注：此处仅填写"</span>
		<span style="color: #FF8000;">重要报告</span>
		<span>",在重要国际学术会议报告情况 </span>
	</div> -->
	<div class="xline" style="height: 5px"></div>
	<table id="expertScore"
		class="table table-hover table-bordered table-striped" style="margin-bottom: 10px;">
		<thead valign="middle">
			<tr>
				<th width="16%"  style="text-align:center;">专家姓名</th>
				<th width="16%"  style="text-align:center;">专家评分</th>
			</tr>
		</thead>
	</table>
		<div class="control-group" align="center">
						<div class="controls">
							<!-- <a class='btn btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='PDFTemp()'><i class='icon-download'></i>导出PDF</a> -->
							<button type="button" class="btn " onClick="javascript:history.back(-1);" style="margin-left: 10px">返回</button>
						</div>
					</div>
				
</body>
</html>
