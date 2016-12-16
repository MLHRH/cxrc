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
			$('#baseinfoid').val(data.baseinfo.id);
			$('#teamName').val(data.baseinfo.teamName);
			$('#sub_dir').val(data.baseinfo.researchDirection);
			$('#sub_1').val(data.baseinfo.subordinateSubject1);
			$('#sub_2').val(data.baseinfo.subordinateSubject2);
			$('#other').val(data.baseinfo.orther);
			$('#project_name').val(data.baseinfo.projectName);
			$('#project_from').val(data.baseinfo.projectSource);
			$('#unit_name').val(data.baseinfo.unitName);
			$('#org_code').val(data.baseinfo.organizationCode);
			$('#legal_rep').val(data.baseinfo.legalRepresentative);
			$('#competent_dep').val(data.baseinfo.competentDepartment);
			$('#unit_add').val(data.baseinfo.unitAddresses);
			$('#zip_code').val(data.baseinfo.zipCode);
			$('#contacts').val(data.baseinfo.contacts);
			$('#mobile_phone').val(data.baseinfo.mobilePhone);
			$('#t_email').val(data.baseinfo.email);
			$('#fax').val(data.baseinfo.fax);
			$('#telephone').val(data.baseinfo.telephone);
			$('#teamID').val(data.baseinfo.teamId)
			//team leader
			$('#leaderinfoid').val(data.leaderinfo.id);
			$('#leaderCountry').val(data.leaderinfo.country);
			$('#leaderName').val(data.leaderinfo.name);
			$('#leaderSex').val(data.leaderinfo.sex);
			$('#leaderNation').val(data.leaderinfo.minzu);
			$('#leaderTechnical_position').val(data.leaderinfo.position);
			$('#leaderBirthday').val(data.leaderinfo.birthday);
			$('#leaderId_type').val(data.leaderinfo.documentType);
			$('#leaderId_num').val(data.leaderinfo.documentNumber);
			$('#leaderProfessional_direction').val(data.leaderinfo.direction);
			$('#leaderSubject1').val(data.leaderinfo.subordinateSubject1);
			$('#leaderSubject2').val(data.leaderinfo.subordinateSubject2);
			$('#leaderAddress').val(data.leaderinfo.addresses);
			$('#leaderZip_code').val(data.leaderinfo.zipCode);
			$('#leaderFax').val(data.leaderinfo.telephoneFax);
			$('#leaderPhone').val(data.leaderinfo.mobilePhone);
			$('#leaderEmail').val(data.leaderinfo.email);
			//工作经历
			Work(data.wlist.length);
			for(var i = 0 ;i < (data.wlist).length;i++){
				$('#work_country'+i).val(data.wlist[i].country);
				$('#work_institution'+i).val(data.wlist[i].work_content);
				$('#work_position'+i).val(data.wlist[i].zhiwu);
				$('#work_start_date'+i).val(data.wlist[i].start_date);
				$('#work_end_date'+i).val(data.wlist[i].end_date);
			}
			//学习经历
			Study(data.plist.length);
			for(var i = 0 ;i< (data.plist).length;i++){
				$('#study_country'+i).val(data.plist[i].country);
				$('#study_institution'+i).val(data.plist[i].academy);
				$('#study_position'+i).val(data.plist[i].major);
				$('#study_start_date'+i).val(data.plist[i].start_date);
				$('#study_end_date'+i).val(data.plist[i].xueli);
				$('#degree'+i).val(data.plist[i].xueli);
			}
			//学术组织期刊任职情况
			Zhuzhi(data.zlist.length);
			for( index_zuzhi = 0; index_zuzhi < (data.zlist).length; index_zuzhi++){
				$('#zuzhi_id'+index_zuzhi).val(data.zlist[index_zuzhi].id);
				$('#zuzhi_name'+index_zuzhi).val(data.zlist[index_zuzhi].name);
				$('#zuzhi_job'+index_zuzhi).val(data.zlist[index_zuzhi].job);
				$('#zuzhi_renqi'+index_zuzhi).val(data.zlist[index_zuzhi].renqi);
			}
			//成员分类统计人数
			$('#memnumid').val(data.memnum.id);
			$('#member_num').val(data.memnum.num);
			$('#age56').val(data.memnum.age_56);
			$('#age46_55').val(data.memnum.age_46_55);
			$('#age36_45').val(data.memnum.age_36_45);
			$('#age35').val(data.memnum.age_35);
			$('#gaoji').val(data.memnum.gaoji);
			$('#fugao').val(data.memnum.fugao);
			$('#zhongji').val(data.memnum.zhongji);
			$('#z_orther').val(data.memnum.z_orther);
			$('#boshi').val(data.memnum.boshi);
			$('#shuoshi').val(data.memnum.shuoshi);
			$('#benke').val(data.memnum.benke);
			$('#x_orther').val(data.memnum.x_orther);
			
			//团队成员信息
			Member(data.mlist.length);
			for(index_meminfo = 0 ; index_meminfo<data.mlist.length; index_meminfo++){
				$('#chenyuanid'+index_meminfo).val(data.mlist[index_meminfo].id);
				$('#chengyuanname'+index_meminfo).val(data.mlist[index_meminfo].name);
				$('#chnengyuansex'+index_meminfo).val(data.mlist[index_meminfo].sex);
				$('#chengyuanbir'+index_meminfo).val(data.mlist[index_meminfo].birthday);
				$('#chengyuantype'+index_meminfo).val(data.mlist[index_meminfo].id_type);
				$('#chengyuannum'+index_meminfo).val(data.mlist[index_meminfo].id_num);
				$('#chengyuanedu'+index_meminfo).val(data.mlist[index_meminfo].study_education);
				$('#chengyuanp'+index_meminfo).val(data.mlist[index_meminfo].work_position);
				$('#chengs'+index_meminfo).val(data.mlist[index_meminfo].direction);
				$('#chengyuancompany'+index_meminfo).val(data.mlist[index_meminfo].work_company);
			}
			
			
			if((data.baseinfo.projectType).indexOf("0")!=-1){
				$('#imp_science').prop("checked",true);
			}
			if((data.baseinfo.projectType).indexOf("1")!=-1){
				$('#imp_project').prop("checked",true);
			}
			if((data.baseinfo.projectType).indexOf("2")!=-1){
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
	for(var i = 0 ; i <= index_meminfo-1; i++){
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
		+'<input type="text" id="#chengs'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="#chengyuancompany'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"   /></td>';
	if( i == 0){
		$('#memberinfo_div').after(addMem_div);
	}
	else{
		$('#memberinfo'+(i-1)).after(addMem_div);
	}
	}
}

