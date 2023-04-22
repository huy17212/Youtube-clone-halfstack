package asm2.com.poly.dao.daoImpl;

import java.util.List;

import asm2.com.poly.dao.accountDao;
import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.entity.account;

public class accountDaoImpl extends hibernateMethods<account> implements accountDao  {

	@Override
	public account findById(Integer Id) {
		return super.findById(account.class, Id);
	}

	@Override
	public account findByemail(String email) {
		String sql = "SELECT o FROM account o WHERE o.email = ?0";
		return super.findOne(account.class, sql, email);
	}

	@Override
	public account findByUsername(String username) {
		String sql = "SELECT o FROM account o WHERE o.accountusername = ?0";
		return super.findOne(account.class, sql, username);

	}

	@Override
	public account findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT o FROM account o WHERE o.accountusername = ?0 AND o.accountpassword = ?1";
		return super.findOne(account.class, sql, username, password);
	}

	@Override
	public List<account> findAll() {
		return super.findAll(account.class, true);
	}

	@Override
	public List<account> findAll(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
