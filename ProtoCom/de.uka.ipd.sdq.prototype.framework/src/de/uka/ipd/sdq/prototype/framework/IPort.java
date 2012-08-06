package de.uka.ipd.sdq.prototype.framework;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPort<AComponent> extends Remote, java.io.Serializable {

	public void setContext(Object myContext) throws RemoteException;

	public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame)  throws RemoteException;

	public AComponent getComponent() throws RemoteException;

}