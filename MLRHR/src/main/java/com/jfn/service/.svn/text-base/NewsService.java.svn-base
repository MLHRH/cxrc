package com.jfn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jfn.dao.NewsDao;
import com.jfn.entity.News;

@Repository
public class NewsService {
	
	private static final Logger log = LoggerFactory.getLogger( NewsService.class );
	@Autowired
	private NewsDao newsDao;
	
	public List<News> getAll()
	{
		return newsDao.getAll();
	}
	
	public List<News> getAllTop()
	{
		return newsDao.getAllforTop();
	}

	public News getById(String newsId) {
		// TODO Auto-generated method stub
		return newsDao.get(Integer.parseInt(newsId));
	}

	public boolean newsInsert(News entity) {
		// TODO Auto-generated method stub
		return newsDao.insert(entity);
	}

	public boolean newsUpdate(News entity) {
		// TODO Auto-generated method stub
		return newsDao.Update(entity);
	}

	public boolean deletenews(String newsId) {
		// TODO Auto-generated method stub
		return newsDao.delete(Integer.parseInt(newsId));
	}
	
	

}
