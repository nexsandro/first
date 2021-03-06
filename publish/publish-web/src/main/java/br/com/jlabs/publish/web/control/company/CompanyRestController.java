package br.com.jlabs.publish.web.control.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jlabs.publish.business.company.CompanyBusiness;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.CompanyNegotiate;
import br.com.jlabs.publish.entity.view.CompanyView;
import br.com.jlabs.publish.web.control.company.dto.CompanyMarketSegment;

@Controller
@RequestMapping(value="/rest")
public class CompanyRestController {

	@Autowired
	private CompanyBusiness companyBusiness;

	@RequestMapping(value="/companies/name={text}", method=RequestMethod.GET)
	public @ResponseBody List<CompanyView> search(@PathVariable("text") String textToSearch) {
		
		List<CompanyView> result = new ArrayList<CompanyView>();
		List<Company> companies = companyBusiness.search(textToSearch);
		
		for(Company company : companies) {
			CompanyView companyView = new CompanyView();
			BeanUtils.copyProperties(company, companyView);
			result.add(companyView);
		}
		
		return result;
		
	}

	@RequestMapping(value="/companies", method=RequestMethod.GET)
	public @ResponseBody List<Company> search() {
		
		return companyBusiness.findAll();
		
	}
	
	@RequestMapping(value="/company/{companyId}/negotiations", method=RequestMethod.GET)
	public @ResponseBody List<CompanyNegotiate> listCompanyNegotiations(@PathVariable Long companyId) {
		
		return companyBusiness.listNegotiations(companyId);
		
	}
	
	@RequestMapping(value="/companies", method=RequestMethod.POST)
	public @ResponseBody Company save(@RequestBody Company company) {
		
		companyBusiness.save(company);
		
		return company;
		
	}

	@RequestMapping(value="/company/{id}", method=RequestMethod.GET)
	public @ResponseBody Company get(@PathVariable Long id) {

		return companyBusiness.findOne("id", id, "address");
		
	}
	
	@RequestMapping(value="/company/{id}", method=RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long id) {

		companyBusiness.delete(id);
		
	}
	
	@RequestMapping(value="/company/{companyId}/marketSegment/{marketSegmentId}", method=RequestMethod.DELETE)
	public @ResponseBody void removeMarketSegment(@PathVariable Long companyId, @PathVariable Long marketSegmentId) {

		companyBusiness.removeMarketSegment(companyId, marketSegmentId);
		
	}
	
	@RequestMapping(value="/company/marketSegments", method=RequestMethod.POST)
	public @ResponseBody void addMarketSegment(@RequestBody CompanyMarketSegment relation) {
		
		companyBusiness.addMarketSegment(relation.getCompany(), relation.getMarketSegment());
		
	}
	
	/**
	 * @param companyBusiness the companyBusiness to set
	 */
	public void setCompanyBusiness(CompanyBusiness companyBusiness) {
		this.companyBusiness = companyBusiness;
	}
	
}
