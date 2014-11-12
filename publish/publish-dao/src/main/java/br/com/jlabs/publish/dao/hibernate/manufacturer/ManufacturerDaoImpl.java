/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.manufacturer;

import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.hibernate.CrudDaoImpl;
import br.com.jlabs.publish.dao.manufacturer.ManufacturerDao;

/**
 * @author sandro
 *
 */
@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends CrudDaoImpl implements ManufacturerDao {

}
