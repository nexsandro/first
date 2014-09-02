package br.com.jlabs.publish.dao.hibernate.user;

import org.springframework.stereotype.Component;

import br.com.jlabs.publish.dao.AbstractHibernateDao;
import br.com.jlabs.publish.dao.user.UserDAO;
import br.com.jlabs.publish.entity.User;

@Component("userDAO")
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDAO {

	public UserDaoImpl() {
		super(User.class);
	}

}
