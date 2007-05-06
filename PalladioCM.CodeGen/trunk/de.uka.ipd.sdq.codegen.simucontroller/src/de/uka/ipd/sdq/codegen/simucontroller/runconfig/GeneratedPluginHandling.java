package de.uka.ipd.sdq.codegen.simucontroller.runconfig;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import de.uka.ipd.sdq.codegen.simucontroller.SimuComJob;
import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.actions.ISimuComControl;

/**
 * @author roman
 * 
 * Class defines all operations, which one needs for a complete
 * simulation execution.
 */
public class GeneratedPluginHandling {
	
	/**
	 * PID 	- Plug-In ID
	 * EPID - Extension Point ID
	 */
	private static final String PID = "de.uka.ipd.sdq.codegen.simucontroller";
	private static final String EPID = "controller";

	private IProgressMonitor monitor = null;
	private IProject project = null;
	private Bundle bundle = null;
	
	
	/* (non-Javadoc) Create s Container - Plugi-In project
	 * @See de.uka.ipd.sdq.codegen.simucontroller.runconfig.PluginProject
	 */
	private GeneratedPluginHandling(IProgressMonitor monitor){
		this.monitor = monitor;
		try {
			setMonitorSubTask("Create Plugin");
			project = PluginProject.createInstance().createContainerPlugin(monitor);
			monitorWorked();
		} catch (CoreException e) {
			setLogMessage("Create container project failed: ", e);
		}
	}
	
	/**
	 * Constructor with Factory Method - pattern
	 */
	public static GeneratedPluginHandling createContainerPlugin(IProgressMonitor monitor) {
		return new GeneratedPluginHandling(monitor);
	}
	
	public void simulate(){
		setMonitorSubTask("Simulate");
		SimuComJob job = new SimuComJob(findPlugin(),null);
		job.setUser(true);
		job.schedule();
		try {
			job.join();
		} catch (InterruptedException e) {
			setLogMessage("Simulation: ", e);
		}
	}

	/**
	 * The function scans all Extensions of Extension Point EPID. Afterwards for
	 * it responsible Klass is caste on the control class.
	 * 
	 * @return - instance of the control class, that is responsible for the
	 *         control of simulation.
	 */
	public ISimuComControl findPlugin() {
		ISimuComControl control = null;

		for (IConfigurationElement configurationElement : Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						PID + "." + EPID)) {
			try {
				control = (ISimuComControl) configurationElement
						.createExecutableExtension("class");
			} catch (CoreException e) {
				SimuControllerPlugin.log(IStatus.ERROR,
						"No simulation plugin found: " + e.getMessage());
			}
		}
		return control;
	}

	/**
	 * Installs a Plug-In from the specified location string with use a bundeles
	 * context.The context is used to grant access to other methods so that this
	 * bundle can interact with the Framework.
	 */
	public Bundle loadPlugin() {
		// location The location identifier of the bundle to install.
		String location = project.getLocationURI().toString();
		location = location.replaceAll("%20", " "); // Workaround a bug in OSGi
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=184620

		BundleContext bundleContext = SimuControllerPlugin.getDefault()
				.getBundle().getBundleContext();

		try {
			setMonitorSubTask("Load Generated Plugin");
			bundle = bundleContext.installBundle(location);
			bundle.start();
			bundle.update();
			monitorWorked();
		} catch (BundleException e) {
			setLogMessage("Loading of generated plugin failed: ", e);
		}
		return bundle;
	}

	/**
	 * Unload and delete the Plug-In project
	 */
	public void unloadPlugin() {
		setMonitorSubTask("Unload");
		try {
			bundle.stop();
			bundle.uninstall();
		} catch (BundleException e) {
			setLogMessage("Unload Bundle: ", e);
		}
		monitorWorked();
		deletePlugin();
	}

	public void deletePlugin() {
		setMonitorSubTask("Cleanup");
		try {
			project.close(monitor);
			project.delete(IResource.ALWAYS_DELETE_PROJECT_CONTENT, monitor);
		} catch (CoreException e) {
			setLogMessage("Delete project failed: ", e);
		}
		monitorWorked();
		monitoreDone();
	}
	
	/** 
	 * Builds the project.
	 */
	public void compileCode() {
		setMonitorSubTask("Compile Code");
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
		} catch (CoreException e) {
			setLogMessage("Comaling of generated plugin failed: ", e);
		}
		monitorWorked();
	}
	
	public void setLogMessage(String msg, Exception e) {
		SimuControllerPlugin.log(IStatus.ERROR, msg + e.getMessage());
	}
	
	
	public void monitoreDone(){
		monitor.done();
	}
	
	public void setMonitorSubTask(String task){
		monitor.subTask(task);
	}
	
	public void setMonitorBeginTask(String task){
		int work = 5;
		monitor.beginTask(task, work);
	}
	
	public void monitorWorked(){
		int work = 1;
		monitor.worked(work);
	}
	
	public IProject getProject() {
		return project;
	}
}
