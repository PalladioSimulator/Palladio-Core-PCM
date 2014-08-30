package de.uka.ipd.sdq.simucomframework.accuracy;

import de.fzi.se.accuracy.issues.AccuracyIssueFactory;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

/**
 * Tools which help to analyze the accuracy influence in the simucomframework.
 *
 * @author groenda
 */
public class AccuracyAnalysisHelper {

    /**
     * Checks that the value for an ID in the stack frame is within the specified bounds.
     * 
     * @param config
     *            Issues will be reported to this instance.
     * @param stackframe
     *            The stack frame.
     * @param simuComId
     *            The ID.
     * @param rdseffId
     *            The UUID of the RD-SEFF in which the variable was accessed.
     * @param actionId
     *            UUID of the {@link AbstractAction} for which a message was recorded.
     * @param resourceName
     *            The location of the resource.
     * @param from
     *            Lower bound (inclusive).
     * @param to
     *            Upper bound (inclusive)
     */
    public static void checkBoundsInterval(String partitionId, String partitionResourceName, SimuComModel config,
            SimulatedStackframe<Object> stackframe, String simuComId, String rdseffId, String actionId,
            String resourceName, String from, String to) {
        Object value;
        try {
            value = stackframe.getValue(simuComId);
            if (value.getClass() == EvaluationProxy.class) {
                value = StackContext.evaluateStatic(((EvaluationProxy) value).getStoEx());
            }
        } catch (ValueNotInFrameException e) {
            config.addIssue(AccuracyIssueFactory
                    .createCharacterisedPCMParameterPartition(
                            "The partition referenced the variable "
                                    + simuComId
                                    + " which was not accessible during runtime. Correct the quality information or PCM model.",
                            partitionResourceName, partitionId));
            return;
        }
        if (value instanceof Byte) {
            if ((Byte) value >= StackContext.evaluateStatic(from, Byte.class)
                    && (Byte) value <= StackContext.evaluateStatic(to, Byte.class)) {
                // within bounds. do nothing.
            } else {
                config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId,
                        resourceName, value, actionId));
            }
        } else if (value instanceof Character) {
            if ((Character) value >= StackContext.evaluateStatic(from, Character.class)
                    && (Character) value <= StackContext.evaluateStatic(to, Character.class)) {
                // within bounds. do nothing.
            } else {
                config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId,
                        resourceName, value, actionId));
            }
        } else if (value instanceof Short) {
            if ((Short) value >= StackContext.evaluateStatic(from, Short.class)
                    && (Short) value <= StackContext.evaluateStatic(to, Short.class)) {
                // within bounds. do nothing.
            } else {
                config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId,
                        resourceName, value, actionId));
            }
        } else if (value instanceof Integer) {
            if ((Integer) value >= StackContext.evaluateStatic(from, Integer.class)
                    && (Integer) value <= StackContext.evaluateStatic(to, Integer.class)) {
                // within bounds. do nothing.
            } else {
                config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId,
                        resourceName, value, actionId));
            }
        } else if (value instanceof Long) {
            if ((Long) value >= StackContext.evaluateStatic(from, Long.class)
                    && (Long) value <= StackContext.evaluateStatic(to, Long.class)) {
                // within bounds. do nothing.
            } else {
                config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId,
                        resourceName, value, actionId));
            }
        } else if (value instanceof Float) {
            if ((Float) value >= StackContext.evaluateStatic(from, Float.class)
                    && (Float) value <= StackContext.evaluateStatic(to, Float.class)) {
                // within bounds. do nothing.
            } else {
                config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId,
                        resourceName, value, actionId));
            }
        } else if (value instanceof Double) {
            if ((Double) value >= StackContext.evaluateStatic(from, Double.class)
                    && (Double) value <= StackContext.evaluateStatic(to, Double.class)) {
                // within bounds. do nothing.
                config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId,
                        resourceName, value, actionId));
            }
        } else {
            String msg = "The dynamic type for "
                    + simuComId
                    + " was "
                    + value.getClass().getCanonicalName()
                    + " which is not supported for interval-typed checks in accuracy influence analysis. Use CharacterisedPCMParameterPartitionRange if the value is not a numeric type.";
            config.addIssue(AccuracyIssueFactory.createTypeInferenceIssue(msg));
        }
    }

    /**
     * Checks that the value for an ID in the stack frame is within a provided list of values.
     * 
     * @param config
     *            Issues will be reported to this instance.
     * @param stackframe
     *            The stack frame.
     * @param simuComId
     *            The ID.
     * @param rdseffId
     *            The UUID of the RD-SEFF in which the variable was accessed.
     * @param resourceName
     *            The location of the resource.
     * @param actionId
     *            UUID of the {@link AbstractAction} in which the variable was accessed.
     * @param specifications
     *            Valid values.
     */
    public static void checkBoundsRange(String partitionId, String partitionResourceName, SimuComModel config,
            SimulatedStackframe<Object> stackframe, String simuComId, String rdseffId, String actionId,
            String resourceName, String... specifications) {
        Object value;
        try {
            value = stackframe.getValue(simuComId);
            if (value.getClass() == EvaluationProxy.class) {
                value = StackContext.evaluateStatic(((EvaluationProxy) value).getStoEx());
            }
        } catch (ValueNotInFrameException e) {
            config.addIssue(AccuracyIssueFactory
                    .createCharacterisedPCMParameterPartition(
                            "The partition referenced the variable "
                                    + simuComId
                                    + " which was not accessible during runtime. Correct the quality information or PCM model.",
                            partitionResourceName, partitionId));
            return;
        }
        Class<?> clazz = value.getClass();
        boolean found = false;
        // The value must match one of the provided specifications
        for (String specification : specifications) {
            if (StackContext.evaluateStatic(specification, clazz).equals(value)) {
                found = true;
                break;
            }
        }
        if (!found) {
            config.addIssue(AccuracyIssueFactory.createParameterExtrapolationIssue(simuComId, rdseffId, resourceName,
                    value, actionId));
        }
    }
}
