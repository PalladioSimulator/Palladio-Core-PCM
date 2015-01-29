package org.palladiosimulator.protocom.framework.java.ee.prototype;

/**
 * Classes implementing the ICallVisitor interface can be used for monitoring method calls.
 * @author Christian Klaussner
 */
public interface ICallVisitor {
	/**
	 * Called before a method call.
	 * @param callId the ID of the call
	 */
	void preCallVisit(String callId);
	
	/**
	 * Called after a method call.
	 * @param callId the ID of the call
	 */
	void postCallVisit(String callId);
}
