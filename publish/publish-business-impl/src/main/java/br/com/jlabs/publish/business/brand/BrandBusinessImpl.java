/**
 * 
 */
package br.com.jlabs.publish.business.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.AbstractCrudBusiness;
import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.dao.brand.BrandDao;
import br.com.jlabs.publish.entity.Brand;

/**
 * @author sandro
 *
 */
@Service("brandBusiness")
public class BrandBusinessImpl extends AbstractCrudBusiness<Brand> implements BrandBusiness {

	@Autowired
	private BrandDao brandDao;

	/**
	 * Default constructor
	 */
	public BrandBusinessImpl() {
	    super(Brand.class);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Brand save(Brand brand) throws UserException {

		if (brand.getId() != null) {
			update(brand);
		} else {
			create(brand);
		}
		
		return brand;
	}
	
}
