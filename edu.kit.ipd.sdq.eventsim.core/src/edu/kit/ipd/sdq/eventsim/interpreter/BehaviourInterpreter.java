package edu.kit.ipd.sdq.eventsim.interpreter;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.usagemodel.UsageScenario;

import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.TraversalException;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.EndTraversal;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This abstract class is the central facility to traverse the actions of a {@link UsageScenario} or
 * a {@link ResourceDemandingSEFF} (RD-SEFF). Traversing means to start with an initial action,
 * perform the simulation logic associated with this action, and then start over with the next
 * action and so on.
 * <p>
 * For each type of action contained in a behaviour description, a traversal strategy (
 * {@link ITraversalStrategy}) has to be implemented. This strategy does two things: 1) It performs
 * the simulation of the action, i.e. changes the simulation state according to the action under
 * traversal. In other words, the simulation logic associated with this action is executed. 2) It
 * provides the information which action is the next to be traversed. For further information see
 * {@link ITraversalInstruction}. Implementors of this class have to provide appropriate traversal
 * strategies for the various action types by implementing the
 * {@link #loadTraversalStrategy(EClass)} method.
 * <p>
 * It is an inherent property of event based simulations that the behaviour of a simulated entity is
 * distributed over several events. Therefore, the traversal can be paused and scheduled to be
 * resumed after a certain delay. To begin a traversal, use the {@link #beginTraversal()} method. In
 * order to resume a paused traversal, use the {@link #resumeTraversal()} method. The resume method
 * can be called on a fresh instance, which is possible due passing a {@link TraversalState}. The
 * traversal state carries the whole status of the traversal, i.e. which action is the next, which
 * one has just been traversed and so on.
 * <p>
 * Clients can register themselves to receive traversal events. Events are fired whenever an action
 * is about to be traversed and when the traversal of an action has been completed. See
 * {@link ITraversalListener}.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the least common parent type of all actions that are to be traversed
 * @param <E>
 *            the type of the entity whose behaviour is simulated by the traversal
 * @param <S>
 *            TODO
 */
public abstract class BehaviourInterpreter<A extends Entity, E extends EventSimEntity, S extends AbstractInterpreterState<A>> {

    private static Logger logger = Logger.getLogger(BehaviourInterpreter.class);
    
    /**
     * Begins or resumes the traversal with the specified action.
     * 
     * @param the
     *            entity which traverses the usage behavior
     * @param firstAction
     *            the action with which to start the traversal
     * @param state
     *            TODO
     */
    protected void traverse(E entity, final A firstAction, S state) {
        A currentAction = firstAction;
        // traverse the actions one after another. When the current action is null, it means that
        // the traversal is either completed or needs to be paused.
        while (currentAction != null) {
            // obtain the traversal strategy for the current action
            final ITraversalStrategy<A, A, E, S> t = this.loadTraversalStrategy(currentAction.eClass());
            if (t == null) {
                throw new TraversalException("No traversal strategy could be found for "
                        + PCMEntityHelper.toString(currentAction));
            }

            if (logger.isDebugEnabled()) {
                logger.debug("Encountered action " + PCMEntityHelper.toString(currentAction) + " at t="
                        + entity.getModel().getSimulationControl().getCurrentSimulationTime());
            }
            
            // notify traversal listeners. Do not change the order of the next two lines!
            this.notifyAfterListenerAboutFinishedActions(entity, currentAction, state);
            this.notifyBeforeListenerAboutStartedActions(entity, currentAction, state);

            // traverse the current action and get an instruction of how to proceed the
            // traversal.
            final ITraversalInstruction<A, S> instruction = t.traverse(currentAction, entity, state);

            // set the next action to be traversed according to the instructions provided by the
            // current traversal strategy
            final A nextAction = instruction.process(state);
            currentAction = nextAction;

            // check, whether the traversal is completed.
            if (nextAction == null && instruction instanceof EndTraversal<?, ?>) {
                this.endTraversal(entity, state);
            }
        }
    }

    protected abstract InterpreterConfiguration<A, E, S> getConfiguration();

    /**
     * This method is called, when the traversal is completed. This is not the case, when the
     * traversal is to be stopped.
     */
    private void endTraversal(E entity, S state) {
        while (state.hasFinishedActions()) {
            final A action = state.dequeueFinishedAction();
            this.notifyAfterListener(action, entity, state);
        }
        entity.notifyLeftSystem();
    }

    /**
     * Notifies the before listeners, if 1) the current action is the first action that is to be
     * traversed or 2) the previously traversed action differs from the current action. In this way,
     * no notifications are fired when the same action is traversed repeatedly.
     * 
     * @param currentAction
     *            the action that is about to be traversed
     */
    private void notifyBeforeListenerAboutStartedActions(E entity, final A currentAction, S state) {
        if (state.getPreviousPosition() == null || !state.getPreviousPosition().getId().equals(currentAction.getId())) {
            this.notifyBeforeListener(currentAction, entity, state);
        }
    }

    /**
     * Notifies the after listeners for each action that has been traversed completely.
     * 
     * @param currentAction
     *            the action that is about to be traversed
     */
    private void notifyAfterListenerAboutFinishedActions(E entity, final A currentAction, S state) {
        while (state.hasFinishedActions()) {
            final A action = state.dequeueFinishedAction();
            if (!action.getId().equals(currentAction.getId())) {
                this.notifyAfterListener(action, entity, state);
            }
        }
    }

    /**
     * This method needs to be implemented by subclasses in order to provide a suitable traversal
     * strategy for each type of action that can appear in the behaviour description.
     * 
     * @param eclass
     *            the type of the action
     * @return the traversal strategy which is able to traverse actions of the specified type
     */
    public abstract <T extends A> ITraversalStrategy<A, T, E, S> loadTraversalStrategy(EClass eclass);

    /**
     * This method is called whenever a simulated entity is about to traverse an action.
     * Implementors have to notify registered event listeners.
     * 
     * @param action
     *            the action which is about to be traversed
     * @param entity
     *            the simulated entity whose behaviour is being simulated by the traversal
     * @param state
     *            TODO
     */
    public abstract void notifyBeforeListener(A action, E entity, S state);

    /**
     * This method is called whenever a simulated entity has completed the traversal of an action.
     * Implementors have to notify registered event listeners.
     * 
     * @param action
     *            the action which has been traversed
     * @param entity
     *            the simulated entity whose behaviour is being simulated by the traversal
     * @param state
     *            TODO
     */
    public abstract void notifyAfterListener(A action, E entity, S state);

}