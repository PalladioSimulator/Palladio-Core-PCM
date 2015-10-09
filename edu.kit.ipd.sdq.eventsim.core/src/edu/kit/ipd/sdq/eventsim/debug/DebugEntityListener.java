package edu.kit.ipd.sdq.eventsim.debug;

import java.lang.ref.WeakReference;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.entities.IEntityListener;

/**
 * This listener prints a debug message when an arbitrary entity entered or left the system. It can
 * be registered with an {@link EventSimEntity}.
 * 
 * @author Philipp Merkle
 * 
 */
public class DebugEntityListener implements IEntityListener {

    private static final Logger logger = Logger.getLogger(DebugEntityListener.class);

    private final WeakReference<EventSimEntity> entity;

    /**
     * Constructs a new debug listener for the specified entity.
     * 
     * @param entity
     *            the entity that is to be observed by this listener
     */
    public DebugEntityListener(final EventSimEntity entity) {
        this.entity = new WeakReference<EventSimEntity>(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enteredSystem() {
		logger.debug("ENTERED SYSTEM: " + this.entity.get().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void leftSystem() {
		logger.debug("LEFT SYSTEM: " + this.entity.get().getName());
    }

}
