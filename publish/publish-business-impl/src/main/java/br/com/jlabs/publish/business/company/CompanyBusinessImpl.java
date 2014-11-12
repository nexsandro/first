package br.com.jlabs.publish.business.company;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.AbstractCrudBusiness;
import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.dao.company.CompanyDao;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.CompanyNegotiate;
import br.com.jlabs.publish.entity.MarketSegment;
import br.com.jlabs.publish.search.company.CompanySearchFilter;

@Service("companyBusiness")
public class CompanyBusinessImpl extends AbstractCrudBusiness<Company> implements CompanyBusiness {

	@Autowired
	private CompanyDao companyDao;
	
	/**
	 * Default constructor.
	 */
	public CompanyBusinessImpl() {
	    super(Company.class);
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public Company save(Company company) throws UserException {

		// Adjust address
		if (company.getAddress() != null) {
			if (company.getAddress().getId() != null) {
				company.setAddress(getCrudDao().update(company.getAddress()));
			} else {
				getCrudDao().create(company.getAddress());
			}
		}
		
		if (company.getId() != null) {
			update(company);
		} else {
			create(company);
		}
		
		return company;
	}

	/**
	 * Search for text.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Company> search(String text) {
		return companyDao.search(new CompanySearchFilter(text));
	}

	/**
	 * Add the market segment to the company collection.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void addMarketSegment(Company company, MarketSegment marketSegment) {
	    
		// Add if not exist market segment
		if (marketSegment.getId() == null) {
			getCrudDao().create(marketSegment);
		} else {
			marketSegment = getCrudDao().load(MarketSegment.class, marketSegment.getId());
		}
	    
		// Associate to the company, must exist.
		company = load(company.getId());
		company.getMarketSegments().add(marketSegment);
		getCrudDao().update(company);
		
    }

	/**
	 * Remove association of market segment.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeMarketSegment(Serializable companyId, Serializable marketSegmentId) {
	    
		Company company = load(companyId);
	    MarketSegment marketSegment = getCrudDao().load(MarketSegment.class, marketSegmentId);
	    
		company.getMarketSegments().remove(marketSegment);
		
    }

	@Transactional(propagation=Propagation.REQUIRED)
	public List<CompanyNegotiate> listNegotiations(Serializable companyId) {
	    return companyDao.listNegotiations(companyId);
    }
	
}
