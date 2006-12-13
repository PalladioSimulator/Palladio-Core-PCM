package de.uka.ipd.sdq.simucomframework;

import java.io.StringReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import antlr.RecognitionException;
import antlr.TokenStreamException;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.stoexvisitor.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simucomframework.stoexvisitor.SimulationExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import desmoj.core.simulator.SimProcess;

public abstract class Context {

	private ResouceRegistry registry = null;
	private SimulatedStack<Object> stack = new SimulatedStack<Object>();

	// AssemblyContextID -> ResourceContainer Object (Deployment Link)
	private HashMap<String, SimulatedResourceContainer> assemblyLinkHash = new HashMap<String, SimulatedResourceContainer>();

	private SimProcess myThread = null;
	private SimuComModel myModel = null;
	
	public Context(SimuComModel myModel) {
		this.registry = myModel.getResourceRegistry();
		this.myModel = myModel;
		initialiseResourceContainer();
		initialiseAssemblyContextLookup();
	}

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
	
	public static Object evaluate(String string, SimulatedStackframe currentFrame) {
		StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
				new StringReader(string));
		Expression formula = null;
		try {
			formula = new PCMStoExParser(lexer).expression();
			ExpressionInferTypeVisitor typeInferer = new SimulationExpressionInferTypeVisitor();
			typeInferer.doSwitch(formula);
			return new PCMStoExEvaluationVisitor(typeInferer,currentFrame)
					.doSwitch(formula);
		} catch (RecognitionException e) {
			e.printStackTrace();
			return 1;
		} catch (TokenStreamException e) {
			e.printStackTrace();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	public SimulatedResourceContainer findResource(String assemblyContextID) {
		SimulatedResourceContainer container = assemblyLinkHash
				.get(assemblyContextID);
		return container;
	}

	protected void linkAssemblyContextAndResourceContainer(
			String assemblyContextID, String resourceContainerID) {
		assert registry.containsResourceContainer(resourceContainerID);
		SimulatedResourceContainer container = registry
				.getResourceContainer(resourceContainerID);
		assemblyLinkHash.put(assemblyContextID, container);
	}

	protected SimulatedResourceContainer createResourceContainer(
			String containerID) {
		return registry.createResourceContainer(containerID);
	}

	public SimulatedStack<Object> getStack(){
		return stack;
	}
	
	protected abstract void initialiseAssemblyContextLookup();

	protected abstract void initialiseResourceContainer();

	public SimProcess getThread() {
		return myThread;
	}

	public SimuComModel getModel() {
		return myModel;
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

	public void setSimProcess(SimProcess process) {
		this.myThread = process;
	}
}
