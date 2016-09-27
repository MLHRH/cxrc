function initUserExportEdit() {
	var now = new Date();
	var end = now.getFullYear() + "." + ((now.getMonth() + 1) < 10 ? "0" + (now.getMonth() + 1) : (now.getMonth() + 1)) + "." + (now.getDate() < 10 ? "0" + now.getDate() : now.getDate())
	$("#apply_date").val(end);
	if ($("#apply_name").val() != -1) {
		if ($("#apply_name").val() == "研究员") {
			$("#apply_userRank").val("正高");
		} else if ($("#apply_name").val() == "副研究员") {
			$("#apply_userRank").val("副高");
		}
	} else {
		$("#apply_userRank").val("副高/正高");
	}
}
