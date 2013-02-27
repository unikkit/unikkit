package org.mamce.unikkit.exception;

/**
 * @author Ramesh
 *
 */
public class UnikkWebException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UnikkWebException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public UnikkWebException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 * @param e
	 */
	public UnikkWebException(String message, Throwable e) {
		super(message, e);
	}
	
	/**
	 * @param e
	 */
	public UnikkWebException(Throwable e) {
		super(e);
	}
}