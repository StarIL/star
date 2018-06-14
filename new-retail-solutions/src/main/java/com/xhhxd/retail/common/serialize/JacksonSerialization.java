package com.xhhxd.retail.common.serialize;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonSerialization implements Serialization {
	private final static Logger logger = LoggerFactory.getLogger(JavaBeanSerialization.class);

	private ThreadLocal<ObjectMapper> jacksonThreadMap = new ThreadLocal<ObjectMapper>() {
		protected ObjectMapper initialValue() {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
			objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
			return objectMapper;
		}
	};

	@Override
	public byte[] serialize(Object obj) {
		try {
			ObjectMapper mapper = jacksonThreadMap.get();
			return mapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException e) {
			logger.error("serialize error {}", e);
		}
		return null;
	}

	@Override
	public Object deserialize(byte[] bytes) {
		return deserialize(bytes, Object.class);
	}

	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clazz) {
		try {
			ObjectMapper mapper = jacksonThreadMap.get();
			return mapper.readValue(bytes, clazz);
		} catch (IOException e) {
			logger.error("deserialize error {}", e);
		}
		return null;
	}
}