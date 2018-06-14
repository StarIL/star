package com.xhhxd.retail.common;

import java.util.concurrent.atomic.AtomicReference;

import com.xhhxd.retail.common.serialize.Serialization;
import com.xhhxd.retail.common.serialize.Serialization.SerializeType;

public class SerializeFactory {

	private static AtomicReference<Serialization> serializationRef = new AtomicReference<Serialization>();

	public static Serialization build(SerializeType serializeType) {
		Serialization serialize = serializationRef.get();
		if (serializationRef.get() != null) {
			return serialize;
		}
		synchronized (CompressFactory.class) {
			serialize = SerializeType.getSerializeByValue(serializeType);
			serializationRef.set(serialize);
			return serialize;
		}
	}
}