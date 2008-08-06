package de.uka.ipd.sdq.dsexplore.analysis.simucom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuLaunchConfigurationDelegate;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.helper.LoggerHelper;
import de.uka.ipd.sdq.dsexplore.qualityAttributes.Performance;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimuComAnalysis implements IAnalysis {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public SimuComAnalysis() {
		// TODO Auto-generated constructor stub
	}
	
	 

	@Override
	public AnalysisResult analyse(PCMInstance pcmInstance, ILaunchConfiguration config, String mode,
			ILaunch launch, IProgressMonitor monitor) throws AnalysisFailedException {
		//pcmInstance.saveToFiles();
		//logger.debug("Written pcm instance to files");
		
		//start SimuCom Workflow
		
		logger.debug("Starting analysis");
		
		SimuLaunchConfigurationDelegate simuCom = new SimuLaunchConfigurationDelegate();
		AnalysisResult result = null;
		
		try {
			simuCom.launch(config, mode, launch, monitor);
			restoreLogger(config);
			logger.debug("Finished SimuCom analysis");
		} catch (CoreException e) {
			String standardError = "SimuCom launch failed for PCM instance \""+pcmInstance.getName()+"\"";
			logger.error(standardError);
			throw new AnalysisFailedException(standardError+": "+e.getMessage(), e);
		}
		
		try {
			int selectedDataSourceID = 
				config.getAttribute(
						SimuComConfig.DATASOURCE_ID, -1);
			if (SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID) == null)
			    {}
			else {
				IDAOFactory factory = SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID);
				String experimentName = pcmInstance.getName();
				//XXX: Quick fix: Assume that there is just one experiment with the name of the current PCM instance.
				Iterator<Experiment> it = factory.createExperimentDAO().findByExperimentName(experimentName
						+" RunNo. "+config.getAttribute(ConstantsContainer.RUN_NO, "1")).iterator();
				if (it.hasNext()){
				  Experiment resultingExperiment = it.next();
				  Collection<ExperimentRun> runs = resultingExperiment.getExperimentRuns();
				  if (runs.size() > 0){
					  ExperimentRun myrun = getLatestRun(runs);
					  result = new SimuComAnalysisResult(myrun, resultingExperiment, pcmInstance);					  
				  } else {
						String errormessage = "There was no experiment run for experiment named \""
							+experimentName+"\" after analysing the PCM instance \""
							+pcmInstance.getName()+"\".";
						logger.error(errormessage);
						throw new AnalysisFailedException(errormessage);
				  }
				  
				} else {
					String errormessage = "There was no experiment named \""
						+experimentName+"\" after analysing the PCM instance \""
						+pcmInstance.getName()+"\".";
					logger.error(errormessage);
					throw new AnalysisFailedException(errormessage);
				}
			}
		} catch (CoreException e) {
			String message = "Accessing the results of SimuCom launch failed for PCM instance \""+pcmInstance.getName()+"\"";
			logger.error(message);
			throw new AnalysisFailedException(message+": "+e.getMessage(), e);
		}
		
		return result;
		
	}


	/** Put all the old appends back in the logger. 
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
		//Quickfix: Extract it from the (nasty) ExperimentDateTime String.
		Date dateLatest = extractTimestamp(latest.getExperimentDateTime());
		for (; iterator.hasNext();) {
			ExperimentRun experimentRun = iterator.next();
			logger.debug("Looking at run "+experimentRun.getExperimentDateTime());
			Date runDate = extractTimestamp(experimentRun.getExperimentDateTime());
			if (dateLatest.compareTo(runDate) > 0){
				latest = experimentRun;
				dateLatest = runDate;
			}
		}
		logger.debug("Latest run: "+latest.getExperimentDateTime());
		return latest;
	}



	/**
	 * Extract timestamps from the experimentDateTime string. This is just a 
	 * QuickFix because {@link ExperimentRun}s currently do not store their 
	 * time properly.    
	 * 
	 * Delete this method after Bug 395 is fixed. 
	 * 
	 * @param experimentDateTime
	 * @return The {@link Date} of the {@link ExperimentRun} 
	 */
	private Date extractTimestamp(String experimentDateTime) {
		//Cut the "Run " part.
		Date date = null;
		experimentDateTime = experimentDateTime.substring(4);
		logger.debug(experimentDateTime);
		String[] experimentDateTimeArray = experimentDateTime.split(" ");
		DateFormat df = DateFormat.getDateInstance();
		logger.debug(df.getNumberFormat());
		logger.debug(df.getNumberFormat().toString());
/*		try {
			//date = df.parse(experimentDateTime);
		} catch (ParseException e) {
			logger.debug("Failed to parse date: "+experimentDateTime);
			e.printStackTrace();
			date = new Date();
		}*/
		return date;
	}

}
