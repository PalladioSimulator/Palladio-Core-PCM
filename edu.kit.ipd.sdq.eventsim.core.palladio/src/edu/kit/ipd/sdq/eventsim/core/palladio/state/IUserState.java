package edu.kit.ipd.sdq.eventsim.core.palladio.state;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import edu.kit.ipd.sdq.eventsim.interpreter.state.IInterpreterState;

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
