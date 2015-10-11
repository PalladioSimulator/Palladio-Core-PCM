package edu.kit.ipd.sdq.eventsim.workload;

import edu.kit.ipd.sdq.eventsim.measurement.ProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.workload.interpreter.usage.UsageInterpreterConfiguration;

public class WorkloadMeasurementConfiguration implements ProbeConfiguration {

	private UsageInterpreterConfiguration interpreterConfiguration;
	
	public WorkloadMeasurementConfiguration(UsageInterpreterConfiguration interpreterConfiguration) {
		this.interpreterConfiguration = interpreterConfiguration;
	}

	public UsageInterpreterConfiguration getInterpreterConfiguration() {
		return interpreterConfiguration;
	}
	
	public static WorkloadMeasurementConfiguration from(EventSimWorkloadModel model) {
		return new WorkloadMeasurementConfiguration(model.getUsageInterpreter().getConfiguration());
	}
	
}
