function initDoc02Middle() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'zhichengDoc02Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
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
