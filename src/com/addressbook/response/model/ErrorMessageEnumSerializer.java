package com.addressbook.response.model;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.addressbook.service.response.ErrorMessageEnum;

/**
 * {@link JsonSerializer} implementation for serializing
 * {@link ErrorMessageEnum} object
 * 
 * @author Vrushali
 *
 */
public class ErrorMessageEnumSerializer extends JsonSerializer<ErrorMessageEnum> {

	@Override
	public void serialize(ErrorMessageEnum enumValue, JsonGenerator generator, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeFieldName("message");
		generator.writeString(enumValue.getMessage());
		generator.writeFieldName("type");
		generator.writeString(enumValue.getErrorType().getType());
		generator.writeEndObject();

	}
}
