package org.palladiosimulator.protocom.framework.port;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.palladiosimulator.protocom.framework.IComponent;
import org.palladiosimulator.protocom.framework.visitor.ICallVisitor;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Port class for basic components.
 * 
 * TODO: Add parameter for context.
 * TODO: Add abstract port class for CompositeComponent.
 * 
 * @author zolynski
 *
 * @param <AComponent>
 */
public class AbstractBasicPort<AComponent extends IComponent> extends java.rmi.server.UnicastRemoteObject implements IPort<AComponent>, java.io.Serializable {

	private static final long serialVersionUID = -7620141651057731901L;

	protected List<ICallVisitor> visitors = new LinkedList<ICallVisitor>();
	
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

	@Override
	public void setComponentFrame(de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> myComponentStackFrame)
			throws java.rmi.RemoteException {
		myComponent.setComponentFrame(myComponentStackFrame);
	}
	
	public void addVisitor(ICallVisitor visitor) {
		visitors.add(visitor);
	}
	
	protected void preCallVisitor(StackContext ctx, String callIdentifier) {
		for (ICallVisitor visitor : visitors) {
			visitor.preCallVisit(ctx, callIdentifier);
		}
	}
	
	protected void postCallVisitor(StackContext ctx, String callIdentifier) {
		for (ICallVisitor visitor : visitors) {
			visitor.postCallVisit(ctx, callIdentifier);
		}
	}

}
