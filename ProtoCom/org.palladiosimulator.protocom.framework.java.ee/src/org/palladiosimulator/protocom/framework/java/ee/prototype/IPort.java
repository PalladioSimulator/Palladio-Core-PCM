package org.palladiosimulator.protocom.framework.java.ee.prototype;

/**
 * The IPort interface is implemented by every port.
 * @param <T> the type of the port's component 
 * @author Christian Klaussner
 */
public interface IPort<T> {
	/**
	 * Sets the context of the port's component.
	 * @param context the context of the port's component
	 */
	void setContext(Object context);
}
