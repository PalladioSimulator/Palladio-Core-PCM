package org.palladiosimulator.protocom.framework.java.ee.prototype;

public interface ICallVisitor {
	void preCallVisit(String callId);
	void postCallVisit(String callId);
}
