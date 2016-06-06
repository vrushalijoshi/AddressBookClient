package com.addressbook.response.model;

import java.io.Serializable;
import java.util.UUID;

import org.joda.time.DateTime;

/**
 * Base model for address book model objects
 * 
 * @author Vrushali
 *
 */
public class BaseModel implements Serializable {

	/** Version UID for serialization */
	private static final long serialVersionUID = -814738485301472487L;

	/** Record unique identifier */
	private UUID id;
	
	/** Last modified time */
	private DateTime lastModifiedDate;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
