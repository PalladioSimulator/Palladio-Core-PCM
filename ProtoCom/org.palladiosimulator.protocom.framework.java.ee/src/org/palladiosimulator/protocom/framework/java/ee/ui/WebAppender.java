package org.palladiosimulator.protocom.framework.java.ee.ui;

import java.util.Deque;
import java.util.LinkedList;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.palladiosimulator.protocom.framework.java.ee.api.sockets.LogSocket;

/**
 * The WebAppender class for Apache Log4j delegates log messages to the web UI.
 * @author Christian Klaussner
 */
public class WebAppender extends AppenderSkeleton {
	public static final String NAME = "ProtoCom-Log";

	private static final int CAPACITY = 50;
	private static final PatternLayout LAYOUT = new PatternLayout("%d{HH:mm:ss} %p %m%n");

	private Deque<String> messages;

	/**
	 * Constructs a new WebAppender object and sets its name to {@link NAME}.
	 */
	public WebAppender() {
		messages = new LinkedList<String>();
		setName(NAME);
	}

	/**
	 * Returns the content of the log.
	 * @return a string containing all messages of the log
	 */
	public String getLogContent() {
		StringBuilder sb = new StringBuilder();

		for (String message : messages) {
			sb.append(message);
		}

		return sb.toString();
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
		while (messages.size() >= CAPACITY) {
			messages.removeFirst();
		}

		String message = LAYOUT.format(event);

		messages.addLast(message);
		LogSocket.append(message);
	}
}
