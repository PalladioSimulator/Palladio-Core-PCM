package de.uka.ipd.sdq.simucomframework.variables;

import java.util.Collection;
import java.util.Map.Entry;

import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCacheEntry;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;

public class StackContext {

	protected SimulatedStack<Object> stack = new SimulatedStack<Object>();

	public Object evaluate(String string, Class expectedType) {
		return evaluate(string,expectedType,stack.currentStackFrame());
	}

	public static Object evaluate(String string, Class expectedType, SimulatedStackframe frame) {
		Object result = evaluate(string,frame);
		if (expectedType.isInstance(result))
			return result;
		if (expectedType == Double.class && result.getClass() == Integer.class)
			return ((Integer)result).doubleValue();
		throw new UnsupportedOperationException("Evaluation result is of type "+result.getClass().getCanonicalName()+
				" but expected was "+expectedType.getCanonicalName()+ " and no conversion was available...");
	}

	public Object evaluate(String string) {
		return evaluate(string,stack.currentStackFrame());
	}

	public static Object evaluate(String stoex, SimulatedStackframe currentFrame) {
		StoExCacheEntry cacheEntry = StoExCache.singleton().getEntry(stoex);
		return new PCMStoExEvaluationVisitor(stoex,currentFrame)
					.doSwitch(cacheEntry.getParsedExpression());
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
					Object result = this.evaluate(proxy.getStoEx(), proxy.getStackFrame());
					frame.addValue(e.getKey(),result);
				}
			}
		}
	}

	public SimulatedStack<Object> getStack(){
		return stack;
	}
	
}
