/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.awt.Component;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.framework.internal.core.Framework;
import org.eclipse.osgi.service.resolver.PlatformAdmin;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;
import org.openarchitectureware.workflow.util.ResourceLoaderFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import com.sun.jndi.toolkit.ctx.ComponentContext;

import de.uka.ipd.sdq.codegen.simucontroller.SimuComJob;
import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.actions.ISimuComControl;

/**
 * @author admin
 * 
 */
public class SimuLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	private static final String PID = "de.uka.ipd.sdq.codegen.simucontroller";
	private static final String EPID = "controller";

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
		boolean status = false;
		
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

		IProject project = null;
		MessageConsole console = new MessageConsole("SimuComController Generator Console", null);
		console.activate();
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ console });
		MessageConsoleStream stream = console.newMessageStream();
		PrintStream outStream = System.out;
		System.setOut(new PrintStream(stream));
		System.out.println("Running oAW Generator");
		monitor.beginTask("Simulation Run", 5);
		try {
			monitor.subTask("Create Plugin");
			project = createPluginProject(monitor);
			monitor.worked(1);

			monitor.subTask("Generate Code");
			for (int i = 0; i < workflowFiles.length; i++)
				status = runWorkflowRunner(workflowFiles[i],
						properties, slotContents);
			monitor.worked(1);
		} catch (CoreException e) {
			SimuControllerPlugin.log(IStatus.ERROR, "Codegen failed: "+e.getMessage());
		} finally {
			System.setOut(outStream);
			ConsolePlugin.getDefault().getConsoleManager().removeConsoles(new IConsole[]{ console });
		}
		monitor.subTask("Compile Code");
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
		monitor.worked(1);
		
		monitor.subTask("Load Generated Plugin");
		Bundle plugin = loadGeneratedPlugin(project);
		monitor.worked(1);
		
		monitor.subTask("Simulate");
		SimuComJob job = new SimuComJob(findPlugin(),null);
		job.setUser(true);
		job.schedule();
		try {
			job.join();
		} catch (InterruptedException e) {
			SimuControllerPlugin.log(IStatus.ERROR, "Simulation: "+e.getMessage());
		}
		
		monitor.subTask("Cleanup");
		try {
			plugin.stop();
			plugin.uninstall();
		} catch (BundleException e) {
			SimuControllerPlugin.log(IStatus.ERROR, "Unload Bundle: "+e.getMessage());
		}
		project.close(monitor);
		project.delete(true, monitor);
		monitor.worked(1);
		monitor.done();
	}

	public ISimuComControl findPlugin(){
		
		ISimuComControl control = null;
		
		for(IConfigurationElement configurationElement : Platform.getExtensionRegistry().
				getConfigurationElementsFor(PID+"."+EPID)){
				try {
					control = (ISimuComControl) configurationElement
							.createExecutableExtension("class");
				} catch (CoreException e) {
					SimuControllerPlugin.log(IStatus.ERROR, 
							"No simulation plugin found: "+e.getMessage());
				}
		}
		return control;
	}
	
	/**
	 * TODO
	 * @throws CoreException 
	 */
	private IProject createPluginProject(IProgressMonitor monitor) throws CoreException{
		return new CreatePluginProject(monitor).getProject();
	}

	/**
	 * TODO
	 * @param project
	 */
	private Bundle loadGeneratedPlugin(IProject project) {
		String location = project.getLocationURI().toString();
		location = location.replaceAll("%20", " "); // Workaround a bug in OSGi
					// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=184620
		
		BundleContext bundleContext = SimuControllerPlugin.getDefault()
				.getBundle().getBundleContext();
		Bundle bundle = null;
		
		try {
			bundle = bundleContext.installBundle(location);
			bundle.start();
			bundle.update();
		} catch (BundleException e) {
			SimuControllerPlugin.log(IStatus.ERROR, "Loading of generated plugin failed: "+e.getMessage());
		}
		return bundle;
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
	public boolean runWorkflowRunner(String workflowFile,
			Map<String, String> properties, Map<String, Object> slotContents)
			throws CoreException, JavaModelException {
		boolean status = false;
		
		WorkflowRunner runner = new WorkflowRunner();
		status = runner.run(workflowFile, new NullProgressMonitor(), properties,
				slotContents);
		
		if (status){
			// TODO loging mit Log4j;
		}
		return status;
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
