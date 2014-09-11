/**
 * 
 */
package br.com.jlabs.publish.dao.marketsegment;

import java.util.List;

import br.com.jlabs.publish.dao.IGenericDao;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
public interface MarketSegmentDao extends IGenericDao<MarketSegment> {

	/**
	 * 
	 * @param partialName
	 * @return
	 */
	public List<MarketSegment> search(String partialName);

}
