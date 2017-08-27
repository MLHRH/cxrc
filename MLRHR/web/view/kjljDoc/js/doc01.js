var objUser = new Object();
 
var userBaseInfor_id;

var id;
var userid;
var currentRole;
//组织期刊的记录条数
var index_zuzhi = 0;
// 初始化工作经历
var index_work = 0;
// 初始化学习经历
var index_study = 0;
function initkjljDoc01() {
	//被审核人的ID存在时。此时是审核模式。采用被审核人的ID初始化。
	if(userId != null && userId !=""){
		userid = userId;
	}
	else{
		userid = user_id;
	}
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'kjljDoc01Init?userId=' + userid,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					
					$('#userName2').val(data[1].name);
				
					$('#user_birthday').val(data[1].birthday);
					$('#sex').val(data[1].sex);
					$('#user_minzu').val(data[1].minzu);
				    $('#title').val(data[1].title);
					$('#document_type').val(data[1].document_type);
					$('#document_number').val(data[1].document_number);
					$('#direction').val(data[1].direction);
					$('#declaration_area').val(data[1].declaration_area);
					$('#telephone').val(data[1].telephone);
					$('#fax').val(data[1].fax);
					$('#mobile_phone').val(data[1].mobile_phone);
					$('#email').val(data[1].email);
					$('#zip_code').val(data[1].zip_code);
					$('#addresses').val(data[1].addresses);
					$('#unit_name').val(data[1].unit_name);
					$('#organization_code').val(data[1].organization_code);
					$('#legal_representative').val(data[1].legal_representative);
					$('#supervisor_unit').val(data[1].supervisor_unit);
					$('#unit_address').val(data[1].unit_address);
					$('#postcode').val(data[0].postcode);
					$('#unit_contact').val(data[1].unit_contact);
					$('#work_telephone').val(data[1].work_telephone);
					$('#work_fax').val(data[1].work_fax);
					$('#unit_address').val(data[1].unit_address);
					$('#postcode').val(data[1].postcode);
					$('#unit_contact').val(data[1].unit_contact);
					
					
					// 学习经历信息
					Study(data[2].plist);
					for (index_study = 0; index_study < data[2].plist.length; index_study++) {
						$('#studyid' + index_study).val(
								data[2].plist[index_study].id);
						$('#study_country' + index_study).val(
								data[2].plist[index_study].country);
						$('#study_colleges' + index_study).val(
								data[2].plist[index_study].academy);
						$('#study_major' + index_study).val(
								data[2].plist[index_study].major);
						$('#study_education' + index_study).val(
								data[2].plist[index_study].xueli);
						$('#study_start_time' + index_study).val(
								data[2].plist[index_study].start_date);
						$('#study_end_time' + index_study).val(
								data[2].plist[index_study].end_date);
					}

					// 工作经历信息
					Work(data[2].wlist);
					for (index_work = 0; index_work < data[2].wlist.length; index_work++) {
						$('#workid' + index_work).val(
								data[2].wlist[index_work].id);
						$('#work_country' + index_work).val(
								data[2].wlist[index_work].country);
						$('#work_institution' + index_work).val(
								data[2].wlist[index_work].work_content);
						$('#work_position' + index_work).val(
								data[2].wlist[index_work].zhiwu);
						$('#work_start_date' + index_work).val(
								data[2].wlist[index_work].start_date);
						$('#work_end_date' + index_work).val(
								data[2].wlist[index_work].end_date);

					}
					// 组织任期情况
					Zuzhi(data[2].zlist);
					for (index_zuzhi = 0; index_zuzhi < data[2].zlist.length; index_zuzhi++) {
						$('#zuzhiid' + index_zuzhi).val(
								data[2].zlist[index_zuzhi].id);
						$('#zuzhi_name' + index_zuzhi).val(
								data[2].zlist[index_zuzhi].zuzhi_name);
						$('#zuzhi_job' + index_zuzhi).val(
								data[2].zlist[index_zuzhi].zuzhi_job);
						$('#zuzhi_renqi' + index_zuzhi).val(
								data[2].zlist[index_zuzhi].zuzhi_renqi);

					}
					var authority = data[3].authority;
					var arr = authority.split("|");
//					if (currentRole == null)
					var isUser = false;
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_USER") {
									isUser = true;
							}
						}
						if(isUser == false){
							$("#selfAssessment").attr("disabled",
									true);
							$("input").each(function(){
								$(this).attr("disabled",
										true);
							});
						}
				} 
			});
}

