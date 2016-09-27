package com.jfn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.KjljDoc01Dao;
import com.jfn.dao.KjljDoc02Dao;
import com.jfn.dao.KjljDoc03Dao;
import com.jfn.dao.KjljDoc04Dao;
import com.jfn.dao.KjljDoc05Dao;
import com.jfn.entity.KjljDoc01;

import com.jfn.entity.KjljDoc03;
import com.jfn.entity.KjljDoc04;
import com.jfn.entity.KjljDoc05;
import com.jfn.entity.KjljDocPatent;
import com.jfn.entity.KjljDocPrize;
import com.jfn.entity.KjljDocProject;
import com.jfn.entity.KjljDocReport;
import com.jfn.entity.KjljDocThesis;
import com.jfn.entity.KjljDocTreatise;

@Repository
public class KjljDocService {
	@Autowired
	private KjljDoc01Dao kjljDoc01Dao;
	@Autowired
	private KjljDoc02Dao kjljDoc02Dao;
	@Autowired
	private KjljDoc03Dao kjljDoc03Dao;
	@Autowired
	private KjljDoc04Dao kjljDoc04Dao;
	@Autowired
	private KjljDoc05Dao kjljDoc05Dao;
	
	public boolean insert01(KjljDoc01 kjljDoc01){
		return kjljDoc01Dao.insert(kjljDoc01);
		}
		
		public boolean update01(KjljDoc01 kjljDoc01){
			return kjljDoc01Dao.update(kjljDoc01);
		}
		
		public boolean delete01( int user_id ){
			return kjljDoc01Dao.delete(user_id);
			
		}
		public KjljDoc01 getByUserId01( int user_id ){
			return kjljDoc01Dao.getByUserId(user_id);
		}
		
		public boolean insert02(KjljDocProject kjljDocProject){
			return kjljDoc02Dao.insert(kjljDocProject);
			}
			
			public KjljDocProject update02(KjljDocProject kjljDocProject,KjljDocPrize kjljDocPrize,KjljDocThesis kjljDocThesis,KjljDocPatent kjljDocPatent,KjljDocReport kjljDocReport,KjljDocTreatise kjljDocTreatise){
				List<Object> list = new ArrayList<Object>();
//				return kjljDoc02Dao.update(kjljDocProject);
				
				kjljDoc02Dao.update(kjljDocProject);
				kjljDoc02Dao.update(kjljDocPrize);
				kjljDoc02Dao.update(kjljDocThesis);
				kjljDoc02Dao.update(kjljDocPatent);
				kjljDoc02Dao.update(kjljDocReport);
			    kjljDoc02Dao.update(kjljDocTreatise);
//			
			   return kjljDocProject; 
			}
			public boolean delete02( int user_id ){
				return kjljDoc02Dao.delete(user_id);
				
			}
			public List<Object> getByUserId02( int user_id){
				List<Object> list = new ArrayList<Object>();
				kjljDoc02Dao.getByUserIdProject(user_id, list);
				kjljDoc02Dao.getByUserIdPrize(user_id,list);
				kjljDoc02Dao.getByUserIdThesis(user_id,list);
				kjljDoc02Dao.getByUserIdPatent(user_id,list);
				kjljDoc02Dao.getByUserIdReport(user_id,list);
				kjljDoc02Dao.getByUserIdTreatise(user_id,list);
				
			
				return list;
			}
			
			
			
			
			public KjljDoc03Dao getkjljDoc03Dao() {
				return kjljDoc03Dao;
			}

			public void setkjljDoc03Dao(KjljDoc03Dao kjljDoc03Dao) {
				this.kjljDoc03Dao = kjljDoc03Dao;
			}
			public boolean insert03(KjljDoc03 entity) {
				// TODO Auto-generated method stub
				return kjljDoc03Dao.insert(entity);
			}
			public KjljDoc03 getByUserId03( int user_id ){
				return kjljDoc03Dao.getByUserId(user_id);
			}
			
			public boolean update03(KjljDoc03 kjljDoc03){
				return kjljDoc03Dao.update(kjljDoc03);
			}
			
			
			public KjljDoc04Dao getkjljDoc04Dao() {
				return kjljDoc04Dao;
			}

			public void setkjljDoc04Dao(KjljDoc04Dao kjljDoc04Dao) {
				this.kjljDoc04Dao = kjljDoc04Dao;
			}
			public boolean insert04(KjljDoc04 entity) {
				// TODO Auto-generated method stub
				return kjljDoc04Dao.insert(entity);
			}
			public KjljDoc04 getByUserId04( int user_id ){
				return kjljDoc04Dao.getByUserId(user_id);
			}
			
			public boolean update04(KjljDoc04 kjljDoc04){
				return kjljDoc04Dao.update(kjljDoc04);
			}
			
			
			public KjljDoc05Dao getkjljDoc05Dao() {
				return kjljDoc05Dao;
			}

			public void setkjljDoc05Dao(KjljDoc05Dao kjljDoc05Dao) {
				this.kjljDoc05Dao = kjljDoc05Dao;
			}
			public boolean insert05(KjljDoc05 entity) {
				// TODO Auto-generated method stub
				return kjljDoc05Dao.insert(entity);
			}
			public KjljDoc05 getByUserId05( int user_id ){
				return kjljDoc05Dao.getByUserId(user_id);
			}
			
			public boolean update05(KjljDoc05 kjljDoc05){
				return kjljDoc05Dao.update(kjljDoc05);
			}
			
			
			
}
