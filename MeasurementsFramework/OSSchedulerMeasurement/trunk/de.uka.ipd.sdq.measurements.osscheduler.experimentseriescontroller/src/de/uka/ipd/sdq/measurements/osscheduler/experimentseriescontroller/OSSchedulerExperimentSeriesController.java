package de.uka.ipd.sdq.measurements.osscheduler.experimentseriescontroller;

import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.experimentseriescontroller.AbstractSeriesController;
import de.uka.ipd.sdq.measurements.systemcontroller.SystemController;

public class OSSchedulerExperimentSeriesController extends AbstractSeriesController {

	@Override
	public void startMeasurements(MeasurementScript script) {
		System.out.println("MEASURING...");
		SystemController systemController = de.uka.ipd.sdq.measurements.experimentseriescontroller.Activator.getDefault().getSystemController();
		systemController.prepareScript(script);
	}

}