function Study(data) {
	$('#study').find('td').each(function(index) {
		if (index == 0) {
			$(this).prop("rowSpan", Number(data.length) + 1)
		}
	})
	for (var i = 0; i < data.length; i++) {
		var add_study_div = '</tr><tr style="page-break-inside: avoid" id = "study'
				+ i
				+ '">'
				+ '<input type="hidden" value="'
				+ data[i].id
				+ '" id=studyid'
				+ i
				+ '>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="study_country'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="study_colleges'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="study_major'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="study_education'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="study_start_time'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="study_end_time'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>';
		if (i == 0) {
			$('#study').after(add_study_div);
		} else {
			$('#study' + (i - 1)).after(add_study_div);
		}
	}
}
function Work(data) {
	$('#work').find('td').each(function(index) {
		if (index == 0) {
			$(this).prop("rowSpan", Number(data.length) + 1)
		}
	})
	for (var i = 0; i < data.length; i++) {
		var add_work_div = '</tr><tr style="page-break-inside: avoid" id = "work'
				+ i
				+ '">'
				+ '<input type="hidden" value="'
				+ data[i].id
				+ '" id=workid'
				+ i
				+ '>'
				+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="work_country'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="work_institution'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="work_position'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="work_start_date'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="work_end_date'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>';
		if (i == 0) {
			$('#work').after(add_work_div);
		} else {
			$('#work' + (i - 1)).after(add_work_div);
		}
	}
}

function Zuzhi(data) {
	$('#zhuzhi').find('td').each(function(index) {
		if (index == 0) {
			$(this).prop("rowSpan", Number(data.length) + 1)
		}
	})
	for (var i = 0; i < Number(data.length); i++) {
		var add_zuzhi_div = '</tr><tr style="page-break-inside: avoid" id = "zuzhi'
				+ i
				+ '">'
				+ '<input type="hidden" value="'
				+ data[i].id
				+ '" id=zuzhiid'
				+ i
				+ '>'
				+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="zuzhi_name'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="zuzhi_job'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
				+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
				+ '<input type="text" id="zuzhi_renqi'
				+ i
				+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>';
		if (i == 0) {
			$('#zhuzhi').after(add_zuzhi_div);
		} else {
			$('#zuzhi' + (i - 1)).after(add_zuzhi_div);
		}
	}
}
function addstudy() {
	var flag = index_study;
	$('#study').find('td').each(function(index) {
		if (index == 0) {
			$(this).prop("rowSpan", Number($(this).attr('rowSpan')) + 2)
		}
	})
	var addStudy_div = '<tr><input type="hidden" id=studyid'
			+ flag
			+ '/></tr>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="study_country'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="study_colleges'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="study_major'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="study_education'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="study_start_time'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="study_end_time'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>';
	if (index_study == 0) {
		$('#study').after(addStudy_div);
	} else {
		// $('#work'+(i-1)).after(addWork_div);
		$('#study').after(addStudy_div);
	}
}
function addwork() {
	var flag = index_work;
	$('#work').find('td').each(function(index) {
		if (index == 0) {
			$(this).prop("rowSpan", Number($(this).attr('rowSpan')) + 2)
			console.log($(this))
		}
	})
	var addWork_div = '<tr><input type="hidden" id=workid'
			+ flag
			+ '/></tr>'
			+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="work_country'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="work_institution'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="work_position'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="work_start_date'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="work_end_date'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>';
	if (index_work == 0) {
		$('#work').after(addWork_div);
	} else {
		// $('#work'+(i-1)).after(addWork_div);
		$('#work').after(addWork_div);
	}
}

function addzuzhi() {
	var flag = index_zuzhi;
	$('#zhuzhi').find('td').each(function(index) {
		if (index == 0) {
			$(this).prop("rowSpan", Number($(this).attr('rowSpan')) + 2)
		}
	})
	var addZuzhi_div = '<tr><input type="hidden" id=zuzhiid'
			+ flag
			+ '/></tr>'
			+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="zuzhi_name'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="zuzhi_job'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+ '<td width=84 colspan=3 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+ '<input type="text" id="zuzhi_renqi'
			+ flag
			+ '" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>';
	if (index_zuzhi == 0) {
		$('#zhuzhi').after(addZuzhi_div);
	} else {
		// $('#work'+(i-1)).after(addWork_div);
		$('#zhuzhi').after(addZuzhi_div);
	}
}

