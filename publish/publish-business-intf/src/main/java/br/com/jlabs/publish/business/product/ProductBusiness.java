package br.com.jlabs.publish.business.product;

import java.io.Serializable;
import java.util.List;

import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.entity.Product;

/**
 * Product business.
 * 
 * @author sandro
 *
 */
public interface ProductBusiness {

	List<Product> list();

	List<Product> search(String partialName);

	Product save(Product company) throws UserException;
	
	Product findOne(Long id);
	
	Product findOne(Serializable key, String[] joinFetch);
	
}
