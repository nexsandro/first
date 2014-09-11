/**
 * 
 */
package br.com.jlabs.publish.business.contact;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.marketsegment.MarketSegmentBusiness;
import br.com.jlabs.publish.dao.marketsegment.MarketSegmentDao;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
@Service("marketSegmentBusiness")
public class MarketSegmentBusinessImpl implements MarketSegmentBusiness {

	@Autowired
	private MarketSegmentDao marketSegmentDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public List<MarketSegment> search(String partialName) {
		
		return marketSegmentDao.search(partialName);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public MarketSegment findOne(Serializable marketSegmentId, String ... joinFetchs) {

		return marketSegmentDao.findOne("id", marketSegmentId, joinFetchs);
		
	}
	
}
