package de.uka.ipd.sdq.dsexplore.analysis;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.launch.DSELaunch;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/** Singleton */
public class AnalysisProxy implements IAnalysis {

	private ILaunch launch;
	private ILaunchConfiguration configuration;
	
	private String qualityAttribute;
	
	IAnalysis ana = null;
	private String mode;
	private IProgressMonitor monitor;
	
	//TODO: Quickfix to reset the Loggers. Refactor!
	private DSELaunch dseLaunch;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy");

	public AnalysisProxy(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor, String qualityAttribute, DSELaunch dseLaunch) {
		this.initialise(configuration, mode, launch, monitor);
		this.qualityAttribute = qualityAttribute;
		this.dseLaunch = dseLaunch;
	}

	@Override
	public IAnalysisResult analyse(PCMInstance pcmInstance) throws CoreException, UserCanceledException, AnalysisFailedException, JobFailedException {
		checkAnalysisExtension();
		
		logger.debug("Starting analysis of "+qualityAttribute);
		IAnalysisResult result = ana.analyse(pcmInstance);
		logger.debug("Finished analysis of "+qualityAttribute);
		dseLaunch.resetLoggers();
		return result;

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
							ana = (IAnalysis)ExtensionHelper.loadExecutableAttribute(element, "delegate");
							ana.initialise(configuration, mode, launch, monitor);
							return;
						}
					}
				}
			}
		}
	}

	@Override
	public void initialise(ILaunchConfiguration configuration, String mode, ILaunch launch,IProgressMonitor monitor) {
		this.launch = launch;
		this.configuration = configuration;
		this.mode = mode;
		this.monitor = monitor;
		
	}

	@Override
	public IAnalysisResult retrieveLastResults(PCMInstance pcmInstance)
			throws CoreException, AnalysisFailedException {
		checkAnalysisExtension();
		return ana.retrieveLastResults(pcmInstance);
	}

	@Override
	public String getQualityAttribute() throws CoreException {
		checkAnalysisExtension();
		return ana.getQualityAttribute();
}

}
