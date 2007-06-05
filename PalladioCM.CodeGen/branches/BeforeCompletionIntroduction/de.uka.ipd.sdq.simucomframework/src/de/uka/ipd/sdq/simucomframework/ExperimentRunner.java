package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.SensorFactory;
// import de.uka.ipd.sdq.simucomframework.swingui.MainUI;
import desmoj.core.simulator.Condition;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.SimTime;

public class ExperimentRunner {
	public static void run(SimuComModel model, long simTime) {
		Experiment exp = model.getExperiment();
		// set experiment parameters
		exp.setShowProgressBar(false); // display a progress bar (or not)
		exp.stop(new SimTime(simTime)); // set end of simulation at 1500 time
										// units
		//exp.tracePeriod(new SimTime(0.0), new SimTime(simTime));
		// set the period of the trace
		//exp.debugPeriod(new SimTime(0.0), new SimTime(simTime)); // and debug
																	// output
		// ATTENTION!
		// Don't use too long periods. Otherwise a huge HTML page will
		// be created which crashes Netscape :-)

		// new MainUI(model).setVisible(true);
		SensorFactory.singleton().reset();
		
		SensorFrameworkObserver sensorObserver = new SensorFrameworkObserver(model);
		SensorFactory.singleton().addSensorObserver(sensorObserver);
		
		// exp.stop(new StopCondition(model,"StopCondtion","Response Time of ConcurScenario",true));
		
		exp.start();

		// generate the report (and other output files)
		exp.report();

		// stop all threads still alive and close all output files
		exp.finish();
		model.getResourceRegistry().deactivateAllActiveResources();
		//TODO: SensorFrameworkDataset.singleton().getMemoryDataset().storeExperiment(model.getExperimentDatastore());
	}
}
