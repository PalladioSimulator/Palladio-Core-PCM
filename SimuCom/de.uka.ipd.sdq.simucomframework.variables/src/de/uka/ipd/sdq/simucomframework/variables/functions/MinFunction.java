package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Implements the minimum function as in @link{@link Math}, e.g. {@link Math#min(double, double)}.
 * 
 * @author groenda
 */
public class MinFunction implements IFunction {
    /** Logger for this class. */
    private static final Logger logger = Logger.getLogger(MinFunction.class);

    /** Name used in the stochastic expression for this function. */
    public static final String MIN_FUNCTION_NAME = "Min";

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.simucomframework.variables.functions.IFunction#checkParameters(java.util.List)
     */
    public boolean checkParameters(List<Object> parameters) {
        if (parameters.size() != 2)
            return false;
        boolean valid = false;
        valid = parameterIsNumber(parameters.get(0)) || parameters.get(0) instanceof String;
        valid &= parameterIsNumber(parameters.get(1));
        valid &= parameters.get(0).getClass().isInstance(parameters.get(1));
        return valid;
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
        if (obj instanceof Integer || obj instanceof Long || obj instanceof Float || obj instanceof Double) {
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
        if (parameters.get(0) instanceof Double || parameters.get(1) instanceof Double) {
            return Math.min((Double) parameters.get(0), (Double) parameters.get(1));
        } else if (parameters.get(0) instanceof Long || parameters.get(1) instanceof Long) {
            return Math.min((Long) parameters.get(0), (Long) parameters.get(1));
        } else if (parameters.get(0) instanceof Integer || parameters.get(1) instanceof Integer) {
            return Math.min((Integer) parameters.get(0), (Integer) parameters.get(1));
        } else if (parameters.get(0) instanceof Float || parameters.get(1) instanceof Float) {
            return Math.min((Float) parameters.get(0), (Float) parameters.get(1));
        } else if (parameters.get(0) instanceof String) {
            if (logger.isDebugEnabled())
                logger.debug("String/Enum-based parameter was provided to Min function. The parameter will be returned directly.");
            return parameters.get(0);
        } else {
            throw new IllegalArgumentException(
                    "Both parameters must have the same type and have one of the type Integer, Long, Float, or Double.");
        }
    }

}
