package runtime;

import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * used on application servers
 * @author <a href="mailto:Reiner.Schaudel@t-online.de" />Reiner Schaudel
 */
public abstract class ServerServiceLocator extends AbstractServiceLocator {
	/**
	 * constants for JBoss 
	 */
	private static final String JBOSS_CTX = "org.jnp.interfaces.NamingContextFactory";
	private static final String JNP = "jnp://";

	/**
	 * constants for TNameServ
	 */
	@SuppressWarnings("unused")
	private static final String SUN_CTX = "com.sun.jndi.cosnaming.CNCtxFactory";
	@SuppressWarnings("unused")
	private static final String IIOP = "iiop://";

	/**
	 * used on an application server
	 * cache for ComponentPort
	 */
	protected transient InitialContext initialContext;

	/**
	 * cache for ComponentInstance
	 */
	protected Hashtable<String, IComponentInstance> instances = new Hashtable<String, IComponentInstance>();

	/**
	 * substitute if {@link ServerServiceLocator#initialContext} 
	 * cannot be initialized or used.
	 */
	// TODO ersetze durch echte Ausnahmebehandlung
	// protected LocalServiceLocator lsl = new LocalServiceLocator(); 

	/**
	 * System-Properties are set to create an InitialContext. 
	 * The factory depends on used application server. 
	 * Provider.url is protocol://host:port. 
	 */
	public ServerServiceLocator() {
		super();
		System.setProperty("java.naming.factory.initial", JBOSS_CTX);
		System.setProperty("java.naming.provider.url", JNP + "localhost:1099");
		try {
			initialContext = new InitialContext();
		} catch(NamingException e) {
			logger.error("ServiceLocator could not initialize context:\n" + e.toString());
			throw new RuntimeException("ServiceLocator could not initialize context: " + e.toString());
		}
	}

	/**
	 * @param name full qualified name of a {@link ComponentPort} 
	 * @return EJB that implements the interface provided by this port
	 */
	protected IComponent getInstanceOfPort(String name) {
		if (name == null) {
			return null;
		}
		IComponent result = null;
		try {
			//logger.info("look up in " + initialContext);
			result = (IComponent) initialContext.lookup(name + "/remote");
			//if (result!=null) logger.info("componentPort "  + name + " found : " + result.toString());
			//else logger.warn("componentPort " + name + " not found");
		} catch (NamingException e) {
			logger.warn("componentPort " + name + " not found in JNDI: " + result + "\n" + e.toString());
			result = (IComponent) getInstanceOfClass(name); // throw Exception ?
		}
		return result;
	}

	/**
	 * @param name full qualified name of a {@link ComponentInstance} 
	 * @return EJB that implements the business interface provided by this component
	 */
	protected IComponentInstance createComponentInstance(String name) {
		if (name == null) {
			return null;
		}
		IComponentInstance result = null;
		try {
			result = (IComponentInstance) initialContext.lookup(name + "/remote");
		} catch (NamingException e) {
			logger.warn("componentImplementation " + name + " not found in JNDI: " + result + "\n" + e.toString());
			result = (IComponentInstance) getInstanceOfClass(name);
		}
		return result;
	}

	/**
	 * looks up in JNDI
	 * @param name the component's name
	 * @return ComponentInstance
	 */
	@Override
	public IComponentInstance lookupInstance(String name) {
		if (name == null) {
			return null;
		}
		IComponentInstance result = null;
		try {
			result = (IComponentInstance) initialContext.lookup(name);
		} catch (NamingException e) {
			logger.warn("componentImplementation " + name + " not found -> must be created");
		}
		return result;
		//return instances.get(name);
	}

	/**
	 * looks up in JNDI
	 * @param name the port's name
	 * @return ComponentPort
	 */
	@Override
	protected IComponent lookupPort(String name) {
		IComponent result = null;
		try {
			result = (IComponent) initialContext.lookup(name);
		} catch(NamingException e) {
			logger.warn("componentPort " + name + " not found -> must be created");
			// perhaps initialContext is not available
			// result = lsl.lookupPort(name);
		}
		return result;
	}

	@Override
	protected void bind(String name, IComponent port) {
		if (name!=null) {
			try {
				initialContext.rebind(name, port);
			} catch(NamingException e) {
				logger.error("could not register ComponentPort:\n" + e.toString());
			}
		}
	}

	@Override
	protected void bind(String name, IComponentInstance impl) {
		if (name!=null) {
			try {
				initialContext.rebind(name, impl);
			} catch(NamingException e) {
				logger.error("could not register ComponentImplementation:\n" + e.toString());
			}
			//instances.put(name, impl);
		}
	}
}