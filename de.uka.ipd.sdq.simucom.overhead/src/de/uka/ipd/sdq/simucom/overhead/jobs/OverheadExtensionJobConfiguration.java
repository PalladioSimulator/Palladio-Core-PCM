package de.uka.ipd.sdq.simucom.overhead.jobs;

import de.uka.ipd.sdq.simucom.overhead.virtualizationoverhead.LoadDependentOverheadConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtensionJobConfiguration;

public class OverheadExtensionJobConfiguration extends AbstractExtensionJobConfiguration {
	
	private LoadDependentOverheadConfiguration loadDependentOverheadConfiguration = null;
	
	public OverheadExtensionJobConfiguration() {
		
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
	
	public LoadDependentOverheadConfiguration getLoadDependentOverheadConfiguration() {
		return loadDependentOverheadConfiguration;
	}

	public void setLoadDependentOverheadConfiguration(LoadDependentOverheadConfiguration loadDependentOverheadConfiguration) {
		this.loadDependentOverheadConfiguration = loadDependentOverheadConfiguration;
	}

}
