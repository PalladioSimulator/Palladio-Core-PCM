package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

/**
 * This class represents the result of a LQN simulation analysis. 
 * 
 * @author pmerkle
 *
 */
public class LQSimAnalysisResult extends LQNResult implements IStatisticAnalysisResult {
	
	
	public LQSimAnalysisResult(LqnModelType model, PCMInstance pcm, UsageScenarioBasedObjective objective) throws AnalysisFailedException {
		super(pcm, model, objective);

	}
	

	public ConfidenceInterval getConfidenceInterval() {
		return null;
	}


	public long getNumberOfObservations() {
		return 0;
	}

}
