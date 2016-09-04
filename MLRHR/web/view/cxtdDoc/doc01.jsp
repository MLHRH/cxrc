<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>doc01</title>
</head>
	<style>
	  .x{
  			border-left:none;
   	  		border-right:none;
 			 border-top:none;
   			 border-bottom:1px solid #0F2543;
  		}
  </style>
<body>
		<p class=MsoNormal align=left style='text-align: left'>
			<span style='font-size: 14.0pt; font-family: 宋体'>附件<span lang=EN-US>1</span></span>
		</p> 
		<p class=MsoNormal style='text-align: center'>
			<b> <span style='font-size: 22.0pt; font-family: 幼圆; letter-spacing: 1.0pt'>基本信息</span>
			</b>
		</p>
		<input type = "hidden" id="baseinfoid">

		<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width=631 style='width: 100%; border-collapse: collapse; border: none'>
			<tr style='page-break-inside: avoid; height: 30pt'>

				<td width=100 colspan=2 valign="middle" style='width: 150pt; border: solid windowtext 1.0pt;  padding: 0cm 5.4pt 0cm 5.4pt; height: 40.8pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'> 团队名称 </span>
					</div>
				</td>
				<td width=1162 colspan=10 valign="middle" style='width: 500pt; border: solid windowtext 1.0pt;  padding: 0cm 5.4pt 0cm 5.4pt; height: 40.8pt'>
					<input type="text" id="teamName" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 30pt'>

				<td width=100 colspan=2 valign="middle" style='width: 150pt; border: solid windowtext 1.0pt;  padding: 0cm 5.4pt 0cm 5.4pt; height: 40.8pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'> 研究方向 </span>
					</div>
				</td>
				<td width=1162 colspan=10 valign="middle" style='width: 500pt; border: solid windowtext 1.0pt;  padding: 0cm 5.4pt 0cm 5.4pt; height: 40.8pt'>
					<input type="text" id="sub_dir" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 30pt;'>
				<td width=99 colspan=2 style='width: 97.55pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 39.05pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>所属学科1</span>
					</div>
				</td>
				<td width=99 colspan=2 valign="middle" style='width: 134.65pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 39.05pt'>
					<input type="text" id="sub_1" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=2 style='width: 97.55pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 39.05pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>所属学科2</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 6.0cm; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 37.7pt'>
					<input type="text" id="sub_2" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>

			</tr>

			<tr style='page-break-inside: avoid; height: 100pt'>
				<td width=50 rowspan=2 colspan=1 valign="middle" style='width: 26.7pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>项目依托</span>
					</div>
				</td>
				<td width=50 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>类 &nbsp;&nbsp;别</span>
					</div>
				</td>
				<td colspan=10 valign="center" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style="margin-top: 20px;">
						<span style='font-size: 14.0pt; font-family: 宋体'><label><input type="checkbox" id="imp_science" value="">重大科研项目</label></span>
					</div>
					<div class=MsoNormal style="margin-top: 20px;">
						<span style='font-size: 14.0pt; font-family: 宋体'><label><input type="checkbox" id="imp_project" value="">重点工程项目</label></span>
					</div>
					<div class=MsoNormal style="margin-top: 20px;">
						<span style='font-size: 14.0pt; font-family: 宋体'><label><input type="checkbox" id="orther_type" value="">其他<label></span>
						<span style='font-size: 14.0pt; font-family: 宋体'><input type="text" id="orther" value=""class="x"></span>
					</div>
				</td>
			</tr>
			<tr style='page-break-inside: avoid; height: 30pt'>
				<td width=99 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>名 &nbsp;&nbsp;称</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="project_name" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=1 valign="middle" style='width: 2.0cm; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>来&nbsp;&nbsp;源</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="project_from" style="font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
			</tr>

			<tr style='page-break-inside: avoid； height: 100pt'>
				<td width=36 rowspan=5 valign="middle" style='width: 26.7pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt;height: 60pt;'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>依托单位</span>
					</div>
				</td>
				<td width=50 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>单位名称</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="unit_name" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=1 valign="middle" style='width: 2.0cm; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>组织机构代码</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="org_code" style="font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>

			</tr>
			<tr style='page-break-inside: avoid; height: 30pt'>
				<td width=99 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>法定代表人</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="legal_rep" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=1 valign="middle" style='width: 2.0cm; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>主管部门</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="competent_dep" style="font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
			</tr>

			<tr style='page-break-inside: avoid; height: 30pt'>
				<td width=99 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>单位地址</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="unit_add" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=1 valign="middle" style='width: 2.0cm; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>邮  编</span>
					</div>
				</td>
				<td width=99 colspan=4 valign="middle" style='width: 99.25pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="zip_code" style="font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
			</tr>

			<tr style='page-break-inside: avoid;'>
				<td width=99 colspan=1 rowspan=2 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>联系人</span>
					</div>
				</td>
				<td width=99 colspan=1 rowspan=2 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<input type="text" id="contacts" style="font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>手  机</span>
					</div>
				</td>
				<td width=99 colspan=2 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="mobile_phone" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>传  真</span>
					</div>
				</td>
				<td width=99 colspan=2 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="fax" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				
			</tr>
			<tr style='page-break-inside: avoid;'>
				<td width=99 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>Email</span>
					</div>
				</td>
				<td width=99 colspan=2 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="t_email" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				<td width=99 colspan=1 valign="middle" style='width: 99.2pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>电  话</span>
					</div>
				</td>
				<td width=99 colspan=2 valign="middle" style='width: 106.3pt; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 38pt'>
					<input type="text" id="telephone" style=" font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" />
				</td>
				
			</tr>

		</table>
		<p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 14.0pt'>&nbsp;</span>
		</p>
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>


		<p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 14.0pt'>&nbsp;</span>
		</p>

		<p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 14.0pt'>&nbsp;</span>
		</p>
		<p class=MsoNormal align=center style='text-align: center'>
			<span style='font-size: 22.0pt; font-family: 黑体'>团队负责人信息</span>
		</p>

		<p class=MsoNormal align=center style='text-align: center'>
			<b><span lang=EN-US style='font-size: 22.0pt;'>&nbsp;</span></b>
		</p>
		<!--团队负责人信息  -->
		<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 style='border-collapse: collapse'>
				
				<tr class="form-group form-group-lg">
					<td width=70 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>姓名
							</span>
						</div>
					</td>
					<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderName"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>性别 
							</span>
						</div>	
					</td>
						<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderSex"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
						<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>国籍 
							</span>
						</div>	
					</td>
						<td width=84 colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderCountry"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
				</tr>
				<tr class="form-group form-group-lg">
					<td width=70 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>名族
							</span>
						</div>
					</td>
					<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderNation"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>专业技术职务 
							</span>
						</div>	
					</td>
						<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderTechnical_position"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
						<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>出生日期 
							</span>
						</div>	
					</td>
						<td width=84 colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderBirthday"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
				</tr>
				<tr class="form-group form-group-lg">
					<td width=70 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>证件类型
							</span>
						</div>
					</td>
					<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderId_type"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>证件号码
							</span>
						</div>	
					</td>
						<td  width=487 colspan=4 valign=top
						style='width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 30pt'>
						<input type="text" id="leaderId_num"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					
				</tr><tr class="form-group form-group-lg">
					<td width=70 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>现从事专业或方向
							</span>
						</div>
					</td>
					<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderProfessional_direction"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>所属学科1 
							</span>
						</div>	
					</td>
						<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderSubject1"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
						<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>所属学科2 
							</span>
						</div>	
					</td>
						<td width=84 colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderSubject2"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
				</tr><tr class="form-group form-group-lg">
					<td width=70 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>通讯地址
							</span>
						</div>
					</td>
				<td  width=487 colspan=3 valign=top
						style='width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 30pt'>
						<input type="text" id="leaderAddress"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>邮编
							</span>
						</div>	
					</td>
						<td width=84 colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderZip_code"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					
				</tr><tr class="form-group form-group-lg">
					<td width=70 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>电话/传真
							</span>
						</div>
					</td>
					<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderFax"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>手机
							</span>
						</div>	
					</td>
						<td width=84 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderPhone"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
						<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>	
							<span style='font-size: 14.0pt; font-family: 宋体'>电子邮箱
							</span>
						</div>	
					</td>
						<td width=84 colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="leaderEmail"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
			</tr>
			<tr style='page-break-inside: avoid'>
				<td>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>学习经历</span>
					</div>
				</td>
			</tr>
			<tr style='page-break-inside: avoid' id="study">
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt' >
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>国家</span>
					</div>
				</td>
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>院校</span>
					</div>
				</td>
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>专业</span>
					</div>
				</td>
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>学历/学位</span>
					</div>
				</td>
				<td width=42 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>起始时间</span>
					</div>
				</td>
				<td width=42 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>结束时间</span>
					</div>
				</td>
			</tr>
			<tr style='page-break-inside: avoid'>
				<td>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>工作经历</span>
					</div>
				</td>
			</tr>
			<tr style='page-break-inside: avoid' id="work">
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt' >
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>国家</span>
					</div>
				</td>
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>单位</span>
					</div>
				</td>
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>职务</span>
					</div>
				</td>
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>起始时间</span>
					</div>
				</td>
				<td width=84 colspan=2 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>结束时间</span>
					</div>
				</td>
				
			</tr>
			
			
			<!-- 团队负责人组织期刊任职情况-->
			<tr style='page-break-inside: avoid'>
				<td>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>国内外学术组织及重要学术期刊任职情况</span>
					</div>
				</td>
				<td>
					<div style="text-align: left;margin-left:30px">
						<a class="btn btn-small btn-info" href="javascript:void(0)" id="addzuzhi" onclick="addzuzhi()">
							<i class="icon-plus-sign"></i>添加
						</a>
					</div>
				</td>
			</tr>
			<tr style='page-break-inside: avoid' id="zhuzhi">
				<td width=487 colspan=3 style='width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 30pt' >
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>组织或期刊名称</span>
					</div>
				</td>
				<td width=84 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>职位</span>
					</div>
				</td>
				<td width=84 colspan=2 style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>任期</span>
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" id="teamID" value="">
		
		<!-- 团队核心成员信息-->
		<p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 14.0pt'>&nbsp;</span>
		</p>
		<div class="xline" style="border-bottom: 1px solid #b3b3b3; height: 10px;"></div>


		<p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 14.0pt'>&nbsp;</span>
		</p>

		<p class=MsoNormal style='text-align: center'>
			<span lang=EN-US style='font-size: 14.0pt'>&nbsp;</span>
		</p>
		<p class=MsoNormal align=center style='text-align: center'>
			<span style='font-size: 22.0pt; font-family: 黑体'>团队成员情况</span>
		</p>

		<p class=MsoNormal align=center style='text-align: center'>
			<b><span lang=EN-US style='font-size: 22.0pt;'>&nbsp;</span></b>
		</p>
		
		
		<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 style='border-collapse: collapse'>
				
				<tr class="form-group form-group-lg">
					<td width=40 rowspan = 6  colspan =2 style='width: 10pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>
							团队成员共 
							<input type="text" id = "member_num"  class="x" style="width: 30px;">
							人
							</span>
						</div>
					</td>
					<td width=30 rowspan =2 style='width: 30pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>年龄</span>
						</div>
					</td>
					<td  colspan=2 style='text-align: center; width: 100pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>56岁以上</span>
					</td>
					<td colspan=2 style='text-align: center; width: 100pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>46-55岁</span>
					</td>
					<td  colspan=2 style='text-align: center; width: 100pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>36-45岁</span>
					</td>
					<td  colspan=2 style='text-align: center; width: 100pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>35岁以下</span>
					</td>
				</tr>
				<tr class="form-group form-group-lg">
					<td colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="age56"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=2  style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="age46_55"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=2  style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="age36_45"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=1 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="age35"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
				</tr>
				
				
				
				
				<tr class="form-group form-group-lg">
					<td  rowspan=2 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>职称
							</span>
						</div>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>高级</span>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>副高</span>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>中级</span>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>其他</span>
					</td>
				</tr>
				
				<tr class="form-group form-group-lg">
					<td colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="gaoji"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="fugao"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=2  style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="zhongji"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=1  style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="z_orther"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
				</tr>
				
				
				
				<tr class="form-group form-group-lg">
					<td width=70  rowspan=2 style='width: 62pt; border: solid black 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
						<div class=MsoNormal align=center style='text-align: center'>
							<span style='font-size: 14.0pt; font-family: 宋体'>学位学历
							</span>
						</div>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>博士</span>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>硕士</span>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>本科/学士</span>
					</td>
					<td colspan=2  style='text-align: center; width: 50pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
							<span style='font-size: 14.0pt; font-family: 宋体'>其他</span>
					</td>
				</tr>
				
				<tr class="form-group form-group-lg">
					<td colspan=2  style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="boshi"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=2 style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="shuoshi"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=2  style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="benke"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
					<td colspan=2  style='text-align: center; width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0; padding: 0; height: 30pt'>
						<input type="text" id="x_orther"  style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 95%; width: 90%; padding: 0px; margin: 3px; border-radius: 0px" />
					</td>
				</tr>
				
				
			
				<tr style='page-break-inside: avoid' id="memberinfo_div">
				<td width=36 rowspan=16 valign="middle" style='width: 6pt; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>团队核心成员（5-15人）</span>
					</div>
				</td>
				<td style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt' >
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>姓名</span>
					</div>
				</td>
				<td  style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>性别</span>
					</div>
				</td>
				<td  style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>出生年月</span>
					</div>
				</td>
				<td  style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>证件类型</span>
					</div>
				</td>
				<td style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>证件号码 </span>
					</div>
				</td>
				<td style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>学位/学历 </span>
					</div>
				</td>
				<td  style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>职务/职称 </span>
					</div>
				</td>
				
				<td style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>现从事专业或研究方向 </span>
					</div>
				</td>
				
				<td  style='width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt'>
					<div class=MsoNormal style='text-align: center'>
						<span style='font-size: 14.0pt; font-family: 宋体'>所在单位 </span>
					</div>
				</td>
			</tr>
		</table>
		
		<div style="text-align: left;margin-left:30px">
			<a class="btn btn-small btn-info" href="javascript:void(0)" id="addmemeber" onclick="addmember()">
				<i class="icon-plus-sign"></i>添加
			</a>
		</div>
</body>
</html>