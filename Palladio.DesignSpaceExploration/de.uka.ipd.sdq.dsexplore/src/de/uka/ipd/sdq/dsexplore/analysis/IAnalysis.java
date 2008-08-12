package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;

public interface IAnalysis {

	
	public abstract IAnalysisResult analyse(PCMInstance pcmInstance) throws AnalysisFailedException, CoreException;

	public abstract void initialise(ILaunchConfiguration configuration, String mode, ILaunch launch,IProgressMonitor monitor);
}
