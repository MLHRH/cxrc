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
					if(data[0][0]!=null){
					$('#study_country').val(data[0][0].country);
					$('#study_colleges').val(data[0][0].academy);
					$('#study_major').val(data[0][0].major);
					$('#study_education').val(data[0][0].xueli);
					$('#study_start_time').val(data[0][0].start_date);
					$('#study_end_time').val(data[0][0].end_date);
					}
					if(data[0][1]!=null){
					$('#user_studcountry2').val(data[0][1].country);
					$('#user_studcollege2').val(data[0][1].academy);
					$('#user_studmajor2').val(data[0][1].major);
					$('#user_studdegree2').val(data[0][1].xueli);
					$('#user_studfirsttime2').val(data[0][1].start_date);
					$('#user_studlasttime2').val(data[0][1].end_date);
					}
					if(data[2][0]!=null){
					$('#user_workcountry').val(data[2][0].country);
					$('#user_workcollege').val(data[2][0].work_content);
					$('#user_workmajor').val(data[2][0].zhiwu);
					$('#user_workdegree').val(data[2][0].start_date);
					$('#user_workfirsttime').val(data[2][0].end_date);
					}
					if(data[2][1]!=null){
					$('#work_country').val(data[2][1].country);
					$('#work_company').val(data[2][1].work_content);
					$('#work_position').val(data[2][1].zhiwu);
					$('#work_start_time').val(data[2][1].start_date);
					$('#work_end_time').val(data[2][1].end_date);
					}
					$('#journal_title').val(data[1].journal_title);
					$('#organization_position').val(data[1].organization_position);
					$('#organization_term').val(data[1].organization_term);
					
					$('#user_workboard2').val(data[1].journal_titlef);
					$('#user_zhiwu2').val(data[1].organization_position1);
					$('#user_renqi2').val(data[1].organization_term1);
					
					$('#user_workboard3').val(data[1].journal_title2);
					$('#user_zhiwu3').val(data[1].organization_position2);
					$('#user_renqi3').val(data[1].organization_term2);
					
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