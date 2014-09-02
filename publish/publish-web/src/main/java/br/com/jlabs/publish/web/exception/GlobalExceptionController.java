package br.com.jlabs.publish.web.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice
 * 
 * @author sandro
 *
 */
public class GlobalExceptionController {

	@Autowired
	MessageSource messageSource;
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e, HttpServletResponse response) {
		
		response.setHeader("Exception", e.toString());

		response.setHeader("Exception-Message", e.getMessage());
		
		ModelAndView result = new ModelAndView("/exception/exception");
		result.addObject("exception", e);
		
		return result;
	}

	/**
	 * @param messageSource the messageSource to set
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
