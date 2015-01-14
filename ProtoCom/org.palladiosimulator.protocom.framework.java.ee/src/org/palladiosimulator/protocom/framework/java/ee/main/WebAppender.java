package org.palladiosimulator.protocom.framework.java.ee.main;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.palladiosimulator.protocom.framework.java.ee.api.sockets.LogSocket;



/**
 * The WebAppender class for Apache Log4j delegates log messages to the web UI.
 * @author Christian Klaussner
 */
public class WebAppender extends AppenderSkeleton {
	public static final String NAME = "ProtoCom-Log";

	private static final int CAPACITY = 100;
	private static final PatternLayout LAYOUT = new PatternLayout("%d{HH:mm:ss} %p %m%n");

	private final LinkedList<LogMessage> messages;

	/**
	 * Constructs a new WebAppender object and sets its name to {@link NAME}.
	 */
	public WebAppender() {
		messages = new LinkedList<LogMessage>();
		setName(NAME);
	}

	/**
	 * Returns the content of the log.
	 * @return a list containing all messages of the log
	 */
	public List<LogMessage> getLogContent() {
		return messages;
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

		String text = LAYOUT.format(event);
		boolean isError = event.getLevel().isGreaterOrEqual(Level.ERROR);

		LogMessage logMessage = new LogMessage(text, isError);

		messages.addLast(logMessage);
		LogSocket.append(logMessage);
	}
}
