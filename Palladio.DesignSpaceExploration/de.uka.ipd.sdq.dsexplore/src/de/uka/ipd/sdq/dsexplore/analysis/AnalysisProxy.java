package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;

public class AnalysisProxy implements IAnalysis {

	@Override
	public AnalysisResult analyse(PCMInstance pcmInstance, ILaunchConfiguration config, String mode,
			ILaunch launch, IProgressMonitor monitor) throws AnalysisFailedException {
		IAnalysis ana = (IAnalysis)ExtensionHelper.loadExtension("de.uka.ipd.sdq.dsexplore.analysis");
		
		return ana.analyse(pcmInstance, config, mode, launch, monitor);

	}

}
