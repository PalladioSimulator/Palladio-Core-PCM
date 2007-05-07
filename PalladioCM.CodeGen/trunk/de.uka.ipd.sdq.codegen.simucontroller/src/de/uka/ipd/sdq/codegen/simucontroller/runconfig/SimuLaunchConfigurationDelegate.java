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
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * @author admin
 * 
 */
public class SimuLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
			
		MessageConsole console = new MessageConsole(
				"SimuComController Generator Console", null);
		console.activate();
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] { console });

		MessageConsoleStream stream = console.newMessageStream();
		PrintStream outStream = System.out;
		System.setOut(new PrintStream(stream));	
		
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
		workflow.addJob(new SimulateJob());	
		
		//execute all steps
		workflow.run();
		//remove all files
		workflow.rollback();
		
		System.setOut(outStream);
		ConsolePlugin.getDefault().getConsoleManager().removeConsoles(new IConsole[]{ console });
	}	
}
