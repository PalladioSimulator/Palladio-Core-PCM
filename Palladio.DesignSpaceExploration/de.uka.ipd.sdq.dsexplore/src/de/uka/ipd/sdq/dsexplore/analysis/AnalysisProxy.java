package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;

public class AnalysisProxy implements IAnalysis {

	private String mode;
	private ILaunch launch;
	private IProgressMonitor monitor;
	private ILaunchConfiguration configuration;
	
	IAnalysis ana = null;

	public AnalysisProxy(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) {
		this.initialise(configuration, mode, launch, monitor);
	}

	@Override
	public IAnalysisResult analyse(PCMInstance pcmInstance) throws AnalysisFailedException, CoreException {
		checkAnalysisExtension();
		
		return ana.analyse(pcmInstance);

	}

	private void checkAnalysisExtension() throws CoreException {
		if (ana == null){
			ana = (IAnalysis)ExtensionHelper.loadExtension("de.uka.ipd.sdq.dsexplore.analysis").iterator().next();
			ana.initialise(configuration, mode,launch,monitor);
		}
	}

	@Override
	public void initialise(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) {
		this.mode = mode;
		this.launch = launch;
		this.monitor = monitor;
		this.configuration = configuration;
		
	}

	@Override
	public IAnalysisResult retrieveLastResults(PCMInstance pcmInstance)
			throws CoreException, AnalysisFailedException {
		checkAnalysisExtension();
		return ana.retrieveLastResults(pcmInstance);
	}

}
