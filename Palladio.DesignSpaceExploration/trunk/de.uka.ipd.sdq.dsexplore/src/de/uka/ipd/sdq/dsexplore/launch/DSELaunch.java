package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jface.dialogs.MessageDialog;
import org.opt4j.config.visualization.Configurator;
import org.opt4j.core.DoubleValue;
import org.opt4j.core.Value;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.start.Opt4J;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.algorithms.HillClimbingAlgorithm;
import de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.cost.CostEvaluator;
import de.uka.ipd.sdq.dsexplore.helper.ConfigurationHelper;
import de.uka.ipd.sdq.dsexplore.helper.DSEMessageBox;
import de.uka.ipd.sdq.dsexplore.helper.DummyAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.GenotypeReader;
import de.uka.ipd.sdq.dsexplore.helper.LoggerHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.start.GivenInstanceEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.dsexplore.opt4j.start.PredefinedInstanceEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.RandomSearch;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;

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
@SuppressWarnings("unchecked")
public class DSELaunch extends AbstractWorkflowBasedLaunchConfigurationDelegate{
	

	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	private String mode;
	private ILaunchConfiguration configuration;
	private ILaunch launch;
	
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
		
		this.mode = mode;
		this.configuration = configuration;
		this.launch = launch;
		super.launch(configuration, mode, launch, monitor);

	}





	private static String resultsToString(List<IAnalysisResult> population) throws AnalysisFailedException {
		String string = "";
		int count = 1;
		for (Iterator<IAnalysisResult> iterator = population.iterator(); iterator
				.hasNext();) {
			IAnalysisResult analysisResult = iterator.next();
			string += count + ".: ";
			string += "\t" + analysisResult.getPCMInstance().getName();
			string += "\t"+ analysisResult.getMeanValue()+" time units.\n"; 
			count ++;
		}
		return string;
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
		ArrayList<LoggerAppenderStruct> loggerList = new ArrayList<LoggerAppenderStruct>();

		// Setup SDQ workflow engine logging
		loggerList.add(setupLogger("de.uka.ipd.sdq.dsexplore", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		
		return loggerList;
	}



	@Override
	protected IJob createWorkflowJob(
			AbstractWorkflowBasedRunConfiguration config, ILaunch launch)
			throws CoreException {
		return new DSEJob(this.configuration, mode, launch, this);
	}



	@Override
	protected AbstractWorkflowBasedRunConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		return new DSEWorkflowConfiguration();
	}
	
	/**
	 * FIXME: This is just a workaround to fix the logging. 
	 * There is a problem when the workflows for the Analyses are started. 
	 * Afterwards, the logging is broken. Thusm I reset it here.
	 * Problem: A new console is opened after each analyses. That makes two consoles per analyses. 
	 * For 1200 candidates, it might crash Eclipse.  
	 * @throws CoreException
	 */
	public void resetLoggers() throws CoreException{
		this.setupProcessAndLogger(configuration, launch);
	}
	
	
}



