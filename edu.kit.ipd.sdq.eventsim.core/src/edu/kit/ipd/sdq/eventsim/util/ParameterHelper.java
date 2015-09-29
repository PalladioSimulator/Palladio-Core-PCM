package edu.kit.ipd.sdq.eventsim.util;

import java.util.List;

import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * Provides helper methods for PCM parameters.
 * 
 * @author Steffen Becker (most of this code has been taken from the SimuCom Xpand templates)
 * @author Philipp Merkle
 * 
 */
public class ParameterHelper {

    /**
     * Returns whether the specified reference belongs to an INNER variable characterisation.
     * 
     * @param reference
     *            the named reference associated with a variable characterisation
     * @return true, if the reference's name is "INNER"; false else.
     */
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

    /**
     * Returns the name for the specified named reference.
     * 
     * @param reference
     *            the named reference
     * @return the name
     */
    public static String getVariableName(AbstractNamedReference reference) {
        if (VariableReference.class.isInstance(reference)) {
            VariableReference r = (VariableReference) reference;
            return r.getReferenceName();
        } else if (NamespaceReference.class.isInstance(reference)) {
            NamespaceReference r = (NamespaceReference) reference;
            return r.getReferenceName() + "." + getVariableName(r.getInnerReference_NamespaceReference());
        }
        assert false : "This position should never be reached.";
        return null; // just to satisfy the compiler
    }

    /**
     * Evaluates the passed parameters in the context of the source frame and copies the results to
     * the targetFrame. INNER characterisations are not evaluated directly, but are instead
     * encapsulated in an {@link EvaluationProxy} which are being repeatedly evaluated on each
     * access.
     */
    public static void evaluateParametersAndCopyToFrame(List<VariableUsage> parameters,
            SimulatedStackframe<Object> sourceFrame, SimulatedStackframe<Object> targetFrame) {
        for (VariableUsage u : parameters) {
            for (VariableCharacterisation c : u.getVariableCharacterisation_VariableUsage()) {
                String parameterUsageLHS = ParameterHelper.getVariableName(u.getNamedReference__VariableUsage());
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

    /**
     * Creates an {@link EvaluationProxy} for the passed parameters and copies them to the
     * targetFrame. The proxy evaluates the passed parameters on each access.
     * 
     * @see EvaluationProxy
     */
    public static void createEvaluationProxiesAndCopyToFrame(List<VariableUsage> parameters,
            SimulatedStackframe<Object> targetFrame) {
        for (VariableUsage u : parameters) {
            String parameterUsageLHS = ParameterHelper.getVariableName(u.getNamedReference__VariableUsage());
            for (VariableCharacterisation c : u.getVariableCharacterisation_VariableUsage()) {
                targetFrame.addValue(parameterUsageLHS + "." + c.getType().toString(), new EvaluationProxy(c
                        .getSpecification_VariableCharacterisation().getSpecification(),
                        new SimulatedStackframe<Object>()));
            }
        }
    }

}
