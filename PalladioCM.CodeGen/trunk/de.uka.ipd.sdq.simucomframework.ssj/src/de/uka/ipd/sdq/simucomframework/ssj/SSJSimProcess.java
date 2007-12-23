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
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#hold(double)
	 */
	public void hold(double d) {
		this.delay(d);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#scheduleAt(double)
	 */
	public void scheduleAt(double d) {
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

	public boolean isTerminated() {
		return this.getState() == SimProcess.DEAD;
	}

	public void passivate() {
		if (!isTerminated())
			this.suspend();
	}

}
