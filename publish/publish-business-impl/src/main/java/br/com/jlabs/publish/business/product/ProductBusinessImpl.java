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

	/**
	 * Delete the company identified by id.
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Long id) {

		Product product = productDao.load(id);
	    
		productDao.delete(product);
    }
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Product save(Product product) throws UserException {

		// Adjust product
		if (product.getId() != null) {
			productDao.update(product);
		} else {
			productDao.create(product);
		}
		
		return product;
	}

}
