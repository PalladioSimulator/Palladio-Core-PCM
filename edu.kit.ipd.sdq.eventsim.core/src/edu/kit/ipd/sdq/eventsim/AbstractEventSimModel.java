package edu.kit.ipd.sdq.eventsim;

import edu.kit.ipd.sdq.eventsim.command.ICommand;
import edu.kit.ipd.sdq.eventsim.command.PCMModelCommandExecutor;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

/**
 * This class is the basis for a simulation component based on EventSim. It
 * contains the management of the active EventSim entities.
 * 
 * @author Christoph Föhrdes
 */
abstract public class AbstractEventSimModel {

	private ISimulationMiddleware middleware;
	private EventSimConfig config;
	private PCMModelCommandExecutor executor;
	private EntityRegistry entityRegistry;

	public AbstractEventSimModel(ISimulationMiddleware middleware) {
		this.middleware = middleware;
		this.config = new EventSimConfig(middleware.getSimulationConfiguration().getConfigurationMap(), middleware.getSimulationConfiguration().isDebug());
		this.executor = new PCMModelCommandExecutor(middleware.getPCMModel());
		this.entityRegistry = EntityRegistry.getInstance();
	}

	public ISimulationMiddleware getSimulationMiddleware() {
		return middleware;
	}

	/**
	 * Initializes the model
	 */
	public abstract void init();

	/**
	 * Executes the specified command and returns the result.
	 * 
	 * @param <T>
	 *            the return type
	 * @param command
	 *            the command that is to be executed
	 * @return the command's result
	 */
	public <T> T execute(final ICommand<T, IPCMModel> command) {
		return this.executor.execute(command);
	}

	/**
	 * Informs this simulation model about the creation of a new entity.
	 * <p>
	 * Once the registered entity has left the simulation system,
	 * {@link #unregisterEntity(EventSimEntity)} should be called. Entities that
	 * were registered, but have not been unregistered are deemed as active
	 * entities, i.e. they have not yet finished simulating their behaviour.
	 * When the simulation is about to stop, the {@code finalise} method
	 * notifies active entities of the imminent stop.
	 * 
	 * @param entity
	 *            the entity that has just been spawned
	 */
	public void registerEntity(EventSimEntity entity) {
		this.entityRegistry.registerEntity(entity);
	}

	/**
	 * Informs this simulation model that the specified entity has finished to
	 * simulate its behaviour and is about to leave the simulated system.
	 * 
	 * @param entity
	 *            the entity that has just finished their simulated behaviour
	 */
	public void unregisterEntity(EventSimEntity entity) {
		this.entityRegistry.unregisterEntity(entity);
	}

	/**
	 * Gives access to the EventSim specific configuration
	 * 
	 * @return An event EventSim config instance
	 */
	public EventSimConfig getEventSimConfig() {
		return this.config;
	}

}
