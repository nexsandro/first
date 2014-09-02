package br.com.jlabs.publish.web.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/common")
public class LoginController {

	@RequestMapping(value="/login")
	public ModelAndView login(String method, HttpServletResponse response) {
		
		ModelAndView result = new ModelAndView("/common/login");

		if (method != null && method.length() > 0)
			result.addObject("msg", "Erro ao tentar login, tente novamente!");
		
		return result;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) session.invalidate();
		
		Cookie cookie = new Cookie("JSESSIONIDSSO", "");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
		return "redirect:/";
	}
}
