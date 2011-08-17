package de.uka.ipd.sdq.simulation.traversal.instructions;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.command.seff.FindActionInResourceDemandingBehaviour;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStackFrame;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalStateStack;

/**
 * Use this instruction to continue the traversal with a specified
 * {@link ResourceDemandingBehaviour}. This opens a new scope on the {@link TraversalStateStack}. As
 * soon as the specified behaviour has been traversed completely, the previous scope is restored.
 * 
 * @author Philipp Merkle
 * 
 */
public class TraverseResourceDemandingBehaviour implements ITraversalInstruction<AbstractAction> {

    private final EventSimModel model;
    private final ComponentInstance component;
    private final AbstractAction actionAfterCompletion;
    private final ResourceDemandingBehaviour behaviour;

    /**
     * Constructs a new instruction.
     * 
     * @param model
     *            the simulation model
     * @param behaviour
     *            the behaviour that is to be traversed in a new scope
     * @param component
     *            the component that provides the specified behaviour
     * @param actionAfterCompletion
     *            the action that is to be traversed after leaving the scope
     */
    public TraverseResourceDemandingBehaviour(final EventSimModel model, final ResourceDemandingBehaviour behaviour,
            final ComponentInstance component, final AbstractAction actionAfterCompletion) {
        this.model = model;
        this.component = component;
        this.behaviour = behaviour;
        this.actionAfterCompletion = actionAfterCompletion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractAction process(final TraversalState<AbstractAction> state) {
        final TraversalStackFrame<AbstractAction> scope = state.getStack().currentScope();
        scope.setPreviousPosition(state.getStack().currentScope().getCurrentPosition());
        scope.setCurrentPosition(this.actionAfterCompletion);

        final StartAction startAction = this.model.execute(new FindActionInResourceDemandingBehaviour<StartAction>(
                this.behaviour, StartAction.class));
        state.getStack().enterScope(new TraversalStackFrame<AbstractAction>());
        state.getStack().currentScope().setCurrentPosition(startAction);
        state.getStack().currentScope().setComponent(this.component);

        return startAction;
    }

}
