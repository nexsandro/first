package br.com.jlabs.publish.business.company;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.dao.address.AddressDao;
import br.com.jlabs.publish.dao.company.CompanyDao;
import br.com.jlabs.publish.dao.marketsegment.MarketSegmentDao;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.MarketSegment;
import br.com.jlabs.publish.search.company.CompanySearchFilter;

@Service("companyBusiness")
public class CompanyBusinessImpl implements CompanyBusiness {

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private MarketSegmentDao marketSegmentDao;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Company> list() {

		return companyDao.findAll();
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
	public Company findOne(Serializable key, String ... joinFetch) {
		return companyDao.findOne("id", key, joinFetch);
	}
	
	/**
	 * Search for text.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Company> search(String text) {
		return companyDao.search(new CompanySearchFilter(text));
	}

	/**
	 * Delete the company identified by id.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Long id) {

		Company company = companyDao.load(id);
	    
		companyDao.delete(company);
    }

	/**
	 * Add the market segment to the company collection.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addMarketSegment(Company company, MarketSegment marketSegment) {
	    
		// Add if not exist market segment
		if (marketSegment.getId() == null) {
			marketSegmentDao.create(marketSegment);
		} else {
			marketSegment = marketSegmentDao.load(marketSegment.getId());
		}
	    
		// Associate to the company, must exist.
		company = companyDao.load(company.getId());
		company.getMarketSegments().add(marketSegment);
		companyDao.update(company);
		
    }

	/**
	 * Remove association of market segment.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeMarketSegment(Serializable companyId, Serializable marketSegmentId) {
	    
		Company company = companyDao.load(companyId);
	    MarketSegment marketSegment = marketSegmentDao.load(marketSegmentId);
	    
		company.getMarketSegments().remove(marketSegment);
		
    }
	
}
