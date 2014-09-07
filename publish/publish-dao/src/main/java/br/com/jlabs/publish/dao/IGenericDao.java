package br.com.jlabs.publish.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

	T findOne(final long id);

	T findOne(String idField, Serializable idValue, String ... joinFetchs);

	List<T> findAll();
	
	List<T> findAll(String ... joinFetchs);

	void create(final T entity);
	
	T load(Serializable id);
	
	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);
}