package de.uka.ipd.sdq.codegen.simucontroller.actions;

import de.uka.ipd.sdq.simucomframework.IStatusObserver;

public interface ISimuComControl {

	public void startSimulation(IStatusObserver statusObserver);
	public void stopSimulation();
}
