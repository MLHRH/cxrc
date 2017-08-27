//申请ID
var applyid;
var oTable = null;
var currentRole;
function initUpFile() {
	if(applyid != null){
		$("#applyid").val(applyid);		
	}

		$("#importBtn").hide();
	
	var arrData = new Array();
	arrData.push({
				"name" : "applyid",
				"value" : applyid,
			});
	$.ajax({
				type : 'get',
				dataType : 'json',
				data : arrData,
				url : "showUpLoadFile",// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var authority = data[1].authority;
					var arr = authority.split("|");
//					if (currentRole == null)
					var isUser = false;
						for (var i = 0; i < arr.length - 1; i++) {
							if (arr[i] == "ROLE_USER") {
								currentRole = "ROLE_USER";
							}
						}
						if(currentRole == "ROLE_USER"){
							$("#importBtn").show();
						}
					intTables(data[0]);
				}
			});
}
function intTables(data){
	var tbody = document.getElementById("fileList");
	var b = tbody.childNodes
	for(var i = 0;i<b.length ; i++){
		tbody.removeChild(b[i]);
	}
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
			if(currentRole != "ROLE_USER"){
				td3.innerHTML = "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='downLoadFile(" + data[i].id
				+ ")'><i class='icon-edit'></i>下载</a>";
			}
			else{
				td3.innerHTML =  "<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='downLoadFile(" + data[i].id
				+ ")'><i class='icon-edit'></i>下载</a>"
				+"<a class='btn btn-small btn-info'  style='margin: 2.5px;' href='javascript:void(0)' onClick='delFile(" + data[i].id
				+ ")'><i class='icon-edit'></i>删除</a>";
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
			"url" : "delFile",
			"data" : arrData,
			"success" : function(data) {
				if (data.status == 0) {
					noty({
						text : data.msg,
						type : 'success',
						dismissQueue : false,
						maxVisible:false,
						closeWith : ['click', 'button'],
						timeout : 3000,
						layout : 'top',
						callback : {
							afterClose : function() {
								initUpFile();
							}
						},
						theme : 'defaultTheme'
					});
				} else if (data.status == 1) {
					noty({
						text : data.msg,
						type : 'error',
						dismissQueue : false,
						maxVisible:false,
						closeWith : ['click', 'button'],
						timeout : 3000,
						layout : 'center',
						callback : {
							afterClose : function() {
								initUpFile();
							}
						},
						theme : 'defaultTheme'
					});
				} 
			}
		});
	}
	else{
		generatenoty('center', '更新失败！', 'error');
	}
}
function downLoadFile(id){
	location.href = 'downloadfile?fileid=' + id;
}