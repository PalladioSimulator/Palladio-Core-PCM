package de.uka.ipd.sdq.simucomframework.variables;

import java.io.Serializable;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCacheEntry;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.StochasticExpressionEvaluationFailedException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

/**
 * StackContext is the parent of all contexts. Simulated threads carry their context with them
 * containing their stack, their resource environment, etc. This is the stack part of the story
 * 
 * @author Steffen Becker
 *
 */
public class StackContext implements Serializable {

    /**
     * Serial ID
     */
    private static final long serialVersionUID = 2031992603442903211L;

    /**
     * Mode under which to evaluate StoEx.
     */
    private VariableMode mode = VariableMode.EXCEPTION_ON_NOT_FOUND;

    private static final Logger LOGGER = Logger.getLogger(StackContext.class.getName());

    public StackContext() {
    }

    /**
     * The stack contained in this object. A Stack contains StackFrames
     */
    protected SimulatedStack<Object> stack = new SimulatedStack<Object>();

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @param expectedType
     *            Type expected by the evaluation. It tries to case the type when needed. If the
     *            type cannot be case, an evaluation exception is thrown
     * @return The value of the StoEx evaluation
     */
    public <T> T evaluate(String string, Class<T> expectedType) {
        return StackContext.evaluateStatic(string, expectedType, stack.currentStackFrame(), mode);
    }

