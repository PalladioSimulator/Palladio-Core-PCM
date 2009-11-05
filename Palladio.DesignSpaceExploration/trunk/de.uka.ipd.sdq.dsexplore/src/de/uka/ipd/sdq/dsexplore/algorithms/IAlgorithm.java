package de.uka.ipd.sdq.dsexplore.algorithms;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;

public interface IAlgorithm {
	
	/**
	 * Initialise the algorithm with an initial population and the analysis tool to use. 
	 * @param population
	 * @param perfAnalysisTool
	 * @param configuration 
	 * @throws CoreException 
	 */
	public void initialise(List<PCMInstance> population, IAnalysis analysisTool, ILaunchConfiguration conf) throws CoreException;

	/**
	 * True if the heuristic terminated.
	 * @return
	 */
	public boolean terminated();

	/** 
	 * One iteration of the heuristic. Depending on the actual implementation, new options are generated, assessed and some are kept for the next generation.   
	 * @param population
	 * @return The next generation of candidates
	 * @throws CoreException
	 * @throws AnalysisFailedException
	 */
	List<IAnalysisResult> iterate(List<IAnalysisResult> population)
			throws CoreException, AnalysisFailedException;
}
