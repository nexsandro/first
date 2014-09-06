package br.com.jlabs.publish.business.company;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.dao.company.AddressDao;
import br.com.jlabs.publish.dao.company.CompanyDao;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.search.company.CompanySearchFilter;

@Service("companyBusiness")
public class CompanyBusinessImpl implements CompanyBusiness {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private AddressDao addressDao;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Company> list() {

		return companyDao.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Company findOne(Long id) {
		return companyDao.findOne(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Company save(Company company) throws UserException {

		// Adjust address
		if (company.getAddress() != null) {
			if (company.getAddress().getId() != null) {
				company.setAddress(addressDao.update(company.getAddress()));
			} else {
				addressDao.create(company.getAddress());
			}
		}
		
		if (company.getId() != null) {
			companyDao.update(company);
		} else {
			companyDao.create(company);
		}
		
		return company;
	}

	/**
	 * @param companyDao the companyDao to set
	 */
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	/**
	 * @return the addressDao
	 */
	public AddressDao getAddressDao() {
		return addressDao;
	}

	/**
	 * @param addressDao the addressDao to set
	 */
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	/**
	 * Retrieve company by id.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Company findOne(String keyField, Serializable key, String[] joinFetch) {
		return companyDao.findOne(keyField, key, joinFetch);
	}
	
	/**
	 * Search for text.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Company> search(String text) {
		return companyDao.search(new CompanySearchFilter(text));
	}
	
}
