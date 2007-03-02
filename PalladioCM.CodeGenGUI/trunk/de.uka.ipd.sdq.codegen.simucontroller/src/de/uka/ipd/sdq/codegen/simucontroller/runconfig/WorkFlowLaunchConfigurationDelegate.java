/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @author admin
 * 
 */
public class WorkFlowLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	private static final String WORKFLOW_LAUNCH_CONFIGURATION_TYPE_ID = "org.openarchitectureware.workflow.workflowLaunchConfigurationType";
	private static final String OAW_CONFIGURATION_NAME_PREFIX = "oAW Workflow Runner";
	private static final String WORKFLOW_RUNNER = "org.openarchitectureware.workflow.WorkflowRunner";

	private String worflowFile;

	private IProject project;

	/**
	 * @param worflowFile
	 * @param projectName
	 */
	public WorkFlowLaunchConfigurationDelegate(String worflowFile,
			IProject project) {
		this.worflowFile = worflowFile;
		this.project = project;
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
		// TODO Auto-generated method stub

		ILaunchConfiguration config = findLaunchConfiguration(getConfigurationType());

		if (config == null || !config.exists()) {
			config = createConfiguration();
			try {
				final ILaunchConfiguration[] configs = DebugPlugin.getDefault()
						.getLaunchManager().getLaunchConfigurations();
				for (int i = 0; i < configs.length; i++) {
					final ILaunchConfiguration myConfiguration = configs[i];
					if (equals(myConfiguration, config)) {
						config = myConfiguration;
						break;
					}
				}
			} catch (final CoreException e) {
				e.printStackTrace();
			}
		}
		DebugUITools.launch(config, mode);
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			reportError(e.toString());
		}
	}

	/**
	 * Create & return a new configuration based on the specified
	 * <code>IType</code>.
	 */
	protected ILaunchConfiguration createConfiguration() {

		ILaunchConfiguration config = null;
		ILaunchConfigurationWorkingCopy wc = null;
		try {
			final ILaunchConfigurationType configType = DebugPlugin
					.getDefault().getLaunchManager()
					.getLaunchConfigurationType(
							WORKFLOW_LAUNCH_CONFIGURATION_TYPE_ID);// IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION);
			wc = configType.newInstance(null, DebugPlugin.getDefault()
					.getLaunchManager()
					.generateUniqueLaunchConfigurationNameFrom(
							OAW_CONFIGURATION_NAME_PREFIX));// type.getElementName()));
		} catch (final CoreException exception) {
			reportCreatingConfiguration(exception);
			return null;
		}
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME,
				WORKFLOW_RUNNER);
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME,
				project.getName());
		// add the workflow file
		wc.setAttribute(
				IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, "\""
						+ worflowFile + "\"");
		wc.setAttribute(IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION,
				"workflow - " + worflowFile);

		try {
			config = wc.doSave();
		} catch (final CoreException exception) {
			reportCreatingConfiguration(exception);
		}

		return config;
	}

	protected void reportCreatingConfiguration(final CoreException exception) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				org.eclipse.jface.dialogs.ErrorDialog.openError(new Shell(),
						"Error creating launch configuration",
						(exception != null ? exception.getMessage() : "Error"),
						exception.getStatus());
			}
		});
	}

	public class TypeDeclarationSearchRequestor extends SearchRequestor {

		private IType match = null;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jdt.core.search.SearchRequestor#acceptSearchMatch(org.eclipse.jdt.core.search.SearchMatch)
		 */
		@Override
		public void acceptSearchMatch(final SearchMatch match)
				throws CoreException {
			this.match = (IType) match.getElement();
		}

		public IType getMatch() {
			return match;
		}
	}

	protected ILaunchConfigurationType getConfigurationType() {
		return DebugPlugin.getDefault().getLaunchManager()
				.getLaunchConfigurationType(
						IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION);
	}

	
	// TODO funktioniert ??????
	protected ILaunchConfiguration findLaunchConfiguration(
			ILaunchConfigurationType configType) {
		List candidateConfigs = Collections.EMPTY_LIST;
		try {
			ILaunchConfiguration[] configs = DebugPlugin.getDefault()
					.getLaunchManager().getLaunchConfigurations(configType);
			candidateConfigs = new ArrayList(configs.length);
			for (int i = 0; i < configs.length; i++) {
				ILaunchConfiguration config = configs[i];
				if (config.getAttribute(
						IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME,
						"").equals(WORKFLOW_RUNNER)) { //$NON-NLS-1$
					if (config
							.getAttribute(
									IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME,
									"").equals(project.getName())) { //$NON-NLS-1$
						candidateConfigs.add(config);
					}
				}
			}
		} catch (CoreException e) {
			// TODO
		}

		// If there are no existing configs associated with the IType, create
		// one.
		// If there is exactly one config associated with the IType, return it.
		// Otherwise, if there is more than one config associated with the
		// IType, prompt the
		// user to choose one.
		int candidateCount = candidateConfigs.size();
		if (candidateCount < 1) {
			return createConfiguration();
		} else if (candidateCount == 1) {
			return (ILaunchConfiguration) candidateConfigs.get(0);
		} else {
			// Prompt the user to choose a config. A null result means the user
			// cancelled the dialog, in which case this method returns null,
			// since cancelling the dialog should also cancel launching
			// anything.
			ILaunchConfiguration config = chooseConfiguration(candidateConfigs);
			if (config != null) {
				return config;
			}
		}

		return null;
	}

	private boolean equals(final ILaunchConfiguration a,
			final ILaunchConfiguration b) throws CoreException {
		String mainTypeName = IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME;
		String projectName = IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME;
		String programArguments = IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS;
		return a.getAttribute(mainTypeName, "X").equals(
				b.getAttribute(mainTypeName, "Y"))
				&& a.getAttribute(projectName, "X").equals(
						b.getAttribute(projectName, "Y"))
				&& a.getAttribute(programArguments, "X").equals(
						b.getAttribute(programArguments, "Y"));
	}

	protected void reportError(final String msg) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(new Shell(), "Error", msg);
			}
		});
	}

	protected ILaunchConfiguration chooseConfiguration(List configList) {
		IDebugModelPresentation labelProvider = DebugUITools
				.newDebugModelPresentation();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				new Shell(), labelProvider);
		dialog.setElements(configList.toArray());
		dialog.setTitle("Select oAW Workflow");
		dialog.setMessage("&Select existing configuration");
		dialog.setMultipleSelection(false);
		int result = dialog.open();
		labelProvider.dispose();
		if (result == Window.OK) {
			return (ILaunchConfiguration) dialog.getFirstResult();
		}
		return null;
	}
}
