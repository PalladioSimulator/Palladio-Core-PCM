package de.uka.ipd.sdq.simucom.overhead;

import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComExtensionConfigurationBuilder;
import de.uka.ipd.sdq.simucom.overhead.jobs.OverheadExtensionJobConfiguration;
import de.uka.ipd.sdq.simucom.overhead.virtualizationoverhead.LoadDependentOverheadConfiguration;
import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtensionJobConfiguration;

public class OverheadSimuComExtensionConfigurationBuilder  extends SimuComExtensionConfigurationBuilder {
	
	
	private boolean useLoadOverheadParameterConfig = false;
	


	@Override
	public AbstractExtensionJobConfiguration buildConfiguration(Map<String, Object> attributes) {
		OverheadExtensionJobConfiguration overheadExtensionJobConfiguration = null;
		if (attributes.containsKey(Constants.USE_LOAD_OVERHEAD_PARAMETERS)){
			
			this.useLoadOverheadParameterConfig = (Boolean)attributes.get(Constants.USE_LOAD_OVERHEAD_PARAMETERS);
		}
		if (useLoadOverheadParameterConfig == true) {
			if (overheadExtensionJobConfiguration == null) {
				overheadExtensionJobConfiguration = new OverheadExtensionJobConfiguration();
				LoadDependentOverheadConfiguration loadDependentOverheadConfiguration = loadLoadDependentOverheadConfiguration(attributes);
				if (loadDependentOverheadConfiguration == null) {
					throw new RuntimeException("Failed to load LoadDependentOverheadConfiguration");
				}
				overheadExtensionJobConfiguration.setLoadDependentOverheadConfiguration(loadDependentOverheadConfiguration);
			}
		}
		
		return overheadExtensionJobConfiguration;
	}
	

	private LoadDependentOverheadConfiguration loadLoadDependentOverheadConfiguration(Map<String, Object> attributes) {
		LoadDependentOverheadConfiguration loadDependentOverheadConfiguration = new LoadDependentOverheadConfiguration();
		if (attributes.containsKey(Constants.LOAD_OVERHEAD_PARAMETERS)){
			String overheadParameters = (String)attributes.get(Constants.LOAD_OVERHEAD_PARAMETERS);
			String[] separated = overheadParameters.split(" ");
			for (int i = 0; i < separated.length; i++) {
				String[] item = separated[i].split(":");
				if (item.length != 2) {
					throw new RuntimeException("Overhead String has wrong format!");
				}
				loadDependentOverheadConfiguration.addOverhead(item[0], Double.parseDouble(item[1]));
			}
			
			return loadDependentOverheadConfiguration;	
		}
		return null;
	}


	@Override
	public SimuComConfigExtension deriveSimuComConfigExtension(
			Map<String, Object> configuration) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
