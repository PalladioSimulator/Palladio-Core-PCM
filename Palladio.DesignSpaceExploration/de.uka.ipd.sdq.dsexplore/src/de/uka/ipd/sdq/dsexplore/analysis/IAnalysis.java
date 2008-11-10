package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;

public interface IAnalysis {

	/**
	 * Analyses the passed {@link PCMInstance}. 
	 * @param pcmInstance
	 * @return
	 * @throws AnalysisFailedException
	 * @throws CoreException
	 */
	public abstract IAnalysisResult analyse(PCMInstance pcmInstance) throws AnalysisFailedException, CoreException;

	 /**
	  * Saves the passed Run Configuration information so that we do not have to pass them as parameters all the time.  
	  * @param configuration
	  * @param mode
	  * @param launch
	  * @param monitor
	  */
	public abstract void initialise(ILaunchConfiguration configuration, String mode, ILaunch launch,IProgressMonitor monitor);

	public abstract IAnalysisResult retrieveLastResults(PCMInstance pcmInstance) throws CoreException, AnalysisFailedException;

}
