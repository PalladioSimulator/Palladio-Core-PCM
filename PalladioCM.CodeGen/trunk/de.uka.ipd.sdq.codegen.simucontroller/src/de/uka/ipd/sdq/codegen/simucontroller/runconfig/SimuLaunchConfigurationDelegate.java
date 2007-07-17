package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.io.PrintStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.openarchitectureware.workflow.debug.WorkflowElementAdapter;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.UserCanceledException;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.Workflow;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.WorkflowExceptionHandler;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CheckOAWConstraintsJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CompilePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CreatePluginProjectJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.GeneratePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.LoadPluginJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimulateJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimulationRunCompositeJob;
import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * @author admin
 * 
 */
public class SimuLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	private static MessageConsole console = null;
	private static PrintStream myOutStream = null;

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

	/*
	 * (non-Javadoc)
	 * 
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
		workflow.addJob(new SimulationRunCompositeJob(configuration));
		
		boolean shouldThrowException = configuration.getAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, false);
		WorkflowExceptionHandler handler = new WorkflowExceptionHandler(shouldThrowException);
		
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
	
	
}
