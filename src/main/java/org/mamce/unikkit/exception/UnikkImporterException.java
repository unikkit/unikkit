package org.mamce.unikkit.exception;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class UnikkImporterException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UnikkImporterException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public UnikkImporterException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 * @param e
	 */
	public UnikkImporterException(String message, Throwable e) {
		super(message, e);
	}
	
	/**
	 * @param e
	 */
	public UnikkImporterException(Throwable e) {
		super(e);
	}
}
