package runtime;

import java.util.Hashtable;
import org.jboss.logging.*;

/**
 * This class is abstract, but it contains all 
 * methods to initialize an component in a local or distributed system.
 * (design pattern: template method)
 * The methods to localize components must be implemented in subclass.
 * 
 * ContextIds and Connectors from the model instance are set in subclasses.
 * 
 * @author <a href="mailto:Reiner.Schaudel@t-online.de" />Reiner Schaudel
 */
public abstract class AbstractServiceLocator implements IServiceLocator {
	protected final String SEPARATOR = "!";
	//protected final String CONNECTOR ="§";
	//protected final String INNERCOMPONENT ="+";
	/**
	 * can a port be used by one or more callers ?
	 * must be set by not-abstract subclass
	 */
	protected runtime.util.PortType portUsage;
	/**
	 * print warnings and logging information
	 */
	protected Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Connectors from an assembly
	 * context_id SEPARATOR fqn(requiredInterface) ->
	 * context_id SEPARATOR simpleName(providedInterface)
	 */
	protected Hashtable<String, String> connectors = new Hashtable<String, String>();

	/**
	 * ContextIds from an assembly
	 * context_id SEPARATOR provRole ->
	 * full qualified name of the component implementation class
	 */
	protected Hashtable<String, String> contextIds = new Hashtable<String, String>();

	/**
	 * Provided Delegation Connectors for Composite Components from a repository
	 * cc_id SEPARATOR fqn(provRole) ->
	 * inner_id SEPARATOR provRole
	 */
	protected Hashtable<String, String> provDelegationConnectors = new Hashtable<String, String>();
	/**
	 * Required Delegation Connectors for Composite Components from a repository
	 * innner_id SEPARATOR fqn(reqRole) ->
	 * cc_context_id SEPARATOR reqRole
	 */
	protected Hashtable<String, String> reqDelegationConnectors = new Hashtable<String, String>();

	/**
	 * cache for the subclasses of ComponentInstance
	 */
	protected Hashtable<String, IComponent> componentImplementations = new Hashtable<String, IComponent>();

	/**
	 * @param port full qualified classname of the port
	 * @return one instance of the ComponentPort
	 */
	protected abstract IComponent getInstanceOfPort(String port);

	/**
	 * @param name AssemblyContextId-provRole
	 * @param port one instance of a ComponentPort
	 */
	protected abstract void bind(String name, IComponent port);

	/**
	 * @param name AssemblyContextId-provRole
	 * @return one instance of a ComponentPort or null, if name is not bound
	 */
	protected abstract IComponent lookupPort(String name);

	protected abstract IComponentInstance createComponentInstance(String fqn);

	/**
	 * @param componentName AssemblyContextId
	 * @param impl implementation of a Component
	 */
	protected abstract void bind(String componentName, IComponentInstance impl);

	/**
	 * uses a cache for implementation classes
	 * @param contextId AssemblyContextId
	 * @return already initialized instance of a {@link ComponentInstance}
	 */
	public abstract IComponentInstance lookupInstance(String contextId);

	public AbstractServiceLocator() {
		//empty
	}

	/**
	 * implemented in generated Service Locator
	 */
	public abstract IComponent getTargetComponentPort(Class reqInterface);

	/** 
	 * builds a Component at runtime
	 * @see runtime.IServiceLocator#getTargetComponentPort(String, Class)
	 * @return an IComponent as EJB don´t support cast to a Class
	 */
	public synchronized IComponent getTargetComponentPort(String contextId, Class reqInterface) {
		logger.info(contextId + " asks for " + reqInterface);
		assert(portUsage!=null);
		assert(reqInterface.isInterface());
		// full qualified name of the Required interface
		String interfaceName = reqInterface.getCanonicalName();
		String targetId = followConnector(contextId + SEPARATOR + interfaceName);

		if (targetId==null) {
			// use of this ComponentPort will raise NullPointerException
			logger.warn("cannot load Required Role " + interfaceName + " for " + contextId);
			return null;
		}
		// change to (simple) name of Provided interface - can be other than Required interface
		interfaceName = targetId.substring(targetId.lastIndexOf(SEPARATOR) + 1);
		//logger.info("target:" + targetId);
		return getComponentPort(targetId, interfaceName);
	}

	/**
	 * instead of following all connectors, 
	 * only one reference inside a Composite Component is resolved at init phase. 
	 *
	 * @param contextId of a Composite Component
	 * @param provInterface of the Composite Component that is delegated to one inner Component
	 * @return one instance of the ComponentPort that implements provInterface
	 */
	public IComponent getInnerTargetComponentPort(String contextId, Class provInterface) {
		logger.info(contextId + " asks for inner Component providing " + provInterface);
		assert(portUsage!=null);
		assert(provInterface.isInterface());
		// full qualified name of the Provided interface
		String interfaceName = provInterface.getCanonicalName();
		String targetId = provDelegationConnectors.get(contextId + SEPARATOR + interfaceName);
		String temp = (targetId!=null) ? contextIds.get(targetId) : null;
		if (temp==null || targetId==null) {
			// use of this ComponentPort will raise NullPointerException
			logger.warn("cannot load inner Component providing " + provInterface + " for " + contextId + " - no target defined");
			return null;
		}
		/* change to full qualified name of Inner Provided interface - 
		 * can be other than Outer Provided interface
		 */
		interfaceName = targetId.substring(targetId.lastIndexOf(SEPARATOR) + 1);
		IComponent componentPort = getComponentPort(targetId, interfaceName);
		if (componentPort==null) {
			// will raise NullPointerException if used
			logger.warn("cannot load inner Component providing " + provInterface + " for " + contextId + " - cannot load class");
			return null;
		}
		//logger.info("inner component " + componentPort +  " successfully initialized");
		//assert(componentPort instanceof provInterface.getClass());
		return componentPort;
	}

