package runtime;

import java.util.*;
import org.jboss.logging.*;
import runtime.util.*;
//import static runtime.util.ComponentType.*; could also be used

/**
 * Holds the context of a runtime component.
 * Description and metadata of a {@link ComponentInstance} 
 * with better performance than reflection.
 * @author <a href="mailto:Reiner.Schaudel@t-online.de" />Reiner Schaudel
 */
public abstract class ComponentContext implements java.io.Serializable {
	/**
	 * print warnings and logging information
	 */
	protected Logger logger;
	/**
	 * equals the assemblyContextId
	 * unique for each component instance
	 * must be set before an runtime instance is used, then read-only
	 */
	protected String contextId;
	/**
	 * name of the Java package and class
	 */
	protected String packageName, className;

	/**
	 * type of the component
	 */
	protected ComponentType type;

	/**
	 * locate components
	 * must be set be subclasses
	 */
	protected IServiceLocator serviceLocator;

	/**
	 * all provided interfaces of the component
	 */
	protected Collection<Class> providedInterfaces = new LinkedList<Class>();

	/**
	 * each required interface of the Component 
	 * is mapped to one {@link ComponentPort}
	 */
	protected Hashtable<Class, IComponent> requiredInterfaces = new Hashtable<Class, IComponent>();

	/**
	 * @param pn package of this component
	 * @param cn classname in the java representation
	 * delegates to {@link #ComponentContext(String pn, String cn, ComponentType ct, String contextId)}
	 * sets third parameter to "BASIC"
	 */
	public ComponentContext(String pn, String cn, String contextId) {
		this(pn, cn, ComponentType.BASIC, contextId);
	}

	/**
	 * @param pn this component's package
	 * @param cn classname in the java representation
	 * @param ct type of the component
	 * @param contextId an assemblyCcontextId from the model instance
	 */
	public ComponentContext(String pn, String cn, ComponentType ct, String contextId) {
		packageName = pn;
		className = cn;
		type = ct;
		this.contextId = contextId;
		logger = Logger.getLogger(pn + "." + cn);
	}

	/**
	 * must be called by subclasses as last statement of the constructor
	 */
	protected void initDependencies(Collection<Class> reqInterfaces) { 
		for(Class clazz : reqInterfaces) {
			IComponent port = serviceLocator.getTargetComponentPort(contextId, clazz);
			if (port!=null) requiredInterfaces.put(clazz, port);
		}
	}

	/**
	 * use of a not connected Role will cause {@link java.lang.NullPointerException}
	 * @param clazz name of the required interface
	 * @return full initialized Component, if the required Role is connected to  
	 * another Component
	 */
	public IComponent getRequiredInterface(Class clazz) {
		assert(clazz.isInterface());
		if (requiredInterfaces.containsKey(clazz)) {
			return requiredInterfaces.get(clazz);
		}
		else {
			IComponent port = serviceLocator.getTargetComponentPort(contextId, clazz);
			if (port!=null) {
				logger.info("cannot find " + clazz.toString() + " for " + contextId);
				requiredInterfaces.put(clazz, port);
			}
			return port;
		}
	}

	/**
	 * delegates to {@link IServiceLocator#getInnerTargetComponentPort(String, Class)}
	 * @param clazz required interface of a Composite Component
	 * that is mapped to an inner Component
	 * @return full initialized Component, if the required Role is connected to another Component
	 */
	public IComponent getInnerComponent(Class clazz) {
		assert(clazz.isInterface());
		return serviceLocator.getInnerTargetComponentPort(contextId, clazz);
	}

	public String getContextId() {
		return contextId;
	}

	public Collection<Class> getProvidedInterfaces() {
		return providedInterfaces;
	}

	public Set getRequiredInterfaces() {
		return requiredInterfaces.keySet();
	}

	/**
	 *  this method is hard coded and should work faster than reflection
	 *  @return package where the class is stored
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 *  @return name of the class
	 */
	public String getName() {
		return className;
	}

	/**
	 *  this method is hard coded and should work faster than reflection
	 *  @return fully qualified name of the class
	 */
	public String getFullName() {
		return packageName + "." + className;
	}

	/**
	 * @return true if this is a composite component, 
	 * false if it is a basic component
	 */
	public boolean isComposite() {
		return (type.equals(ComponentType.COMPOSITE));
	}

	public String toString() {
		return packageName +  "." + className +  "$" + type;
	}
}