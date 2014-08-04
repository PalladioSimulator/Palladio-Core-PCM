/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovHardwareInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovNetworkInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovTransformationResult;
import de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence;
import de.uka.ipd.sdq.sensitivity.DoubleParameterRange;
import de.uka.ipd.sdq.sensitivity.DoubleParameterSequence;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;
import de.uka.ipd.sdq.sensitivity.FailureDimension;
import de.uka.ipd.sdq.sensitivity.FailureDimensionResultSpecification;
import de.uka.ipd.sdq.sensitivity.FailureTypeResultSpecification;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;

/**
 * @author brosch
 * 
 */
public class SensitivityCalculator {

    /**
     * Log4J logging support.
     */
    private static final Logger LOGGER = Logger.getLogger(SensitivityCalculator.class.getName());

    /**
     * Calculates the current double value from a given parameter variation and step number.
     * 
     * @param variation
     *            the parameter variation
     * @param stepNumber
     *            the step number
     * @param baseValue
     *            the original value (for offset calculations)
     * @return the current value
     */
    public double calculateCurrentDoubleValue(final DoubleParameterVariation variation, final int stepNumber,
            final double baseValue) {
        if (variation instanceof DoubleParameterSequence) {
            DoubleParameterSequence sequence = (DoubleParameterSequence) variation;
            return sequence.getDoubleValues().get(stepNumber - 1);
        } else if (variation instanceof DoubleOffsetSequence) {
            DoubleOffsetSequence sequence = (DoubleOffsetSequence) variation;
            switch (sequence.getDoubleOffsetType__DoubleOffsetSequence()) {
            case ADD:
                return baseValue + sequence.getOffsetValues().get(stepNumber - 1);
            case SUBTRACT:
                return baseValue - sequence.getOffsetValues().get(stepNumber - 1);
            case MULTIPLY:
                return baseValue * sequence.getOffsetValues().get(stepNumber - 1);
            case DIVIDE:
                return baseValue / sequence.getOffsetValues().get(stepNumber - 1);
            default:
                LOGGER.error("Double offset type \"" + sequence.getDoubleOffsetType__DoubleOffsetSequence().getName()
                        + "\" not yet supported.");
                return 0.0;
            }
        } else if (variation instanceof DoubleParameterRange) {
            DoubleParameterRange range = (DoubleParameterRange) variation;
            if (range.isConsiderStepSize()) {
                return range.getFirstValue() + range.getStepSize() * (stepNumber - 1);
            } else {
                return range.getFirstValue()
                        + ((range.getLastValue() - range.getFirstValue()) / (range.getStepCount() - 1))
                        * (stepNumber - 1);
            }
        } else {
            LOGGER.error("Parameter variation type \"" + variation.eClass().toString() + "\" not yet supported.");
            return 0.0;
        }
    }

    /**
     * Calculates the current string value from a given parameter variation and step number.
     * 
     * @param sequence
     *            the parameter variation
     * @param stepNumber
     *            the step number
     * @return the current value
     */
    public String calculateCurrentStringValue(final StringParameterSequence sequence, final int stepNumber) {
        return sequence.getStringValues().get(stepNumber - 1);
    }

    /**
     * Calculates the total failure potential associated to a given sensitivity result
     * specification.
     * 
     * @param markovResult
     *            the Markov transformation result
     * @param specification
     *            the result specification
     * @return the failure potential
     */
    private double calculateFailurePotential(MarkovTransformationResult markovResult,
            FailureDimensionResultSpecification specification) {
        double result = 0.0;
        for (MarkovFailureType failureType : markovResult.getCumulatedFailureTypeProbabilities().keySet()) {
            if (isMatch(specification.getFailureDimension__FailureDimensionResultSpecification(), failureType)) {
                result += markovResult.getCumulatedFailureTypeProbabilities().get(failureType);
            }
        }
        return result;
    }

