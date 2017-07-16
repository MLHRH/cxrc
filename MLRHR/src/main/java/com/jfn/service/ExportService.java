package com.jfn.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.common.util.ExcelUtil;
import com.jfn.dao.GroupDao;
import com.jfn.dao.StatisticalResultDao;
import com.jfn.dao.ZhichengApplyDao;
import com.jfn.entity.ExpertVote;
import com.jfn.entity.Group;
import com.jfn.vo.ExcelBase;
import com.jfn.vo.PersonFirstGroup;
import com.jfn.vo.PersonFirstTrial;
import com.jfn.vo.PersonSecondGroup;
import com.jfn.vo.PersonSecondTrial;
import com.jfn.vo.TeamFirstGroup;
import com.jfn.vo.TeamFirstTrial;
import com.jfn.vo.TeamSecondGroup;
import com.jfn.vo.TeamSecondTrial;
/**
 * Created by xubin on 2017/5/14
 */
@Repository
public class ExportService{
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private StatisticalResultDao statisticalResultDao;
    @Autowired
    private ZhichengApplyDao zhichengApplyDao ;
    public void CreateExcelFile(String dateStr,Integer applyStrep,Date starttime,Date endtime,String path){
        List<Group> groups = groupDao.getGroupTree();
        ExcelBase excelBase = new ExcelBase();
        if(applyStrep ==1 ){
            excelBase.setApplyStep(1);
            //杰出青年
            List<PersonFirstGroup> jcqnList= new ArrayList();
            for(int i = 0 ; i < groups.size() ;i++){
                Group group = groups.get(i);
                PersonFirstGroup personFirstGroup = new PersonFirstGroup();
                personFirstGroup.setGroupName(group.getName());
                List<PersonFirstTrial> personFirstTrials = statisticalResultDao.getPersonFirstTrialScoreJcqn("杰出青年",
                        group.getId(),starttime,endtime);
                personFirstGroup.setPersonFirstTrials(personFirstTrials);
                jcqnList.add(personFirstGroup);
            }
            //科技领军
            List<PersonFirstGroup> kjljList = new ArrayList();
            for(int i = 0 ; i < groups.size() ;i++){
                Group group = groups.get(i);
                PersonFirstGroup personFirstGroup = new PersonFirstGroup();
                personFirstGroup.setGroupName(group.getName());
                List<PersonFirstTrial> personFirstTrials = statisticalResultDao.getPersonFirstTrialScoreKjlj("科技领军",
                        group.getId(),starttime,endtime);
                personFirstGroup.setPersonFirstTrials(personFirstTrials);
                kjljList.add(personFirstGroup);
            }
            //创新团队
            List<TeamFirstGroup> teamList = new ArrayList();
            for(int i = 0 ; i < groups.size() ; i++){
                Group group = groups.get(i);
                List<TeamFirstTrial> teamFirstTrials = statisticalResultDao.getPersonFirstTrialScoreCxtd("创新团队", group.getId(), starttime, endtime);
                TeamFirstGroup teamFirstGroup = new TeamFirstGroup();
                teamFirstGroup.setTeamFirstTrials(teamFirstTrials);
                teamFirstGroup.setGroupName(group.getName());
                //获取团队初审list
                teamList.add(teamFirstGroup);
            }
            excelBase.setJcqnList(jcqnList);
            excelBase.setKjljList(kjljList);
            excelBase.setTeamFirstGroups(teamList); 
            ExcelUtil.writeExcel(excelBase,path);
     
        }else{

            excelBase.setApplyStep(2);
            //杰出青年
            List<PersonSecondGroup> jcqnListsec= new ArrayList();
            for(int i = 0 ; i < groups.size() ;i++){
                Group group = groups.get(i);
                PersonSecondGroup personSecondGroup = new PersonSecondGroup();
                personSecondGroup.setGroupName(group.getName());
                List<PersonSecondTrial> personFirstTrials = statisticalResultDao.getPersonSecondTrialVoteJcqn("杰出青年",
                        group.getId(),starttime,endtime);
                for (PersonSecondTrial personSecondTrial : personFirstTrials) {
                	String applyId = personSecondTrial.getApplyId();
                	if (applyId != null && !applyId.equals("")) {
                		List<ExpertVote> expertVotes = zhichengApplyDao.getExpertVote(Integer.valueOf(applyId));		
                		List<ExpertVote> tongguo = new ArrayList<ExpertVote>();
                		List<ExpertVote> butongguo = new ArrayList<ExpertVote>();
                		List<ExpertVote> qiquan = new ArrayList<ExpertVote>();
                		for (ExpertVote expertVote : expertVotes) {
						if (expertVote.getExpert_vote().equals("1")) {
							tongguo.add(expertVote);
						}else if (expertVote.getExpert_vote().equals("2")) {
							butongguo.add(expertVote);
						}else if (expertVote.getExpert_vote().equals("3")){
							qiquan.add(expertVote);
						}
					}
                		personSecondTrial.setAgreeNum(tongguo.size());	
                		personSecondTrial.setDisagreeNum(butongguo.size());
                		personSecondTrial.setWaiverNum(qiquan.size());
                		if (expertVotes.size() == 0) {
                			personSecondTrial.setVoteRate(0);
						}else {
							Double vate = Double.valueOf(tongguo.size())/Double.valueOf(expertVotes.size());
							BigDecimal bigDecimal = new BigDecimal(vate);  
							double f1 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
							personSecondTrial.setVoteRate(f1);							
						}
                	}
				}
                personSecondGroup.setPersonSecondTrials(personFirstTrials);
                jcqnListsec.add(personSecondGroup);
            }
            //科技领军
            List<PersonSecondGroup> kjljListsec = new ArrayList();
            for(int i = 0 ; i < groups.size() ;i++){
                Group group = groups.get(i);
                PersonSecondGroup personSecondGroup = new PersonSecondGroup();
                personSecondGroup.setGroupName(group.getName());
                List<PersonSecondTrial> personFirstTrials = statisticalResultDao.getPersonSecondTrialVoteKjlj("科技领军",
                        group.getId(),starttime,endtime);
                for (PersonSecondTrial personSecondTrial : personFirstTrials) {
                	String applyId = personSecondTrial.getApplyId();
                	if (applyId != null && !applyId.equals("")) {
                		List<ExpertVote> expertVotes = zhichengApplyDao.getExpertVote(Integer.valueOf(applyId));		
                		List<ExpertVote> tongguo = new ArrayList<ExpertVote>();
                		List<ExpertVote> butongguo = new ArrayList<ExpertVote>();
                		List<ExpertVote> qiquan = new ArrayList<ExpertVote>();
                		for (ExpertVote expertVote : expertVotes) {
						if (expertVote.getExpert_vote().equals("1")) {
							tongguo.add(expertVote);
						}else if (expertVote.getExpert_vote().equals("2")) {
							butongguo.add(expertVote);
						}else if (expertVote.getExpert_vote().equals("3")){
							qiquan.add(expertVote);
						}
					}
                		personSecondTrial.setAgreeNum(tongguo.size());	
                		personSecondTrial.setDisagreeNum(butongguo.size());
                		personSecondTrial.setWaiverNum(qiquan.size());
                		if (expertVotes.size() == 0) {
                			personSecondTrial.setVoteRate(0);
						}else {
							Double vate = Double.valueOf(tongguo.size())/Double.valueOf(expertVotes.size());
							BigDecimal bigDecimal = new BigDecimal(vate);  
							double f1 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
							personSecondTrial.setVoteRate(f1);		
						}
                	}
				}
                personSecondGroup.setPersonSecondTrials(personFirstTrials);
                kjljListsec.add(personSecondGroup);
            }
            //创新团队
            List<TeamSecondGroup> teamListsec = new ArrayList();
            for(int i = 0 ; i < groups.size() ; i++){
                Group group = groups.get(i);
                List<TeamSecondTrial> teamSecondTrials = statisticalResultDao.getPersonSecondTrialVoteCxtd("创新团队", group.getId(), starttime, endtime);
                for (TeamSecondTrial teamSecondTrial : teamSecondTrials) {
                	String applyId = teamSecondTrial.getApplyId();
                	if (applyId != null && !applyId.equals("")) {
                		List<ExpertVote> expertVotes = zhichengApplyDao.getExpertVote(Integer.valueOf(applyId));		
                		List<ExpertVote> tongguo = new ArrayList<ExpertVote>();
                		List<ExpertVote> butongguo = new ArrayList<ExpertVote>();
                		List<ExpertVote> qiquan = new ArrayList<ExpertVote>();
                		for (ExpertVote expertVote : expertVotes) {
						if (expertVote.getExpert_vote().equals("1")) {
							tongguo.add(expertVote);
						}else if (expertVote.getExpert_vote().equals("2")) {
							butongguo.add(expertVote);
						}else if (expertVote.getExpert_vote().equals("3")){
							qiquan.add(expertVote);
						}
					}
                		teamSecondTrial.setAgreeNum(tongguo.size());	
                		teamSecondTrial.setDisagreeNum(butongguo.size());
                		teamSecondTrial.setWaiverNum(qiquan.size());
                		if (expertVotes.size() == 0) {
                			 teamSecondTrial.setVoteRate(0);
						}else {
							Double vate = Double.valueOf(tongguo.size())/Double.valueOf(expertVotes.size());
							BigDecimal bigDecimal = new BigDecimal(vate);  
							double f1 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
							teamSecondTrial.setVoteRate(f1);					
						}
                	}
				}
                TeamSecondGroup teamSecondGroup = new TeamSecondGroup();
                teamSecondGroup.setTeamSecondTrials(teamSecondTrials);
                teamSecondGroup.setGroupName(group.getName());
                //获取团队初审list
                teamListsec.add(teamSecondGroup);
            }
            excelBase.setJcqnListSecondGroups(jcqnListsec);
            excelBase.setKjljListSecondGroups(kjljListsec);
            excelBase.setTeamSecondGroups(teamListsec);
            ExcelUtil.writeExcelSec(excelBase,path);
        }
    }
}
