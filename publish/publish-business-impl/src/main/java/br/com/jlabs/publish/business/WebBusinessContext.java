package br.com.jlabs.publish.business;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.jlabs.infra.context.BusinessContext;

@Service
public class WebBusinessContext implements BusinessContext {

	public boolean isUserInRole(String roleName) {
		return getRequest().isUserInRole(roleName);
	}

	public String getUserName() {
		HttpServletRequest request = getRequest();
		return request == null ? 
				null : 
				request.getUserPrincipal() == null ?
						null : request.getUserPrincipal().getName();
	}
	
	public String getUserIp() {
		return getRequest().getRemoteAddr();
	}
	
	private HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
	}
	
}
