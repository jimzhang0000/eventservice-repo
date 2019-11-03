package org.jimzh.mini.events.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8068159478691321443L;
	
	public DataNotFoundException(String event) {
		super(event);
	}
}
