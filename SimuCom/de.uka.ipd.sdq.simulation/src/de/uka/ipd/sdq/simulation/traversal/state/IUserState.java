package de.uka.ipd.sdq.simulation.traversal.state;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.simulation.entities.User;

/**
 * This interface specifies which state information can be set and returned for a {@link User}
 * entity.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IUserState extends IInterpreterState<AbstractUserAction> {

    // currently, there is no additional state information for User entities

}
