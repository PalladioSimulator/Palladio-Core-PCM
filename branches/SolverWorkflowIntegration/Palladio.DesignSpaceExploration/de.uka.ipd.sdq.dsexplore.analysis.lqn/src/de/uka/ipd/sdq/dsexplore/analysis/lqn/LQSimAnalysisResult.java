package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

/**
 * This class represents the result of a LQN simulation analysis. 
 * 
 * @author pmerkle
 *
 */
public class LQSimAnalysisResult extends LQNResult implements IStatisticAnalysisResult {
	
	
	public LQSimAnalysisResult(LqnModelType model, PCMInstance pcm) throws AnalysisFailedException {
		super(pcm, model);

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


	@Override
	public ConfidenceInterval getConfidenceInterval()
			throws AnalysisFailedException {
		return null;
	}


	@Override
	public long getNumberOfObservations() throws AnalysisFailedException {
		return 0;
	}

}
