package br.com.jlabs.publish.dao.hibernate.user;

import org.springframework.stereotype.Component;

import br.com.jlabs.publish.dao.hibernate.CrudDaoImpl;
import br.com.jlabs.publish.dao.user.UserDao;

@Component("userDAO")
public class UserDaoImpl extends CrudDaoImpl implements UserDao {


}
