package asm2.com.poly.dao.daoImpl;

import java.util.List;

import asm2.com.poly.dao.subcriberDao;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.subcriber;
import asm2.com.poly.service.subcriberService;

public class subcriberServiceImpl implements subcriberService {
	
	subcriberDao dao = new subcriberDaoImpl();
	
	@Override
	public subcriber findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<subcriber> findAll() {
		return dao.findAll();
	}

	@Override
	public subcriber create(subcriber subcriber) {
		return dao.create(subcriber);
	}

	@Override
	public subcriber delete(subcriber subcriber) {
		return dao.delete(subcriber);
	}

	@Override
	public subcriber update(subcriber subcriber) {
		return dao.update(subcriber);
	}

	@Override
	public List<account> findByAccountSubcriber(List<account> listAccountSubcriber, account accountId) {
		
		return dao.findByAccountSubcriber(listAccountSubcriber, accountId);
	}
	
}
