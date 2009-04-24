package org.somox.ui.runconfig;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.somox.ui.Activator;
import org.somox.ui.GUISoMoXCoreController;


/**
 * The class is defined by the delegate attribute of a launchConfigurationType
 * extension and performs launching for a Model Analyzer launch configuration.
 * 
 * @author Michael Hauck
 */
public class ModelAnalyzerConfigurationDelegate implements
		ILaunchConfigurationDelegate{

	/*(non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		GUISoMoXCoreController controller = Activator.getDefault().getGuiSoMoXCoreController();
		IProcess[] p = launch.getProcesses();
		if (p != null) {
			for (int i=0; i<p.length; i++) {
				System.err.println("process: " + p[i]);
			}
		}
		
		if(controller == null){
			//MessageDialog.openError(shell, "SoMoX Core Controller not loaded", "The SoMoX Core Controller can not be accessed. This indicates that the controller is not loaded yet. May be the SoMoX Core itself is not in place or not started yet.");
		} else {
			Preferences preferencesTemp = Activator.getDefault().getPluginPreferences();
			Preferences preferences = new Preferences();
			String[] availableProperties = preferencesTemp.propertyNames();
			// Make a copy of the preferences to store run dialog preferences
			// as well
			for (int i=0; i<availableProperties.length; i++) {
				preferences.setValue(availableProperties[i], preferencesTemp.getString(availableProperties[i]));
			}
			Set<Map.Entry<String, Object>> runConfigProperties = configuration.getAttributes().entrySet();
			Iterator<Map.Entry<String, Object>> i = runConfigProperties.iterator();
			while (i.hasNext()) {
				Map.Entry<String, Object> entry = i.next();
				preferences.setValue(entry.getKey(), entry.getValue().toString());
			}
			//controller.startAnalyze(monitor, preferences);
			//controller.startExtraction(monitor, preferences);
			
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
