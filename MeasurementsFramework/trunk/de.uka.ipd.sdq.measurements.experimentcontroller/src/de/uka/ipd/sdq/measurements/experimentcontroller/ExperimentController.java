package de.uka.ipd.sdq.measurements.experimentcontroller;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;

public abstract class ExperimentController {
	
	//TODO
	// Currently, the data source (where to store results) is specified in the configuration and passed to the experiment
	// controller. Put this field in a special ExperimentConfigurationClass. This class can maybe be enhanced 
	// by concrete Experiment Controllers.
	public abstract void performExperiment(List<MachineDescription> machineDescriptions, TaskSet taskSet, int dataSourceId, IProgressMonitor monitor);

}
