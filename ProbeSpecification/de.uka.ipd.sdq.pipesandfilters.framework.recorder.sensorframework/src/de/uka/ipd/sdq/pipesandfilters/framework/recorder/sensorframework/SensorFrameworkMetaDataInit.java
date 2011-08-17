package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework;

import java.util.Vector;

import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkConfig;

public class SensorFrameworkMetaDataInit extends MetaDataInit {

	private boolean isRemoteRun;

	public SensorFrameworkMetaDataInit(
			Vector<MeasurementMetric> measuredMetrics,
			SensorFrameworkConfig recorderConfiguration) {
		super(measuredMetrics, recorderConfiguration);
	}

	public boolean isRemoteRun() {
		return isRemoteRun;
	}

	// TODO This should be called from somewhere. Or move it to
	// SensorFrameworkRecorderConfig?
	public void setRemoteRun(boolean isRemoteRun) {
		this.isRemoteRun = isRemoteRun;
	}

}
