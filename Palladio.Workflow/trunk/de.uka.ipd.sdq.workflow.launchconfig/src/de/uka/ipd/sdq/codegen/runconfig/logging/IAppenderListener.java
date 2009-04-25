package de.uka.ipd.sdq.codegen.runconfig.logging;

import org.apache.log4j.Level;

/**
 * Interface for classes listening to new text arriving at a Log4J appender which is capable
 * of infoming about new text via events instead of logging itself
 * @author Steffen
 *
 */
public interface IAppenderListener {
	/**
	 * Event handler method which is called by an appender whenever a new log message arrives.
	 * The handler can then decide what to do with the new log message
	 * @param text The formatted log message
	 * @param level The log level of the log message used to filter events
	 */
	public void textAddedEvent(String text, Level level);
}
