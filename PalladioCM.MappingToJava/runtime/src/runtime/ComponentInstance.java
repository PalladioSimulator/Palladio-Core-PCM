package runtime;

import org.jboss.logging.*;
import runtime.resources.*;

/**
 * holds the implementation of all methods provided by a component
 */
public abstract class ComponentInstance implements IComponentInstance {
	protected ComponentContext componentContext;
	protected ResourceManager resourceMan;
	/**
	 * print warnings and logging information
	 */
	protected Logger logger;
	protected boolean initCalledBefore = false;

	protected abstract void initRequiredInterfaces(String id);

	/**
	 * use {@link #init(String id) to set AssemblyContextId}
	 */
	public ComponentInstance() {
		logger = Logger.getLogger(this.getClass());
	}

	/**
	 * must be called by ServiceLocator
	 * @param id ContextId from the PCM Assembly
	 */
	public void init(String id) {
		if (initCalledBefore) {
			logger.warn("cycle in graph");
		} else {
			initRequiredInterfaces(id);
			initCalledBefore = true;
		}
	}

	public void destroy() {
		logger.info("destroyed");
	}

	/**
	 * @return description of the component
	 */
	public ComponentContext getContext() {
		return componentContext;
	}

	public String toString() {
		return (componentContext!=null) ? componentContext.toString() : "ComponentInstance";
	}
}