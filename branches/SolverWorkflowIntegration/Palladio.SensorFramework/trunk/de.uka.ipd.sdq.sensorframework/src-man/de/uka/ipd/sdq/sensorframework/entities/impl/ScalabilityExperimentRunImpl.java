package de.uka.ipd.sdq.sensorframework.entities.impl;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.sensorframework.entities.ScalabilityExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

@javax.persistence.Entity
public class ScalabilityExperimentRunImpl extends ExperimentRunImpl implements ScalabilityExperimentRun {

	private String[] paramNames = null;
	
	private Map<String, Integer> constParameters = 
		new HashMap<String, Integer> ();
	
	public ScalabilityExperimentRunImpl(IDAOFactory myFactory) {
		super(myFactory);
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
