package de.uka.ipd.sdq.simulation.traversal.usage.strategies;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import de.uka.ipd.sdq.simulation.entities.User;
import de.uka.ipd.sdq.simulation.events.ResumeUsageTraversalEvent;
import de.uka.ipd.sdq.simulation.traversal.state.UserState;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.usage.IUsageTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.usage.instructions.UsageTraversalInstructionFactory;

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
    public IUsageTraversalInstruction traverse(final Delay delay, final User user, final UserState state) {
        // evaluate StoEx
        final PCMRandomVariable delayTimeSpecification = delay.getTimeSpecification_Delay();
        final double delayTime = NumberConverter.toDouble(StackContext.evaluateStatic(delayTimeSpecification
                .getSpecification()));

        // schedule the traversal to continue after the desired delay
        new ResumeUsageTraversalEvent(user.getModel(), state).schedule(user, delayTime);

        return UsageTraversalInstructionFactory.interruptTraversal(delay.getSuccessor());
    }

}
