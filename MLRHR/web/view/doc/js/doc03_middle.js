function initDoc03Middle() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc03Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					$('#ftPDF01').text(data.fileTypeNum01);
					$('#ftPDF02').text(data.fileTypeNum02);
					$('#ftPDF03').text(data.fileTypeNum03);
					$('#ftPDF04').text(data.fileTypeNum04);

				}
			});
}
