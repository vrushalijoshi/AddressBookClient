package com.addressbook.response.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.DateTime;

public class DateTimeXMLAdaptor extends XmlAdapter<String, DateTime> {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public DateTime unmarshal(String v) throws Exception {
		return DateTime.parse(v);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String marshal(DateTime v) throws Exception {
		return v.toString();
	}
}
