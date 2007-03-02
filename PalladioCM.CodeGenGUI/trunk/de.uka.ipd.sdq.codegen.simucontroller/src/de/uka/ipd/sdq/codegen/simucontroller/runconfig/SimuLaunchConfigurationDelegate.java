/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.VMRunnerConfiguration;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.codegen.simucontroller.Activator;

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

		new WorkFlowLaunchConfigurationDelegate(getWorkflowFile(),
				createJavaProject(monitor).getProject()).launch(configuration,
				mode, launch, monitor);

		// Map<String, String> properties = new HashMap<String, String>();
		// Map slotContents = new HashMap();

		/*
		 * properties.put("aop_templates", "prototype_template_methods");
		 * properties.put(ResourceManagerTab.REPOSITORY_FILE, configuration
		 * .getAttribute(ResourceManagerTab.REPOSITORY_FILE, ""));
		 * properties.put(ResourceManagerTab.SYSTEM_FILE, configuration
		 * .getAttribute(ResourceManagerTab.SYSTEM_FILE, ""));
		 * properties.put(ResourceManagerTab.ALLOCATION_FILE, configuration
		 * .getAttribute(ResourceManagerTab.ALLOCATION_FILE, ""));
		 * properties.put(ResourceManagerTab.USAGE_FILE, configuration
		 * .getAttribute(ResourceManagerTab.USAGE_FILE, ""));
		 * properties.put(ResourceManagerTab.OUTPUT_PATH, configuration
		 * .getAttribute(ResourceManagerTab.OUTPUT_PATH, ""));
		 */

		// String workflowFile =
		// "D:/studienarbeit/workspace/de.uka.ipd.sdq.codegen.simucontroller/workflows/codegen_system.oaw";
		// new WorkflowRunner().run(workflowFile, new NullProgressMonitor(),
		// properties,
		// slotContents);
	}

	/**
	 * TODO
	 */
	public String getWorkflowFile() {
		Plugin plugin = Activator.getDefault();
		IPath path = new Path("workflows/codegen_system.oaw");

		// where plugin is of type org.eclipse.core.runtime.Plugin:
		URL url = FileLocator.find(plugin.getBundle(), path, null);

		if (url != null)
			try {
				url = FileLocator.resolve(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return url.getFile().replaceFirst("/", "");
	}

	/**
	 * @param progressMonitor
	 * @param workspace
	 * @param project
	 * @return
	 * @throws CoreException
	 */
	private IJavaProject createJavaProject(IProgressMonitor progressMonitor)
			throws CoreException {
		
		// TODO progressMonitor ?????

		String PROJECT_ID = "de.uka.ipd.sdq.codegen.simucominstance";

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(PROJECT_ID);
		IFolder folder = project.getFolder("src");

		IJavaProject javaProject;
		// progressMonitor.subTask("JET creating project " + project.getName());
		// //$NON-NLS-1$
		// project.create(new SubProgressMonitor(progressMonitor, 1));
		if (!project.exists())
			project.create(null);

		project.open(null);
		
		if (!folder.exists()) {
			folder.create(false, true, null);
		}

		// progressMonitor.subTask("_UI_JETCreatingProject_message");
		// //$NON-NLS-1$
		IProjectDescription description = workspace
				.newProjectDescription(project.getName());
		description.setNatureIds(new String[] { JavaCore.NATURE_ID });
		description.setLocation(null);
		// project.open(new SubProgressMonitor(progressMonitor, 1));

		// project.setDescription(description, new SubProgressMonitor(
		// progressMonitor, 1));
		project.setDescription(description, null);

		javaProject = JavaCore.create(project);
		return javaProject;
	}

}
