package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class SimulatedLinkingResource extends AbstractScheduledResource {
	
	private String throughput;
	private String latencySpec;
	
	public SimulatedLinkingResource(SimuComModel myModel, String typeID, String description, String d, String latencySpec)
	{
		super (myModel, typeID, description, SchedulingStrategy.FCFS);
		this.latencySpec = latencySpec;
		this.throughput = d;
	}

	@Override
	protected double calculateDemand(double demand) {
		return NumberConverter.toDouble(StackContext.evaluateStatic(latencySpec)) + 
				demand/NumberConverter.toDouble(StackContext.evaluateStatic(throughput));
	}

}
