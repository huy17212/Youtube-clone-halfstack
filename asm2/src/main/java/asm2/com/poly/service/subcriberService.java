package asm2.com.poly.service;

import java.util.List;

import asm2.com.poly.entity.account;
import asm2.com.poly.entity.subcriber;

public interface subcriberService {
	public subcriber findById(Integer id);
	public List<subcriber> findAll();
	public subcriber create(subcriber subcriber);
	public subcriber delete(subcriber subcriber);
	public subcriber update(subcriber subcriber);
	public List<account> findByAccountSubcriber(List<account> listAccountSubcriber, account accountId); 
}
