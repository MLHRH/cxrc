var colorArr = ["#FE0000", "#FEA501", "#FFFF00", "#99CC33", "#028002", "#018080", "#0180FE", "#0443BC", "#800180", "#C41884","#008080"];
var numArr01 = [3500, 1200, 900, 800, 600, 400, 300, 200, 100, 50, 2200];
var status = "已通过";
function initHrstatistic() {
	init();
	initDataSelected();
	getData();
}
function init() {
	var activeLiId = $("#myTab .active").attr('id');
	if (activeLiId == "nav1") {
		status = "已通过";
	} else if (activeLiId == "nav2") {
		status = "未通过";
	} else if (activeLiId == "nav3") {
		status = "待审核";
	} else if (activeLiId == "nav4") {
		status = "终审中";
	}
}
function initDataSelected() {
	var now = new Date();
	var nowBack = new Date(now.getFullYear(), now.getMonth() + 1 - 5, now.getDate() + 1);

	var sYear = nowBack.getFullYear(); 
	var sMonth = nowBack.getMonth(); 
	var sDate = nowBack.getDate(); 
	
	var start = sYear + "-" + (sMonth < 10 ? "0" + sMonth : sMonth) + "-" + (sDate < 10 ? "0" + sDate : sDate)
	var end = now.getFullYear() + "-" + ((now.getMonth() + 1) < 10 ? "0" + (now.getMonth() + 1) : (now.getMonth() + 1)) + "-" + (sDate < 10 ? "0" + sDate : sDate)
	$("#startdate_buy").val(start);
	$("#enddate_buy").val(end);
}
function getData() {
	arrData = new Array();
	arrData.push({
				"name" : "startDate",
				"value" : $("#startdate_buy").val()
			});

	arrData.push({
				"name" : "endDate",
				"value" : $("#enddate_buy").val()
			});
	arrData.push({
				"name" : "body_id",
				"value" : body_id
			});
	arrData.push({
				"name" : "status",
				"value" : status
			});
	arrData.push({
		"name" : "apply_type",
		"value" : $("#apply_type").val()
	});
//	arrData.push({
//				"name" : "apply_name",
//				"value" : $("#apply_name").val()
//			});

	/*
	 * arrData.push({ "name" : "apply_rank", "value" : $("#apply_rank").val()
	 * });
	 */
	$.ajax({
				"dataType" : 'json',
				"type" : "post",
				"url" : "bodyselectByDate",
				"data" : arrData,
				"success" : function(data) {
					initHrstatisticPie(data[1]);
					initBodyListDataTables(data[0]);
				}
			});
}

function initHrstatisticPie(list) {
	var arrData1 = 0;
	var arrData2 = 0;
	var arrData3 = 0;
//	var arrData1_2 = 0;
//	var arrData2_2 = 0;
//	var arrData3_2 = 0;
//	var arrData4_2 = 0;

	if (list.length > 0) {
		for (var i = 0; i < list.length; i++) {
			switch (list[i].apply_type) {
				case "0" :
					arrData1++;
					break;
				case "1" :
					arrData2++;
					break;
				case "2" :
					arrData3++;
					break;
			}
//			switch (list[i].apply_name) {
//				case "基础地质" :
//					arrData1_2++;
//					break;
//				case "矿产地质" :
//					arrData2_2++;
//					break;
//				case "水工环" :
//					arrData3_2++;
//					break;
//				case "技术方法" :
//					arrData4_2++;
//					break;
//			}
		}
	}

	var paidData01 = [{
				value : arrData1,
				color : "#3D8E3F"
			}, {
				value : arrData2,
				color : "#F09E14"
			}, {
				value : arrData3,
				color : "#008080"
			}

	];
//	var paidData01_2 = [{
//				value : arrData1_2,
//				color : "#3D8E3F"
//			}, {
//				value : arrData2_2,
//				color : "#F09E14"
//			}, {
//				value : arrData3_2,
//				color : "#018080"
//			}, {
//				value : arrData4_2,
//				color : "#0180FE"
//			}];

	var myDoughnut = new Chart(document.getElementById("pie").getContext("2d")).Doughnut(paidData01);
	$("#pie").attr("width", "250");
	$("#pie").attr("height", "200");

	$("#arrData1").html(arrData1);
	$("#arrData2").html(arrData2);
	$("#arrData3").html(arrData3);

//	var myDoughnut_2 = new Chart(document.getElementById("pie_2").getContext("2d")).Doughnut(paidData01_2);
//	$("#pie_2").attr("width", "250");
//	$("#pie_2").attr("height", "200");
//
//	$("#arrData1_2").html(arrData1_2);
//	$("#arrData2_2").html(arrData2_2);
//	$("#arrData3_2").html(arrData3_2);
//	$("#arrData4_2").html(arrData4_2);
}

function setStatus(sta) {
	if (sta == 0) {
		$("#nav1").addClass("active")
		$("#nav2").removeClass("active")
		$("#nav3").removeClass("active")
		$("#nav4").removeClass("active")
		status = "已通过";
	} else if (sta == 1) {
		$("#nav2").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav3").removeClass("active")
		$("#nav4").removeClass("active")
		status = "未通过";
	} else if (sta == 2) {
		$("#nav3").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav2").removeClass("active")
		$("#nav4").removeClass("active")
		status = "待审核";
	} else if (sta == 3) {
		$("#nav4").addClass("active")
		$("#nav1").removeClass("active")
		$("#nav2").removeClass("active")
		$("#nav3").removeClass("active")
		status = "终审中";
	}
	getData();
}
// 生成PDF
function exportDoc07() {
	$('#myModal').modal('hide')
	arrData.push({
				"name" : "startDate",
				"value" : $("#startdate_buy").val()
			});

	arrData.push({
				"name" : "endDate",
				"value" : $("#enddate_buy").val()
			});
	arrData.push({
				"name" : "body_id",
				"value" : body_id
			});
	arrData.push({
				"name" : "status",
				"value" : status
			});
	arrData.push({
				"name" : "apply_type",
				"value" : $("#apply_type").val()
			});
	arrData.push({
				"name" : "apply_rank",
				"value" : $("#apply_rank").val()
			});
	arrData.push({
				"name" : "apply_userRank",
				"value" : $("#apply_userRank").val()
			});
	arrData.push({
				"name" : "apply_body",
				"value" : $("#apply_body").val()
			});
	arrData.push({
				"name" : "apply_userName",
				"value" : $("#apply_userName").val()
			});
	arrData.push({
				"name" : "apply_userMobile",
				"value" : $("#apply_userMobile").val()
			});
	arrData.push({
				"name" : "apply_date",
				"value" : $("#apply_date").val()
			});
	$.ajax({
				type : 'post',
				dataType : 'json',
				data : arrData,
				url : 'exportDoc07',// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) { // 请求成功后处理函数。
					if (rst.filename != "") {
						// alert('请求成功');
						var curWwwPath = window.document.location.href;
						// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
						var pathName = window.document.location.pathname;
						var pos = curWwwPath.indexOf(pathName);
						// 获取主机地址，如： http://localhost:8083
						var localhostPaht = curWwwPath.substring(0, pos);
						// 获取带"/"的项目名，如：/uimcardprj
						// var
						// projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
						var url = localhostPaht + "/exportFile/" + rst.filename;
						window.open(url, "_blank");
					}
				}
			});
}

function showModel() {
	$("#myModalSave").unbind("click");
	$("#myModalSave").click(function() {
				exportDoc07();
			});
	$("#myModalTitle").text("添加报表表头信息");
	$(".modal-body").load("userExportEdit", initUserExportEdit);
	$('#myModal').modal();
}
