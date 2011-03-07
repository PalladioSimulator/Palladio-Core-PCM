package de.uka.ipd.sdq.simulation.traversal;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.simulation.entities.EventSimEntity;
import de.uka.ipd.sdq.simulation.exceptions.concrete.TraversalException;
import de.uka.ipd.sdq.simulation.traversal.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.listener.ITraversalListener;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

/**
 * This abstract class is the central facility to traverse the actions of an usage scenario or a
 * resource demanding service effect specification (RDSEFF). Traversing means to start with an
 * initial action, perform the simulation logic associated with this action, and then start over
 * with the next action and so on.
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
 * It is an inherent property of event based simulations that the simulated behaviour of an entity
 * is distributed over several events. Thus, the traversal can be paused and scheduled to be resumed
 * after a certain delay. To begin a traversal, use the {@link #beginTraversal()} method. In order
 * to resume a paused traversal, use the {@link #resumeTraversal()} method. The resume method can be
 * called on a fresh instance, which is possible due to the so called traversal context. This
 * context carries the whole status of the traversal, i.e. which action is the next, which one has
 * just been traversed and so on. See {@link TraversalState}.
 * <p>
 * Clients can register themselves to receive traversal events. Events are fired whenever an action
 * is about to be traversed and when the traversal of an action has been completed. See
 * {@link ITraversalListener}.
 * 
 * @author Philipp Merkle
 * 
 * @param <A>
 *            the parent type of all actions that are intended to be traversed
 * @param <E>
 *            the type of the entity whose behaviour is simulated by the traversal
 */
public abstract class BehaviourTraversal<A extends Entity, E extends EventSimEntity> {

    private static Logger logger = Logger.getLogger(BehaviourTraversal.class);

    /** holds the whole state of the traversal */
    protected TraversalState<A> state;

    /** the entity which traverses the usage behavior */
    protected final E entity;

    public BehaviourTraversal(final E entity, final TraversalState<A> state) {
        this.entity = entity;
        this.state = state;
    }

    /**
     * Starts the traversal without restoring the traversal state.
     */
    public abstract void beginTraversal();

    /**
     * Resumes the traversal after it has been paused. The traversal is restored according to the
     * state described by the traversal context.
     */
    public abstract void resumeTraversal();

    /**
     * Begins or resumes the traversal with the specified action.
     * 
     * @param firstAction
     *            the action with which to start the traversal
     */
    protected void traverse(A firstAction) {
        A currentAction = firstAction;
        while (currentAction != null) {
            // obtain the traversal strategy for the current action
            final ITraversalStrategy<A, A, E> t = this.obtainTraversalStrategy(currentAction.eClass());
            if (t == null) {
                throw new TraversalException("No traversal strategy could be found for "
                        + PCMEntityHelper.toString(currentAction));
            }

            // notify traversal listeners. Do not change the order!
            this.notifyAfterListenerAboutFinishedActions(currentAction);
            this.notifyBeforeListenerAboutStartedActions(currentAction);

            // traverse the current action
            if (logger.isDebugEnabled()) {
                logger.debug("Traversing action " + PCMEntityHelper.toString(currentAction) + " at t="
                        + this.entity.getModel().getSimulationControl().getCurrentSimulationTime());
            }
            final ITraversalInstruction<A> instruction = t.traverse(currentAction, this.entity, this.state);

            // set the next action to be traversed according to the instructions provided by the
            // current traversal strategy
            final A nextAction = instruction.process(this.state);
            currentAction = nextAction;

            // check whether the traversal should be stopped
            if (nextAction == null && instruction instanceof EndTraversal<?>) {
                endTraversal();
            }
        }
    }

    private void endTraversal() {
        while (this.state.getStack().currentScope().hasFinishedActions()) {
            final A action = this.state.getStack().currentScope().dequeueFinishedAction();
            this.notifyAfterListener(action, this.entity);
        }
        this.state.getStack().leaveScope();
        this.entity.notifyLeftSystem();
    }

    /**
     * Notifies the before listeners, if 1) the current action is the first action that is to be
     * traversed or 2) the previously traversed action differs from the current action. In this way,
     * no notifications are fired when the same action is traversed repeatedly.
     * 
     * @param currentAction
     *            the action, which is about to be traversed
     */
    private void notifyBeforeListenerAboutStartedActions(final A currentAction) {
        final TraversalStackFrame<A> currentScope = this.state.getStack().currentScope();
        if (currentScope.getPreviousPosition() == null
                || !currentScope.getPreviousPosition().getId().equals(currentAction.getId())) {
            this.notifyBeforeListener(currentAction, this.entity);
        }
    }

    private void notifyAfterListenerAboutFinishedActions(final A currentAction) {
        final TraversalStackFrame<A> currentScope = this.state.getStack().currentScope();
        while (currentScope.hasFinishedActions()) {
            final A action = currentScope.dequeueFinishedAction();
            if (!action.getId().equals(currentAction.getId())) {
                this.notifyAfterListener(action, this.entity);
            }
        }
    }

    /**
     * Returns the entity whose behaviour is to be simulated.
     * 
     * @return the simulated entity
     */
    public E getEntity() {
        return entity;
    }

    /**
     * This method has to be implemented by subclasses in order to provide a corresponding traversal
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
     */
    public abstract void notifyBeforeListener(A action, E entity);

    /**
     * This method is called whenever a simulated entity has completed the traversal of an action.
     * Implementors have to notify registered event listeners.
     * 
     * @param action
     *            the action which has been traversed
     * @param entity
     *            the simulated entity whose behaviour is being simulated by the traversal
     */
    public abstract void notifyAfterListener(A action, E entity);

}