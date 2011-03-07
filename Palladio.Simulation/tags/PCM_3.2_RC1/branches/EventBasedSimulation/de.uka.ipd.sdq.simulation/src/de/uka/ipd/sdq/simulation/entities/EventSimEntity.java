package de.uka.ipd.sdq.simulation.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.context.Context;

public abstract class EventSimEntity extends AbstractSimEntity<EventSimModel> {

    private static final AtomicLong idGenerator = new AtomicLong(0);

    private final List<IEntityListener> listeners;
    private final long id;
    private final String namePrefix;

    public EventSimEntity(final EventSimModel model, final String namePrefix) {
        super(model, namePrefix);
        this.listeners = new ArrayList<IEntityListener>();
        this.id = idGenerator.incrementAndGet();
        this.namePrefix = namePrefix;
    }

    public void notifyEnteredSystem() {
        for (final IEntityListener l : this.listeners) {
            l.enteredSystem();
        }
    }

    public void notifyLeftSystem() {
        for (final IEntityListener l : this.listeners) {
            l.leftSystem();
        }
    }

    public void addEntityListener(final IEntityListener listener) {
        this.listeners.add(listener);
    }
    
    public void removeEntityListener(final IEntityListener listener) {
        this.listeners.remove(listener);
    }

    public long getEntityId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.namePrefix + "#" + this.getEntityId();
    }
    
    public static void resetIdGenerator() {
        idGenerator.set(0);
    }
    
    public abstract Context getContext();    

}
