package de.uka.ipd.sdq.simulation.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.interpreter.seff.IRequestTraversalInstruction;
import de.uka.ipd.sdq.simulation.interpreter.seff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import de.uka.ipd.sdq.simulation.interpreter.state.RequestState;
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
    public IRequestTraversalInstruction traverse(SetVariableAction action, Request entity, RequestState state) {
        StackContext ctx = state.getStoExContext();
        SimulatedStackframe<Object> currentStackFrame = ctx.getStack().currentStackFrame();

        ParameterHelper.evaluateParametersAndCopyToFrame(action.getLocalVariableUsages_SetVariableAction(),
                currentStackFrame, currentStackFrame);

        return RequestTraversalInstructionFactory.traverseNextAction(action.getSuccessor_AbstractAction());
    }

}
