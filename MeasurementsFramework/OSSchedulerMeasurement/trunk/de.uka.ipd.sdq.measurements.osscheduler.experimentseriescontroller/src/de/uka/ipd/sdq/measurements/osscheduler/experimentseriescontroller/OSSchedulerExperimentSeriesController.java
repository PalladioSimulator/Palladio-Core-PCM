package de.uka.ipd.sdq.measurements.osscheduler.experimentseriescontroller;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.MeasurementsFactory;
import de.uka.ipd.sdq.measurements.experimentseriescontroller.AbstractSeriesController;
import de.uka.ipd.sdq.measurements.osscheduler.experimentcontroller.OSSchedulerExperimentController;
import de.uka.ipd.sdq.measurements.osscheduler.experimentcontroller.OSSchedulerExperimentControllerPlugin;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;

public class OSSchedulerExperimentSeriesController extends AbstractSeriesController {

	@Override
	public void startMeasurements(MeasurementScript script, int dataSourceId, IProgressMonitor monitor) {
		OSSchedulerExperimentController osSchedulerExperimentController = OSSchedulerExperimentControllerPlugin.getDefault().getOsSchedulerExperimentController();
		for (TaskSet taskSet : script.getTaskSets()) {
			osSchedulerExperimentController.performExperiment(script.getMachineDescriptions(), taskSet, dataSourceId, monitor);
		}
		//SystemAdapter systemAdapter = de.uka.ipd.sdq.measurements.experimentseriescontroller.ExperimentSeriesControllerPlugin.getDefault().getSystemController();
		//systemAdapter.prepareScript(script);
	}
	
	public void startMeasurements(String machineIP, int machinePort, int dataSourceId, IProgressMonitor monitor) {
		MeasurementScript script = MeasurementsFactory.eINSTANCE.createMeasurementScript();
		MachineDescription machineDescription = MeasurementsFactory.eINSTANCE.createMachineDescription();
		machineDescription.setIp(machineIP);
		machineDescription.setName("myMachine");
		machineDescription.setPort(machinePort);
		script.getMachineDescriptions().add(machineDescription);
		startMeasurements(script, dataSourceId, monitor);
	}

}
