package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class SimulatedLinkingResource extends AbstractScheduledResource {
	
	private double throughput;
	private String latencySpec;
	
	public SimulatedLinkingResource(SimuComModel myModel, String typeID, double throughput, String latencySpec)
	{
		super (myModel, typeID, SchedulingStrategy.FCFS);
		this.latencySpec = latencySpec;
		this.throughput = throughput;
	}

	@Override
	protected double calculateDemand(double demand) {
		return NumberConverter.toDouble(StackContext.simpleEvaluate(latencySpec)) + demand/throughput;
	}

}
