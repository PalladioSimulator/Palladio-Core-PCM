package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch;

import java.io.Serializable;
import java.util.Map;

import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.IRecorderConfiguration;

public class SensorFrameworkConfig implements IRecorderConfiguration, Serializable {

	private static final long serialVersionUID = 1L;
	
	private long datasourceID;
	
	public static final String DATASOURCE_ID = "datasourceID";
	
	public void setConfiguration(Map<String,Object> configuration) {
		this.datasourceID = (Integer)configuration.get(
				DATASOURCE_ID);	
	}
	
	public long getDatasourceID() {
		return this.datasourceID;
	}

}
