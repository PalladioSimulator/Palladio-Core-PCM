package de.uka.ipd.sdq.pcmsolver;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;

/**
 * The central class that controls the PCM Solver process when launched from the
 * eclipse UI.
 * 
 * This class is deprecated by now (?).
 * 
 * @see Heiko's dissertation, chapter 6 at
 *      http://docserver.bis.uni-oldenburg.de
 *      /_publikationen/dissertation/2008/kozpar08/pdf/kozpar08.pdf
 * @author koziolek, brosch
 * 
 */
public class PCMSolver {

	/**
	 * A console for output of PCm Solver results.
	 */
	private static MessageConsole messageConsole;

	/**
	 * Retrieves the PCM Solver console.
	 * 
	 * @return the PCM Solver console
	 */
	public static MessageConsole getConsole() {
		return messageConsole;
	}

	/**
	 * Enables log4j logging for this class.
	 */
	private static Logger logger = Logger.getLogger(PCMSolver.class.getName());

	/**
	 * Configuration details constant.
	 */
	private static final int DOMAINSIZEDEFAULT = 32;

	/**
	 * Configuration details constant.
	 */
	private static final double DISTANCEDEFAULT = 1.0;

	/**
	 * Wrapper object for the model parts belonging to the PCM instance.
	 */
	private PCMInstance currentModel;

	/**
	 * References the progress monitor associated with the launch.
	 */
	private IProgressMonitor monitor;

	/**
	 * Indicates the actual type of the PCM solving process. The user can choose
	 * between different types through the launch configuration.
	 */
	private SolverStrategy strategy;

	/**
	 * The constructor.
	 * 
	 * Configures the PCM Solver process according to the launch configuration
	 * defined by the user.
	 * 
	 * @param configuration
	 *            the launch configuration
	 * @param monitor
	 *            the progress monitor
	 * @param reliability
	 *            enables reliability analysis
	 */
	public PCMSolver(final ILaunchConfiguration configuration,
			final IProgressMonitor monitor, final boolean reliability) {

		// Set the progress monitor:
		this.monitor = monitor;

		// Configure log4j logging:
		configureLogging(configuration);

		// Determine the PCM model parts from the launch configuration:
		currentModel = new PCMInstance(configuration);

		// Determine configuration details:
		int domainSize = DOMAINSIZEDEFAULT;
		double distance = DISTANCEDEFAULT;
		String solver = MessageStrings.SRE_SOLVER;
		try {
			domainSize = Integer.parseInt(configuration.getAttribute(
					MessageStrings.MAX_DOMAIN, "" + DOMAINSIZEDEFAULT));
			distance = Double.parseDouble(configuration.getAttribute(
					MessageStrings.SAMPLING_DIST, "" + DISTANCEDEFAULT));
			solver = configuration.getAttribute(MessageStrings.SOLVER,
					MessageStrings.SRE_SOLVER);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Configure the PCM Solver process:
		PDFConfiguration.setCurrentConfiguration(domainSize, distance,
				IProbabilityFunctionFactory.eINSTANCE.createDefaultUnit());
		if (reliability) {
			// strategy = new Pcm2MarkovStrategy(configuration);
		} else if (solver.equals(MessageStrings.SRE_SOLVER)) {
			// strategy = new Pcm2RegExStrategy();
		} else if (solver.equals(MessageStrings.LQNS_SOLVER)) {
			// strategy = new Pcm2LqnStrategy(configuration);
		} else if (solver.equals(MessageStrings.LQSIM_SOLVER)) {
			// strategy = new Pcm2LqnStrategy(configuration);
		}
	}

	/**
	 * The constructor with default value for reliability (FALSE).
	 * 
	 * This constructor is maintained for being downwards compatible with the
	 * former PCM Solver version, which did not support reliability analysis.
	 * 
	 * @param configuration
	 *            the launch configuration
	 * @param monitor
	 *            the progress monitor
	 */
	public PCMSolver(final ILaunchConfiguration configuration,
			final IProgressMonitor monitor) {
		this(configuration, monitor, false);
	}

	/**
	 * Executes the PCM Solver process.
	 */
	public void execute() {

		// Check the model for being valid:
		if (!currentModel.isValid()) {
			logger.error("PCM Instance invalid! Check filenames.");
			return;
		}

		// Only a very coarse progress monitoring is supported, which assigns
		// 50% progress to the execution of the involved transformation(s), and
		// 50% to the final solving:
		monitor.beginTask("Analysis", 100);
		strategy.transform(currentModel);
		monitor.worked(50);
		strategy.solve();
		monitor.worked(50);
	}

	/**
	 * Configures the log4j logging capability.
	 * 
	 * @param configuration
	 *            the launch configuration
	 */
	private void configureLogging(final ILaunchConfiguration configuration) {

		// Set the layout for logging messages:
		PatternLayout myLayout = new PatternLayout(
				"%d{HH:mm:ss,SSS} [%t] %-5p %c - %m%n");

		// Define and configure a new message console:
		if (messageConsole == null) {
			messageConsole = new MessageConsole(
					"PCM Solver Console: Analysis Tool Output", null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { messageConsole });
		}

		// Switch to this console if any other console is active:
		messageConsole.activate();

		// Enable writing to the console:
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure(new WriterAppender(myLayout, messageConsole
				.newMessageStream()));

		//Anne: Now superfluous, logging is handled by the ...ConfgurationDelegates
		// Adapt the logging level to the choice of the user:
/*		boolean verboseLogging = false;
		try {
			verboseLogging = configuration.getAttribute(
					MessageStrings.VERBOSE_LOGGING, false);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		Logger.getRootLogger().setLevel(
				(verboseLogging) ? Level.DEBUG : Level.INFO);*/
	}

	public SolverStrategy getStrategy() {
		return strategy;
	}
}
