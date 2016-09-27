var colorArr = ["#FE0000", "#FF9821", "#FCFF00", "#A5E400", "#01DEFB", "#2084FE", "#AE20FF", "#FC20D8", "#7B1CDC"];
var numArr01 = [30, 10, 45, 25, 60, 30, 40];
var numArr02 = [50, 40, 45, 35, 60, 50, 30];
var bodyArr = ["地质力学研究所", "矿产资源研究所", "地质研究所", "国家地质实验测试中心", "水文地质环境地质研究所", "地球物理地球化学勘查研究所", "岩溶地质研究所"];
function initHrstatisticOfBody() {
	arrData = new Array();
	for (var i = 0; i < 7; i++) {
		arrData.push({
					value : numArr01[i] + numArr02[i],
					color : colorArr[i]
				});
	}
	var myDoughnut = new Chart(document.getElementById("canvas").getContext("2d")).Doughnut(arrData);
	initLegend();
}

/*
 * 增加右侧图例
 */
function initLegend() {
	var dom = $("#legend");
	dom.html("");
	var str = "";
	for (var i = 0; i < 7; i++) {
		str += "<div style='margin-bottom: 5px; font-family: 宋体'><span style='border-radius: 3px;background:" + colorArr[i] + "'>&nbsp;&nbsp;</span>&nbsp;" + bodyArr[i] + "(自然：" + numArr01[i]
				+ "，工程："+numArr02[i]+")" + "</div>";
	}
	dom.html(str);
}