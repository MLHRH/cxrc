//申请ID
var newId = $('#newId').val();
var oTable = null;
var currentRole;
function initnewUpFile() {

	
		$("#test2").hide();
	var arrData = new Array();
	arrData.push({
				"name" : "newId",
				"value" : newId,
			});
//	arrData.push({
//		"name" : "applytype",
//		"value" : $('#apply_type').val(),
//	});
	$.ajax({
				type : 'get',
				dataType : 'json',
				data : arrData,
				url : "newshowUpLoadFile",// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					console.log(data)
					var authority = data[1].authority;
					var arr = authority.split("|");
					$("#test2").hide();
//					if (currentRole == null)
					var isUser = false;
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_PROFESSOR") {
								currentRole = "ROLE_PROFESSOR";
							}
						}
						
						if(currentRole == "ROLE_PROFESSOR" ){
							$("#test2").show();
						}
					intTables(data[0]);
				}
			});
}
function intTables(data){
	var tbody = document.getElementById("fileList");
	var b = tbody.childNodes
	$('#fileList').empty()
	if(data[0] != null){
		for(var i = 0 ; i < data.length ;i++){
			var tr = document.createElement("tr");
			var td1= document.createElement("td");
			var td2= document.createElement("td");
			var td3= document.createElement("td");
			tr.appendChild(td1);
			td1.innerText=data[i].oldfilename;
			tr.appendChild(td2);
			td2.innerText=data[i].upload_time;
			tr.appendChild(td3);
			if(currentRole == "ROLE_PROFESSOR"){
				td3.innerHTML =  "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='downLoadFile(" + data[i].id
				+ ")'><i class='icon-edit'></i>下载</a>"
				+"<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='delFile(" + data[i].id
				+ ")'><i class='icon-edit'></i>删除</a>";
			}else{
				td3.innerHTML = "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='downLoadFile(" + data[i].id
				+ ")'><i class='icon-edit'></i>下载</a>";
			}
			tbody.appendChild(tr);
			
		}
	}
}


function delFile(id){
	arrData = new Array();
	if ($("#applyId").val() != "") {
		arrData.push({
					"name" : "fileId",
					"value" : id
				});
		$.ajax({
			"dataType" : 'json',
			"type" : "get",
			"url" : "newdelFile",
			"data" : arrData,
			"success" : function(data) {
				layer.msg(data.msg)
				initnewUpFile();
			},
			"error":function(){
				layer.msg("删除失败")
			}
		});
	}
	else{
		generatenoty('center', '更新失败！', 'error');
	}
}
function downLoadFile(id){
	location.href = 'newdownloadfile?fileid=' + id;
}