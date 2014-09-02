package br.com.jlabs.publish.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract hibernate DAO.
 * 
 * @author sandro
 *
 * @param <T> Entity to be persisted
 */
public abstract class AbstractHibernateDao<T extends Serializable> {

	/**
	 * Class of entity to be persisted
	 */
	private Class<T> clazz;

	/**
	 * Default constructor
	 */
	public AbstractHibernateDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * 
	 * @param clazzToSet
	 */
	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public T findOne(long id) {
		return (T) getCurrentSession().get(clazz, id);
	}
	
	/**
	 * 
	 * @param idField
	 * @param idValue
	 * @param joinFetchs
	 * @return
	 */
	public T findOne(String idField, Serializable idValue, String...joinFetchs) {
		Criteria criteria = createJoinedCriteria(joinFetchs);
		
		criteria.add(Restrictions.eq(idField, idValue));
		
		for(String joinFetch : joinFetchs) {
			criteria.setFetchMode(joinFetch, FetchMode.JOIN);
		}
		
		return (T) criteria.uniqueResult();
	}

	/**
	 * 
	 * @return
	 */
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}
	
	/**
	 * 
	 * @param joinFetchs
	 * @return
	 */
	public List<T> findAll(String ... joinFetchs) {
		Criteria criteria = createJoinedCriteria(joinFetchs);
		
		return criteria.list();
	}

	/**
	 * 
	 * @param joinFetchs
	 * @return
	 */
	private Criteria createJoinedCriteria(String... joinFetchs) {
		Session currentSession = getCurrentSession();
		Criteria criteria = currentSession.createCriteria(clazz);
		
		for(String joinFetch: joinFetchs) {
			criteria.setFetchMode(joinFetch, FetchMode.JOIN);
		}
		return criteria;
	}
	
	/**
	 * 
	 * @param entity
	 */
	public void create(T entity) {
		getCurrentSession().persist(entity);
	}

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T update(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	/**
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	/**
	 * 
	 * @param entityId
	 */
	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	/**
	 * 
	 * @return
	 */
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}