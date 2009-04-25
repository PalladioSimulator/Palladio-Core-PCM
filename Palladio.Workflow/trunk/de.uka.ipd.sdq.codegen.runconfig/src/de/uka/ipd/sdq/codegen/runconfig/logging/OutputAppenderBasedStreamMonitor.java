package de.uka.ipd.sdq.codegen.runconfig.logging;

import org.apache.log4j.Level;


/**
 * An AppenderBasedStreamMonitor which only forwards log messages with an Log level of 
 * less than WARN. It can be, for example, attached to the standard output stream for informative or
 * debug messages.
 * @author Steffen
 *
 */
public class OutputAppenderBasedStreamMonitor extends
		AppenderBasedStreamMonitor {

	@Override
	public void textAddedEvent(String text, Level level) {
		if (!level.isGreaterOrEqual(Level.WARN)) {
			notifyListeners(text);
		}
	}
}
