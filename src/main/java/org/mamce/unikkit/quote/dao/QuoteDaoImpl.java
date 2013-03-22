package org.mamce.unikkit.quote.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.event.Event;
import org.mamce.unikkit.model.quote.Quote;

/**
 * @author Ramesh
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
		Criteria criteria = getSession().createCriteria(Quote.class);
		criteria.addOrder(Order.asc("createdDate"));
		criteria.add(Expression.eq("active", true));
		criteria.add(Expression.eq("featured", true));
		
		return criteria.list();
	
	}

	public void delete(Quote quote) {
		deleteObject(quote);
	}
}
