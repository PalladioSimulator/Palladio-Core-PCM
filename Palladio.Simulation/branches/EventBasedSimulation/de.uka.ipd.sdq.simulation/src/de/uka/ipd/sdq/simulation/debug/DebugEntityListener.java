package de.uka.ipd.sdq.simulation.debug;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.entities.IEntityListener;

public class DebugEntityListener implements IEntityListener {

    private static final Logger logger = Logger.getLogger(DebugEntityListener.class);

    private final EventSimEntity entity;

    public DebugEntityListener(final EventSimEntity entity) {
        this.entity = entity;
    }

    @Override
    public void enteredSystem() {
        logger.debug("ENTERED SYSTEM: " + this.entity.getName());
    }

    @Override
    public void leftSystem() {
        logger.debug("LEFT SYSTEM: " + this.entity.getName());
    }

}
