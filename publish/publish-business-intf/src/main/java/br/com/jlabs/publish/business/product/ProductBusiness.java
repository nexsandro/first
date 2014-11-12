package br.com.jlabs.publish.business.product;

import java.util.List;

import br.com.jlabs.publish.business.CrudBusiness;
import br.com.jlabs.publish.business.UserException;
import br.com.jlabs.publish.entity.Product;

/**
 * Product business.
 * 
 * @author sandro
 *
 */
public interface ProductBusiness extends CrudBusiness<Product> {

	List<Product> search(String partialName);

	Product save(Product company) throws UserException;
	
}
