package edu.kit.ipd.sdq.eventsim.system.interpreter.seff.strategies;

import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import edu.kit.ipd.sdq.eventsim.system.entities.Request;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.util.ParameterHelper;

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
