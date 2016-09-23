var contentName = "userBase";
var user_id=0;
$(document).ready(function() {
	user_id = $("#userId").val();
	initUserBase();
	$("#content").load("userBase");
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
	case "userBase":
		initUserBase();
		break;
	case "userBaogao":
		initUserBaogao();
		break;
	case "userWork":
		initUserWork();
		break;
	case "userSkill":
		initUserSkill();
		break;
	case "userSkill_2":
		initUserSkill_2();
		break;
	case "userProject":
		initUserProject();
		break;
	case "userPeixun":
		initUserPeixun();
		break;
	case "userReport":
		initUserReport();
		break;
	case "userReport":
		initUserReport();
		break;
	case "userChengguo":
		initUserChengguo();
		break;
	case "userZhuanli":
		initUserZhuanli();
		break;
	case "userAward":
		initUserAward();
		break;
	case "userExam":
		initUserExam();
		break;
	case "doc02_middle":
		initDoc02Middle();
		break;
	case "doc03_middle":
		initDoc03Middle();
		break;
	default:
		break;
	}
}