    /**
     * Calculates the total failure potential associated to a given sensitivity result
     * specification.
     * 
     * @param markovResult
     *            the Markov transformation result
     * @param specification
     *            the result specification
     * @return the failure potential
     */
    private double calculateFailurePotential(MarkovTransformationResult markovResult,
            FailureTypeResultSpecification specification) {
        double result = 0.0;
        for (MarkovFailureType failureType : markovResult.getCumulatedFailureTypeProbabilities().keySet()) {
            for (FailureType resultType : specification.getFailureTypes__FailureTypeResultSpecification()) {
                if (isMatch(failureType, resultType)) {
                    result += markovResult.getCumulatedFailureTypeProbabilities().get(failureType);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Calculates the total failure potential associated to a given sensitivity result
     * specification.
     * 
     * @param result
     *            the Markov transformation result
     * @param specification
     *            the result specification
     * @return the failure potential
     */
    public double calculateFailurePotential(final MarkovTransformationResult result,
            final SensitivityResultSpecification specification) {
        if (specification instanceof FailureTypeResultSpecification) {
            return calculateFailurePotential(result, (FailureTypeResultSpecification) specification);
        } else if (specification instanceof FailureDimensionResultSpecification) {
            return calculateFailurePotential(result, (FailureDimensionResultSpecification) specification);
        } else {
            LOGGER.error("Result specification type \"" + specification.eClass().toString() + "\" not yet supported.");
            return 0.0;
        }
    }

    /**
     * Calculates the number of steps to perform for a given parameter variation.
     * 
     * @param variation
     *            the parameter variation
     * @return the number of steps to perform
     */
    public int calculateNumberOfSteps(final SensitivityParameterVariation variation) {
        if (variation instanceof DoubleParameterRange) {
            if (((DoubleParameterRange) variation).isConsiderStepSize()) {
                DoubleParameterRange range = (DoubleParameterRange) variation;
                return (int) Math.floor(Math.abs(range.getLastValue() - range.getFirstValue())
                        / Math.abs(range.getStepSize())) + 1;
            } else {
                return ((DoubleParameterRange) variation).getStepCount();
            }
        } else if (variation instanceof DoubleParameterSequence) {
            return ((DoubleParameterSequence) variation).getDoubleValues().size();
        } else if (variation instanceof DoubleOffsetSequence) {
            return ((DoubleOffsetSequence) variation).getOffsetValues().size();
        } else if (variation instanceof StringParameterSequence) {
            return ((StringParameterSequence) variation).getStringValues().size();
        } else {
            LOGGER.error("Parameter variation type \"" + variation.eClass().toString() + "\" not yet supported.");
            return 0;
        }
    }

    /**
     * Retrieves the current log entry for a certain sensitivity step.
     * 
     * @param variation
     *            the parameter variation
     * @param stepNumber
     *            the step number
     * @return the current log entry
     */
    public String getCurrentLogEntry(final SensitivityParameterVariation variation, final int stepNumber) {
        if (variation instanceof DoubleOffsetSequence) {
            DoubleOffsetSequence sequence = (DoubleOffsetSequence) variation;
            switch (sequence.getDoubleOffsetType__DoubleOffsetSequence()) {
            case ADD:
                return "x + " + sequence.getOffsetValues().get(stepNumber - 1).toString();
            case SUBTRACT:
                return "x - " + sequence.getOffsetValues().get(stepNumber - 1).toString();
            case MULTIPLY:
                return "x * " + sequence.getOffsetValues().get(stepNumber - 1).toString();
            case DIVIDE:
                return "x / " + sequence.getOffsetValues().get(stepNumber - 1).toString();
            default:
                LOGGER.error("Double offset type \"" + sequence.getDoubleOffsetType__DoubleOffsetSequence().getName()
                        + "\" not yet supported.");
                return null;
            }
        } else if (variation instanceof DoubleParameterVariation) {
            return ((Double) calculateCurrentDoubleValue((DoubleParameterVariation) variation, stepNumber, 0.0))
                    .toString();
        } else if (variation instanceof StringParameterSequence) {
            return calculateCurrentStringValue((StringParameterSequence) variation, stepNumber);
        } else {
            LOGGER.error("Parameter variation type \"" + variation.eClass().toString() + "\" not yet supported.");
            return null;
        }
    }

    /**
     * Compares a failure dimension and a failure type with each other.
     * 
     * @param dimension
     *            the failure dimension
     * @param type
     *            the failure type
     * @return TRUE if the type is of the given dimension
     */
    private boolean isMatch(FailureDimension dimension, MarkovFailureType type) {
        return (dimension.equals(FailureDimension.SOFTWARE) && (type instanceof MarkovSoftwareInducedFailureType))
                || (dimension.equals(FailureDimension.HARDWARE) && (type instanceof MarkovHardwareInducedFailureType))
                || (dimension.equals(FailureDimension.NETWORK) && (type instanceof MarkovNetworkInducedFailureType));
    }

    /**
     * Compares a given MarkovFailureType and PCM failure type for compatibility.
     * 
     * @param failureType
     *            the MakovFailureType
     * @param resultType
     *            the PCM failure type
     * @return TRUE if both types are compatible
     */
    private boolean isMatch(MarkovFailureType failureType, FailureType resultType) {
        if ((failureType instanceof MarkovSoftwareInducedFailureType)
                && (resultType instanceof SoftwareInducedFailureType)) {
            MarkovSoftwareInducedFailureType markovSWType = (MarkovSoftwareInducedFailureType) failureType;
            SoftwareInducedFailureType swType = (SoftwareInducedFailureType) resultType;
            return markovSWType.getSoftwareFailureId().equals(swType.getId());
        } else if ((failureType instanceof MarkovHardwareInducedFailureType)
                && (resultType instanceof HardwareInducedFailureType)) {
            MarkovHardwareInducedFailureType markovHWType = (MarkovHardwareInducedFailureType) failureType;
            HardwareInducedFailureType hwType = (HardwareInducedFailureType) resultType;
            return markovHWType.getResourceTypeId().equals(
                    hwType.getProcessingResourceType__HardwareInducedFailureType().getId());
        } else if ((failureType instanceof MarkovNetworkInducedFailureType)
                && (resultType instanceof NetworkInducedFailureType)) {
            MarkovNetworkInducedFailureType markovNWType = (MarkovNetworkInducedFailureType) failureType;
            NetworkInducedFailureType nwType = (NetworkInducedFailureType) resultType;
            return markovNWType.getCommLinkResourceTypeId().equals(
                    nwType.getCommunicationLinkResourceType__NetworkInducedFailureType().getId());
        } else {
            return false;
        }
    }
}