	private IComponent getComponentPort(String targetId, String interfaceName) {
		IComponent componentPort;
		switch (portUsage) {
		case SINGLE:
			// each caller gets his own one ComponentPort
			componentPort = createComponentPort(targetId, interfaceName);
			logger.info("created : " + componentPort);
			break;
		case MULTI:
			// Binding is only useful, if a ComponentPort can be accessed 
			// and is shared by different components. 
			componentPort = lookupPort(targetId);
			if (componentPort==null) {
				componentPort = createComponentPort(targetId, interfaceName);
				bind(targetId, componentPort);
				logger.info("created : " + componentPort);
			}
			else {
				// nothing to do when port has been created before
				logger.info("found : " + componentPort);
			}
			break;
		default:
			logger.error("define usage of ports either SINGLE or MULTI");
			return null;
		}
		//logger.info(componentPort +  " successfully initialized");
		return componentPort;
	}

	/**
	 * @param targetId of the Provided Role
	 * @param interfaceName interface the ComponentPort implements
	 * @return initialized instance of one ComponentPort
	 */
	private IComponent createComponentPort(String targetId, String interfaceName) {
		IComponentInstance componentImpl = null;
		IComponent componentPort = null;
		componentPort = getInstanceOfPort(
				portFqn(targetId, interfaceName));
		componentImpl = getComponentImplementation(targetId);
		componentPort.setContextId(contextId(targetId));
		componentPort.setComponentInstance(componentImpl);
		return componentPort;
	}

	/**
	 * Looks up the component by name 
	 * or loads the class, if the component is not cached. 
	 * @param provRoleId provided Role that is requested
	 * @return instance of a ComponentInstance that implements the 
	 * component's methods and state 
	 */
	private IComponentInstance getComponentImplementation(String provRoleId) {
		String fqn = contextIds.get(provRoleId);
		// extract ContextId from "ContextId SEPARATOR providedRole"
		String componentContextId = contextId(provRoleId);
		IComponentInstance instance = lookupInstance(componentContextId);
		if (instance==null) {
			instance = createComponentInstance(fqn);
			/* keep reference for other Provided Roles of this component
			   and allow cyclic dependencies between components
			 */ 
			if (instance!=null) {
				bind(componentContextId, instance);
				instance.init(componentContextId);
				logger.info("component implementation " + instance + " created");
			}
			else return null;
		} else {
			logger.info("component implementation " + instance + " found");
			/* -> already bind
			    if not in a cycle, it was initialized before
			    if a cycle exist, it will be initialized by first caller
			*/
		}
		return instance;
	}

	/**
	 * follows an unlimited number of connectors 
	 * @param contextId of the calling Required Role
	 * @return contextId of the target or null, if the assembly has not defined 
	 * a SystemAssemblyConnector for this Required Role
	 */
	private String followConnector(String contextId) {
		//logger.info("follow a System Assembly Connector: " + contextId);
		String targetContextId = connectors.get(contextId);
		if ((targetContextId != null) && (contextIds.get(targetContextId)!=null)) {
			// second term == full qualified name of the target Component 
			return targetContextId;
		}
		else {
			/* follow a Required Delegation Connector
			 * -> get out of the Composite Component
			 */
			//logger.info("follow a Required Delegation Connector: " + contextId);
			targetContextId = reqDelegationConnectors.get(contextId);
			return (targetContextId != null) ? followConnector(targetContextId) : null;
		}
	}

	/**
	 * Extract package name from full qualified name and add port name to it.
	 * @param provRoleId provided Role that is requested
	 * @param provInterface fqn of the interface provided by this component 
	 * @return calculated full qualified name of the {@link ComponentPort}
	 */
	private String portFqn(String provRoleId, String provInterface) {
		//logger.info("look for component with id " + provRoleId);
		// full qualified name of the implementation class
		String implName = contextIds.get(provRoleId);
		String packageName = implName.substring(0, implName.lastIndexOf(".") + 1);
		String interfaceName = provInterface.substring(provInterface.lastIndexOf(".") + 1);
		return packageName + interfaceName + "Port";
	}

	/**
	 * Extract contextId of a {@link ComponentInstance}
	 * @param provRoleId 
	 * @return calculated contextId of a {@link ComponentInstance}
	 */
	private String contextId(String provRoleId) {
		return provRoleId.substring(0, provRoleId.indexOf(SEPARATOR));
	}

	/**
	 * loads a class via Class.forName() and gets an instance of this class
	 * @param name full qualified name of a class
	 * @return one instance of the class (POJO) or null, if the class cannot be loaded
	 */
	protected Object getInstanceOfClass(String name) {
		Object result = null;
		try {
			Class c = Class.forName(name);
			result = c.newInstance();
		} catch (ClassNotFoundException e) {
			/* could be asserted for some classes at compile time
			 * via static constructor in a generated class
			 */
			logger.error(e);
		} catch (InstantiationException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		}
		return result;
	}
}