var objUser = new Object();
 
var userBaseInfor_id;


function initjcqnDoc01() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'jcqnDoc01Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					
					$('#userName2').val(data[0].name);
				
					$('#user_birthday').val(data[0].birthday);
					$('#sex').val(data[0].sex);
					$('#user_minzu').val(data[0].minzu);
				    $('#title').val(data[0].title);
					$('#document_type').val(data[0].document_type);
					$('#document_number').val(data[0].document_number);
					$('#direction').val(data[0].direction);
					$('#declaration_area').val(data[0].declaration_area);
					$('#telephone').val(data[0].telephone);
					$('#fax').val(data[0].fax);
					$('#mobile_phone').val(data[0].mobile_phone);
					$('#email').val(data[0].email);
					$('#zip_code').val(data[0].zip_code);
					$('#addresses').val(data[0].addresses);
					$('#study_country').val(data[0].study_country);
					$('#study_colleges').val(data[0].study_colleges);
					$('#study_major').val(data[0].study_major);
					$('#study_education').val(data[0].study_education);
					$('#study_start_time').val(data[0].study_start_time);
					$('#study_end_time').val(data[0].study_end_time);
					$('#work_country').val(data[0].work_country);
					$('#work_company').val(data[0].work_company);
					$('#work_position').val(data[0].work_position);
					$('#work_start_time').val(data[0].work_start_time);
					$('#work_end_time').val(data[0].work_end_time);
					$('#journal_title').val(data[0].journal_title);
					$('#organization_position').val(data[0].organization_position);
					$('#organization_term').val(data[0].organization_term);
					$('#unit_name').val(data[0].unit_name);
					$('#organization_code').val(data[0].organization_code);
					$('#legal_representative').val(data[0].legal_representative);
					$('#supervisor_unit').val(data[0].supervisor_unit);
					$('#unit_address').val(data[0].unit_address);
					$('#postcode').val(data[0].postcode);
					$('#unit_contact').val(data[0].unit_contact);
					$('#work_telephone').val(data[0].work_telephone);
					$('#work_fax').val(data[0].work_fax);
					$('#unit_address').val(data[0].unit_address);
					$('#postcode').val(data[0].postcode);
					$('#unit_contact').val(data[0].unit_contact);
				} 
			});
}
function updatejcqnDoc01() {
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
				url : "jcqnDoc01Update",
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