/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.brand;

import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.brand.BrandDao;
import br.com.jlabs.publish.dao.hibernate.CrudDaoImpl;

/**
 * @author sandro
 *
 */
@Repository("brandDao")
public class BrandDaoImpl extends CrudDaoImpl implements BrandDao {

}
