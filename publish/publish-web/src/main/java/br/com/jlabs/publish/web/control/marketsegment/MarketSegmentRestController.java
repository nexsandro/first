/**
 * 
 */
package br.com.jlabs.publish.web.control.marketsegment;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jlabs.publish.business.company.CompanyBusiness;
import br.com.jlabs.publish.business.marketsegment.MarketSegmentBusiness;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
@Controller
@RequestMapping(value="/rest")
public class MarketSegmentRestController {

	@Autowired
	private MarketSegmentBusiness marketSegmentBusiness;
	
	@Autowired
	private CompanyBusiness companyBusiness;
	
	@RequestMapping(value="/marketsegment/name={partialName}", method=RequestMethod.GET)
	public @ResponseBody List<MarketSegment> search(@PathVariable("partialName") String partialName) {
		
		return marketSegmentBusiness.search(partialName);
	}
	
	@RequestMapping(value="/company/{companyId}/marketSegments", method=RequestMethod.GET)
	public @ResponseBody Set<MarketSegment> list(@PathVariable("companyId") Long companyId) {
		
		return companyBusiness.findOne(companyId, "marketSegments").getMarketSegments();
	}

	@RequestMapping(value="/marketSegment/{marketSegmentId}", method=RequestMethod.GET)
	public @ResponseBody MarketSegment get(@PathVariable Long marketSegmentId) {

		return marketSegmentBusiness.findOne(marketSegmentId);
		
	}
	
}
