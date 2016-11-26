var contentName = "expertBase";
var user_id=0;
$(document).ready(function() {
	user_id = $("#userId").val();
	initExpertBase();
	$("#content").load("expertBase");
	$("#userBase").addClass("active");
	// 左侧导航添加选中效果
	$("#orderedlist li").click(function() {
		$("li").each(function() {
			$(this).removeClass("active");
		});
		$(this).addClass("active");
		contentName = $(this).attr("id");

		$("#content").load(contentName, function() {
			init(contentName);
		});
	});
	// 清除bootstrap modal缓存
	$('body').on('hidden', '.modal', function() {
		$(this).removeData('modal');
	});
	$('#myModal').on('hidden', function() {
		init(contentName);
	});
	$('#modalDoc02').live('hidden', function() {
		initDoc02();
	});
	$('#modalDoc03').live('hidden', function() {
		initDoc03();
	});
});

function init(contentName) {
	switch (contentName) {
	case "expertBase":
		initExpertBase();
		break;
	default:
		break;
	}
}