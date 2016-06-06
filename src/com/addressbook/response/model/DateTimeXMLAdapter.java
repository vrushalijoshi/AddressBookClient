package com.addressbook.response.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 * Adapter to convert {@link DateTime} object to {@link String} representation
 * 
 * @author Vrushali
 *
 */
public class DateTimeXMLAdapter extends XmlAdapter<String, DateTime> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DateTime unmarshal(String v) throws Exception {
		if (v != null && !StringUtils.isEmpty(v))
			return DateTime.parse(v);
		else
			return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String marshal(DateTime v) throws Exception {
		if(v != null)
			return v.toString();
		else
			return null;
	}
}
