package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class MaxMeasurementsStopCondition extends Condition {

	private long max_measurements = 1000;
	private SimuComModel myModel; 
	private MeasurementStopConditionStatus myStopConditionStatus = new MeasurementStopConditionStatus();
	
	public MaxMeasurementsStopCondition(SimuComModel owner) {
		super(owner, "Maximum Measurements Count Stop Condition");

		this.myModel = (SimuComModel)owner;
		max_measurements = myModel.getConfig().getMaxMeasurementsCount();
	}

	@Override
	public boolean check() {
		this.myStopConditionStatus.setStatusValue(String.valueOf(myModel.getMainMeasurementsCount()));
		return (max_measurements > 0) && (myModel.getMainMeasurementsCount()>=max_measurements);
	}

	@Override
	public IConditionStatus getStatus() {
		return myStopConditionStatus ;
	}
	
	
}

class MeasurementStopConditionStatus implements IConditionStatus {

	private String statusValue;

	@Override
	public String getStatusLabel() {
		return "Measurements: ";
	}

	@Override
	public String getStatusValue() {
		return statusValue;
	}
	
	public void setStatusValue(String status){
		this.statusValue = status;
	}
	
}