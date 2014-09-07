/**
 * 
 */
package br.com.jlabs.publish.business.contact;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.dao.company.CompanyDao;
import br.com.jlabs.publish.dao.contact.ContactDao;
import br.com.jlabs.publish.entity.Contact;

/**
 * @author sandro
 *
 */
@Service("contactBusiness")
public class ContactBusinessImpl implements ContactBusiness {

	@Autowired
	private ContactDao contactDao;

	@Autowired
	private CompanyDao companyDao;
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.publish.business.contact.ContactBusiness#list(java.lang.Long)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Contact> list(Long companyId) {

		return contactDao.list(companyId);

	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Contact findOne(Serializable key, String ... joinFetch) {
	    return contactDao.findOne("id", key, joinFetch);
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Contact contact) {
		
		if ( contact.getId() == null ) {
			
			contact.setCompany(companyDao.load(contact.getCompany().getId()));
			contactDao.create(contact);
			
		} else {
			
			contactDao.update(contact);
			
		}
    }

}
