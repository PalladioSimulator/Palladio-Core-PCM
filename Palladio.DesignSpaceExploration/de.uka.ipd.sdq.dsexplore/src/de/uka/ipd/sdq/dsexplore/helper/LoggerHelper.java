package de.uka.ipd.sdq.dsexplore.helper;

import java.io.PrintWriter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class LoggerHelper {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	/**
	 * Setup log4j. FIXME: Does not really do what I want! 
	 * @param config SimuCom config which is queried for the logging settings
	 * @throws CoreException 
	 */
	public static void initializeLogger(ILaunchConfiguration config) throws CoreException {
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
		ConsoleAppender myAppender = new ConsoleAppender(myLayout);
		if (config.getAttribute(SimuComConfig.VERBOSE_LOGGING, true))
			myAppender.setThreshold(Priority.DEBUG);
		else
			myAppender.setThreshold(Priority.WARN);
		myAppender.setWriter(new PrintWriter(System.out));
		BasicConfigurator.configure();
		BasicConfigurator.configure(myAppender);
		logger.debug("Logging enabled!");
	}
	
}
