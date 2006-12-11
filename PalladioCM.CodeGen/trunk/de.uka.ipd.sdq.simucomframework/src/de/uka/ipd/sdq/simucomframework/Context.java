package de.uka.ipd.sdq.simucomframework;

import java.io.StringReader;
import java.util.HashMap;

import antlr.RecognitionException;
import antlr.TokenStreamException;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import desmoj.core.simulator.SimProcess;

public abstract class Context {

	private ResouceRegistry registry = null;
	private SimulatedStack<Object> stack = new SimulatedStack<Object>();

	// AssemblyContextID -> ResourceContainer Object (Deployment Link)
	private HashMap<String, SimulatedResourceContainer> assemblyLinkHash = new HashMap<String, SimulatedResourceContainer>();

	private SimProcess myThread = null;
	private SimuComModel myModel = null;
	
	public Context(SimuComModel myModel, SimProcess myThread) {
		this.registry = myModel.getResourceRegistry();
		this.myThread = myThread;
		this.myModel = myModel;
		initialiseResourceContainer();
		initialiseAssemblyContextLookup();
	}

	public Object evaluate(String string) {
		return evaluate(string,stack.currentStackFrame());
	}
	
	public static Object evaluate(String string, SimulatedStackframe currentFrame) {
		StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
				new StringReader(string));
		Expression formula = null;
		int result = 1;
		try {
			formula = new PCMStoExParser(lexer).expression();
			return new PCMStoExEvaluationVisitor(currentFrame)
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
}
