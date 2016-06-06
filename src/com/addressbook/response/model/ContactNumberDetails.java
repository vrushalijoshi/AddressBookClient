package com.addressbook.response.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Maintains contact number details corresponding to the person record
 * 
 * @author Vrushali
 *
 */
@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class ContactNumberDetails extends BaseModel{
	
	/** Version UID for serialization */
	private static final long serialVersionUID = -2132916262177665876L;
	
	/** contact number */
	private Long contactNumber;
	
	public ContactNumberDetails() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the contactNumber
	 */
	public Long getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber
	 *            the contactNumber to set
	 */
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
}
