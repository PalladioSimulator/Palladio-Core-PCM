package de.uka.ipd.sdq.simucomframework.variables;

import java.io.Serializable;

import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

/**
 * Evaluation Proxies are used to store the defining equation instead of the 
 * actual value in a stackframe entry. This is usefull in cases where the
 * equation is stochastic, e.g., contains a random variable like a 
 * probability function literal. For example, the evaluation proxy 
 * 10*IntPMF[(1;0.2)(2;0.8) evaluates to 10 in 20% of all cases and to 20 in
 * 80% of all cases.
 * Evaluation proxies are used to store INNER characterisations which are
 * evaluated on every access instead of a single time during their initialisation
 * @author Steffen Becker
 *
 */
/**
 * @author Steffen Becker
 *
 */
public class EvaluationProxy implements Serializable {
	
	/**
	 *  The stoex proxied by this object
	 */
	private String stoex;
	
	/**
	 * The Stackframe under which the stoex is evaluated 
	 */
	private SimulatedStackframe<Object> contextFrame;

	public EvaluationProxy (String stoex, SimulatedStackframe<Object> contextFrame)
	{
		this.stoex = stoex;
		this.contextFrame = contextFrame;
	}

	public SimulatedStackframe<Object> getStackFrame() {
		return contextFrame;
	}

	public String getStoEx() {
		return stoex;
	}

	@Override
	public String toString() {
		return "EvaluationProxy<"+this.getStoEx()+">";
	}
	
	
}
