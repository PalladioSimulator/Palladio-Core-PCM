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
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/** Singleton */
public class AnalysisProxy implements IAnalysis {

	private String mode;
	private ILaunch launch;
	private IProgressMonitor monitor;
	private ILaunchConfiguration configuration;
	
	private String qualityAttribute;
	
	IAnalysis ana = null;

	public AnalysisProxy(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor, String qualityAttribute) {
		this.initialise(configuration, mode, launch, monitor);
		this.qualityAttribute = qualityAttribute;
	}

	@Override
	public IAnalysisResult analyse(PCMInstance pcmInstance) throws CoreException, UserCanceledException, AnalysisFailedException, JobFailedException {
		checkAnalysisExtension();
		
		return ana.analyse(pcmInstance);

	}

	private void checkAnalysisExtension() throws CoreException {
		if (ana == null){
//			ana = (IAnalysis)ExtensionHelper.loadExtension("de.uka.ipd.sdq.dsexplore.analysis").iterator().next();
			
			// obtain the extension of the choosen analysis method 
			String methodName = configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(this.qualityAttribute), "");
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
