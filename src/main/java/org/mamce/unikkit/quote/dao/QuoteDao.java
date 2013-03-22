package org.mamce.unikkit.quote.dao;

import java.util.List;

import org.mamce.unikkit.model.quote.Quote;

public interface QuoteDao {

	List<Quote> findAllQuote();
	List<Quote> findFeaturedQuotes();
	Quote findQuoteById(long id);
	void saveQuote(Quote quote);
	void saveAllQuote(List<Quote> quotes);
	void delete(Quote quote);
}
