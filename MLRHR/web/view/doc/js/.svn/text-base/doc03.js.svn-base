function initDoc03() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc03Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					$('#userName').val(data.userName);
					$('#seriesName').val(data.seriesName);
					$('#professionalName').val(data.professionalName);
					$('#qualificationName').val(data.qualificationName);
					$('#ftPDF01').text(data.fileTypeNum01);
					$('#ftPDF02').text(data.fileTypeNum02);
					$('#ftPDF03').text(data.fileTypeNum03);
					$('#ftPDF04').text(data.fileTypeNum04);

				}
			});
}
function updateDoc03() {
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
				"url" : "zhichengDoc03Update",
				"data" : arrData,
				"success" : function(rst) {
					if (rst.result == 1) {
						noty({
									text : '附件9 保存完成！请继续完善其他信息！',
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
function checkFilePDF(id) {
	if (id == null) {
		checkFilePDFSearchUser(user_id);
		$("#modalDoc03Title").text("预览所有附件");
		$("#modalDoc03BodyId").load("checkFilePDF");
		$('#modalDoc03').modal();
	} else {
	}
}
function uploadFilePDF(type) {
	$("#modalDoc03Title").text("管理附件");
	switch (type) {
		case 1 :
			$("#modalDoc03BodyId").load("uploadfile?ft=2&num=1&userId=" + user_id);
			break;
		case 2 :
			$("#modalDoc03BodyId").load("uploadfile?ft=2&num=2&userId=" + user_id);
			break;
		case 3 :
			$("#modalDoc03BodyId").load("uploadfile?ft=2&num=3&userId=" + user_id);
			break;
		case 4 :
			$("#modalDoc03BodyId").load("uploadfile?ft=2&num=4&userId=" + user_id);
			break;
		default :
			break;
	}
	$('#modalDoc03').modal();
}
function downLoadFile_03() {
	// 生成PDF
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'downLoadFile?uploader_id=' + user_id + '&file_type=2',// 请求的路径
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
