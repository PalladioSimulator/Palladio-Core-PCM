package edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.strategies;

import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.Delay;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import edu.kit.ipd.sdq.eventsim.core.palladio.state.UserState;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.ITraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.instructions.InterruptTraversal;
import edu.kit.ipd.sdq.eventsim.workload.EventSimWorkloadModel;
import edu.kit.ipd.sdq.eventsim.workload.entities.User;
import edu.kit.ipd.sdq.eventsim.workload.events.ResumeUsageTraversalEvent;

/**
 * This traversal strategy is responsible for {@link Delay} actions.
 * 
 * @author Philipp Merkle
 * 
 */
public class DelayTraversalStrategy implements ITraversalStrategy<AbstractUserAction, Delay, User, UserState> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractUserAction, UserState> traverse(final Delay delay, final User user, final UserState state) {
        // evaluate StoEx
        final PCMRandomVariable delayTimeSpecification = delay.getTimeSpecification_Delay();
        final double delayTime = NumberConverter.toDouble(StackContext.evaluateStatic(delayTimeSpecification.getSpecification()));

        // schedule the traversal to continue after the desired delay
        new ResumeUsageTraversalEvent((EventSimWorkloadModel) user.getEventSimModel(), state).schedule(user, delayTime);

        return new InterruptTraversal<>(delay.getSuccessor());
    }

}
