<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<body lang=ZH-CN style='text-justify-trim: punctuation'>
	<div class="modal hide" id="modalDoc02" style="width: 794px;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3 id="modalDoc02Title">附件窗口</h3>
		</div>
		<div id="modalDoc02BodyId" class="modal-body" style="min-height: 300px; max-height: 500px;"></div>
		<div class="modal-footer">
			<a href="javascript:void(0)" data-dismiss="modal" class="btn">关闭</a>
		</div>
	</div>

	<div align=center style='text-align: center; height: 56px'>
		<b style='vertical-align: middle; margin: 0 auto;'><span style='font-size: 18.0pt; font-family: 仿宋'>证明证书材料复印件</span></b>
		<a style='vertical-align: middle; margin-left:5px; float: right;' class="btn  btn-info" href="javascript:void(0)" onClick="downLoadFile_02()">
			<i class="icon-download"></i>下载
		</a>
		<a style='vertical-align: middle; margin: 0 auto; float: right;' class="btn  btn-info" href="javascript:void(0)" onClick="checkFile()">
			<i class="icon-picture"></i>预览
		</a>
		
	</div>

	<div align=center>

		<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 style='border-collapse: collapse; border: none'>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 16.0pt; font-family: 仿宋'>序号</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 16.0pt; font-family: 仿宋'>材料名称</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 16.0pt; font-family: 仿宋'>份数</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 16.0pt; font-family: 仿宋'>备注</span>
					</p>
				</td>
				<td width=67 style='width: 80.55pt; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 16.0pt; font-family: 仿宋'>附件管理</span>
					</p>
				</td>
			</tr>
			<tr style='height: 34.0pt'>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>1</span>
					</p>
				</td>
				<td width=383
					style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>毕业证书、学位证书</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span id='ft01' lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(1)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>2</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>任职资格证书</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span id='ft02' lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(2)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>3</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>外语考试合格证或免试证明</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span id='ft03' lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(3)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>4</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>计算机考试合格证书或免试证明</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span id='ft04' lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(4)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>5</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>成果、业绩获奖证书证明</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span id='ft05' lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(5)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>6</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>项目合同书</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span id='ft06' lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(6)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>7</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>论文检索证明</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span id='ft07' lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(7)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>8</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal>
						<span style='font-size: 16.0pt; font-family: 仿宋'>其他证明证书</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span id='ft08' lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'>
							<a class="btn btn-small btn-info" href="javascript:void(0)" onClick="uploadFile(8)">
								<i class="icon-upload"></i>管理
							</a>
						</span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal style='line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'></span>
					</p>
				</td>
			</tr>
			<tr>
				<td width=49 style='width: 36.9pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=383 style='width: 287.45pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal style='line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.5pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<p class=MsoNormal align=center style='text-align: center; line-height: 150%'>
						<span lang=EN-US style='font-size: 16.0pt; line-height: 150%; font-family: 仿宋'>&nbsp;</span>
					</p>
				</td>
				<td width=67 style='width: 50.55pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 34.0pt'>
					<p class=MsoNormal align=center style='text-align: center'>
						<span lang=EN-US style='font-size: 16.0pt; font-family: 仿宋'></span>
					</p>
				</td>
			</tr>
		</table>

	</div>

</body>

</html>
