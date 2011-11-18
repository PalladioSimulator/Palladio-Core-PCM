package de.uka.ipd.sdq.simulation.traversal.seff.instructions;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.traversal.instructions.EndTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.InterruptTraversal;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseAfterLeavingScope;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.seff.IRequestTraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.state.RequestState;

public class RequestTraversalInstructionFactory {

    private static EndSeffTraversal END_SEFF_TRAVERSAL = new EndSeffTraversal();
    private static TraverseSeffAfterLeavingScope TRAVERSE_SEFF_AFTER_LEAVING_SCOPE = new TraverseSeffAfterLeavingScope();

    public static EndSeffTraversal endTraversal() {
        return END_SEFF_TRAVERSAL;
    }

    public static InterruptSeffTraversal interruptTraversal(AbstractAction resumeAction) {
        return new InterruptSeffTraversal(resumeAction);
    }

    public static TraverseSeffAfterLeavingScope traverseAfterLeavingScope() {
        return TRAVERSE_SEFF_AFTER_LEAVING_SCOPE;
    }

    public static TraverseNextSeffAction traverseNextAction(AbstractAction nextAction) {
        return new TraverseNextSeffAction(nextAction);
    }

    public static TraverseComponentBehaviourInstruction traverseResourceDemandingBehaviour(final EventSimModel model,
            final ResourceDemandingBehaviour behaviour, final ComponentInstance component,
            final AbstractAction actionAfterCompletion) {
        return new TraverseComponentBehaviourInstruction(model, behaviour, component, actionAfterCompletion);
    }

    public static class EndSeffTraversal extends EndTraversal<AbstractAction, RequestState> implements
            IRequestTraversalInstruction {
    }

    public static class InterruptSeffTraversal extends InterruptTraversal<AbstractAction, RequestState>
            implements IRequestTraversalInstruction {
        public InterruptSeffTraversal(AbstractAction resumeAction) {
            super(resumeAction);
        }
    }

    public static class TraverseSeffAfterLeavingScope extends
            TraverseAfterLeavingScope<AbstractAction, RequestState> implements IRequestTraversalInstruction {
    }

    public static class TraverseNextSeffAction extends TraverseNextAction<AbstractAction, RequestState>
            implements IRequestTraversalInstruction {
        public TraverseNextSeffAction(AbstractAction nextAction) {
            super(nextAction);
        }
    }

}
