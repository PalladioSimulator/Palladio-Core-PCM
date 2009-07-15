package de.uka.ipd.sdq.prototype.framework.strategies;

import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

public class PassiveResource {
	
	private static Logger logger = 
		Logger.getLogger(PassiveResource.class.getName());
	
	private Semaphore semaphore;
	private String type;
	
	public PassiveResource(int capacity, String type){
		this.semaphore = new Semaphore(capacity, true);
		this.type = type;
	}

	public void acquire(){
		logger.debug("Acquiring "+type);
		this.semaphore.acquireUninterruptibly();
		logger.debug(type+" aquired");
	}
	
	public void release(){
		this.semaphore.release();
		logger.debug(type+" released");
	}

	public String getType() {
		return type;
	}
	
}
