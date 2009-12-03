package de.uka.ipd.sdq.measurements.experimentseriescontroller;

import de.uka.ipd.sdq.measurements.MeasurementScript;


public abstract class AbstractSeriesController {

	//TODO
	// Currently, the data source (where to store results) is specified in the configuration and passed to the experiment
	// series controller. Put this field in a special ExperimentConfigurationClass. This class can maybe be enhanced 
	// by concrete Experiment Series Controllers.
	public abstract void startMeasurements(MeasurementScript script, int dataSourceId);
	
}
