package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;
import desmoj.core.simulator.Condition;
import desmoj.core.simulator.Entity;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class DesmoJConditionWrapper extends Condition {

    private SimCondition abstractCondition;

    public DesmoJConditionWrapper(SimCondition abstractCondition, DesmoJModel owner) {
        super(owner, abstractCondition.getClass().getName(), false);
        this.abstractCondition = abstractCondition;
    }

    @Override
    public boolean check() {
        return abstractCondition.check();
    }

    @Override
    public boolean check(Entity arg0) {
        return false;
    }

}
