package com.xhhxd.retail.common.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonSerialization implements Serialization {	
	
	@Override
	public byte[] serialize(Object obj) {
		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		serializer.config(SerializerFeature.DisableCircularReferenceDetect, true);
		serializer.config(SerializerFeature.WriteEnumUsingToString, true);
		serializer.config(SerializerFeature.WriteClassName, true);
		serializer.write(obj);
		return out.toBytes("UTF8");
	}

	@Override
	public Object deserialize(byte[] bytes) {
		return deserialize(bytes, Object.class);
	}

	@Override
	public <T> T deserialize(byte[] bytes, Class<T> clazz) {
		return JSON.parseObject(bytes, clazz);
	}
}