/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

import de.uka.ipd.sdq.codegen.simucontroller.SimuComJob;
import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;

/**
 * @author admin
 * 
 */
public class SimuLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	public static String REPOSITORY_FILE 	= "codegen_repository.oaw";
	public static String SYSTEM_FILE 		= "codegen_system.oaw";
	public static String USAGE_FILE 		= "codegen_usage.oaw";
	public static String TEMPLATE_METHODS 	= "simulation_template_methods";

	public static String[] workflowFiles = { REPOSITORY_FILE, SYSTEM_FILE,
			USAGE_FILE };

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		Map<String, String> properties = new HashMap<String, String>();
		Map<String, Object> slotContents = new HashMap<String, Object>();

		properties.put("aop_templates", TEMPLATE_METHODS);
		properties.put(ResourceManagerTab.REPOSITORY_FILE, configuration
				.getAttribute(ResourceManagerTab.REPOSITORY_FILE, ""));
		properties.put(ResourceManagerTab.SYSTEM_FILE, configuration
				.getAttribute(ResourceManagerTab.SYSTEM_FILE, ""));
		properties.put(ResourceManagerTab.ALLOCATION_FILE, configuration
				.getAttribute(ResourceManagerTab.ALLOCATION_FILE, ""));
		properties.put(ResourceManagerTab.USAGE_FILE, configuration
				.getAttribute(ResourceManagerTab.USAGE_FILE, ""));
		properties.put(ResourceManagerTab.OUTPUT_PATH, configuration
				.getAttribute(ResourceManagerTab.OUTPUT_PATH, ""));
		String workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getRawLocationURI().getPath();
		properties.put("workspace_loc", workspaceLocation);

		GeneratedPluginHandling pluginHandling = GeneratedPluginHandling.create(monitor);
		
		MessageConsole console = createConsole();
		MessageConsoleStream stream = console.newMessageStream();
		PrintStream outStream = System.out;
		System.setOut(new PrintStream(stream));
		System.out.println("Running oAW Generator");
		pluginHandling.setMonitorBeginTask("Simulation Run");
		try {
			pluginHandling.setMonitorSubTask("Generate Code");
			for (int i = 0; i < workflowFiles.length; i++)
				runWorkflowRunner(workflowFiles[i],
						properties, slotContents);
			pluginHandling.monitorWorked();
		} catch (CoreException e) {
			pluginHandling.setLogMessage("Codegen failed: ", e);
		} finally {
			System.setOut(outStream);
			removeConsole(console);
		}
		
		pluginHandling.simulate();
	}

	private void removeConsole(MessageConsole console) {
		ConsolePlugin.getDefault().getConsoleManager().removeConsoles(new IConsole[]{ console });
	}

	private static MessageConsole createConsole(){
		MessageConsole console = new MessageConsole(
				"SimuComController Generator Console", null);
		console.activate();
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] { console });
		return console;
	}

	/**
	 * 
	 * @param workflowFile
	 * @param properties
	 * @param slotContents
	 * @return
	 * @throws CoreException
	 * @throws JavaModelException
	 */
	public void runWorkflowRunner(String workflowFile,
			Map<String, String> properties, Map<String, Object> slotContents)
			throws CoreException, JavaModelException {
		
		WorkflowRunner runner = new WorkflowRunner();
		runner.run(workflowFile, new NullProgressMonitor(), properties,
				slotContents);
	}

	/**
	 * Refactoring TODO
	 */
	public String getWorkflowFile(String fileName) {
		Bundle pluginBundle = SimuControllerPlugin.getDefault().getBundle();

		// where plugin is of type org.eclipse.core.runtime.Plugin:
		URL url = FileLocator.find(pluginBundle, new Path(fileName), null);

		if (url != null)
			try {
				url = FileLocator.resolve(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return url.getFile().replaceFirst("/", "");
	}
}
