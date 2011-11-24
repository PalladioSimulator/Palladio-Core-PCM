package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;

public class MaxMeasurementsStopCondition implements SimCondition {

	private long max_measurements = 1000;
	private SimuComModel myModel; 
	
	public MaxMeasurementsStopCondition(SimuComModel owner) {
		this.myModel = owner;
		max_measurements = myModel.getConfiguration().getMaxMeasurementsCount();
	}

	@Override
	public boolean check() {
		return (max_measurements > 0) && (myModel.getMainMeasurementsCount()>=max_measurements);
	}
}
