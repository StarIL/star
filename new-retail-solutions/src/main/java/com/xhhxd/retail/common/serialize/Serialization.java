package com.xhhxd.retail.common.serialize;

public interface Serialization {

	byte[] serialize(Object obj);

	Object deserialize(byte[] bytes);

	<T> T deserialize(byte[] bytes, Class<T> clz);

	// void close(Closeable closeable);

	public enum SerializeType {
		JavaBean(0), Fastjson(1), Jackson(2), Kryo(3);

		private int value;

		SerializeType(int value) {
			this.value = value;
		}

		public static Serialization getSerializeByValue(SerializeType type) {
			if (type == SerializeType.JavaBean) {
				return new JavaBeanSerialization();
			} else if (type == SerializeType.Fastjson) {
				return new FastJsonSerialization();
			} else if (type == SerializeType.Jackson) {
				return new JacksonSerialization();
			} else {
				return new JavaBeanSerialization();
			}
		}

		public int getValue() {
			return value;
		}
	}
}
