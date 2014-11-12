package br.com.jlabs.publish.business;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.entity.Entity;

public interface CrudBusiness<E extends Entity> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	E findOne(Serializable id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	E load(Serializable id);

	/**
	 * 
	 * @param idField
	 * @param idValue
	 * @param joinFetchs
	 * @return
	 */
	E findOne(String idField, Serializable idValue, String... joinFetchs);

	/**
	 * 
	 * @return
	 */
	List<E> findAll();

	/**
	 * 
	 * @param joinFetchs
	 * @return
	 */
	List<E> findAll(String... joinFetchs);

	/**
	 * 
	 * @param entity
	 */
	void create(E entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	E update(E entity);

	/**
	 * 
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * 
	 * @param id
	 */
	void delete(Serializable id);

}