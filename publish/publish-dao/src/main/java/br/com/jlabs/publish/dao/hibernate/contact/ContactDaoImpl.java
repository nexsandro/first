/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.contact;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.AbstractHibernateDao;
import br.com.jlabs.publish.dao.contact.ContactDao;
import br.com.jlabs.publish.entity.Contact;

/**
 * @author sandro
 *
 */
@Repository("contactDao")
public class ContactDaoImpl extends AbstractHibernateDao<Contact> implements ContactDao {

	/**
	 * Default constructor
	 */
	public ContactDaoImpl() {
	    super(Contact.class);
    }

	public List<Contact> list(Long companyId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Contact.class);

		crit.add(Restrictions.eq("company.id", companyId));
		
		return crit.list();
    }
	
	

}
