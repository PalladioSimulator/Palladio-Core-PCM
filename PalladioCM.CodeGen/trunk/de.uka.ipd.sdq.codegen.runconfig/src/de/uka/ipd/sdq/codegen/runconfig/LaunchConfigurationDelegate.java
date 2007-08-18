package de.uka.ipd.sdq.codegen.runconfig;

import java.io.PrintStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;
import de.uka.ipd.sdq.codegen.workflow.Workflow;
import de.uka.ipd.sdq.codegen.workflow.WorkflowExceptionHandler;

/**
 * The class is defined by the delegate attribute of a launchConfigurationType
 * extension and performs launching for a SimuBench launch configuration.The
 * class is abstract and defines the following methods, which must be
 * implemented by subclasses.
 * 
 * defineTemplateMethod() 
 * 					- value of AOP_TEMPLATE attribute
 * createRunCompositeJob() 
 * 					- create the composite job, which had to be added to Workflow 
 * isShouldThrowException() 
 * 					- should exception if launching fails
 * 
 * @author Roman Andrej
 */
public abstract class LaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	private static MessageConsole console = null;
	private static PrintStream myOutStream = null;


	/*(non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		/** set a template method in the configuration */
		ILaunchConfiguration configWithTemplate = setTemplateMethode(configuration);
		
		PrintStream outStream = System.out;
		PrintStream errStream = System.err;
		System.setOut(getPrintStream());
		System.setErr(getPrintStream());
		
		Workflow workflow = new Workflow(monitor);
		workflow.addJob(createRunCompositeJob(configWithTemplate));
		
		WorkflowExceptionHandler handler = new WorkflowExceptionHandler(
				isShouldThrowException(configuration));
		
		try {
			//execute all steps
			workflow.run();
		} catch (JobFailedException e) {
			handler.handleJobFailed(e);
		} catch (UserCanceledException e) {
			handler.handleUserCanceled(e);
		} finally {
			try {
				workflow.rollback();
			} catch (RollbackFailedException e) {
				handler.handleRollbackFailed(e);
			}
		}
		
		System.setOut(outStream);
		System.setErr(errStream);
	}
	
	private MessageConsole getConsole() {
		if (console == null) {
			console = new MessageConsole("SimuComController Generator Console",
					null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { console });
		}
		console.activate();
		return console;
	}
	
	private PrintStream getPrintStream() {
		if (myOutStream == null) {
			MessageConsole console = getConsole();
			myOutStream = new PrintStream(console.newMessageStream());
		}
		return myOutStream;
	}

	/**
	 * This function sets the attributes AOP_TEMPLATE. But a copy is provided by
	 * ILaunchConfiguration.
	 */
	private ILaunchConfigurationWorkingCopy setTemplateMethode(
			ILaunchConfiguration configuration) throws CoreException {

		ILaunchConfigurationWorkingCopy copy = configuration.copy(configuration
				.getName());
		copy.setAttribute(ConstantsContainer.AOP_TEMPLATE, defineTemplateMethod());

		return copy;
	}
	
	/**
	 * @return a value of AOP_TEMPLATE attribute
	 */
	protected abstract String defineTemplateMethod();

	/**
	 * create the composite job, which had to be added to Workflow
	 * @see de.uka.ipd.sdq.codegen.workflow.Workflow
	 * 
	 * @param configuration
	 *            the configuration to launch
	 * @exception CoreException
	 *                if launching fails
	 */
	protected abstract IJob createRunCompositeJob(
			ILaunchConfiguration configuration) throws CoreException;

	/**
	 * @param configuration
	 *            the configuration to launch
	 * @exception CoreException
	 *                if launching fails
	 */
	protected abstract boolean isShouldThrowException(
			ILaunchConfiguration configuration) throws CoreException;
	
}
