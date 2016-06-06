package com.addressbook.response.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Maintains details corresponding to the person record
 * 
 * @author Vrushali
 *
 */
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class PersonDetails extends BaseModel {

	/** Version UID for serialization */
	private static final long serialVersionUID = -5676020321577013777L;

	/** first name */
	private String firstName;
	/** middle name */
	private String middleName;
	/** last name */
	private String lastName;
	/** date of birth */
	private DateTime dateOfBirth;
	/** list of email addresses */
	@JsonDeserialize(as = ArrayList.class, contentAs = EmailAddressDetails.class)
	private List<EmailAddressDetails> emailAddressDetails;
	/** list of contact numbers */
	@JsonDeserialize(as = ArrayList.class, contentAs = ContactNumberDetails.class)
	private List<ContactNumberDetails> contactNumberDetails;
	/** list of addresses */
	@JsonDeserialize(as = ArrayList.class, contentAs = AddressDetails.class)
	private List<AddressDetails> addressDetails;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(DateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the emailAddressDetails
	 */
	public List<EmailAddressDetails> getEmailAddressDetails() {
		return emailAddressDetails;
	}

	/**
	 * @param emailAddressDetails
	 *            the emailAddressDetails to set
	 */
	public void setEmailAddressDetails(List<EmailAddressDetails> emailAddressDetails) {
		this.emailAddressDetails = emailAddressDetails;
	}

	/**
	 * @return the contactNumberDetails
	 */
	public List<ContactNumberDetails> getContactNumberDetails() {
		return contactNumberDetails;
	}

	/**
	 * @param contactNumberDetails
	 *            the contactNumberDetails to set
	 */
	public void setContactNumberDetails(List<ContactNumberDetails> contactNumberDetails) {
		this.contactNumberDetails = contactNumberDetails;
	}

	/**
	 * @return the addressDetails
	 */
	public List<AddressDetails> getAddressDetails() {
		return addressDetails;
	}

	/**
	 * @param addressDetails
	 *            the addressDetails to set
	 */
	public void setAddressDetails(List<AddressDetails> addressDetails) {
		this.addressDetails = addressDetails;
	}
}
