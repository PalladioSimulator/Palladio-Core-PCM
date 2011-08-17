package de.uka.ipd.sdq.dsexplore.analysis.simucom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowLauncher;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;

import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkConfig;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.dsexplore.exception.ExceptionHelper;
import de.uka.ipd.sdq.dsexplore.helper.ConfigurationHelper;
import de.uka.ipd.sdq.dsexplore.helper.LoggerHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Starts a SimuCom Analysis for the design space exploration. 
 * @author Anne
 *
 */
public class SimuComAnalysis extends SimuComWorkflowLauncher implements IAnalysis {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/** Store the launch parameters so that we do not have to pass them all the time.*/
	private ILaunchConfiguration config;

	private String experimentName;

	private SimuComWorkflowConfiguration simuComWorkflowConfiguration;

	private PCMInstance pcmInstance;

	private List<Objective> objectives;

	private MDSDBlackboard blackboard;

	/**
	 * Calls SimuCom. Before doing so, it calls the {@link ConfigurationHelper}
	 * to update the {@link ILaunchConfiguration} and stores the
	 * {@link PCMInstance} to files, so that SimuCom can read it as usual. After
	 * the SimuCom run, the analysis results are extracted from the
	 * sensorFramework data sources and returned. The returned
	 * {@link IAnalysisResult} is a {@link SimuComAnalysisResult} which does not
	 * store the results directly, but provides access to the underlying
	 * sensorFramework data sources.
	 * 
	 * {@inheritDoc}
	 * @throws UserCanceledException 
	 * 
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysis#analyse(de.uka.ipd.sdq.dsexplore.PCMInstance)
	 */
	@Override
	public void analyse(IProgressMonitor monitor) throws AnalysisFailedException, CoreException, UserCanceledException {

		launchSimuCom( monitor);		
		
		
	}

	

	private IStatisticAnalysisResult retrieveSimuComResults(UsageScenario usageScenario)
			throws CoreException, AnalysisFailedException {
		
		
		
		IStatisticAnalysisResult result = null;
		int selectedDataSourceID = 
			config.getAttribute(
					SensorFrameworkConfig.DATASOURCE_ID, -1);
		if (SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID) == null)
		    {}
		else {
			IDAOFactory factory = SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID);
			
