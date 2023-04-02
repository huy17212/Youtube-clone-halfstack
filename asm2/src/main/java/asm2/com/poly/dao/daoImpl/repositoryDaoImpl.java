package asm2.com.poly.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.dao.repositoryDao;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.repository;
import asm2.com.poly.entity.repositoryStatus;

public class repositoryDaoImpl extends hibernateMethods<repository> implements repositoryDao {
	@Override
	public List<repository> findAllByStatusId(account currentAccount, repositoryStatus repository) {
		
		List<repository> lits = super.findAll(repository.class, false);
		List<repository> tempo = new ArrayList<>();
		
		for(repository item : lits) {
			if(item.getAccountid().getId().equals(currentAccount.getId()) && item.getStatusid().getId().equals(repository.getId())) {
				tempo.add(item);
			}
		}
		return tempo;
	}

	@Override
	public List<repository> findAll() {
		return super.findAll(repository.class, false);
	}
}
