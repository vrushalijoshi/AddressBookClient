package com.addressbook.service.response;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.addressbook.response.model.PersonDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Address book response object
 * 
 * @author Vrushali
 *
 */
@XmlRootElement
@JsonInclude(Include.NON_EMPTY)
public class AddressBookResponse implements Serializable {

	/** Version UID for serialization */
	private static final long serialVersionUID = 5256433005599617095L;

	/** list of {@link ErrorMessages} */
	private List<ErrorMessages> errorMessages;

	/** list of fetched {@link PersonDetails} objects */
	private List<PersonDetails> personDetails;

	/**
	 * @return the personDetails
	 */
	public List<PersonDetails> getPersonDetails() {
		return personDetails;
	}

	/**
	 * @param personDetails
	 *            the personDetails to set
	 */
	public void setPersonDetails(List<PersonDetails> personDetails) {
		this.personDetails = personDetails;
	}

	/**
	 * @return the errorMessages
	 */
	public List<ErrorMessages> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * @param errorMessages
	 *            the errorMessages to set
	 */
	public void setErrorMessages(List<ErrorMessages> errorMessages) {
		this.errorMessages = errorMessages;
	}
}
