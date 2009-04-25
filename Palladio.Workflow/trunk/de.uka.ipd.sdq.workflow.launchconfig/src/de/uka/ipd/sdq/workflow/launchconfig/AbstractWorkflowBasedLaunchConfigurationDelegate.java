package de.uka.ipd.sdq.workflow.launchconfig;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.Workflow;
import de.uka.ipd.sdq.codegen.workflow.exceptions.WorkflowExceptionHandler;
import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflowExceptionHandler;
import de.uka.ipd.sdq.workflow.launchconfig.logging.StreamsProxyAppender;

/**
 * Abstract base class for Eclipse Launches (both Run and Debug mode are supported) which run
 * based on the SDQ workflow engine, i.e., the run has an IJob which gets executed. The class
 * offers features to convert the information contained in ILaunchConfiguration into a
 * strongly typed configuration object for the workflow job, features to suport logging into the
 * Eclipse console, support for an Eclipse process which can be used to interrupt, terminate or debug 
 * the run, integration of the Eclipse progress bar, execption handling, etc.
 * 
 * The class is supposed to be used to implement Eclipse run configurations, like SimuCom, ProtoCom,
 * PCM2Java, PCM2LQN, SoMoX, Java2PCM, etc.
 * 
 * The class is abstract and defines some methods, which must be
 * implemented by subclasses. See method descriptions for details.
 * 
 * This class is based on code provided by Roman Andrej
 * 
 * @param <WorkflowConfigurationType> The type of the configuration object needed by the workflow job to 
 * 			configure itself. Out of the box support for the run mode (run or debug), log-level, and
 * 			unit test runs is provided.
 * @param <WorkflowType> The type of the workflow to be executed. This can be simple workflows, workflows
 * 			using a blackboard, etc.
 * 
 * @author Steffen Becker
 */
