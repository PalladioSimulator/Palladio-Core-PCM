package org.somox.ui.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.somox.ui.Activator;
import org.somox.ui.GUISoMoXCoreController;


/**
 * The class is defined by the delegate attribute of a launchConfigurationType
 * extension and performs launching for a Model Extraction launch configuration.
 * 
 * @author Michael Hauck
 */
public abstract class ModelExtractionConfigurationDelegate implements
		ILaunchConfigurationDelegate{

	/*(non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		//launch.addProcess(new ModelExtractorProcess(launch));
		/*PrintStream outStream = System.out;
		PrintStream errStream = System.err;
		PrintStream consoleStream = getPrintStream();
		System.setOut(consoleStream);
		System.setErr(consoleStream);*/
		// check that the controller is available
		GUISoMoXCoreController controller = Activator.getDefault().getGuiSoMoXCoreController();
		//controller.startExtraction(progressMonitor);
		if(controller == null){
			//MessageDialog.openError(shell, "SoMoX Core Controller not loaded", "The SoMoX Core Controller can not be accessed. This indicates that the controller is not loaded yet. May be the SoMoX Core itself is not in place or not started yet.");
		} else {
			controller.startExtraction(monitor);
			
		}
		// Signal execution termination 
		//launch.getProcesses()[0].terminate();
	}
	
	/*private MessageConsole getConsole() {
		if (console == null) {
			console = new MessageConsole("Model Extraction Console",
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
	}*/

}