    /**
     * Parse and evaluate the given Stoex using the current stackframe on top of the stack
     * 
     * @param string
     *            Stoex to evaluate
     * @return The value of the StoEx evaluation
     */
    public Object evaluate(String string) {
        return evaluateStatic(string, stack.currentStackFrame(), mode);
    }

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @param currentFrame
     *            The Stackframe under which the evaluation is performed
     * @return The value of the StoEx evaluation
     */
    public Object evaluate(String stoex, SimulatedStackframe<Object> currentFrame) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("About to evaluate " + stoex);
        }
        StoExCacheEntry cacheEntry = StoExCache.singleton().getEntry(stoex);
        Object result = null;
        try {
            result = new PCMStoExEvaluationVisitor(cacheEntry, currentFrame, mode, StoExCache.singleton()
                    .getProbabilityFunctionFactory()).doSwitch(cacheEntry.getParsedExpression());
        } catch (Exception ex) {
            throw new StochasticExpressionEvaluationFailedException("Evaluation of expression " + stoex + " failed.",
                    ex);
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Result " + result);
        }
        return result;
    }

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @return The value of the StoEx evaluation
     */
    public static Object evaluateStatic(String stoex) {
        return evaluateStatic(stoex, new SimulatedStackframe<Object>());
    }

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @param currentFrame
     *            The Stackframe under which the evaluation is performed
     * @return The value of the StoEx evaluation
     */
    public static Object evaluateStatic(String stoex, SimulatedStackframe<Object> currentFrame) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("About to evaluate " + stoex);
        }
        StoExCacheEntry cacheEntry = StoExCache.singleton().getEntry(stoex);
        Object result = null;
        try {
            result = new PCMStoExEvaluationVisitor(cacheEntry, currentFrame, VariableMode.EXCEPTION_ON_NOT_FOUND,
                    StoExCache.singleton().getProbabilityFunctionFactory()).doSwitch(cacheEntry.getParsedExpression());
        } catch (Exception ex) {
            throw new StochasticExpressionEvaluationFailedException("Evaluation of expression " + stoex + " failed.",
                    ex);
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Result " + result);
        }
        return result;
    }

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @param currentFrame
     *            The Stackframe under which the evaluation is performed
     * @param mode
     *            Evaluation mode to use
     * @return The value of the StoEx evaluation
     */
    public static Object evaluateStatic(String stoex, SimulatedStackframe<Object> currentFrame, VariableMode mode) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("About to evaluate " + stoex);
        }
        StoExCacheEntry cacheEntry = StoExCache.singleton().getEntry(stoex);
        Object result = null;
        try {
            result = new PCMStoExEvaluationVisitor(cacheEntry, currentFrame, mode, StoExCache.singleton()
                    .getProbabilityFunctionFactory()).doSwitch(cacheEntry.getParsedExpression());
        } catch (Exception ex) {
            throw new StochasticExpressionEvaluationFailedException("Evaluation of expression " + stoex + " failed.",
                    ex);
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Result " + result);
        }
        return result;
    }

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @param expectedType
     *            Type expected by the evaluation. It tries to case the type when needed. If the
     *            type cannot be case, an evaluation exception is thrown
     * @return The value of the StoEx evaluation
     */
    public static <T> T evaluateStatic(String string, Class<T> expectedType) {
        return evaluateStatic(string, expectedType, new SimulatedStackframe<Object>(),
                VariableMode.EXCEPTION_ON_NOT_FOUND);
    }

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @param expectedType
     *            Type expected by the evaluation. It tries to case the type when needed. If the
     *            type cannot be case, an evaluation exception is thrown
     * @param frame
     *            Stackframe to be used in the evaluation
     * @return The value of the StoEx evaluation
     */
    public static <T> T evaluateStatic(String string, Class<T> expectedType, SimulatedStackframe<Object> frame) {
        return evaluateStatic(string, expectedType, frame, VariableMode.EXCEPTION_ON_NOT_FOUND);
    }

    /**
     * Parse and evaluate the given Stoex
     * 
     * @param string
     *            Stoex to evaluate
     * @param expectedType
     *            Type expected by the evaluation. It tries to case the type when needed. If the
     *            type cannot be case, an evaluation exception is thrown
     * @param frame
     *            Stackframe to be used in the evaluation
     * @param mode
     *            Evaluation mode to use
     * @return The value of the StoEx evaluation
     */
    @SuppressWarnings("unchecked")
    public static <T> T evaluateStatic(String string, Class<T> expectedType, SimulatedStackframe<Object> frame,
            VariableMode mode) {
        Object result = evaluateStatic(string, frame, mode);
        if (expectedType.isInstance(result)) {
            return (T) result;
        }
        /*
         * Support default (auto-)conversion hierarchy char/byte -> short -> int -> long -> float ->
         * double
         */
        if (expectedType == Byte.class) {
            if (result.getClass() == Character.class) {
                return (T) Byte.valueOf((byte) ((Character) result).charValue());
            }
        }
        if (expectedType == Character.class) {
            if (result.getClass() == Byte.class) {
                return (T) Character.valueOf((char) ((Byte) result).byteValue());
            }
        }
        if (expectedType == Short.class) {
            if (result.getClass() == Byte.class) {
                return (T) Short.valueOf(((Byte) result).shortValue());
            }
            if (result.getClass() == Character.class) {
                return (T) Short.valueOf(Byte.valueOf((byte) ((Character) result).charValue()).shortValue());
            }
        }
        if (expectedType == Integer.class) {
            if (result.getClass() == Byte.class) {
                return (T) Integer.valueOf(((Byte) result).intValue());
            }
            if (result.getClass() == Short.class) {
                return (T) Integer.valueOf(((Short) result).intValue());
            }
            if (result.getClass() == Character.class) {
                return (T) Integer.valueOf(Byte.valueOf((byte) ((Character) result).charValue()).intValue());
            }
        }
        if (expectedType == Long.class) {
            if (result.getClass() == Byte.class) {
                return (T) Long.valueOf(((Byte) result).longValue());
            }
            if (result.getClass() == Short.class) {
                return (T) Long.valueOf(((Short) result).longValue());
            }
            if (result.getClass() == Integer.class) {
                return (T) Long.valueOf(((Integer) result).longValue());
            }
            if (result.getClass() == Character.class) {
                return (T) Long.valueOf(Byte.valueOf((byte) ((Character) result).charValue()).longValue());
            }
        }
        if (expectedType == Float.class) {
            if (result.getClass() == Byte.class) {
                return (T) Float.valueOf(((Byte) result).floatValue());
            }
            if (result.getClass() == Short.class) {
                return (T) Float.valueOf(((Short) result).floatValue());
            }
            if (result.getClass() == Integer.class) {
                return (T) Float.valueOf(((Integer) result).floatValue());
            }
            if (result.getClass() == Long.class) {
                return (T) Float.valueOf(((Long) result).floatValue());
            }
            if (result.getClass() == Character.class) {
                return (T) Float.valueOf(Byte.valueOf((byte) ((Character) result).charValue()).floatValue());
            }
        }
        if (expectedType == Double.class) {
            if (result.getClass() == Byte.class) {
                return (T) Double.valueOf(((Byte) result).doubleValue());
            }
            if (result.getClass() == Short.class) {
                return (T) Double.valueOf(((Short) result).doubleValue());
            }
            if (result.getClass() == Integer.class) {
                return (T) Double.valueOf(((Integer) result).doubleValue());
            }
            if (result.getClass() == Long.class) {
                return (T) Double.valueOf(((Long) result).doubleValue());
            }
            if (result.getClass() == Float.class) {
                return (T) Double.valueOf(((Float) result).doubleValue());
            }
            if (result.getClass() == Character.class) {
                return (T) Double.valueOf(Byte.valueOf((byte) ((Character) result).charValue()).doubleValue());
            }
        }
        UnsupportedOperationException ex = new UnsupportedOperationException("Evaluation result is of type "
                + result.getClass().getCanonicalName() + " but expected was " + expectedType.getCanonicalName()
                + " and no conversion was available...");
        if (LOGGER.isEnabledFor(Level.ERROR)) {
            LOGGER.error("Evaluation of an expression resulted in wrong type!", ex);
        }
        throw ex;
    }

    /**
     * Evaluate all EvaluationProxies starting with "variable name" and store the results in the
     * given stack frame
     * 
     * @param frame
     *            The frame which stores the evaluated proxy results
     * @param variablename
     */
    public void evaluateInner(SimulatedStackframe<Object> frame, String variablename) {
        SimulatedStackframe<Object> topmostFrame = this.getStack().currentStackFrame();
        for (Entry<String, Object> e : topmostFrame.getContents()) {
            if (e.getKey().startsWith(variablename)) {
                if (e.getValue() instanceof EvaluationProxy) {
                    EvaluationProxy proxy = (EvaluationProxy) e.getValue();
                    Object result = StackContext.evaluateStatic(proxy.getStoEx(), proxy.getStackFrame(), mode);
                    frame.addValue(e.getKey(), result);
                }
            }
        }
    }

    /**
     * @return The current stack
     */
    public SimulatedStack<Object> getStack() {
        return stack;
    }

    /**
     * @return Current evaluation mode
     */
    public VariableMode getEvaluationMode() {
        return mode;
    }

    /**
     * Set the evaluation method
     * 
     * @param mode
     *            The new evaluation method to set
     */
    public void setEvaluationMode(VariableMode mode) {
        this.mode = mode;
    }

}
