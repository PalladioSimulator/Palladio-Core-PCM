package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.qualityAttributes.QualityAttribute;

public interface IAnalysis {

	
	public abstract AnalysisResult analyse(PCMInstance pcmInstance, ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws AnalysisFailedException;
}
