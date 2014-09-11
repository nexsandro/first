package br.com.jlabs.publish.business.contact;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.entity.Contact;

public interface ContactBusiness {

	/**
	 * List all the contacts of the refered company
	 * @param companyId
	 * @return
	 */
	List<Contact> list(Long companyId);
	
	Contact findOne(Serializable key, String ... joinFetch);

	void save(Contact company);

	void delete(Long id);
	
}
