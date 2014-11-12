/**
 * 
 */
package br.com.jlabs.publish.business.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.AbstractCrudBusiness;
import br.com.jlabs.publish.dao.contact.ContactDao;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.Contact;

/**
 * @author sandro
 *
 */
@Service("contactBusiness")
public class ContactBusinessImpl extends AbstractCrudBusiness<Contact> implements ContactBusiness {

	@Autowired
	private ContactDao contactDao;
	
	public ContactBusinessImpl() {
	    super(Contact.class);
    }
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.publish.business.contact.ContactBusiness#list(java.lang.Long)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Contact> list(Long companyId) {
		return contactDao.list(companyId);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Contact contact) {
		
		if ( contact.getId() == null ) {
			
			contact.setCompany(getCrudDao().load(Company.class, contact.getCompany().getId()));
			create(contact);
			
		} else {
			
			update(contact);
			
		}
    }


}
