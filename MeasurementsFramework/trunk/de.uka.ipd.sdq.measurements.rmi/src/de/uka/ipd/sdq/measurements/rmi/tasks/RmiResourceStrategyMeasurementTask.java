package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;

public class RmiResourceStrategyMeasurementTask extends RmiMachineTask implements Serializable {

	private static final long serialVersionUID = -5098686142442634106L;
	
	private RmiDemand demand = null;
	private long measurementTime = 0L;
	
	public RmiResourceStrategyMeasurementTask(int id) {
		super(id);
	}
	
	public void setDemand(RmiDemand demand) {
		this.demand = demand;
	}
	
	public RmiDemand getDemand() {
		return demand;
	}
		
	public void setMeasurementTime(long measurementTime) {
		this.measurementTime = measurementTime;
	}
	
	public long getMeasurementTime() {
		return measurementTime;
	}
	
}
