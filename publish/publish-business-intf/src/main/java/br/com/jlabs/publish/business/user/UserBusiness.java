package br.com.jlabs.publish.business.user;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.entity.User;

public interface UserBusiness {

	User save(User user);
	
	List<User> list();
	
	User getUserById(Serializable id);
}
