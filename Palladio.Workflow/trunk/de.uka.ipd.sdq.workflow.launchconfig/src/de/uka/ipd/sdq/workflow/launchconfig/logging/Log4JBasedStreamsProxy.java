package de.uka.ipd.sdq.workflow.launchconfig.logging;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;

/**
 * This class is a IStreamsProxy implementation which uses Log4J appender as source of its
 * output and error streams. IStreamsProxy is the interface used by Eclipse to redirect 
 * console outputs to a dedicated run console in its GUI. It is based on an event notification
 * mechanismn which throws an event any time a new line should be added to the console output.
 * @author Steffen
 *
 */
public class Log4JBasedStreamsProxy implements IStreamsProxy {

	/**
	 * List of appenders which can log to standard out 
	 */
	private AppenderBasedStreamMonitor outMonitor = null;
	
	/**
	 * List of appenders which can log to standard error (displayed in red) 
	 */
	private AppenderBasedStreamMonitor errMonitor = null;

	/**
	 * Appender used for this class' write method 
	 */
	private StreamsProxyAppender myAppender = new StreamsProxyAppender();
	
	private ArrayList<StreamsProxyAppender> addedAppenders = new ArrayList<StreamsProxyAppender>();
	
	/**
	 * Constructor, create appender container for both output streams 
	 */
	public Log4JBasedStreamsProxy() {
		super();
		
		this.outMonitor = new OutputAppenderBasedStreamMonitor();
		this.errMonitor = new ErrorAppenderBasedStreamMonitor();
		
		myAppender.setLayout(new PatternLayout());
		this.addAppender(myAppender);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStreamsProxy#getErrorStreamMonitor()
	 */
	public IStreamMonitor getErrorStreamMonitor() {
		return this.errMonitor;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStreamsProxy#getOutputStreamMonitor()
	 */
	public IStreamMonitor getOutputStreamMonitor() {
		return this.outMonitor;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStreamsProxy#write(java.lang.String)
	 */
	public void write(String input) throws IOException {
		myAppender.doAppend(new LoggingEvent(input, null, null, input, null));
	}
	
	/**
	 * Add a new Log4J appender to this StreamsProxy. It has to be of type StreamsProxyAppender which 
	 * can be initialised and setup at will. 
	 * @param appender
	 */
	public void addAppender(StreamsProxyAppender appender) {
		this.outMonitor.addAppender(appender);
		this.errMonitor.addAppender(appender);
		this.addedAppenders.add(appender);
	}

	public void removeAppender(StreamsProxyAppender appender) {
		this.outMonitor.removeAppender(appender);
		this.errMonitor.removeAppender(appender);
		this.addedAppenders.remove(appender);
	}
	
	public void dispose() {
		for (StreamsProxyAppender appender : addedAppenders) {
			this.outMonitor.removeAppender(appender);
			this.errMonitor.removeAppender(appender);
		}
		addedAppenders.clear();
	}
}
