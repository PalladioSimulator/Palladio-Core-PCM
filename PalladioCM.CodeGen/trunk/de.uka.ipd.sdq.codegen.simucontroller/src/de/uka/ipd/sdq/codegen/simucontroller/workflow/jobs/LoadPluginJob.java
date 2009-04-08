package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.resources.IProject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.RollbackFailedException;

/**
 * Installs a Plug-In from the specified location string with use a bundeles
 * context.The context is used to grant access to other methods so that this
 * bundle can interact with the Framework.
 */
public class LoadPluginJob implements IJob {

	private CreatePluginProjectJob myCreatePluginProjectJob;
	private Bundle myBundle;

	public LoadPluginJob(CreatePluginProjectJob createPluginProjectJob) {
		myCreatePluginProjectJob = createPluginProjectJob;
	}

	public void execute() throws JobFailedException {
		assert (myCreatePluginProjectJob != null);

		IProject project = myCreatePluginProjectJob.getProject();
		assert (project != null);

		String location = null;
		try {
			// location The location identifier of the bundle to install.
			location = project.getLocationURI().toString();
			location = location.replaceAll("%20", " "); // Workaround a bug in
														// OSGi
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=184620

		} catch (Exception e) {
			throw new JobFailedException("Getting project location failed", e);
		}

		BundleContext bundleContext = null;
		try {
			bundleContext = SimuControllerPlugin.getDefault().getBundle()
					.getBundleContext();

		} catch (Exception e) {
			throw new JobFailedException("Getting bundle context failed", e);
		}

		try {
			myBundle = bundleContext.installBundle(location);
			myBundle.start();
			myBundle.update();
		} catch (Exception e) {
			throw new JobFailedException("Loading of generated plugin failed", e);
		}
	}

	public String getName() {
		return "Load Plugin";
	}

	public void rollback() throws RollbackFailedException {
		if (myBundle == null) {
			return;
		}

		try {
			myBundle.stop();
			myBundle.uninstall();
		} catch (BundleException e) {
			throw new RollbackFailedException("Unloading bundle failed", e);
		}
	}
}
