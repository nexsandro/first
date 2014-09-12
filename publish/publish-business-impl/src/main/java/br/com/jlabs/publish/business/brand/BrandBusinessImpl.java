/**
 * 
 */
package br.com.jlabs.publish.business.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.dao.brand.BrandDao;
import br.com.jlabs.publish.entity.Brand;

/**
 * @author sandro
 *
 */
@Service("brandBusiness")
public class BrandBusinessImpl implements BrandBusiness {

	@Autowired
	private BrandDao brandDao;

	/**
	 * Return list of all products
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Brand> list() {
	    return brandDao.findAll();
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Brand findOne(Long brandId) {
		return brandDao.findOne(brandId);
	}

	/**
	 * Delete the company identified by id.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Long id) {

		Brand brand = brandDao.load(id);
	    
		brandDao.delete(brand);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Brand save(Brand brand) throws UserException {

		if (brand.getId() != null) {
			brandDao.update(brand);
		} else {
			brandDao.create(brand);
		}
		
		return brand;
	}	
}
