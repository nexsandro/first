/**
 * 
 */
package br.com.jlabs.publish.web.control.company.dto;

import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
public class CompanyMarketSegment {

	/**
	 * Companhia.
	 */
	private Company company;
	
	/**
	 * marketSegment.
	 */
	private MarketSegment marketSegment;
	
	/**
	 * Default constructor
	 */
	public CompanyMarketSegment() {
	    super();
    }

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the marketSegment
	 */
	public MarketSegment getMarketSegment() {
		return marketSegment;
	}

	/**
	 * @param marketSegment the marketSegment to set
	 */
	public void setMarketSegment(MarketSegment marketSegment) {
		this.marketSegment = marketSegment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    return "CompanyMarketSegment [company=" + company + ", marketSegment="
	            + marketSegment + "]";
    }

}
