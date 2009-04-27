package org.somox.analyzer.simplemodelanalyzer.ui;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.somox.analyzer.simplemodelanalyzer.Activator;
import org.somox.analyzer.simplemodelanalyzer.SimpleModelAnalyzer;
import org.somox.core.SoMoXCoreLogger;
import org.somox.ui.GUISoMoXCoreController;
import org.somox.ui.runconfig.ModelAnalyzerConfiguration;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.Workflow;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;

/**
 * The class is defined by the delegate attribute of a launchConfigurationType
 * extension and performs launching for a Model Analyzer launch configuration.
 * 
 * @author Michael Hauck
 */
public class SimpleModelAnalyzerConfigurationDelegate
		extends
		AbstractWorkflowBasedLaunchConfigurationDelegate<ModelAnalyzerConfiguration, Workflow> {

	protected IJob createWorkflowJob(final ModelAnalyzerConfiguration config,
			ILaunch launch) throws CoreException {
		IJob myJob = new IJob() {

			public void execute(IProgressMonitor monitor)
					throws JobFailedException, UserCanceledException {

				GUISoMoXCoreController controller = org.somox.ui.Activator
						.getDefault().getGuiSoMoXCoreController();

				if (controller == null) {
					throw new JobFailedException(
							"The SoMoX Core Controller can not be accessed. This indicates that the controller is not loaded yet. May be the SoMoX Core itself is not in place or not started yet.");
				}

				Preferences preferencesTemp = Activator.getDefault()
						.getPluginPreferences();
				final Preferences preferences = new Preferences();
				final IProgressMonitor progressMonitor = monitor;
				String[] availableProperties = preferencesTemp.propertyNames();
				// Make a copy of the preferences to store run dialog
				// preferences as well
				for (int i = 0; i < availableProperties.length; i++) {
					preferences.setValue(availableProperties[i],
							preferencesTemp.getString(availableProperties[i]));
				}
				try {
					Set<Map.Entry<String, Object>> runConfigProperties = config
							.getSomoxConfiguration().getAttributes().entrySet();
					Iterator<Map.Entry<String, Object>> i = runConfigProperties
							.iterator();
					while (i.hasNext()) {
						Map.Entry<String, Object> entry = i.next();
						preferences.setValue(entry.getKey(), entry.getValue()
								.toString());
					}
				} catch (CoreException e1) {
					throw new JobFailedException(e1);
				}
				if (controller == null) {
					SoMoXCoreLogger.logError(
							"SoMoX Core Controller not loaded", null);
					return;
				}

				controller.startAnalyze(SimpleModelAnalyzer.class.getName(),
						progressMonitor, preferences);

			}

			public String getName() {
				return "SoMoX Analyzer Job";
			}

			public void rollback(IProgressMonitor monitor)
					throws RollbackFailedException {
				// Not needed.
			}

		};

		return myJob;

	}

	protected ModelAnalyzerConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		return new ModelAnalyzerConfiguration(configuration);
	}

	@Override
	protected void setupLogging(Level logLevel) throws CoreException {
		super.setupLogging(logLevel);
		setupLogger("org.somox", logLevel, logLevel
				.isGreaterOrEqual(Level.DEBUG) ? DETAILED_LOG_PATTERN
				: SHORT_LOG_PATTERN);
	}

}
