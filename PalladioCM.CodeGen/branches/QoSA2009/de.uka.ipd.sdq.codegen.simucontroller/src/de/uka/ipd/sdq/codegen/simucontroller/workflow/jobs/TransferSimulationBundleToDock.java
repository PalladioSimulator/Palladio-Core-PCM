package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugTarget;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.gui.DockStatusViewPart;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.IJobWithResult;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComResult;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

/**
 * Installs a Plug-In from the specified location string with use a bundeles
 * context.The context is used to grant access to other methods so that this
 * bundle can interact with the Framework.
 */
public class TransferSimulationBundleToDock implements IJob {

	/**
	 * This job's parent job which creates a JAR archive of the simulation bundle 
	 */
	private IJobWithResult<byte[]> myCreatePluginProjectJob;
	
	/**
	 * Configuration object for the simulation 
	 */
	private SimuComConfig myConfig;

	private ILaunch launch;

	private boolean isDebug;

	public TransferSimulationBundleToDock(
			IJobWithResult<byte[]> createPluginJarJob,
			SimuComConfig simuConfig, ILaunch launch) {
		myCreatePluginProjectJob = createPluginJarJob;
		myConfig = simuConfig;
		this.launch = launch;
		this.isDebug = simuConfig.isDebug();
	}

	public void execute() throws JobFailedException {
		SimulationDebugTarget target = null;
		assert (myCreatePluginProjectJob != null);

		showSimuDockView();
		try {
			DockModel dock = SimuControllerPlugin.getDockModel().getBestFreeDock();
			SimulationDockService simService = dock.getService();
			if (isDebug) {
				target  = new SimulationDebugTarget(launch,dock);
				launch.addDebugTarget(target);
			}
			simService.simulate(
					myConfig,
					myCreatePluginProjectJob.getResult(),
					dock.isRemote());
		} catch (InterruptedException e) {
			throw new JobFailedException("Job failed while waiting for a dock to become available",e);
		}
		catch (Exception e) {
			throw new JobFailedException("Job failed.",e);
		}
		finally {
			if (isDebug) {
				if (target != null) {
					// Wait for termination, needed as termination is reported via async events by the dock
					while (!target.isTerminated()) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
						}
					}
					target.dispose();
					launch.removeDebugTarget(target);
				}
			}
		}
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

	public String getName() {
		return "Transfer Plugin to Dock and Simulate";
	}

	public void rollback() throws RollbackFailedException {
	}
}
