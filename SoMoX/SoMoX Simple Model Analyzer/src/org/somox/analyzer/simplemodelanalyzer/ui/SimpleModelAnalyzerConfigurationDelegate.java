package org.somox.analyzer.simplemodelanalyzer.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.somox.analyzer.simplemodelanalyzer.Activator;
import org.somox.analyzer.simplemodelanalyzer.SimpleModelAnalyzer;
import org.somox.core.SoMoXCoreLogger;
import org.somox.ui.GUISoMoXCoreController;

/**
 * The class is defined by the delegate attribute of a launchConfigurationType
 * extension and performs launching for a Model Analyzer launch configuration.
 * 
 * @author Michael Hauck
 */
public class SimpleModelAnalyzerConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.
	 * eclipse.debug.core.ILaunchConfiguration, java.lang.String,
	 * org.eclipse.debug.core.ILaunch,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		GUISoMoXCoreController controller = org.somox.ui.Activator.getDefault()
				.getGuiSoMoXCoreController();

		Preferences preferencesTemp = Activator.getDefault()
				.getPluginPreferences();
		final Preferences preferences = new Preferences();
		final IProgressMonitor progressMonitor = monitor;
		String[] availableProperties = preferencesTemp.propertyNames();
		// Make a copy of the preferences to store run dialog preferences
		// as well
		for (int i = 0; i < availableProperties.length; i++) {
			preferences.setValue(availableProperties[i], preferencesTemp
					.getString(availableProperties[i]));
		}
		Set<Map.Entry<String, Object>> runConfigProperties = configuration
				.getAttributes().entrySet();
		Iterator<Map.Entry<String, Object>> i = runConfigProperties.iterator();
		while (i.hasNext()) {
			Map.Entry<String, Object> entry = i.next();
			preferences.setValue(entry.getKey(), entry.getValue().toString());
		}

		if (controller == null) {
			SoMoXCoreLogger.logError("SoMoX Core Controller not loaded", null);
			return;
		}

		// Since we are not in the UI world here (ILaunchConfigurationDelegate 
		// is not a UI element), creating a ProgressDialog is not possible.
		// Instead, do all work in a thread.
		new Thread(new Runnable() {
			public void run() {
				GUISoMoXCoreController controller = org.somox.ui.Activator
						.getDefault().getGuiSoMoXCoreController();
				controller.startAnalyze(SimpleModelAnalyzer.class.getName(),
						progressMonitor, preferences);
			}
		}).start();


	}

	/*
	 * private MessageConsole getConsole() { if (console == null) { console =
	 * new MessageConsole("Model Extraction Console", null);
	 * ConsolePlugin.getDefault().getConsoleManager().addConsoles( new
	 * IConsole[] { console }); } console.activate(); return console; }
	 * 
	 * private PrintStream getPrintStream() { if (myOutStream == null) {
	 * MessageConsole console = getConsole(); myOutStream = new
	 * PrintStream(console.newMessageStream()); } return myOutStream; }
	 */

}
