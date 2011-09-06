package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Criterion;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;

/**
 * Starts a LQN simulation analysis for the design space exploration.
 * 
 * @author pmerkle, martens
 *
 */
public class LQSimAnalysis extends AbstractLQNAnalysis {

	
	@Override
	protected String getSolverMessageString() {
		return MessageStrings.LQSIM_SOLVER;
	}
	
	@Override
	protected LQNResult retrieveResult(PCMInstance pcm,
			LqnModelType model, Criterion criterion) throws AnalysisFailedException {
		LQSimAnalysisResult result = new LQSimAnalysisResult(model, pcm, criterion, this.criterionToAspect, this.lQNQualityAttribute);
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
