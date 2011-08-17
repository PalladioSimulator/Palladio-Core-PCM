package de.uka.ipd.sdq.dsexplore.designdecisions;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

@Deprecated
public interface INewCandidates {

	/**
	 * The order of the list might represent an ordering of the results, from best to worst. 
	 * @param currentSolution
	 * @return
	 * @throws CoreException 
	 */
	public abstract List<DegreeOfFreedomInstance> generateDesignDecisions(PCMInstance currentSolution) throws CoreException;
	
	public abstract void setConfiguration(ILaunchConfiguration conf);


}
