/**
 * 
 */
package com.cdac.hibernate.exception;

/**
 * @author Smita B Kumar
 *
 */
public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4141341996193194885L;

	/**
	 * 
	 */
	public CustomerException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CustomerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public CustomerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CustomerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
