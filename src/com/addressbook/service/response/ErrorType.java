package com.addressbook.service.response;

/**
 * Maintains error types
 * 
 * @author Vrushali
 *
 */
public enum ErrorType {
	WARNING("warning"), ERROR("error");

	private String type;

	private ErrorType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
