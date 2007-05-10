package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import de.uka.ipd.sdq.codegen.simucontroller.SimuComJob;
import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.actions.ISimuComControl;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;

class CreatePluginProjectJob implements ISimulationJob {

	private IProject myProject;

	public CreatePluginProjectJob() {
		myProject = null;
	}

	public IProject getProject() {
		return myProject;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#execute()
	 */
	public void execute() throws Exception {
		try {
			myProject = PluginProject.createInstance().createContainerPlugin(new NullProgressMonitor());		
		} catch (CoreException e) {
			throw new Exception("Creating plugin project failed",e);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#getName()
	 */
	public String getName() {
		return "Create Plugin Project";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.ISimuComJob#rollback()
	 */
	public void rollback() throws Exception {
		if (myProject == null) {
			return;
		}
		try {
			myProject.close(new NullProgressMonitor());
		} catch (CoreException e) {
			throw new Exception("Closing plugin project failed", e);
		}

		try {
			myProject.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new Exception("Deleting plugin project failed", e);
		}
	}
}

/**
 * Start the Workflow-Engine of oAW - Generator
 * 
 */
class GeneratePluginCodeJob implements ISimulationJob {

	private final static String REPOSITORY_FILE 	= "codegen_repository.oaw";
	private final static String SYSTEM_FILE 		= "codegen_system.oaw";
	private final static String USAGE_FILE 		= "codegen_usage.oaw";
	private final static String TEMPLATE_METHODS 	= "simulation_template_methods";

	private final String[] myWorkflowFiles = { REPOSITORY_FILE, SYSTEM_FILE,
			USAGE_FILE };

	private ILaunchConfiguration myConfiguration;

	public GeneratePluginCodeJob(ILaunchConfiguration configuration) {
		myConfiguration = configuration;
	}

	public void execute() throws Exception {
		assert (myConfiguration != null);

		Map<String, String> properties = new HashMap<String, String>();
		Map<String, Object> slotContents = new HashMap<String, Object>();

		String workspaceLocation = null;

		try {
			workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getRawLocationURI().getPath();
		} catch (Exception e) {
			throw new Exception("Getting workspace location failed", e);
		}

		try {
			properties.put("aop_templates", TEMPLATE_METHODS);
			properties.put("workspace_loc", workspaceLocation);

			properties.put(ResourceManagerTab.REPOSITORY_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.REPOSITORY_FILE, ""));
			properties.put(ResourceManagerTab.SYSTEM_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.SYSTEM_FILE, ""));
			properties.put(ResourceManagerTab.ALLOCATION_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.ALLOCATION_FILE, ""));
			properties.put(ResourceManagerTab.USAGE_FILE, myConfiguration
					.getAttribute(ResourceManagerTab.USAGE_FILE, ""));
			properties.put(ResourceManagerTab.OUTPUT_PATH, myConfiguration
					.getAttribute(ResourceManagerTab.OUTPUT_PATH, ""));

		} catch (Exception e) {
			throw new Exception("Setting up properties failed", e);
		}			

		for (String workflowFile: myWorkflowFiles) {
			try {
				WorkflowRunner runner = new WorkflowRunner();
				if (!runner.run(workflowFile, 
						new org.openarchitectureware.workflow.monitor.NullProgressMonitor(),
						properties,
						slotContents)) {
					throw new Exception("oAW workflow returned false: " + workflowFile);
				}
			} catch (Exception e) {
				throw new Exception("Running oAW workflow failed: " + workflowFile, e);
			}
		}
	}

	public String getName() {
		return "Generate Plugin Code";
	}

	public void rollback() throws Exception {
	}
}

class CompilePluginCodeJob implements ISimulationJob {

	private CreatePluginProjectJob myCreatePluginProjectJob;

	public CompilePluginCodeJob(CreatePluginProjectJob createPluginProjectJob) {
		myCreatePluginProjectJob = createPluginProjectJob;
	}

