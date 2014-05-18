package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.state.ITraversalStrategyState;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.IUsageTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.instructions.UsageTraversalInstructionFactory;

/**
 * This traversal strategy is responsible for {@link Loop} actions.
 * 
 * @author Philipp Merkle
 * 
 */
public class LoopTraversalStrategy implements IUsageTraversalStrategy<Loop> {

    private static Logger logger = Logger.getLogger(LoopTraversalStrategy.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public IUsageTraversalInstruction traverse(final Loop loop, final User user, final UserState state) {
        // restore or create state
        LoopTraversalState internalState = (LoopTraversalState) state.getInternalState(loop);
        if (internalState == null) {
            internalState = this.initialiseState(user, loop, state);
        }

        if (!this.doneAllIterations(internalState)) {
            if (logger.isDebugEnabled()) {
                logger.debug("Traversing iteration " + internalState.getCurrentIteration() + " of "
                        + internalState.getOverallIterations());
            }

            // traverse the body behaviour
            internalState.incrementCurrentIteration();
            final ScenarioBehaviour bheaviour = loop.getBodyBehaviour_Loop();
            return UsageTraversalInstructionFactory.traverseScenarioBehaviour(user.getEventSimModel(), bheaviour, loop);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("Completed loop traversal");
            }
            return UsageTraversalInstructionFactory.traverseNextAction(loop.getSuccessor());
        }
    }

    private LoopTraversalState initialiseState(final User user, final Loop loop, final UserState state) {
        // evaluate the iteration count
        final PCMRandomVariable loopCountRandVar = loop.getLoopIteration_Loop();
        final Integer overallIterations = StackContext.evaluateStatic(loopCountRandVar.getSpecification(),
                Integer.class);

        // create and set state
        final LoopTraversalState internalState = new LoopTraversalState(overallIterations);
        state.addInternalState(loop, internalState);

        return internalState;
    }

    private boolean doneAllIterations(final LoopTraversalState state) {
        return state.getCurrentIteration() > state.getOverallIterations();
    }

    private static final class LoopTraversalState implements ITraversalStrategyState {

        private int currentIteration;
        private final int overallIterations;

        public LoopTraversalState(final int overallIterations) {
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
