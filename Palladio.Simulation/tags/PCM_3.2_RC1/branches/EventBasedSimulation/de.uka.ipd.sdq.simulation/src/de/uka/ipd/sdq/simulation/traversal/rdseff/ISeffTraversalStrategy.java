package de.uka.ipd.sdq.simulation.traversal.rdseff;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.ITraversalStrategy;

public interface ISeffTraversalStrategy<T extends AbstractAction> extends
        ITraversalStrategy<AbstractAction, T, Request> {

    // no additional signatures

}
