package de.uka.ipd.sdq.simucomframework.variables;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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

public class StackContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2031992603442903211L;
	private VariableMode mode = VariableMode.EXCEPTION_ON_NOT_FOUND;
	
	private static Logger logger = 
		Logger.getLogger(StackContext.class.getName());
        
    public StackContext() {}
        
	protected SimulatedStack<Object> stack = new SimulatedStack<Object>();

	public Object evaluate(String string, Class expectedType) {
		return StackContext.evaluateStatic(string,expectedType,stack.currentStackFrame(),mode);
	}

	public Object evaluate(String string) {
		return evaluateStatic(string,stack.currentStackFrame(),mode);
	}

	public Object evaluate(String stoex, SimulatedStackframe currentFrame) {
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

	public static Object evaluateStatic(String stoex) {
		return evaluateStatic(stoex, new SimulatedStackframe());
	}

	public static Object evaluateStatic(String stoex, SimulatedStackframe currentFrame) {
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

	public static Object evaluateStatic(String stoex, SimulatedStackframe currentFrame, VariableMode mode) {
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

	public static Object evaluateStatic(String string, Class expectedType) {
		return evaluateStatic(string,expectedType,new SimulatedStackframe(),VariableMode.EXCEPTION_ON_NOT_FOUND);
	}

	public static Object evaluateStatic(String string, Class expectedType, SimulatedStackframe frame) {
		return evaluateStatic(string,expectedType,frame,VariableMode.EXCEPTION_ON_NOT_FOUND);
	}
	
	public static Object evaluateStatic(String string, Class expectedType, SimulatedStackframe frame,VariableMode mode) {
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
	public void evaluateInner(SimulatedStackframe frame, String variablename) {
		SimulatedStackframe topmostFrame = this.getStack().currentStackFrame();
		for(Entry<String,Object> e : (Collection<Entry<String,Object>>)topmostFrame.getContents()) {
			if (e.getKey().startsWith(variablename)) {
				if (e.getValue() instanceof EvaluationProxy) {
					EvaluationProxy proxy = (EvaluationProxy) e.getValue();
					Object result = this.evaluateStatic(proxy.getStoEx(), proxy.getStackFrame(),mode);
					frame.addValue(e.getKey(),result);
				}
			}
		}
	}

	public SimulatedStack<Object> getStack(){
		return stack;
	}

	public VariableMode getEvaluationMode() {
		return mode;
	}

	public void setEvaluationMode(VariableMode mode) {
		this.mode = mode;
	}

}
