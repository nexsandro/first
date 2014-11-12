/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.product;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.product.ProductDao;
import br.com.jlabs.publish.entity.Product;

/**
 * @author sandro
 *
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Search for products that has the name as partialName.
	 */
	public List<Product> search(String partialName) {
		Session session = sessionFactory.getCurrentSession();
		
		Disjunction disj = Restrictions.disjunction();

		disj.add(Restrictions.ilike("name", partialName, MatchMode.ANYWHERE));
		
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(disj);
		
		criteria.setMaxResults(15);
		
		return criteria.list();    
	}

}
