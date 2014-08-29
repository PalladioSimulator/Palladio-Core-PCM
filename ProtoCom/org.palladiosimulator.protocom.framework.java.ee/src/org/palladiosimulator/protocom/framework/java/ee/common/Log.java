package org.palladiosimulator.protocom.framework.java.ee.common;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.palladiosimulator.protocom.framework.java.ee.api.sockets.LogSocket;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * The Log singleton provides methods for logging messages.
 * @author Christian Klaussner
 */
public final class Log {
	private static Log log;

	private LinkedList<String> infoMessages;
	private JsonFactory jsonFactory;

	/**
	 * Private constructor.
	 */
	private Log() {
		infoMessages = new LinkedList<String>();
		jsonFactory = new JsonFactory();
	}

	/**
	 * Singleton accessor.
	 * @return the log instance
	 */
	public static Log getInstance() {
		if (log == null) {
			log = new Log();
		}

		return log;
	}

	/**
	 * Adds the specified message to the log.
	 * @param type the type of the message
	 * @param message the message to add
	 */
	public void addMessage(MessageType type, String message) {
		StringBuilder logMessage = new StringBuilder();

		logMessage.append(new SimpleDateFormat("HH:mm:ss").format(new Date()));

		switch (type) {
		case INFO:
			logMessage.append(" INFO ");
			break;

		case ERROR:
			logMessage.append(" ERROR ");
			break;

		default:
		}

		logMessage.append(message);

		infoMessages.add(logMessage.toString());

		LogSocket.addMessage(logMessage.toString());
	}

	/**
	 * Converts the log messages to JSON.
	 * @param base the index of the first message to convert
	 * @return a JSON object string with properties "messageCount" (number) and "messages" (array)
	 */
	public String toJson(int base) {
		StringWriter out = new StringWriter();

		try {
			JsonGenerator json = jsonFactory.createGenerator(out);
			json.writeStartObject();

			// Write the number of messages.
			json.writeNumberField("messageCount", infoMessages.size() - base);

			// Write the messages as array of strings.
			json.writeFieldName("messages");
			json.writeStartArray();

			for (int i = base; i < infoMessages.size(); i++) {
				json.writeString(infoMessages.get(i));
			}

			json.writeEndArray();

			json.writeEndObject();
			json.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out.toString();
	}

	/**
	 * Shortcut method for adding an info message to the log.
	 * @param message the message to add to the log
	 */
	public static void info(String message) {
		Log logInstance = Log.getInstance();
		logInstance.addMessage(MessageType.INFO, message);
	}

	/**
	 * Shortcut method for adding an error message to the log.
	 * @param message the message to add to the log
	 */
	public static void error(String message) {
		Log logInstance = Log.getInstance();
		logInstance.addMessage(MessageType.ERROR, message);
	}
}
