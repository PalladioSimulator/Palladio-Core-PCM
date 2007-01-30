package runtime;

/**
 * Top interface for (Enterprise Java Beans based) ComponentPort
 */
public interface IComponent extends java.io.Serializable {
	/**
	 * overload with corresponding method that sets
	 * component = impl;
	 * @param impl one instance of the implementation class 
	 */
	public void setComponentInstance(ComponentInstance impl);
	/**
	 * called by an ServiceLocator or dependency injection
	 */
	public void setContextId(String id);
}