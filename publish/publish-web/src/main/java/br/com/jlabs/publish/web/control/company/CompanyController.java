package br.com.jlabs.publish.web.control.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.business.company.CompanyBusiness;
import br.com.jlabs.publish.entity.Company;

@Controller
@RequestMapping(value="/sec/company")
public class CompanyController {

	@Autowired
	private CompanyBusiness companyBusiness;
	
	@RequestMapping("/list")
	public ModelAndView list() {
		
		List<Company> companies = companyBusiness.findAll();
		ModelAndView modelAndView = new ModelAndView("/company/list");
		modelAndView.addObject("companies", companies);
		return modelAndView;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(Company company, BindingResult companyBindingResult) {
		
		if (company.getId() != null)
			company = companyBusiness.findOne(company.getId());
		
		ModelAndView modelAndView = new ModelAndView("/company/edit");
		modelAndView.addObject("company", company);
		
		return modelAndView;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(Company company, BindingResult companyBindingResult) throws UserException {
		
		companyBusiness.save(company);
		
		return new ModelAndView("redirect:list");
	}
	
	public void setCompanyBusiness(CompanyBusiness companyBusiness) {
		this.companyBusiness = companyBusiness;
	}
}
