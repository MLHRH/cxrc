var objUser = new Object();
 
var userBaseInfor_id;

var id;
var userid;
var currentRole;
function initjcqnDoc01() {
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
				url : 'jcqnDoc01Init?userId=' + userid,// 请求的路径
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
				
					$('#study_country').val(data[1].study_country);
					$('#study_colleges').val(data[1].study_colleges);
					$('#study_major').val(data[1].study_major);
					$('#study_education').val(data[1].study_education);
					$('#study_start_time').val(data[1].study_start_time);
					$('#study_end_time').val(data[1].study_end_time);
					
					
					$('#user_studcountry2').val(data[1].user_studcountry2);
					$('#user_studcollege2').val(data[1].user_studcollege2);
					$('#user_studmajor2').val(data[1].user_studmajor2);
					$('#user_studdegree2').val(data[1].user_studdegree2);
					$('#user_studfirsttime2').val(data[1].user_studfirsttime2);
					$('#user_studlasttime2').val(data[1].user_studlasttime2);
					
					
					$('#user_workcountry').val(data[1].user_workcountry);
					$('#user_workcollege').val(data[1].user_workcollege);
					$('#user_workmajor').val(data[1].user_workmajor);
					$('#work_starttime').val(data[1].work_starttime);
					$('#work_endtime').val(data[1].work_endtime);
					
					
					$('#work_country').val(data[1].work_country);
					$('#work_company').val(data[1].work_company);
					$('#work_position').val(data[1].work_position);
					$('#work_start_time').val(data[1].work_start_time);
					$('#work_end_time').val(data[1].work_end_time);
					
					$('#journal_title').val(data[1].journal_title);
					$('#organization_position').val(data[1].organization_position);
					$('#organization_term').val(data[1].organization_term);
					
					$('#journal_title1').val(data[1].journal_title1);
					$('#organization_position1').val(data[1].organization_position1);
					$('#organization_term1').val(data[1].organization_term1);
					
					$('#journal_title2').val(data[1].journal_title2);
					$('#organization_position2').val(data[1].organization_position2);
					$('#organization_term2').val(data[1].organization_term2);
					
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
function updatejcqnDoc01() {
	arrData = new Array();
	arrData.push({
		"name" : "user_id",
		"value" : userid
	});
arrData.push({
		"name" : "name",
		"value" : $("#userName2").val()
	});arrData.push({
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
	});
	
	arrData.push({
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
	});;arrData.push({
		"name" : "study_start_time",
		"value" : $("#study_start_time").val()
	});arrData.push({
		"name" : "study_end_time",
		"value" : $("#study_end_time").val()
	});arrData.push({
		"name" : "user_studcountry2",
		"value" : $("#user_studcountry2").val()
	});arrData.push({
		"name" : "user_studcollege2",
		"value" : $("#user_studcollege2").val()
	});arrData.push({
		"name" : "user_studmajor2",
		"value" : $("#user_studmajor2").val()
	});arrData.push({
		"name" : "user_studdegree2",
		"value" : $("#user_studdegree2").val()
	});arrData.push({
		"name" : "user_studfirsttime2",
		"value" : $("#user_studfirsttime2").val()
	});arrData.push({
		"name" : "user_studlasttime2",
		"value" : $("#user_studlasttime2").val()
	});
	
	arrData.push({
		"name" : "work_country",
		"value" : $("#work_country").val()
	});arrData.push({
		"name" : "work_company",
		"value" : $("#work_company").val()
	});arrData.push({
		"name" : "work_position",
		"value" : $("#work_position").val()
	});arrData.push({
		"name" : "work_start_time",
		"value" : $("#work_start_time").val()
	});arrData.push({
		"name" : "work_end_time",
		"value" : $("#work_end_time").val()
	});arrData.push({
		"name" : "user_workcountry",
		"value" : $("#user_workcountry").val()
	});arrData.push({
		"name" : "user_workcollege",
		"value" : $("#user_workcollege").val()
	});arrData.push({
		"name" : "user_workmajor",
		"value" : $("#user_workmajor").val()
	});arrData.push({
		"name" : "work_starttime",
		"value" : $("#work_starttime").val()
	});arrData.push({
		"name" : "work_endtime",
		"value" : $("#work_endtime").val()
	});
	
	
	arrData.push({
		"name" : "journal_title",
		"value" : $("#journal_title").val()
	});arrData.push({
		"name" : "organization_position",
		"value" : $("#organization_position").val()
	});arrData.push({
		"name" : "organization_term",
		"value" : $("#organization_term").val()
	});arrData.push({
		"name" : "journal_title1",
		"value" : $("#journal_title1").val()
	});arrData.push({
		"name" : "organization_position1",
		"value" : $("#organization_position1").val()
	});arrData.push({
		"name" : "organization_term1",
		"value" : $("#organization_term1").val()
	});arrData.push({
		"name" : "journal_title2",
		"value" : $("#journal_title2").val()
	});arrData.push({
		"name" : "organization_position2",
		"value" : $("#organization_position2").val()
	});arrData.push({
		"name" : "organization_term2",
		"value" : $("#organization_term2").val()
	});
	
	arrData.push({
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