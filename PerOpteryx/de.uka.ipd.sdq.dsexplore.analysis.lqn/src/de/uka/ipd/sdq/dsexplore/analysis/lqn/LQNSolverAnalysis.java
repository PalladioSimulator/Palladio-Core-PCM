package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Criterion;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;

/**
 * Starts a LQN Solver Analysis for the design space exploration.
 * 
 * @author pmerkle
 *
 */
public class LQNSolverAnalysis extends AbstractLQNAnalysis {
	
	boolean hasConverged = true;

	/**
	 * try to handle the exception or throw it back. 
	 * @param e
	 * @return
	 */
	@Override
	protected IAnalysisResult handleException(RuntimeException e, PCMInstance pcm) {
		if (e.getMessage() != null && 
				(e.getMessage().contains("exited with 1: The model failed to converge."))
				|| (e.getMessage().contains("Open arrival rate of ") 
				    && e.getMessage().contains("is too high."))){
			hasConverged = false;
			return new LQNNotConvergedResult(pcm);
//		} else if (e.getMessage() != null && e.getMessage().contains("invalid input")){
//			 String inputFileName = Pcm2LqnStrategy.FILENAME_INPUT_XML;
//			 copyfile(inputFileName, inputFileName+"-invalidInput"+iteration);
//			 throw e;
//		} else if (e.getMessage() != null && e.getMessage().contains(" returned an unrecognised exit value")){
//			 String inputFileName = Pcm2LqnStrategy.FILENAME_INPUT_XML;
//			 copyfile(inputFileName, inputFileName+"-unrecognizedExit"+iteration);
//			 throw e;
		} else {
			throw e;
		}
		
	}
	
	@Override
	protected String getSolverMessageString() {
		return MessageStrings.LQNS_SOLVER;
	}

	@Override
	public boolean hasStatisticResults() throws CoreException {
		return false;
	}
	
	@Override
	protected ILQNResult retrieveResult(PCMInstance pcm,
			LqnModelType model, Criterion criterion) throws AnalysisFailedException {
		ILQNResult result;
		if (hasConverged){
			result = new LQNSolverAnalysisResult(model, pcm, criterion, this.criterionToAspect, this.lQNQualityAttribute);
		} else {
			result = new LQNNotConvergedResult(pcm);
			hasConverged = true;
		}
		return result;
	}
	

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		return true;
	}

	
	
}
