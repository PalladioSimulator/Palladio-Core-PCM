package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.SimCondition;
import desmoj.core.simulator.Condition;
import desmoj.core.simulator.Entity;

public class DesmoJConditionWrapper<T extends ISimulationModel<T>> extends Condition {

    private SimCondition<T> abstractCondition;

    public DesmoJConditionWrapper(SimCondition<T> abstractCondition, DesmoJModel<T> owner) {
        super(owner, abstractCondition.getName(), false);
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
