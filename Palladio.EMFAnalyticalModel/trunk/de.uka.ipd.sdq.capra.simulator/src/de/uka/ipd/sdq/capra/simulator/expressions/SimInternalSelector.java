package de.uka.ipd.sdq.capra.simulator.expressions;

/**
 * @author     jens.happe
 */
public class SimInternalSelector implements Cloneable{
	
	/**
	 * @uml.property  name="probability"
	 */
	private double probability;
	private SimCapraExpression expression;
	
	public SimInternalSelector(double probability, SimCapraExpression expression) {
		super();
		this.probability = probability;
		this.expression = expression;
	}

	/**
	 * @return
	 * @uml.property  name="probability"
	 */
	public double getProbability() {
		return probability;
	}

	public SimCapraExpression getCapraExpression() {
		return expression;
	}
	
	@Override
	public SimInternalSelector clone(){
		SimCapraExpression newExpression = expression.clone();
		return new SimInternalSelector(probability, newExpression);
	}

}
