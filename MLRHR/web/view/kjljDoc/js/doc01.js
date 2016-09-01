var objUser = new Object();
 
var userBaseInfor_id;


function initkjljDoc01() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'kjljDoc01Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					
					$('#userName2').val(data.name);
				
					
					$('#sex').val(data.sex);
					$('#user_minzu').val(data.minzu);
					$('#user_birthday').val(data.birthday);
				    $('#title').val(data.title);
					$('#document_type').val(data.document_type);
					$('#document_number').val(data.document_number);
					$('#direction').val(data.direction);
					$('#declaration_area').val(data.declaration_area);
					$('#telephone').val(data.telephone);
					$('#fax').val(data.fax);
					$('#mobile_phone').val(data.mobile_phone);
					$('#email').val(data.email);
					$('#zip_code').val(data.zip_code);
					$('#addresses').val(data.addresses);
					$('#study_country').val(data.study_country);
					$('#study_colleges').val(data.study_colleges);
					$('#study_major').val(data.study_major);
					$('#study_education').val(data.study_education);
					$('#study_start_time').val(data.study_start_time);
					$('#study_end_time').val(data.study_end_time);
					
					$('#user_studcountry2').val(data.study_country);
					$('#user_studcollege2').val(data.study_colleges);
					$('#user_studmajor2').val(data.study_major);
					$('#user_studdegree2').val(data.study_education);
					$('#user_studfirsttime2').val(data.study_start_time);
					$('#user_studlasttime2').val(data.study_end_time);
					
					$('#work_country').val(data.work_country);
					$('#work_company').val(data.work_company);
					$('#work_position').val(data.work_position);
					$('#work_start_time').val(data.work_start_time);
					$('#work_end_time').val(data.work_end_time);
					
					$('#work_country2').val(data.work_country);
					$('#work_company2').val(data.work_company);
					$('#work_position2').val(data.work_position);
					$('#work_start_time2').val(data.work_start_time);
					$('#work_end_time2').val(data.work_end_time);
					
					$('#journal_title').val(data.journal_title);
					$('#organization_position').val(data.organization_position);
					$('#organization_term').val(data.organization_term);
					
					$('#user_workboard2').val(data.journal_title);
					$('#user_zhiwu2').val(data.organization_position);
					$('#user_renqi2').val(data.organization_term);
					
					$('#user_workboard3').val(data.journal_title);
					$('#user_zhiwu3').val(data.organization_position);
					$('#user_renqi3').val(data.organization_term);
					
					
					$('#unit_name').val(data.unit_name);
					$('#organization_code').val(data.organization_code);
					$('#legal_representative').val(data.legal_representative);
					$('#supervisor_unit').val(data.supervisor_unit);
					$('#unit_address').val(data.unit_address);
					$('#postcode').val(data.postcode);
					$('#unit_contact').val(data.unit_contact);
					$('#work_telephone').val(data.work_telephone);
					$('#work_fax').val(data.work_fax);
					
				} 
			});
}
function updatekjljDoc01() {
	arrData = new Array();
arrData.push({
		"name" : "name",
		"value" : $("#userName2").val()
	});
	if ($("#user_birthday").val() != "")
		arrData.push({
					"name" : "birthday",
					"value" : $("#user_birthday").val()
				});
	arrData.push({
		"name" : "sex",
		"value" : $("#sex").val()
	});arrData.push({
		"name" : "minzu",
		"value" : $("#user_minzu").val()
	});arrData.push({
		"name" : "title",
		"value" : $("#title").val()
	});arrData.push({
		"name" : "document_type",
		"value" : $("#document_type").val()
	});arrData.push({
		"name" : "document_number",
		"value" : $("#document_number").val()
	});arrData.push({
		"name" : "direction",
		"value" : $("#direction").val()
	});arrData.push({
		"name" : "declaration_area",
		"value" : $("#declaration_area").val()
	});arrData.push({
		"name" : "telephone",
		"value" : $("#telephone").val()
	});arrData.push({
		"name" : "fax",
		"value" : $("#fax").val()
	});arrData.push({
		"name" : "mobile_phone",
		"value" : $("#mobile_phone").val()
	});arrData.push({
		"name" : "email",
		"value" : $("#email").val()
	});arrData.push({
		"name" : "zip_code",
		"value" : $("#zip_code").val()
	});arrData.push({
		"name" : "addresses",
		"value" : $("#addresses").val()
	});arrData.push({
		"name" : "study_country",
		"value" : $("#study_country").val()
	});arrData.push({
		"name" : "study_colleges",
		"value" : $("#study_colleges").val()
	});arrData.push({
		"name" : "study_major",
		"value" : $("#study_major").val()
	});arrData.push({
		"name" : "study_education",
		"value" : $("#study_education").val()
	});if ($("#study_start_time").val() != "")
		arrData.push({
			"name" : "study_start_time",
			"value" : $("#study_start_time").val()
		});
	if ($("#study_end_time").val() != "")
		arrData.push({
			"name" : "study_end_time",
			"value" : $("#study_end_time").val()
		});
	arrData.push({
		"name" : "minzu",
		"value" : $("#work_country").val()
	});arrData.push({
		"name" : "work_country",
		"value" : $("#work_country").val()
	});arrData.push({
		"name" : "work_company",
		"value" : $("#work_company").val()
	});arrData.push({
		"name" : "work_position",
		"value" : $("#work_position").val()
	});	if ($("#work_start_time").val() != "")
		arrData.push({
			"name" : "work_start_time",
			"value" : $("#work_start_time").val()
		});	if ($("#work_end_time").val() != "")
			arrData.push({
				"name" : "work_end_time",
				"value" : $("#work_end_time").val()
			});
	;arrData.push({
		"name" : "journal_title",
		"value" : $("#journal_title").val()
	});arrData.push({
		"name" : "organization_position",
		"value" : $("#organization_position").val()
	});arrData.push({
		"name" : "organization_term",
		"value" : $("#organization_term").val()
	});arrData.push({
		"name" : "unit_name",
		"value" : $("#unit_name").val()
	});arrData.push({
		"name" : "organization_code",
		"value" : $("#organization_code").val()
	});arrData.push({
		"name" : "legal_representative",
		"value" : $("#legal_representative").val()
	});arrData.push({
		"name" : "supervisor_unit",
		"value" : $("#supervisor_unit").val()
	});
	arrData.push({
				"name" : "unit_address",
				"value" : $("#unit_address").val()
			});
	arrData.push({
		"name" : "postcode",
		"value" : $("#postcode").val()
	});arrData.push({
		"name" : "unit_contact",
		"value" : $("#unit_contact").val()
	});arrData.push({
		"name" : "work_telephone",
		"value" : $("#work_telephone").val()
	});arrData.push({
		"name" : "work_fax",
		"value" : $("#work_fax").val()
	});
	
	$.ajax({
				dataType : "json",
				type : "post",
				url : "kjljDoc01Update",
				data :arrData,
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) {
					if (rst.result == 1) {
						alert("success!");

					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
	
	
}