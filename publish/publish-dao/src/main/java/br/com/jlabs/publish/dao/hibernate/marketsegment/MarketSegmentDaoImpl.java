/**
 * 
 */
package br.com.jlabs.publish.dao.hibernate.marketsegment;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.AbstractHibernateDao;
import br.com.jlabs.publish.dao.marketsegment.MarketSegmentDao;
import br.com.jlabs.publish.entity.MarketSegment;

/**
 * @author sandro
 *
 */
@Repository("marketSegmentDao")
public class MarketSegmentDaoImpl extends AbstractHibernateDao<MarketSegment> implements
        MarketSegmentDao {

	/**
	 * Default constructor.
	 */
	public MarketSegmentDaoImpl() {
	    super(MarketSegment.class);
    }
	
	/**
	 * Search Market segment by name
	 * @param partialName
	 * @return
	 */
	public List<MarketSegment> search(String partialName) {

		Session session = sessionFactory.getCurrentSession();
		
		Disjunction disj = Restrictions.disjunction();

		disj.add(Restrictions.ilike("name", partialName, MatchMode.ANYWHERE));
		
		Criteria criteria = session.createCriteria(MarketSegment.class);
		criteria.add(disj);
		
		return criteria.list();
		
	}

	
}
