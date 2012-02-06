package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.logging.console.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.ui.WorkflowProcess;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;

/**
 * Launches multiple simulation runs. 
 * 
 * TODO: Integrate in Workflow concept. Unify the Tabs for all PCM Solvers. 
 * Maybe use this common tab for all analyses, so that for reliability, SimCom and LQN,
 * always only one config with once the model files is needed.   
 * 
 * @author Anne
 *
 */
public class DSELaunch extends AbstractPCMLaunchConfigurationDelegate<DSEWorkflowConfiguration>{
	
	WorkflowProcess myWorkflowProcess;
	
	/**
	 * Logger of this class 
	 */
	private static Logger logger = Logger.getLogger(DSELaunch.class);
	

	private ILaunchConfiguration originalConfiguration;
	private ILaunch originalLaunch;


	/**
	 * Test for starting multiple simulations.
	 * @param configuration
	 * @param mode
	 * @param launch
	 * @param monitor
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		this.originalConfiguration = configuration;
		this.originalLaunch = launch;
		
		int iterations = getNumberOfDSEIterations(configuration);
		
		logger.warn("Will start "+iterations+" analysis runs. Only first one may be visible on the console.");
		for (int i = 0; i < iterations; i++) {
			super.launch(configuration, mode, launch, monitor);
		}
		
	}

	private int getNumberOfDSEIterations(ILaunchConfiguration configuration) {
		String stringValue;
		try {
			stringValue = configuration.getAttribute(DSEConstantsContainer.DSE_ITERATIONS, "0");
			if (!stringValue.equals("")){
				int i = Integer.parseInt(stringValue);
				return i;
			}
		} catch (Exception e) { /* just use 1 */ }
		return 1;
	}

	/**
	 * Copied from AbstractWorkflowBasedLaunchConfigurationDelegate
	 * Setup logger for the workflow run. May be overridden by clients to configure further logger
	 * for other namespaces than de.uka.ipd.sdq.workflow. Use protected method setupLogger to configure
	 * additional loggers
	 * @param logLevel The apache log4j log level requested by the user as log level
	 * @throws CoreException 
	 */
	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);

		// Setup SDQ workflow engine logging
		loggerList.add(setupLogger("de.uka.ipd.sdq.dsexplore", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.reliability.solver", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.pcmsolver", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.simucomframework.variables", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.stoex.analyser", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		
		return loggerList;
	}



	@Override
	protected IJob createWorkflowJob(
			DSEWorkflowConfiguration config, ILaunch launch)
			throws CoreException {
		return new PerOpteryxJob(config, this);
	}



	@Override
	protected DSEWorkflowConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		
		AbstractWorkflowConfigurationBuilder builder;
		builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
		
		DSEWorkflowConfiguration config = new DSEWorkflowConfiguration();
		builder.fillConfiguration(config);
		
		builder = new DSEWorkflowConfigurationBuilder(configuration, mode, this);
		builder.fillConfiguration(config);
		
		config.setRawConfig(configuration);
		
		return config;
	}
	
	/**
	 * FIXME: This is just a workaround to fix the logging. 
	 * There is a problem when the workflows for the Analyses are started. 
	 * Afterwards, the logging is broken. Thus, I reset it here.
	 * Problem: I do not know how much overhead this creates, maybe it is the cause for crashing eclipse after 1600 candidates with LQNS.  
	 * @throws CoreException
	 */
	public void resetLoggers() throws CoreException{
		//Logger.getRootLogger().removeAllAppenders();
		//Logger.getLogger(loggerName);
//		for (LoggerAppenderStruct logger : this.myLoggerList) {
//			this.myWorkflowProcess.addAppender(logger.getAppender());
//		}
	}

	public ILaunch getOriginalLaunch() {
		return this.originalLaunch;
	}
	
	public ILaunchConfiguration getOriginalConfiguration() {
		return originalConfiguration;
	}
	
	/** 
	 * Get the Eclipse process used by the workflow engine. When called first, 
	 * instatiate new process. Later return the same. 
	 * 
	 * @param launch The ILaunch passed to this launch by Eclipse
	 * @return The process used to execute this launch
	 */
	@Override
	protected WorkflowProcess getProcess(ILaunch launch) {
		if (this.myWorkflowProcess == null){
			this.myWorkflowProcess = new WorkflowProcess(launch);
		}
		return this.myWorkflowProcess; 
	}
	
}



