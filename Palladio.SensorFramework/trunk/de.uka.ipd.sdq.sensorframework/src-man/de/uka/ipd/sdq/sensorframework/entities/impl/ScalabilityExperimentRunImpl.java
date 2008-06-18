package de.uka.ipd.sdq.sensorframework.entities.impl;

import java.util.Map;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.ScalabilityExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class ScalabilityExperimentRunImpl extends ExperimentRunImpl implements ScalabilityExperimentRun {

	private String[] paramNames = null;
	
	private Map<String, Integer> constParameters = 
		new HashMap<String, Integer> ();
	
	public ScalabilityExperimentRunImpl(IDAOFactory myFactory) {
		super(myFactory);
		// TODO Auto-generated constructor stub
	}
	
	public void setVarParameterNames(String[] names) {
		paramNames = names;
	}
	
	public String[] getVarParameterNames() {
		return paramNames;
	}
	
	public Map<String, Integer> getConstParameters() {
		return constParameters;
	}
	
	public void addConstParameter(String parameterName, int parameterValue) {
		constParameters.put(parameterName, parameterValue);
	}
	
}
