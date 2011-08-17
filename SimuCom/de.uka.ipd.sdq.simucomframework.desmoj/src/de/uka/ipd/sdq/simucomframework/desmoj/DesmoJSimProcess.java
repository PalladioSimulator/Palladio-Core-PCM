/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;
import desmoj.core.exception.SimAbortedException;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

/**
 * @author Snowball
 *
 */
public class DesmoJSimProcess extends SimProcess implements ISimProcessDelegate {

	de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myAbstractProcess = null;
	
	public DesmoJSimProcess(de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myProcess, Model owner, String name) {
		super(owner, name, false);
		this.myAbstractProcess = myProcess;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#hold(double)
	 */
	public void hold(double d) {
		this.hold(new SimTime(d));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#lifeCycle()
	 */
	@Override
	public void lifeCycle() {
		try {
			myAbstractProcess.lifeCycle();
		}
		catch(SimFinishedException ex){}
		catch(SimAbortedException ex){}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#scheduleAt(double)
	 */
	public void scheduleAt(double d) {
		this.activate(new SimTime(d));
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#setTimeoutFailure(java.lang.String)
	 */
	public void setTimeoutFailure(String timeoutFailureName) {
		// Implementation for DesmoJ unclear:
		throw new UnsupportedOperationException();
	}
}
