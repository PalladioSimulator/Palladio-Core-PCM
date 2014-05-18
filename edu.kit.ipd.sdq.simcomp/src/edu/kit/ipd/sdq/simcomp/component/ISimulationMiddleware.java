package edu.kit.ipd.sdq.simcomp.component;

import java.util.List;

import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.simulation.IStatusObserver;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationEvent;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationInitEvent;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationStartEvent;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationStopEvent;

/**
 * Represents the central point of a simulation component based simulation.
 * 
 * @author Christoph Föhrdes
 */
public interface ISimulationMiddleware {

	/**
	 * List of simulation events triggered by this simulation component.
	 */
	@SuppressWarnings("rawtypes")
	public static Class[] componentEvents = new Class[] { 
		SimulationInitEvent.class, 
		SimulationStartEvent.class, 
		SimulationStopEvent.class, 
		SimulationFinalizeEvent.class
	};

	/**
	 * Initializes the middleware with a simulation configuration provided by
	 * the user on launch. Called in the prepare simulation phase.
	 * 
	 * @param configuration
	 *            A simulation configuration
	 * @param pcmModel
	 *            The PCM model to be simulated
	 */
	public void initialize(ISimulationConfiguration configuration, IPCMModel pcmModel);

	/**
	 * Starts a simulation component based simulation.
	 * 
	 * @param statusObserver
	 *            A status observer which indicates the simulation progress in
	 *            the GUI.
	 */
	public void startSimulation(final IStatusObserver statusObserver);

	/**
	 * Stops the simulation.
	 */
	public void stopSimulation();

	/**
	 * Returns a simulation component out of a list of alternatives based on the
	 * simulation configuration and a simulation context.
	 * 
	 * @param componentList
	 *            A list of possible simulation components to choose from
	 * @param context
	 *            A simulation context to base the decision on
	 * @return The simulation component to be used
	 */
	public <T extends ISimulationComponent> T getSimulationComponent(List<? extends ISimulationComponent> componentList, ISimulationContext context);

	/**
	 * Gives access to the simulation configuration provided by the user on
	 * launch of the simulation run.
	 * 
	 * @return A simulation configuration
	 */
	public ISimulationConfiguration getSimulationConfiguration();

	/**
	 * Gives access to the PCM model to be simulated.
	 * 
	 * @return The PCM model to be simulated
	 */
	public IPCMModel getPCMModel();

	/**
	 * Gives access to the abstract sim engine simulation model, which is the
	 * core of the simulation. It basically represents the main simulation
	 * timeline.
	 * 
	 * @return The simulation model
	 */
	public ISimulationModel getSimulationModel();

	/**
	 * Gives access to the simulation control instance
	 * 
	 * @return The simulation control
	 */
	public ISimulationControl getSimulationControl();

	/**
	 * Triggers a specific simulation event. All registered event handlers are
	 * processed synchronously.
	 * 
	 * @param event
	 *            The event type to trigger
	 */
	public void triggerEvent(SimulationEvent event);

	/**
	 * Registers a new event handler for a specific event.
	 * 
	 * @param eventId
	 *            The event type to listen for
	 * @param handler
	 *            The event handler callback.
	 */
	public void registerEventHandler(String eventId, IEventHandler<? extends SimulationEvent> handler);

	/**
	 * Gives access to the central probe specification context of the probe
	 * framework.
	 * 
	 * @return The probe specification context
	 */
	ProbeSpecContext getProbeSpecContext();

	/**
	 * Gives access the the amount of measurements done in the current
	 * simulation. One measurement means one user request was entirely
	 * processed.
	 * 
	 * @return The amount of measurement for the current simulation run.
	 */
	int getMeasurementCount();

}
