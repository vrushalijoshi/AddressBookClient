@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value = DateTimeXMLAdapter.class, type = DateTime.class)
})
package com.addressbook.response.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import org.joda.time.DateTime;







