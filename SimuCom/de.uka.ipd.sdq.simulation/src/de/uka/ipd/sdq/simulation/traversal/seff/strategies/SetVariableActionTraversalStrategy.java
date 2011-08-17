package de.uka.ipd.sdq.simulation.traversal.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.util.ParameterHelper;

/**
 * This traversal strategy is responsible for {@link SetParameterAction}s.
 * 
 * @author Philipp Merkle
 *
 */
public class SetVariableActionTraversalStrategy implements ISeffTraversalStrategy<SetVariableAction> {

    /**
     * {@inheritDoc}
     */
    @Override
    public ITraversalInstruction<AbstractAction> traverse(SetVariableAction action, Request entity,
            TraversalState<AbstractAction> state) {
        StackContext ctx = state.getStoExContext();
        SimulatedStackframe<Object> currentStackFrame = ctx.getStack().currentStackFrame();

        ParameterHelper.evaluateParametersAndCopyToFrame(action.getLocalVariableUsages_SetVariableAction(), currentStackFrame, currentStackFrame);

        return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
    }

}
