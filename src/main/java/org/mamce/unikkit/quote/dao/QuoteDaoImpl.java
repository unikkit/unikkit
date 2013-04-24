package org.mamce.unikkit.quote.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.quote.Quote;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class QuoteDaoImpl extends UnikkITDaoSupport<Quote> implements QuoteDao {

	@Override
	public List<Quote> findAllQuote() {
		return getHibernateTemplate().find("from Quote");
	}

	public void saveQuote(Quote quote) {
		saveObject(quote);
	}
	
	public void saveAllQuote(List<Quote> quotes) {
		saveAll(quotes);
	}

	@Override
	public Quote findQuoteById(long id) {
		return (Quote) getHibernateTemplate().get(Quote.class, id);
	}

	@Override
	public List<Quote> findFeaturedQuotes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Quote.class);
		criteria.addOrder(Order.asc("createdDate"));
		criteria.add(Expression.eq("active", true));
		criteria.add(Expression.eq("featured", true));
		return getHibernateTemplate().findByCriteria(criteria);
	
	}

	public void delete(Quote quote) {
		deleteObject(quote);
	}
}
