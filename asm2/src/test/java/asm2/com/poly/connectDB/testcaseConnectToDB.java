package asm2.com.poly.connectDB;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import asm2.com.poly.context.contextToHibernate;

public class testcaseConnectToDB {
	
	@ParameterizedTest
	@ValueSource(strings = {"asmm", "asmjava42", "asmadiahkd"})
	public void connectToDB(String namePersistenceUnit) {
		EntityManager connect = contextToHibernate.getEntityManager(namePersistenceUnit);
		Assertions.assertNotNull(connect);
	}
	
	
}
