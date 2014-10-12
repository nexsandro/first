package br.com.jlabs.publish.dao.company;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.dao.IGenericDao;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.CompanyNegotiate;
import br.com.jlabs.publish.search.company.CompanySearchFilter;

public interface CompanyDao extends IGenericDao<Company> {

	List<Company> list();

	List<Company> search(CompanySearchFilter companySearchFilter);

	List<CompanyNegotiate> listNegotiations(Serializable companyId);

}
