package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Calculates the minimum of a value and given absolute and relative deviations. This function has
 * three parameters. The first parameter is the value, the second on the absolute deviation, and the
 * third one the relative deviation.
 * 
 * @author groenda
 */
public class MinDeviationFunction implements IFunction {
    /** Logger for this class. */
    private static final Logger logger = Logger.getLogger(MinDeviationFunction.class);

    /** Name used in the stochastic expression for this function. */
    public static final String MIN_DEVIATION_FUNCTION_NAME = "MinDeviation";

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.simucomframework.variables.functions.IFunction#checkParameters(java.util.List)
     */
    public boolean checkParameters(List<Object> parameters) {
        if (parameters.size() != 3)
            return false;
        if (!(parameterIsNumber(parameters.get(0)) || parameters.get(0) instanceof String)) {
            return false;
        }
        if (!(parameters.get(1) instanceof Double)) {
            return false;
        }
        if (!(parameters.get(2) instanceof Double)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the given parameter is a number. Valid numbers are of the types {@link Integer},
     * {@link Long}, {@link Float}, and {@link Double}.
     * 
     * @param obj
     *            Parameter.
     * @return {@code true} if, and only if, the parameter is a number.
     */
    private boolean parameterIsNumber(Object obj) {
        boolean valid = false;
        if (obj instanceof Integer || obj instanceof Byte || obj instanceof Character || obj instanceof Long
                || obj instanceof Float || obj instanceof Double) {
            valid = true;
        }
        return valid;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.variables.functions.IFunction#evaluate(java.util.List)
     */
    public Object evaluate(List<Object> parameters) {
        Object value = parameters.get(0);
        if (value instanceof String) {
            if (logger.isDebugEnabled())
                logger.debug("String/Enum-based parameter was provided to MinDeviation Function. The parameter will be directly returned.");
            return value;
        }
        Double abs = (Double) parameters.get(1);
        Double rel = (Double) parameters.get(2);
        if (value instanceof Integer) {
            Integer val = (Integer) value;
            if (abs > val * rel) {
                return Double.valueOf(Math.floor(val - abs)).intValue();
            } else {
                return Double.valueOf(Math.floor(val - val * rel)).intValue();
            }
        } else if (value instanceof Long) {
            Long val = (Long) value;
            if (abs > val * rel) {
                return Double.valueOf(Math.floor(val - abs)).longValue();
            } else {
                return Double.valueOf(Math.floor(val - val * rel)).longValue();
            }
        } else if (value instanceof Byte) {
            Byte val = (Byte) value;
            if (abs > val * rel) {
                return Double.valueOf(Math.floor(val - abs)).byteValue();
            } else {
                return Double.valueOf(Math.floor(val - val * rel)).byteValue();
            }
        } else if (value instanceof Character) {
            Character val = (Character) value;
            if (abs > val * rel) {
                return Double.valueOf(Math.floor(val - abs)).byteValue();
            } else {
                return Double.valueOf(Math.floor(val - val * rel)).byteValue();
            }
        } else if (value instanceof Float) {
            Float val = (Float) value;
            if (abs > val * rel) {
                return Double.valueOf(Math.floor(val - abs)).floatValue();
            } else {
                return Double.valueOf(Math.floor(val - val * rel)).floatValue();
            }
        } else if (value instanceof Double) {
            Double val = (Double) value;
            if (abs > val * rel) {
                return Double.valueOf(Math.floor(val - abs));
            } else {
                return Double.valueOf(Math.floor(val - val * rel));
            }
        } else {
            throw new IllegalArgumentException("Unsupported type of value argument experienced.");
        }
    }

}
