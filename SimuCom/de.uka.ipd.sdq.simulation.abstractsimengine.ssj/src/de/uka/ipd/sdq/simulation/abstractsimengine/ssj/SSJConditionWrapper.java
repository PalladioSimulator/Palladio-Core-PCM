package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 */
public class SSJConditionWrapper<M extends ISimulationModel> {

    private SimCondition abstractCondition;

    public SSJConditionWrapper(SimCondition abstractCondition) {
        this.abstractCondition = abstractCondition;
    }

}
