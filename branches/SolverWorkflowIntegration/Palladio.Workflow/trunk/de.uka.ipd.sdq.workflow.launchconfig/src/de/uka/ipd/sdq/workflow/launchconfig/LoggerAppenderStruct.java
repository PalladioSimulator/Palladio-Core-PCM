package de.uka.ipd.sdq.workflow.launchconfig;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.workflow.launchconfig.logging.StreamsProxyAppender;

public class LoggerAppenderStruct {
	private Logger logger;
	private StreamsProxyAppender appender;
	/**
	 * @param logger
	 * @param appender
	 */
	public LoggerAppenderStruct(Logger logger, StreamsProxyAppender appender) {
		super();
		this.logger = logger;
		this.appender = appender;
	}
	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return logger;
	}
	/**
	 * @return the appender
	 */
	public StreamsProxyAppender getAppender() {
		return appender;
	}
}