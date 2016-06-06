package com.addressbook.service.response;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.addressbook.response.model.ErrorMessageEnumSerializer;

/**
 * Maintains list of error messages used to update list of error messages in
 * {@link AddressBookResponse} while processing request
 * 
 * @author Vrushali
 *
 */
@JsonSerialize(using = ErrorMessageEnumSerializer.class)
public enum ErrorMessageEnum {
	INTERNAL_SERVER_ERROR("Internal Server Error",ErrorType.ERROR),
	INVALID_REQUEST("Invalid Request", ErrorType.ERROR), 
	INVALID_NAME_ERROR("Invalid name provided. First ,Middle and Last name are required",ErrorType.ERROR), 
	MISSING_EMAIL_ADDRESS("Email address not provided.Atleast one email address is required",ErrorType.ERROR), 
	INVALID_EMAIL_ADDRESS_FORMAT("Email address is not valid",ErrorType.ERROR), 
	MISSING_CONTACT_NUMBER("Contact number not provided.Atleast one contact number is required",ErrorType.ERROR), 
	INVALID_CONTACT_NUMBER("Contact number is not valid",ErrorType.ERROR), 
	MISSING_ADDRESS("Address not provided.Atleast one address is required",ErrorType.ERROR), 
	INCOMPLETE_DELETE_REQUEST("Id missing from delete request",ErrorType.ERROR), 
	INVALID_ID("Invalid record id",ErrorType.ERROR),
	INCOMPLETE_UPDATE_REQUEST("Id missing from update request",ErrorType.ERROR), 
	RECORD_NOT_FOUND("Record not found", ErrorType.WARNING), 
	RECORD_PERSIST_ERROR("Error occured while persisting record",ErrorType.ERROR),
	RECORD_ALREADY_PRESENT("Error while persisting as record is already present",ErrorType.ERROR), 
	RECORD_NOT_FOUND_TO_PERSIST("Error occured as no record found",ErrorType.ERROR), 
	RECORD_FETCH_ERROR("Error occured while fetching records",ErrorType.ERROR),
	RECORD_DELETE_ERROR("Error occured while deleting records",ErrorType.ERROR), 
	RECORD_FETCH_BY_NAME_ERROR("Error occured while fetching record based on name and date of birth",ErrorType.ERROR), 
	PERSON_ID_MISSING_FROM_UPDATE_REQUEST("Person id missing from the update request",ErrorType.ERROR), 
	ADDRESS_ID_MISSING_FROM_UPDATE_REQUEST("Address id missing from the update request",ErrorType.ERROR),
	CONTACT_NUMBER_ID_MISSING_FROM_UPDATE_REQUEST("Contact Number id missing from the update request",ErrorType.ERROR),
	EMAIL_ADDRESS_ID_MISSING_FROM_UPDATE_REQUEST("Email Address id missing from the update request",ErrorType.ERROR), 
	INVALID_DATE_OF_BIRTH("Date of Birth is mandetory field",ErrorType.ERROR);

	private String message;
	private ErrorType errorType;

	private ErrorMessageEnum(String message, ErrorType errorType) {
		this.message = message;
		this.errorType = errorType;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errorType
	 */
	public ErrorType getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType
	 *            the errorType to set
	 */
	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}
}
