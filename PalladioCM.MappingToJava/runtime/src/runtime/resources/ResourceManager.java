package runtime.resources;

import java.util.*;
import org.jboss.logging.*;

/**
 * Available resources are set in the generated code 
 * @author <a href="mailto:Reiner.Schaudel@t-online.de" />Reiner Schaudel
 */
public abstract class ResourceManager implements java.io.Serializable {
	/**
	 * hold semaphores representing resources from the environment
	 */
	protected static HashMap<String, Resource> resources;

	/**
	 * print warnings and logging information
	 */
	protected Logger logger;

	protected ResourceManager() {
		logger = Logger.getLogger(this.getClass());
		resources = new HashMap<String, Resource>();
		logger.info("started");
	}
	/**
	 * @param name represents the resource to acquire
	 * @param id identifies the resource
	 * @param count number of available resources
	 */
	public void addResource(String name, String id, int count) {
		resources.put(id, new Resource(name, id, count));
	}

	/**
	 * @param id identifies the resource
	 */
	public synchronized void acquire(String id) {
		Resource res = resources.get(id);
		if (res==null) {
			logger.info("register resource " + id);
			res = new Resource("", id);
			resources.put(id, res);
		}
		try {
			logger.info("acquire resource " + res.getId() + ":" + res.getName());
			res.acquire();
		} catch (InterruptedException e) {
			// empty
		}
	}
	
	/**
	 * @param id identifies the resource to release
	 */
	public synchronized void release(String id) {
		Resource res = resources.get(id);
		if (res==null) {
			logger.error("resource " + id + " has not been registered before");
			res = new Resource("", id);
			resources.put(id, res);
		}
		res.release();
	}
}