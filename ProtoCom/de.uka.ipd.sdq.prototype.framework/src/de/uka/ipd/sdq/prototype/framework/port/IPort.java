package de.uka.ipd.sdq.prototype.framework.port;

import java.rmi.Remote;
import java.rmi.RemoteException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

/**
 * Port interface.
 * 
 * TODO: Add another parameter for context class. Currently type safety is
 * checked at runtime.
 * 
 * @author zolynski
 * 
 * @param <AComponent>
 */
public interface IPort<AComponent> extends Remote, java.io.Serializable {

	/**
	 * Inject the context into this port (and therefore into the component).
	 * 
	 * @param myContext		context object.
	 * @throws RemoteException
	 */
	public void setContext(Object myContext) throws RemoteException;

	/**
	 * Sets the component stack frame.
	 * 
	 * @param myComponentStackFrame
	 * @throws RemoteException
	 */
	public void setComponentFrame(SimulatedStackframe<Object> myComponentStackFrame) throws RemoteException;

	/**
	 * Returns the component of this port.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public AComponent getComponent() throws RemoteException;

}