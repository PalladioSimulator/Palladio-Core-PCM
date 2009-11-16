package de.uka.ipd.sdq.measurements.osscheduler.configurator;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;


public class OSSchedulerMeasurementsConfiguration extends
AbstractWorkflowBasedRunConfiguration {
	
	private String measurementScriptPath = null;

	public String getMeasurementScriptPath() {
		return measurementScriptPath;
	}

	public void setMeasurementScriptPath(String measurementScriptPath) {
		this.measurementScriptPath = measurementScriptPath;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaults() {
		// TODO Auto-generated method stub
		
	}

}
