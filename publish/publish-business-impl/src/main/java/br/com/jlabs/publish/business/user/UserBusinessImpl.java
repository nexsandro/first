package br.com.jlabs.publish.business.user;

import org.springframework.stereotype.Service;

import br.com.jlabs.publish.business.AbstractCrudBusiness;
import br.com.jlabs.publish.entity.User;

@Service("userBusiness")
public class UserBusinessImpl extends AbstractCrudBusiness<User> implements UserBusiness {

	/**
	 * Default constructor.
	 */
	public UserBusinessImpl() {
	    super(User.class);
    }

}
