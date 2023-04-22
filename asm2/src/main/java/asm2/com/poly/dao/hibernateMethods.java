package asm2.com.poly.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import asm2.com.poly.context.contextToHibernate;

public class hibernateMethods<T>{
	Boolean sign = true;
	public EntityManager entityManger;
	
	public hibernateMethods() {
		entityManger = contextToHibernate.getEntityManager("asmjava42");
//		entityManger.getTransaction().begin();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable{
		entityManger.close();
		super.finalize();
	}
	
	public T findById(Class<T> clazz, Integer id) {
		return entityManger.find(clazz, id);
	}
	
	public List<T> findAll(Class<T> clazz, boolean existIsActive){
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if(existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManger.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}
	
	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize){
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if(existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManger.createQuery(sql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	public T findOne (Class<T> clazz, String sql, Object ... params) {
		TypedQuery<T> query = entityManger.createQuery(sql, clazz);
		for(int i  = 0 ; i < params.length ; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public List<T> findMany (Class<T> clazz, String sql, Object ... params) {
		TypedQuery<T> query = entityManger.createQuery(sql, clazz);
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i,  params[i]);
		}
		return query.getResultList();
	}
	
	public T create(T entity) {
		try {
			entityManger.getTransaction().begin();
			entityManger.persist(entity);
			entityManger.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			entityManger.getTransaction().rollback();
			sign = false;
			throw new RuntimeException(e);
		}
	}
	
	public T update(T entity) {
		try {
			entityManger.getTransaction().begin();
			entityManger.merge(entity);
			entityManger.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			entityManger.getTransaction().rollback();
			sign = false;
			throw new RuntimeException(e);
		}
	}
	
	public T delete(T entity) {
		try {
			entityManger.getTransaction().begin();
			entityManger.remove(entityManger.contains(entity) ? entity : entityManger.merge(entity));
			entityManger.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			entityManger.getTransaction().rollback();
			sign = false;
			throw new RuntimeException(e);
		}
	}
	
}
