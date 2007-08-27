package de.uka.ipd.sdq.codegen.runconfig;

import java.io.PrintStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;

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
 * createRunCompositeJob() - create the composite job, which had to be added to
 * 									Workflow 
 * isShouldThrowException() - should exception if launching fails
 * 
 * In order to be able to make the co-variant restriction for this class, was
 * defined here directly a generic type parameter T. The parameter T must be
 * AttributesGetMethods or a subclass at least. Thus one limits already the use
 * range of this class from the beginning and avoids also unnecessary type
 * casting.
 * 
 * @author Roman Andrej
 */
public abstract class LaunchConfigurationDelegate<T extends AttributesGetMethods> implements
		ILaunchConfigurationDelegate{

	private static MessageConsole console = null;
	private static PrintStream myOutStream = null;
	private T attributes = null;


	/*(non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		PrintStream outStream = System.out;
		PrintStream errStream = System.err;
		System.setOut(getPrintStream());
		System.setErr(getPrintStream());

		Workflow workflow = new Workflow(monitor);
		
		/** create the instance of type T */
		attributes = creataAttributesGetMethods(configuration);

		WorkflowExceptionHandler handler = new WorkflowExceptionHandler(
				attributes.isShouldThrowException(configuration));

		try {
			workflow.addJob(createRunCompositeJob(attributes));
			// execute all steps
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
	 * create the composite job, which had to be added to Workflow
	 * 
	 * @see de.uka.ipd.sdq.codegen.workflow.Workflow
	 * 
	 * @param attributes -
	 *            the generic type must be AttributesGetMethods or a subclass at
	 *            least.
	 */
	protected abstract IJob createRunCompositeJob(
			T attributes) throws JobFailedException, CoreException;
	
	/**
	 * The method create the instance of generic type T. The type defines that
	 * access methods on ILaunchConfiguration-Object
	 */
	protected abstract T creataAttributesGetMethods(ILaunchConfiguration configuration);
}
