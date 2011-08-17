package de.uka.ipd.sdq.simulation.debug;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.entities.IEntityListener;

/**
 * This listener prints a debug message when an arbitrary entity entered or left the system. It can
 * be registered with an {@link EventSimEntity}.
 * 
 * @author Philipp Merkle
 * 
 */
public class DebugEntityListener implements IEntityListener {

    private static final Logger logger = Logger.getLogger(DebugEntityListener.class);

    private final EventSimEntity entity;

    /**
     * Constructs a new debug listener for the specified entity.
     * 
     * @param entity
     *            the entity that is to be observed by this listener
     */
    public DebugEntityListener(final EventSimEntity entity) {
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enteredSystem() {
        logger.debug("ENTERED SYSTEM: " + this.entity.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void leftSystem() {
        logger.debug("LEFT SYSTEM: " + this.entity.getName());
    }

}
