package asm2.com.poly.dao.daoImpl;

import java.util.List;

import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.dao.subcriberDao;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.subcriber;
import asm2.com.poly.service.accountService;
import asm2.com.poly.service.subcriberService;
import asm2.com.poly.service.Impl.accountServiceImpl;

public class subcriberDaoImpl extends hibernateMethods<subcriber> implements subcriberDao {

	@Override
	public subcriber findById(Integer id) {
		return super.findById(subcriber.class, id);
	}

	@Override
	public List<subcriber> findAll() {
		return super.findAll(subcriber.class, false);
	}

	@Override
	public List<account> findByAccountSubcriber(List<account> listAccountSubcriber, account accountid) {
			accountService accountService = new accountServiceImpl();
			
			subcriberService subcribeService = new subcriberServiceImpl();
			subcriber d = subcribeService.findById(accountid.getId());
			String listSubcriber = d.getListsubcriber();
			String[] list;
			
			if (listSubcriber.isBlank()) {
				listAccountSubcriber.removeAll(listAccountSubcriber);
				return listAccountSubcriber;
			}
			else if (!listSubcriber.contains(",")) {
				account accsubcribe = accountService.findById(Integer.parseInt(listSubcriber));
				listAccountSubcriber.add(accsubcribe);
				return listAccountSubcriber;
			} else if (listSubcriber.contains(",")) {
				list = listSubcriber.split(",");
				for (String item : list) {
					account accsubcribe = accountService.findById(Integer.parseInt(item));
					listAccountSubcriber.add(accsubcribe);
				}
				return listAccountSubcriber;
			}
		return null;
	}

}
