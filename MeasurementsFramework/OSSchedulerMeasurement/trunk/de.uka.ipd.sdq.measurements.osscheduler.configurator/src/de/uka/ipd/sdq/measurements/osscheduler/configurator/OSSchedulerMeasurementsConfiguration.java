package de.uka.ipd.sdq.measurements.osscheduler.configurator;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;


public class OSSchedulerMeasurementsConfiguration extends
AbstractWorkflowBasedRunConfiguration {
	
	private String measurementScriptPath = null;
	private String machineIP = null;
	private int machinePort = 0;
	private boolean useMeasurementsScript = false;
	private int measurementsResultsDataSourceId = -1;
	
	public int getMeasurementsResultsDataSourceId() {
		return measurementsResultsDataSourceId;
	}

	public void setMeasurementsResultsDataSourceId(int measurementsResultsDataSourceId) {
		this.measurementsResultsDataSourceId = measurementsResultsDataSourceId;
	}

	public boolean isUseMeasurementsScript() {
		return useMeasurementsScript;
	}

	public void setUseMeasurementsScript(boolean useMeasurementsScript) {
		this.useMeasurementsScript = useMeasurementsScript;
	}

	public String getMachineIP() {
		return machineIP;
	}

	public void setMachineIP(String machineIP) {
		this.machineIP = machineIP;
	}

	public int getMachinePort() {
		return machinePort;
	}

	public void setMachinePort(int machinePort) {
		this.machinePort = machinePort;
	}

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