function updatekjljDoc01() {
	
	var arrstudy = [];
	var arrwork = [];
	var arrzuzhi = [];
	for (var i = 0; i <= index_study; i++) {
		var CxtdStudy = {};
		CxtdStudy.id = $('#studyid' + i).val();
		CxtdStudy.country = $('#study_country' + i).val();
		CxtdStudy.academy = $('#study_colleges' + i).val();
		CxtdStudy.major = $('#study_major' + i).val();
		CxtdStudy.xueli = $('#study_education' + i).val();
		CxtdStudy.start_date = $('#study_start_time' + i).val();
		CxtdStudy.end_date = $('#study_end_time' + i).val();
		if (CxtdStudy.country == null && CxtdStudy.academy == null
				&& CxtdStudy.major == null && CxtdStudy.xueli == null
				&& CxtdStudy.start_date == null && CxtdStudy.end_date == null) {
			break;
		}
		arrstudy.push(CxtdStudy);
	}

	// 工作信息
	for (var i = 0; i <= index_work; i++) {
		var CxtdWork = {};
		CxtdWork.id = $('#workid' + i).val();
		CxtdWork.country = $('#work_country' + i).val();
		CxtdWork.work_content = $('#work_institution' + i).val();
		CxtdWork.zhiwu = $('#work_position' + i).val();
		CxtdWork.start_date = $('#work_start_date' + i).val();
		CxtdWork.end_date = $('#work_end_date' + i).val();
		if (CxtdWork.country == null && CxtdWork.work_content == null
				&& CxtdWork.zhiwu == null && CxtdWork.start_date == null
				&& CxtdWork.end_date == null) {
			break;
		}
		arrwork.push(CxtdWork);
	}
	// 组织信息
	for (var i = 0; i <= index_zuzhi; i++) {
		var CxtdZuzhi = {};
		CxtdZuzhi.id = $('#zuzhiid' + i).val();
		CxtdZuzhi.zuzhi_name = $('#zuzhi_name' + i).val();
		CxtdZuzhi.zuzhi_job = $('#zuzhi_job' + i).val();
		CxtdZuzhi.zuzhi_renqi = $('#zuzhi_renqi' + i).val();
		if (CxtdZuzhi.zuzhi_name == null && CxtdZuzhi.zuzhi_job == null
				&& CxtdZuzhi.zuzhi_renqi == null) {
           break;
		}
		arrzuzhi.push(CxtdZuzhi);
	}
	var studyList = JSON.stringify(arrstudy);
	var workList = JSON.stringify(arrwork);
	var zuzhiList = JSON.stringify(arrzuzhi);
	
	var kjlj = {};
	kjlj.user_id = userid;
	kjlj.name = $("#userName2").val();
    kjlj.birthday = $("#user_birthday").val();
	kjlj.sex = $("#sex").val();
	kjlj.minzu = $("#user_minzu").val();
    kjlj.title = $("#title").val();
	kjlj.document_type=$("#document_type").val();
	kjlj.document_number= $("#document_number").val();
	kjlj.direction=$("#direction").val();
	kjlj.declaration_area=$("#declaration_area").val();
	kjlj.telephone=$("#telephone").val();
    kjlj.fax= $("#fax").val();
	kjlj.mobile_phone=$("#mobile_phone").val();
	kjlj.email=$("#email").val();
	kjlj.zip_code=$("#zip_code").val();
	kjlj.addresses=$("#addresses").val();
    kjlj.unit_name=$("#unit_name").val();
	kjlj.organization_code=$("#organization_code").val();
	kjlj.legal_representative=$("#legal_representative").val();
	kjlj.supervisor_unit=$("#supervisor_unit").val();
	kjlj.unit_address=$("#unit_address").val();
	kjlj.postcode=$("#postcode").val();
	kjlj.unit_contact=$("#unit_contact").val();
	kjlj.work_telephone= $("#work_telephone").val();
	kjlj.work_fax=$("#work_fax").val();
	
	$.ajax({
				dataType : "json",
				type : "POST",
				url : "kjljDoc01Update",
				data : {
					"kjlj" : JSON.stringify(kjlj),
					"zuzhis" : zuzhiList,
					"studys" : studyList,
					"works" : workList
				},
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) {
					if (rst.result == 1) {
						alert("修改成功，请继续填写!");

					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
	
	
}