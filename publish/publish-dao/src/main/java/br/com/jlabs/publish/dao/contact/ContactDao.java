/**
 * 
 */
package br.com.jlabs.publish.dao.contact;

import java.util.List;

import br.com.jlabs.publish.dao.CrudDao;
import br.com.jlabs.publish.entity.Contact;

/**
 * @author sandro
 *
 */
public interface ContactDao extends CrudDao {

	List<Contact> list(Long companyId);
	
}
