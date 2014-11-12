/**
 * 
 */
package br.com.jlabs.publish.business.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.AbstractCrudBusiness;
import br.com.jlabs.publish.business.marketsegment.MarketSegmentBusiness;
import br.com.jlabs.publish.dao.marketsegment.MarketSegmentDao;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
@Service("marketSegmentBusiness")
public class MarketSegmentBusinessImpl extends AbstractCrudBusiness<MarketSegment> implements MarketSegmentBusiness {

	@Autowired
	private MarketSegmentDao marketSegmentDao;
	
	/**
	 * Default constructor.
	 */
	public MarketSegmentBusinessImpl() {
	    super(MarketSegment.class);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<MarketSegment> search(String partialName) {
		
		return marketSegmentDao.search(partialName);
		
	}
	
}
