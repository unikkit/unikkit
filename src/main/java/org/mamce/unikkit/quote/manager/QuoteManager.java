package org.mamce.unikkit.quote.manager;

import java.util.List;

import org.mamce.unikkit.model.quote.Quote;

/**
 * @author Ramesh
 *
 */
public interface QuoteManager {

	void saveQuote(Quote quote);
	void saveAllQuote(List<Quote> quotes);
	List<Quote> findAllQuotes();
	List<Quote> findFeaturedQuotes();
	Quote findQuoteById(long id);
	void delete(Quote quote);

}
