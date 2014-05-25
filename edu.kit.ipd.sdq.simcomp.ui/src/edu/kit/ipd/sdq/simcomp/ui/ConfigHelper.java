package edu.kit.ipd.sdq.simcomp.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.xml.bind.DatatypeConverter;

public class ConfigHelper {

	/**
	 * Serializes an object into a string to be stored in the launch
	 * configuration.
	 * 
	 * @param object
	 *            An object to serialize
	 * @return The serialized and base64 encoded object
	 */
	public static String serializeObject(Serializable object) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printBase64Binary(baos.toByteArray());
	}

	/**
	 * Deserializes an object from a launch configuration storage.
	 * 
	 * @param serializedObject
	 *            A serialized and base64 encoded object
	 * @return The unserialized object
	 */
	public static Object deserializeObject(String serializedObject) {
		ByteArrayInputStream bais = new ByteArrayInputStream(DatatypeConverter.parseBase64Binary(serializedObject));
		ObjectInputStream ois;
		Object object = null;
		try {
			ois = new ObjectInputStream(bais);
			object = ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return object;
	}
}
