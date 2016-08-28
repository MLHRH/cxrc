function initDoc02() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc02Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					$('#userName').val(data.userName);
					$('#seriesName').val(data.seriesName);
					$('#professionalName').val(data.professionalName);
					$('#qualificationName').val(data.qualificationName);
					$('#ft01').text(data.fileTypeNum01);
					$('#ft02').text(data.fileTypeNum02);
					$('#ft03').text(data.fileTypeNum03);
					$('#ft04').text(data.fileTypeNum04);
					$('#ft05').text(data.fileTypeNum05);
					$('#ft06').text(data.fileTypeNum06);
					$('#ft07').text(data.fileTypeNum07);
					$('#ft08').text(data.fileTypeNum08);

				}
			});
}
function updateDoc02() {
	var arrData = new Array();
	arrData.push({
				"name" : "userId",
				"value" : user_id
			});
	arrData.push({
				"name" : "userName",
				"value" : $('#userName').val()
			});
	arrData.push({
				"name" : "seriesName",
				"value" : $('#seriesName').val()
			});
	arrData.push({
				"name" : "professionalName",
				"value" : $('#professionalName').val()
			});
	arrData.push({
				"name" : "qualificationName",
				"value" : $('#qualificationName').val()
			});
	$.ajax({
				"dataType" : 'json',
				"type" : "post",
				"url" : "zhichengDoc02Update",
				"data" : arrData,
				"success" : function(rst) {
					if (rst.result == 1) {
						noty({
									text : '附件8  保存完成！请继续完善其他信息！',
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
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
}
function checkFile(id) {
	if (id == null) {
		checkFileSearchUser(user_id);
		$("#modalDoc02Title").text("预览所有附件");
		$("#modalDoc02BodyId").load("checkFile");
		$('#modalDoc02').modal();
	} else {
	}
}
function uploadFile(type) {
	$("#modalDoc02Title").text("管理附件");
	switch (type) {
		case 1 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=1&userId=" + user_id);
			break;
		case 2 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=2&userId=" + user_id);
			break;
		case 3 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=3&userId=" + user_id);
			break;
		case 4 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=4&userId=" + user_id);
			break;
		case 5 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=5&userId=" + user_id);
			break;
		case 6 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=6&userId=" + user_id);
			break;
		case 7 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=7&userId=" + user_id);
			break;
		case 8 :
			$("#modalDoc02BodyId").load("uploadfile?ft=1&num=8&userId=" + user_id);
			break;
		default :
			break;
	}
	$('#modalDoc02').modal();
}
function downLoadFile_02() {
	// 生成PDF
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'downLoadFile?uploader_id=' + user_id + '&file_type=1',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) { // 请求成功后处理函数。
					if (rst.filename != "") {
						// alert('请求成功');
						var curWwwPath = window.document.location.href;
						// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
						var pathName = window.document.location.pathname;
						var pos = curWwwPath.indexOf(pathName);
						// 获取主机地址，如： http://localhost:8083
						var localhostPaht = curWwwPath.substring(0, pos);
						// 获取带"/"的项目名，如：/uimcardprj
						// var
						// projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
						var url = localhostPaht + "/exportFile/" + rst.filename;
						window.open(url, "_blank");
					}
				}
			});
}