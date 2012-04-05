package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationWorkflowConfiguration;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockServiceImpl;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtendableJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Installs a Plug-In from the specified location string with use a bundles
 * context.The context is used to grant access to other methods so that this
 * bundle can interact with the Framework.
 */
public class TransferSimulationBundleToDock extends AbstractExtendableJob<MDSDBlackboard> {

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
		
        // FIXME: this class should not be specific to a simulator implementation (like SimuCom or
        // EventSim), but the workflow hooks currently have no means to refer to the simulator
        // implementation to which a given extension applies. The hooks rather assume that SimuCom
        // is used, which causes other implementations to fail. Therefore, as a workaround we have
        // to check for SimuCom here.
        if (isSimuComSimulationRun()) {
            handleJobExtensions(WorkflowHooks.WORKFLOW_ID_AFTER_DOCK, configuration);
        }
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		
		
		assert (myCreatePluginProjectJob != null);

		try {
			DockModel dock = SimuControllerPlugin.getDockModel().getBestFreeDock();
			SimulationDockService simService = dock.getService();
			if (isDebug) {
				debugListener.simulationStartsInDock(dock);
			}
			simService.load(
					myConfig.getSimulationConfiguration(),
					myCreatePluginProjectJob.getResult(),
					dock.isRemote());
			
			// Execute extension jobs first
			// TODO: don't call this here. Put TransferSimulationBundleToDock job logic into a separate job that is nested in a OrderPreservingCompositeJob
			// together with the extension jobs
			for (IJob extensionJob : myJobs) {
				if (isSimuComSimulationRun() && extensionJob instanceof AbstractSimuComExtensionJob) {
					((AbstractSimuComExtensionJob)extensionJob).setSimuComModel(((SimulationDockServiceImpl)simService).getSimuComModel());
					((AbstractSimuComExtensionJob)extensionJob).initialize(myConfig);
				}
			}
			super.execute(monitor);
			
			
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
	
	private boolean isSimuComSimulationRun() {
	    return myConfig.getSimulationConfiguration().getSimulatorId().equals("de.uka.ipd.sdq.codegen.simucontroller.simucom");
	}

	public String getName() {
		return "Transfer Plugin to Dock and Simulate";
	}

}
