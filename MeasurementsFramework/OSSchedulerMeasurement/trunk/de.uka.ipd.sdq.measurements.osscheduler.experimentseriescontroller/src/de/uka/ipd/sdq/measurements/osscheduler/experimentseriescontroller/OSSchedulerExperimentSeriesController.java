package de.uka.ipd.sdq.measurements.osscheduler.experimentseriescontroller;

import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.experimentseriescontroller.AbstractSeriesController;
import de.uka.ipd.sdq.measurements.systemadapter.SystemAdapter;

public class OSSchedulerExperimentSeriesController extends AbstractSeriesController {

	@Override
	public void startMeasurements(MeasurementScript script) {
		System.out.println("MEASURING...");
		SystemAdapter systemAdapter = de.uka.ipd.sdq.measurements.experimentseriescontroller.ExperimentSeriesControllerPlugin.getDefault().getSystemController();
		systemAdapter.prepareScript(script);
	}

}
