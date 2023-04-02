package asm2.com.poly.service;

import java.util.List;

import asm2.com.poly.entity.account;
import asm2.com.poly.entity.repository;
import asm2.com.poly.entity.repositoryStatus;

public interface repositoryService {
	public List<repository> findAllByStatusId(account currentAccount, repositoryStatus statusId);
	public List<repository> findAll();
	public repository create(repository entity);
	public repository delete(repository entity);
	public repository update(repository entity);
}	
