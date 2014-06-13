package org.palladiosimulator.protocom.framework.visitor;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public class ConsoleOutputVisitor implements ICallVisitor {

	@Override
	public void preCallVisit(StackContext ctx, String callIdentifier) {
		System.out.println("Pre: " + callIdentifier);
	}

	@Override
	public void postCallVisit(StackContext ctx, String callIdentifier) {
		System.out.println("Post: " + callIdentifier);
	}

}
