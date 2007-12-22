/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.ssj;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simprocs.SimProcess;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;

/**
 * @author Snowball
 *
 */
public class SSJSimProcess extends umontreal.iro.lecuyer.simprocs.SimProcess implements ISimProcessDelegate {

	de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myAbstractProcess = null;
	
	public SSJSimProcess(de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myProcess, String name) {
		// super(owner, name, false);
		super(((SSJExperiment)myProcess.getModel().getSimulationControl()).getSimulator());		
		this.myAbstractProcess = myProcess;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#activateAfter(de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate)
	 */
	public void activateAfter(de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess p) {
		// TODO: Check if this is correct...?
		this.scheduleNext();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#hold(double)
	 */
	@Override
	public void hold(double d) {
		this.delay(d);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#scheduleAt(double)
	 */
	@Override
	public void scheduleAt(double d) {
		// TODO: Check correctness...
		new Event(sim) {

			@Override
			public void actions() {
				SSJSimProcess.this.resume();
			}
			
		}.schedule(d);
	}

	@Override
	public void actions() {
		myAbstractProcess.lifeCycle();
	}

	@Override
	public boolean isTerminated() {
		return this.getState() == SimProcess.DEAD;
	}

	@Override
	public void passivate() {
		this.suspend();
	}

}
