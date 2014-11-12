/**
 * 
 */
package br.com.jlabs.publish.dao.product;

import java.util.List;

import br.com.jlabs.publish.entity.Product;

/**
 * @author sandro
 *
 */
public interface ProductDao {

	List<Product> search(String text);
	
}
