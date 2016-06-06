package com.addressbook.response.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Maintains email address details corresponding to the person record
 * 
 * @author Vrushali
 *
 */
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class EmailAddressDetails extends BaseModel {

	/** Version UID for serialization */
	private static final long serialVersionUID = 7539205834443159760L;

	/** email address */
	private String emailAddress;

	public EmailAddressDetails() {
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
