package org.palladiosimulator.protocom.framework.java.se.port;

import java.rmi.RemoteException;

import org.palladiosimulator.protocom.framework.java.se.IComponent;

/**
 * Port class for basic components.
 * 
 * TODO: Add parameter for context. TODO: Add abstract port class for CompositeComponent.
 * 
 * @author Sebastian Lehrig
 *
 * @param <AComponent>
 */
public class AbstractBasicPort<AComponent extends IComponent> extends java.rmi.server.UnicastRemoteObject implements
        IPort<AComponent>, java.io.Serializable {

    private static final long serialVersionUID = -7620141651057731901L;

    protected AComponent myComponent = null;

    protected AbstractBasicPort() throws RemoteException {
        super();
    }

    @Override
    public AComponent getComponent() throws java.rmi.RemoteException {
        return myComponent;
    }

    @Override
    public void setContext(Object myContext) throws java.rmi.RemoteException {
        myComponent.setContext(myContext);
    }
}
