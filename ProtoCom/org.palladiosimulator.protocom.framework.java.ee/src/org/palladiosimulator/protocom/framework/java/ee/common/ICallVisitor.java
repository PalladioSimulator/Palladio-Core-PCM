package org.palladiosimulator.protocom.framework.java.ee.common;

public interface ICallVisitor {
	void preCallVisit(String callId);
	void postCallVisit(String callId);
}
