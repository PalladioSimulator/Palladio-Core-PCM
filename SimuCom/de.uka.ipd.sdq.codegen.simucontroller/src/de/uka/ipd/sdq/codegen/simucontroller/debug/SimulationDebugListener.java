package de.uka.ipd.sdq.codegen.simucontroller.debug;

import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;

/**
 * An implementation of the IDebugListener interface 
 * that... TODO
 * (this was the standard debug listener implementation which now 
 * has its own class)
 * 
 * TODO currently, the simucontroller.debug package is exported.
 * Maybe, to hide the implementation, provide a factory which 
 * resides in a public package 
 * 
 * @author hauck
 *
 */
public class SimulationDebugListener implements IDebugListener {
	
	private SimulationDebugTarget target = null;
	
	ILaunch launch = null;
	
	public SimulationDebugListener(ILaunch launch) {
		this.launch = launch;
	}

	public void simulationStartsInDock(DockModel dock) {
		target   = new SimulationDebugTarget(launch,dock);
		launch.addDebugTarget(target);
	}

	public void simulationStoppedInDock() {
		if (target != null) {
			// Wait for termination, needed as termination is reported via async events by the dock
			while (!target.isTerminated()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
			launch.removeDebugTarget(target);
			target.dispose();
		}
	}

}
