////初始化DOC02
//function initcxtdDoc02(){
//	$.ajax({
//		type : 'get',
//		dataType : 'json',
//		url : 'cxtdDoc02Init?userId=' + user_id,// 请求的路径
//		error : function() {// 请求失败处理函数
//		},
//		success : function(data) { // 请求成功后处理函数。
//			var myDate = new Date();
//			var year = myDate.getFullYear();
//			var month = myDate.getMonth() + 1;
//			var day = myDate.getDate();
//			/*$('#currentDate').html(year + "年" + month + "月" + day + "日");*/
//			$('#nationality').val(data[0].country);
//			$('#userName').val(data[0].name);
//			$('#sex').val(data[0].sex);
//			$('#national').val(data[0].minzu);
//			$('#technical_position').val(data[0].position);
//			$('#birthday').val(data[0].birthday);
//			$('#document_type').val(data[0].documentType);
//			$('#Id').val(data[0].documentNumber);
//			$('#professional_direction').val(data[0].direction);
//			$('#subject1').val(data[0].subordinateSubject1);
//			$('#subject2').val(data[0].subordinateSubject2);
//			$('#address').val(data[0].addresses);
//			$('#zip_code').val(data[0].zipCode);
//			$('#fax').val(data[0].telephoneFax);
//			$('#phone').val(data[0].mobilePhone);
//			$('#email').val(data[0].email);
//			$('#oj_name1').val(data[0].journalTitle1);
//			$('#oj_position1').val(data[0].organizationPosition1);
//			$('#oj_term1').val(data[0].organizationTerm1);
//			$('#oj_name2').val(data[0].journalTitle2);
//			$('#oj_position2').val(data[0].organizationPosition2);
//			$('#oj_term2').val(data[0].organizationTerm2);
//			for(var i = 0 ;i < data[1].length;i++){
//				$('#work_country'+(i+1)).val(data[1][i].contry);
//				$('#work_institution'+(i+1)).val(data[1][i].body);
//				$('#work_position'+(i+1)).val(data[1][i].position);
//				$('#work_start_date'+(i+1)).val(data[1][i].start_time);
//				$('#work_end_date'+(i+1)).val(data[1][i].end_time);
//			}
//			for(var i = 0 ;i< data[2].length;i++){
//				$('#study_country'+(i+1)).val(data[2][i].contry);
//				$('#study_institution'+(i+1)).val(data[2][i].college);
//				$('#study_position'+(i+1)).val(data[2][i].major);
//				$('#study_start_date'+(i+1)).val(data[2][i].start_time);
//				$('#study_end_date'+(i+1)).val(data[2][i].end_time);
//				$('#degree'+(i+1)).val(data[2][i].degree);
//			}
//			
//		}
//	});
//	
//}