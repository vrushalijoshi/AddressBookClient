package com.addressbook.service.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Maintains error message and error data
 * 
 * @author Vrushali
 *
 */
@JsonInclude(Include.NON_NULL)
public class ErrorMessages implements Serializable {
	/** Version UID for serialization */
	private static final long serialVersionUID = 183042660065368806L;

	/** error message enum object, with error message and error type */
	private ErrorMessageEnum errorMessage;

	/** error message data */
	private String errorMessageData;

	public ErrorMessages() {
	}

	public ErrorMessages(ErrorMessageEnum errorMessage, String errorMessageData) {
		this.errorMessage = errorMessage;
		this.errorMessageData = errorMessageData;
	}

	/**
	 * @return the errorMessage
	 */
	public ErrorMessageEnum getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(ErrorMessageEnum errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorMessageData
	 */
	public String getErrorMessageData() {
		return errorMessageData;
	}

	/**
	 * @param errorMessageData
	 *            the errorMessageData to set
	 */
	public void setErrorMessageData(String errorMessageData) {
		this.errorMessageData = errorMessageData;
	}
}
