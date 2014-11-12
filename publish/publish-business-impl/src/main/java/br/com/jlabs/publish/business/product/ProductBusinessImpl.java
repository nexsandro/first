/**
 * 
 */
package br.com.jlabs.publish.business.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlabs.publish.business.AbstractCrudBusiness;
import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.dao.product.ProductDao;
import br.com.jlabs.publish.entity.Product;

/**
 * @author sandro
 *
 */
@Service("productBusiness")
public class ProductBusinessImpl extends AbstractCrudBusiness<Product> implements ProductBusiness {

	@Autowired
	private ProductDao productDao;

	/**
	 * 
	 */
	public ProductBusinessImpl() {
	    super(Product.class);
    }
	
	/* (non-Javadoc)
	 * @see br.com.jlabs.publish.business.product.ProductBusiness#search(java.lang.String)
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Product> search(String partialName) {
		
		return productDao.search(partialName);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Product save(Product product) throws UserException {

		// Adjust product
		if (product.getId() != null) {
			update(product);
		} else {
			create(product);
		}
		
		return product;
	}

}
