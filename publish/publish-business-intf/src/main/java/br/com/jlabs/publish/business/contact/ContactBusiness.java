package br.com.jlabs.publish.business.contact;

import java.util.List;

import br.com.jlabs.publish.business.CrudBusiness;
import br.com.jlabs.publish.entity.Contact;

public interface ContactBusiness extends CrudBusiness<Contact> {

	/**
	 * List all the contacts of the refered company
	 * @param companyId
	 * @return
	 */
	List<Contact> list(Long companyId);
	
	void save(Contact company);

}
