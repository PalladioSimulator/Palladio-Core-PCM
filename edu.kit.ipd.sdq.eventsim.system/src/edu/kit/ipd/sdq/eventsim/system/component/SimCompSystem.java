package edu.kit.ipd.sdq.eventsim.system.component;

/**
 * @author cfoehrdes
 *
 * This class is just a singleton as intermediate step while refactoring to declarative services.
 */
public class SimCompSystem {
	
	private static SimCompSystem instance = new SimCompSystem();
	
	private SimCompSystem() {
	}
	
	public static SimCompSystem getInstance() {
        return instance;
    }
	
	

}
