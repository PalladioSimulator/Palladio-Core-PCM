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

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.CheckOAWConstraints;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.CompilePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.CreatePluginProjectJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.GeneratePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.LoadPluginJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.SimulateJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.SimulationWorkflow;
import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;


class ErrorDisplayRunner implements Runnable {
	private Throwable e;

	
	public ErrorDisplayRunner(Throwable e) {
		super();
		this.e = e;
	}

	public void run() {
		new ErrorDisplayDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), e).open();
	}

}

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
		boolean shouldThrowException = configuration.getAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, false);

		SimulationWorkflow workflow = new SimulationWorkflow(monitor);
		SimuComConfig simuConfig = new SimuComConfig(configuration.getAttributes());

		CheckOAWConstraints constraintsJob = new CheckOAWConstraints(configuration);
		workflow.addJob(constraintsJob);
		
		/**
		 * Step 1: Create container Plugin 
		 */
		CreatePluginProjectJob createPluginProjectJob = new CreatePluginProjectJob(configuration);
		workflow.addJob(createPluginProjectJob);

		/**
		 * Step 2: Generate source code with oAW-Generator
		 */
		workflow.addJob(new GeneratePluginCodeJob(configuration));

		/**
		 * Step 3: Compile the code
		 */
		workflow.addJob(new CompilePluginCodeJob(createPluginProjectJob));

		/**
		 * Step 4: Load a generated Plug-In
		 */
		workflow.addJob(new LoadPluginJob(createPluginProjectJob));

		/**
		 * Step 5: Simulate
		 */
		workflow.addJob(new SimulateJob(simuConfig));

		//execute all steps
		try {
			workflow.run();
		} catch (final Exception e) {
			if (shouldThrowException)
				throw new CoreException(new Status(IStatus.ERROR,SimuControllerPlugin.PLUGIN_ID,"Simulation failed",e));
			PlatformUI.getWorkbench().getDisplay().syncExec(new ErrorDisplayRunner(e));
		} finally {
			//remove all files
			try {
				workflow.rollback();
			} catch (Exception e) {
				if (shouldThrowException)
					throw new CoreException(new Status(IStatus.ERROR,SimuControllerPlugin.PLUGIN_ID,"Simulation failed",e));
				PlatformUI.getWorkbench().getDisplay().syncExec(new ErrorDisplayRunner(e));
			}
		}
		System.setOut(outStream);
		System.setErr(errStream);
	}
}
