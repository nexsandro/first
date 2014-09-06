/**
 * 
 */
package br.com.jlabs.publish.business.product;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.dao.brand.BrandDao;
import br.com.jlabs.publish.dao.manufacturer.ManufacturerDao;
import br.com.jlabs.publish.dao.product.ProductDao;
import br.com.jlabs.publish.entity.Product;

/**
 * @author sandro
 *
 */
@Service("productBusiness")
public class ProductBusinessImpl implements ProductBusiness {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private BrandDao brandDao;

	@Autowired
	private ManufacturerDao manufacturerDao;
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.publish.business.product.ProductBusiness#search(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Product> search(String partialName) {
		
		return productDao.search(partialName);
	}

	/**
	 * Return list of all products
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Product> list() {
	    return productDao.findAll();
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Product findOne(Long id) {
		return productDao.findOne(id);
	}

	/**
	 * Retrieve company by id.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Product findOne(Serializable key, String[] joinFetch) {
		return productDao.findOne("id", key, joinFetch);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Product save(Product product) throws UserException {

		// Adjust brand
		if (product.getBrand() != null) {
			if (product.getBrand().getId() != null) {
				product.setBrand(brandDao.update(product.getBrand()));
			} else {
				brandDao.create(product.getBrand());
			}
		}

		// Adjust manufacturer
		if (product.getManufacturer() != null) {
			if (product.getManufacturer().getId() != null) {
				product.setManufacturer(manufacturerDao.update(product.getManufacturer()));
			} else {
				manufacturerDao.create(product.getManufacturer());
			}
		}

		// Adjust product
		if (product.getId() != null) {
			productDao.update(product);
		} else {
			productDao.create(product);
		}
		
		return product;
	}

}
