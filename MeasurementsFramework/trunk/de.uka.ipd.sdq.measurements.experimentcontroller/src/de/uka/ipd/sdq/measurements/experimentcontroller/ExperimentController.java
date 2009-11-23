package de.uka.ipd.sdq.measurements.experimentcontroller;

import java.util.List;

import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;

public abstract class ExperimentController {
	
	public abstract void performExperiment(List<MachineDescription> machineDescriptions, TaskSet taskSet);

}
