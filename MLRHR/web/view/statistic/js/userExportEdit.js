function initUserExportEdit() {
	var now = new Date();
	var end = now.getFullYear() + "-" + ((now.getMonth() + 1) < 10 ? "0" + (now.getMonth() + 1) : (now.getMonth() + 1)) + "-" + (now.getDate() < 10 ? "0" + now.getDate() : now.getDate())
	$("#apply_date").val(end);
}
