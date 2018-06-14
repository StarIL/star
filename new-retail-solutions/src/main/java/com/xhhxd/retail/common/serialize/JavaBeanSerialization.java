package com.xhhxd.retail.common.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unchecked")
public class JavaBeanSerialization implements Serialization {
	private final static Logger logger = LoggerFactory.getLogger(JavaBeanSerialization.class);

	@Override
	public byte[] serialize(Object obj) {
		if(obj == null) return null;
		
		ByteArrayOutputStream bytOutSteam = null;
		ObjectOutputStream objOutSteam = null;
		try {
			bytOutSteam = new ByteArrayOutputStream();
			objOutSteam = new ObjectOutputStream(bytOutSteam);
			objOutSteam.writeObject(obj);
			return bytOutSteam.toByteArray();
		} catch (IOException e) {
			logger.error("serialize error {}", e);
		} finally {
			close(bytOutSteam);
			close(objOutSteam);
		}
		return new byte[0];
	}

	@Override
	public Object deserialize(byte[] bytes) {
		return deserialize(bytes, Object.class);
	}

	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clz) {
		if(bytes == null || bytes.length <= 0) return null;
		
		ByteArrayInputStream bytInStream = null;
		ObjectInputStream objInStream = null;
		try {
			bytInStream = new ByteArrayInputStream(bytes);
			objInStream = new ObjectInputStream(bytInStream);
			return (T) objInStream.readObject();
		} catch (IOException e) {
			logger.error("deserialize error {}", e);
		} catch (ClassNotFoundException e) {
			logger.error("deserialize error {}", e);
		} finally {
			close(bytInStream);
			close(objInStream);
		}
		return null;
	}

	private void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				logger.error("close error {}", e);
			}
		}
	}
}
