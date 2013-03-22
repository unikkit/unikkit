package org.mamce.unikkit.web.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;
import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.model.quote.Quote;
import org.mamce.unikkit.quote.manager.QuoteManager;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@ApplicationScoped
public class ManageQuotesBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(ManageQuotesBean.class);
	
	private String who;
	private String what;
	private String avatarImgUri;
	private boolean active = true;
	private boolean featured;
	
	@ManagedProperty(value=MP_QUOTE_MANAGER)
	private QuoteManager quoteManager;
	
	private Quote selectedQuote;
	
	/**
	 * @return the who
	 */
	public String getWho() {
		return who;
	}
	/**
	 * @param who the who to set
	 */
	public void setWho(String who) {
		this.who = who;
	}
	/**
	 * @return the what
	 */
	public String getWhat() {
		return what;
	}
	/**
	 * @param what the what to set
	 */
	public void setWhat(String what) {
		this.what = what;
	}
	
	/**
	 * @return the avatarImgUri
	 */
	public String getAvatarImgUri() {
		return avatarImgUri;
	}
	/**
	 * @param avatarImgUri the avatarImgUri to set
	 */
	public void setAvatarImgUri(String avatarImgUri) {
		this.avatarImgUri = avatarImgUri;
	}
	
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the featured
	 */
	public boolean isFeatured() {
		return featured;
	}
	/**
	 * @param featured the featured to set
	 */
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	/**
	 * @return the quoteManager
	 */
	public QuoteManager getQuoteManager() {
		return quoteManager;
	}
	/**
	 * @param quoteManager the quoteManager to set
	 */
	public void setQuoteManager(QuoteManager quoteManager) {
		this.quoteManager = quoteManager;
	}
	
	/**
	 * @return the selectedQuote
	 */
	public Quote getSelectedQuote() {
		return selectedQuote;
	}
	/**
	 * @param selectedQuote the selectedQuote to set
	 */
	public void setSelectedQuote(Quote selectedQuote) {
		this.selectedQuote = selectedQuote;
	}
	
	private void clearForm() {
		setId(Constants.UNSAVED_ID);
		setActive(true);
		setFeatured(false);
		setWhat("");
		setWho("");
		
		// TODO: RK: Set default avatar picture
	}
	/**
	 * @param event
	 */
	public void handleWhoSaidAvatar(FileUploadEvent event) {
		System.out.println("Starting upload...");
	}
	
	public List<Quote> getAllQuotes() {
		return quoteManager.findAllQuotes();
	}
	
	public void addNewQuote() {
		Quote quote = new Quote();
		
		quote.setActive(isActive());
		quote.setFeatured(isFeatured());
		quote.setWhat(getWhat());
		quote.setWho(getWho());
		
		quoteManager.saveQuote(quote);
		
		LOGGER.info("New quote added successfully!");
		
		clearForm();
	}
	
	public void onQuotesRowEdit(RowEditEvent event) {
		Quote currentQuote = (Quote) event.getObject();
		
		if(currentQuote != null) {
			Quote existingQuote = quoteManager.findQuoteById(currentQuote.getId());
			
			if(existingQuote == null) {
				LOGGER.error("Unable to find the quote.");
				return;
			}
			
			existingQuote.setWhat(currentQuote.getWhat());
			existingQuote.setWho(currentQuote.getWho());
			existingQuote.setActive(currentQuote.isActive());
			existingQuote.setFeatured(currentQuote.isFeatured());
			
			quoteManager.saveQuote(existingQuote);
			LOGGER.info("Quote updated successfully!");
		}
	}

	public void onQuotesRowEditCancel(RowEditEvent event) {
		
	}
	
	public void deleteQuotes() {
		if(selectedQuote != null) {
			Quote existingQuote = quoteManager.findQuoteById(selectedQuote.getId());
			
			if(existingQuote == null) {
				LOGGER.error("Unable to find the quote.");
				return;
			}
			
			quoteManager.delete(existingQuote);
			LOGGER.info("Quote deleted!");
		}
	
	}
}
