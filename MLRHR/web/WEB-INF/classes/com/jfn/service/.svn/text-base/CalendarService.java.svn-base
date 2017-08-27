package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.CalendarDao;
import com.jfn.entity.Calendar;

/**
 * @create-time 2014-8-8 下午9:07:25
 * @creator     佟德慧
 */
@Repository
public class CalendarService {
	
	private static final Logger log = LoggerFactory.getLogger( CalendarService.class );
	@Autowired
	private CalendarDao calendarDao;
	
	public List<Calendar> getAll()
	{
		return calendarDao.getAll();
	}
	

	public Calendar getById(String calendarId) {
		// TODO Auto-generated method stub
		return calendarDao.get(Integer.parseInt(calendarId));
	}

	public boolean calendarInsert(Calendar entity) {
		// TODO Auto-generated method stub
		return calendarDao.insert(entity);
	}

	public boolean calendarUpdate(Calendar entity) {
		// TODO Auto-generated method stub
		return calendarDao.Update(entity);
	}

	public boolean deletecalendar(String calendarId) {
		// TODO Auto-generated method stub
		return calendarDao.delete(Integer.parseInt(calendarId));
	}
	

}
