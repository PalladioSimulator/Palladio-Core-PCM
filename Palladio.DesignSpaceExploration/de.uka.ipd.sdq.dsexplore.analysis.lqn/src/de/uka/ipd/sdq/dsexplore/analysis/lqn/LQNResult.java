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
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Pcm2LqnHelper;

public abstract class LQNResult implements IStatisticAnalysisResult {
	
	protected static Logger logger = Logger
	.getLogger("de.uka.ipd.sdq.dsexplore");
	
	protected double responseTime;
	protected double squaredCoeffVariance;
	
	protected PCMInstance pcm;

	public LQNResult(PCMInstance pcm2, LqnModelType model) throws AnalysisFailedException {
		this.pcm = pcm2;
		this.initialize(model);
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
		OutputResultType outputResult = task.getResultTask().get(0);
		
		try {
			this.responseTime = LQNUtils.getReponseTimeOfSubActivities(task);

			if (outputResult.getSquaredCoeffVariation() != null){
				this.squaredCoeffVariance = LQNUtils
					.convertStringToDouble((String) outputResult
							.getSquaredCoeffVariation());
			} else 
				this.squaredCoeffVariance = 1;
		} catch (ParseException ex) {
			throw new AnalysisFailedException("Failed to parse string value.",
					ex);
		}
		// utilization = (String) outputResult.getUtilization();
		// throughput = (String) outputResult.getThroughput();
	}


	@Override
	public double getMedianValue() throws AnalysisFailedException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PCMInstance getPCMInstance() {
		return pcm;
	}

	@Override
	public double getUtilisationOfResource(ResourceContainer container,
			ProcessingResourceSpecification resource)
			throws AnalysisFailedException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMeanValue() {
		return responseTime;
	}
	
	public double getSquaredCoefficientOfVariance(){
		return this.squaredCoeffVariance;
	}
	
	public double getCoefficientOfVariance(){
		return  Math.sqrt(this.squaredCoeffVariance);
	}
	
	public double getVariance(){
		double var = this.getSquaredCoefficientOfVariance() * this.getMeanValue() * this.getMeanValue(); 
		return var;
	}
	
	public double getStandardDeviation(){
		double std = Math.sqrt(this.getVariance()); 
		return std;
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

}
