package runtime;

/**
 * Top interface for (Enterprise Java Beans based) ComponentPort
 */
public interface IComponent {
	/**
	 * overload with corresponding method that sets
	 * component = impl;
	 * @param impl one instance of the implementation class 
	 */
	public void setComponentInstance(IComponentInstance impl);
	/**
	 * called by an ServiceLocator or dependency injection
	 */
	public void setContextId(String id);
}