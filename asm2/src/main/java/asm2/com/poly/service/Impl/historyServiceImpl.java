package asm2.com.poly.service.Impl;

import java.util.List;

import asm2.com.poly.dao.historyDao;
import asm2.com.poly.dao.daoImpl.historyDaoImpl;
import asm2.com.poly.entity.history;
import asm2.com.poly.service.historyService;

public class historyServiceImpl implements historyService {

	public historyDao dao;
	
	public historyServiceImpl() {
		dao = new historyDaoImpl();
	}
	
	@Override
	public List<history> findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public List<history> findByUserAndIsLiked(String username) {
		return dao.findByUserAndIsLiked(username);
	}

	@Override
	public history findByUserAndViewId(Integer userId, Integer viewId) {
		return dao.findByUserAndViewId(userId, viewId);
	}

	@Override
	public history create(history entity) {
		return dao.create(entity);
	}

	@Override
	public history update(history entity) {
		return dao.update(entity);
	}
	
}
