package asm2.com.poly.dao.daoImpl;

import java.util.List;

import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.dao.repositoryDao;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.repository;

public class repositoryDaoImpl extends hibernateMethods<repository> implements repositoryDao {
	@Override
	public List<repository> findAllByStatusId(account currentAccount, Integer statusId) {
		String sql = "SELECT o FROM repository o WHERE o.account.accountid = ?0 and o.repository.statusid = ?1";
		return super.findMany(repository.class, sql, currentAccount.getId(), statusId);
	}
}
