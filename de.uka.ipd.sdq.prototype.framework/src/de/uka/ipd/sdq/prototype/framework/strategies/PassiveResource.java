package de.uka.ipd.sdq.prototype.framework.strategies;

import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

/**
 * Simulates passive resource usage with semaphores.
 * 
 * @author zolynski
 */
public class PassiveResource {

	private static Logger logger = Logger.getLogger(PassiveResource.class.getName());

	private Semaphore semaphore;
	private String type;

	/**
	 * Initializes a resource pool with given capacity.
	 * 
	 * @param capacity
	 *            pool size
	 * @param type
	 *            name of resource type
	 */
	public PassiveResource(int capacity, String type) {
		this.semaphore = new Semaphore(capacity, true);
		this.type = type;
	}

	/**
	 * Acquires one resource of this type. Blocks if the current pool is exhausted.
	 */
	public void acquire() {
		if (logger.isDebugEnabled()) {
			logger.debug("Acquiring " + type);
		}

		this.semaphore.acquireUninterruptibly();

		if (logger.isDebugEnabled()) {
			logger.debug(type + " aquired");
		}
	}

	/**
	 * Releases one resource of ths type.
	 */
	public void release() {
		this.semaphore.release();

		if (logger.isDebugEnabled()) {
			logger.debug(type + " released");
		}
	}

	public String getType() {
		return type;
	}

}
