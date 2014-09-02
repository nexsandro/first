/**
 * 
 */
package br.com.jlabs.publish.web.control.uc01_home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * Home Page Controller
 * 
 * @author sandro
 *
 */
@Controller
@RequestMapping("/rest")
public class HomeController {

	/**
	 * Show home page
	 * @return model and view
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home() {
		
		return new ModelAndView("home/index");
		
	}
}
