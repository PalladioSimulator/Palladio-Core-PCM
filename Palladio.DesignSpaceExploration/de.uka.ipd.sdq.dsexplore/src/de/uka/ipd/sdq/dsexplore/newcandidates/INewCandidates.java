package de.uka.ipd.sdq.dsexplore.newcandidates;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;

public interface INewCandidates {

	/**
	 * The order of the list might represent an ordering of the results, from best to worst. 
	 * @param currentSolution
	 * @return
	 * @throws CoreException 
	 */
	public abstract List<PCMInstance> generateNewCandidates(IAnalysisResult currentSolution) throws CoreException;

}
