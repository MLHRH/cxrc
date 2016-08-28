//初始化DOC01
function initcxtdDoc01(){
	$.ajax({
		type : 'get',
		dataType : 'json',
		// 请求的路径
		url : 'cxtdDoc01Init?userId=' + user_id,
		// 请求失败处理函数
		error : function() {
			
		},
		// 请求成功后处理函数。
		success : function(data) { 
			var myDate = new Date();
			var year = myDate.getFullYear();
			var month = myDate.getMonth() + 1;
			var day = myDate.getDate();
			$('#teamName').val(data[0].teamName);
			$('#sub_dir').val(data[0].researchDirection);
			$('#sub_1').val(data[0].subordinateSubject1);
			$('#sub_2').val(data[0].subordinateSubject2);
			$('#other').val(data[0].orther);
			$('#project_name').val(data[0].projectName);
			$('#project_from').val(data[0].projectSource);
			$('#unit_name').val(data[0].unitName);
			$('#org_code').val(data[0].organizationCode);
			$('#legal_rep').val(data[0].legalRepresentative);
			$('#competent_dep').val(data[0].competentDepartment);
			$('#unit_add').val(data[0].unitAddresses);
			$('#zip_code').val(data[0].zipCode);
			$('#contacts').val(data[0].contacts);
			$('#mobile_phone').val(data[0].mobilePhone);
			$('#t_email').val(data[0].email);
			$('#fax').val(data[0].fax);
			$('#telephone').val(data[0].telephone);
			$('#teamID').val(data[0].teamId)
			$('#nationality').val(data[1].country);
			$('#userName').val(data[1].name);
			$('#sex').val(data[1].sex);
			$('#national').val(data[1].minzu);
			$('#technical_position').val(data[1].position);
			$('#birthday').val(data[1].birthday);
			$('#document_type').val(data[1].documentType);
			$('#Id').val(data[1].documentNumber);
			$('#professional_direction').val(data[1].direction);
			$('#subject1').val(data[1].subordinateSubject1);
			$('#subject2').val(data[1].subordinateSubject2);
			$('#address').val(data[1].addresses);
			$('#zip_code').val(data[1].zipCode);
			$('#fax').val(data[1].telephoneFax);
			$('#phone').val(data[1].mobilePhone);
			$('#email').val(data[1].email);
			/*$('#oj_name1').val(data[1].journalTitle1);
			$('#oj_position1').val(data[1].organizationPosition1);
			$('#oj_term1').val(data[1].organizationTerm1);
			$('#oj_name2').val(data[1].journalTitle2);
			$('#oj_position2').val(data[1].organizationPosition2);
			$('#oj_term2').val(data[1].organizationTerm2);*/
			for(var i = 0 ;i < data[2].length;i++){
				$('#work_country'+(i+1)).val(data[2][i].country);
				$('#work_institution'+(i+1)).val(data[2][i].body);
				$('#work_position'+(i+1)).val(data[2][i].position);
				$('#work_start_date'+(i+1)).val(data[2][i].start_time);
				$('#work_end_date'+(i+1)).val(data[2][i].end_time);
			}
			for(var i = 0 ;i< data[3].length;i++){
				$('#study_country'+(i+1)).val(data[3][i].country);
				$('#study_institution'+(i+1)).val(data[3][i].college);
				$('#study_position'+(i+1)).val(data[3][i].major);
				$('#study_start_date'+(i+1)).val(data[3][i].start_time);
				$('#study_end_date'+(i+1)).val(data[3][i].end_time);
				$('#degree'+(i+1)).val(data[3][i].degree);
			}
			if((data[0].projectType).indexOf("0")!=-1){
				$('#imp_science').prop("checked",true);
			}
			if((data[0].projectType).indexOf("1")!=-1){
				$('#imp_project').prop("checked",true);
			}
			if((data[0].projectType).indexOf("2")!=-1){
				$('#orther_type').prop("checked",true);
			}
		}
	});
	
}
function updatecxtdDoc01(){
	
	var cxtdDoc01 = {};
	var type;
	cxtdDoc01.teamName = $('#teamName').val();
	cxtdDoc01.researchDirection = $('#sub_dir').val();
	cxtdDoc01.subordinateSubject1 = $('#sub_1').val();
	cxtdDoc01.subordinateSubject2 = $('#sub_2').val();
	
	if($('#imp_science').is(':checked')){
		type = "0"
	}
	if($('#imp_project').is(':checked')){
		type += "1"
	}
	if($('#orther_type').is(':checked')){
		type += "2"
	}
	
	cxtdDoc01.projectType = type;
	cxtdDoc01.orther = $('#other').val();
	cxtdDoc01.projectName = $('#project_name').val();
	cxtdDoc01.projectSource = $('#project_from').val();
	cxtdDoc01.unitName = $('#unit_name').val();
	cxtdDoc01.organizationCode = $('#org_code').val();
	cxtdDoc01.legalRepresentative = $('#legal_rep').val();
	cxtdDoc01.competentDepartment = $('#competent_dep').val();
	cxtdDoc01.unitAddresses = $('#unit_add').val();
	cxtdDoc01.zipCode= $('#zip_code').val();
	cxtdDoc01.contacts = $('#contacts').val();
	cxtdDoc01.mobilePhone = $('#mobile_phone').val();
	cxtdDoc01.fax = $('#fax').val();
	cxtdDoc01.email = $('#t_email').val();
	cxtdDoc01.telephone = $('#telephone').val();
	cxtdDoc01.teamId = $('#teamID').val();
	cxtdDoc01.userid = user_id;
	cxtdDoc01.status = 0;
	var cxtddoc01 = JSON.stringify(cxtdDoc01);
	$.ajax({
		type:'POST',
		dataType:'json',
		data:{"cxtddoc01":cxtddoc01},
		url:'cxtdDoc01Update',
		error:function(){
			alert('请求失败');
		},
		success:function(data){
			if (data.result == "更新成功") {
				noty({
							text : '附件1  保存完成！请继续完善其他信息！',
							type : 'success',
							dismissQueue : false,
							closeWith : ['click', 'button'],
							timeout : 1500,
							layout : 'top',
							callback : {
								afterClose : function() {
									// location.href='${ctx}/userBaseInfor?bt=base';
								}
							},
							theme : 'defaultTheme'
						});
			} else {
				generatenoty('center', data.result, 'error');
			}
		}
	})
	
}