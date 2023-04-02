package asm2.com.poly.service.Impl;

import java.util.List;

import asm2.com.poly.dao.repositoryDao;
import asm2.com.poly.dao.daoImpl.repositoryDaoImpl;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.repository;
import asm2.com.poly.entity.repositoryStatus;
import asm2.com.poly.service.repositoryService;

public class repositoryServiceImpl implements repositoryService {

	repositoryDao dao = new repositoryDaoImpl();

	@Override
	public List<repository> findAllByStatusId(account currentAccount, repositoryStatus statusId) {
		return dao.findAllByStatusId(currentAccount, statusId);
	}

	@Override
	public repository create(repository entity) {
		return dao.create(entity);
	}

	@Override
	public repository delete(repository entity) {
		return dao.delete(entity);
	}

	@Override
	public repository update(repository entity) {
		return dao.update(entity);

	}

	@Override
	public List<repository> findAll() {
		return dao.findAll();
	}
}
