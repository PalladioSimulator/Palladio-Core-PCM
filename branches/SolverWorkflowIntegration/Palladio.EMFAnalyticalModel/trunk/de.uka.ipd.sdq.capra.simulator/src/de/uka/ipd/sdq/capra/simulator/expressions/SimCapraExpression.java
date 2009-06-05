package de.uka.ipd.sdq.capra.simulator.expressions;

import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;

public interface SimCapraExpression extends Cloneable {
		
	SimCapraExpression clone();

	SimCapraExpression getNext(SimCapraProcess process);

	boolean isAction();

	void reset();

	void setVarUsages(String name, SimCapraExpression behaviour);

	boolean hasNext();

	void addFinishingListener(IFinishingListener listener);

}
