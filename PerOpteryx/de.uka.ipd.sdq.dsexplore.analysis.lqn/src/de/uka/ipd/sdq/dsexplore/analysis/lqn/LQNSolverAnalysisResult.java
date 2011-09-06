package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import java.util.Map;

import org.opt4j.core.Criterion;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

/**
 * This class represents the result of a LQN Solver analysis. 
 * 
 * @author pmerkle
 *
 */
public class LQNSolverAnalysisResult extends LQNResult implements IStatisticAnalysisResult {
	

	public LQNSolverAnalysisResult(LqnModelType model, PCMInstance pcm, 
			Criterion criterion, Map<Criterion, EvaluationAspectWithContext> objectiveToAspect,
			LQNQualityAttributeDeclaration qualityAttributeInfo) throws AnalysisFailedException {

		super(pcm, model, criterion, objectiveToAspect, qualityAttributeInfo);

	}
	
	public ConfidenceInterval getConfidenceInterval() {
		return null;
	}



	public long getNumberOfObservations() {
		return 0;
	}

}


