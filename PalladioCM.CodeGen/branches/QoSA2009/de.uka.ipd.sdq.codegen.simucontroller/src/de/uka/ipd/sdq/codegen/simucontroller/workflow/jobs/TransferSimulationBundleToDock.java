package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
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
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;
import de.uka.ipd.sdq.simucomframework.usage.ClosedWorkloadUser;
import de.uka.ipd.sdq.simucomframework.usage.OpenWorkloadUser;

/**
 * Installs a Plug-In from the specified location string with use a bundeles
 * context.The context is used to grant access to other methods so that this
 * bundle can interact with the Framework.
 */
public class TransferSimulationBundleToDock implements IJob {

	/**
	 * This job's parent job which creates a JAR archive of the simulation
	 * bundle
	 */
	private IJobWithResult<byte[]> myCreatePluginProjectJob;

	/**
	 * Configuration object for the simulation
	 */
	private SimuComConfig myConfig;

	private ILaunch launch;

	private boolean isDebug;

	private static Logger logger = Logger
			.getLogger(TransferSimulationBundleToDock.class.getName());

	public TransferSimulationBundleToDock(
			IJobWithResult<byte[]> createPluginJarJob,
			SimuComConfig simuConfig, ILaunch launch) {
		myCreatePluginProjectJob = createPluginJarJob;
		myConfig = simuConfig;
		this.launch = launch;
		this.isDebug = true;// simuConfig.isDebug();
	}

	public void execute() throws JobFailedException {
		SimulationDebugTarget target = null;
		assert (myCreatePluginProjectJob != null);

		showSimuDockView();
		try {
			DockModel dock = SimuControllerPlugin.getDockModel()
					.getBestFreeDock();
			SimulationDockService simService = dock.getService();
			if (isDebug) {
				target = new SimulationDebugTarget(launch, dock);
				launch.addDebugTarget(target);
			}
			simService.simulate(myConfig, myCreatePluginProjectJob.getResult(),
					dock.isRemote());
		} catch (InterruptedException e) {
			throw new JobFailedException(
					"Job failed while waiting for a dock to become available",
					e);
		} catch (Exception e) {
			throw new JobFailedException("Job failed.", e);
		} finally {
			if (isDebug) {
				if (target != null) {
					// Wait for termination, needed as termination is reported
					// via async events by the dock
					while (!target.isTerminated()) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
						}
					}
					configureLogger();
					int openRunCount = OpenWorkloadUser.getRunCount();
					int openFailureCount = OpenWorkloadUser.getFailureCount();
					double openFailureRate = (openRunCount == 0) ? 0
							: ((double) openFailureCount / (double) openRunCount);
					int closedRunCount = ClosedWorkloadUser.getRunCount();
					int closedFailureCount = ClosedWorkloadUser
							.getFailureCount();
					double closedFailureRate = (closedRunCount == 0) ? 0
							: ((double) closedFailureCount / (double) closedRunCount);
					logger
							.info("Simulation results: OpenWorkloadUser.runCount = "
									+ openRunCount);
					logger
							.info("Simulation results: OpenWorkloadUser.failureCount = "
									+ openFailureCount);
					logger
							.info("Simulation results: OpenWorkloadUser.failureRate = "
									+ openFailureRate);
					logger
							.info("Simulation results: ClosedWorkloadUser.runCount = "
									+ closedRunCount);
					logger
							.info("Simulation results: ClosedWorkloadUser.failureCount = "
									+ closedFailureCount);
					logger
							.info("Simulation results: ClosedWorkloadUser.failureRate = "
									+ closedFailureRate);
					OpenWorkloadUser.resetCounters();
					ClosedWorkloadUser.resetCounters();
					target.dispose();
					launch.removeDebugTarget(target);
				}
			}
		}
	}

	private void showSimuDockView() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			public void run() {
				IViewPart viewer;
				try {
					viewer = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage()
							.showView(DockStatusViewPart.ID);
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().bringToTop(viewer);
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

	private void configureLogger() {
		PatternLayout myLayout = new PatternLayout(
				"%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
		ConsoleAppender myAppender = new ConsoleAppender(myLayout);
		BasicConfigurator.configure(myAppender);
	}
}
