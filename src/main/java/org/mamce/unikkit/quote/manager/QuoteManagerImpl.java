package org.mamce.unikkit.quote.manager;

import java.util.List;

import org.mamce.unikkit.model.quote.Quote;
import org.mamce.unikkit.quote.dao.QuoteDao;

/**
 * @author Ramesh
 *
 */
public class QuoteManagerImpl implements QuoteManager {

	private QuoteDao quoteDao;
	
	/**
	 * @return the quoteDao
	 */
	public QuoteDao getQuoteDao() {
		return quoteDao;
	}

	/**
	 * @param quoteDao the quoteDao to set
	 */
	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}

	@Override
	public void saveQuote(Quote quote) {
		quoteDao.saveQuote(quote);
	}

	@Override
	public void saveAllQuote(List<Quote> quotes) {
		quoteDao.saveAllQuote(quotes);
	}

	@Override
	public List<Quote> findAllQuotes() {
		return quoteDao.findAllQuote();
	}

	@Override
	public Quote findQuoteById(long id) {
		return quoteDao.findQuoteById(id);
	}

	@Override
	public List<Quote> findFeaturedQuotes() {
		return quoteDao.findFeaturedQuotes();
	}

	@Override
	public void delete(Quote quote) {
		quoteDao.delete(quote);
	}

}
