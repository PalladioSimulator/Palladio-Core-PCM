package edu.kit.ipd.sdq.simcomp.middleware.simulation;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.simulation.ISimulationControl;
import de.uka.ipd.sdq.simulation.IStatusObserver;
import de.uka.ipd.sdq.simulation.SimulationResult;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationConfiguration;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.middleware.Activator;

/**
 * The entry point for a simulation component based simulation. This class is
 * instantiated as bundle activator of the generated simulation code bundle.
 * 
 * Should be started on GUI access in launch configuration
 * 
 * @author Christoph Föhrdes
 */
public abstract class SimulationMain implements ISimulationControl, BundleActivator {

	private ServiceRegistration<?> serviceRegistryEntry;
	private ISimulationMiddleware simulationMiddleware;
	private BundleContext bundleContext;
	private Throwable exceptionOccured;
	private SimuComStatus simuComStatus;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("SimulationMain start (generated bundle activated)");

		this.bundleContext = bundleContext;

		// register the simulation main service in the temporary simulation code
		// plugin project to be called by the simulation dock
		this.serviceRegistryEntry = bundleContext.registerService(ISimulationControl.class.getName(), this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("SimulationMain stop (generated bundle deactivated)");

		// unregister the simulation main service and clean up
		this.serviceRegistryEntry.unregister();
		this.serviceRegistryEntry = null;
		this.bundleContext = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void prepareSimulation(AbstractSimulationConfig configuration, IStatusObserver observer, boolean arg2) {
		Activator middlewareActivator = Activator.getDefault();
		this.simulationMiddleware = middlewareActivator.getSimulationMiddleware();

		ISimulationConfiguration simConfig = (ISimulationConfiguration) configuration;

		// load the PCM model to be simulated
		final IPath usageModelLocation = this.createRelativePathToModelFile(simConfig.getUsageModelFile());
		final IPath allocationModelLocation = this.createRelativePathToModelFile(simConfig.getAllocationModelFile());
		IPCMModel pcmModel = PCMModel.loadFromBundle(this.bundleContext.getBundle(), usageModelLocation, allocationModelLocation);

		// initialize the middleware
		this.simulationMiddleware.initialize(simConfig, pcmModel);

		this.getStatus().setCurrentSimulationTime(0);
	}

	/**
	 * Takes a path and converts it to a path that is relative to the bundle.
	 * 
	 * @param location
	 *            the path
	 * @return the relative path
	 */
	private IPath createRelativePathToModelFile(final String location) {
		String fileName = new File(location).getName();
		final IPath path = new Path("model/" + fileName);

		return path;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimulationResult startSimulation(AbstractSimulationConfig configuration, final IStatusObserver observer, boolean arg2) {
		try {

			this.simulationMiddleware.startSimulation(observer);

		} catch (final Throwable t) {
			t.printStackTrace();
			this.exceptionOccured = t;
			return SimulationResult.ERROR;
		}

		return SimulationResult.OK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopSimulation() {
		this.simulationMiddleware.stopSimulation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Throwable getErrorThrowable() {
		return this.exceptionOccured;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimuComStatus getStatus() {
		if (this.simuComStatus == null) {
			this.simuComStatus = SimucomstatusFactory.eINSTANCE.createSimuComStatus();
			this.simuComStatus.setProcessStatus(SimucomstatusFactory.eINSTANCE.createSimulatedProcesses());
			this.simuComStatus.setResourceStatus(SimucomstatusFactory.eINSTANCE.createSimulatedResources());
		}

		return this.simuComStatus;
	}
}