public abstract class 
	AbstractWorkflowBasedLaunchConfigurationDelegate
		<WorkflowConfigurationType extends AbstractWorkflowBasedRunConfiguration,
		WorkflowType extends Workflow>
	implements ILaunchConfigurationDelegate {

	
	/**
	 * Log Pattern used for run mode 
	 */
	protected static final String SHORT_LOG_PATTERN = "[%-10t] %-5p: %m%n";
	
	/**
	 * Log Pattern used for debug mode 
	 */
	protected static final String DETAILED_LOG_PATTERN = "%-8r [%-10t] %-5p: %m [%c]%n";
	
	/**
	 * Logger of this class 
	 */
	protected Logger logger = null;

	/**
	 * The Eclipse process attached to this launch run 
	 */
	private WorkflowProcess myProcess = null;

	/**
	 * List of logger configured for the workflow, used to cleanup logger after launch execution
	 */
	private ArrayList<Logger> myLogger = new ArrayList<Logger>();
	
	/**
	 * Name of the entry in the configuration hashmap containing the log level
	 */
	public static String VERBOSE_LOGGING = "verboseLogging";

	/*(non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		logger = Logger.getLogger(AbstractWorkflowBasedLaunchConfigurationDelegate.class);

		// Add a process to this launch, needed for Eclipse UI updates
		this.myProcess = getProcess(launch);
		// Configure logging output to the Eclipse console
		setupLogging(configuration.getAttribute(VERBOSE_LOGGING, false) ? Level.DEBUG : Level.INFO );
		launch.addProcess(getProcess());
		
		// Setup a new classloader to allow reconfiguration of apache commons logging
		ClassLoader oldClassLoader = configureNewClassloader();
		// Reconfigure apache commons logging to use Log4J as backend logger
		System.setProperty(LogFactoryImpl.LOG_PROPERTY, "org.apache.commons.logging.impl.Log4JLogger");

		try {
			logger.info("Create workflow configuration");
			WorkflowConfigurationType workflowConfiguration = 
				deriveConfiguration(configuration, mode);
		
			logger.info("Validating workflow configuration");
			workflowConfiguration.validateAndFreeze();
	
			logger.info("Creating workflow engine");
			Workflow workflow = createWorkflow(workflowConfiguration,
					monitor, launch);
			
			logger.info("Executing workflow");
			workflow.run();
		} finally {
			// Reset classloader to original value
			Thread.currentThread().setContextClassLoader(oldClassLoader);
		}
		
		for(Logger l : this.myLogger)
			l.removeAllAppenders();
		
		// Singnal execution terminatation to Eclipse to update UI 
		launch.getProcesses()[0].terminate();
	}

	/**
	 * Instanciate the workflow exception handler used to handle failures in the
	 * workflow. By default returns an excpetion handler which uses Eclipse
	 * Dialogs to inform the user about the failure.
	 * @param interactive Whether the workflow runs interactive
	 * @return A workflow exception handler
	 */
	protected WorkflowExceptionHandler createExcpetionHandler(boolean interactive) {
		return new UIBasedWorkflowExceptionHandler(!interactive);
	}

	/** Instantiate the workflow engine. By default a standard workflow engine is created.
	 * @param workflowConfiguration Configuration of the workflow job
	 * @param monitor A progress monitor
	 * @param launch The associated Eclipse launch
	 * @return The workflow engine to use for this launch
	 * @throws CoreException
	 */
	@SuppressWarnings("unchecked")
	protected WorkflowType createWorkflow(
			WorkflowConfigurationType workflowConfiguration, 
			IProgressMonitor monitor,
			ILaunch launch) throws CoreException {
		return (WorkflowType) new Workflow(
				createWorkflowJob(workflowConfiguration, launch), 
				monitor,
				createExcpetionHandler(workflowConfiguration.isInteractive()));
	}

	/**
	 * Create a new classloader to be used by this thread. Return the old
	 * classloader for later resets
	 * @return Old classloader
	 */
	private ClassLoader configureNewClassloader() {
		ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
		URLClassLoader cl = new URLClassLoader(new URL[]{},oldClassLoader);
		Thread.currentThread().setContextClassLoader(cl);
		return oldClassLoader;
	}

	/**
	 * Setup logger for the workflow run. May be overridden by clients to configure further logger
	 * for other namespaces than de.uka.ipd.sdq.workflow. Use protected method setupLogger to configure
	 * additional loggers
	 * @param logLevel The apache log4j log level requested by the user as log level
	 * @throws CoreException 
	 */
	protected void setupLogging(Level logLevel) throws CoreException {
		// Setup SDQ workflow engine logging
		setupLogger("de.uka.ipd.sdq.workflow", logLevel, logLevel.isGreaterOrEqual(Level.DEBUG) ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN);
	}

	/**
	 * Configure the named logger to log on the given log level with the given PatternLayout
	 * @param loggerName The name of the logger to configure 
	 * @param logLevel The log level to be used by the logger to configure
	 * @param layout The layout for the pattern layout to be used to format log messages.
	 * 		The layout may reuse the defined constants in this class for short and detailed
	 *      log outputs
	 */
	protected void setupLogger(String loggerName, Level logLevel, String layout) {
		Logger logger = Logger.getLogger(loggerName);
		StreamsProxyAppender appender = new StreamsProxyAppender();
		logger.removeAllAppenders();
		logger.setLevel(logLevel);
		appender.setLayout(
				new PatternLayout(layout));
		logger.setAdditivity(false);
		logger.addAppender(appender);

		this.myProcess.addAppender(appender);
		this.myLogger .add(logger);
	}


	/** 
	 * Instantiate the Eclipse process used by the workflow engine. Override this method to return a different process if you need
	 * support for debugging, etc.
	 * @param launch The ILaunch passed to this launch by Eclipse
	 * @return The process used to execute this launch
	 */
	protected WorkflowProcess getProcess(ILaunch launch) {
		return new WorkflowProcess(launch);
	}

	/**
	 * Instantiate the main job to be executed by the workflow engine. The job can be a single job or any other job type like composite jobs.
	 * The job will be run by the workflow engine.
	 * @param config The strongly-typed configuration object used to configure the main workflow job
	 * @param launch The eclipse ILaunch associated to the workflow, needed to setup debugging if the workflow supports it
	 * @return The main workflow job to be executed by the workflow engine
	 * @throws CoreException
	 */
	protected abstract IJob createWorkflowJob(
			WorkflowConfigurationType config,
			ILaunch launch) throws CoreException;

	/**
	 * This method is called as template method and has to be overriden by clients. Its purpose is to convert the Eclipse ILaunchConfiguration
	 * (which is basically an untyped hashmap) into a strongly typed configuration object needed by this workflow's main workflow job.
	 * @param configuration The ILaunchConfiguration to be converted into a strongly typed configuration object for the main workflow job
	 * @param mode The mode of execution, can be either debug or run
	 * @return The strongly typed configuration object for the main workflow job
	 * @throws CoreException
	 */
	protected abstract WorkflowConfigurationType deriveConfiguration(ILaunchConfiguration configuration, String mode) throws CoreException;
	
	/**
	 * Return the Eclipse process attached to this workflow run
	 * @return The Eclipse process attached to this workflow run
	 */
	protected IProcess getProcess() {
		if (this.myProcess == null)
			throw new UnsupportedOperationException("Cannot call getProcess before the workflow is instanciated.");

		return this.myProcess;
	}
}
