package de.uka.ipd.sdq.simulation.traversal;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.exceptions.unchecked.TraversalException;
import de.uka.ipd.sdq.simulation.traversal.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.traversal.listener.ITraversalListener;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

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
 * {@link #obtainTraversalStrategy(EClass)} method.
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
 */
public abstract class BehaviourTraversal<A extends Entity, E extends EventSimEntity> {

    private static Logger logger = Logger.getLogger(BehaviourTraversal.class);

    /** the entity which traverses the usage behavior */
    protected final E entity;

    public BehaviourTraversal(final E entity) {
        this.entity = entity;
    }

//    /**
//     * Creates a new traversal state and starts the traversal.
//     */
//    public abstract void beginTraversal();
//
//    /**
//     * Resumes the traversal after it has been paused. The traversal is restored in accordance with
//     * the specified traversal state.
//     * 
//     * @param state
//     *            the traversal state
//     */
//    public abstract void resumeTraversal(TraversalState<A> state);

    /**
     * Begins or resumes the traversal with the specified action.
     * 
     * @param firstAction
     *            the action with which to start the traversal
     */
    protected void traverse(final A firstAction, TraversalState<A> state) {
        A currentAction = firstAction;
        // traverse the actions one after another. When the current action is null, it means that
        // the traversal is either completed or needs to be paused.
        while (currentAction != null) {
            // obtain the traversal strategy for the current action
            final ITraversalStrategy<A, A, E> t = this.obtainTraversalStrategy(currentAction.eClass());
            if (t == null) {
                throw new TraversalException("No traversal strategy could be found for "
                        + PCMEntityHelper.toString(currentAction));
            }

            // notify traversal listeners. Do not change the order of the next two lines!
            this.notifyAfterListenerAboutFinishedActions(currentAction, state);
            this.notifyBeforeListenerAboutStartedActions(currentAction, state);

            // traverse the current action and get an instruction of how to proceed the
            // traversal.
            if (logger.isDebugEnabled()) {
                logger.debug("Traversing action " + PCMEntityHelper.toString(currentAction) + " at t="
                        + this.entity.getModel().getSimulationControl().getCurrentSimulationTime());
            }
            final ITraversalInstruction<A> instruction = t.traverse(currentAction, this.entity, state);

            // set the next action to be traversed according to the instructions provided by the
            // current traversal strategy
            final A nextAction = instruction.process(state);
            currentAction = nextAction;

            // check, whether the traversal is completed.
            if (nextAction == null && instruction instanceof EndTraversal<?>) {
                this.endTraversal(state);
            }
        }
    }

    /**
     * This method is called, when the traversal is completed. This is not the case, when the
     * traversal is to be stopped.
     */
    private void endTraversal(TraversalState<A> state) {
        while (state.getStack().currentScope().hasFinishedActions()) {
            final A action = state.getStack().currentScope().dequeueFinishedAction();
            this.notifyAfterListener(action, this.entity, state);
        }
        state.getStack().leaveScope();
        this.entity.notifyLeftSystem();
    }

    /**
     * Notifies the before listeners, if 1) the current action is the first action that is to be
     * traversed or 2) the previously traversed action differs from the current action. In this way,
     * no notifications are fired when the same action is traversed repeatedly.
     * 
     * @param currentAction
     *            the action that is about to be traversed
     */
    private void notifyBeforeListenerAboutStartedActions(final A currentAction, TraversalState<A> state) {
        final TraversalStackFrame<A> currentScope = state.getStack().currentScope();
        if (currentScope.getPreviousPosition() == null
                || !currentScope.getPreviousPosition().getId().equals(currentAction.getId())) {
            this.notifyBeforeListener(currentAction, this.entity, state);
        }
    }

    /**
     * Notifies the after listeners for each action that has been traversed completely.
     * 
     * @param currentAction
     *            the action that is about to be traversed
     */
    private void notifyAfterListenerAboutFinishedActions(final A currentAction, TraversalState<A> state) {
        final TraversalStackFrame<A> currentScope = state.getStack().currentScope();
        while (currentScope.hasFinishedActions()) {
            final A action = currentScope.dequeueFinishedAction();
            if (!action.getId().equals(currentAction.getId())) {
                this.notifyAfterListener(action, this.entity, state);
            }
        }
    }

    /**
     * Returns the entity whose behaviour is to be simulated.
     * 
     * @return the simulated entity
     */
    public E getEntity() {
        return this.entity;
    }

    /**
     * This method needs to be implemented by subclasses in order to provide a suitable traversal
     * strategy for each type of action that can appear in the behaviour description.
     * 
     * @param eclass
     *            the type of the action
     * @return the traversal strategy which is able to traverse actions of the specified type
     */
    public abstract <T extends A> ITraversalStrategy<A, T, E> obtainTraversalStrategy(EClass eclass);

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
    public abstract void notifyBeforeListener(A action, E entity, TraversalState<A> state);

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
    public abstract void notifyAfterListener(A action, E entity, TraversalState<A> state);

}