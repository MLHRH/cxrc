var objUser = new Object();
 
var userBaseInfor_id;


function initjcqnDoc02() {
	$.ajax({
				type : 'get',
				dataType : 'json',
				url : 'jcqnDoc02Init?userId=' + user_id,// 请求的路径
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(data) { // 请求成功后处理函数。
					var myDate = new Date();
					var year = myDate.getFullYear();
					var month = myDate.getMonth() + 1;
					var day = myDate.getDate();
					$('#currentDate').html(year + "年" + month + "月" + day + "日");
					$('#xuhao1').val(data[0][0].xuhao_id);
					$('#project_name1').val(data[0][0].entryName);
					$('#project_page1').val(data[0][0].projectNumber);
					$('#project_money1').val(data[0][0].funds);
					$('#start_end_date1').val(data[0][0].startStopTime);
					$('#project_character1').val(data[0][0].projectNature);
					$('#project_role1').val(data[0][0].role);
					
					$('#xuhao2').val(data[0][1].xuhao_id);
					$('#project_name2').val(data[0][1].entryName);
					$('#project_page2').val(data[0][1].projectNumber);
					$('#project_money2').val(data[0][1].funds);
					$('#start_end_date2').val(data[0][1].startStopTime);
					$('#project_character2').val(data[0][1].projectNature);
					$('#project_role2').val(data[0][1].role);
//					
					$('#xuhao3').val(data[0][2].xuhao_id);
					$('#project_name3').val(data[0][2].entryName);
					$('#project_page3').val(data[0][2].projectNumber);
					$('#project_money3').val(data[0][2].funds);
					$('#start_end_date3').val(data[0][2].startStopTime);
					$('#project_character3').val(data[0][2].projectNature);
					$('#project_role3').val(data[0][2].role);
					
					$('#xuhao4').val(data[0][3].xuhao_id);
					$('#project_name4').val(data[0][3].entryName);
					$('#project_page4').val(data[0][3].projectNumber);
					$('#project_money4').val(data[0][3].funds);
					$('#start_end_date4').val(data[0][3].startStopTime);
					$('#project_character4').val(data[0][3].projectNature);
					$('#project_role4').val(data[0][3].role);
					
					$('#xuhao5').val(data[0][4].xuhao_id);
					$('#project_name5').val(data[0][4].entryName);
					$('#project_page5').val(data[0][4].projectNumber);
					$('#project_money5').val(data[0][4].funds);
					$('#start_end_date5').val(data[0][4].startStopTime);
					$('#project_character5').val(data[0][4].projectNature);
					$('#project_role5').val(data[0][4].role);
					
					$('#xuhao6').val(data[0][5].xuhao_id);
					$('#project_name6').val(data[0][5].entryName);
					$('#project_page6').val(data[0][5].projectNumber);
					$('#project_money6').val(data[0][5].funds);
					$('#start_end_date6').val(data[0][5].startStopTime);
					$('#project_character6').val(data[0][5].projectNature);
					$('#project_role6').val(data[0][5].role);

					
					$('#02xuhao1').val(data[1][0].xuhao_id);
					$('#award_item_name1').val(data[1][0].awardItemName);
					$('#prize_name1').val(data[1][0].prizeName);
					$('#grade1').val(data[1][0].grade);
					$('#sort1').val(data[1][0].sort);
					$('#reward_time1').val(data[1][0].rewardTime);
					$('#grant_institution1').val(data[1][0].grantInstitution);
					
					$('#02xuhao2').val(data[1][1].xuhao_id);
					$('#award_item_name2').val(data[1][1].awardItemName);
					$('#prize_name2').val(data[1][1].prizeName);
					$('#grade2').val(data[1][1].grade);
					$('#sort2').val(data[1][1].sort);
					$('#reward_time2').val(data[1][1].rewardTime);
					$('#grant_institution2').val(data[1][1].grantInstitution);
					
					$('#02xuhao3').val(data[1][2].xuhao_id);
					$('#award_item_name3').val(data[1][2].awardItemName);
					$('#prize_name3').val(data[1][2].prizeName);
					$('#grade3').val(data[1][2].grade);
					$('#sort3').val(data[1][2].sort);
					$('#reward_time3').val(data[1][2].rewardTime);
					$('#grant_institution3').val(data[1][2].grantInstitution);
					
					$('#02xuhao4').val(data[1][3].xuhao_id);
					$('#award_item_name4').val(data[1][3].awardItemName);
					$('#prize_name4').val(data[1][3].prizeName);
					$('#grade4').val(data[1][3].grade);
					$('#sort4').val(data[1][3].sort);
					$('#reward_time4').val(data[1][3].rewardTime);
					$('#grant_institution4').val(data[1][3].grantInstitution);
//	TODO				
					
					$('#03xuhao1').val(data[10].xuhao_id);
					$('#thesis_topic1').val(data[10].thesisTopic);
					$('#author_sort1').val(data[10].authorSort);
					$('#journal_title1').val(data[10].journalTitle);
					$('#year_volume_pagenumber1').val(data[10].yearVolumePagenumber);
					$('#influence_factor1').val(data[10].influenceFactor);
					$('#sci_times1').val(data[10].sciTimes);
					
					$('#03xuhao2').val(data[11].xuhao_id);
					$('#thesis_topic2').val(data[11].thesisTopic);
					$('#author_sort2').val(data[11].authorSort);
					$('#journal_title2').val(data[11].journalTitle);
					$('#year_volume_pagenumber2').val(data[11].yearVolumePagenumber);
					$('#influence_factor2').val(data[11].influenceFactor);
					$('#sci_times2').val(data[11].sciTimes);
					
					$('#03xuhao3').val(data[12].xuhao_id);
					$('#thesis_topic3').val(data[12].thesisTopic);
					$('#author_sort3').val(data[12].authorSort);
					$('#journal_title3').val(data[12].journalTitle);
					$('#year_volume_pagenumber3').val(data[12].yearVolumePagenumber);
					$('#influence_factor3').val(data[12].influenceFactor);
					$('#sci_times3').val(data[12].sciTimes);
					
					$('#03xuhao4').val(data[13].xuhao_id);
					$('#thesis_topic4').val(data[13].thesisTopic);
					$('#author_sort4').val(data[13].authorSort);
					$('#journal_title4').val(data[13].journalTitle);
					$('#year_volume_pagenumber4').val(data[13].yearVolumePagenumber);
					$('#influence_factor4').val(data[13].influenceFactor);
					$('#sci_times4').val(data[13].sciTimes);
					
					$('#03xuhao5').val(data[14].xuhao_id);
					$('#thesis_topic5').val(data[14].thesisTopic);
					$('#author_sort5').val(data[14].authorSort);
					$('#journal_title5').val(data[14].journalTitle);
					$('#year_volume_pagenumber5').val(data[14].yearVolumePagenumber);
					$('#influence_factor5').val(data[14].influenceFactor);
					$('#sci_times5').val(data[14].sciTimes);
					
					$('#03xuhao6').val(data[15].xuhao_id);
					$('#thesis_topic6').val(data[15].thesisTopic);
					$('#author_sort6').val(data[15].authorSort);
					$('#journal_title6').val(data[15].journalTitle);
					$('#year_volume_pagenumber6').val(data[15].yearVolumePagenumber);
					$('#influence_factor6').val(data[15].influenceFactor);
					$('#sci_times6').val(data[15].sciTimes);
// TODO					
					
					$('#04xuhao1').val(data[16].xuhao_id);
					$('#patent_name1').val(data[16].patentName);
					$('#grant_number1').val(data[16].grantNumber);
					$('#inventor1').val(data[16].inventorSort);
					$('#type1').val(data[16].type);
					$('#authorized_time1').val(data[16].authorizedTime);
					$('#authorized_national1').val(data[16].authorizedNational);
					
					$('#04xuhao2').val(data[17].xuhao_id);
					$('#patent_name2').val(data[17].patentName);
					$('#grant_number2').val(data[17].grantNumber);
					$('#inventor2').val(data[17].inventorSort);
					$('#type2').val(data[17].type);
					$('#authorized_time2').val(data[17].authorizedTime);
					$('#authorized_national2').val(data[17].authorizedNational);
					
					$('#04xuhao3').val(data[18].xuhao_id);
					$('#patent_name3').val(data[18].patentName);
					$('#grant_number3').val(data[18].grantNumber);
					$('#inventor3').val(data[18].inventorSort);
					$('#type3').val(data[18].type);
					$('#authorized_time3').val(data[18].authorizedTime);
					$('#authorized_national3').val(data[18].authorizedNational);
					
					$('#04xuhao4').val(data[19].xuhao_id);
					$('#patent_name4').val(data[19].patentName);
					$('#grant_number4').val(data[19].grantNumber);
					$('#inventor4').val(data[19].inventorSort);
					$('#type4').val(data[19].type);
					$('#authorized_time4').val(data[19].authorizedTime);
					$('#authorized_national4').val(data[19].authorizedNational);
					
//TODO					
					$('#05xuhao1').val(data[20].xuhao_id);
					$('#report_name1').val(data[20].reportName);
					$('#meeting_name1').val(data[20].meetingName);
					$('#organizers1').val(data[20].organizers);
					$('#meeting_time1').val(data[20].meetingTime);
					$('#meetin1g_place1').val(data[20].meetingPlace);
					$('#report_type1').val(data[20].reportType);
					
					$('#05xuhao2').val(data[21].xuhao_id);
					$('#report_name2').val(data[21].reportName);
					$('#meeting_name2').val(data[21].meetingName);
					$('#organizers2').val(data[21].organizers);
					$('#meeting_time2').val(data[21].meetingTime);
					$('#meetin1g_place2').val(data[21].meetingPlace);
					$('#report_type2').val(data[21].reportType);
					
					$('#05xuhao3').val(data[22].xuhao_id);
					$('#report_name3').val(data[22].reportName);
					$('#meeting_name3').val(data[22].meetingName);
					$('#organizers3').val(data[22].organizers);
					$('#meeting_time3').val(data[22].meetingTime);
					$('#meetin1g_place3').val(data[22].meetingPlace);
					$('#report_type3').val(data[22].reportType);
					
					$('#05xuhao4').val(data[23].xuhao_id);
					$('#report_name4').val(data[23].reportName);
					$('#meeting_name4').val(data[23].meetingName);
					$('#organizers4').val(data[23].organizers);
					$('#meeting_time4').val(data[23].meetingTime);
					$('#meetin1g_place4').val(data[23].meetingPlace);
					$('#report_type4').val(data[23].reportType);
//		TODO			
					
					$('#06xuhao1').val(data[24].xuhao_id);
					$('#treatise_name1').val(data[24].treatiseName);
					$('#press1').val(data[24].press);
					$('#issuing_country1').val(data[24].issuingCountry);
					$('#year1').val(data[24].year);
					
					$('#06xuhao2').val(data[25].xuhao_id);
					$('#treatise_name2').val(data[25].treatiseName);
					$('#press2').val(data[25].press);
					$('#issuing_country2').val(data[25].issuingCountry);
					$('#year2').val(data[25].year);
					
					$('#06xuhao3').val(data[26].xuhao_id);
					$('#treatise_name3').val(data[26].treatiseName);
					$('#press3').val(data[26].press);
					$('#issuing_country3').val(data[26].issuingCountry);
					$('#year3').val(data[26].year);
					
					
 
				}
			});
}
function updateDoc02() {
	var count = 0 ;
	arrData = new Array();	
	for(var i=1;i<= 6;i++){
		var project = new Object();
		project.id = $('#xuhao'+i).val();
		project.project_name = $('#project_name'+i).val();
		arrData[count++] = project;
	}
	arrData.push({
		"name" : "project",
		"value" : arrData
	});
	arrData.push({
				"name" : "userId",
				"value" : userId
			});
	arrData.push({
				"name" : "id",
				"value" : $("#xuhao1").val()
			});
	arrData.push({
				"name" : "entryName",
				"value" : $("#project_name1").val()
			});
	arrData.push({
				"name" : "projectNumber",
				"value" : $("#project_page1").val()
			});
	arrData.push({
				"name" : "funds",
				"value" : $("#project_money1").val()
			});
	
		arrData.push({
			"name" : "startStopTime",
			"value" : $("#start_end_date1").val()
		});
	arrData.push({
				"name" : "projectNature",
				"value" : $("#project_character1").val()
			});

	arrData.push({
		"name" : "role",
		"value" : $("#project_role1").val()
	});
	
	
	arrData.push({
		"name" : "id",
		"value" : $("#xuhao2").val()
	});
arrData.push({
		"name" : "entryName",
		"value" : $("#project_name2").val()
	});
arrData.push({
		"name" : "projectNumber",
		"value" : $("#project_page2").val()
	});
arrData.push({
		"name" : "funds",
		"value" : $("#project_money2").val()
	});
arrData.push({
		"name" : "startStopTime",
		"value" : $("#start_end_date2").val()
	});
arrData.push({
		"name" : "projectNature",
		"value" : $("#project_character2").val()
	});

arrData.push({
"name" : "role",
"value" : $("#project_role2").val()
});
	
arrData.push({
	"name" : "id",
	"value" : $("#xuhao3").val()
});
arrData.push({
	"name" : "entryName",
	"value" : $("#project_name3").val()
});
arrData.push({
	"name" : "projectNumber",
	"value" : $("#project_page3").val()
});
arrData.push({
	"name" : "funds",
	"value" : $("#project_money3").val()
});

	arrData.push({
		"name" : "startStopTime",
		"value" : $("#start_end_date3").val()
	});
arrData.push({
	"name" : "projectNature",
	"value" : $("#project_character3").val()
});

arrData.push({
"name" : "role",
"value" : $("#project_role3").val()
});
	
	
	
arrData.push({
	"name" : "id",
	"value" : $("#xuhao4").val()
});
arrData.push({
	"name" : "entryName",
	"value" : $("#project_name4").val()
});
arrData.push({
	"name" : "projectNumber",
	"value" : $("#project_page4").val()
});
arrData.push({
	"name" : "funds",
	"value" : $("#project_money4").val()
});

	arrData.push({
		"name" : "startStopTime",
		"value" : $("#start_end_date4").val()
	});
arrData.push({
	"name" : "projectNature",
	"value" : $("#project_character4").val()
});

arrData.push({
"name" : "role",
"value" : $("#project_role4").val()
});
	
arrData.push({
	"name" : "id",
	"value" : $("#xuhao5").val()
});
arrData.push({
	"name" : "entryName",
	"value" : $("#project_name5").val()
});
arrData.push({
	"name" : "projectNumber",
	"value" : $("#project_page5").val()
});
arrData.push({
	"name" : "funds",
	"value" : $("#project_money5").val()
});

	arrData.push({
		"name" : "startStopTime",
		"value" : $("#start_end_date5").val()
	});
arrData.push({
	"name" : "projectNature",
	"value" : $("#project_character5").val()
});

arrData.push({
"name" : "role",
"value" : $("#project_role5").val()
});
	
arrData.push({
	"name" : "id",
	"value" : $("#xuhao6").val()
});
arrData.push({
	"name" : "entryName",
	"value" : $("#project_name6").val()
});
arrData.push({
	"name" : "projectNumber",
	"value" : $("#project_page6").val()
});
arrData.push({
	"name" : "funds",
	"value" : $("#project_money6").val()
});

	arrData.push({
		"name" : "startStopTime",
		"value" : $("#start_end_date6").val()
	});
arrData.push({
	"name" : "projectNature",
	"value" : $("#project_character6").val()
});

arrData.push({
"name" : "role",
"value" : $("#project_role6").val()
});
	

arrData.push({
	"name" : "id",
	"value" : $("#02xuhao1").val()
	});
		
	arrData.push({
		"name" : "awardItemName",
		"value" : $("#award_item_name1").val()
	});
	arrData.push({
		"name" : "prizeName",
		"value" : $("#prize_name1").val()
	});
	arrData.push({
		"name" : "grade",
		"value" : $("#grade1").val()
	});
	arrData.push({
		"name" : "sort",
		"value" : $("#sort1").val()
	});

		arrData.push({
			"name" : "rewardTime",
			"value" : $("#reward_time1").val()
		});
	arrData.push({
		"name" : "grantInstitution",
		"value" : $("#grant_institution1").val()
	});

	arrData.push({
		"name" : "id",
		"value" : $("#02xuhao2").val()
		});
			
		arrData.push({
			"name" : "awardItemName",
			"value" : $("#award_item_name2").val()
		});
		arrData.push({
			"name" : "prizeName",
			"value" : $("#prize_name2").val()
		});
		arrData.push({
			"name" : "grade",
			"value" : $("#grade2").val()
		});
		arrData.push({
			"name" : "sort",
			"value" : $("#sort2").val()
		});
	
			arrData.push({
				"name" : "rewardTime",
				"value" : $("#reward_time2").val()
			});
		arrData.push({
			"name" : "grantInstitution",
			"value" : $("#grant_institution2").val()
		});	
	
	
		arrData.push({
			"name" : "id",
			"value" : $("#02xuhao3").val()
			});
				
			arrData.push({
				"name" : "awardItemName",
				"value" : $("#award_item_name3").val()
			});
			arrData.push({
				"name" : "prizeName",
				"value" : $("#prize_name3").val()
			});
			arrData.push({
				"name" : "grade",
				"value" : $("#grade3").val()
			});
			arrData.push({
				"name" : "sort",
				"value" : $("#sort3").val()
			});
	
				arrData.push({
					"name" : "rewardTime",
					"value" : $("#reward_time3").val()
				});
			arrData.push({
				"name" : "grantInstitution",
				"value" : $("#grant_institution3").val()
			});
	
	
			arrData.push({
				"name" : "id",
				"value" : $("#02xuhao4").val()
				});
					
				arrData.push({
					"name" : "awardItemName",
					"value" : $("#award_item_name4").val()
				});
				arrData.push({
					"name" : "prizeName",
					"value" : $("#prize_name4").val()
				});
				arrData.push({
					"name" : "grade",
					"value" : $("#grade4").val()
				});
				arrData.push({
					"name" : "sort",
					"value" : $("#sort4").val()
				});
	
					arrData.push({
						"name" : "rewardTime",
						"value" : $("#reward_time4").val()
					});
				arrData.push({
					"name" : "grantInstitution",
					"value" : $("#grant_institution4").val()
				});
	

				arrData.push({
					"name" : "id",
					"value" : $("#03xuhao1").val()
					});
						
					arrData.push({
						"name" : "thesisTopic",
						"value" : $("#thesis_topic1").val()
					});
					arrData.push({
						"name" : "authorSort",
						"value" : $("#author_sort1").val()
					});
					arrData.push({
						"name" : "journalTitle",
						"value" : $("#journal_title1").val()
					});
					arrData.push({
						"name" : "yearVolumePagenumber",
						"value" : $("#year_volume_pagenumber1").val()
					});
						arrData.push({
							"name" : "influenceFactor",
							"value" : $("#influence_factor1").val()
						});
					arrData.push({
						"name" : "sciTimes",
						"value" : $("#sci_times1").val()
					});
	
	
					arrData.push({
						"name" : "id",
						"value" : $("#03xuhao2").val()
						});
							
						arrData.push({
							"name" : "thesisTopic",
							"value" : $("#thesis_topic2").val()
						});
						arrData.push({
							"name" : "authorSort",
							"value" : $("#author_sort2").val()
						});
						arrData.push({
							"name" : "journalTitle",
							"value" : $("#journal_title2").val()
						});
						arrData.push({
							"name" : "yearVolumePagenumber",
							"value" : $("#year_volume_pagenumber2").val()
						});
							arrData.push({
								"name" : "influenceFactor",
								"value" : $("#influence_factor2").val()
							});
						arrData.push({
							"name" : "sciTimes",
							"value" : $("#sci_times2").val()
						});
	
						arrData.push({
							"name" : "id",
							"value" : $("#03xuhao3").val()
							});
								
							arrData.push({
								"name" : "thesisTopic",
								"value" : $("#thesis_topic3").val()
							});
							arrData.push({
								"name" : "authorSort",
								"value" : $("#author_sort3").val()
							});
							arrData.push({
								"name" : "journalTitle",
								"value" : $("#journal_title3").val()
							});
							arrData.push({
								"name" : "yearVolumePagenumber",
								"value" : $("#year_volume_pagenumber3").val()
							});
								arrData.push({
									"name" : "influenceFactor",
									"value" : $("#influence_factor3").val()
								});
							arrData.push({
								"name" : "sciTimes",
								"value" : $("#sci_times3").val()
							});
							
							arrData.push({
								"name" : "id",
								"value" : $("#03xuhao4").val()
								});
									
								arrData.push({
									"name" : "thesisTopic",
									"value" : $("#thesis_topic4").val()
								});
								arrData.push({
									"name" : "authorSort",
									"value" : $("#author_sort4").val()
								});
								arrData.push({
									"name" : "journalTitle",
									"value" : $("#journal_title4").val()
								});
								arrData.push({
									"name" : "yearVolumePagenumber",
									"value" : $("#year_volume_pagenumber4").val()
								});
									arrData.push({
										"name" : "influenceFactor",
										"value" : $("#influence_factor4").val()
									});
								arrData.push({
									"name" : "sciTimes",
									"value" : $("#sci_times4").val()
								});
							
								arrData.push({
									"name" : "id",
									"value" : $("#03xuhao5").val()
									});
										
									arrData.push({
										"name" : "thesisTopic",
										"value" : $("#thesis_topic5").val()
									});
									arrData.push({
										"name" : "authorSort",
										"value" : $("#author_sort5").val()
									});
									arrData.push({
										"name" : "journalTitle",
										"value" : $("#journal_title5").val()
									});
									arrData.push({
										"name" : "yearVolumePagenumber",
										"value" : $("#year_volume_pagenumber5").val()
									});
										arrData.push({
											"name" : "influenceFactor",
											"value" : $("#influence_factor5").val()
										});
									arrData.push({
										"name" : "sciTimes",
										"value" : $("#sci_times5").val()
									});				
							
									arrData.push({
										"name" : "id",
										"value" : $("#03xuhao6").val()
										});
											
										arrData.push({
											"name" : "thesisTopic",
											"value" : $("#thesis_topic6").val()
										});
										arrData.push({
											"name" : "authorSort",
											"value" : $("#author_sort6").val()
										});
										arrData.push({
											"name" : "journalTitle",
											"value" : $("#journal_title6").val()
										});
										arrData.push({
											"name" : "yearVolumePagenumber",
											"value" : $("#year_volume_pagenumber6").val()
										});
											arrData.push({
												"name" : "influenceFactor",
												"value" : $("#influence_factor6").val()
											});
										arrData.push({
											"name" : "sciTimes",
											"value" : $("#sci_times6").val()
										});					

										arrData.push({
											"name" : "id",
											"value" : $("#04xuhao1").val()
											});
												
											arrData.push({
												"name" : "patentName",
												"value" : $("#patent_name1").val()
											});
											arrData.push({
												"name" : "grantNumber",
												"value" : $("#grant_number1").val()
											});
											arrData.push({
												"name" : "inventorSort",
												"value" : $("#inventor1").val()
											});
											arrData.push({
												"name" : "type",
												"value" : $("#type1").val()
											});
												arrData.push({
													"name" : "authorizedTime",
													"value" : $("#authorized_time1").val()
												});
											arrData.push({
												"name" : "authorizedNational",
												"value" : $("#authorized_national1").val()
											});				
										

											arrData.push({
												"name" : "id",
												"value" : $("#04xuhao2").val()
												});
													
												arrData.push({
													"name" : "patentName",
													"value" : $("#patent_name2").val()
												});
												arrData.push({
													"name" : "grantNumber",
													"value" : $("#grant_number2").val()
												});
												arrData.push({
													"name" : "inventorSort",
													"value" : $("#inventor2").val()
												});
												arrData.push({
													"name" : "type",
													"value" : $("#type2").val()
												});
													arrData.push({
														"name" : "authorizedTime",
														"value" : $("#authorized_time2").val()
													});
												arrData.push({
													"name" : "authorizedNational",
													"value" : $("#authorized_national2").val()
												});		
												

												arrData.push({
													"name" : "id",
													"value" : $("#04xuhao3").val()
													});
														
													arrData.push({
														"name" : "patentName",
														"value" : $("#patent_name3").val()
													});
													arrData.push({
														"name" : "grantNumber",
														"value" : $("#grant_number3").val()
													});
													arrData.push({
														"name" : "inventorSort",
														"value" : $("#inventor3").val()
													});
													arrData.push({
														"name" : "type",
														"value" : $("#type3").val()
													});
														arrData.push({
															"name" : "authorizedTime",
															"value" : $("#authorized_time3").val()
														});
													arrData.push({
														"name" : "authorizedNational",
														"value" : $("#authorized_national3").val()
													});	

													arrData.push({
														"name" : "id",
														"value" : $("#04xuhao4").val()
														});
															
														arrData.push({
															"name" : "patentName",
															"value" : $("#patent_name4").val()
														});
														arrData.push({
															"name" : "grantNumber",
															"value" : $("#grant_number4").val()
														});
														arrData.push({
															"name" : "inventorSort",
															"value" : $("#inventor4").val()
														});
														arrData.push({
															"name" : "type",
															"value" : $("#type4").val()
														});
															arrData.push({
																"name" : "authorizedTime",
																"value" : $("#authorized_time4").val()
															});
														arrData.push({
															"name" : "authorizedNational",
															"value" : $("#authorized_national4").val()
														});		
												
//	TODO											
				arrData.push({
					"name" : "id",
					"value" : $("#05xuhao1").val()
				});
		arrData.push({
					"name" : "reportName",
					"value" : $("#report_name1").val()
				});
		arrData.push({
					"name" : "meetingName",
					"value" : $("#meeting_name1").val()
				});
		arrData.push({
					"name" : "organizers",
					"value" : $("#organizers1").val()
				});
		
			arrData.push({
				"name" : "meetingTime",
				"value" : $("#meeting_time1").val()
			});
		arrData.push({
					"name" : "meetingPlace",
					"value" : $("#meetin1g_place1").val()
				});

		arrData.push({
			"name" : "reportType",
			"value" : $("#report_type1").val()
		});			
				
				
				
		arrData.push({
			"name" : "id",
			"value" : $("#05xuhao2").val()
		});
arrData.push({
			"name" : "reportName",
			"value" : $("#report_name2").val()
		});
arrData.push({
			"name" : "meetingName",
			"value" : $("#meeting_name2").val()
		});
arrData.push({
			"name" : "organizers",
			"value" : $("#organizers2").val()
		});

	arrData.push({
		"name" : "meetingTime",
		"value" : $("#meeting_time2").val()
	});
arrData.push({
			"name" : "meetingPlace",
			"value" : $("#meetin1g_place2").val()
		});

arrData.push({
	"name" : "reportType",
	"value" : $("#report_type2").val()
});		
				
				
arrData.push({
	"name" : "id",
	"value" : $("#05xuhao3").val()
});
arrData.push({
	"name" : "reportName",
	"value" : $("#report_name3").val()
});
arrData.push({
	"name" : "meetingName",
	"value" : $("#meeting_name3").val()
});
arrData.push({
	"name" : "organizers",
	"value" : $("#organizers3").val()
});

arrData.push({
"name" : "meetingTime",
"value" : $("#meeting_time3").val()
});
arrData.push({
	"name" : "meetingPlace",
	"value" : $("#meetin1g_place3").val()
});

arrData.push({
"name" : "reportType",
"value" : $("#report_type3").val()
});		
				
				
arrData.push({
	"name" : "id",
	"value" : $("#05xuhao4").val()
});
arrData.push({
	"name" : "reportName",
	"value" : $("#report_name4").val()
});
arrData.push({
	"name" : "meetingName",
	"value" : $("#meeting_name4").val()
});
arrData.push({
	"name" : "organizers",
	"value" : $("#organizers4").val()
});

arrData.push({
"name" : "meetingTime",
"value" : $("#meeting_time4").val()
});
arrData.push({
	"name" : "meetingPlace",
	"value" : $("#meetin1g_place4").val()
});

arrData.push({
"name" : "reportType",
"value" : $("#report_type4").val()
});			
				
				
//	TODO

arrData.push({
	"name" : "id",
	"value" : $("#06xuhao1").val()
});
arrData.push({
	"name" : "treatiseName",
	"value" : $("#treatise_name1").val()
});
arrData.push({
	"name" : "press",
	"value" : $("#press1").val()
});
arrData.push({
	"name" : "issuingCountry",
	"value" : $("#issuing_country1").val()
});

arrData.push({
"name" : "year",
"value" : $("#year1").val()
});

arrData.push({
	"name" : "id",
	"value" : $("#06xuhao2").val()
});
arrData.push({
	"name" : "treatiseName",
	"value" : $("#treatise_name2").val()
});
arrData.push({
	"name" : "press",
	"value" : $("#press2").val()
});
arrData.push({
	"name" : "issuingCountry",
	"value" : $("#issuing_country2").val()
});

arrData.push({
"name" : "year",
"value" : $("#year2").val()
});
arrData.push({
	"name" : "id",
	"value" : $("#06xuhao3").val()
});
arrData.push({
	"name" : "treatiseName",
	"value" : $("#treatise_name3").val()
});
arrData.push({
	"name" : "press",
	"value" : $("#press3").val()
});
arrData.push({
	"name" : "issuingCountry",
	"value" : $("#issuing_country3").val()
});

arrData.push({
"name" : "year",
"value" : $("#year3").val()
});



	
	$.ajax({
				dataType : "json",
				type : "post",
				url : "jcqnDoc02Update",
				data : {"project":arrData},
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) {
					if (rst.result == 1) {

					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
	// user
	/*arrData = new Array();
	arrData.push({
				"name" : "id",
				"value" : user_id
			});
	arrData.push({
				"name" : "name",
				"value" : $("#userName2").val()
			});
	arrData.push({
				"name" : "id_num",
				"value" : id_num
			});
	arrData.push({
				"name" : "body_id",
				"value" : body_id
			});
	arrData.push({
				"name" : "telephone",
				"value" : telephone
			});
	arrData.push({
				"name" : "telefax",
				"value" : telefax
			});
	arrData.push({
				"name" : "mobile",
				"value" : mobile
			});
	arrData.push({
				"name" : "email",
				"value" : email
			});

	$.ajax({
				dataType : "json",
				type : "post",
				url : "updateUser",
				data : arrData,
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) {
					if (rst.result == 1) {

					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});
	arrData = new Array();
	arrData.push({
				"name" : "id",
				"value" : userBaseInfor_id
			});
	arrData.push({
				"name" : "user_id",
				"value" : user_id
			});
	 
	arrData.push({
				"name" : "gender",
				"value" : $("input[name='user_gender']:checked").val()
			});
	if ($("#user_birthday").val() != "")
		arrData.push({
					"name" : "birthday",
					"value" : $("#user_birthday").val()
				});
	arrData.push({
				"name" : "cardcode",
				"value" : $("#user_cardcode").val()
			});
	arrData.push({
				"name" : "jishuzhicheng",
				"value" : $("#user_jishuzhicheng").val()
			});
	arrData.push({
				"name" : "minzu",
				"value" : $("#user_minzu").val()
			});
	 
		arrData.push({
					"name" : "cardtype",
					"value" : $("#user_cardtype").val()
				});
	arrData.push({
				"name" : "yanjiufangxiang",
				"value" : $("#user_yanjiufangxiang").val()
			});
	arrData.push({
				"name" : "shenbaolingyu",
				"value" : $("#user_shenbaolingyu").val()
			});
	arrData.push({
				"name" : "workphone",
				"value" : $("#user_workphone").val()
			});
	arrData.push({
				"name" : "chuanzhen",
				"value" : $("#user_chaunzhen").val()
			});
	arrData.push({
				"name" : "telephone",
				"value" : $("#user_telephone").val()
			});
	 
	arrData.push({
				"name" : "email",
				"value" : $("#user_email").val()
			});
	arrData.push({
				"name" : "postcord",
				"value" : $("#user_postcord").val()
			});
	arrData.push({
				"name" : "addr",
				"value" : $("#user_addr").val()
			});
	arrData.push({
		"name" : "studcountry",
		"value" : $("#user_studcountry").val()
	});
arrData.push({
		"name" : "studcollege",
		"value" : $("#studcollege").val()
	});
arrData.push({
		"name" : "studmajor",
		"value" : $("#user_studmajor").val()
	});
arrData.push({
		"name" : "studdegree",
		"value" : $("#user_studdegree").val()
	});
	
	arrData.push({
				"name" : "studfirsttime",
				"value" : $("#user_studfirsttime").val()
			});
	arrData.push({
		"name" : "studlasttime",
		"value" : $("#user_studlasttime").val()
	});
	arrData.push({
		"name" : "studcountry2",
		"value" : $("#user_studcountry2").val()
	});
arrData.push({
		"name" : "studcollege2",
		"value" : $("#studcollege2").val()
	});
arrData.push({
		"name" : "studmajor2",
		"value" : $("#user_studmajor2").val()
	});
arrData.push({
		"name" : "studdegree2",
		"value" : $("#user_studdegree2").val()
	});
	
	arrData.push({
				"name" : "studfirsttime2",
				"value" : $("#user_studfirsttime2").val()
			});
	arrData.push({
		"name" : "studlasttime2",
		"value" : $("#user_studlasttime2").val()
	});
	arrData.push({
		"name" : "workcountry",
		"value" : $("#user_workcountry").val()
	});
arrData.push({
		"name" : "workcollege",
		"value" : $("#workcollege").val()
	});
arrData.push({
		"name" : "workmajor",
		"value" : $("#user_workmajor").val()
	});
arrData.push({
		"name" : "workdegree",
		"value" : $("#user_workdegree").val()
	});
	
	arrData.push({
				"name" : "workfirsttime",
				"value" : $("#user_workfirsttime").val()
			});
	arrData.push({
		"name" : "worklasttime",
		"value" : $("#user_worklasttime").val()
	});
	arrData.push({
		"name" : "workboard1",
		"value" : $("#user_workboard1").val()
	});
	
	arrData.push({
				"name" : "zhiwu1",
				"value" : $("#user_zhiwu1").val()
			});
	arrData.push({
		"name" : "renqi1",
		"value" : $("#user_renqi1").val()
	});
	
	 
	arrData.push({
		"name" : "workboard2",
		"value" : $("#user_workboard2").val()
	});
	
	arrData.push({
				"name" : "zhiwu2",
				"value" : $("#user_zhiwu2").val()
			});
	arrData.push({
		"name" : "renqi2",
		"value" : $("#user_renqi2").val()
	});
	
	arrData.push({
		"name" : "workboard3",
		"value" : $("#user_workboard3").val()
	});
	
	arrData.push({
				"name" : "zhiwu3",
				"value" : $("#user_zhiwu3").val()
			});
	arrData.push({
		"name" : "renqi3",
		"value" : $("#user_renqi3").val()
	});
	
	arrData.push({
		"name" : "danweiname",
		"value" : $("#user_danweiname").val()
	});
	
	arrData.push({
				"name" : "origcode",
				"value" : $("#user_origcode").val()
			});
	arrData.push({
		"name" : "reprsentperson",
		"value" : $("#user_reprsentperson").val()
	});
	arrData.push({
		"name" : "zhuguandanwei",
		"value" : $("#user_zhuguandanwei").val()
	});
	
	arrData.push({
				"name" : "danweiaddr",
				"value" : $("#user_danweiaddr").val()
			});
	arrData.push({
		"name" : "danweicode",
		"value" : $("#user_danweicode").val()
	});
	arrData.push({
		"name" : "danweicont",
		"value" : $("#user_danweicont").val()
	});
	
	arrData.push({
				"name" : "danweiphone",
				"value" : $("#user_danweiphone").val()
			});
	arrData.push({
		"name" : "danweichuanzhen",
		"value" : $("#user_danweichuanzhen").val()
	});
	*/
	 
	
	 
/*	$.ajax({
				dataType : "json",
				type : "post",
				url : "updateUserBaseDetail",
				data : arrData,
				error : function() {// 请求失败处理函数
					alert('请求失败');
				},
				success : function(rst) {
					if (rst.result == 1) {
						noty({
									text : '附件3  保存完成！请继续完善其他信息!',
									type : 'success',
									dismissQueue : false,
									closeWith : ['click', 'button'],
									timeout : 1500,
									layout : 'top',
									callback : {
										afterClose : function() {
											// location.href='${ctx}/userBaseInfor?bt=base';
										}
									},
									theme : 'defaultTheme'
								});
					} else {
						generatenoty('center', rst.msg, 'error');
					}
				}
			});*/
}
