package edu.kit.ipd.sdq.simcomp.component;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simulation.IStatusObserver;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import edu.kit.ipd.sdq.eventsim.measurement.r.RMeasurementStore;
import edu.kit.ipd.sdq.simcomp.component.meta.IContextFieldValueProvider;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;
import edu.kit.ipd.sdq.simcomp.config.ISimulationConfiguration;
import edu.kit.ipd.sdq.simcomp.events.IEventHandler;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationInitEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationStartEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationStopEvent;

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
	public static Class[] componentEvents = new Class[] { SimulationInitEvent.class, SimulationStartEvent.class, SimulationStopEvent.class, SimulationFinalizeEvent.class };

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
	 * Returns a collection of meta data about all simulation components
	 * registered at this simulation middleware instance. The meta data consists
	 * of a list of simulation component type descriptions which contain data
	 * about their available implementations and contexts to configure the
	 * dynamic simulator composition.
	 * 
	 * @return A List of simulation component metadata
	 */
	public List<SimulationComponentImpl> getSimulationComponentMetadata();

	/**
	 * Returns the value provider for a given simulation context field. Used to
	 * create simulation configurations.
	 * 
	 * @param field
	 *            The field to fetch the value provider for
	 * @return A value provider instance
	 */
	public IContextFieldValueProvider getValueProviderForContextField(SimulationContextField field);

	/**
	 * Starts a simulation component based simulation.
	 * 
	 * @param statusObserver
	 *            A status observer which indicates the simulation progress in
	 *            the GUI.
	 */
	public void startSimulation(final IStatusObserver statusObserver);

	/**
	 * Stops a simulation run simulation.
	 */
	public void stopSimulation();

	/**
	 * Returns a simulation component out of a list of alternatives based on the
	 * simulation configuration and a simulation context.
	 * 
	 * @param requestingType
	 *            The component type requesting access to a required simulation
	 *            component. For example ISystem when accessing a
	 *            IActiveResource from ISystem.
	 * @param requiredType
	 *            The component type to be accessed. For example IActiveResource
	 *            when accessing a IActiveResource from ISystem.
	 * @param componentList
	 *            A list of alternative simulation components to select one
	 *            from. For example a list of IActiveResource implementations
	 *            when accessing a IActiveResource from ISystem.
	 * @param context
	 *            The simulation context used to determine the simulation
	 *            component
	 * 
	 * @return The simulation component to use
	 */
	public ISimulationComponent getSimulationComponent(Class<? extends ISimulationComponent> requestingType, Class<? extends ISimulationComponent> requiredType, List<? extends ISimulationComponent> componentList, AbstractSimulationContext context);

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
	 * Registers a new event handler for a specific event. This event handler is
	 * not unregistered on cleanup of the simulation middleware.
	 * 
	 * @param eventId
	 *            The event type to listen for
	 * @param handler
	 *            The event handler callback.
	 */
	public void registerEventHandler(String eventId, IEventHandler<? extends SimulationEvent> handler);

	/**
	 * Registers a new event handler for a specific event.
	 * 
	 * @param eventId
	 *            The event type to listen for
	 * @param handler
	 *            The event handler callback.
	 * @param unregisterOnReset
	 *            Specifies if the event handler should be unregistered on
	 *            middleware cleanup or not
	 */
	public void registerEventHandler(String eventId, IEventHandler<? extends SimulationEvent> handler, boolean unregisterOnReset);

//	/**
//	 * Gives access to the central probe specification context of the probe
//	 * framework.
//	 * 
//	 * @return The probe specification context
//	 */
//	MeasurementSink getProbeSpecContext();

	/**
	 * Gives access the the amount of measurements done in the current
	 * simulation. One measurement means one user request was entirely
	 * processed.
	 * 
	 * @return The amount of measurement for the current simulation run.
	 */
	int getMeasurementCount();

	/**
	 * Increases the simulation measurement count. One measurement means one
	 * user request was entirely processed.
	 */
	void increaseMeasurementCount();

	/**
	 * Resets the measurement counter.
	 */
	void resetMeasurementCount();

	/**
	 * Called before every simulation run to reset the middleware.
	 */
	void reset();

	IRandomGenerator getRandomGenerator();
	
	RMeasurementStore getMeasurementStore();

}