			//XXX: Quick fix: Assume that there is just one experiment with the name of the current PCM instance.
			//Iterator<Experiment> it = factory.createExperimentDAO().findByExperimentName(experimentName
			//		+" RunNo. "+config.getAttribute(ConstantsContainer.RUN_NO, "0")).iterator();
			Iterator<Experiment> it = factory.createExperimentDAO().findByExperimentName(experimentName).iterator();
			if (it.hasNext()){
			  Experiment resultingExperiment = it.next();
			  Collection<ExperimentRun> runs = resultingExperiment.getExperimentRuns();
			  if (runs.size() > 0){
				  ExperimentRun myrun = getLatestRun(runs);
				  result = new SimuComAnalysisResult(myrun, resultingExperiment, pcmInstance, usageScenario);					  
			  } else {
					String errormessage = "There was no experiment run for experiment named \""
						+experimentName+"\" after analysing the PCM instance \""
						+this.experimentName+"\".";
					logger.error(errormessage);
					throw new AnalysisFailedException(errormessage);
			  }
			  
			} else {
				String errormessage = "There was no experiment named \""
					+experimentName+"\" after analysing the PCM instance \""
					+this.experimentName+"\".";
				logger.error(errormessage);
				throw new AnalysisFailedException(errormessage);
			}
		}
		return result;
	}


	private void launchSimuCom(IProgressMonitor monitor)
			throws CoreException, AnalysisFailedException, UserCanceledException {
		
/*		LoadPCMModelsIntoBlackboardJob loadJob = new LoadPCMModelsIntoBlackboardJob(config);
				
		PCMInstance pcm = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		pcm.saveToXMIFile(pcm.getSystem(), this.config.getAttribute(ConstantsContainer.SYSTEM_FILE, ""));
		pcm.saveToXMIFile(pcm.getAllocation(), this.config.getAttribute(ConstantsContainer.ALLOCATION_FILE, ""));
		
		SimuComWorkflowLauncher simuCom = new SimuComWorkflowLauncher();
		
		AbstractPCMWorkflowRunConfiguration PCMConfig;*/
		
		SimuComJob job = new SimuComJob(this.simuComWorkflowConfiguration, null, false);
		job.setBlackboard(this.blackboard);
		
		try {
			//simuCom.launch(config, ILaunchManager.RUN_MODE, launch, monitor);
			//restoreLogger(config);
			job.execute(monitor);
			logger.debug("Finished SimuCom analysis");
		} catch (JobFailedException e) { 
			logger.error(e.getMessage());
			throw new AnalysisFailedException(e);
		} 

	}


	/** Put all the old appends back in the logger. FIXME: does not work as expected :( but whatever.
	 * @throws CoreException */
	private void restoreLogger(ILaunchConfiguration config) throws CoreException {
		BasicConfigurator.resetConfiguration();
		LoggerHelper.initializeLogger(config);
	}	
		

	/**
	 * Get the latest Run from the {@link Collection} based on the getExperimentDateTime() 
	 * value. 
	 * @param runs A collection of {@link ExperimentRun}
	 * @return The latest run or the first in the collection if timestamps 
	 * cannot properly be parsed.  
	 */
	private ExperimentRun getLatestRun(Collection<ExperimentRun> runs) {
		Iterator<ExperimentRun> iterator = runs.iterator();
		ExperimentRun latest = iterator.next();
		//FIXME: Due to Bug 395, I cannot get the order of ExperimentRuns. 
		//Quickfix: Extract it from the (nasty) ExperimentDateTime String as a long.
		long dateLatest = extractTimestamp(latest.getExperimentDateTime());
		for (; iterator.hasNext();) {
			ExperimentRun experimentRun = iterator.next();
			logger.debug("Looking at run "+experimentRun.getExperimentDateTime());
			long runDate = extractTimestamp(experimentRun.getExperimentDateTime());
			if (dateLatest < runDate){
				latest = experimentRun;
				dateLatest = runDate;
			}
		}
		logger.debug("Latest run: "+latest.getExperimentDateTime());
		return latest;
	}



	/**
	 * Extract time stamps from the experimentDateTime string. This is just a 
	 * QuickFix because {@link ExperimentRun}s currently do not store their 
	 * time properly.    
	 * 
	 * Delete this method after Bug 395 is fixed. 
	 * 
	 * @param experimentDateTime
	 * @return The {@link Date} of the {@link ExperimentRun} 
	 */
	private long extractTimestamp(String experimentDateTime) {
		//XXX fix this as soon as Bug 395 is fixed
		
		//Cut the "Run " part.
		experimentDateTime = experimentDateTime.substring(4);
		String[] experimentDateTimeArray = experimentDateTime.split(" ");
		String month = experimentDateTimeArray[1];
		
		//This is stupid, but what else to do with the nasty string...
		int monthNo = 0;
		if (month.equals("Jan")){
			monthNo = 1;
		} else if (month.equals("Feb")){
			monthNo = 2;
		} else if (month.equals("Mar")){
			monthNo = 3;
		} else if (month.equals("Apr")){
			monthNo = 4;
		} else if (month.equals("May")){
			monthNo = 5;
		} else if (month.equals("Jun")){
			monthNo = 6;
		} else if (month.equals("Jul")){
			monthNo = 7;
		} else if (month.equals("Aug")){
			monthNo = 8;
		} else if (month.equals("Sep")){
			monthNo = 9;
		} else if (month.equals("Oct")){
			monthNo = 10;
		} else if (month.equals("Nov")){
			monthNo = 11;
		} else monthNo = 12;
		
		int day = Integer.parseInt(experimentDateTimeArray[2]);
		String[] time = experimentDateTimeArray[3].split(":");
		int hour = Integer.parseInt(time[0]);
		int minute = Integer.parseInt(time[1]);
		int second = Integer.parseInt(time[2]);
		int year = Integer.parseInt(experimentDateTimeArray[5]);
		
		//The date in seconds since year 0.
		long date = (((((year * 12) + monthNo) * 31 + day)* 24 + hour)*60 + minute ) * 60 + second;
		
		return date;
	}



	/**
	 * {@inheritDoc}
	 * @throws CoreException 
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysis#initialise(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void initialise(ILaunchConfiguration configuration) throws CoreException {
		this.config = configuration;
		if (blackboard == null){
			throw ExceptionHelper.createNewCoreException("Error in initialisation: No Blackboard was set when initialising the SimuCom Analysis. Contact the developers.");
		}
		
		this.experimentName = configuration.getAttribute(SimuComConfig.EXPERIMENT_RUN, "");
		
		this.simuComWorkflowConfiguration = deriveConfiguration(configuration, ILaunchManager.RUN_MODE);
		this.simuComWorkflowConfiguration.setOverwriteWithoutAsking(true);
		
		this.pcmInstance = new PCMInstance((PCMResourceSetPartition)blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		List<UsageScenario> scenarios = pcmInstance.getUsageModel().getUsageScenario_UsageModel();
		this.objectives = new ArrayList<Objective>(scenarios.size());
		for (UsageScenario usageScenario : scenarios) {
			objectives.add(new UsageScenarioBasedObjective(this.getQualityAttribute(), Objective.Sign.MIN, usageScenario));
		}
	}



	@Override
	public IStatisticAnalysisResult retrieveLastResultsForObjective(Objective obj) throws CoreException, AnalysisFailedException {
		if(obj instanceof UsageScenarioBasedObjective){
			return this.retrieveSimuComResults(((UsageScenarioBasedObjective)obj).getUsageScenario());
		}
		throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore.analysis.simucom", "Cannot handle Objective of type "+obj.getClass()+". Required is UsageScenarioBasedObjective."));
	}



	@Override
	public String getQualityAttribute() throws CoreException {
		return DSEConstantsContainer.MEAN_RESPONSE_TIME_QUALITY;
}



	@Override
	public boolean hasStatisticResults() throws CoreException {
		return true;
	}



	@Override
	public List<Objective> getObjectives() throws CoreException {
		return this.objectives;
	}



	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		return true;
	}



	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}
	
	

}
