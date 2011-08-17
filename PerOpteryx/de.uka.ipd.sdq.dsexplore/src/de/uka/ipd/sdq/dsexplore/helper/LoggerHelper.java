package de.uka.ipd.sdq.dsexplore.helper;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

public class LoggerHelper {
	
	/** Logger for log4j. */
//	private static Logger logger = 
//		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	/**
	 * Setup log4j. FIXME: Does not really do what I want!
	 * 
	 *  TODO: Log in the console of the starting application, just as the simulation does. 
	 *  
	 * @param config SimuCom config which is queried for the logging settings
	 * @throws CoreException 
	 */
	public static void initializeLogger(ILaunchConfiguration config) throws CoreException {
/*		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
		ConsoleAppender myAppender = new ConsoleAppender(myLayout);
		if (config.getAttribute(SimuComConfig.VERBOSE_LOGGING, true))
			myAppender.setThreshold(Priority.DEBUG);
		else
			myAppender.setThreshold(Priority.WARN);
		myAppender.setWriter(new PrintWriter(System.out));*/
		//BasicConfigurator.resetConfiguration();
		//BasicConfigurator.configure();
		//BasicConfigurator.configure(myAppender);
		//logger.debug("Verbose logging enabled!");
	}
	
}
