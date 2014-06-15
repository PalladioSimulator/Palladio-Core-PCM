package org.palladiosimulator.protocom.framework.webui;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class LogAppender extends AppenderSkeleton {
	private final LinkedList<String> infoMessages;
	
	public LogAppender() {
		infoMessages = new LinkedList<String>();
	}
	
	@Override
	public void close() {
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected void append(LoggingEvent event) {
		StringBuilder message = new StringBuilder();
		
		message.append(new SimpleDateFormat("HH:mm:ss").format(new Date(event.getTimeStamp())));
		
		switch (event.getLevel().toInt()) {
		case Level.INFO_INT:
			message.append(" INFO ");
			break;
			
		case Level.ERROR_INT:
			message.append(" ERROR ");
			break;
			
		case Level.DEBUG_INT:
			message.append(" DEBUG ");
			break;
		}
		
		message.append(event.getMessage());
		
		infoMessages.add(message.toString());
		
		// System.out.println("Web Log: " + new SimpleDateFormat("HH:mm:ss").format(new Date(event.getTimeStamp())) + " " + event.getMessage());
	}
	
	public String toJson(int base) {
		StringWriter out = new StringWriter();
		
		try {
			JsonGenerator json = new JsonFactory().createGenerator(out);
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
}
