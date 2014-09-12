/**
 * 
 */
package br.com.jlabs.publish.business.brand;

import java.util.List;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.entity.Brand;

/**
 * @author sandro
 *
 */
public interface BrandBusiness {

	List<Brand> list();

	Brand findOne(Long brandId);

	Brand save(Brand brand) throws UserException;

	void delete(Long brandId);

}
