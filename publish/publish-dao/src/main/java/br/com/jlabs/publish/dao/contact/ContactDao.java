/**
 * 
 */
package br.com.jlabs.publish.dao.contact;

import java.util.List;

import br.com.jlabs.publish.dao.IGenericDao;
import br.com.jlabs.publish.entity.Contact;

/**
 * @author sandro
 *
 */
public interface ContactDao extends IGenericDao<Contact> {

	List<Contact> list(Long companyId);
	
}
