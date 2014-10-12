package br.com.jlabs.publish.business.company;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.CompanyNegotiate;
import br.com.jlabs.publish.entity.MarketSegment;

public interface CompanyBusiness {

	List<Company> list();

	Company save(Company company) throws UserException;

	Company findOne(Serializable id, String ... joinFetch);

	List<Company> search(String text);

	void delete(Long id);

	void addMarketSegment(Company company, MarketSegment marketSegment);

	void removeMarketSegment(Serializable companyId, Serializable marketSegmentId);
	
	List<CompanyNegotiate> listNegotiations(Serializable companyId);
	
}
