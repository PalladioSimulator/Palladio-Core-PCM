package org.somox.ui.runconfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.osgi.service.prefs.BackingStoreException;
import org.somox.common.SoMoXProjectPreferences;
import org.somox.ui.Activator;
import org.somox.ui.GUISoMoXCoreController;
import org.somox.ui.SoMoXUILogger;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.Workflow;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;

/**
 * The class is defined by the delegate attribute of a launchConfigurationType
 * extension and performs launching for a Model Extraction launch configuration.
 * 
 * @author Michael Hauck
 */
public class ModelExtractionConfigurationDelegate extends
			AbstractWorkflowBasedLaunchConfigurationDelegate<ModelExtractionConfiguration, Workflow> {

	protected IJob createWorkflowJob(
			final ModelExtractionConfiguration config, ILaunch launch)
			throws CoreException {
		IJob myJob = new IJob() {

			public void execute(IProgressMonitor monitor)
					throws JobFailedException, UserCanceledException {

				// check that the controller is available
				GUISoMoXCoreController controller = Activator.getDefault()
						.getGuiSoMoXCoreController();

				if (controller == null) {
					throw new JobFailedException("The SoMoX Core Controller can not be accessed. This indicates that the controller is not loaded yet. May be the SoMoX Core itself is not in place or not started yet.");
				}
				
				Preferences preferencesTemp = Activator.getDefault()
						.getPluginPreferences();
				Preferences preferences = new Preferences();
				String[] availableProperties = preferencesTemp
						.propertyNames();
				// Make a copy of the preferences to store run dialog
				// preferences as well
				for (int i = 0; i < availableProperties.length; i++) {
					preferences.setValue(availableProperties[i],
							preferencesTemp
									.getString(availableProperties[i]));
				}

				// Create project dir based on project name
				String projectDir = Platform.getInstanceLocation().getURL()
						.getFile();
				String projectName;
				try {
					projectName = config.getSomoxConfiguration().getAttribute(
							SoMoXProjectPreferences.SOMOX_PROJECT_NAME, "");
					if ((projectName == null) || projectName.equals("")) {
						throw new JobFailedException("No project specified. Extraction aborted.");
					}
					preferences.setValue(
							SoMoXProjectPreferences.SOMOX_PROJECT_NAME,
							projectDir + projectName);
					config.getSomoxConfiguration().getAttributes().remove(
							SoMoXProjectPreferences.SOMOX_PROJECT_NAME);
				} catch (CoreException e1) {
					throw new JobFailedException(e1);
				}

				IProject project = ResourcesPlugin.getWorkspace().getRoot()
						.getProject(projectName);
				IScopeContext projectContext = new ProjectScope(project);
				IEclipsePreferences node = projectContext
						.getNode("org.somox");

				try {
					String[] projectPropertyKeys = node.keys();
					if ((projectPropertyKeys == null)
							|| (projectPropertyKeys.length == 0)) {
						throw new JobFailedException("Failed to read project preferences. Specified project is probably not a SoMoX project.");
					} else {
						for (int i = 0; i < projectPropertyKeys.length; i++) {
							preferences.setValue(projectPropertyKeys[i],
									node.get(projectPropertyKeys[i], ""));
						}
					}

				} catch (BackingStoreException e) {
					throw new JobFailedException("Failed to get project preferences.  Extraction aborted.",
									e);

				}
				try {
					Set<Map.Entry<String, Object>> runConfigProperties = config.getSomoxConfiguration()
							.getAttributes().entrySet();
					Iterator<Map.Entry<String, Object>> i = runConfigProperties
							.iterator();
					while (i.hasNext()) {
						Map.Entry<String, Object> entry = i.next();
						System.err.println("PREF: " + entry.getKey() + ", "
								+ entry.getValue().toString());
						preferences.setValue(entry.getKey(), entry
								.getValue().toString());
					}
				} catch (CoreException e1) {
					throw new JobFailedException(e1);
				}

				controller.startExtraction(monitor, preferences);
			}

			public String getName() {
				return "SoMoX Extraction Job";
			}

			public void rollback(IProgressMonitor monitor)
					throws RollbackFailedException {
				// Not needed.
			}

		};
		return myJob;
	}

	protected ModelExtractionConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		return new ModelExtractionConfiguration(configuration);
	}

	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
		loggerList.add(setupLogger("org.somox", logLevel, logLevel.isGreaterOrEqual(Level.DEBUG) ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.fzi.sissy", logLevel, logLevel.isGreaterOrEqual(Level.DEBUG) ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		
		return loggerList;
	}

}

