package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;
import de.uka.ipd.sdq.simulation.command.rdseff.FindActionInSEFF;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class TraverseResourceDemandingBehaviour implements ITraversalInstruction<AbstractAction> {

    private final EventSimModel model;
    private final SimulatedComponentInstance component;
    private final AbstractAction actionAfterCompletion;
    private final ResourceDemandingBehaviour behaviour;

    /**
     * 
     * @param model
     * @param behaviour
     * @param component
     * @param actionAfterCompletion
     *            the action which is to be executed when the behaviour has been traversed
     *            completely
     */
    public TraverseResourceDemandingBehaviour(final EventSimModel model, final ResourceDemandingBehaviour behaviour,
            final SimulatedComponentInstance component, final AbstractAction actionAfterCompletion) {
        this.model = model;
        this.component = component;
        this.behaviour = behaviour;
        this.actionAfterCompletion = actionAfterCompletion;
    }

    @Override
    public AbstractAction process(final TraversalState<AbstractAction> state) {
        final TraversalStackFrame<AbstractAction> scope = state.getStack().currentScope();
        scope.setPreviousPosition(state.getStack().currentScope().getCurrentPosition());
        scope.setCurrentPosition(this.actionAfterCompletion);

        final StartAction startAction = this.model.execute(new FindActionInSEFF<StartAction>(this.behaviour,
                StartAction.class));
        state.getStack().enterScope(new TraversalStackFrame<AbstractAction>());
        state.getStack().currentScope().setCurrentPosition(startAction);
        state.getStack().currentScope().setComponent(this.component);

        return startAction;
    }

}
