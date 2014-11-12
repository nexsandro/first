/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.address;

import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.address.AddressDao;
import br.com.jlabs.publish.dao.hibernate.CrudDaoImpl;

/**
 * @author sandro
 *
 */
@Repository("addressDao")
public class AddressDaoImpl extends CrudDaoImpl implements AddressDao {

}
