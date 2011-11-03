package de.uka.ipd.sdq.simulation.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntity;

/**
 * This is the abstract base class for all simulated entities. Entities have an ID and they notify
 * registered {@link IEntityListener}s if requested. Both, the generation of IDs and the handling of
 * listeners is provided by this class.
 * <p>
 * IDs are unique with regard to the class of an entity. Thus, an entity that is an instance of
 * {@code ClassA} can have a certain ID while at the same time an entity of {@code ClassB} can have
 * the same ID. IDs are generated as follows: 0, 1, ..., n.
 * <p>
 * Listeners can register themselves by using the {@code addEntityListener()} method. The listeners
 * can be notified by calling {@code notifyEnteredSystem()} or {@code notifyLeftSystem()}.
 * 
 * @author Philipp Merkle
 * 
 */
public abstract class EventSimEntity extends AbstractSimEntity<EventSimModel> {

    // maps entity class -> ID generator
    private static final Map<Class<? extends EventSimEntity>, AtomicLong> idGenerators;

    private final List<IEntityListener> listeners;
    private final long id;
    private final String namePrefix;

    static {
        idGenerators = new HashMap<Class<? extends EventSimEntity>, AtomicLong>();
    }

    /**
     * Constructs an entity with the specified {@code namePrefix}. The entity is created with an ID
     * that is unique with regard to the entity's class.
     * 
     * @param model
     *            the model
     * @param namePrefix
     *            the prefix of the entitie's name
     */
    public EventSimEntity(final EventSimModel model, final String namePrefix) {
        super(model, namePrefix);
        this.listeners = new ArrayList<IEntityListener>();
        this.namePrefix = namePrefix;
        this.id = generateNextId();
    }

    /**
     * Generates the next ID for an entity or creates a new ID generator with 0 being the first ID.
     * 
     * @return the next ID
     */
    private long generateNextId() {
        AtomicLong generator = idGenerators.get(this.getClass());
        if (generator == null) {
            generator = new AtomicLong(0);
            idGenerators.put(this.getClass(), generator);
        }
        return generator.incrementAndGet();
    }

    /**
     * Notifies all registered listeners that the entity is about to enter the system.
     */
    public void notifyEnteredSystem() {
        for (final IEntityListener l : this.listeners) {
            l.enteredSystem();
        }
    }

    /**
     * Notifies all registered listeners that the entity has left the system.
     */
    public void notifyLeftSystem() {
        for (final IEntityListener l : this.listeners) {
            l.leftSystem();
        }
    }

    /**
     * Adds a listener, which is to be informed whenever an entity is about to enter or has left the
     * system.
     * 
     * @param listener
     *            the listener that is to be added
     */
    public void addEntityListener(final IEntityListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Removes a listener that has been registered before.
     * 
     * @param listener
     *            the listener that is to be removed
     */
    public void removeEntityListener(final IEntityListener listener) {
        this.listeners.remove(listener);
    }

    public long getEntityId() {
        return this.id;
    }

    /**
     * Returns the name of this entity. The name is the {@code namePrefix} passed to the constructor
     * concatenated with the entity's ID.
     * 
     * @return a string representation of this entity
     */
    @Override
    public String getName() {
        return this.namePrefix + "#" + this.getEntityId();
    }

    /**
     * Resets the ID generators, so that the ID generated next is 0 for all entity classes.
     */
    public static void resetIdGenerator() {
        idGenerators.clear();
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		return getName();
	}

}
