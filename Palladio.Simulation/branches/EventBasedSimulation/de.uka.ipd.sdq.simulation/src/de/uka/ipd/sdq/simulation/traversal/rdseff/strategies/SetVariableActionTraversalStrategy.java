package de.uka.ipd.sdq.simulation.traversal.rdseff.strategies;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simulation.context.Context;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.instructions.ITraversalInstruction;
import de.uka.ipd.sdq.simulation.traversal.instructions.TraverseNextAction;
import de.uka.ipd.sdq.simulation.traversal.rdseff.ISeffTraversalStrategy;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;
import de.uka.ipd.sdq.simulation.util.ParameterHelper;

public class SetVariableActionTraversalStrategy implements ISeffTraversalStrategy<SetVariableAction> {

    @Override
    public ITraversalInstruction<AbstractAction> traverse(SetVariableAction action, Request entity,
            TraversalState<AbstractAction> state) {
        Context ctx = entity.getContext();
        SimulatedStackframe<Object> currentStackFrame = ctx.getStack().currentStackFrame();

        for (VariableUsage u : action.getLocalVariableUsages_SetVariableAction()) {
            for (VariableCharacterisation c : u.getVariableCharacterisation_VariableUsage()) {
                String parameterUsageLHS = ParameterHelper.getId(u.getNamedReference__VariableUsage());
                if (ParameterHelper.isInnerReference(u.getNamedReference__VariableUsage())) {
                    currentStackFrame.addValue(parameterUsageLHS + "." + c.getType().toString(), new EvaluationProxy(c
                            .getSpecification_VariableCharacterisation().getSpecification(), currentStackFrame
                            .copyFrame()));
                } else {
                    currentStackFrame.addValue(parameterUsageLHS + "." + c.getType().toString(), ctx.evaluate(c
                            .getSpecification_VariableCharacterisation().getSpecification()));
                }
            }
        }

        return new TraverseNextAction<AbstractAction>(action.getSuccessor_AbstractAction());
    }

}
