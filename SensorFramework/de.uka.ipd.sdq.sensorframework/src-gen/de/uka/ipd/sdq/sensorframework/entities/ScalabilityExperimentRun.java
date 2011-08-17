package de.uka.ipd.sdq.sensorframework.entities;

import java.util.Map;

public interface ScalabilityExperimentRun extends ExperimentRun {
	public String[] getVarParameterNames();
	public void setVarParameterNames(String[] names);
	public void addConstParameter(String paramName, int paramValue);
	public Map<String, Integer> getConstParameters();

}
