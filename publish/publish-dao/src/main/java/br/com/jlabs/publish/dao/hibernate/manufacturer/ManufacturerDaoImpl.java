/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.manufacturer;

import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.AbstractHibernateDao;
import br.com.jlabs.publish.dao.manufacturer.ManufacturerDao;
import br.com.jlabs.publish.entity.Manufacturer;

/**
 * @author sandro
 *
 */
@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends AbstractHibernateDao<Manufacturer> implements ManufacturerDao {

	public ManufacturerDaoImpl() {
	    super(Manufacturer.class);
    }

}
