package br.com.jlabs.publish.web.control.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jlabs.publish.business.contact.ContactBusiness;
import br.com.jlabs.publish.entity.Contact;

@Controller
@RequestMapping(value="/rest")
public class ContactRestController {

	@Autowired
	private ContactBusiness contactBusiness;
	
	@RequestMapping(value="/contacts/company.id={companyId}", method=RequestMethod.GET)
	public @ResponseBody List<Contact> search(@PathVariable("companyId") Long companyId) {
		
		return contactBusiness.list(companyId);
		
	}

	@RequestMapping(value="/contact/{id}", method=RequestMethod.GET)
	public @ResponseBody Contact get(@PathVariable Long id) {

		return contactBusiness.findOne(id, "company");
		
	}

	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public @ResponseBody Contact save(@RequestBody Contact contact) {
		
		contactBusiness.save(contact);
		
		return contact;
		
	}
}
