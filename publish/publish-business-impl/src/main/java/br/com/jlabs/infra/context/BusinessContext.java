package br.com.jlabs.infra.context;

public interface BusinessContext {

	public boolean isUserInRole(String roleName);
	
	public String getUserName();
	
	public String getUserIp();
	
}
