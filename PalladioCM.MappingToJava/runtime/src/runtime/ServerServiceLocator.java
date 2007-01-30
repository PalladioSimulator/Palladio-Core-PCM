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
	protected Hashtable<String, ComponentInstance> instances = new Hashtable<String, ComponentInstance>();

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
			logger.warn("componentPort " + name + " not found : " + result + "\n" + e.toString());
			//result = lsl.getInstanceOfPort(name); // throw Exception ?
		}
		return result;
	}

	/**
	 * looks up in a cache
	 * @param name the component's name
	 * @return ComponentInstance
	 */
	@Override
	public ComponentInstance lookupInstance(String name) {
		return instances.get(name);
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
				logger.error("could not register Component:\n" + e.toString());
				// lsl.bind(name, port);
			}
		}
	}

	@Override
	protected void bind(String name, ComponentInstance impl) {
		if (name!=null) {
			instances.put(name, impl);
		}
	}
}