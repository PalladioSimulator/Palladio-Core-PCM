package org.palladiosimulator.protocom.framework.java.se.port;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Port interface.
 * 
 * TODO: Add another parameter for context class. Currently type safety is checked at runtime.
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 * 
 * @param <AComponent>
 */
public interface IPort<AComponent> extends Remote, java.io.Serializable {

    /**
     * Inject the context into this port (and therefore into the component).
     * 
     * @param myContext
     *            context object.
     * @throws RemoteException
     */
    public void setContext(Object myContext) throws RemoteException;

    /**
     * Returns the component of this port.
     * 
     * @return
     * @throws RemoteException
     */
    public AComponent getComponent() throws RemoteException;

}