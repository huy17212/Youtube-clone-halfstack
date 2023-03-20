package asm2.com.poly.service.Impl;

import java.util.List;

import asm2.com.poly.dao.accountDao;
import asm2.com.poly.dao.daoImpl.accountDaoImpl;
import asm2.com.poly.entity.account;
import asm2.com.poly.service.accountService;

public class accountServiceImpl	implements accountService {

	accountDao service;
	
	public accountServiceImpl() {
		service = new accountDaoImpl();
	}
	
	@Override
	public account findById(Integer Id) {
		return service.findById(Id);
	}

	@Override
	public account findByemail(String email) {
		return service.findByemail(email);
	}

	@Override
	public account findByUsername(String username) {
		return service.findByUsername(username);
	}

	@Override
	public account findByUsernameAndPassword(String username, String password) {
		return service.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<account> findAll() {
		return service.findAll();
	}

	@Override
	public List<account> findAll(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public account create(account entity) {
		return service.create(entity);
	}

	@Override
	public account update(account entity) {
		return service.create(entity);
	}

	@Override
	public account delete(account entity) {
		return service.create(entity);
	}

}
