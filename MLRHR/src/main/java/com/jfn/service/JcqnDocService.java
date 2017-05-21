package com.jfn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.JcqnDoc01Dao;
import com.jfn.dao.JcqnDoc02Dao;
import com.jfn.dao.JcqnDoc03Dao;
import com.jfn.dao.JcqnDoc04Dao;
import com.jfn.dao.JcqnDoc05Dao;
import com.jfn.dao.JcqnDoc08Dao;
import com.jfn.dao.JcqnDoc09Dao;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.ExpertVote;
import com.jfn.entity.JcqnDoc01;
import com.jfn.entity.JcqnDoc03;
import com.jfn.entity.JcqnDoc04;
import com.jfn.entity.JcqnDoc05;
import com.jfn.entity.JcqnDocPatent;
import com.jfn.entity.JcqnDocPrize;
import com.jfn.entity.JcqnDocProject;
import com.jfn.entity.JcqnDocReport;
import com.jfn.entity.JcqnDocThesis;
import com.jfn.entity.JcqnDocTreatise;

@Repository
public class JcqnDocService {
	@Autowired
	private JcqnDoc01Dao jcqnDoc01Dao;
	@Autowired
	private JcqnDoc02Dao jcqnDoc02Dao;
	@Autowired
	private JcqnDoc03Dao jcqnDoc03Dao;
	@Autowired
	private JcqnDoc04Dao jcqnDoc04Dao;
	@Autowired
	private JcqnDoc05Dao jcqnDoc05Dao;
	@Autowired
	private JcqnDoc08Dao jcqnDoc08Dao;
	@Autowired
	private JcqnDoc09Dao jcqnDoc09Dao;
	public boolean insert01(JcqnDoc01 jcqnDoc01){
		return jcqnDoc01Dao.insert(jcqnDoc01);
		}
		
		public boolean update01(JcqnDoc01 jcqnDoc01){
			return jcqnDoc01Dao.update(jcqnDoc01);
		}
		
		public boolean delete01( int user_id ){
			return jcqnDoc01Dao.delete(user_id);
			
		}
		public JcqnDoc01 getByUserId01( int user_id ){
			return jcqnDoc01Dao.getByUserId(user_id);
		}
		
	
		
		public boolean insert02(JcqnDocProject jcqnDocProject){
			return jcqnDoc02Dao.insert(jcqnDocProject);
			}
			
			public JcqnDocProject update02(JcqnDocProject jcqnDocProject,JcqnDocPrize jcqnDocPrize,JcqnDocThesis jcqnDocThesis,JcqnDocPatent jcqnDocPatent,JcqnDocReport jcqnDocReport,JcqnDocTreatise jcqnDocTreatise){
				List<Object> list = new ArrayList<Object>();
//				return jcqnDoc02Dao.update(jcqnDocProject);
				
				jcqnDoc02Dao.update(jcqnDocProject);
				jcqnDoc02Dao.update(jcqnDocPrize);
				jcqnDoc02Dao.update(jcqnDocThesis);
				jcqnDoc02Dao.update(jcqnDocPatent);
				jcqnDoc02Dao.update(jcqnDocReport);
			    jcqnDoc02Dao.update(jcqnDocTreatise);
//			
			   return jcqnDocProject; 
			}
			public boolean delete02( int user_id ){
				return jcqnDoc02Dao.delete(user_id);
				
			}
			public List<Object> getByUserId02( int user_id){
				List<Object> list = new ArrayList<Object>();
				jcqnDoc02Dao.getByUserIdProject(user_id, list);
				jcqnDoc02Dao.getByUserIdPrize(user_id,list);
				jcqnDoc02Dao.getByUserIdThesis(user_id,list);
				jcqnDoc02Dao.getByUserIdPatent(user_id,list);
				jcqnDoc02Dao.getByUserIdReport(user_id,list);
				jcqnDoc02Dao.getByUserIdTreatise(user_id,list);
				
			
				return list;
			}
			/*public List<JcqnDocProject> getByUserIdProject( int user_id ){
				return jcqnDoc02Dao.getByUserId(user_id);
			}
			public List<JcqnDocReport> getByUserIdReport( int user_id ){
				return jcqnDoc02Dao.getByUserIdReport(user_id);
			}
			public List<JcqnDocTreatise> getByUserIdTreatise( int user_id ){
				return jcqnDoc02Dao.getByUserIdTreatise(user_id);
			}
			public List<JcqnDocPrize> getByUserIdPrize( int user_id ){
				return jcqnDoc02Dao.getByUserIdPrize(user_id);
			}
			
			public List<JcqnDocPatent> getByUserIdPatent( int user_id ){
				return jcqnDoc02Dao.getByUserIdPatent(user_id);
			}
			
			public List<JcqnDocThesis> getByUserIdThesis( int user_id ){
				return jcqnDoc02Dao.getByUserIdThesis(user_id);
			}*/
		
			
			
			public JcqnDoc03Dao getJcqnDoc03Dao() {
				return jcqnDoc03Dao;
			}

			public void setJcqnDoc03Dao(JcqnDoc03Dao jcqnDoc03Dao) {
				this.jcqnDoc03Dao = jcqnDoc03Dao;
			}
			public boolean insert03(JcqnDoc03 entity) {
				// TODO Auto-generated method stub
				return jcqnDoc03Dao.insert(entity);
			}
			public JcqnDoc03 getByUserId03( int user_id ){
				return jcqnDoc03Dao.getByUserId(user_id);
			}
			
			public boolean update03(JcqnDoc03 jcqnDoc03){
				return jcqnDoc03Dao.update(jcqnDoc03);
			}
			
			
			public JcqnDoc04Dao getJcqnDoc04Dao() {
				return jcqnDoc04Dao;
			}

			public void setJcqnDoc04Dao(JcqnDoc04Dao jcqnDoc04Dao) {
				this.jcqnDoc04Dao = jcqnDoc04Dao;
			}
			public boolean insert04(JcqnDoc04 entity) {
				// TODO Auto-generated method stub
				return jcqnDoc04Dao.insert(entity);
			}
			public JcqnDoc04 getByUserId04( int user_id ){
				return jcqnDoc04Dao.getByUserId(user_id);
			}
			
			public boolean update04(JcqnDoc04 jcqnDoc04){
				return jcqnDoc04Dao.update(jcqnDoc04);
			}
			
			
			public JcqnDoc05Dao getJcqnDoc05Dao() {
				return jcqnDoc05Dao;
			}

			public void setJcqnDoc05Dao(JcqnDoc05Dao jcqnDoc05Dao) {
				this.jcqnDoc05Dao = jcqnDoc05Dao;
			}
			public boolean insert05(JcqnDoc05 entity) {
				// TODO Auto-generated method stub
				return jcqnDoc05Dao.insert(entity);
			}
			public JcqnDoc05 getByUserId05( int user_id ){
				return jcqnDoc05Dao.getByUserId(user_id);
			}
			
			public boolean update05(JcqnDoc05 jcqnDoc05){
				return jcqnDoc05Dao.update(jcqnDoc05);
			}
			
			public List<ExpertScore> gExpertScore(int apply_id) {
				return jcqnDoc08Dao.getExpertscore(apply_id);
				
			}
			public List<ExpertVote> gExpertVote(int apply_id) {
				return jcqnDoc09Dao.getExpertVote(apply_id);
				
			}
		
}
