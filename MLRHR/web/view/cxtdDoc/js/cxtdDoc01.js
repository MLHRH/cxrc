//组织期刊的记录条数
var index_zuzhi = 0;
//团队成员记录条数
var index_meminfo = 0;
//初始化DOC01
var id;
function initcxtdDoc01(){
	//被审核人的ID存在时。此时是审核模式。采用被审核人的ID初始化。
	if(userId != null && userId !=""){
		id = userId;
	}
	else{
		id = user_id;
	}
	$.ajax({
		type : 'get',
		dataType : 'json',
		url : 'cxtdDoc01Init?userId=' + id,
		error : function() {
		},
		// 请求成功后处理函数。
		success : function(data) { 
			//team baseinfo
			$('#baseinfoid').val(data[0].baseinfo.id);
			$('#teamName').val(data[0].baseinfo.teamName);
			$('#sub_dir').val(data[0].baseinfo.researchDirection);
			$('#sub_1').val(data[0].baseinfo.subordinateSubject1);
			$('#sub_2').val(data[0].baseinfo.subordinateSubject2);
			$('#other').val(data[0].baseinfo.orther);
			$('#project_name').val(data[0].baseinfo.projectName);
			$('#project_from').val(data[0].baseinfo.projectSource);
			$('#unit_name').val(data[0].baseinfo.unitName);
			$('#org_code').val(data[0].baseinfo.organizationCode);
			$('#legal_rep').val(data[0].baseinfo.legalRepresentative);
			$('#competent_dep').val(data[0].baseinfo.competentDepartment);
			$('#unit_add').val(data[0].baseinfo.unitAddresses);
			$('#zip_code').val(data[0].baseinfo.zipCode);
			$('#contacts').val(data[0].baseinfo.contacts);
			$('#mobile_phone').val(data[0].baseinfo.mobilePhone);
			$('#t_email').val(data[0].baseinfo.email);
			$('#fax').val(data[0].baseinfo.fax);
			$('#telephone').val(data[0].baseinfo.telephone);
			$('#teamID').val(data[0].baseinfo.teamId)
			//team leader
			$('#leaderinfoid').val(data[0].leaderinfo.id);
			$('#leaderCountry').val(data[0].leaderinfo.country);
			$('#leaderName').val(data[0].leaderinfo.name);
			$('#leaderSex').val(data[0].leaderinfo.sex);
			$('#leaderNation').val(data[0].leaderinfo.minzu);
			$('#leaderTechnical_position').val(data[0].leaderinfo.position);
			$('#leaderBirthday').val(data[0].leaderinfo.birthday);
			$('#leaderId_type').val(data[0].leaderinfo.documentType);
			$('#leaderId_num').val(data[0].leaderinfo.documentNumber);
			$('#leaderProfessional_direction').val(data[0].leaderinfo.direction);
			$('#leaderSubject1').val(data[0].leaderinfo.subordinateSubject1);
			$('#leaderSubject2').val(data[0].leaderinfo.subordinateSubject2);
			$('#leaderAddress').val(data[0].leaderinfo.addresses);
			$('#leaderZip_code').val(data[0].leaderinfo.zipCode);
			$('#leaderFax').val(data[0].leaderinfo.telephoneFax);
			$('#leaderPhone').val(data[0].leaderinfo.mobilePhone);
			$('#leaderEmail').val(data[0].leaderinfo.email);
			//学习经历
			$('#study_country').val(data[0].leaderinfo.study_country);
			$('#study_colleges').val(data[0].leaderinfo.study_colleges);
			$('#study_major').val(data[0].leaderinfo.study_major);
			$('#study_education').val(data[0].leaderinfo.study_education);
			$('#study_start_time').val(data[0].leaderinfo.study_start_time);
			$('#study_end_time').val(data[0].leaderinfo.study_end_time);
				
			$('#user_studcountry2').val(data[0].leaderinfo.user_studcountry2);
			$('#user_studcollege2').val(data[0].leaderinfo.user_studcollege2);
			$('#user_studmajor2').val(data[0].leaderinfo.user_studmajor2);
			$('#user_studdegree2').val(data[0].leaderinfo.user_studdegree2);
			$('#user_studfirsttime2').val(data[0].leaderinfo.user_studfirsttime2);
			$('#user_studlasttime2').val(data[0].leaderinfo.user_studlasttime2);
            //工作经历
			$('#user_workcountry').val(data[0].leaderinfo.user_workcountry);
			$('#user_workcollege').val(data[0].leaderinfo.user_workcollege);
			$('#user_workmajor').val(data[0].leaderinfo.user_workmajor);
			$('#work_starttime').val(data[0].leaderinfo.work_starttime);
			$('#work_endtime').val(data[0].leaderinfo.work_endtime);
			
			$('#work_country').val(data[0].leaderinfo.work_country);
			$('#work_company').val(data[0].leaderinfo.work_company);
			$('#work_position').val(data[0].leaderinfo.work_position);
			$('#work_start_time').val(data[0].leaderinfo.work_start_time);
			$('#work_end_time').val(data[0].leaderinfo.work_end_time);
            //期刊任职情况
			$('#journal_title').val(data[0].leaderinfo.journal_title);
			$('#organization_position').val(data[0].leaderinfo.organization_position);
			$('#organization_term').val(data[0].leaderinfo.organization_term);
			
			$('#journal_title1').val(data[0].leaderinfo.journal_title1);
			$('#organization_position1').val(data[0].leaderinfo.organization_position1);
			$('#organization_term1').val(data[0].leaderinfo.organization_term1);
			
			$('#journal_title2').val(data[0].leaderinfo.journal_title2);
			$('#organization_position2').val(data[0].leaderinfo.organization_position2);
			$('#organization_term2').val(data[0].leaderinfo.organization_term2);
			//成员分类统计人数
			$('#memnumid').val(data[0].memnum.id);
			$('#member_num').val(data[0].memnum.num);
			$('#age56').val(data[0].memnum.age_56);
			$('#age46_55').val(data[0].memnum.age_46_55);
			$('#age36_45').val(data[0].memnum.age_36_45);
			$('#age35').val(data[0].memnum.age_35);
			$('#gaoji').val(data[0].memnum.gaoji);
			$('#fugao').val(data[0].memnum.fugao);
			$('#zhongji').val(data[0].memnum.zhongji);
			$('#z_orther').val(data[0].memnum.z_orther);
			$('#boshi').val(data[0].memnum.boshi);
			$('#shuoshi').val(data[0].memnum.shuoshi);
			$('#benke').val(data[0].memnum.benke);
			$('#x_orther').val(data[0].memnum.x_orther);
			
			//团队成员信息
			Member(data[0].mlist.length);
			for(index_meminfo = 0 ; index_meminfo<data[0].mlist.length; index_meminfo++){
				$('#chenyuanid'+index_meminfo).val(data[0].mlist[index_meminfo].id);
				$('#chengyuanname'+index_meminfo).val(data[0].mlist[index_meminfo].name);
				$('#chnengyuansex'+index_meminfo).val(data[0].mlist[index_meminfo].sex);
				$('#chengyuanbir'+index_meminfo).val(data[0].mlist[index_meminfo].birthday);
				$('#chengyuantype'+index_meminfo).val(data[0].mlist[index_meminfo].id_type);
				$('#chengyuannum'+index_meminfo).val(data[0].mlist[index_meminfo].id_num);
				$('#chengyuanedu'+index_meminfo).val(data[0].mlist[index_meminfo].study_education);
				$('#chengyuanp'+index_meminfo).val(data[0].mlist[index_meminfo].work_position);
				$('#chengs'+index_meminfo).val(data[0].mlist[index_meminfo].direction);
				$('#chengyuancompany'+index_meminfo).val(data[0].mlist[index_meminfo].work_company);
			}
			var authority = data[1].authority;
			var arr = authority.split("|");
//			if (currentRole == null)
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
			
			if((data[0].baseinfo.projectType).indexOf("0")!=-1){
				$('#imp_science').prop("checked",true);
			}
			if((data[0].baseinfo.projectType).indexOf("1")!=-1){
				$('#imp_project').prop("checked",true);
			}
			if((data[0].baseinfo.projectType).indexOf("2")!=-1){
				$('#orther_type').prop("checked",true);
			}
		}
	});
	
}
function updatecxtdDoc01(){
	//定义对象
	var cxtdDoc01 = {};
	var CxtdBaseInfo = {};
	var CxtdLeaderinfo = {};
	var CxtdLeaderZuzhi = {};
	
	var CxtdMemNum = {};
	var arrZuzhi = [];
	var arrMemInfo = [];
	var type;
	if($('#imp_science').is(':checked')){
		type = "0"
	}
	if($('#imp_project').is(':checked')){
		type += "1"
	}
	if($('#orther_type').is(':checked')){
		type += "2"
	}
	
	//团队基本信息
	CxtdBaseInfo.id = $('#baseinfoid').val();
	CxtdBaseInfo.teamName = $('#teamName').val();
	CxtdBaseInfo.researchDirection = $('#sub_dir').val();
	CxtdBaseInfo.subordinateSubject1 = $('#sub_1').val();
	CxtdBaseInfo.subordinateSubject2 = $('#sub_2').val();
	CxtdBaseInfo.projectType = type;
	CxtdBaseInfo.orther = $('#orther').val();
	CxtdBaseInfo.projectSource = $('#project_from').val();
	CxtdBaseInfo.projectName = $('#project_name').val();
	CxtdBaseInfo.unitName = $('#unit_name').val();
	CxtdBaseInfo.organizationCode = $('#org_code').val();
	CxtdBaseInfo.legalRepresentative = $('#legal_rep').val();
	CxtdBaseInfo.competentDepartment = $('#competent_dep').val();
	CxtdBaseInfo.unitAddresses = $('#unit_add').val();
	CxtdBaseInfo.zipCode = $('#zip_code').val();
	CxtdBaseInfo.contacts = $('#contacts').val();
	CxtdBaseInfo.mobilePhone = $('#mobile_phone').val();
	CxtdBaseInfo.fax = $('#fax').val();
	CxtdBaseInfo.email = $('#t_email').val();
	CxtdBaseInfo.telephone = $('#telephone').val();
	CxtdBaseInfo.teamId = $('#teamID').val();
	CxtdBaseInfo.userid = user_id;
	CxtdBaseInfo.status = 0;
	//团队负责人信息
	CxtdLeaderinfo.id = $('#leaderid').val();
	CxtdLeaderinfo.teamId = $('#teamId').val();
	CxtdLeaderinfo.name = $('#leaderName').val();
	CxtdLeaderinfo.sex = $('#leaderSex').val();
	CxtdLeaderinfo.country = $('#leaderCountry').val();
	CxtdLeaderinfo.minzu = $('#leaderNation').val();
	CxtdLeaderinfo.position = $('#leaderTechnical_position').val();
	CxtdLeaderinfo.birthday = $('#leaderBirthday').val();
	CxtdLeaderinfo.documentType = $('#leaderId_type').val();
	CxtdLeaderinfo.documentNumber = $('#leaderId_num').val();
	CxtdLeaderinfo.direction = $('#leaderProfessional_direction').val();
	CxtdLeaderinfo.subordinateSubject1 = $('#leaderSubject1').val();
	CxtdLeaderinfo.subordinateSubject2 = $('#leaderSubject2').val();
	CxtdLeaderinfo.telephoneFax = $('#leaderFax').val();
	CxtdLeaderinfo.mobilePhone = $('#leaderPhone').val();
	CxtdLeaderinfo.email = $('#leaderEmail').val();
	CxtdLeaderinfo.zipCode = $('#leaderZip_code').val();
	CxtdLeaderinfo.addresses = $('#leaderAddress').val();
	
	CxtdLeaderinfo.study_country = $('#study_country').val();
	CxtdLeaderinfo.study_colleges = $('#study_colleges').val();
	CxtdLeaderinfo.study_major = $('#study_major').val();
	CxtdLeaderinfo.study_education = $('#study_education').val();
	CxtdLeaderinfo.study_start_time = $('#study_start_time').val();
	CxtdLeaderinfo.study_end_time = $('#study_end_time').val();
	
	CxtdLeaderinfo.user_studcountry2 = $('#user_studcountry2').val();
	CxtdLeaderinfo.user_studcollege2 = $('#user_studcollege2').val();
	CxtdLeaderinfo.user_studmajor2 = $('#user_studmajor2').val();
	CxtdLeaderinfo.user_studdegree2 = $('#user_studdegree2').val();
	CxtdLeaderinfo.user_studfirsttime2 = $('#user_studfirsttime2').val();
	CxtdLeaderinfo.user_studlasttime2 = $('#user_studlasttime2').val();
	
	CxtdLeaderinfo.work_country = $('#user_workcountry').val();
	CxtdLeaderinfo.work_company = $('#user_workcollege').val();
	CxtdLeaderinfo.work_position = $('#user_workmajor').val();
	CxtdLeaderinfo.work_start_time = $('#work_starttime').val();
	CxtdLeaderinfo.work_end_time = $('#work_endtime').val();
	
	CxtdLeaderinfo.user_workcountry = $('#work_country').val();
	CxtdLeaderinfo.user_workcollege = $('#work_company').val();
	CxtdLeaderinfo.user_workmajor = $('#work_position').val();
	CxtdLeaderinfo.work_starttime = $('#work_start_time').val();
	CxtdLeaderinfo.work_endtime = $('#work_end_time').val();
	
	CxtdLeaderinfo.journal_title = $('#journal_title').val();
	CxtdLeaderinfo.organization_position = $('#organization_position').val();
	CxtdLeaderinfo.organization_term = $('#organization_term').val();
	
	CxtdLeaderinfo.journal_title1 = $('#journal_title1').val();
	CxtdLeaderinfo.organization_position1 = $('#organization_position1').val();
	CxtdLeaderinfo.organization_term1 = $('#organization_term1').val();
	
	CxtdLeaderinfo.journal_title2 = $('#journal_title2').val();
	CxtdLeaderinfo.organization_position2 = $('#organization_position2').val();
	CxtdLeaderinfo.organization_term2 = $('#organization_term2').val();
	
	
	
	
	//组织期刊
	for(var i = 0 ; i <= index_zuzhi-1; i++){ 
		CxtdLeaderZuzhi.id =$('#zuzhi_id'+i).val();
		CxtdLeaderZuzhi.name=$('#zuzhi_name'+i).val();
		CxtdLeaderZuzhi.job = $('#zuzhi_job'+i).val();
		CxtdLeaderZuzhi.renqi= $('#zuzhi_renqi'+i).val();
		arrZuzhi[i] = CxtdLeaderZuzhi;
	}
	//创新团队人数分类统计
	CxtdMemNum.num = $('#member_num').val();
	CxtdMemNum.team_id = $('#teamId').val();
	CxtdMemNum.age_56 = $('#age56').val();
	CxtdMemNum.age_46_55 = $('#age46_55').val();
	CxtdMemNum.age_36_45 = $('#age36_45').val();
	CxtdMemNum.age_35 = $('#age35').val();
	CxtdMemNum.gaoji = $('#gaoji').val();
	CxtdMemNum.fugao = $('#fugao').val();
	CxtdMemNum.zhongji = $('#zhongji').val();
	CxtdMemNum.z_orther = $('#z_orther').val();
	CxtdMemNum.boshi = $('#boshi').val();
	CxtdMemNum.shuoshi =$('#shuoshi').val();
	CxtdMemNum.benke = $('#benke').val();
	CxtdMemNum.x_orther = $('#x_orther').val();
	//团队成员信息
	for(var i = 0 ; i <= index_meminfo; i++){
		var CxtdMemberInfo ={};
		CxtdMemberInfo.id = $('#chenyuanid'+i).val();
		CxtdMemberInfo.name = $('#chengyuanname'+i).val();
		CxtdMemberInfo.sex = $('#chnengyuansex'+i).val();
		CxtdMemberInfo.birthday = $('#chengyuanbir'+i).val();
		CxtdMemberInfo.id_type = $('#chengyuantype'+i).val();
		CxtdMemberInfo.id_num = $('#chengyuannum'+i).val();
		CxtdMemberInfo.study_education = $('#chengyuanedu'+i).val();
		CxtdMemberInfo.work_position = $('#chengyuanp'+i).val();
		CxtdMemberInfo.direction = $('#chengs'+i).val();
		CxtdMemberInfo.work_company = $('#chengyuancompany'+i).val();
		arrMemInfo.push(CxtdMemberInfo);
	}
	var baseInfo = JSON.stringify(CxtdBaseInfo);
	var leaderInfo = JSON.stringify(CxtdLeaderinfo);
	var zList = JSON.stringify(arrZuzhi);
	var mList = JSON.stringify(arrMemInfo);
	var memNum = JSON.stringify(CxtdMemNum);
	
	//var cxtddoc01 = JSON.stringify(cxtdDoc01);
	$.ajax({
		type:'POST',
		dataType:'json',
		data:{"baseinfo":baseInfo,"leaderinfo":leaderInfo,"zuzhis":zList,"meminfos":mList,"memnum":memNum},
		url:'cxtdDoc01Update',
		error:function(){
			alert("connect error!");
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

function Member(index){
	for(var i = 0 ; i < index ; i++){
		var addMem_div = '</tr><tr style="page-break-inside: avoid" id = "memberinfo'+i+'">'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengyuanname'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chnengyuansex'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengyuanbir'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengyuantype'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengyuannum'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
	    +'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengyuanedu'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengyuanp'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengs'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="chengyuancompany'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>';
	if( i == 0){
		$('#memberinfo_div').after(addMem_div);
	}
	else{
		$('#memberinfo'+(i-1)).after(addMem_div);
	}
	}
}

//function Work(index){
//	var flag = index;
//	for( var i = 0 ; i < flag ; i++){
//		var addWork_div='<tr style="page-break-inside: avoid;" id="work_index"'+i+'>'
//			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//			+'<input type="text" id="work_country'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td>'
//			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//			+'<input type="text" id="work_institution'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//			+'<input type="text" id="work_position'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//			+'<input type="text" id="work_start_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//			+'<td width=84  colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//			+'<input type="text" id="work_end_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td></tr>';
//		if(i == 0){
//			$('#work').after(addWork_div);
//		}
//		else{
//			$('#work_index'+(i-1)).after(addWork_div);
//			
//		}
//	}
//	
//}
//function Study(index){
//	var flag = index;
//	for(var i = 0 ; i < flag ; i++){
//		var addStudy_div='<tr style="page-break-inside: avoid" id=study_index'+i+'>'
//		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="study_country'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="study_institution'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="study_position'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="degree'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="study_start_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
//		+'<td width=42 style="width: 31pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="study_end_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td></tr>';
//	if(i == 0){
//		$('#study').after(addStudy_div);
//	}
//	else{
//		$('#study_index'+(i-1)).after(addStudy_div);
//		}
//	}
//}
//function Zhuzhi(index){
//	var flag = index;
//	for(var i = 0 ; i < flag ; i++){
//		var addZhuzhi_div='<tr><input type="hidden" id=zuzhi_id'+i+'/></tr>'
//		+'<tr style="page-break-inside: avoid" id=zuzhi_div'+i+'><td width=487 colspan=3 valign=top style="width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 30pt">'
//		+'<input type="text" id="zuzhi_name'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/> '
//		+'</td><td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="zuzhi_job'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/>'
//		+'</td><td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//		+'<input type="text" id="zuzhi_renqi'+i+'"style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td></tr>';
//	if(i == 0){
//		$('#zhuzhi').after(addZhuzhi_div);
//	}
//	else{
//		$('#zuzhi_div'+(i-1)).after(addZhuzhi_div);
//	}
//	}
//}

//function addzuzhi(){
//	alert("addzuzhi");
//	var flag = index_zuzhi+1;
//	
//	var addZhuzhi_div='<tr><input type="hidden" id=zuzhi_id'+flag+'/></tr>'
//	+'<tr style="page-break-inside: avoid" id=zuzhi_div'+flag+'><td width=487 colspan=3 valign=top style="width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 30pt">'
//	+'<input type="text" id="zuzhi_name'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/> '
//	+'</td><td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//	+'<input type="text" id="zuzhi_job'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/>'
//	+'</td><td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
//	+'<input type="text" id="zuzhi_renqi'+flag+'"style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td></tr>';
//	$('#zuzhi_div'+(index_zuzhi)).after(addZhuzhi_div);
//	index_zuzhi++;
//}
function addmember(){
	var flag = index_meminfo+1;
	if(flag >11){
		return ;
	}
	var add_div = '<tr><input type="hidden" id=chenyuanid'+flag+'/></tr>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengyuanname'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chnengyuansex'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengyuanbir'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengyuantype'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengyuannum'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
    +'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengyuanedu'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengyuanp'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengs'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
	+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="chengyuancompany'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>';
    if(index_meminfo == 0){
    	alert("tianji!")
    	$('#memberinfo_div').after(add_div);
    }
    else{
    	   // $('#memberinfo_div'+(index_meminfo)).after(add_div);
    	$('#memberinfo_div').after(add_div);
    }
    index_meminfo++;
	
}