package de.uka.ipd.sdq.capra.simulator.actions;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;

public interface SimAction extends SimCapraExpression{
	SimAction clone();
	
	void execute(SimCapraProcess capraProcess);
	
}
