function checkFileSearchUser(user_id) {
	$.ajax({
		type : 'get',
		dataType : 'json',
		url : 'fileListAll?user_id=' + user_id+'&file_type=1',// 请求的路径
		error : function() {// 请求失败处理函数
			alert('请求失败');
		},
		success : function(data) { // 请求成功后处理函数。
			var dom = $("#fade");
			dom.html("");
			var str = "";
			var imgID = new Image();
			var name = "";

			if (data.length > 0) {

				for (var i in data) {
					// imgID.src=data[i].file_path;
					name = data[i].file_path.substring(data[i].file_path
							.lastIndexOf("/"));
					imgID.src = "/attach/" + name;
					str += "<li><a href='"
							+ imgID.src
							+ "'  rel='zoom-width:794;zoom-height:570'  class='MagicZoomPlus'><img src="
							+ imgID.src
							+ "  alt='暂无图片'  width='794' height='570'  onload='AutoResizeImage(794,570,this)'/></a></li>";
				}

			} else {
				str += "<li><a href='images/nodata.png'  rel='zoom-width:794;zoom-height:570'  class='MagicZoomPlus'><img src='images/nodata.png'  alt='暂无图片'  width='794' height='570'  onload='AutoResizeImage(794,600,this)'/></a></li>";
			}

			dom.html(str);
			$('#fade').lightSlider({
						minSlide : 1,
						maxSlide : 1

					});
			MagicZoomPlus.refresh();
		}
	});
}
// 图片大小自动脚本，限制的最大宽和高
function AutoResizeImage(maxWidth, maxHeight, objImg) {
	var img = new Image();
	img.src = objImg.src;
	var hRatio;
	var wRatio;
	var Ratio = 1;
	var w = img.width;
	var h = img.height;
	wRatio = maxWidth / w;
	hRatio = maxHeight / h;
	if (maxWidth == 0 && maxHeight == 0) {
		Ratio = 1;
	} else if (maxWidth == 0) { //
		if (hRatio < 1)
			Ratio = hRatio;
	} else if (maxHeight == 0) {
		if (wRatio < 1)
			Ratio = wRatio;
	} else if (wRatio < 1 || hRatio < 1) {
		Ratio = (wRatio <= hRatio ? wRatio : hRatio);
	}
	if (Ratio < 1) {
		w = w * Ratio;
		h = h * Ratio;
	}
	objImg.height = h;
	objImg.width = w;
}