package de.uka.ipd.sdq.dsexplore.newcandidates;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.dsexplore.PCMInstance;

public interface INewCandidates {

	/**
	 * The order of the list might represent an ordering of the results, from best to worst. 
	 * @param currentSolution
	 * @return
	 * @throws CoreException 
	 */
	public abstract List<PCMInstance> generateNewCandidates(PCMInstance currentSolution) throws CoreException;

	public void setGeneration(int generation) throws CoreException;  
}
