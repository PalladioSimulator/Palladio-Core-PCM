package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.ITraversalStrategyState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

/**
 * This traversal strategy is responsible for {@link LoopAction}s.
 * 
 * @author Philipp Merkle
 *
 */
public class LoopActionTraversalStrategy implements ISeffTraversalStrategy<LoopAction> {

    private static Logger logger = Logger.getLogger(LoopActionTraversalStrategy.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractAction> traverse(final LoopAction loop, final Request request,
            final TraversalState<AbstractAction> state) {
        // restore or create state
        LoopActionTraversalState internalState = (LoopActionTraversalState) state.getStack().currentScope().getInternalState(loop);
        if (internalState == null) {
            internalState = this.initialiseState(request, loop, state);
        }

        if (!this.doneAllIterations(internalState)) {
            if (logger.isDebugEnabled()) {
                logger.debug("Traversing iteration " + internalState.getCurrentIteration() + " of "
                        + internalState.getOverallIterations());
            }
            
            // traverse the body behaviour
            internalState.incrementCurrentIteration();
            final ResourceDemandingBehaviour behaviour = loop.getBodyBehaviour_Loop();
            return new TraverseResourceDemandingBehaviour(request.getModel(), behaviour, state.getStack()
                    .currentScope().getComponent(), loop);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("Completed loop traversal");
            }
            return new TraverseNextAction<AbstractAction>(loop.getSuccessor_AbstractAction());
        }
    }

    private LoopActionTraversalState initialiseState(final Request request, final LoopAction loop,
            final TraversalState<AbstractAction> state) {
        // evaluate the iteration count
        final PCMRandomVariable loopCountRandVar = loop.getIterationCount_LoopAction();
        final Integer overallIterations = state.getStoExContext().evaluate(loopCountRandVar.getSpecification(),
                Integer.class);

        // create and set state
        final LoopActionTraversalState internalState = new LoopActionTraversalState(overallIterations);
        state.getStack().currentScope().addInternalState(loop, internalState);

        return internalState;
    }

    private boolean doneAllIterations(final LoopActionTraversalState state) {
        return state.getCurrentIteration() > state.getOverallIterations();
    }

    private class LoopActionTraversalState implements ITraversalStrategyState {

        private int currentIteration;
        private final int overallIterations;

        public LoopActionTraversalState(final int overallIterations) {
            this.overallIterations = overallIterations;
            this.currentIteration = 1;
        }

        public int getCurrentIteration() {
            return this.currentIteration;
        }

        public void incrementCurrentIteration() {
            this.currentIteration++;
        }

        public int getOverallIterations() {
            return this.overallIterations;
        }

    }

}
