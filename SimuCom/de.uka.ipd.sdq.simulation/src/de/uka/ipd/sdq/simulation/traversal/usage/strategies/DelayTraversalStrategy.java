package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.events.ResumeUsageTraversalEvent;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;

/**
 * This traversal strategy is responsible for {@link Delay} actions.
 * 
 * @author Philipp Merkle
 *
 */
public class DelayTraversalStrategy implements IUsageTraversalStrategy<Delay> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractUserAction> traverse(final Delay delay, final User user,
            final TraversalState<AbstractUserAction> state) {
        // evaluate StoEx
        final PCMRandomVariable delayTimeSpecification = delay.getTimeSpecification_Delay();
        final double delayTime = NumberConverter.toDouble(StackContext.evaluateStatic(delayTimeSpecification
                .getSpecification()));

        // schedule the traversal to continue after the desired delay
        new ResumeUsageTraversalEvent(user.getModel(), state).schedule(user, delayTime);

        return new InterruptTraversal<AbstractUserAction>(delay.getSuccessor());
    }

}
