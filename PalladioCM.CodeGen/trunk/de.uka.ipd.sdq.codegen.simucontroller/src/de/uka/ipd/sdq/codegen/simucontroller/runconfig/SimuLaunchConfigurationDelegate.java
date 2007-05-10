/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.io.PrintStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.progress.UIJob;

/**
 * @author admin
 * 
 */
public class SimuLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {
	
	private static MessageConsole console = null;
	private static PrintStream myOutStream = null;
	
	private MessageConsole getConsole(){
		if (console == null) {
			console = new MessageConsole(
					"SimuComController Generator Console", null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { console });
		}
		console.activate();
		return console;
	}
	
	private PrintStream getPrintStream() {
		if (myOutStream == null){
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
		System.setOut(getPrintStream());	
		
		SimulationWorkflow workflow = new SimulationWorkflow(monitor);
		
		/**
		 * Step 1: Create container Plugin 
		 */
		CreatePluginProjectJob createPluginProjectJob = new CreatePluginProjectJob();
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
		// TODO Roman: SimTime aus Config auslesen!
		workflow.addJob(new SimulateJob(1500000));	
		
		//execute all steps
		try{
			workflow.run();
		}catch(final Exception e){
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					new MessageDialog(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Error running the simulation",
							null,
							"Error running the simulation. Exception given: "+e.getMessage(),
							MessageDialog.ERROR, new String[] { "OK" }, 0).open();
						}
			});
			// throw new RuntimeException(e);
		}
		//remove all files
		workflow.rollback();
		
		System.setOut(outStream);
		// ConsolePlugin.getDefault().getConsoleManager().removeConsoles(new IConsole[]{ console });
	}	
}
