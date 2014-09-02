package br.com.jlabs.publish.web.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jlabs.publish.business.company.CompanyBusiness;

@Controller
@RequestMapping("/sec")
public class IndexController {

	@Autowired
	private CompanyBusiness companyBusiness;
	
	@RequestMapping(value="/index")
	public ModelAndView doIt(HttpServletRequest req, HttpServletResponse resp) {
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("companies", companyBusiness.list());
		
		return modelAndView;
	}

	
}
