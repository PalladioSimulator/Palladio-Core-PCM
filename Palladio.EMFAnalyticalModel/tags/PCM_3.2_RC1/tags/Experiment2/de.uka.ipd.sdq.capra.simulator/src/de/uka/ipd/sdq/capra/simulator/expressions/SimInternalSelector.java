package de.uka.ipd.sdq.capra.simulator.expressions;

public class SimInternalSelector implements Cloneable{
	
	private double probability;
	private SimCapraExpression expression;
	
	public SimInternalSelector(double probability, SimCapraExpression expression) {
		super();
		this.probability = probability;
		this.expression = expression;
	}

	public double getProbability() {
		return probability;
	}

	public SimCapraExpression getCapraExpression() {
		return expression;
	}
	
	public SimInternalSelector clone(){
		SimCapraExpression newExpression = expression.clone();
		return new SimInternalSelector(probability, newExpression);
	}

}