function Work(index){
	var flag = index;
	for( var i = 0 ; i < flag ; i++){
		var addWork_div='<tr style="page-break-inside: avoid;" id="work_index"'+i+'>'
			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+'<input type="text" id="work_country'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td>'
			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+'<input type="text" id="work_institution'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+'<input type="text" id="work_position'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+'<input type="text" id="work_start_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
			+'<td width=84  colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
			+'<input type="text" id="work_end_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td></tr>';
		if(i == 0){
			$('#work').after(addWork_div);
		}
		else{
			$('#work_index'+(i-1)).after(addWork_div);
			
		}
	}
	
}
function Study(index){
	var flag = index;
	for(var i = 0 ; i < flag ; i++){
		var addStudy_div='<tr style="page-break-inside: avoid" id=study_index'+i+'>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="study_country'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="study_institution'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="study_position'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="degree'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
		+'<td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="study_start_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/></td>'
		+'<td width=42 style="width: 31pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="study_end_date'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td></tr>';
	if(i == 0){
		$('#study').after(addStudy_div);
	}
	else{
		$('#study_index'+(i-1)).after(addStudy_div);
		}
	}
}
function Zhuzhi(index){
	var flag = index;
	for(var i = 0 ; i < flag ; i++){
		var addZhuzhi_div='<tr><input type="hidden" id=zuzhi_id'+i+'/></tr>'
		+'<tr style="page-break-inside: avoid" id=zuzhi_div'+i+'><td width=487 colspan=3 valign=top style="width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 30pt">'
		+'<input type="text" id="zuzhi_name'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/> '
		+'</td><td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="zuzhi_job'+i+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/>'
		+'</td><td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
		+'<input type="text" id="zuzhi_renqi'+i+'"style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td></tr>';
	if(i == 0){
		$('#zhuzhi').after(addZhuzhi_div);
	}
	else{
		$('#zuzhi_div'+(i-1)).after(addZhuzhi_div);
	}
	}
}

function addzuzhi(){
	alert("addzuzhi");
	var flag = index_zuzhi+1;
	
	var addZhuzhi_div='<tr><input type="hidden" id=zuzhi_id'+flag+'/></tr>'
	+'<tr style="page-break-inside: avoid" id=zuzhi_div'+flag+'><td width=487 colspan=3 valign=top style="width: 365.5pt; border-top: none; border-left: none;  border: solid black 1.0pt;  padding: 0cm 5.0pt 0cm 5.0pt; height: 30pt">'
	+'<input type="text" id="zuzhi_name'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/> '
	+'</td><td width=84 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="zuzhi_job'+flag+'" style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px"/>'
	+'</td><td width=84 colspan=2 style="width: 62pt; border: solid black 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt; height: 30pt">'
	+'<input type="text" id="zuzhi_renqi'+flag+'"style="text-align: center; font-size: 14.0pt; font-family: 宋体; display: inline-block; height: 90%; width: 95%; padding: 0px; margin: 3px; border-radius: 0px" /></td></tr>';
	$('#zuzhi_div'+(index_zuzhi)).after(addZhuzhi_div);
	index_zuzhi++;
}
function addmember(){
	alert("addmember");
	var flag = index_meminfo+1;
	if(flag >15){
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