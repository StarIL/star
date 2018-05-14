package com.xhhxd.retail.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class DateTimeConverter extends ObjectMapper {

	private static final long serialVersionUID = 1L;
	
	public DateTimeConverter() {
		this.registerModule(new JavaTimeModule());
		this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
	}
}
