package br.com.jlabs.publish.business.user;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.user.UserBusiness;
import br.com.jlabs.publish.dao.user.UserDAO;
import br.com.jlabs.publish.entity.User;

@Service("userBusiness")
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<User> list() {
		return userDao.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public User save(User user) {
		userDao.create(user);
		return user;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public User getUserById(Serializable id) {
		return userDao.findOne((Long) id);
	}
}
