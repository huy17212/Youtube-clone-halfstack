package asm2.com.poly.service;

import java.util.List;

import asm2.com.poly.entity.account;

public interface accountService {
	account findById(Integer Id);
	account findByemail(String email);
	account findByUsername(String username);
	account findByUsernameAndPassword(String username, String password);
	List<account> findAll();
	List<account> findAll(Integer pageNumber, Integer pageSize);
	account create(account entity);
	account update(account entity);
	account delete(account entity);
}
