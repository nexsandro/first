/**
 * 
 */
package br.com.jlabs.publish.dao.marketsegment;

import java.util.List;

import br.com.jlabs.publish.dao.CrudDao;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
public interface MarketSegmentDao extends CrudDao {

	/**
	 * 
	 * @param partialName
	 * @return
	 */
	public List<MarketSegment> search(String partialName);

}
