package br.com.jlabs.publish.business.company;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.entity.Company;

public interface CompanyBusiness {

	List<Company> list();

	Company save(Company company) throws UserException;

	Company findOne(Serializable id, String[] joinFetch);

	List<Company> search(String text);

	Company findOne(Long id);
	
}
