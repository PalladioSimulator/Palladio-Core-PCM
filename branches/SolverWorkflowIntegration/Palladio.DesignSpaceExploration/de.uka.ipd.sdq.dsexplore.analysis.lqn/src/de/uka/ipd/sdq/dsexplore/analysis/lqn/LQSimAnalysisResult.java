package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import java.text.ParseException;
import java.util.Iterator;

import org.apache.log4j.Logger;

import LqnCore.LqnModelType;
import LqnCore.OutputResultType;
import LqnCore.ProcessorType;
import LqnCore.TaskType;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Pcm2LqnHelper;

/**
 * This class represents the result of a LQN simulation analysis. 
 * 
 * @author pmerkle
 *
 */
public class LQSimAnalysisResult implements IAnalysisResult {
	
	protected static Logger logger = Logger
			.getLogger("de.uka.ipd.sdq.dsexplore");
	
	private LqnModelType model;

	private PCMInstance pcm;

	private double responseTime;
	
	private String utilization;

	private String throughput;
	
	public LQSimAnalysisResult(LqnModelType model, PCMInstance pcm) throws AnalysisFailedException {
		this.model = model;
		this.pcm = pcm;
		
		initialize();
	}
	
	private void initialize() throws AnalysisFailedException {
		responseTime = 0.0;
		utilization = "0";
		throughput = "0";
		
		// Retrieve the usage scenario's name used within the result
		// TODO: Can we really assume there is only one usage scenario?
		String scenarioName = Pcm2LqnHelper.getIdForUsageScenario(pcm.getUsageModel()
				.getUsageScenario_UsageModel().get(0)); 
		String processorName = scenarioName + "_Processor"; // see class LqnBuilder#getProcessorTypeFromModel(String)
		
		// Obtain processor, representing the usage scenario's overall resource demand
		ProcessorType processor = null;
		Iterator<ProcessorType> itProcessors = model.getProcessor().iterator();
		while (itProcessors.hasNext()) {
			ProcessorType proc = itProcessors.next();
			if (proc.getName().equals(processorName)) {
				processor = proc;
				break;
			}
		}
		
		// TODO: Can we really assume there is only one task?
		TaskType task = processor.getTask().get(0);
		OutputResultType outputResult = task.getResultTask().get(0);
		String serviceTimeMean = (String)task.getEntry().get(0).getResultEntry().get(0).getPhase1ServiceTime();
		try {
			responseTime = LQNUtils.convertStringToDouble(serviceTimeMean);
		}
		catch (ParseException ex) {
			throw new AnalysisFailedException(
					"Failed to parse string value.", ex);
		}
		
		utilization = (String) outputResult.getUtilization();
		throughput = (String) outputResult.getThroughput();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(IAnalysisResult other) {
		int res = 0;
		try {
			res = Double.valueOf(getMeanValue())
					.compareTo(other.getMeanValue());
		} catch (AnalysisFailedException ex) {
			logger.error("Failed to compare the analysis results.", ex);
		}
		
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMeanValue() throws AnalysisFailedException {
		return responseTime;
	}

	/**
	 * TODO 
	 * @return -1
	 */
	@Override
	public double getMedianValue() throws AnalysisFailedException {
		return -1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PCMInstance getPCMInstance() {
		return pcm;
	}

	/**
	 * Not implemented yet.
	 * @return -1
	 */
	@Override
	public double getUtilisationOfResource(ResourceContainer container,
			ProcessingResourceSpecification resource)
			throws AnalysisFailedException {
		// TODO Implement
		return -1;
	}

}
