package com.shiwulian.wechat.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class JsonUtil {

	static {
		SerializeConfig.getGlobalInstance().put(Date.class, new SimpleDateFormatSerializer("yyyyyy-MM-dd hh:mm:ss"));
		ParserConfig.getGlobalInstance().putDeserializer(Date.class, new SqlDateDeserializer(true));
	}

	public static String toJSON(Object object) {
		return JSONObject.toJSONString(object);
	}
	
	public static  byte[] toBytes(Object object) {
		return JSONObject.toJSONBytes(object);
	}

	public static <T> T parseObject(String json, Class<T> clazz) {
		return JSONObject.parseObject(json, clazz);
	}

	public static <T> Map<String, T> parseMap(String json, Class<T> clazz) {
		Map<String, T> map = JSONObject.parseObject(json, new TypeReference<Map<String, T>>() {
		}.getType());
		Map<String, T> ret = new HashMap<>();
		for (String key : map.keySet()) {
			ret.put(key, JSONObject.parseObject(map.get(key).toString(), clazz));
		}
		return ret;
	}

	public static <T> Map<String, List<T>> parseMaps(String json, Class<T> clazz) {
		Map<String, List<T>> maps = JSONObject.parseObject(json, new TypeReference<Map<String, List<T>>>() {
		}.getType());
		Map<String, List<T>> ret = new HashMap<>();
		for (Entry<String, List<T>> entry : maps.entrySet()) {
			ret.put(entry.getKey(), JSONObject.parseArray(entry.getValue().toString(), clazz));
		}
		return ret;
	}

	public static Map<String, Object> parseObjectMap(String json) {
		return JSONObject.parseObject(json, new TypeReference<Map<String, Object>>() {
		}.getType());
	}

	public static <T> List<T> parseArray(String json, Class<T> clazz) {
		return JSONObject.parseArray(json, clazz);
	}
}