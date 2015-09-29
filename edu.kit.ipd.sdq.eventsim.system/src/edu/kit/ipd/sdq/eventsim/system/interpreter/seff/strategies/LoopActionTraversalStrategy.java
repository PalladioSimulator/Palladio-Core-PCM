package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.seff.LoopAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;

import edu.kit.ipd.sdq.eventsim.interpreter.state.ITraversalStrategyState;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;

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
    public IRequestTraversalInstruction traverse(final LoopAction loop, final Request request,
            final RequestState state) {
        // restore or create state
        LoopActionTraversalState internalState = (LoopActionTraversalState) state.getInternalState(loop);
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
            return RequestTraversalInstructionFactory.traverseResourceDemandingBehaviour(request.getEventSimModel(), behaviour, state.getComponent(), loop);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("Completed loop traversal");
            }
            return RequestTraversalInstructionFactory.traverseNextAction(loop.getSuccessor_AbstractAction());
        }
    }

    private LoopActionTraversalState initialiseState(final Request request, final LoopAction loop,
            final RequestState state) {
        // evaluate the iteration count
        final PCMRandomVariable loopCountRandVar = loop.getIterationCount_LoopAction();
        final Integer overallIterations = state.getStoExContext().evaluate(loopCountRandVar.getSpecification(),
                Integer.class);

        // create and set state
        final LoopActionTraversalState internalState = new LoopActionTraversalState(overallIterations);
        state.addInternalState(loop, internalState);

        return internalState;
    }

    private boolean doneAllIterations(final LoopActionTraversalState state) {
        return state.getCurrentIteration() > state.getOverallIterations();
    }

    private static final class LoopActionTraversalState implements ITraversalStrategyState {

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
