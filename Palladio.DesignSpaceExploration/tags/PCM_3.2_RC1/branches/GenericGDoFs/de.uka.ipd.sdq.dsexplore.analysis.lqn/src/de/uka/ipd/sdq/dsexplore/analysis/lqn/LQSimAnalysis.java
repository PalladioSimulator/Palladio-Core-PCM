package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import org.eclipse.core.runtime.CoreException;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedCriterion;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;

/**
 * Starts a LQN simulation analysis for the design space exploration.
 * 
 * @author pmerkle
 *
 */
public class LQSimAnalysis extends AbstractLQNAnalysis {

	
	@Override
	protected String getSolverMessageString() {
		return MessageStrings.LQSIM_SOLVER;
	}
	
	@Override
	protected LQNResult retrieveResult(PCMInstance pcm,
			LqnModelType model,UsageScenarioBasedCriterion criterion) throws AnalysisFailedException {
		LQSimAnalysisResult result = new LQSimAnalysisResult(model, pcm, criterion);
		return result;
	}		


	@Override
	public boolean hasStatisticResults() throws CoreException {
		return false;
	}

	@Override
	protected IAnalysisResult handleException(RuntimeException e, PCMInstance pcm) {
		throw e;
	}

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		return true;
	}

}
