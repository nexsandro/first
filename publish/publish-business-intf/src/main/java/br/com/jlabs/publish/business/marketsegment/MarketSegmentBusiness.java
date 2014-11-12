/**
 * 
 */
package br.com.jlabs.publish.business.marketsegment;

import java.util.List;

import br.com.jlabs.publish.business.CrudBusiness;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
public interface MarketSegmentBusiness extends CrudBusiness<MarketSegment> {

	public List<MarketSegment> search(String partialName);

}
