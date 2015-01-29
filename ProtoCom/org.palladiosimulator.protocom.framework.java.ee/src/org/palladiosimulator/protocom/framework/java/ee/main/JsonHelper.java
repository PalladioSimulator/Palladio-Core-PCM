package org.palladiosimulator.protocom.framework.java.ee.main;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The JsonHelper class is used to convert object from and to JSON.
 * @author Christian Klaussner
 */
public final class JsonHelper {
	private static final ObjectMapper MAPPER;

	static {
		MAPPER = new ObjectMapper();
	}

	/**
	 * Converts the specified object to a JSON string.
	 * @param object the object to convert
	 * @return a JSON string representing the object
	 */
	public static String toJson(Object object) {
		String value = "";

		try {
			value = MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return value;
	}
	
	/**
	 * Converts a JSON string to an object.
	 * @param json the JSON string to convert
	 * @param clazz the class of the object
	 * @param <T> the type of the object
	 * @return an object represented by the JSON string
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		T object = null;

		try {
			object = MAPPER.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return object;
	}
}
