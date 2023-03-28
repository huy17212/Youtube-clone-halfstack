package asm2.com.poly.dao.daoImpl;

import java.util.List;

import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.dao.subcriberDao;
import asm2.com.poly.entity.subcriber;

public class subcriberDaoImpl extends hibernateMethods<subcriber> implements subcriberDao {

	@Override
	public subcriber findById(Integer id) {
		return super.findById(subcriber.class, id);
	}

	@Override
	public List<subcriber> findAll() {
		return super.findAll(subcriber.class, false);
	}

}
