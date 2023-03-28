package asm2.com.poly.context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class contextToHibernate {
	private static EntityManagerFactory factory;
	
	public static EntityManager getEntityManager(String persistenceUnitname) {
		if(factory == null || factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory(persistenceUnitname);
		}
		return factory.createEntityManager();
	}
	
	public static void shutDown() {
		if(factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}
