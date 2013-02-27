package org.mamce.unikkit.exception;

/**
 * @author Ramesh
 *
 */
public class UnikkResourceException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UnikkResourceException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public UnikkResourceException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 * @param e
	 */
	public UnikkResourceException(String message, Throwable e) {
		super(message, e);
	}
	
	/**
	 * @param e
	 */
	public UnikkResourceException(Throwable e) {
		super(e);
	}
}

