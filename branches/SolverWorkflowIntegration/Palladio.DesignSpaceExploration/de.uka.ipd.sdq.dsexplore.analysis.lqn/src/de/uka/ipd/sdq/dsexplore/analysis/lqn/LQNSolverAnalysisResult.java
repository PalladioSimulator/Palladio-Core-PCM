package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import java.text.ParseException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityDefType;
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
 * This class represents the result of a LQN Solver analysis. 
 * 
 * @author pmerkle
 *
 */
public class LQNSolverAnalysisResult implements IAnalysisResult {
	
	protected static Logger logger = Logger
			.getLogger("de.uka.ipd.sdq.dsexplore");
	
	//private LqnModelType model;

	private PCMInstance pcm;

	private double responseTime;
	
	//private String utilization;

	//private String throughput;
	
	public LQNSolverAnalysisResult(LqnModelType model, PCMInstance pcm) throws AnalysisFailedException {
		//this.model = model;
		this.pcm = pcm;
		
		initialize(model);
	}
	
	private void initialize(LqnModelType model) throws AnalysisFailedException {
		responseTime = 0.0;
		//utilization = "0";
		//throughput = "0";
		
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
		//OutputResultType outputResult = task.getResultTask().get(0);
		
		// We add all result service times of the usage scenario to compute the response time
		// TODO: check whether this works correctly if the usage scenario contains branches
		EList<ActivityDefType> activities = task.getTaskActivities().getActivity();
		for (ActivityDefType activity : activities) {
			EList<OutputResultType> results = activity.getResultActivity();
			for (OutputResultType outputResultType : results) {
				try {
					responseTime += LQNUtils.convertStringToDouble((String) outputResultType.getServiceTime());
				}
				catch (ParseException ex) {
					throw new AnalysisFailedException(
							"Failed to parse string value.", ex);
				}
			}
		}
		
		//utilization = (String) outputResult.getUtilization();
		//throughput = (String) outputResult.getThroughput();
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
	 * Not applicable to LQN Solver results. 
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
