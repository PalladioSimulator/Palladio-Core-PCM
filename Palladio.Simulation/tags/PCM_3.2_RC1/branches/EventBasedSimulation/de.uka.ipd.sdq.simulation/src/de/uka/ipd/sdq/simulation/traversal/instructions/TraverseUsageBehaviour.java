package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.usage.FindActionInUsageBehaviour;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;

public class TraverseUsageBehaviour implements ITraversalInstruction<AbstractUserAction> {

    private final EventSimModel model;
    private final ScenarioBehaviour behaviour;
    private final AbstractUserAction actionAfterCompletion;

    public TraverseUsageBehaviour(final EventSimModel model, final ScenarioBehaviour behaviour,
            final AbstractUserAction actionAfterCompletion) {
        this.model = model;
        this.behaviour = behaviour;
        this.actionAfterCompletion = actionAfterCompletion;
    }

    @Override
    public AbstractUserAction process(final TraversalState<AbstractUserAction> context) {
        final TraversalStackFrame<AbstractUserAction> scope = context.getStack().currentScope();
        scope.setPreviousPosition(context.getStack().currentScope().getCurrentPosition());
        scope.setCurrentPosition(this.actionAfterCompletion);

        final Start start = this.model.execute(new FindActionInUsageBehaviour<Start>(this.behaviour, Start.class));
        context.getStack().enterScope(new TraversalStackFrame<AbstractUserAction>());
        context.getStack().currentScope().setCurrentPosition(start);
        return start;
    }

}
