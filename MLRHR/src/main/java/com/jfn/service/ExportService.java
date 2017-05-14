package com.jfn.service;

import com.jfn.common.util.ExcelUtil;
import com.jfn.dao.GroupDao;
import com.jfn.dao.StatisticalResultDao;
import com.jfn.entity.Group;
import com.jfn.vo.ExcelBase;
import com.jfn.vo.PersonFirstGroup;
import com.jfn.vo.PersonFirstTrial;
import com.jfn.vo.TeamFirstGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
@Repository
public class ExportService{
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private StatisticalResultDao statisticalResultDao;
    public void CreateExcelFile(String dateStr,Integer applyStrep,Date starttime,Date endtime){
        List<Group> groups = groupDao.getGroupTree();
        ExcelBase excelBase = new ExcelBase();
        if(applyStrep ==1 ){
            excelBase.setApplyStep(1);
            //杰出青年
            List<PersonFirstGroup> jcqnList= new ArrayList<>();
            for(int i = 0 ; i < groups.size() ;i++){
                Group group = groups.get(i);
                PersonFirstGroup personFirstGroup = new PersonFirstGroup();
                personFirstGroup.setGroupName(group.getName());
                List<PersonFirstTrial> personFirstTrials = statisticalResultDao.getPersonFirstTrialScore("杰出青年",
                        group.getId(),starttime,endtime);
                personFirstGroup.setPersonFirstTrials(personFirstTrials);
                jcqnList.add(personFirstGroup);
            }
            //科技领军
            List<PersonFirstGroup> kjljList = new ArrayList<>();
            for(int i = 0 ; i < groups.size() ;i++){
                Group group = groups.get(i);
                PersonFirstGroup personFirstGroup = new PersonFirstGroup();
                personFirstGroup.setGroupName(group.getName());
                List<PersonFirstTrial> personFirstTrials = statisticalResultDao.getPersonFirstTrialScore("科技领军",
                        group.getId(),starttime,endtime);
                personFirstGroup.setPersonFirstTrials(personFirstTrials);
                kjljList.add(personFirstGroup);
            }
            //创新团队
            List<TeamFirstGroup> teamList = new ArrayList<>();
            for(int i = 0 ; i < groups.size() ; i++){
                Group group = groups.get(i);
                TeamFirstGroup teamFirstGroup = new TeamFirstGroup();
                teamFirstGroup.setGroupName(group.getName());
                //获取团队初审list
                teamList.add(teamFirstGroup);
            }
            excelBase.setJcqnList(jcqnList);
            excelBase.setKjljList(kjljList);
            excelBase.setTeamFirstGroups(teamList);
        }else{

        }
        ExcelUtil.writeExcel(excelBase,"D://");
    }
}
