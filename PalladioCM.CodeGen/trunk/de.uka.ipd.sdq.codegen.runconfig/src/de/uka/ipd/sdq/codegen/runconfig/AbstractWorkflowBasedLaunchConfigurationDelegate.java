package de.uka.ipd.sdq.codegen.runconfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.Workflow;
import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflow;
import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflowExceptionHandler;

/**
 * Abstract base class of all solver runs for PCM model instances. A PCM model instance
 * consists of a PCM system model, its allocation, a resource environment, several PCM
 * repositories, and a usage model.
 * 
 * The class is supposed to be used to implement Eclipse run configurations, like SimuCom, ProtoCom,
 * PCM2Java, PCM2LQN, etc.
 * 
 * The class is abstract and defines some methods, which must be
 * implemented by subclasses. See method descriptions for details.
 * 
 * @author Roman Andrej
 * 		   Steffen Becker
 */

public abstract class AbstractWorkflowBasedLaunchConfigurationDelegate<WorkflowConfigurationType extends AbstractWorkflowBasedRunConfiguration>
	implements ILaunchConfigurationDelegate {

	protected Log logger = null;

	/*(non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		// Add a process to this launch, needed for Eclipse UI updates
		launch.addProcess(getProcess(launch));

		setupApacheCommonsLogging();

		logger.info("Create workflow configuration");
		WorkflowConfigurationType workflowConfiguration = 
			deriveConfiguration(configuration, mode);
		
		logger.info("Validating configuration...");
		workflowConfiguration.validateAndFreeze();
	
		
		Workflow workflow = new UIBasedWorkflow(
				createWorkflowJob(workflowConfiguration), 
				monitor, 
				new UIBasedWorkflowExceptionHandler(
						!workflowConfiguration.isInteractive()));
		workflow.run();
		
		// Singnal execution terminatation to Eclipse to update UI 
		launch.getProcesses()[0].terminate();
	}

	/**
	 * @param launch
	 * @return
	 */
	protected SimProcess getProcess(ILaunch launch) {
		return new SimProcess(launch);
	}

	protected void setupApacheCommonsLogging() {
		/* Configure Apache Commons Logger for tools supporting this kind of logging
		 * method
		 */
		System.setProperty("org.apache.commons.logging.simplelog.defaultlog","info");
		logger = LogFactory.getLog(AbstractWorkflowBasedLaunchConfigurationDelegate.class);
	}
	
	/**
	 * Create the job executed in the underlying workflow
	 * 
	 */
	protected abstract IJob createWorkflowJob(
			WorkflowConfigurationType config) throws CoreException;
	
	/**
	 * The method create the instance of generic type. The type defines that
	 * access methods on ILaunchConfiguration-Object
	 * @param mode 
	 * @throws CoreException 
	 */
	protected abstract WorkflowConfigurationType deriveConfiguration(ILaunchConfiguration configuration, String mode) throws CoreException;
}
