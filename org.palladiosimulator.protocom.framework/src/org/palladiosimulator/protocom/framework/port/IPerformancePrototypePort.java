package org.palladiosimulator.protocom.framework.port;

import java.rmi.RemoteException;

import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

/**
 * Port interface for performance prototypes.
 * 
 * TODO: Add another parameter for context class. Currently type safety is
 * checked at runtime.
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 * 
 * @param <AComponent>
 */
public interface IPerformancePrototypePort<AComponent> extends IPort<AComponent> {
	/**
	 * Sets the component stack frame.
	 * 
	 * @param myComponentStackFrame
	 * @throws RemoteException
	 */
	public void setComponentFrame(SimulatedStackframe<Object> myComponentStackFrame) throws RemoteException;
}