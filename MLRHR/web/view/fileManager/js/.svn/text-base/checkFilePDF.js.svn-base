function checkFilePDFSearchUser(user_id) {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'fileListAll?user_id=' + user_id + '&file_type=2',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。

					if (data.length > 0) {
						var curWwwPath = window.document.location.href;
						// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
						var pathName = window.document.location.pathname;
						var pos = curWwwPath.indexOf(pathName);
						// 获取主机地址，如： http://localhost:8083
						var localhostPaht = curWwwPath.substring(0, pos);
						// 获取带"/"的项目名，如：/uimcardprj

						var filename = "";
						var fileUrl = "";
						var myPDF = "";
						var prev = $("#PDF_prev");
						var next = $("#PDF_next");
						var selectNum = 0;
						filename = data[0].file_path.substring(data[0].file_path.lastIndexOf("/"));
						fileUrl = localhostPaht + "/attach" + filename;

						myPDF = new PDFObject({
									url : fileUrl,
									width : "760px",
									height : "500px"
								});
						if (myPDF.embed("pdfShow")) {
							var intro = $('#pdfShow');
							if (intro) {
								intro.addClass("embedded");
							}
						}
						prev.bind('click', function() {
									if (selectNum > 0) {
										selectNum--;
										filename = data[selectNum].file_path.substring(data[selectNum].file_path.lastIndexOf("/"));
										fileUrl = localhostPaht + "/attach" + filename;
										initPDF(fileUrl);
									}
								});
						next.bind('click', function() {
									if (selectNum < data.length - 1) {
										selectNum++;
										filename = data[selectNum].file_path.substring(data[selectNum].file_path.lastIndexOf("/"));
										fileUrl = localhostPaht + "/attach" + filename;

										initPDF(fileUrl);
									}
								});
					}
					else{
					$("#pdfShow").html("暂无内容！");
					$("#pdfShow").css("text-align","center");
					
					}

				}
			});
}
function initPDF(fileUrl) {
	myPDF = new PDFObject({
				url : fileUrl,
				width : "760px",
				height : "500px"
			});
	if (myPDF.embed("pdfShow")) {
		var intro = $('#pdfShow');
		if (intro) {
			intro.addClass("embedded");
		}
	}
}
