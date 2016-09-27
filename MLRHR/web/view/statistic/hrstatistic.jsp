<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国土资源科技创新人才工程管理信息系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
</head>
<body>
	<div class="modal hide" id="myModal" style="width: 500px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3 id="myModalTitle">附件窗口</h3>
		</div>
		<div class="modal-body" style="min-height: 300px; max-height: 500px; padding-left: 0; padding-right: 0;"></div>
		<div class="modal-footer">
			<a id="myModalSave" class="btn btn-primary" style="margin-right: 5px" href='javascript:void(0)' onclick="" class='btn'>确定导出</a>
			<a href='javascript:void(0)' data-dismiss='modal' class='btn'>取消</a>
		</div>
	</div>

	<div class="container-fluid" style="padding: 0">
		<ul class="nav nav-tabs" id="myTab">
			<li id="nav1" class="active" onclick="setStatus(0)">
				<a href="javascript:void(0)">审核通过</a>
			</li>
			<li id="nav2" onclick="setStatus(1)">
				<a href="javascript:void(0)">审核未通过</a>
			</li>
			<li id="nav3" onclick="setStatus(2)">
				<a href="javascript:void(0)">待审核</a>
			</li>
			<li id="nav4" onclick="setStatus(3)">
				<a href="javascript:void(0)">终审中</a>
			</li>
		</ul>
		<div class="tab-pane active" id="jh">
			<form id="stat" class="form-inline" method="post" action="${ctx}/finance/jhstat">
				<div class="control-group">
					<div class="controls" style="text-align: left;">
						<label class="control-label" for="inputtitle">开始时间：</label>
						<input id="startdate_buy" class="input-small search-query" name="startdate" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" class="required" style="width: 75px;">
						<label class="control-label" for="inputtitle">结束时间：</label>
						<input id="enddate_buy" class="input-small search-query" name="enddate" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})" class="required" style="width: 75px;">
						<label class="control-label" for="inputtitle">申报级别：</label>
						<select id="apply_type" style="width: 100px">
							<option value="-1">全部</option>
							<option value="杰出青年">杰出青年</option>
							<option value="创新团队">创新团队</option>
							<option value="科技领军">科技领军</option>
						</select>
						<!--<label class="control-label" for="inputtitle">专业分组：</label>
						 <select id="apply_name" style="width: 110px">
							<option value="-1">全部</option>
							<option value="0">基础地质</option>
							<option value="1">矿产地质</option>
							<option value="2">水工环</option>
							<option value="3">技术方法</option>
						</select> -->
						<!-- 						<label class="control-label" for="inputtitle">专业级别：</label> -->
						<!-- 						<select id="apply_rank" style="width: 110px"> -->
						<!-- 							<option value="-1">全部</option> -->
						<!-- 							<option value="副高">副高</option> -->
						<!-- 							<option value="正高">正高</option> -->
						<!-- 						</select> -->
						<a class='btn btn-small btn-info' style='margin: 0 3px' href='javascript:void(0)' onClick='getData()'>
							<i class='icon-search'></i>统计
						</a>
						<a class='btn btn-small btn-info' style='margin-right: 5px' href='javascript:void(0)' onClick='showModel()'>
							<i class='icon-download'></i>导出报表
						</a>
					</div>
				</div>
				<div style="text-align: left">
					<span>提示：请先选择好统计参数（特别是</span>
					<span style="color: #FF8000;">"杰出青年/创新团队/科技领军人物"</span>
					<span>级别），再点击"统计"或者"导出报表"。</span>
				</div>
			</form>

			<ul class="thumbnails">
				<li class="span6">
					<div class="thumbnail">
						<div style="width: 100%; margin-bottom: 0px; margin-left: 0px; height: 300px;">
							<div class="caption" style="float: left; margin-left: 0px">
								<h3>申请级别统计</h3>
								<canvas id="pie" width="250" height="200"></canvas>
							</div>
							<div id="pieLegend" style="padding: 60px 20px; text-align: left; height: 100%; vertical-align: middle; font-size: 18px;">
								<div style="margin: 20px; line-height: 30px;">
									杰出青年
									<span id="arrData1" class="label label-success"> </span>
									人
								</div>
								<div style="margin: 20px; line-height: 30px;">
									创新团队
									<span id="arrData2" class="label label-warning"></span>
									人
								</div>
								<div style="margin: 20px; line-height: 30px;">
									科技领军
									<span id="arrData3" class="label label-info"></span>
									人
								</div>
							</div>
						</div>

					</div>
				</li>
				<!-- <li class="span6">
					<div class="thumbnail">
						<div style="width: 100%; margin-bottom: 0px; margin-left: 0px; height: 300px;">
							<div class="caption" style="float: left; margin-left: 0px">
								<h3>专业分组统计</h3>
								<canvas id="pie_2" width="250" height="200"></canvas>
							</div>
							<div id="pieLegend_2" style="padding: 60px 20px; text-align: left; height: 100%; vertical-align: middle; font-size: 18px;">
								<div style="margin: 20px; line-height: 30px;">
									基础地质
									<span id="arrData1_2" class="label label-success"> </span>
									人
								</div>
								<div style="margin: 20px; line-height: 30px;">
									矿产地质
									<span id="arrData2_2" class="label label-warning"></span>
									人
								</div>
								<div style="margin: 20px; line-height: 30px;">
									水工环
									<span id="arrData3_2" class="label label-warning"></span>
									人
								</div>
								<div style="margin: 20px; line-height: 30px;">
									技术方法
									<span id="arrData4_2" class="label label-warning"></span>
									人
								</div>
							</div>
						</div>

					</div>
				</li> -->
			</ul>
		</div>

	</div>
	<!--/.fluid-container-->
</body>
</html>
