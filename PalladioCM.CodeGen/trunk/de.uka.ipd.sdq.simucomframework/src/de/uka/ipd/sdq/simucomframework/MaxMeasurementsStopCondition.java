package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Condition;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Model;

public class MaxMeasurementsStopCondition extends Condition {

	private long max_measurements = 1000;
	private SimuComModel myModel; 
	
	public MaxMeasurementsStopCondition(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);

		this.myModel = (SimuComModel)owner;
		max_measurements = myModel.getConfig().getMaxMeasurementsCount();
	}

	public boolean check() {
		return (max_measurements > 0) && (myModel.getMainMeasurementsCount()>=max_measurements);
	}
	
	@Override
	public boolean check(Entity arg0) {
		return false;
	}
	
}
