package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.IViewDescriptor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.ServiceTracker;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusModel;
import de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewPart;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockServiceImpl;

/**
 * Installs a Plug-In from the specified location string with use a bundeles
 * context.The context is used to grant access to other methods so that this
 * bundle can interact with the Framework.
 */
public class TransferSimulationBundleToDock implements IJob {

	private CreatePluginProjectJob myCreatePluginProjectJob;
	private SimuComConfig myConfig;
	private DockStatusModel dockViewModel;

	public TransferSimulationBundleToDock(
			CreatePluginProjectJob createPluginProjectJob,
			SimuComConfig simuConfig) {
		myCreatePluginProjectJob = createPluginProjectJob;
		myConfig = simuConfig;
	}

	public void execute() throws JobFailedException {
		assert (myCreatePluginProjectJob != null);

		IProject project = myCreatePluginProjectJob.getProject();
		assert (project != null);

		String location = null;
		try {
			location = new File(project.getLocationURI()).getAbsolutePath()
					+ File.separator + "simucominstance.jar";
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
		showSimuDockView();
		SimuControllerPlugin.getDockModel().getBestFreeDock().getService().simulate(myConfig,
				loadBundle(location));
	}

	private void showSimuDockView() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable(){

			public void run() {
				IViewPart viewer;
				try {
					viewer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(DockStatusViewPart.ID);
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(viewer);
					viewer.setFocus();
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	}

	private byte[] loadBundle(String location) {
		byte[] result = null;
		try {
			File bundleFile = new File(location);
			result = new byte[(int) bundleFile.length()];
			FileInputStream fis = new FileInputStream(bundleFile);
			fis.read(result);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getName() {
		return "Transfer Plugin to Dock and Simulate";
	}

	public void rollback() throws RollbackFailedException {
	}
}
