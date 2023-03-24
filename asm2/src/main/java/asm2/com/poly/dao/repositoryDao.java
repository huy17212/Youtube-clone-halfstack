package asm2.com.poly.dao;

import java.util.List;

import asm2.com.poly.entity.account;
import asm2.com.poly.entity.repository;

public interface repositoryDao {
	
	public List<repository> findAllByStatusId(account currentAccount, Integer statusId);
	public repository create(repository entity);
	public repository delete(repository entity);
	public repository update(repository entity);
}
