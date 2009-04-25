package de.uka.ipd.sdq.workflow.launchconfig.logging;

import org.apache.log4j.Level;


/**
 * An AppenderBasedStreamMonitor which only forwards log messages with an Log level of 
 * WARN or higher. It can be, for example, attached to the standard error stream.
 * @author Steffen
 *
 */
public class ErrorAppenderBasedStreamMonitor extends AppenderBasedStreamMonitor {

	@Override
	public void textAddedEvent(String text, Level level) {
		if (level.isGreaterOrEqual(Level.WARN)) {
			notifyListeners(text);
		}
	}

}
