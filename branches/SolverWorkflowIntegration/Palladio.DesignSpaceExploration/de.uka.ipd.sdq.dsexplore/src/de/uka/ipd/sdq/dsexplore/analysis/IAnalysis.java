package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public interface IAnalysis {

	/**
	 * Analyses the passed {@link PCMInstance}. 
	 * @param pcmInstance
	 * @return
	 * @throws CoreException
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 * @throws AnalysisFailedException 
	 */
	public abstract IAnalysisResult analyse(PCMInstance pcmInstance) throws CoreException, UserCanceledException, JobFailedException, AnalysisFailedException;

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
