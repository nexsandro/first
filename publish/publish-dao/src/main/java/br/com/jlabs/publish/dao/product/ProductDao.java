/**
 * 
 */
package br.com.jlabs.publish.dao.product;

import java.util.List;

import br.com.jlabs.publish.dao.IGenericDao;
import br.com.jlabs.publish.entity.Product;

/**
 * @author sandro
 *
 */
public interface ProductDao extends IGenericDao<Product> {

	List<Product> search(String text);
	
}
