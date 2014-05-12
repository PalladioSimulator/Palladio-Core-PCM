package edu.kit.ipd.sdq.eventsim;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;

/**
 * Registry for active simulation entities
 * 
 * @author Christoph Föhrdes
 *
 */
public class EntityRegistry {

	private static EntityRegistry instance = new EntityRegistry();

	private final List<EventSimEntity> activeEntitiesList;

	/**
	 * This class is a singleton
	 */
	private EntityRegistry() {
		this.activeEntitiesList = new CopyOnWriteArrayList<EventSimEntity>();
	}

	public static EntityRegistry getInstance() {
        return instance;
    }

	/**
	 * Informs this simulation model about the creation of a new entity.
	 * <p>
	 * Once the registered entity has left the simulation system,
	 * {@link #unregisterEntity(EventSimEntity)} should be called. Entities that
	 * were registered, but have not been unregistered are deemed as active
	 * entities, i.e. they have not yet finished simulating their behavior.
	 * When the simulation is about to stop, the {@code finalise} method
	 * notifies active entities of the imminent stop.
	 * 
	 * @param entity
	 *            the entity that has just been spawned
	 */
	public void registerEntity(EventSimEntity entity) {
		this.activeEntitiesList.add(entity);
	}

	/**
	 * Informs this simulation model that the specified entity has finished to
	 * simulate its behavior and is about to leave the simulated system.
	 * 
	 * @param entity
	 *            the entity that has just finished their simulated behavior
	 */
	public void unregisterEntity(EventSimEntity entity) {
		this.activeEntitiesList.remove(entity);
	}
}
