package br.com.jlabs.publish.dao.hibernate.company;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jlabs.publish.dao.company.CompanyDao;
import br.com.jlabs.publish.dao.hibernate.CrudDaoImpl;
import br.com.jlabs.publish.entity.Company;
import br.com.jlabs.publish.entity.CompanyNegotiate;
import br.com.jlabs.publish.search.company.CompanySearchFilter;

@Repository("companyDao")
public class CompanyDaoImpl extends CrudDaoImpl implements CompanyDao {


	public List<CompanyNegotiate> listNegotiations(Serializable companyId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria crit = session.createCriteria(CompanyNegotiate.class);
		crit.add(Restrictions.eq("company.id", companyId));
		
		return crit.list();
	}
	
	public List<Company> search(CompanySearchFilter companySearchFilter) {

		Session session = sessionFactory.getCurrentSession();
		
		Disjunction disj = Restrictions.disjunction();

		disj.add(Restrictions.ilike("name", companySearchFilter.getText(), MatchMode.ANYWHERE));
		disj.add(Restrictions.ilike("cnpj", companySearchFilter.getText(), MatchMode.ANYWHERE));
		
		Criteria criteria = session.createCriteria(Company.class);
		criteria.add(disj);
		
		return criteria.list();
		
	}

}
