package de.uka.ipd.sdq.workflow.pcm.runconfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Experiment run descriptor for sensitivity analyses. 
 * This descriptor contains the values chosen for each variable of the sensitivity analysis. 
 * It provides an experiment name based on this information.  
 *
 */
public class ExperimentRunDescriptor {

	private String name;
	private ArrayList<ParameterDescriptor> parameterList;

	public ExperimentRunDescriptor(String name, List<SensitivityAnalysisConfiguration> sconfList) {
		this.name = name;
		this.parameterList = new ArrayList<ParameterDescriptor>();
		
		for(SensitivityAnalysisConfiguration sac : sconfList){
			ParameterDescriptor pd = new ParameterDescriptor(sac.getShortName(), sac.getVariable(), sac.getCurrent(), sac.getRunNo());
			parameterList.add(pd);
		}
		
	}

	public String getRunIdentifier() {
		String result = null;
		for (ParameterDescriptor pd : parameterList){
			result = result == null ? "" : result + ".";
			result += pd.getRunNo();
		}
		return result;
	}

	public String getNameExperimentRun() {
		return name + " No. " + getRunIdentifier();
	}

	public List<ParameterDescriptor> getParameters() {
		return parameterList;
	}

}
