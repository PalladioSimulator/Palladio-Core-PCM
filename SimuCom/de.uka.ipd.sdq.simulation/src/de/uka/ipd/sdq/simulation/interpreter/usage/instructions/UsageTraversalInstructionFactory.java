package de.uka.ipd.sdq.simulation.interpreter.usage.instructions;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.interpreter.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.interpreter.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.interpreter.instructions.TraverseAfterLeavingScope;
import de.uka.ipd.sdq.simulation.interpreter.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.interpreter.state.UserState;
import de.uka.ipd.sdq.simulation.interpreter.usage.IUsageTraversalInstruction;

public class UsageTraversalInstructionFactory {

    private static EndUsageTraversal END_USAGE_TRAVERSAL = new EndUsageTraversal();
    private static TraverseUsageAfterLeavingScope TRAVERSE_USAGE_AFTER_LEAVING_SCOPE = new TraverseUsageAfterLeavingScope();

    public static EndUsageTraversal endTraversal() {
        return END_USAGE_TRAVERSAL;
    }

    public static InterruptUsageTraversal interruptTraversal(AbstractUserAction resumeAction) {
        return new InterruptUsageTraversal(resumeAction);
    }

    public static TraverseUsageAfterLeavingScope traverseAfterLeavingScope() {
        return TRAVERSE_USAGE_AFTER_LEAVING_SCOPE;
    }

    public static TraverseNextUsageAction traverseNextAction(AbstractUserAction nextAction) {
        return new TraverseNextUsageAction(nextAction);
    }

    public static TraverseUsageBehaviourInstruction traverseScenarioBehaviour(final EventSimModel model,
            final ScenarioBehaviour behaviour, final AbstractUserAction actionAfterCompletion) {
        return new TraverseUsageBehaviourInstruction(model, behaviour, actionAfterCompletion);
    }

    public static class EndUsageTraversal extends EndTraversal<AbstractUserAction, UserState> implements
            IUsageTraversalInstruction {
    }

    public static class InterruptUsageTraversal extends InterruptTraversal<AbstractUserAction, UserState>
            implements IUsageTraversalInstruction {
        public InterruptUsageTraversal(AbstractUserAction resumeAction) {
            super(resumeAction);
        }
    }

    public static class TraverseUsageAfterLeavingScope extends
            TraverseAfterLeavingScope<AbstractUserAction, UserState> implements IUsageTraversalInstruction {
    }

    public static class TraverseNextUsageAction extends TraverseNextAction<AbstractUserAction, UserState>
            implements IUsageTraversalInstruction {
        public TraverseNextUsageAction(AbstractUserAction nextAction) {
            super(nextAction);
        }
    }

}
