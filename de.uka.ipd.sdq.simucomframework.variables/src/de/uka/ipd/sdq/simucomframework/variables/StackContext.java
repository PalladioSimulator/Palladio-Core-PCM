package de.uka.ipd.sdq.simucomframework.variables;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCacheEntry;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.StochasticExpressionEvaluationFailedException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

/**
 * StackContext is the parent of all contexts. Simulated threads carry their
 * context with them containing their stack, their resource environment, etc.
 * This is the stack part of the story
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
	
	private static Logger logger = 
		Logger.getLogger(StackContext.class.getName());
        
    public StackContext() {}
        
	/**
	 * The stack contained in this object. A Stack contains StackFrames 
	 */
	protected SimulatedStack<Object> stack = new SimulatedStack<Object>();

	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @param expectedType Type expected by the evaluation. It tries
	 * to case the type when needed. If the type cannot be case, an evaluation
	 * exception is thrown
	 * @return The value of the StoEx evaluation
	 */
	public Object evaluate(String string, Class<?> expectedType) {
		return StackContext.evaluateStatic(string,expectedType,stack.currentStackFrame(),mode);
	}

	/**
	 * Parse and evaluate the given Stoex using the current stackframe on
	 * top of the stack
	 * @param string Stoex to evaluate
	 * @return The value of the StoEx evaluation
	 */
	public Object evaluate(String string) {
		return evaluateStatic(string,stack.currentStackFrame(),mode);
	}

	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @param currentFrame The Stackframe under which the evaluation is performed
	 * @return The value of the StoEx evaluation
	 */
	public Object evaluate(String stoex, SimulatedStackframe<Object> currentFrame) {
		StoExCacheEntry cacheEntry = StoExCache.singleton().getEntry(stoex);
		Object result = null;
		try {
			 result = new PCMStoExEvaluationVisitor(stoex,currentFrame,mode)
						.doSwitch(cacheEntry.getParsedExpression());
		} catch (Exception ex) {
			throw new StochasticExpressionEvaluationFailedException("Evaluation of expression "+stoex+" failed.",ex);
		}
		return result;
	}

	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @return The value of the StoEx evaluation
	 */
	public static Object evaluateStatic(String stoex) {
		return evaluateStatic(stoex, new SimulatedStackframe<Object>());
	}

	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @param currentFrame The Stackframe under which the evaluation is performed
	 * @return The value of the StoEx evaluation
	 */
	public static Object evaluateStatic(String stoex, SimulatedStackframe<Object> currentFrame) {
		StoExCacheEntry cacheEntry = StoExCache.singleton().getEntry(stoex);
		Object result = null;
		try {
			result = new PCMStoExEvaluationVisitor(stoex,currentFrame,VariableMode.EXCEPTION_ON_NOT_FOUND)
					.doSwitch(cacheEntry.getParsedExpression());
		} catch (Exception ex) {
			throw new StochasticExpressionEvaluationFailedException("Evaluation of expression "+stoex+" failed.",ex);
		}
		return result;
	}

	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @param currentFrame The Stackframe under which the evaluation is performed
	 * @param mode Evaluation mode to use
	 * @return The value of the StoEx evaluation
	 */
	public static Object evaluateStatic(String stoex, SimulatedStackframe<Object> currentFrame, VariableMode mode) {
		StoExCacheEntry cacheEntry = StoExCache.singleton().getEntry(stoex);
		Object result = null;
		try {
			result = new PCMStoExEvaluationVisitor(stoex,currentFrame,mode)
					.doSwitch(cacheEntry.getParsedExpression());
		} catch (Exception ex) {
			throw new StochasticExpressionEvaluationFailedException("Evaluation of expression "+stoex+" failed.",ex);
		}
		return result;
	}

	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @param expectedType Type expected by the evaluation. It tries
	 * to case the type when needed. If the type cannot be case, an evaluation
	 * exception is thrown
	 * @return The value of the StoEx evaluation
	 */
	public static Object evaluateStatic(String string, Class<?> expectedType) {
		return evaluateStatic(string,expectedType,new SimulatedStackframe<Object>(),VariableMode.EXCEPTION_ON_NOT_FOUND);
	}

	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @param expectedType Type expected by the evaluation. It tries
	 * to case the type when needed. If the type cannot be case, an evaluation
	 * exception is thrown
	 * @param frame Stackframe to be used in the evaluation
	 * @return The value of the StoEx evaluation
	 */
	public static Object evaluateStatic(String string, Class<?> expectedType, SimulatedStackframe<Object> frame) {
		return evaluateStatic(string,expectedType,frame,VariableMode.EXCEPTION_ON_NOT_FOUND);
	}
	
	/**
	 * Parse and evaluate the given Stoex
	 * @param string Stoex to evaluate
	 * @param expectedType Type expected by the evaluation. It tries
	 * to case the type when needed. If the type cannot be case, an evaluation
	 * exception is thrown
	 * @param frame Stackframe to be used in the evaluation
	 * @param mode Evaluation mode to use
	 * @return The value of the StoEx evaluation
	 */
	public static Object evaluateStatic(String string, Class<?> expectedType, SimulatedStackframe<Object> frame,VariableMode mode) {
		logger.debug("About to evaluate "+string);
		Object result = evaluateStatic(string,frame,mode);
		logger.debug("Result "+result);
		if (expectedType.isInstance(result))
			return result;
		if (expectedType == Double.class && result.getClass() == Integer.class)
			return ((Integer)result).doubleValue();
		UnsupportedOperationException ex = new UnsupportedOperationException("Evaluation result is of type "+result.getClass().getCanonicalName()+
				" but expected was "+expectedType.getCanonicalName()+ " and no conversion was available..."); 
		logger.error("Evaluation of an expression resulted in wrong type!",ex);
		throw ex; 
	}
	
	/**
	 * Evaluate all EvaluationProxies starting with "variable name" and store the 
	 * results in the given stack frame
	 * @param frame The frame which stores the evaluated proxy results
	 * @param variablename
	 */
	public void evaluateInner(SimulatedStackframe<Object> frame, String variablename) {
		SimulatedStackframe<Object> topmostFrame = this.getStack().currentStackFrame();
		for(Entry<String,Object> e : (Collection<Entry<String,Object>>)topmostFrame.getContents()) {
			if (e.getKey().startsWith(variablename)) {
				if (e.getValue() instanceof EvaluationProxy) {
					EvaluationProxy proxy = (EvaluationProxy) e.getValue();
					Object result = StackContext.evaluateStatic(proxy.getStoEx(), proxy.getStackFrame(),mode);
					frame.addValue(e.getKey(),result);
				}
			}
		}
	}

	/**
	 * @return The current stack
	 */
	public SimulatedStack<Object> getStack(){
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
	 * @param mode The new evaluation method to set
	 */
	public void setEvaluationMode(VariableMode mode) {
		this.mode = mode;
	}

}
