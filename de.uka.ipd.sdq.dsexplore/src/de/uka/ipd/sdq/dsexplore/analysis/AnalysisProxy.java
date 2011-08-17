package de.uka.ipd.sdq.dsexplore.analysis;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.core.Criterion;

import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSELaunch;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/** Singleton */
public class AnalysisProxy implements IAnalysis {

	private ILaunchConfiguration configuration;
	
	private String qualityAttributeName;
	private String qualityAttributeId;
	
	IAnalysis ana = null;
	
	//TODO: Quickfix to reset the Loggers. Refactor!
	private DSELaunch dseLaunch;

	/**Name of the analysis extension to load, e.g. LQN solver. */ 
	private String methodName;

	private MDSDBlackboard blackboard;

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy");

	public AnalysisProxy(ILaunchConfiguration configuration,  String qualityAttributeName, String qualityAttributeId, DSELaunch dseLaunch, String methodName) {
		this.initialise(configuration);
		this.qualityAttributeName = qualityAttributeName;
		this.qualityAttributeId = qualityAttributeId;
		this.dseLaunch = dseLaunch;
		this.methodName = methodName;
	}

	@Override
	public void analyse(IProgressMonitor monitor) throws CoreException, UserCanceledException, AnalysisFailedException, JobFailedException {
		IAnalysis ana = getDecoratedAnalysis();
		
		logger.debug("Starting analysis of "+qualityAttributeName);
		ana.analyse(monitor);
		logger.debug("Finished analysis of "+qualityAttributeName);
		dseLaunch.resetLoggers();

	}
	
	private IAnalysis getDecoratedAnalysis() throws CoreException {
		if (ana == null){
			ana = this.loadDecoratedAnalysis();
			ana.setBlackboard(blackboard);
			ana.initialise(configuration);

		} 
		return ana;
	}
	
	private IAnalysis loadDecoratedAnalysis() throws CoreException{
		// obtain the extension of the choosen analysis method 
		IExtension[] extensions = ExtensionHelper.loadAnalysisExtensions();
		for (IExtension ext : extensions) {
			IConfigurationElement[] elements = ext.getConfigurationElements();
			for (IConfigurationElement element : elements) {
				if (element.getName().equals("analysis")) { 
					// if extension fits to analysis method
					if (element.getAttribute("name").equals(methodName)) { 
						// obtain an analysis method instance  
						ana = (IAnalysis)ExtensionHelper.loadExecutableAttribute(element, "delegate");
						return ana;
					}
				}
			}
		}
		throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", "Cannot load analysis extension for "+methodName)); 
	}

	@Override
	public void initialise(ILaunchConfiguration configuration) {
		this.configuration = configuration;
	}


	@Override
	public String getQualityAttribute() throws CoreException {
		return getDecoratedAnalysis().getQualityAttribute();
}

	@Override
	public boolean hasStatisticResults() throws CoreException {
		return this.getDecoratedAnalysis().hasStatisticResults();
	}

	@Override
	public List<Criterion> getCriterions() throws CoreException {
		return getDecoratedAnalysis().getCriterions();
	}

	@Override
	public IAnalysisResult retrieveLastResultsForCriterion(Criterion criterion)
			throws CoreException, AnalysisFailedException {
		return getDecoratedAnalysis().retrieveLastResultsForCriterion(criterion);
	}

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		if (ana != null){
			ana = loadDecoratedAnalysis();
		}
		//ana may be not initialised
		return ana.hasObjectivePerUsageScenario();
	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
