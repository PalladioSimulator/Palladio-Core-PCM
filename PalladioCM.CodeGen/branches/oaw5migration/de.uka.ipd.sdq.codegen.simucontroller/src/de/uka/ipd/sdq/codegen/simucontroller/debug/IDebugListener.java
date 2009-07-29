package de.uka.ipd.sdq.codegen.simucontroller.debug;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

public interface IDebugListener {

	public void simulationStartsInDock(DockModel dock);
	public void simulationStoppedInDock();
	
}
