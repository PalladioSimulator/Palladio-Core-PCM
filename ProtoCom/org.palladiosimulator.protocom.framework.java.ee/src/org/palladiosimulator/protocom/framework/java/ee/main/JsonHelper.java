package org.palladiosimulator.protocom.framework.java.ee.main;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonHelper {
	private static final ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}

	public static String toJson(Object object) {
		String value = "";

		try {
			value = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return value;
	}

	/*public static Object fromJson(String json, Class<?> clazz) {
		Object object = null;

		try {
			object = mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return object;
	}*/



	public static <T> T fromJson(String json, Class<T> clazz) {
		T object = null;

		try {
			object = mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return object;
	}
}
