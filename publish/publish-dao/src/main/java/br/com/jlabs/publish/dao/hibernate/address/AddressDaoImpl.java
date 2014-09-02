/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.address;

import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.AbstractHibernateDao;
import br.com.jlabs.publish.dao.company.AddressDao;
import br.com.jlabs.publish.entity.Address;

/**
 * @author sandro
 *
 */
@Repository("addressDao")
public class AddressDaoImpl extends AbstractHibernateDao<Address> implements AddressDao {

	/**
	 * Default constructor
	 */
	public AddressDaoImpl() {
	    super(Address.class);
    }

}
