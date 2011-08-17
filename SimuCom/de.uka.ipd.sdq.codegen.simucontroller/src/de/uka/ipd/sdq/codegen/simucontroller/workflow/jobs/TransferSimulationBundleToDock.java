package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationWorkflowConfiguration;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;

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
	private AbstractSimulationWorkflowConfiguration myConfig;

	private boolean isDebug;

	private IDebugListener debugListener;

	public TransferSimulationBundleToDock(
			AbstractSimulationWorkflowConfiguration configuration,
			IDebugListener debugListener,
			IJobWithResult<byte[]> createPluginJarJob) {
		super();
		
		this.myCreatePluginProjectJob = createPluginJarJob;
		this.myConfig = configuration;
		this.debugListener = debugListener;
		this.isDebug = configuration.isDebug();
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException {
		assert (myCreatePluginProjectJob != null);

		try {
			DockModel dock = SimuControllerPlugin.getDockModel().getBestFreeDock();
			SimulationDockService simService = dock.getService();
			if (isDebug) {
				debugListener.simulationStartsInDock(dock);
			}
			simService.simulate(
					myConfig.getSimulationConfiguration(),
					myCreatePluginProjectJob.getResult(),
					dock.isRemote());
		} catch (InterruptedException e) {
			throw new JobFailedException("Job failed while waiting for a dock to become available",e);
		}
		catch (Exception e) {
			throw new JobFailedException("Simulation run failed.",e);
		}
		finally {
			if (isDebug) {
				this.debugListener.simulationStoppedInDock();
			}
		}
	}

	public String getName() {
		return "Transfer Plugin to Dock and Simulate";
	}

	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
	}
}
