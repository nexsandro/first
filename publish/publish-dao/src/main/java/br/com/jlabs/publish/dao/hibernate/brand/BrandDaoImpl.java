/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.brand;

import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.AbstractHibernateDao;
import br.com.jlabs.publish.dao.brand.BrandDao;
import br.com.jlabs.publish.entity.Brand;

/**
 * @author sandro
 *
 */
@Repository("brandDao")
public class BrandDaoImpl extends AbstractHibernateDao<Brand> implements BrandDao {

	public BrandDaoImpl() {
	    super(Brand.class);
    }

}
