<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.dataTables_filter, .dataTables_length {
	display: none;
}

.add {
	/*  	display: none; */
	
}

.br {
	/* 	display: none; */
	
}
</style>
<title>doc06</title>
</head>

<body bgcolor=white lang=ZH-CN style='text-justify-trim: punctuation'>
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
	<div class=WordSection1 style='layout-grid: 15.6pt'>

		<div class=MsoNormal align=left style='text-align: left'>
			<span style='font-size: 16.0pt; font-family: 仿宋'>
				附件
				<span lang=EN-US>4</span>
			</span>
		</div>

		<div class=MsoNormal align=center style='text-align: center; margin-bottom: 10px'>
			<b> <span style='font-size: 18.0pt; font-family: 宋体'>申报自然科学研究系列地质科学研究专业 </span>
			</b> <b> <span class="apply_jibie" style="font-size: 18.0pt; font-family: 宋体; text-decoration: underline"></span>
			</b> <b> <span style='font-size: 18.0pt; font-family: 宋体'> 级任职资格综合情况表</span>
			</b>
		</div>

		<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width="100%" style='width: 100.0%; border-collapse: collapse; border: none'>
			<tr style='height: 45px'>
				<td colspan=2 style='width: 11%; border: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>姓 名</span>
					</div>
				</td>
				<td colspan=2 style='width: 11%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="userName" style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td colspan=2 style='width: 11%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>性 别</span>
					</div>
				</td>
				<td colspan=2 style='width: 11%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div style="float: left; width: 100%;">
						<label class="radio" style="width: 20%; float: left;">
							<input type="radio" name="user_gender" value="男" checked />
							男
						</label>
						<label class="radio" style="width: 20%; float: left;">
							<input type="radio" name="user_gender" value="女" />
							女
						</label>
					</div>
				</td>
				<td colspan=2 style='width: 11%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>出生年月</span>
					</div>
				</td>
				<td colspan=3 style='width: 13.6%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_birthday" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td colspan=3 style='width: 13.6% border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>参加工作时间</span>
					</div>
				</td>
				<td colspan=3 style='border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_canjiashijian" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
			</tr>
			<tr style='height: 45px' readOnly="true">
				<td colspan=2 style='border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>最高学历</span>
					</div>
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="userStudy_xueli"
						style="text-align: center; font-size: 16.0pt; font-family: 仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" readOnly="true" />
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>学 制</span>
					</div>
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="userStudy_xuezhi"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" readOnly="true" />
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>毕业学校</span>
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="userStudy_xuexiao"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" readOnly="true" />
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>毕业时间</span>
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="userStudy_end_date" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" readOnly="true" />
				</td>
			</tr>
			<tr style='height: 45px'>
				<td colspan=2 style='border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>所学专业</span>
					</div>
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="userStudy_zhuanye"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>现从事专业</span>
					</div>
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_congshizhuanye"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>现任职资格</span>
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_renzhizige"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td colspan=3 rowspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>任职资格审批时间及单位</span>
					</div>
				</td>
				<td colspan=3 rowspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_shenpidanwei" style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
					<input type="text" id="user_shenpishijian" onfocus="WdatePicker({isShowWeek:true,dateFmt:'yyyy.MM.dd'})"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />

				</td>
			</tr>
			<tr style='height: 45px'>
				<td colspan=2 style='border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>行政职务</span>
					</div>
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_xingzhengzhiwu"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>外语成绩</span>
					</div>
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_yingyu" style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td colspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>计算机成绩</span>
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<input type="text" id="user_jisuanji"
						style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
			</tr>
			<tr style='height: 45px'>
				<td colspan=2 style='border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>任职期间历年考核情况</span>
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal>
						<span id="kaoheYear01" style='font-size: 14.0pt; font-family: 华文仿宋'></span>
						<input type="text" id="kaohe01"
							style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 40%; padding: 0px; margin: 3px 0px; border-radius: 0px" />
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal>
						<span id="kaoheYear02" style='font-size: 14.0pt; font-family: 华文仿宋'></span>
						<input type="text" id="kaohe02"
							style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 40%; padding: 0px; margin: 3px 0px; border-radius: 0px" />
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal>
						<span id="kaoheYear03" style='font-size: 14.0pt; font-family: 华文仿宋'></span>
						<input type="text" id="kaohe03"
							style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 40%; padding: 0px; margin: 3px 0px; border-radius: 0px" />
					</div>
				</td>
				<td colspan=4 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal>
						<span id="kaoheYear04" style='font-size: 14.0pt; font-family: 华文仿宋'></span>
						<input type="text" id="kaohe04"
							style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 40%; padding: 0px; margin: 3px 0px; border-radius: 0px" />
					</div>
				</td>
				<td colspan=4 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 45px'>
					<div class=MsoNormal>
						<span id="kaoheYear05" style='font-size: 14.0pt; font-family: 华文仿宋'></span>
						<input type="text" id="kaohe05"
							style="text-align: center; font-size: 14.0pt; font-family: 华文仿宋; display: inline-block; height: 90%; width: 40%; padding: 0px; margin: 3px 0px; border-radius: 0px" />
					</div>
				</td>
			</tr>

			<tr style='page-break-inside: avoid; height: 57.15pt'>
				<td colspan=1 style='width: 5.5%; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 57.15pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>学习培训经历</span>
					</div>
				</td>
				<td colspan=18 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 10pt 5.4pt 5.4pt 5.4pt; height: 57.15pt'>
					<%@ include file="/view/userBaseInfor/userPeixun.jsp"%>
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 66.55pt'>
				<td colspan=1 style='width: 5.5%; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 66.55pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>专业技术工作简历</span>
					</div>
				</td>
				<td colspan=17 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 5.4pt 5.4pt 5.4pt 5.4pt; height: 66.55pt'>
					<%@ include file="/view/userBaseInfor/userWork.jsp"%></td>
			</tr>
			<tr style='page-break-inside: avoid; height: 25.5pt'>
				<td colspan=1 style='width: 5.5%; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 25.5pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>任现职以来承担的项目</span>
					</div>
				</td>
				<td colspan=18 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 25.5pt'>
					<%@ include file="/view/userBaseInfor/userProject.jsp"%></td>
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 22.7pt'>
				<td colspan=1 rowspan=4 style='width: 5.5%; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>任现职资格以来取得的主要成果</span>
					</div>
				</td>
				<td rowspan=1 colspan=1 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>重要创新性或原创性研究成果</span>
					</div>
				</td>
				<td colspan=17 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<textarea style="display: inline-block; height: 90%; width: 99%; padding: 0px; margin: 3px; border-radius: 0px" id="chuangxin"></textarea>
				</td>

			</tr>
			<tr style='page-break-inside: avoid; height: 22.7pt'>
				<td rowspan=1 colspan=1 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>获奖 情况</span>
					</div>
				</td>
				<td colspan=17 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<%@ include file="/view/userBaseInfor/userAward.jsp"%>
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 22.7pt'>
				<td colspan=1 style='width: 5.5%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>论文专著</span>
					</div>
				</td>
				<td colspan=17 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 5.4pt; height: 22.7pt'>
					<%@ include file="/view/userBaseInfor/userChengguo.jsp"%>
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 22.7pt'>
				<td rowspan=1 colspan=1 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>专利</span>
					</div>
				</td>
				<td colspan=17 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 22.7pt'>
					<%@ include file="/view/userBaseInfor/userZhuanli.jsp"%>
				</td>
			</tr>

			<tr style='page-break-inside: avoid; line-height: 50px'>
				<td colspan=5 style='border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>符合职称申报条件中的</span>
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<label class="radio" style="display: inline-block; margin: 0 0 0 5px; padding-left: 10px" for="user_tiaojian_0">1.基本条件</label>
						<input type="checkbox" name="user_tiaojian" value="1" id="user_tiaojian_0" style="margin: 0" />
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<label class="radio" style="display: inline-block; margin: 0 0 0 5px; padding-left: 10px" for="user_tiaojian_1">2.学历与资历</label>
						<input type="checkbox" name="user_tiaojian" value="1" id="user_tiaojian_1" style="margin: 0" />
					</div>
				</td>
				<td colspan=3 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<label class="radio" style="display: inline-block; margin: 0 0 0 5px; padding-left: 10px" for="user_tiaojian_2">3.理论知识、经历与能力</label>
						<input type="checkbox" name="user_tiaojian" value="1" id="user_tiaojian_2" style="margin: 0" />
					</div>
				</td>
				<td colspan=5 style='vertical-align: middle; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style=''>4.学术成果</span>
						<span style=''>(</span>
						<span>
							<label class="radio" style="display: inline-block; margin: 0 0 0 2px; padding-left: 10px" for="user_tiaojian4_1">①</label>
							<input type="radio" name="user_tiaojian4" value="1" id="user_tiaojian4_1" style="margin: 0" checked="checked" />
							<label class="radio" style="display: inline-block; margin: 0 0 0 2px; padding-left: 10px" for="user_tiaojian4_2">②</label>
							<input type="radio" name="user_tiaojian4" value="2" id="user_tiaojian4_2" style="margin: 0" />
							<label class="radio" style="display: inline-block; margin: 0 0 0 2px; padding-left: 10px" for="user_tiaojian4_3">③</label>
							<input type="radio" name="user_tiaojian4" value="3" id="user_tiaojian4_3" style="margin: 0" />
							<label class="radio" style="display: inline-block; margin: 0 0 0 2px; padding-left: 10px" for="user_tiaojian4_4">④</label>
							<input type="radio" name="user_tiaojian4" value="4" id="user_tiaojian4_4" style="margin: 0" />
						</span>
						<span style=''>)</span>
					</div>
				</td>
			</tr>

			<tr style='page-break-inside: avoid; line-height: 40px'>
				<td colspan=1 rowspan=2 style='border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>单位呈报意见</span>
					</div>
				</td>
				<td colspan=4 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>是否破格</span>
					</div>
				</td>
				<td colspan=5 valign=top
					style='vertical-align: middle; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'></div>
				</td>
				<td colspan=4 rowspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>单位审核意见</span>
					</div>
				</td>
				<td colspan=5 rowspan=2 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal align=center style='text-align: center'></div>
					<div class=MsoNormal align=center style='text-align: center'>
						<p style=""></p>
						<span lang=EN-US style='font-size: 14.0pt; font-family: 华文仿宋'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>单位签章</span>
					</div>
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 43.7pt; line-height: 40px'>
				<td colspan=9 style='border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 43.7pt'>
					<div class=MsoNormal style=""></div>
					<div class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 14.0pt; font-family: 华文仿宋'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
						<span style='font-size: 14.0pt; font-family: 华文仿宋'>人事（职改）部门签章</span>
					</div>
				</td>
			</tr>
		</table>
		<div class=MsoNormal align=left style='text-align: left; line-height: 20.0pt'>
			<span style='font-size: 14.0pt; font-family: 华文仿宋'> 注：1.任现职以来公开发表的论文、专著、报告等代表作：研究员限10篇、副研限6篇、破格申报正研限12篇、副研8篇；2.刊物级别指：国际核心SCI（EI）收录、SCI（EI）收录、中文核心期刊；3.报告级别指：基金项目、国家项目、省部项目、地调项目、横向项目。 </span>
		</div>

		<div class=MsoNormal align=center style='text-align: center; line-height: 20.0pt'>
			<b> <span style='font-size: 14.0pt; font-family: 华文仿宋'>
					（不得改变表格格式，用
					<span lang=EN-US>A3</span>
					纸打印）
				</span>
			</b>
		</div>
	</div>

</body>

</html>