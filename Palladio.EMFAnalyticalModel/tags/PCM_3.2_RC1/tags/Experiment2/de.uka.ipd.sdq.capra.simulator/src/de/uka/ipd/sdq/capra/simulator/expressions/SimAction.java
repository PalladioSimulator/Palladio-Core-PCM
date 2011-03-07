package de.uka.ipd.sdq.capra.simulator.expressions;

public interface SimAction extends SimCapraExpression{
	SimAction clone();
	
	void execute(SimCapraProcess capraProcess);
	
}
