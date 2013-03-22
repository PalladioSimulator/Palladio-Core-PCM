package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;

/**
 * 
 * Stop condition for the maximum amount of measurements on SimuCom's main response time sensor.
 * @author snowball
 *
 */
public class MaxMeasurementsStopCondition implements SimCondition {

	final private long max_measurements;
	final private SimuComModel myModel; 
	
	public MaxMeasurementsStopCondition(SimuComModel owner) {
	    super();
	    
		this.myModel = owner;
		max_measurements = myModel.getConfiguration().getMaxMeasurementsCount();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition#check()
	 */
	@Override
	public boolean check() {
		return myModel.getMainMeasurementsCount() >= max_measurements;
	}
}
