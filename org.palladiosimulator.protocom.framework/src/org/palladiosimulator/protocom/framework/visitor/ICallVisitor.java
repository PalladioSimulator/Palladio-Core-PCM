package org.palladiosimulator.protocom.framework.visitor;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Interceptor for service calls within PCM systems.
 * 
 * @author Thomas Zolynski
 */
public interface ICallVisitor {

	public void preCallVisit(StackContext ctx, String callIdentifier);
	public void postCallVisit(StackContext ctx, String callIdentifier);
	
}
