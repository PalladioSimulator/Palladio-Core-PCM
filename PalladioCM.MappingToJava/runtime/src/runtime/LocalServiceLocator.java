package runtime;

import java.util.*;

/**
 * used on a standalone JVM
 * @author <a href="mailto:Reiner.Schaudel@t-online.de" />Reiner Schaudel
 */
public abstract class LocalServiceLocator extends AbstractServiceLocator {

	/**
	 * cache for ComponentPort 
	 */
	protected Hashtable<String, IComponent> ports = new Hashtable<String, IComponent>();

	/**
	 * cache for ComponentInstance
	 */
	protected Hashtable<String, IComponentInstance> instances = new Hashtable<String, IComponentInstance>();

	/**
	 * standard constructor is empty
	 */
	public LocalServiceLocator() {
		super();
	}

	/**
	 * gets an instance via {@link AbstractServiceLocator#getInstanceOfClass(String)} 
	 * @param port full qualified name of a {@link ComponentPort}
	 * @return one instance of the {@link ComponentPort} (POJO)
	 */
	protected IComponent getInstanceOfPort(String port) {
		return (IComponent) getInstanceOfClass(port);
	}
	
	/**
	 * uses a cache for ComponentPort
	 * @return already initialized instance of a {@link ComponentPort}
	 */
	protected IComponent lookupPort(String name) {
		return ports.get(name);
	}

	@Override
	protected IComponentInstance createComponentInstance(String name) {
		return (IComponentInstance) getInstanceOfClass(name);
	}

	@Override
	public IComponentInstance lookupInstance(String name) {
		return instances.get(name);
	}

	/**
	 * @param name the component's name
	 * @param component already initialized instance of a {@link ComponentPort}
	 */
	@Override
	protected void bind(String name, IComponent component) {
		if (component!=null)
			ports.put(name, component);
	}

	/**
	 * @param name the component's name
	 * @param component already initialized instance of a {@link ComponentInstance}
	 * @see runtime.AbstractServiceLocator#bind(String, ComponentInstance)
	 */
	@Override
	protected void bind(String name, IComponentInstance component) {
		if (component!=null)
			instances.put(name, component);
	}
}