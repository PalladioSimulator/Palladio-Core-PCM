package de.uka.ipd.sdq.simulation.traversal.usage;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.traversal.ITraversalStrategy;

public interface IUsageTraversalStrategy<T extends AbstractUserAction> extends
        ITraversalStrategy<AbstractUserAction, T, User> {

    // no further signature

}
