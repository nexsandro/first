package br.com.jlabs.publish.web.control.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jlabs.publish.business.user.UserBusiness;
import br.com.jlabs.publish.entity.User;

@Controller
@RequestMapping(value="/sec/user")
public class UserController {

	@Autowired
	private UserBusiness userBusiness;

	
	@RequestMapping("/list")
	public ModelAndView list() {
		
		List<User> users = userBusiness.findAll();
		ModelAndView modelAndView = new ModelAndView("/user/list");
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(User user, BindingResult bindingResult) {
		
		if (user.getId() != null)
			user = userBusiness.findOne(user.getId());
		
		ModelAndView modelAndView = new ModelAndView("/user/edit");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}

	/**
	 * @param userBusiness the userBusiness to set
	 */
	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	
}
