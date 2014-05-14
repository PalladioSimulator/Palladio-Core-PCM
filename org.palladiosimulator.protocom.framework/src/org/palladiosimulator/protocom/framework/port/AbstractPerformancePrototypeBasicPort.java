package org.palladiosimulator.protocom.framework.port;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.palladiosimulator.protocom.framework.IPerformancePrototypeComponent;
import org.palladiosimulator.protocom.framework.visitor.ICallVisitor;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Port class for basic components.
 * 
 * TODO: Add parameter for context.
 * TODO: Add abstract port class for CompositeComponent.
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 *
 * @param <AComponent>
 */
public class AbstractPerformancePrototypeBasicPort<AComponent extends IPerformancePrototypeComponent> extends AbstractBasicPort<AComponent> implements IPerformancePrototypePort<AComponent> {

	/**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -1063354534881855863L;
    protected List<ICallVisitor> visitors = new LinkedList<ICallVisitor>();

	protected AbstractPerformancePrototypeBasicPort() throws RemoteException {
		super();
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
