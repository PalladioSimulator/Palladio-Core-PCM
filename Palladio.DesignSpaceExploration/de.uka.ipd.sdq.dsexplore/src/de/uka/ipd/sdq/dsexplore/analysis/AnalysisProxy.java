package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;

/** Singleton */
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
//			ana = (IAnalysis)ExtensionHelper.loadExtension("de.uka.ipd.sdq.dsexplore.analysis").iterator().next();
			
			// obtain the extension of the choosen analysis method 
			String methodName = configuration.getAttribute(DSEConstantsContainer.ANALYSIS_METHOD, "");
			IExtension[] extensions = ExtensionHelper.loadAnalysisExtensions();
			for (IExtension ext : extensions) {
				IConfigurationElement[] elements = ext.getConfigurationElements();
				for (IConfigurationElement element : elements) {
					if (element.getName().equals("analysis")) { 
						// if extension fits to analysis method
						if (element.getAttribute("name").equals(methodName)) { 
							// obtain an analysis method instance  
							ana = (IAnalysis)ExtensionHelper.loadExecutableAttribute(ext, "analysis", "delegate");
							ana.initialise(configuration, mode,launch,monitor);
							return;
						}
					}
				}
			}
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