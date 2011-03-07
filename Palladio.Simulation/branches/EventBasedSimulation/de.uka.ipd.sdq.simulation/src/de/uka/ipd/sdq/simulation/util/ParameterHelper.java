package de.uka.ipd.sdq.simulation.util;

import java.util.List;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.VariableReference;

public class ParameterHelper {

    public static boolean isInnerReference(AbstractNamedReference reference) {
        if (VariableReference.class.isInstance(reference)) {
            VariableReference r = (VariableReference) reference;
            return r.getReferenceName().equals("INNER");
        } else if (NamespaceReference.class.isInstance(reference)) {
            NamespaceReference r = (NamespaceReference) reference;
            return r.getReferenceName().equals("INNER") || isInnerReference(r.getInnerReference_NamespaceReference());
        }
        return false;
    }

    public static String getId(AbstractNamedReference reference) {
        if (VariableReference.class.isInstance(reference)) {
            VariableReference r = (VariableReference) reference;
            return r.getReferenceName();
        } else if (NamespaceReference.class.isInstance(reference)) {
            NamespaceReference r = (NamespaceReference) reference;
            return r.getReferenceName() + "." + getId(r.getInnerReference_NamespaceReference());
        }
        assert false : "This position should never be reached.";
        return null; // just to satisfy the compiler
    }

    /**
     * Evaluates the passed parameters in the context of the source frame and copies the results to
     * the targetFrame. INNER characterisations are not evaluated directly, but are instead
     * encapsulated in an {@link EvaluationProxy} which are being repeatedly evaluated on every
     * access.
     * 
     * @author Steffen Becker (this code has been taken from the SimuCom Xpand templates)
     */
    public static void evaluateParametersAndCopyToFrame(List<VariableUsage> parameters,
            SimulatedStackframe<Object> sourceFrame, SimulatedStackframe<Object> targetFrame) {
        for (VariableUsage u : parameters) {
            for (VariableCharacterisation c : u.getVariableCharacterisation_VariableUsage()) {
                String parameterUsageLHS = ParameterHelper.getId(u.getNamedReference__VariableUsage());
                if (ParameterHelper.isInnerReference(u.getNamedReference__VariableUsage())) {
                    targetFrame.addValue(parameterUsageLHS + "." + c.getType().toString(), new EvaluationProxy(c
                            .getSpecification_VariableCharacterisation().getSpecification(), sourceFrame.copyFrame()));
                } else {
                    targetFrame.addValue(parameterUsageLHS + "." + c.getType().toString(), StackContext.evaluateStatic(
                            c.getSpecification_VariableCharacterisation().getSpecification(), sourceFrame));
                }
            }
        }
    }

}
