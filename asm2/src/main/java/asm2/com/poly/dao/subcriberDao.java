package asm2.com.poly.dao;

import java.util.List;

import asm2.com.poly.entity.subcriber;

public interface subcriberDao {
		
	public subcriber findById(Integer id);
	public List<subcriber> findAll();
	public subcriber create(subcriber subcriber);
	public subcriber delete(subcriber subcriber);
	public subcriber update(subcriber subcriber);
}
