/**
 * 
 */
package br.com.jlabs.publish.business.marketsegment;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
public interface MarketSegmentBusiness {

	public MarketSegment findOne(Serializable marketSegmentId, String ... joinFetchs);

	public List<MarketSegment> search(String partialName);

}