	public void execute() throws Exception {
		assert (myCreatePluginProjectJob != null);

		IProject project = myCreatePluginProjectJob.getProject();
		assert (project != null);

		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		} catch (Exception e) {
			throw new Exception("Refreshing plugin project failed", e);
		}

		try {
			project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		} catch (Exception e) {
			throw new Exception("Building plugin project failed", e);
		}
		if (project.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length > 0){
			boolean failed = false;
			IMarker[] markers = project.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			String errorList = "";
			for (IMarker marker:markers) {
				if (((Integer)marker.getAttribute(IMarker.SEVERITY)) == IMarker.SEVERITY_ERROR) {
					errorList += marker.getAttribute(IMarker.MESSAGE) + "\n";
					failed = true;
				}
			}
			if (failed)
				throw new Exception("Unable to build the simulation plugin. Failure Messages: "+errorList);
		}
	}

	public String getName() {
		return "Compile Plugin Code";
	}

	public void rollback() throws Exception {
	}
}

/**
 * Installs a Plug-In from the specified location string with use a bundeles
 * context.The context is used to grant access to other methods so that this
 * bundle can interact with the Framework.
 */
class LoadPluginJob implements ISimulationJob {

	private CreatePluginProjectJob myCreatePluginProjectJob;
	private Bundle myBundle;

	public LoadPluginJob(CreatePluginProjectJob createPluginProjectJob) {
		myCreatePluginProjectJob = createPluginProjectJob;
	}

	public void execute() throws Exception {
		assert (myCreatePluginProjectJob != null);

		IProject project = myCreatePluginProjectJob.getProject();
		assert (project != null);

		String location = null;
		try {
			// location The location identifier of the bundle to install.
			location = project.getLocationURI().toString();
			location = location.replaceAll("%20", " "); // Workaround a bug in OSGi
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=184620

		} catch (Exception e) {
			throw new Exception("Getting project location failed",e);
		}

		BundleContext bundleContext = null;
		try {
			bundleContext = SimuControllerPlugin.getDefault()
			.getBundle().getBundleContext();

		} catch (Exception e) {
			throw new Exception("Getting bundle context failed",e);
		}

		try {
			myBundle = bundleContext.installBundle(location);
			myBundle.start();
			myBundle.update();
		} catch (Exception e) {
			throw new Exception("Loading of generated plugin failed", e);
		}
	}

	public String getName() {
		return "Load Plugin";
	}

	public void rollback() throws Exception {
		if (myBundle == null) {
			return;
		}

		try {
			myBundle.stop();
			myBundle.uninstall();
		} catch (BundleException e) {
			throw new Exception("Unloading bundle failed", e);
		}
	}
}

class SimulateJob implements ISimulationJob {

	/**
	 * PID 	- Plug-In ID
	 */
	private static final String PID = "de.uka.ipd.sdq.codegen.simucontroller";

	/**
	 * EPID - Extension Point ID
	 */
	private static final String EPID = "controller";

	private long maxSimulationTime;

	public SimulateJob(long maxSimulationTime) {
		this.maxSimulationTime = maxSimulationTime;
	}

	public void execute() throws Exception {
		ISimuComControl control = null;

		try {
			for (IConfigurationElement configurationElement : Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							PID + "." + EPID)) {
				control = (ISimuComControl) configurationElement
				.createExecutableExtension("class");
				if (control != null) {
					//successful
					break;
				}
			}		
		} catch (Exception e) {
			throw new Exception("Locating simulation plugin failed",e);
		}

		SimuComJob job = new SimuComJob(control, maxSimulationTime, null);
		try {
			job.setUser(true);
			job.schedule();			
			job.join();
		} catch (Exception e) {
			throw new Exception("Simulation failed ", e);
		}
		if (job.getStatus() == SimuComStatus.ERROR)
			throw new Exception(job.getErrorMessage());
	}

	public String getName() {
		return "Simulate";
	}

	public void rollback() throws Exception {
	}
}
